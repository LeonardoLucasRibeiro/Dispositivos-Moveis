package br.com.iesb.batalhanavalandroid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Artilharia implements ElementosInterface{
	


	private String tipo;
	private String sigla;
	private String nome;
	private String situacao;
	private int	tamanho;
	private List<String> posicoes = new ArrayList<String>();
	private HashMap<Integer, Integer> imagens = new HashMap<Integer, Integer>();
	private HashMap<Integer, Integer> imagensOff = new HashMap<Integer, Integer>();
	
	
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
	public HashMap<Integer, Integer> getImagens() {
		return imagens;
	}
	public void setImagens(HashMap<Integer, Integer> imagens) {
		this.imagens = imagens;
	}
	public HashMap<Integer, Integer> getImagensOff() {
		return imagensOff;
	}
	public void setImagensOff(HashMap<Integer, Integer> imagensOff) {
		this.imagensOff = imagensOff;
	}

	
	@Override
	public void distribuiElementos(BatalhaAdapater objArtilhariaAdapter) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
