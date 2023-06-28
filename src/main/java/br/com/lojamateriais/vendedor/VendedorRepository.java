package br.com.lojamateriais.vendedor;


import br.com.lojamateriais.loja.Vendedor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Range;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedorRepository  extends JpaRepository<Vendedor, Long> {
    Page<Vendedor> findByAtivoTrue(Pageable paginacao);


}
