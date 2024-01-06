package com.brasilvirtual.models.item;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class Item {

    @Id
    @GeneratedValue
    private Long idItem;
    private String nome;
    private String imagem;
    private double preco;

}
