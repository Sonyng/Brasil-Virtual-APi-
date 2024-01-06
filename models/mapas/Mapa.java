package com.brasilvirtual.models.mapas;

import com.brasilvirtual.models.item.Item;
import com.brasilvirtual.models.jogadores.Jogador;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "mapas")
public class Mapa extends Item {

    private String anoMapa;

    public Mapa(Long idItem, String nome, String imagem, double preco, String anoMapa) {
        super(idItem, nome, imagem, preco);
        this.anoMapa = anoMapa;
    }

    public Mapa() {
    }
}

