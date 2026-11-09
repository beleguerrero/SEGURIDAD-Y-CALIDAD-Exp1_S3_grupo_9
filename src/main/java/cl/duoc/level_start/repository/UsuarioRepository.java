package cl.duoc.level_start.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.duoc.level_start.entity.UsuarioEntity;

@Repository 
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    Optional<UsuarioEntity> findByUsuario(String usuario);

    boolean existsByUsuario(String usuario);

}
