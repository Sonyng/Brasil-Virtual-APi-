package com.brasilvirtual.controllers;

import com.brasilvirtual.models.skins.Skin;
import com.brasilvirtual.services.SkinsService;
import jakarta.validation.Valid;
import org.flywaydb.core.api.callback.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/skins")
public class SkinController {
    @Autowired
    private SkinsService skinsService;

    @PostMapping
    public ResponseEntity<Skin> criar(@RequestBody Skin skin) {
        try {
            Skin skinCadastrar = skinsService.criar(skin);
            return new ResponseEntity<>(skinCadastrar, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity("Erro ao criar a skin: "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(skinsService.findAll());
    }


    @GetMapping("/{skin}")
    public ResponseEntity findById(@PathVariable Long skin) {
        var skinAux = skinsService.buscarPorID(skin);
        if(skin == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok((skin));
    }
    @PutMapping("/{skin}")
    public ResponseEntity atualizar(@PathVariable Long skin) {
        if(skinsService.existe(skin)) return ResponseEntity.notFound().build();
        var skinAtualizada = skinsService.atualizar(new Skin(), 1);
        return ResponseEntity.ok(skinAtualizada);
    }
    @DeleteMapping("/{skins}")
    public ResponseEntity deletar(@PathVariable Long idSkin) {
        if(skinsService.existe(idSkin)) return ResponseEntity.notFound().build();
        skinsService.deletar(idSkin);
        return ResponseEntity.noContent().build();
    }
}




