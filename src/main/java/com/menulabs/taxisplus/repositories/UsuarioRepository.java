package com.menulabs.taxisplus.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.menulabs.taxisplus.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findOneByEmail(String email);
}
