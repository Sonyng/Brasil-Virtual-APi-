package com.brasilvirtual.repositories;

import com.brasilvirtual.models.mapas.Mapa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MapasRepository extends JpaRepository <Mapa, Long> {
}
