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
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.locadora.Model.Aluguel;
import com.edu.locadora.Model.Carro;
import com.edu.locadora.Service.AluguelService;
import com.edu.locadora.Service.CarroService;
import com.edu.locadora.Service.LocatarioService;

@Controller
@RequestMapping("/aluguel")
public class AluguelController {
    
    @Autowired
    AluguelService aluguelService;

    @Autowired
    CarroService carroService;

    @Autowired
    LocatarioService locatarioService;

    @GetMapping("/cadastro/{placa}")
    public String novoAluguel(@PathVariable String placa, Model model){
        Aluguel aluguel = new Aluguel();
        Carro carro = carroService.buscarPorPlaca(placa);

        aluguel.setCarro(carro);

        model.addAttribute("aluguel", aluguel);
        model.addAttribute("carros", carroService.listarTodos());
        model.addAttribute("locatarios", locatarioService.listarTodos());

        return "aluguel-form";
    }

    @PostMapping("/salvar")
    public String salvarAluguel(@ModelAttribute Aluguel aluguel){
        aluguelService.criarAluguel(
            aluguel.getCarro(),
            aluguel.getLocatario(),
            aluguel.getQtDias()
        );

        
        return "redirect:/aluguel";
    }

    @GetMapping("/devolver/{id}")
    public String devolverCarro(@PathVariable Long id,
                            @RequestParam double litrosFaltando,
                            @RequestParam boolean danos){

        aluguelService.devolverCarro(id, litrosFaltando, danos);

        return "redirect:/aluguel";
    }
    
    @GetMapping("/editar/{id}")
    public String editarAluguel(@PathVariable Long id, Model model){
        Aluguel aluguel = aluguelService.buscarPorId(id);

        model.addAttribute("aluguel",aluguel);
        model.addAttribute("carros", carroService.listarTodos());
        model.addAttribute("locatarios", locatarioService.listarTodos());
        
        return "aluguel-form";
    }

    @GetMapping
    public String listarAluguel(Model model){
        List<Aluguel> alugueis = aluguelService.listarTodos();

        model.addAttribute("alugueis", alugueis);

        return "aluguel-list";
    }

    @GetMapping("/excluir/{id}")
    public String excluirAluguel(@PathVariable Long id){
        aluguelService.excluir(id);

        return "redirect:/aluguel";
    }

}
