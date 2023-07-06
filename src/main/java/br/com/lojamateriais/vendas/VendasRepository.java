package br.com.lojamateriais.vendas;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Range;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendasRepository extends JpaRepository<Vendas, Long> {

    Page<Vendas> findByFinalizadaTrue(Pageable paginacao);
}
