package br.com.iesb.batalhanavalandroid;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ArtilhariaAdapater<ArtilhariaInterface> artilhariaAdapter;
	private List<Artilharia> 						lsitaArtilharia; 
	
	private ArtilhariaAdapater<ArtilhariaInterface> artilhariaAdapter2;
	private List<Artilharia> 						lsitaArtilharia2; 
	
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);
	    this.iniciaArtilhariaJogador1();
	    this.iniciaArtilhariaJogador2();
	    
	    
	    GridView gridview = (GridView) findViewById(R.id.gridview);
	    gridview.setAdapter(new ImageAdapter(this));
	    
	    
	    gridview.setOnItemClickListener(new OnItemClickListener() {
	    	public void onItemClick(AdapterView<?> parent, View v,int position, long id) {
	    		ImageAdapter  img 	= (ImageAdapter) parent.getAdapter();
	            String tiro = artilhariaAdapter.analisaTiro(position,lsitaArtilharia);
	            int imagem	= R.drawable.teste3;	
	            if(!tiro.equals("")){
	            	imagem	= R.drawable.error;
	            	if(tiro.equals("Acertou")){
	            		//Toast.makeText(MainActivity.this, "Na Mosca" ,Toast.LENGTH_SHORT).show();
	            	}else if(tiro.equals("Destroco")){
	            		//Toast.makeText(MainActivity.this, "Flamengo é cachorro morto!!!" ,Toast.LENGTH_SHORT).show();
	            		//Toast.makeText(MainActivity.this, "Não precisa atirar de novo, no mesmo lugar..." ,Toast.LENGTH_LONG).show();
	            	}else{
	            		explosao();
	            		Toast.makeText(MainActivity.this, "" + tiro.toString(),Toast.LENGTH_LONG).show();	            		
	            	}
	            }
	            img.setImageView(v,imagem);
				if(artilhariaAdapter.analisaCampoBatalha(lsitaArtilharia)){
					Toast.makeText(MainActivity.this, "######## JOGADOR 2 CAMPEÃO #########" ,Toast.LENGTH_LONG).show();
				}	
	        }
	    });
	    
	    
	    GridView gridview2 = (GridView) findViewById(R.id.gridview2);
	    gridview2.setAdapter(new ImageAdapter(this));
	    
	    
	    gridview2.setOnItemClickListener(new OnItemClickListener() {
	    	public void onItemClick(AdapterView<?> parent, View v,int position, long id) {
	    		ImageAdapter  img 	= (ImageAdapter) parent.getAdapter();
	            String tiro = artilhariaAdapter2.analisaTiro(position,lsitaArtilharia2);
	            int imagem	= R.drawable.teste3;	
	            if(!tiro.equals("")){
	            	imagem	= R.drawable.error;
	            	if(tiro.equals("Acertou")){
	            		//Toast.makeText(MainActivity.this, "Na Mosca" ,Toast.LENGTH_SHORT).show();
	            	}else if(tiro.equals("Destroco")){
//	            		Toast.makeText(MainActivity.this, "Flamengo é cachorro morto!!!" ,Toast.LENGTH_SHORT).show();
//	            		Toast.makeText(MainActivity.this, "Não precisa atirar de novo, no mesmo lugar..." ,Toast.LENGTH_LONG).show();
	            	}else{
	            		explosao();
	            		Toast.makeText(MainActivity.this, "" + tiro.toString(),Toast.LENGTH_LONG).show();	            		
	            	}
	            }
	            img.setImageView(v,imagem);
				if(artilhariaAdapter2.analisaCampoBatalha(lsitaArtilharia2)){
					Toast.makeText(MainActivity.this, "######## JOGADOR 1 CAMPEÃO #########" ,Toast.LENGTH_LONG).show();
				}	
	        }
	    });
	    
	    
	   
	    
	  
	}
	
	
	public void explosao(){
		MediaPlayer musica = MediaPlayer.create(this, R.raw.explosao);
	    musica.start();
	}
	
	public void fim(){
		MediaPlayer musica = MediaPlayer.create(this, R.raw.hino);
	    musica.start();
	}

	
	private void iniciaArtilhariaJogador1(){
		
		artilhariaAdapter	= new ArtilhariaAdapater<ArtilhariaInterface>(10);
		lsitaArtilharia 	= new ArrayList<Artilharia>();
		
		//1 porta aviões
		PortaAvioes portaAviao = new PortaAvioes();
		portaAviao.setNome("Derruba Flamenguistas");
		portaAviao.setSigla("P1");
		portaAviao.setTamanho(3);
		artilhariaAdapter.adicionaArtilharia(portaAviao);
		lsitaArtilharia.add(portaAviao);
		
		//1 navio de 4 canos
		Navios navio01	=	new Navios();	
		navio01.setNome("Avalanche Vascaina");
		navio01.setSigla("N1");
		navio01.setTamanho(4);
		artilhariaAdapter.adicionaArtilharia(navio01);
		lsitaArtilharia.add(navio01);
		
		//2 navios de 3 canos
		Navios navio02	=	new Navios();	
		navio02.setNome("Trem Bala Vascaíno");
		navio02.setSigla("N2");
		navio02.setTamanho(3);
		artilhariaAdapter.adicionaArtilharia(navio02);
		lsitaArtilharia.add(navio02);
		
		Navios navio03	=	new Navios();	
		navio03.setNome("Edmundo Animal");
		navio03.setSigla("N3");
		navio03.setTamanho(3);
		artilhariaAdapter.adicionaArtilharia(navio03);
		lsitaArtilharia.add(navio03);
		
		
		//3 navios de 2 canos
		Navios navio04	=	new Navios();	
		navio04.setNome("Juniho Pernambucano Reizinho da Colina");
		navio04.setSigla("N4");
		navio04.setTamanho(2);
		artilhariaAdapter.adicionaArtilharia(navio04);
		lsitaArtilharia.add(navio04);
		
		Navios navio05	=	new Navios();	
		navio05.setNome("Gigante da Colina");
		navio05.setSigla("N5");
		navio05.setTamanho(2);
		artilhariaAdapter.adicionaArtilharia(navio05);
		lsitaArtilharia.add(navio05);
		
		Navios navio06	=	new Navios();	
		navio06.setNome("Caldeirão de São Jenuário");
		navio06.setSigla("N6");
		navio06.setTamanho(2);
		artilhariaAdapter.adicionaArtilharia(navio06);
		lsitaArtilharia.add(navio06);
		
		
		//4 navios de 1 cano
		Navios navio07	=	new Navios();	
		navio07.setNome("Menguinho");
		navio07.setSigla("N7");
		navio07.setTamanho(1);
		artilhariaAdapter.adicionaArtilharia(navio07);
		lsitaArtilharia.add(navio07);
		
		Navios navio08	=	new Navios();	
		navio08.setNome("Fraaaamengoooo");
		navio08.setSigla("N8");
		navio08.setTamanho(1);
		artilhariaAdapter.adicionaArtilharia(navio08);
		lsitaArtilharia.add(navio08);
		
		Navios navio09	=	new Navios();	
		navio09.setNome("Juiz é jogador do Menguinho");
		navio09.setSigla("N9");
		navio09.setTamanho(1);
		artilhariaAdapter.adicionaArtilharia(navio09);
		lsitaArtilharia.add(navio09);
		
		Navios navio10	=	new Navios();	
		navio10.setNome("Uma vez framengo, NUNCA mais framengo");
		navio10.setSigla("N0");
		navio10.setTamanho(1);
		artilhariaAdapter.adicionaArtilharia(navio10);
		lsitaArtilharia.add(navio10);
	}
	
	
private void iniciaArtilhariaJogador2(){
		
		artilhariaAdapter2	= new ArtilhariaAdapater<ArtilhariaInterface>(10);
		lsitaArtilharia2 	= new ArrayList<Artilharia>();
		
		//1 porta aviões
		PortaAvioes portaAviao = new PortaAvioes();
		portaAviao.setNome("TopGun");
		portaAviao.setSigla("P1");
		portaAviao.setTamanho(3);
		artilhariaAdapter2.adicionaArtilharia(portaAviao);
		lsitaArtilharia2.add(portaAviao);
		
		//1 navio de 4 canos
		Navios navio01	=	new Navios();	
		navio01.setNome("Asas Indomáveis");
		navio01.setSigla("N1");
		navio01.setTamanho(4);
		artilhariaAdapter2.adicionaArtilharia(navio01);
		lsitaArtilharia2.add(navio01);
		
		//2 navios de 3 canos
		Navios navio02	=	new Navios();	
		navio02.setNome("Rocky V");
		navio02.setSigla("N2");
		navio02.setTamanho(3);
		artilhariaAdapter2.adicionaArtilharia(navio02);
		lsitaArtilharia2.add(navio02);
		
		Navios navio03	=	new Navios();	
		navio03.setNome("American Pie");
		navio03.setSigla("N3");
		navio03.setTamanho(3);
		artilhariaAdapter2.adicionaArtilharia(navio03);
		lsitaArtilharia2.add(navio03);
		
		
		//3 navios de 2 canos
		Navios navio04	=	new Navios();	
		navio04.setNome("Tropa de Elite I");
		navio04.setSigla("N4");
		navio04.setTamanho(2);
		artilhariaAdapter2.adicionaArtilharia(navio04);
		lsitaArtilharia2.add(navio04);
		
		Navios navio05	=	new Navios();	
		navio05.setNome("Tropa de Elite 2");
		navio05.setSigla("N5");
		navio05.setTamanho(2);
		artilhariaAdapter2.adicionaArtilharia(navio05);
		lsitaArtilharia2.add(navio05);
		
		Navios navio06	=	new Navios();	
		navio06.setNome("Cidade de Deus");
		navio06.setSigla("N6");
		navio06.setTamanho(2);
		artilhariaAdapter2.adicionaArtilharia(navio06);
		lsitaArtilharia2.add(navio06);
		
		
		//4 navios de 1 cano
		Navios navio07	=	new Navios();	
		navio07.setNome("Velozes e furiosos");
		navio07.setSigla("N7");
		navio07.setTamanho(1);
		artilhariaAdapter2.adicionaArtilharia(navio07);
		lsitaArtilharia2.add(navio07);
		
		Navios navio08	=	new Navios();	
		navio08.setNome("O grande dagrão branco");
		navio08.setSigla("N8");
		navio08.setTamanho(1);
		artilhariaAdapter2.adicionaArtilharia(navio08);
		lsitaArtilharia2.add(navio08);
		
		Navios navio09	=	new Navios();	
		navio09.setNome("Surf Sessions");
		navio09.setSigla("N9");
		navio09.setTamanho(1);
		artilhariaAdapter2.adicionaArtilharia(navio09);
		lsitaArtilharia2.add(navio09);
		
		Navios navio10	=	new Navios();	
		navio10.setNome("Paracuru");
		navio10.setSigla("N0");
		navio10.setTamanho(1);
		artilhariaAdapter2.adicionaArtilharia(navio10);
		lsitaArtilharia2.add(navio10);
	}
	
	
}
