package com.brasilvirtual.models;

import com.brasilvirtual.models.item.Item;
import com.brasilvirtual.models.jogadores.Jogador;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Compra {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Jogador jogador;
    @ManyToMany
    @JoinTable(name = "compra-item", joinColumns = @JoinColumn(name = "compra_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> itens;
}
