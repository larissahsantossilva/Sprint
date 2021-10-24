package com.fiap.smartinventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.smartinventory.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
