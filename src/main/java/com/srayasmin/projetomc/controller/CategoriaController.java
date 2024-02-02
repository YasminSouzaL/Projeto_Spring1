package com.srayasmin.projetomc.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.srayasmin.projetomc.domain.Categoria;
import com.srayasmin.projetomc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService service;
    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id){
        Categoria obj = service.buscar(id);
        return ResponseEntity.ok().body(obj);  
    }
    
    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Categoria obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
