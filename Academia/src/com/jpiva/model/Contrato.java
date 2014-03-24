package com.jpiva.model;

import java.math.BigDecimal;
import java.util.List;

public class Contrato {
	
	int limiteDeAulas, limiteDeAulasSemanais, diaDePagto, qtdMesesPlano, qtdParcela;
	BigDecimal valorParcela;
	List diasDaSemana;
	Cliente cliente;
	
	
	public int getLimiteDeAulas() {
		return limiteDeAulas;
	}
	public void setLimiteDeAulas(int limiteDeAulas) {
		this.limiteDeAulas = limiteDeAulas;
	}
	public int getLimiteDeAulasSemanais() {
		return limiteDeAulasSemanais;
	}
	public void setLimiteDeAulasSemanais(int limiteDeAulasSemanais) {
		this.limiteDeAulasSemanais = limiteDeAulasSemanais;
	}
	public int getDiaDePagto() {
		return diaDePagto;
	}
	public void setDiaDePagto(int diaDePagto) {
		this.diaDePagto = diaDePagto;
	}
	public int getQtdMesesPlano() {
		return qtdMesesPlano;
	}
	public void setQtdMesesPlano(int qtdMesesPlano) {
		this.qtdMesesPlano = qtdMesesPlano;
	}
	public int getQtdParcela() {
		return qtdParcela;
	}
	public void setQtdParcela(int qtdParcela) {
		this.qtdParcela = qtdParcela;
	}
	public BigDecimal getValorParcela() {
		return valorParcela;
	}
	public void setValorParcela(BigDecimal valorParcela) {
		this.valorParcela = valorParcela;
	}
	public List getDiasDaSemana() {
		return diasDaSemana;
	}
	public void setDiasDaSemana(List diasDaSemana) {
		this.diasDaSemana = diasDaSemana;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
