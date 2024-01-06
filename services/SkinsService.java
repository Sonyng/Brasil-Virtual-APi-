package com.brasilvirtual.services;

import com.brasilvirtual.models.skins.Skin;
import com.brasilvirtual.repositories.SkinsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkinsService {
    @Autowired
    private SkinsRepository skinsRepository;
    public Skin criar (Skin skins){
        return skinsRepository.save(skins);
    }
    @Cacheable(value = "skinsCache", key = "#idSkin")
    public Optional<Skin> buscarPorID(Long idSkin){
        return skinsRepository.findById(idSkin);
    }
    @Cacheable(value = "skinsCache", key = "'all'")
    public List<Skin> findAll(){
        return skinsRepository.findAll();
    }
    @CacheEvict(value = "skinsCache", key = "#skin.idItem")
    public Skin atualizar (Skin skin, int skinAux){
        var skin1 = skinsRepository.findById(skin.getIdItem());
        if(skin1.isPresent()){
            if (skin1.get().getNome()!= null){
                skin1.get().setNome(skin.getNome());
            }
        }
        return skin;
    }
    @CacheEvict(value = "skinsCache", key = "#idSkin")
    public void deletar (Long idSkin){
        skinsRepository.deleteById(idSkin);
    }
    public boolean existe (Long idSkin){
        return !skinsRepository.existsById(idSkin);
    }



}
