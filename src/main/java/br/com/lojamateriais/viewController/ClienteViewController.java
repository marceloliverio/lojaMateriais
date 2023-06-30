package br.com.lojamateriais.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/templates")
public class ClienteView {

    @GetMapping
    public String carregaPaginaFormulario(){
        return "templates/cadastroCliente";
    }
}
