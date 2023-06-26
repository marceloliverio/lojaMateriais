package br.com.lojamateriais.produto;

import br.com.lojamateriais.loja.Produtos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Range;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produtos, Long> {

    Page<Produtos> findById(Pageable paginacao);
}
