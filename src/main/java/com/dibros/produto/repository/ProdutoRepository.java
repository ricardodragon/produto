package com.dibros.produto.repository;

import com.dibros.produto.model.Produto;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Long> {

    List<Produto> findByUsuarioId(Long id);
}
