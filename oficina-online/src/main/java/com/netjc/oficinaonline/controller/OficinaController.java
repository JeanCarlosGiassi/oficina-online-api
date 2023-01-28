package com.netjc.oficinaonline.controller;

import com.netjc.oficinaonline.entity.Oficina;
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
public class OficinaController {
    OficinaService oficinaService;

    @PostMapping("/oficinas")
    @ResponseStatus(HttpStatus.CREATED)
    public Oficina createOficina(@RequestBody Oficina oficina){
        log.info("Criando uma oficina com as informações [{}]", oficina);
        return oficinaService.createOficina(oficina);
    }

    @GetMapping("/oficinas")
    @ResponseStatus(HttpStatus.OK)
    public List<Oficina> getOficinas(){
        return oficinaService.listAllOficina();
    }

    @GetMapping("/oficinas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Oficina> getOficinas(@PathVariable(value = "id") Integer id){
        return oficinaService.getOficinaById(id);
    }

    @DeleteMapping("/oficinas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteOficinaById(@PathVariable(value = "id") Integer id){
        return oficinaService.deleteOficinaById(id);
    }
}
