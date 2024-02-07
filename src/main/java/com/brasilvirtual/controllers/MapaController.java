package com.brasilvirtual.controllers;

import com.brasilvirtual.models.mapas.Mapa;
import com.brasilvirtual.models.skins.Skin;
import com.brasilvirtual.services.MapasService;
import com.brasilvirtual.services.SkinsService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/mapas")
public class MapaController {

    @Autowired
    private MapasService mapasService;
    @PostMapping
    public ResponseEntity<Mapa> criar(@RequestBody Mapa mapa, UriComponentsBuilder uriBuilder) {
        Mapa novoMapa = mapasService.criar(mapa);
        var uri = uriBuilder.path("/mapas/{id}").buildAndExpand(novoMapa.getIdItem()).toUri();
        return ResponseEntity.created(uri).body(novoMapa);
    }
    @GetMapping
    public ResponseEntity findAll(@PageableDefault Pageable pageable){
        return ResponseEntity.ok(mapasService.findAll(pageable));
    }
    @GetMapping("/{mapa}")
    public ResponseEntity findById(@PathVariable Long mapa){
        var mapaAux = mapasService.buscarPorId(mapa);
        if(mapaAux.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok((mapa));
    }
    @PutMapping("/{mapa}")
    public ResponseEntity atualizar(@PathVariable Long mapa) {
        var newMapa = mapasService.buscarPorId(mapa);
        if (mapasService.existe(mapa)) return ResponseEntity.notFound().build();
        var mapaAtualizado = mapasService.atualizar(new Mapa());
        return ResponseEntity.ok(mapaAtualizado);

    }
    @DeleteMapping("/{mapas}")
    public ResponseEntity deletar (@PathVariable Long mapa){
        if (mapasService.existe(mapa)) return ResponseEntity.notFound().build();
        mapasService.deletar(mapa);
        return ResponseEntity.noContent().build();
    }

}




