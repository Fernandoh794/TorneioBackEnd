package com.example.demo.controller;

import com.example.demo.entity.Categoria;
import com.example.demo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public ResponseEntity<List<Categoria>> fetchAllCategorias() {
        return ResponseEntity.ok().body(categoriaRepository.findAll());
    }


    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria categoria) {
        System.out.println(categoria);
        return ResponseEntity.ok(categoriaRepository.save(categoria));
    };



}
