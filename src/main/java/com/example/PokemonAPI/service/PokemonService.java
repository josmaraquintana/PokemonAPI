package com.example.PokemonAPI.service;

import com.example.PokemonAPI.model.Pokemon;
import com.example.PokemonAPI.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public List<Pokemon> listarTodos() {
        return pokemonRepository.findAll();
    }
    public Pokemon guardar(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }
    public Optional<Pokemon> buscarPorId(Long id) {
        return pokemonRepository.findById(id);
    }
}
