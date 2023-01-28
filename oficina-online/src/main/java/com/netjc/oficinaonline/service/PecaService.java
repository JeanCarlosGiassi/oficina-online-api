package com.netjc.oficinaonline.service;

import com.netjc.oficinaonline.entity.FabricantePeca;
import com.netjc.oficinaonline.entity.Peca;
import com.netjc.oficinaonline.repository.IFabricantePecaRepository;
import com.netjc.oficinaonline.repository.IPecaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PecaService {
    private IPecaRepository pecaRepository;

    public Peca createPeca(Peca peca){
        return pecaRepository.save(peca);
    }
    public List<Peca> listAllPeca(){
        return (List<Peca>) pecaRepository.findAll();
    }
    public Optional<Peca> getPecaById(Integer id){ return  pecaRepository.findById(id);}

    public ResponseEntity<Object> deletePecaById(Integer id){
        return pecaRepository.findById(id).map(
                oficinaDelete -> {pecaRepository.deleteById(id);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Peca> updatePecaById(Peca peca, Integer id){
        return pecaRepository.findById(id)
                .map(pecaUpdate -> {
                    pecaUpdate.setPeca(peca.getPeca());
                    Peca updated = pecaRepository.save(pecaUpdate);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }
}
