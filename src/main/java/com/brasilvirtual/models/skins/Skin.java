package com.brasilvirtual.models.skins;

import com.brasilvirtual.models.item.Item;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "skins")
public class Skin extends Item {
    public Skin(Long idItem, String nome, String imagem, double preco) {
        super(idItem, nome, imagem, preco);
    }

    public Skin() {
    }
}
