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

import com.edu.locadora.Model.Carro;
import com.edu.locadora.Service.CarroService;
import com.edu.locadora.Service.CategoriaService;

@Controller
@RequestMapping("/carros")
public class CarroController 
{
    @Autowired
    private CarroService carroService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/novo")
    public String novoCarro(Model model){

        model.addAttribute("carro", new Carro());
        model.addAttribute("categorias", categoriaService.listarTodas());
        return "carro-form";
    }

    @PostMapping("/salvar")
    public String salvarCarro(@ModelAttribute Carro carro){
        carroService.salvar(carro);

        return "redirect:/carro";
    }

    @GetMapping("/editar/{placa}")
    public String editarCarro(@PathVariable String placa, Model model){
        Carro carro = carroService.buscarPorPlaca(placa);

        model.addAttribute("carro", carro);
        model.addAttribute("categorias", categoriaService.listarTodas());

        return "carro-form";
    }

    @GetMapping
    public String listarCarro(Model model){
        List<Carro> carros = carroService.listarTodos();

        model.addAttribute("carros", carros);

        return "carro-list";
    }

    @GetMapping("/excluir/{placa}")
    public String excluirCarro(@PathVariable String placa){
        carroService.excluir(placa);

        return "redirect:/carro";
    }

    @GetMapping("/categoria")
    public String porCategoria(@RequestParam String categoria, Model model) {

        List<Carro> carrosFiltrados = carroService.listarTodos()
            .stream()
            .filter(c -> c.getCategoria() != null
                    && c.getCategoria().getNome().equalsIgnoreCase(categoria))
            .toList();

        model.addAttribute("carros", carrosFiltrados);
        model.addAttribute("categoriaSelecionada", categoria);

        return "carro-list";
    }

    @GetMapping("/udf/disponiveis")
    public String listarDisponiveisUDF(Model model){

        model.addAttribute("carros",
        carroService.listarCarrosDisponiveisUDF()
        );

        return "carro-list";
    }
}
