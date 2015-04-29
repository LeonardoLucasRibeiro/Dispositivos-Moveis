package br.com.iesb.batalhanavalandroid;

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
	
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);
	   
	    iniciaArtilhariaJogador1();
	    iniciaArtilhariaJogador2();
	    artilhariaAdapterCampoA = getArtilhariaAdapterCampoA(); 
		artilhariaAdapterCampoB = getArtilhariaAdapterCampoB();
		lsitaArtilhariaCampoA   = getLsitaArtilhariaCampoA();
		lsitaArtilhariaCampoB	= getLsitaArtilhariaCampoB();
		
		
	    setVezJogadorA(true);
	    setVezJogadorB(false);
	    
	    // Campo de Batalha do Computador
	    GridView gridviewCampoA = (GridView) findViewById(artilhariaAdapterCampoA.getResourceGrid());
	    ImageAdapter imageAdapter = new ImageAdapter(this);
	    imageAdapter.iniciaMontaThumbs();
	    gridviewCampoA.setAdapter(imageAdapter);
	    gridviewCampoA.setOnItemClickListener(new OnItemClickListener() {
	    	public void onItemClick(AdapterView<?> parent, View v,int position, long id) {
	    		if(isVezJogadorA()){
	    			analisaTiro(parent, v, position, id, artilhariaAdapterCampoA, lsitaArtilhariaCampoA, JogadorComputadorActivity.this);
	    			//jogadaComputador( (GridView) findViewById(artilhariaAdapterCampoB.getResourceGrid()) );
	    			jogadaComputador();
	    		}
	        }
	    	
	    	
	    });
	    
	    //Campo de Batalha do Jogador 
	    gridviewCampoB = (GridView) findViewById(artilhariaAdapterCampoB.getResourceGrid());
	    ImageAdapter imageAdapter2 = new ImageAdapter(this);
	    imageAdapter2.iniciaMontaThumbs();
	    imageAdapter2.iniciaMontaThumbsJogador(lsitaArtilhariaCampoB);
	    gridviewCampoB.setAdapter(imageAdapter2);
	    
	    gridviewCampoB.setOnItemClickListener(new OnItemClickListener() {
	    	public void onItemClick(AdapterView<?> parent, View v,int position, long id) {
	    		//if(isVezJogadorB()){
	    			analisaTiro(parent, v, position, id, artilhariaAdapterCampoB, lsitaArtilhariaCampoB, JogadorComputadorActivity.this);
	    		//}	

	        }
	    });

	    
	   
	    //gridviewCampoB.performItemClick( gridviewCampoB.getAdapter().getView(1, null, null), 0, gridviewCampoB.getAdapter().getItemId(1)) ;
	    //jogadaComputador(gridviewCampoB);
	    
	    
	}
	
	
	public void jogadaComputador(){
			System.out.println("COMPUTADOR JOGANDO");
			gridviewCampoB.performItemClick( gridviewCampoB.getAdapter().getView(1, null, null), 5, gridviewCampoB.getAdapter().getItemId(1)) ;
	}
	
	
}
