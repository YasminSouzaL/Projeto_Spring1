package com.srayasmin.projetomc.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.srayasmin.projetomc.domain.Categoria;
import com.srayasmin.projetomc.dto.CategoriaDTO;
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
    public ResponseEntity<?> insert(@RequestBody Categoria obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Categoria obj, @PathVariable Integer id){
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll(){
        List<Categoria> list = service.findAll();
        List<CategoriaDTO> listDTO = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
        
    }

    @GetMapping("/page")
    public ResponseEntity<Page<CategoriaDTO>> findPage(
        @RequestParam(value="page", defaultValue="0") Integer page, 
        @RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
        @RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
        @RequestParam(value="direction", defaultValue="ASC") String direction){
        Page<Categoria> list = service.findPage(page, linesPerPage, orderBy, direction);
        Page<CategoriaDTO> listDTO = list.map(obj -> new CategoriaDTO(obj));
        return ResponseEntity.ok().body(listDTO);
    }
}
