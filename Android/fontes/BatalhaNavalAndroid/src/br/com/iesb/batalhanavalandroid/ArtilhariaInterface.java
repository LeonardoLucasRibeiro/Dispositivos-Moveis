package br.com.iesb.batalhanavalandroid;

import java.util.List;


public interface ArtilhariaInterface {
	public void distribuiArtilharia(ArtilhariaAdapater objArtilhariaAdapter);
	public List<String> getPosicoes();
	public String getTipo();
	public String getNome();
	public String getSigla();
}
