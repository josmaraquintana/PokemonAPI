package com.example.PokemonAPI.controller;

import com.example.PokemonAPI.model.Pokemon;
import com.example.PokemonAPI.service.PokemonService;
import jakarta.validation.Valid;
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
        return pokemonService.listarPorId(id);
    }
    @PostMapping
    public Pokemon crear(@Valid @RequestBody Pokemon pokemon){
        return pokemonService.guardar(pokemon);
    }

    @PutMapping("/{id}")
    public Pokemon actualizarCompleto(@PathVariable Long id, @RequestBody Pokemon pokemon) {
        return pokemonService.actualizarPokemonCompleto(id, pokemon);
    }

    @PatchMapping("/{id}")
    public Pokemon actualizarParcial(@PathVariable Long id, @RequestBody Pokemon pokemon) {
        return pokemonService.actualizarPokemonParcial(id, pokemon);
    }

    // Eliminar un pokemon por id
    @DeleteMapping("/{id}")
    public void eliminarPokemon(@PathVariable Long id) {
        pokemonService.eliminarPokemon(id);
    }

}
