package com.brasilvirtual.models.jogadores;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record JogadorRecord(@NotBlank(message = "Nome não pode ser vazio.")
                            String nome,
                            @Email
                            String email,
                            String senha,
                            String dataNascimento)
                             {
    public Jogador toJogador(){
        return new Jogador(null, nome(), email(), senha(), dataNascimento(), null, null);
    }

}
