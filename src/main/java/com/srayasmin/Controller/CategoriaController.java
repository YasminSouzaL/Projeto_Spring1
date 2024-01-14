package com.srayasmin.Controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @GetMapping
    public String listar(){
        return "REST está funcionando!";
    }

}
