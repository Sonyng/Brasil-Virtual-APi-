package com.brasilvirtual.repositories;

import com.brasilvirtual.models.skins.Skin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkinsRepository extends JpaRepository <Skin, Long> {
}
