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

import com.edu.locadora.Model.Locatario;
import com.edu.locadora.Service.LocatarioService;

@Controller
@RequestMapping("/locatario")
public class LocatarioController {

    @Autowired
    LocatarioService locatarioService;

    @GetMapping("/novo")
    public String novoLocatario(Model model){
        model.addAttribute("locatario", new Locatario());

        return "locatario-form";
    }

    @PostMapping("/salvar")
    public String salvarLocatario(@ModelAttribute Locatario locatario){
        locatarioService.salvar(locatario);

        return "redirect:/locatario";
    }

    @GetMapping("/editar/{cpf}")
    public String editarLocatario(@PathVariable String cpf, Model model){
        Locatario locatario = locatarioService.buscarPorCPF(cpf);

        model.addAttribute("locatario", locatario);

        return "locatario-form";
    }

    @GetMapping
    public String listarLocatario(Model model){
        List<Locatario> locatarios = locatarioService.listarTodos();

        model.addAttribute("locatarios", locatarios);

        return "locatario-list";
    }

    @GetMapping("/excluir/{cpf}")
    public String excluirLocatario(@PathVariable String cpf){
        locatarioService.excluir(cpf);
        
        return "redirect:/locatario";
    }
    
}
