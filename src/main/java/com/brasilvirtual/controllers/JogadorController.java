package com.brasilvirtual.controllers;

import com.brasilvirtual.models.jogadores.Jogador;
import com.brasilvirtual.models.jogadores.JogadorRecord;
import com.brasilvirtual.models.jogadores.JogadorResponse;
import com.brasilvirtual.models.skins.Skin;
import com.brasilvirtual.services.JogadoresService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@CrossOrigin("*")
@RequestMapping("/jogadores")
public class JogadorController {
    @Autowired
    private JogadoresService jogadoresService;
    @PostMapping
    public ResponseEntity<JogadorResponse> criar (@RequestBody @Valid JogadorRecord jogador, UriComponentsBuilder builder) {
        Jogador novoJogador = jogadoresService.criar(jogador.toJogador());
        var uri = builder.path("/jogadores/{id}").buildAndExpand(novoJogador.getId()).toUri();
        return ResponseEntity.created(uri).body(new JogadorResponse(novoJogador));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Jogador> buscarJogadorPorId(@PathVariable Long id) {
        var jogador = jogadoresService.buscarPorId(id);
        return ResponseEntity.ok().body(jogador);
    }

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(jogadoresService.findAll());
    }
    @PutMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable Long id){
        var newJogador = jogadoresService.buscarPorId(id);
        if(jogadoresService.existe(id)) return ResponseEntity.notFound().build();
        var jogadorAtualizado = jogadoresService.atualizar(newJogador); return ResponseEntity.ok(jogadorAtualizado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        if(jogadoresService.existe(id)) return ResponseEntity.notFound().build();
        jogadoresService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

