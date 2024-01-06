package com.brasilvirtual.models.jogadores;

public record JogadorResponse(Long id, String nome,String email, String dataNascimento) {
    public JogadorResponse(Jogador jogador){
        this(jogador.getId(), jogador.getNome(), jogador.getEmail(), jogador.getDataNascimento());
    }
}
