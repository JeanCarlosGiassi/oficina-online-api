package com.netjc.oficinaonline.controller;

import com.netjc.oficinaonline.entity.Oficina;
import com.netjc.oficinaonline.service.OficinaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
}
