package br.com.iesb.batalhanavalandroid;

import java.util.HashMap;
import java.util.List;


public class Agua implements ElementosInterface{

	private String situacao;
	
	@Override
	public void distribuiElementos(BatalhaAdapater objArtilhariaAdapter) {
		objArtilhariaAdapter.getCampoBatalha().add(this);
		
	}

	@Override
	public List<String> getPosicoes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSigla() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	@Override
	public int getTamanho() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public HashMap<Integer, Integer> getImagens() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setImagens(HashMap<Integer, Integer> barcoTamanho1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HashMap<Integer, Integer> getImagensOff() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setImagensOff(HashMap<Integer, Integer> imagensOff) {
		// TODO Auto-generated method stub
		
	}





}
