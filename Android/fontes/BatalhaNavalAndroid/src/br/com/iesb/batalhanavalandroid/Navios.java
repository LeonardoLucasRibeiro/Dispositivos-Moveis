package br.com.iesb.batalhanavalandroid;

import java.util.List;



public class Navios  extends Artilharia{

	private static final String TIPO = "NAVIO";
	private static final String SIGLA = "N";
	public Navios() {
		super.setTipo(TIPO); 
		super.setSigla(SIGLA);
	}
	
	
	public void distribuiElementos(BatalhaAdapater objArtilhariaAdapter) {
		int	tamanhoCampoBatalha	=	objArtilhariaAdapter.getTamanhoCampoBatalha();
		int itensCampoBatalha	=	tamanhoCampoBatalha * tamanhoCampoBatalha;
		int	referenciaRandomica	=	(int) ( Math.random() * itensCampoBatalha);
		int	referenciaDirecao	=	(int) ( Math.random() * tamanhoCampoBatalha);
		int	direcao				=	1;
		boolean validacao 		=   true;
		int referencia;

		//Se o randomico de referencia da dire�‹o for êmpar ando em coluna
		if(referenciaDirecao%2 == 1 ){
			direcao	= tamanhoCampoBatalha;
		}
	
		//Por enquanto fica fixo a direção	
		direcao				=	1;
		
		getPosicoes().clear();
		getImagens().clear();
		getImagensOff().clear();
//		List imagens =	null;
//		if(this.getTamanho() == 1){
//			imagens = MainActivity.barcoTamanho1;
//			System.out.println(imagens);
//		}
		//Adiciona ao List de Strings os possiveis candidatos
		for(int i= 0; i<this.getTamanho();i++){
			referencia	=	referenciaRandomica + (i*direcao);
			//Aqui vou validar se passa dos limites do Campo de batalha 
			//TambŽm validar se Ž uma possivel quebra de linha
			//TambŽm validar se ja existe uma referencia de objeto Artilharia na posi�‹o
			if(
					referencia >= itensCampoBatalha     	|| 
					( (referencia+1)%tamanhoCampoBatalha == 0 && i < this.getTamanho()-1 ) 	||  
					objArtilhariaAdapter.getCampoBatalha().get(referencia) instanceof Artilharia 
					
					|| (referencia+1 <itensCampoBatalha 				  && objArtilhariaAdapter.getCampoBatalha().get(referencia+1) instanceof Artilharia)
					|| (referencia-1 >=0								  && objArtilhariaAdapter.getCampoBatalha().get(referencia-1) instanceof Artilharia)
					|| (referencia+tamanhoCampoBatalha <itensCampoBatalha && objArtilhariaAdapter.getCampoBatalha().get(referencia+tamanhoCampoBatalha) instanceof Artilharia)
					|| (referencia-tamanhoCampoBatalha >=0				  && objArtilhariaAdapter.getCampoBatalha().get(referencia-tamanhoCampoBatalha) instanceof Artilharia)
			  ){
					validacao = false;
					break;	
			}
			getPosicoes().add(referencia+"");
			
			
			if(this.getTamanho() ==1){ 
				getImagens().put(  referencia, (Integer) MainActivity.barcoTamanho1.get(i) );
				getImagensOff().put(  referencia, (Integer) MainActivity.barcoTamanho1_Off.get(i) );
			}else if(this.getTamanho() == 2){
				getImagens().put(referencia, (Integer) MainActivity.barcoTamanho2.get(i));
				getImagensOff().put(  referencia, (Integer) MainActivity.barcoTamanho2_Off.get(i) );
			}else if(this.getTamanho() == 3){
				getImagens().put(referencia, (Integer) MainActivity.barcoTamanho3.get(i));
				getImagensOff().put(  referencia, (Integer) MainActivity.barcoTamanho3_Off.get(i) );
			}else{ 
				getImagens().put(referencia, (Integer) MainActivity.barcoTamanho4.get(i));
				getImagensOff().put(  referencia, (Integer) MainActivity.barcoTamanho4_Off.get(i) );
			}	
			
			
		}
		if(!validacao){
			distribuiElementos(objArtilhariaAdapter);
		}
		
	}

}
