package com.example.biblioteca.controller;

import com.example.biblioteca.entity.Livro;
import com.example.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private LivroService service;

    @GetMapping
    public String listar(Model model) {
        List<Livro> livros = service.listarLivros();
        model.addAttribute("livros", livros);
        return "livros"; // Nome do template Thymeleaf
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Livro obterLivro(@PathVariable Long id) {
        return service.obterLivroPorId(id);
    }

    @PostMapping
    @ResponseBody
    public Livro cadastrar(@RequestBody Livro livro) {
        return service.salvarLivro(livro);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Livro atualizar(@PathVariable Long id, @RequestBody Livro livro) {
        return service.atualizarLivro(id, livro);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deletar(@PathVariable Long id) {
        service.deletarLivro(id);
    }
}
