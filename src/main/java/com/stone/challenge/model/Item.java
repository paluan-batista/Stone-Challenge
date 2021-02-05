package com.stone.challenge.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

	@SerializedName("id")
	@Expose
	private Integer id;
	@SerializedName("tipoUnidade")
	@Expose
	private String tipoUnidade;
	@SerializedName("unidadeDeMedida")
	@Expose
	private String unidadeDeMedida;
	@SerializedName("nome")
	@Expose
	private String nome;
	@SerializedName("peso")
	@Expose
	private Integer peso;
	@SerializedName("preco")
	@Expose
	private Integer preco;
	@SerializedName("quantidade")
	@Expose
	private Integer quantidade;

	public Integer getId() {
	return id;
	}

	public void setId(Integer id) {
	this.id = id;
	}

	public String getTipoUnidade() {
	return tipoUnidade;
	}

	public void setTipoUnidade(String tipoUnidade) {
	this.tipoUnidade = tipoUnidade;
	}

	public String getUnidadeDeMedida() {
	return unidadeDeMedida;
	}

	public void setUnidadeDeMedida(String unidadeDeMedida) {
	this.unidadeDeMedida = unidadeDeMedida;
	}

	public String getNome() {
	return nome;
	}

	public void setNome(String nome) {
	this.nome = nome;
	}

	public Integer getPeso() {
	return peso;
	}

	public void setPeso(Integer peso) {
	this.peso = peso;
	}

	public Integer getPreco() {
	return preco;
	}

	public void setPreco(Integer preco) {
	this.preco = preco;
	}

	public Integer getQuantidade() {
	return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
	this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", tipoUnidade=" + tipoUnidade + ", unidadeDeMedida=" + unidadeDeMedida + ", nome="
				+ nome + ", peso=" + peso + ", preco=" + preco + ", quantidade=" + quantidade + "]";
	}
	
	

}
