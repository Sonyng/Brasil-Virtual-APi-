package com.brasilvirtual.models.jogadores;

import com.brasilvirtual.models.mapas.Mapa;
import com.brasilvirtual.models.skins.Skin;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Table(name = "Jogadores")
    public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String dataNascimento;
    @ManyToMany
    @JoinTable(name = "jogador-skin", joinColumns = @JoinColumn(name = "jogador_id"),
            inverseJoinColumns = @JoinColumn(name = "skin_id"))
    private List<Skin> skins;

    @ManyToMany
    @JoinTable(name = "jogador-mapa", joinColumns = @JoinColumn(name = "jogador_id"),
            inverseJoinColumns = @JoinColumn(name = "mapa_id"))
    private List<Mapa> mapas;

}