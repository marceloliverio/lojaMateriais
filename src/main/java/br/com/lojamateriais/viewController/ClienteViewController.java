package br.com.lojamateriais.viewController;

import br.com.lojamateriais.cliente.ClienteRepository;
import br.com.lojamateriais.cliente.DadosAtualizacaoCliente;
import br.com.lojamateriais.cliente.DadosCadastroCliente;
import br.com.lojamateriais.loja.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clienteView")
public class ClienteViewController {

    @Autowired
    private ClienteRepository repository;
    @GetMapping("/cadastroCliente")
    public String carregaPaginaFormulario(Long id, Model model){
        if(id != null){
            var cliente = repository.getReferenceById(id);
            model.addAttribute("cliente", cliente);
        }
        return "clienteView/cadastroCliente";
    }

    @GetMapping
    public String carregarListagem(Model model) {
        model.addAttribute("lista" , repository.findAll());
        return "clienteView/listagemCliente";
    }
    @PostMapping
    @Transactional
    public String cadastrarCliente(DadosCadastroCliente dados){
        var cliente = new Cliente(dados);
        repository.save(cliente);
        return "redirect:/clienteView";
    }
    @PutMapping
    @Transactional
    public String editarCliente(DadosAtualizacaoCliente dados){
        var cliente = repository.getReferenceById(dados.id());
        cliente.atualizarInformacoes(dados);
        return "redirect:/clienteView";

    }
    @DeleteMapping
    @Transactional
    public String excluirCliente(Long id){
        repository.deleteById(id);
        return "redirect:/clienteView";
    }
}
