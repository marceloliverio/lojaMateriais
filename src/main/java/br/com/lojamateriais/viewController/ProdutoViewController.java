package br.com.lojamateriais.viewController;

import br.com.lojamateriais.loja.Produtos;
import br.com.lojamateriais.produto.DadosAtualizacaoProduto;
import br.com.lojamateriais.produto.DadosCadastroProduto;
import br.com.lojamateriais.produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produtoView")
public class ProdutoViewController {

    @Autowired
    private ProdutoRepository repository;


    @GetMapping("/cadastroProduto")
    public String carregaPaginaFormulario(Long id, Model model) {
        if (id != null) {
            var produto = repository.getReferenceById(id);
            model.addAttribute("produto", produto);
        }
        return "produtoView/cadastroProduto";
    }

    @GetMapping
    public String carregarListagem(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "produtoView/listagemProduto";
    }

    @PostMapping
    @Transactional
    public String cadastrarProduto(DadosCadastroProduto dados) {
        var produto = new Produtos(dados);
        repository.save(produto);
        return "redirect:/produtoView";
    }

    @PutMapping
    @Transactional
    public String editarProduto(DadosAtualizacaoProduto dados) {
        var produto = repository.getReferenceById(dados.id());
        produto.atualizarInformacoes(dados);
        return "redirect:/produtoView";

    }

    @DeleteMapping
    @Transactional
    public String excluirProduto(Long id){
        repository.deleteById(id);
        return "redirect:/produtoView";
    }
}