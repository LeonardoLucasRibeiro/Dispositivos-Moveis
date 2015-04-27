package br.com.iesb.batalhanavalandroid;

import java.util.ArrayList;
import java.util.List;


public class Artilharia {
	
	private String tipo;
	private String sigla;
	private String nome;
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
}
