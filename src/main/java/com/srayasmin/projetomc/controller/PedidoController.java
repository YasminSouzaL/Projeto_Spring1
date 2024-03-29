package com.srayasmin.projetomc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.srayasmin.projetomc.domain.Pedido;
import com.srayasmin.projetomc.services.PedidoService;
 
@RestController
@RequestMapping(value="/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService service;
    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id){
        Pedido obj = service.buscar(id);
        return ResponseEntity.ok().body(obj);  
    }
    
}
