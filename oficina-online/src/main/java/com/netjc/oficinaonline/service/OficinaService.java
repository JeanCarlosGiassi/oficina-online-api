package com.netjc.oficinaonline.service;

import com.netjc.oficinaonline.entity.Oficina;
import com.netjc.oficinaonline.repository.IOficinaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OficinaService {
    private IOficinaRepository oficinaRepository;

    public Oficina createOficina(Oficina oficina){
       return oficinaRepository.save(oficina);
    }
    public List<Oficina> listAllOficina(){
        return (List<Oficina>) oficinaRepository.findAll();
    }
    public Optional<Oficina> getOficinaById(Integer id){ return  oficinaRepository.findById(id);}
    public ResponseEntity<Object> deleteOficinaById(Integer id){
        return oficinaRepository.findById(id).map(
                oficinaDelete -> {oficinaRepository.deleteById(id);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
