package com.jpiva.model;

import java.util.Date;

public class Cliente {
	
	String 	aluno, 
			representante, 
			endereco, 
			numero, 
			complemento, 
			bairro,
			cidade,
			cep, 
			localNascimento,
			fone1,
			fone2,
			treinouAntes,
			ondeTreinou,
			escolaridade,
			profissao,
			localTrabalho,
			enderecoTrabalho,
			numeroTrabalho,
			bairroTrabalho,
			cidadeTrabalho,
			foneTrabalho,
			rg,
			cpf,
			nomePai,
			nomeMae;
			
	
	int idade, estadoCivil;
	double peso, altura;
	Date dtNascimento;
	
	
	public int getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(int estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public Date getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	
	public String getAluno() {
		return aluno;
	}
	public void setAluno(String aluno) {
		this.aluno = aluno;
	}
	public String getRepresentante() {
		return representante;
	}
	public void setRepresentante(String representante) {
		this.representante = representante;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLocalNascimento() {
		return localNascimento;
	}
	public void setLocalNascimento(String localNascimento) {
		this.localNascimento = localNascimento;
	}
	public String getFone1() {
		return fone1;
	}
	public void setFone1(String fone1) {
		this.fone1 = fone1;
	}
	public String getFone2() {
		return fone2;
	}
	public void setFone2(String fone2) {
		this.fone2 = fone2;
	}
	public String getTreinouAntes() {
		return treinouAntes;
	}
	public void setTreinouAntes(String treinouAntes) {
		this.treinouAntes = treinouAntes;
	}
	public String getOndeTreinou() {
		return ondeTreinou;
	}
	public void setOndeTreinou(String ondeTreinou) {
		this.ondeTreinou = ondeTreinou;
	}
	public String getEscolaridade() {
		return escolaridade;
	}
	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	public String getLocalTrabalho() {
		return localTrabalho;
	}
	public void setLocalTrabalho(String localTrabalho) {
		this.localTrabalho = localTrabalho;
	}
	public String getEnderecoTrabalho() {
		return enderecoTrabalho;
	}
	public void setEnderecoTrabalho(String enderecoTrabalho) {
		this.enderecoTrabalho = enderecoTrabalho;
	}
	public String getNumeroTrabalho() {
		return numeroTrabalho;
	}
	public void setNumeroTrabalho(String numeroTrabalho) {
		this.numeroTrabalho = numeroTrabalho;
	}
	public String getBairroTrabalho() {
		return bairroTrabalho;
	}
	public void setBairroTrabalho(String bairroTrabalho) {
		this.bairroTrabalho = bairroTrabalho;
	}
	public String getCidadeTrabalho() {
		return cidadeTrabalho;
	}
	public void setCidadeTrabalho(String cidadeTrabalho) {
		this.cidadeTrabalho = cidadeTrabalho;
	}
	public String getFoneTrabalho() {
		return foneTrabalho;
	}
	public void setFoneTrabalho(String foneTrabalho) {
		this.foneTrabalho = foneTrabalho;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNomePai() {
		return nomePai;
	}
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}
	public String getNomeMae() {
		return nomeMae;
	}
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
	
	

}
