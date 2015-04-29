package br.com.iesb.batalhanavalandroid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class BatalhaAdapater <T extends ElementosInterface>{
	
	private List<T> 					campoBatalha;
	private int 						tamanhoCampoBatalha;
	private Destrocos 					destroco;	
	private Agua						agua;
	private String 						nomeJogador;
	private int							resourceGrid;

	
	public int getTamanhoCampoBatalha() {
		return tamanhoCampoBatalha;
	}
	public void setTamanhoCampoBatalha(int tamanhoCampoBatalha) {
		this.tamanhoCampoBatalha = tamanhoCampoBatalha;
	}
	public List<T> getCampoBatalha() {
		return campoBatalha;
	}
	public void setCampoBatalha(List<T> campoBatalha) {
		this.campoBatalha = campoBatalha;
	}
	public String getNomeJogador() {
		return nomeJogador;
	}
	public void setNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}
	public BatalhaAdapater(){
		
	}
	public int getResourceGrid() {
		return resourceGrid;
	}
	public void setResourceGrid(int resourceGrid) {
		this.resourceGrid = resourceGrid;
	}
	
	public BatalhaAdapater(int tamanho){
		tamanhoCampoBatalha		=	tamanho;
		campoBatalha 			=	new ArrayList<T>();
		destroco				=	new Destrocos();
		agua					=	new Agua();
		int itensCampoBatalha	=	tamanhoCampoBatalha * tamanhoCampoBatalha;		
		for(int i=0;i<itensCampoBatalha;i++){
			campoBatalha.add(null);
			//agua.distribuiElementos(this);
		}
	}
	public void adicionaArtilharia(T artilharia){
		artilharia.distribuiElementos(this);
		for(String item : artilharia.getPosicoes()){
			campoBatalha.set(Integer.parseInt(item), artilharia);	
		}
	}
	public ElementosInterface analisaTiro(int  referencia){
			T	artilharia = campoBatalha.get(referencia);
			
			if(artilharia instanceof Artilharia){
					campoBatalha.set(referencia,    (T) destroco );
					if(!campoBatalha.contains(artilharia)){
						artilharia.setSituacao("Eliminou");
						//retorno =  "VOCÊ DESTRUIU O MEU "+artilharia.getTipo().toUpperCase()+" - "+artilharia.getNome().toUpperCase();
						//retorno = "eliminou";
						System.out.println("Uauuuu!!!! Voce acabou de destruir totalmente o meu "+artilharia.getTipo()+" - "+artilharia.getNome());
					}else{
						artilharia.setSituacao("Acertou");
						//retorno =  "Acertou";
						System.out.println("Você acabou de acertar uma parte do meu "+artilharia.getTipo()+" - "+artilharia.getNome());
					}
			}else if(campoBatalha.get(referencia) instanceof Destrocos){
				artilharia.setSituacao("Destroco");
				//retorno =  "Destroco";
			}else if(campoBatalha.get(referencia) instanceof Agua){
				artilharia.setSituacao("Agua");
				//retorno =  "Agua";
			}else{
				campoBatalha.set(referencia,    (T) agua );
				//artilharia = (T) new Agua();
				//artilharia.setSituacao("");
			}
			
			
			return artilharia;
	}	
	
	
	public String analisaTiro___(int  referencia){
		String retorno	=	"";
		if(campoBatalha.get(referencia) instanceof Artilharia){
				T	artilharia = campoBatalha.get(referencia);
				campoBatalha.set(referencia,    (T) destroco );
				if(!campoBatalha.contains(artilharia)){
					retorno =  "VOCÊ DESTRUIU O MEU "+artilharia.getTipo().toUpperCase()+" - "+artilharia.getNome().toUpperCase();
					System.out.println("Uauuuu!!!! Voce acabou de destruir totalmente o meu "+artilharia.getTipo()+" - "+artilharia.getNome());
				}else{
					retorno =  "Acertou";
					System.out.println("Você acabou de acertar uma parte do meu "+artilharia.getTipo()+" - "+artilharia.getNome());
				}
		}else if(campoBatalha.get(referencia) instanceof Destrocos){
			retorno =  "Destroco";
		}else if(campoBatalha.get(referencia) instanceof Agua){
			retorno =  "Agua";
		}else{
			campoBatalha.set(referencia,    (T) agua );
		}
		return retorno;
	}
	public boolean analisaCampoBatalha(List<Artilharia> lista){
		boolean fimJogo = 	true;
		for(Artilharia item : lista){
			if(campoBatalha.contains(item)){
				fimJogo  = false;
				break;
			}
		}
		return fimJogo;
	}
	
}
