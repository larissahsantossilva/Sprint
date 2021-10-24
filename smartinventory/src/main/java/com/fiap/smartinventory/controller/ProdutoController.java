package com.fiap.smartinventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fiap.smartinventory.model.Produto;
import com.fiap.smartinventory.repository.ProdutoRepository;

@Controller
public class ProdutoController {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/list")
	public String getHome(Model model) {
		
		model.addAttribute("produtos", produtoRepository.findAll());
		return "index";
	}
	
	@PostMapping("/add")
    public String addProduto(Produto produto, BindingResult result, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("errors", result.getAllErrors());
            return "redirect:list";
        }

        produtoRepository.save(produto);
        return "redirect:list";
    }
	
	@PostMapping("/delete")
	public String deletaProduto(Long id, RedirectAttributes redirectAttributes) {
		
		produtoRepository.deleteById(id);
		redirectAttributes.addFlashAttribute("msg", "Produto deletado com sucesso!");
		return "redirect:list";
	}
	
}
