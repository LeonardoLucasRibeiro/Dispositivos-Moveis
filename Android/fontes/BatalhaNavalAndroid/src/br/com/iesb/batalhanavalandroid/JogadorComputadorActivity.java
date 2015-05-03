package br.com.iesb.batalhanavalandroid;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class JogadorComputadorActivity extends MainActivity {


	private BatalhaAdapater<ElementosInterface>		artilhariaAdapterCampoA; 
	private BatalhaAdapater<ElementosInterface> 	artilhariaAdapterCampoB;
	private List<Artilharia> 						lsitaArtilhariaCampoA;
	private List<Artilharia> 						lsitaArtilhariaCampoB; 
	private GridView gridviewCampoB;
	private List<Integer> 							tirosComputador;
	private List<Integer> 							direcaoTirosComputador;
	private int tiroAcertoDeOrigem					= -1;						
	private int tiroAcertoCorrente					= -1;
	
	
	
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);

	    criaHashMapBarcos();
	    iniciaArtilhariaJogador1();
	    iniciaArtilhariaJogador2();
	    
	    artilhariaAdapterCampoA = getArtilhariaAdapterCampoA(); 
		artilhariaAdapterCampoB = getArtilhariaAdapterCampoB();
		lsitaArtilhariaCampoA   = getLsitaArtilhariaCampoA();
		lsitaArtilhariaCampoB	= getLsitaArtilhariaCampoB();
		
		tirosComputador			=	new ArrayList<Integer>();
		direcaoTirosComputador	=	new ArrayList<Integer>();

		
	    setVezJogadorA(true);
	    setVezJogadorB(false);
	    
	    // Campo de Batalha do Jogador
	    GridView gridviewCampoA = (GridView) findViewById(artilhariaAdapterCampoA.getResourceGrid());
	    ImageAdapter imageAdapter = new ImageAdapter(this);
	    imageAdapter.iniciaMontaThumbs();
	    gridviewCampoA.setAdapter(imageAdapter);
	    gridviewCampoA.setOnItemClickListener(new OnItemClickListener() {
	    	public void onItemClick(AdapterView<?> parent, View v,int position, long id) {
	    		if(isVezJogadorA()){
	    				analisaTiro(parent, v, position, id, artilhariaAdapterCampoA, lsitaArtilhariaCampoA, JogadorComputadorActivity.this);
	    		 
	
		    		 Thread thread = new Thread() {          
		              public void run() {
			    				
			    				runOnUiThread(new Runnable() {  
			                        @Override
			                        public void run() {
			                        	if(isVezJogadorB()){
			                        		try {
			    								sleep(2000);
			    							} catch (InterruptedException e) {
			    								// TODO Auto-generated catch block
			    								e.printStackTrace();
			    							}
											jogadaComputador();
											
			                        	}	
			                        }
		                        });
			    			
			              };
			          };
			          thread.start();
	    			
	    			
	    		}
	        }
	    	
	    	
	    	
	    });
	    
	    //Campo de Batalha do Computador 
	    gridviewCampoB = (GridView) findViewById(artilhariaAdapterCampoB.getResourceGrid());
	    ImageAdapter imageAdapter2 = new ImageAdapter(this);
	    imageAdapter2.iniciaMontaThumbs();
	    imageAdapter2.iniciaMontaThumbsJogador(lsitaArtilhariaCampoB);
	    gridviewCampoB.setAdapter(imageAdapter2);
	    
	   
//	    
//	    Thread thread = new Thread() {          
//            public void run() {
//                boolean isComputadorJoga = true;
//           
//                    while(isComputadorJoga) {
//                        runOnUiThread(new Runnable() {  
//	                        @Override
//	                        public void run() {
//	                        	if(isVezJogadorB()){
//										jogadaComputador();
//	                        	}	
//	                        }
//                        });
//                    }
//            };
//        };
//        thread.start();	
	
	    
	  
	}
	
	
	public void jogadaComputador(){
			String	tiro	=	"";	 	
    		int 	num		=	(int) ( Math.random() * 100);
    		
    		//Só entra nesta lógica se tiver carregado o direcionador para o Computador
    		if(!direcaoTirosComputador.isEmpty()){
    			num = tiroAcertoCorrente + (direcaoTirosComputador.get(0));
    		}
    		
    		
    		System.out.println(num);
    		System.out.println(tirosComputador);
    		
    		//Controle para o coputador não atirar mais em água e em destroços
    		if(tirosComputador.contains(num) ){
    			if(!direcaoTirosComputador.isEmpty()){
					direcaoTirosComputador.remove(0);
					tiroAcertoCorrente = tiroAcertoDeOrigem;
				}
    			jogadaComputador();
    			return;
    		}
    		////#############FAZER A LÓGICA DE QUEBRA DE LINIHA#######################
    		else if(  num < 0 	|| 	num >= (artilhariaAdapterCampoB.getTamanhoCampoBatalha() * artilhariaAdapterCampoB.getTamanhoCampoBatalha())  ){
    			if(!direcaoTirosComputador.isEmpty()){
					direcaoTirosComputador.remove(0);
					tiroAcertoCorrente = tiroAcertoDeOrigem;
				}
    			jogadaComputador();
    			return;
    		}else{
    			tirosComputador.add(num);
    			tiro = analisaTiroComputador(num, artilhariaAdapterCampoB, lsitaArtilhariaCampoB, JogadorComputadorActivity.this);
    			
    			if(tiro.equals("Acertou")){
    				if(direcaoTirosComputador.isEmpty()){
	    				direcaoTirosComputador.add(1);
	    				direcaoTirosComputador.add(-1);
	    				direcaoTirosComputador.add(10);
	    				direcaoTirosComputador.add(-10);
	    				//Se a lista está vazia e acertei quer dizer este foi meu primeiro acerto em uma nova artilharia
	    				tiroAcertoDeOrigem = num;
	    				tiroAcertoCorrente = num;	
    				}else{
    					tiroAcertoCorrente = tirosComputador.get(tirosComputador.size()-1);
    				}	
    			}else if(tiro.equals("")){
    				if(!direcaoTirosComputador.isEmpty()){
    					direcaoTirosComputador.remove(0);
    					tiroAcertoCorrente = tiroAcertoDeOrigem;
    				}	
    			}else if(tiro.equals("Eliminou")){
    				if(!direcaoTirosComputador.isEmpty()){
    					direcaoTirosComputador.removeAll(direcaoTirosComputador);
    					tiroAcertoDeOrigem = -1;
    					tiroAcertoCorrente = -1;
    				}	
    			}
    			
    		}
	}

}
