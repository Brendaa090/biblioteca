package com.example.biblioteca.service;

import com.example.biblioteca.entity.Livro;
import com.example.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    @Autowired
    private LivroRepository repository;

    public List<Livro> listarLivros() {
        return repository.findAll();
    }

    public Livro salvarLivro(Livro livro) {
        return repository.save(livro);
    }

    public Livro atualizarLivro(Long id, Livro livro) {
        livro.setId(id);
        return repository.save(livro);
    }

    public void deletarLivro(Long id) {
        repository.deleteById(id);
    }

    public Livro obterLivroPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
}
