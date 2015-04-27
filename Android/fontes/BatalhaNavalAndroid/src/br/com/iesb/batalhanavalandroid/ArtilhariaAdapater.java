package br.com.iesb.batalhanavalandroid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class ArtilhariaAdapater <T extends ArtilhariaInterface>{
	
	private List<T> campoBatalha;
	private int 	tamanhoCampoBatalha;
	private HashMap<String, Integer> referenciaAlfaNumerica; 
	private Destrocos destroco;	

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
	
	public ArtilhariaAdapater(){
		
	}
	
	public ArtilhariaAdapater(int tamanho){
		tamanhoCampoBatalha		=	tamanho;
		campoBatalha 			=	new ArrayList<T>();
		referenciaAlfaNumerica	=	new HashMap<String, Integer>();
		destroco				=	new Destrocos();
		int itensCampoBatalha	=	tamanhoCampoBatalha * tamanhoCampoBatalha;		
		for(int i=0;i<itensCampoBatalha;i++){
			campoBatalha.add(null);
		}
		referenciaAlfaNumerica.put("A", 0);
		referenciaAlfaNumerica.put("B", 1);
		referenciaAlfaNumerica.put("C", 2);
		referenciaAlfaNumerica.put("D", 3);
		referenciaAlfaNumerica.put("E", 4);
		referenciaAlfaNumerica.put("F", 5);
		referenciaAlfaNumerica.put("G", 6);
		referenciaAlfaNumerica.put("H", 7);
		referenciaAlfaNumerica.put("I", 8);
		referenciaAlfaNumerica.put("J", 9);
		
	}
	public void adicionaArtilharia(T artilharia){
		artilharia.distribuiArtilharia(this);
		for(String item : artilharia.getPosicoes()){
			campoBatalha.set(Integer.parseInt(item), artilharia);	
		}
	}
	public String analisaTiro(int  tentativa, List<Artilharia> lista){
			String retorno	=	"";
			int referencia;
			referencia		=	tentativa;
			

			if(campoBatalha.get(referencia) instanceof Artilharia){
				T	artilharia = campoBatalha.get(referencia);
				
				
				if(campoBatalha.get(referencia) instanceof Destrocos){
					retorno =  "Destroco";
				}else{
					campoBatalha.set(referencia,    (T) destroco );
					if(!campoBatalha.contains(artilharia)){
						retorno =  "Uauuuu!!!! Voce acabou de destruir totalmente o meu "+artilharia.getTipo()+" - "+artilharia.getNome();
						System.out.println("Uauuuu!!!! Voce acabou de destruir totalmente o meu "+artilharia.getTipo()+" - "+artilharia.getNome());
					}else{
						retorno =  "Acertou";
						System.out.println("Você acabou de acertar uma parte do meu "+artilharia.getTipo()+" - "+artilharia.getNome());
					}
					
				}
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
//		if(fimJogo){
//			System.out.println("######## FIM ##########");
//			System.out.println("ParabŽs voc� destruiu todos!!!!");
//		}
	}
	public void desenhaCampoBatalha(List<Artilharia> lista){
		
		HashMap<Integer, String> referenciaAlfaNumericaInversa	=	new HashMap<Integer, String>();
		referenciaAlfaNumericaInversa.put(0,"A");
		referenciaAlfaNumericaInversa.put(1,"B");
		referenciaAlfaNumericaInversa.put(2,"C");
		referenciaAlfaNumericaInversa.put(3,"D");
		referenciaAlfaNumericaInversa.put(4,"E");
		referenciaAlfaNumericaInversa.put(5,"F");
		referenciaAlfaNumericaInversa.put(6,"G");
		referenciaAlfaNumericaInversa.put(7,"H");
		referenciaAlfaNumericaInversa.put(8,"I");
		referenciaAlfaNumericaInversa.put(9,"J");
		
		
		
		int itensCampoBatalha	=	campoBatalha.size();
		System.out.println("");
		System.out.println("");
		System.out.print("   ");
		for(int a=0;a<81;a++){
			System.out.print("_");
		}
		System.out.println("");
		for(int i=0;i<itensCampoBatalha;i++){
			String desenhoCampo	=	"";		
			if(campoBatalha.get(i) == null){
				desenhoCampo = "      ";
				for(Artilharia item : lista){
					if(item.getPosicoes().contains(i+"")){
						desenhoCampo = "   X  ";		
					}	
				}
			}else{
				desenhoCampo = "  "+campoBatalha.get(i).getSigla()+"  ";
			}
			
			
			
			
			
			if((i)%getTamanhoCampoBatalha()  == 0){
				System.out.print(referenciaAlfaNumericaInversa.get(i/tamanhoCampoBatalha)+"  ");
			}
			System.out.print("| "+desenhoCampo);		
			if(  (i+1)%getTamanhoCampoBatalha()  == 0 ){
				System.out.print("|");
				System.out.println("");
				System.out.print("   ");
				for(int a=0;a<81;a++){
					System.out.print("_");
				}	
				System.out.println("");
			}
			
		}
		System.out.println("");
		System.out.print("    ");
		for(int i=1;i<=tamanhoCampoBatalha;i++){
			String desenhoCampo;
			desenhoCampo = "  "+i+"     ";
			System.out.print(desenhoCampo);
		}
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
	}
}
