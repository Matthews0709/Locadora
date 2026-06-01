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

import com.edu.locadora.Model.Carro;
import com.edu.locadora.Model.Reparo;
import com.edu.locadora.Service.CarroService;
import com.edu.locadora.Service.ReparoService;

@Controller
@RequestMapping("/reparo")
public class ReparoController {
    
    @Autowired
    ReparoService reparoService;

    @Autowired
    CarroService carroService;

    @GetMapping("/novo/{placa}")
    public String novoReparo(@PathVariable String placa, Model model){
        Reparo reparo = new Reparo();
        Carro carro = carroService.buscarPorPlaca(placa);

        reparo.setCarro(carro);

        model.addAttribute("reparo", reparo);
        model.addAttribute("carros", carroService.listarTodos());

        return "reparo-form";
    }

    @PostMapping("salvar")
    public String salvarReparo(@ModelAttribute Reparo reparo, Carro carro){
        reparoService.salvar(reparo);
        
        carro = carroService.buscarPorPlaca(carro.getPlaca());

        reparoService.iniciarReparo(carro, reparo);

        return "redirect:/reparo";
    }

    @GetMapping("/finalizar/{id}")
    public String finalizar(@PathVariable Long id){

        Reparo reparo = reparoService.buscarPorIdReparo(id);
        reparoService.finalizarReparo(reparo.getCarro(), id);

        return "redirect:/reparo";
    }

    @GetMapping("/editar/{id}")
    public String editarReparo(@PathVariable Long id, Model model){
        Reparo reparo = reparoService.buscarPorIdReparo(id);
        
        model.addAttribute("reparo",reparo);

        return "reparo-form";
    }

    @GetMapping
    public String listarReparo(Model model){
        List<Reparo> reparos = reparoService.listarTodos();

        model.addAttribute("reparos", reparos);

        return "reparo-list";
    }

    @GetMapping("/excluir/{id}")
    public String excluirReparo(@PathVariable Long id){
        reparoService.excluir(id);
        
        return "redirect:/reparo";
    }
}
