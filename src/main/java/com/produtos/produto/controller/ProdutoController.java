package com.produtos.produto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.produtos.produto.model.Produto;
import com.produtos.produto.model.ProdutoRepository;

@Controller // Utilizado para quando fazemos a conexão do Front
public class ProdutoController {
    
    @Autowired
    private ProdutoRepository repository;

    // Model é o objeto do SpringBoot(MVC) que traz atributos e métodos prontos para a comunicação entre o front e o backend.
    // model.addAttribute("produtos" -> Pede a lista de produtos
    // repository.findAll() -> Pesquisar e trazer todos os produtos do BD.
    // return "lista"; -> é a página html que será mostrada os produtos
    @GetMapping("/")
    public String listarProdutos(Model model) {
        model.addAttribute("produtos", repository.findAll());
        return "lista"; 
    }

    @GetMapping("/cadastro")
    public String mostrarFormulario(Model model) {
        model.addAttribute("produto", new Produto());
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrar(Produto produto){
        repository.save(produto);
        return "redirect:/";
    }
    



    
    



}
