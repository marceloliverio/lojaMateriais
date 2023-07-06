package br.com.lojamateriais.viewController;

import br.com.lojamateriais.loja.Produtos;
import br.com.lojamateriais.loja.Vendedor;
import br.com.lojamateriais.produto.DadosAtualizacaoProduto;
import br.com.lojamateriais.produto.DadosCadastroProduto;
import br.com.lojamateriais.vendedor.DadosAtualizacaoVendedor;
import br.com.lojamateriais.vendedor.DadosCadastroVendedor;
import br.com.lojamateriais.vendedor.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vendedorView")
public class VendedorViewController {

    @Autowired
    private VendedorRepository repository;

    @GetMapping("/cadastroVendedor")
    public String carregaPaginaFormulario(Long id, Model model) {
        if (id != null) {
            var vendedor = repository.getReferenceById(id);
            model.addAttribute("vendedor", vendedor);
        }
        return "vendedorView/cadastroVendedor";
    }

    @GetMapping
    public String carregarListagem(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "vendedorView/listagemVendedor";
    }

    @PostMapping
    @Transactional
    public String cadastrarVendedor(DadosCadastroVendedor dados) {
        var vendedor = new Vendedor(dados);
        repository.save(vendedor);
        return "redirect:/vendedorView";
    }

    @PutMapping
    @Transactional
    public String editarVendedor(DadosAtualizacaoVendedor dados) {
        var vendedor = repository.getReferenceById(dados.id());
        vendedor.atualizarInformacoes(dados);
        return "redirect:/vendedorView";

    }

    @DeleteMapping
    @Transactional
    public String excluirVendedor(Long id){
        repository.deleteById(id);
        return "redirect:/vendedorView";
    }
}
