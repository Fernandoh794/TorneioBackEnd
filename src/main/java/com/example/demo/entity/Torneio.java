package com.example.demo.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Torneio {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String nome;


    @OneToMany(mappedBy = "torneio", fetch = FetchType.EAGER)
    private List<Categoria> categorias;

}
