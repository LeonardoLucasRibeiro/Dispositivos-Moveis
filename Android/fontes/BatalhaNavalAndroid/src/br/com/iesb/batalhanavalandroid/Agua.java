package br.com.iesb.batalhanavalandroid;

import java.util.List;


public class Agua implements ElementosInterface{

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



}
