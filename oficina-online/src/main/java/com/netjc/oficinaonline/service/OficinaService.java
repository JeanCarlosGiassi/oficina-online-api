package com.netjc.oficinaonline.service;

import com.netjc.oficinaonline.entity.Oficina;
import com.netjc.oficinaonline.repository.OficinaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OficinaService {
    private OficinaRepository oficinaRepository;

    public Oficina createOficina(Oficina oficina){
       return oficinaRepository.save(oficina);
    }
    public List<Oficina> listAllOficina(){
        return (List<Oficina>) oficinaRepository.findAll();
    }
}
