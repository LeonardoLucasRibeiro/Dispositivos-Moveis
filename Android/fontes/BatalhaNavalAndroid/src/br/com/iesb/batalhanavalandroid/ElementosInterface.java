package br.com.iesb.batalhanavalandroid;

import java.util.HashMap;
import java.util.List;


public interface ElementosInterface {
	public void distribuiElementos(BatalhaAdapater objArtilhariaAdapter);
	public List<String> getPosicoes();
	public String getTipo();
	public String getNome();
	public String getSigla();
	public String getSituacao();
	public int getTamanho();
	public void setSituacao(String situacao);
	
	public HashMap<Integer, Integer> getImagens();
	public void setImagens(HashMap<Integer, Integer> barcoTamanho1);
	public HashMap<Integer, Integer> getImagensOff();
	public void setImagensOff(HashMap<Integer, Integer> imagensOff);
}
