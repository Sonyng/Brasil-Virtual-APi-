package com.brasilvirtual.repositories;

import com.brasilvirtual.models.jogadores.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadoresRepository extends JpaRepository <Jogador, Long> {
}
