package com.example.demo.controller;

import com.example.demo.entity.Torneio;
import com.example.demo.repository.TorneioRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/torneio")
public class TorneioController {

    @Autowired
    private TorneioRepository torneioRepository;

    @GetMapping
    public ResponseEntity<List<Torneio>> fetchAllTorneios() {
        List<Torneio> torneios = torneioRepository.findAll();
        return ResponseEntity.ok(torneios);
    }

    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Torneio> createTorneio(@RequestBody Torneio torneio) {
        return ResponseEntity.ok(torneioRepository.save(torneio));
    };



}

