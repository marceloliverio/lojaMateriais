package br.com.lojamateriais.vendas;

import br.com.lojamateriais.loja.Cliente;
import br.com.lojamateriais.loja.Produtos;
import br.com.lojamateriais.loja.Vendedor;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Entity (name = "vendas")
@Table (name = "vendas")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode (of = "id")
@ToString
public class Vendas {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cliente_id", referencedColumnName = "id")
    private Cliente cliente;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vendedor_id", referencedColumnName = "id")
    private Vendedor vendedor;
    @ManyToMany
    @JoinTable(name="vendas_produto" , joinColumns = {@JoinColumn(name = "vendas_id")}, inverseJoinColumns = {@JoinColumn(name = "produto_id")})
    private List<Produtos> teste;
    private Boolean finalizada;

    public Vendas(Cliente cliente, Vendedor vendedor, List<Produtos> produtos) {

        this.cliente = cliente;
        this.vendedor = vendedor;
        this.teste = produtos;
    }
}
