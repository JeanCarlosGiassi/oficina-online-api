package com.netjc.oficinaonline.repository;

import com.netjc.oficinaonline.entity.Peca;
import com.netjc.oficinaonline.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IUsuarioRepository extends CrudRepository<Usuario, Integer> {
    Optional<Usuario> findByUsername(String username);
}
