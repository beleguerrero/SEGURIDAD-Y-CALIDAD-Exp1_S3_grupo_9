package cl.duoc.level_start.jwt;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component 
public class JwtUtil {
    
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    @Value ("${jwt.issuer}")
    private String issuer;

    @Value("${jwt.audience}")
    private String audience;

    private SecretKey getSigningKeyB64() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private SecretKey getSigningKey() {
        byte[] keyBytes = secret.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(Long userId, String username, String role) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + expiration);
        return Jwts
        .builder()
        .subject(username)
        .claim("userId", userId)
        .claim("role", role)
        .issuer(issuer)
        .audience().add(audience).and()
        .issuedAt(now)
        .expiration(expirationDate)
        .signWith(getSigningKeyB64(), Jwts.SIG.HS256)
        .compact();
    }

    private Claims extractClaims(String token) {
        return Jwts
        .parser()
        .verifyWith(getSigningKeyB64())
        .requireIssuer(issuer)
        .requireAudience(audience)
        .build()
        .parseSignedClaims(token)
        .getPayload();
    }
    
    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }
    
    public Long extractUserId(String token) {
        return extractClaims(token).get("userId", Long.class);
    }

    public String extractRole(String token) {
        return extractClaims(token).get("role", String.class);
    }

    public boolean isValid(String token, String username) {
        try {
            String tokenUsername = extractUsername(token);
            return tokenUsername.equals(username) && extractClaims(token).getExpiration().after(new Date());
        } catch (Exception e) {
            return false;
        }
    }
    
}
