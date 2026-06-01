package com.edu.locadora.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.locadora.Model.Categoria;
import com.edu.locadora.Service.CategoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController 
{
    @Autowired
    private CategoriaService categoriaService;


    @GetMapping("/novo")
    public String novaCategoria(Model model){
        model.addAttribute("categoria", new Categoria());
        return "categoria-form";
    }

    @PostMapping("/salvar")
    public String salvarCategoria(@ModelAttribute Categoria categoria){
        categoriaService.salvar(categoria);
        return "redirect:/categoria";
    }

    @GetMapping
    public String listarCategorias(Model model){
        List<Categoria> categorias = categoriaService.listarTodas();
        model.addAttribute("categorias", categorias);
        return "categoria-list";
    }

    @GetMapping("/editar/{id}")
    public String editarCategoria(@PathVariable Long id, Model model){
        Categoria categoria = categoriaService.buscarPoridCategoria(id);
        model.addAttribute("categoria", categoria);
        return "categoria-form";
    }

    @GetMapping("/excluir/{id}")
    public String excluirCategoria(@PathVariable Long id){
        categoriaService.excluir(id);
        return "redirect:/categoria";
    }
}
