package com.netjc.oficinaonline.service;

import com.netjc.oficinaonline.entity.FabricantePeca;
import com.netjc.oficinaonline.entity.Oficina;
import com.netjc.oficinaonline.repository.IFabricantePecaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FabricantePecaService {
    private IFabricantePecaRepository fabricantePecaRepository;

    public FabricantePeca createFabricantePeca(FabricantePeca fabricantePeca){
        return fabricantePecaRepository.save(fabricantePeca);
    }
    public List<FabricantePeca> listAllFabricantePeca(){
        return (List<FabricantePeca>) fabricantePecaRepository.findAll();
    }
    public Optional<FabricantePeca> getFabricantePecaById(Integer id){ return  fabricantePecaRepository.findById(id);}

    public ResponseEntity<Object> deleteFabricantePecaById(Integer id){
        return fabricantePecaRepository.findById(id).map(
                oficinaDelete -> {fabricantePecaRepository.deleteById(id);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<FabricantePeca> updateTaskById(FabricantePeca fabricante, Integer id){
        return fabricantePecaRepository.findById(id)
                .map(fabricantePecaUpdate -> {
                    fabricantePecaUpdate.setFabricante(fabricante.getFabricante());
                    FabricantePeca updated = fabricantePecaRepository.save(fabricantePecaUpdate);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }
}
