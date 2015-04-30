package br.com.iesb.batalhanavalandroid;

import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class DoisJogadoresActivity extends MainActivity {


	private BatalhaAdapater<ElementosInterface> artilhariaAdapterCampoA; 
	private BatalhaAdapater<ElementosInterface> artilhariaAdapterCampoB;
	private List<Artilharia> 						lsitaArtilhariaCampoA;
	private List<Artilharia> 						lsitaArtilhariaCampoB; 

	
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
	    setVezJogadorA(true);
	    setVezJogadorB(false);
	    
	    GridView gridviewCampoA = (GridView) findViewById(artilhariaAdapterCampoA.getResourceGrid());
	    ImageAdapter imageAdapter = new ImageAdapter(this);
	    imageAdapter.iniciaMontaThumbs();
	    gridviewCampoA.setAdapter(imageAdapter);
	    gridviewCampoA.setOnItemClickListener(new OnItemClickListener() {
	    	public void onItemClick(AdapterView<?> parent, View v,int position, long id) {
	    		if(isVezJogadorA()){
	    			analisaTiro(parent, v, position, id, artilhariaAdapterCampoA, lsitaArtilhariaCampoA, DoisJogadoresActivity.this);
	    		}
	        }
	    });
	    
	    
	    GridView gridviewCampoB = (GridView) findViewById(artilhariaAdapterCampoB.getResourceGrid());
	    ImageAdapter imageAdapter2 = new ImageAdapter(this);
	    imageAdapter2.iniciaMontaThumbs();
	    gridviewCampoB.setAdapter(imageAdapter2);

	    gridviewCampoB.setOnItemClickListener(new OnItemClickListener() {
	    	public void onItemClick(AdapterView<?> parent, View v,int position, long id) {
	    		if(isVezJogadorB()){
	    			analisaTiro(parent, v, position, id, artilhariaAdapterCampoB, lsitaArtilhariaCampoB, DoisJogadoresActivity.this);
	    		}	

	        }
	    });

	}
}
