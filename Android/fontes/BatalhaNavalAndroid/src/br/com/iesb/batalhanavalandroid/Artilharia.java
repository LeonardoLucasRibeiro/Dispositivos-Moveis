package br.com.iesb.batalhanavalandroid;

import java.util.ArrayList;
import java.util.List;


public class Artilharia implements ElementosInterface{
	
	private String tipo;
	private String sigla;
	private String nome;
	private String situacao;
	private int	tamanho;
	private List<String> posicoes = new ArrayList<String>();
	
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	public List<String> getPosicoes() {
		return posicoes;
	}
	public void setPosicoes(List<String> posicoes) {
		this.posicoes = posicoes;
	}

	
	
	public void distribuiElementos(BatalhaAdapater objArtilhariaAdapter) {
		// TODO Auto-generated method stub
	}
}
