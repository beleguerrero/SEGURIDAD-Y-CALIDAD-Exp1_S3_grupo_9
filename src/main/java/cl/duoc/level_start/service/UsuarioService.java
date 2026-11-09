package cl.duoc.level_start.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cl.duoc.level_start.dto.LoginRequestDTO;
import cl.duoc.level_start.dto.LoginResponseDTO;
import cl.duoc.level_start.entity.UsuarioEntity;
import cl.duoc.level_start.jwt.JwtUtil;
import cl.duoc.level_start.repository.UsuarioRepository;

@Service 
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;


    public UsuarioService(
        UsuarioRepository usuarioRepository,
        AuthenticationManager authenticationManager, 
        JwtUtil jwtUtil
    ) {
        this.usuarioRepository = usuarioRepository;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }


    public LoginResponseDTO login(LoginRequestDTO data) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(data.getUsuario(), data.getPassword()));

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        UsuarioEntity usuario = usuarioRepository.findByUsuario(userDetails.getUsername()).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        String role = userDetails.getAuthorities().iterator().next().getAuthority();
        String token = jwtUtil.generateToken(usuario.getId(), userDetails.getUsername(), role);

        return new LoginResponseDTO(token, "Bearer");
    }

}
