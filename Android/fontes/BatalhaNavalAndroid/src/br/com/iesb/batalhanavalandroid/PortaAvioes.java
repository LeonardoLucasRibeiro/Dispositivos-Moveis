package br.com.iesb.batalhanavalandroid;



public class PortaAvioes extends Artilharia {

	private static final String TIPO = "PORTA AVIÕES";
	private static final String SIGLA = "P";
	public PortaAvioes() {
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
	
		getPosicoes().clear();
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
		}
		if(!validacao){
			distribuiElementos(objArtilhariaAdapter);
		}else{
		
				//##########   Monta asa do Avi‹o ##############
				validacao = true;
				if(direcao == 1){
					direcao	= tamanhoCampoBatalha;
				}else{
					direcao	= 1;
				}
				int tamanhoAsa = this.getTamanho()/2;
				//##########   Asa Esquerda ##################
				for(int i= 0; i<tamanhoAsa;i++){
					referencia	=	referenciaRandomica - direcao;
					//Aqui vou validar se passa dos limites do Campo de batalha 
					//TambŽm validar se Ž uma possivel quebra de linha
					//TambŽm validar se ja existe uma referencia de objeto Artilharia na posi�‹o
					if(
							referencia < 0   || 
							(referenciaRandomica)%tamanhoCampoBatalha == 0 ||
							( (referencia)%tamanhoCampoBatalha == 0 && i < tamanhoAsa-1 ) 	||  
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
				}
				if(!validacao){
					distribuiElementos(objArtilhariaAdapter);
				}else{
					validacao = true;
					//###########  Asa Direita #################
					for(int i= 0; i<tamanhoAsa;i++){
						referencia	=	referenciaRandomica + direcao;
						//Aqui vou validar se passa dos limites do Campo de batalha 
						//TambŽm validar se Ž uma possivel quebra de linha
						//TambŽm validar se ja existe uma referencia de objeto Artilharia na posi�‹o
						if(
								referencia >= itensCampoBatalha     	|| 
								(referenciaRandomica+1)%tamanhoCampoBatalha == 0 ||
								( (referencia+1)%tamanhoCampoBatalha == 0 && i < tamanhoAsa-1 ) 	||  
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
					}
					if(!validacao){
						distribuiElementos(objArtilhariaAdapter);
					}
				}	
		}		
	}
	
	
		

	
}
