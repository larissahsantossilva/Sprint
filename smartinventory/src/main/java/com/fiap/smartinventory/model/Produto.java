package com.fiap.smartinventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name = "TB_PRODUTO")
@SequenceGenerator(sequenceName = "SEQ_PRODUTO", name = "produto", initialValue = 1, allocationSize = 1)
public class Produto {

	@Id
	@GeneratedValue(generator = "produto", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "nm_produto", nullable = false)
	private String nome;
	
	@Column(name = "ds_produto", nullable = false)
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Produto(Long id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public Produto() {
	}
	
}
