package com.netjc.oficinaonline.controller;

import com.netjc.oficinaonline.entity.FabricantePeca;
import com.netjc.oficinaonline.entity.Peca;
import com.netjc.oficinaonline.service.FabricantePecaService;
import com.netjc.oficinaonline.service.PecaService;
import io.swagger.annotations.Api;
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
@Api
public class PecaController {
    PecaService pecaService;

    @PostMapping("/pecas")
    @ResponseStatus(HttpStatus.CREATED)
    public Peca createPeca(@RequestBody Peca peca){
        log.info("Criando um fabricante com as informações [{}]", peca);
        return pecaService.createPeca(peca);
    }

    @GetMapping("/pecas")
    @ResponseStatus(HttpStatus.OK)
    public List<Peca> getPeca(){
        return pecaService.listAllPeca();
    }

    @PutMapping("/pecas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Peca> putPecaById(@PathVariable (value = "id") Integer id, @RequestBody Peca peca){
        log.info("Atualizando Fabricante de Peça com id [{}]", id);
        return pecaService.updatePecaById(peca, id);
    }

    @GetMapping("/pecas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Peca> getPeca(@PathVariable(value = "id") Integer id){
        return pecaService.getPecaById(id);
    }

    @DeleteMapping("/pecas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deletePecaById(@PathVariable(value = "id") Integer id){
        return pecaService.deletePecaById(id);
    }
}
