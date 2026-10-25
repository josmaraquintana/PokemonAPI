package com.example.PokemonAPI.controller;

import com.example.PokemonAPI.model.Pokemon;
import com.example.PokemonAPI.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pokemones")
public class PokemonController {
    @Autowired
    private PokemonService pokemonService;

    @GetMapping
    public List<Pokemon> listar(){
        return pokemonService.listarTodos();
    }
    @GetMapping("/{id}")
    public Pokemon buscarPorId(@PathVariable Long id){
        return pokemonService.buscarPorId(id).orElse(null);
    }
    @PostMapping
    public Pokemon crear(@RequestBody Pokemon pokemon){
        return pokemonService.guardar(pokemon);
    }
}
