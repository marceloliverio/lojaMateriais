package br.com.lojamateriais.viewController;

import br.com.lojamateriais.cliente.ClienteRepository;
import br.com.lojamateriais.cliente.DadosAtualizacaoCliente;
import br.com.lojamateriais.cliente.DadosCadastroCliente;
import br.com.lojamateriais.loja.Cliente;
import br.com.lojamateriais.loja.Produtos;
import br.com.lojamateriais.produto.ProdutoRepository;
import br.com.lojamateriais.vendas.Vendas;
import br.com.lojamateriais.vendas.VendasRepository;
import br.com.lojamateriais.vendedor.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/vendasView")
public class VendasController {

    @Autowired
    private VendasRepository repository;

    @Autowired
    private ClienteRepository cRepository;

    @Autowired
    private VendedorRepository vRepository;

    @Autowired
    private ProdutoRepository pRepository;

    @GetMapping("/cadastroVendas")
    public String carregaPaginaFormulario(Long id,Model model){

            if(id != null ) {
                model.addAttribute("vendas", repository.getReferenceById(id));

            }
        model.addAttribute("produtos", pRepository.findAll());
        model.addAttribute("clientes", cRepository.findAll());
        model.addAttribute("vendedores", vRepository.findAll());
        return "/vendasView/cadastroVendas";
    }

    @GetMapping
    public String carregarListagem(Model model) {
        List<Vendas> vendas = repository.findAll();

        System.out.println(vendas);
        model.addAttribute("vendas" , repository.findAll());


        return "vendasView/listagemVendas";
    }

    @GetMapping("/details")
    public String carregarListagemProdutos(Model model, Long id) {
        model.addAttribute("vendas" , repository.getReferenceById(id));
        return "vendasView/details";
    }




    @PostMapping
    @Transactional
    public String cadastrarVenda(Long idCliente, Long idVendedor, String produtos){



        var ids = produtos.split(",");
        List<Produtos>prods = new ArrayList<>();
        for (String id: ids){
            prods.add(pRepository.getReferenceById(Long.parseLong(id)));
        }
        var cliente = cRepository.getReferenceById(idCliente);
        var vendedor = vRepository.getReferenceById(idVendedor);
        var vendas = new Vendas(cliente, vendedor, prods);

        repository.save(vendas);

        return "redirect:/vendasView";
    }
//    @PutMapping
//    @Transactional
//    public String editarCliente(DadosAtualizacaoCliente dados){
//        var cliente = repository.getReferenceById(dados.id());
//        cliente.atualizarInformacoes(dados);
//        return "redirect:/clienteView";
//
//    }
//    @DeleteMapping
//    @Transactional
//    public String excluirCliente(Long id){
//        repository.deleteById(id);
//        return "redirect:/clienteView";
//    }

}
