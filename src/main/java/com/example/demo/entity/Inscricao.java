package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class Inscricao {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "usuario1_id")
    private User usuario1;

    @ManyToOne
    @JoinColumn(name = "usuario2_id")
    private User usuario2;
}