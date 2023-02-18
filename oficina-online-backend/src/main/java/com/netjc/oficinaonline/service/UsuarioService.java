package com.netjc.oficinaonline.service;

import com.auth0.jwt.impl.ClaimsHolder;
import com.netjc.oficinaonline.entity.Usuario;
import com.netjc.oficinaonline.repository.IUsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioService {

    public String extractUsername(String token){
        return null;
    }

}
