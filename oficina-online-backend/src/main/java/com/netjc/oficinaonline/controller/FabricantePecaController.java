package com.netjc.oficinaonline.controller;

import com.netjc.oficinaonline.entity.FabricantePeca;
import com.netjc.oficinaonline.entity.Oficina;
import com.netjc.oficinaonline.service.FabricantePecaService;
import com.netjc.oficinaonline.service.OficinaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
@Slf4j
public class FabricantePecaController {

    FabricantePecaService fabricantePecaService;

    @PostMapping("/fabricantes/peca")
    @ResponseStatus(HttpStatus.CREATED)
    public FabricantePeca createFabricantePeca(@RequestBody FabricantePeca fabricantePeca){
        log.info("Criando um fabricante com as informações [{}]", fabricantePeca);
        return fabricantePecaService.createFabricantePeca(fabricantePeca);
    }

    @GetMapping("/fabricantes/peca")
    @ResponseStatus(HttpStatus.OK)
    public List<FabricantePeca> getFabricantesPeca(){
        return fabricantePecaService.listAllFabricantePeca();
    }

    @PutMapping("/fabricantes/peca/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<FabricantePeca> putFabricantePecaById(@PathVariable (value = "id") Integer id, @RequestBody FabricantePeca fabricantePeca){
        log.info("Atualizando Fabricante de Peça com id [{}]", id);
        return fabricantePecaService.updateFabricantePecaById(fabricantePeca, id);
    }

    @GetMapping("/fabricantes/peca/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<FabricantePeca> getFabricantesPeca(@PathVariable(value = "id") Integer id){
        return fabricantePecaService.getFabricantePecaById(id);
    }

    @DeleteMapping("/fabricantes/peca/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteFabricantesPecaById(@PathVariable(value = "id") Integer id){
        return fabricantePecaService.deleteFabricantePecaById(id);
    }
}
