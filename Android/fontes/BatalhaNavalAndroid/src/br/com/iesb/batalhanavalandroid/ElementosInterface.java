package br.com.iesb.batalhanavalandroid;

import java.util.List;


public interface ElementosInterface {
	public void distribuiElementos(BatalhaAdapater objArtilhariaAdapter);
	public List<String> getPosicoes();
	public String getTipo();
	public String getNome();
	public String getSigla();
}
