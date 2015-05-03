package br.com.iesb.batalhanavalandroid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private BatalhaAdapater<ElementosInterface> artilhariaAdapterCampoA; 
	private BatalhaAdapater<ElementosInterface> artilhariaAdapterCampoB;
	private List<Artilharia> 						lsitaArtilhariaCampoA;
	private List<Artilharia> 						lsitaArtilhariaCampoB; 
	private boolean vezJogadorA;
	private boolean vezJogadorB;
	
	static List<Integer> barcoTamanho1;
	static List<Integer> barcoTamanho2;
	static List<Integer> barcoTamanho3;
	static List<Integer> barcoTamanho4;
	
	static List<Integer> portaAvioes;
	
	
	static List<Integer> barcoTamanho1_Off;
	static List<Integer> barcoTamanho2_Off;
	static List<Integer> barcoTamanho3_Off;
	static List<Integer> barcoTamanho4_Off;

	static List<Integer> portaAvioes_Off;
	
	public BatalhaAdapater<ElementosInterface> getArtilhariaAdapterCampoA() {
		return artilhariaAdapterCampoA;
	}
	public void setArtilhariaAdapterCampoA(
			BatalhaAdapater<ElementosInterface> artilhariaAdapterCampoA) {
		this.artilhariaAdapterCampoA = artilhariaAdapterCampoA;
	}
	public BatalhaAdapater<ElementosInterface> getArtilhariaAdapterCampoB() {
		return artilhariaAdapterCampoB;
	}
	public void setArtilhariaAdapterCampoB(
			BatalhaAdapater<ElementosInterface> artilhariaAdapterCampoB) {
		this.artilhariaAdapterCampoB = artilhariaAdapterCampoB;
	}
	public List<Artilharia> getLsitaArtilhariaCampoA() {
		return lsitaArtilhariaCampoA;
	}
	public void setLsitaArtilhariaCampoA(List<Artilharia> lsitaArtilhariaCampoA) {
		this.lsitaArtilhariaCampoA = lsitaArtilhariaCampoA;
	}
	public List<Artilharia> getLsitaArtilhariaCampoB() {
		return lsitaArtilhariaCampoB;
	}
	public void setLsitaArtilhariaCampoB(List<Artilharia> lsitaArtilhariaCampoB) {
		this.lsitaArtilhariaCampoB = lsitaArtilhariaCampoB;
	}
	public boolean isVezJogadorA() {
		return vezJogadorA;
	}
	public void setVezJogadorA(boolean vezJogadorA) {
		this.vezJogadorA = vezJogadorA;
	}
	public boolean isVezJogadorB() {
		return vezJogadorB;
	}
	public void setVezJogadorB(boolean vezJogadorB) {
		this.vezJogadorB = vezJogadorB;
	}

	
	public void analisaTiro(AdapterView<?> parent, View v,int position, long id, 
			BatalhaAdapater<ElementosInterface> artilhariaAdapterCampo, 
			List<Artilharia> lsitaArtilhariaCampo,
			Context context) {

			ImageAdapter  img 			= (ImageAdapter) parent.getAdapter();
			ElementosInterface elemnto 	= artilhariaAdapterCampo.analisaTiro(position);
			int imagem					= R.drawable.agua;
	        String tiro					= ""; 
	        
	        if(elemnto instanceof ElementosInterface){		
	        		tiro = elemnto.getSituacao();
	        }

	        if(!tiro.equals("")){
				if(tiro.equals("Acertou")){
					imagem	= R.drawable.error;
					img.setmThumbId(position, imagem);
					img.setImageView(v,imagem);
				}else if(tiro.equals("Destroco")){
					//imagem	= R.drawable.error;
				}else if(tiro.equals("Agua")){
					//imagem	= R.drawable.agua;
				}else{
					explosao();
					//Toast.makeText(context, "" + "FOI DESTRUIDO O "+elemnto.getTipo().toUpperCase()+" - "+elemnto.getNome().toUpperCase(),Toast.LENGTH_SHORT).show();
					GridView gridview = (GridView) findViewById(artilhariaAdapterCampo.getResourceGrid());
					for(String item : elemnto.getPosicoes()){
						imagem = elemnto.getImagensOff().get(Integer.parseInt(item));
						img.setmThumbId(Integer.parseInt(item), imagem);
		    		}
					gridview.setAdapter(img);
				}
			}else{
				img.setmThumbId(position, imagem);
				img.setImageView(v,imagem);
				setVezJogadorA(!isVezJogadorA());
				//setVezJogadorB(!isVezJogadorB());
			}
	        
			//Verifica se todos os objetos foram destruios no campo de guerra em questão
			if(artilhariaAdapterCampo.analisaCampoBatalha(lsitaArtilhariaCampo)){
				Toast.makeText(context, "######## "+artilhariaAdapterCampo.getNomeJogador()+" CAMPEÃO #########" ,Toast.LENGTH_LONG).show();
			}	
	}

	
	public String analisaTiroComputador(
										int position, 
										BatalhaAdapater<ElementosInterface> artilhariaAdapterCampo, 
										List<Artilharia> lsitaArtilhariaCampo,
										Context context) {

			
			GridView gridview 			= (GridView) findViewById(artilhariaAdapterCampo.getResourceGrid());
			ImageAdapter  img 			= (ImageAdapter) gridview.getAdapter();
			ElementosInterface elemnto 	= artilhariaAdapterCampo.analisaTiro(position);
			int imagem					= R.drawable.agua;
	        String tiro					= ""; 
	        
	        if(elemnto instanceof ElementosInterface){		
	        		tiro = elemnto.getSituacao();
	        }

	        if(!tiro.equals("")){
				if(tiro.equals("Acertou")){
					imagem	= R.drawable.error;
					img.setmThumbId(position, imagem);
				}else if(tiro.equals("Destroco")){
					
				}else if(tiro.equals("Agua")){
					
				}else{
					//Toast.makeText(context, "" + "FOI DESTRUIDO O  "+elemnto.getTipo().toUpperCase()+" - "+elemnto.getNome().toUpperCase(),Toast.LENGTH_SHORT).show();
					//Chama o som de explosão, neste caso quando um aartilharia é totalmente destruida.
					explosao();
					//Monta as imagens da Artilharia totalmente destruida
					for(String item : elemnto.getPosicoes()){
						imagem = elemnto.getImagensOff().get(Integer.parseInt(item));
						img.setmThumbId(Integer.parseInt(item), imagem);
		    		}
				}
			}else{
				setVezJogadorA(!isVezJogadorA());
				setVezJogadorB(!isVezJogadorB());
				img.setmThumbId(position, imagem);
			}
	        
	        //Desenha os objetos (imagens) na Grid de acordo com o array de imagens
	        gridview.setAdapter(img);
			//Verifica se todos os objetos foram destruios no campo de guerra em questão
			if(artilhariaAdapterCampo.analisaCampoBatalha(lsitaArtilhariaCampo)){
				Toast.makeText(context, "######## "+artilhariaAdapterCampo.getNomeJogador()+" CAMPEÃO #########" ,Toast.LENGTH_LONG).show();
			}	
		
			return tiro;
	}
	
	
	
	public void explosao(){
		MediaPlayer musica = MediaPlayer.create(this, R.raw.explosao);
	    musica.start();
	}
	
	

	
	public void iniciaArtilhariaJogador1(){
		
		artilhariaAdapterCampoA	= new BatalhaAdapater<ElementosInterface>(10);
		lsitaArtilhariaCampoA 	= new ArrayList<Artilharia>();
		artilhariaAdapterCampoA.setNomeJogador("Jogador 1");
		artilhariaAdapterCampoA.setResourceGrid(R.id.gridview);
		
		//1 porta avioes
		PortaAvioes portaAviao = new PortaAvioes();
		portaAviao.setNome("Derruba Flamenguistas");
		portaAviao.setSigla("P1");
		portaAviao.setTamanho(3);
		artilhariaAdapterCampoA.adicionaArtilharia(portaAviao);
		lsitaArtilhariaCampoA.add(portaAviao);
		
		//1 navio de 4 canos
		Navios navio01	=	new Navios();	
		navio01.setNome("Avalanche Vascaína");
		navio01.setSigla("N1");
		navio01.setTamanho(4);
		artilhariaAdapterCampoA.adicionaArtilharia(navio01);
		lsitaArtilhariaCampoA.add(navio01);
		
		//2 navios de 3 canos
		Navios navio02	=	new Navios();	
		navio02.setNome("Trem Bala Vascaíno");
		navio02.setSigla("N2");
		navio02.setTamanho(3);
		artilhariaAdapterCampoA.adicionaArtilharia(navio02);
		lsitaArtilhariaCampoA.add(navio02);
		
		Navios navio03	=	new Navios();	
		navio03.setNome("Edmundo Animal");
		navio03.setSigla("N3");
		navio03.setTamanho(3);
		artilhariaAdapterCampoA.adicionaArtilharia(navio03);
		lsitaArtilhariaCampoA.add(navio03);
		
		
		//3 navios de 2 canos
		Navios navio04	=	new Navios();	
		navio04.setNome("Juniho Pernambucano Reizinho da Colina");
		navio04.setSigla("N4");
		navio04.setTamanho(2);
		artilhariaAdapterCampoA.adicionaArtilharia(navio04);
		lsitaArtilhariaCampoA.add(navio04);
		
		Navios navio05	=	new Navios();	
		navio05.setNome("Gigante da Colina");
		navio05.setSigla("N5");
		navio05.setTamanho(2);
		artilhariaAdapterCampoA.adicionaArtilharia(navio05);
		lsitaArtilhariaCampoA.add(navio05);
		
		Navios navio06	=	new Navios();	
		navio06.setNome("Caldeirão de São Jenuário");
		navio06.setSigla("N6");
		navio06.setTamanho(2);
		artilhariaAdapterCampoA.adicionaArtilharia(navio06);
		lsitaArtilhariaCampoA.add(navio06);
		
		
		//4 navios de 1 cano
		Navios navio07	=	new Navios();	
		navio07.setNome("Menguinho");
		navio07.setSigla("N7");
		navio07.setTamanho(1);
		artilhariaAdapterCampoA.adicionaArtilharia(navio07);
		lsitaArtilhariaCampoA.add(navio07);
		
		Navios navio08	=	new Navios();	
		navio08.setNome("Fraaaamengoooo");
		navio08.setSigla("N8");
		navio08.setTamanho(1);
		artilhariaAdapterCampoA.adicionaArtilharia(navio08);
		lsitaArtilhariaCampoA.add(navio08);
		
		Navios navio09	=	new Navios();	
		navio09.setNome("Juiz é jogador do Menguinho");
		navio09.setSigla("N9");
		navio09.setTamanho(1);
		artilhariaAdapterCampoA.adicionaArtilharia(navio09);
		lsitaArtilhariaCampoA.add(navio09);
		
		Navios navio10	=	new Navios();	
		navio10.setNome("Uma vez framengo, NUNCA mais framengo");
		navio10.setSigla("N0");
		navio10.setTamanho(1);
		artilhariaAdapterCampoA.adicionaArtilharia(navio10);
		lsitaArtilhariaCampoA.add(navio10);
		
		setArtilhariaAdapterCampoA(artilhariaAdapterCampoA);
		setLsitaArtilhariaCampoA(lsitaArtilhariaCampoA);
	}
	
	
	public void iniciaArtilhariaJogador2(){
		
		artilhariaAdapterCampoB	= new BatalhaAdapater<ElementosInterface>(10);
		lsitaArtilhariaCampoB 	= new ArrayList<Artilharia>();
		artilhariaAdapterCampoB.setNomeJogador("Jogador 2");
		artilhariaAdapterCampoB.setResourceGrid(R.id.gridview2);
		//1 porta avioes
		PortaAvioes portaAviao = new PortaAvioes();
		portaAviao.setNome("TopGun");
		portaAviao.setSigla("P1");
		portaAviao.setTamanho(3);
		artilhariaAdapterCampoB.adicionaArtilharia(portaAviao);
		lsitaArtilhariaCampoB.add(portaAviao);
		
		//1 navio de 4 canos
		Navios navio01	=	new Navios();	
		navio01.setNome("Asas Indomáveis");
		navio01.setSigla("N1");
		navio01.setTamanho(4);
		artilhariaAdapterCampoB.adicionaArtilharia(navio01);
		lsitaArtilhariaCampoB.add(navio01);
		
		//2 navios de 3 canos
		Navios navio02	=	new Navios();	
		navio02.setNome("Rocky V");
		navio02.setSigla("N2");
		navio02.setTamanho(3);
		artilhariaAdapterCampoB.adicionaArtilharia(navio02);
		lsitaArtilhariaCampoB.add(navio02);
		
		Navios navio03	=	new Navios();	
		navio03.setNome("American Pie");
		navio03.setSigla("N3");
		navio03.setTamanho(3);
		artilhariaAdapterCampoB.adicionaArtilharia(navio03);
		lsitaArtilhariaCampoB.add(navio03);
		
		
		//3 navios de 2 canos
		Navios navio04	=	new Navios();	
		navio04.setNome("Tropa de Elite I");
		navio04.setSigla("N4");
		navio04.setTamanho(2);
		artilhariaAdapterCampoB.adicionaArtilharia(navio04);
		lsitaArtilhariaCampoB.add(navio04);
		
		Navios navio05	=	new Navios();	
		navio05.setNome("Tropa de Elite 2");
		navio05.setSigla("N5");
		navio05.setTamanho(2);
		artilhariaAdapterCampoB.adicionaArtilharia(navio05);
		lsitaArtilhariaCampoB.add(navio05);
		
		Navios navio06	=	new Navios();	
		navio06.setNome("Cidade de Deus");
		navio06.setSigla("N6");
		navio06.setTamanho(2);
		artilhariaAdapterCampoB.adicionaArtilharia(navio06);
		lsitaArtilhariaCampoB.add(navio06);
		
		
		//4 navios de 1 cano
		Navios navio07	=	new Navios();	
		navio07.setNome("Velozes e furiosos");
		navio07.setSigla("N7");
		navio07.setTamanho(1);
		artilhariaAdapterCampoB.adicionaArtilharia(navio07);
		lsitaArtilhariaCampoB.add(navio07);
		
		Navios navio08	=	new Navios();	
		navio08.setNome("O grande dagrão branco");
		navio08.setSigla("N8");
		navio08.setTamanho(1);
		artilhariaAdapterCampoB.adicionaArtilharia(navio08);
		lsitaArtilhariaCampoB.add(navio08);
		
		Navios navio09	=	new Navios();	
		navio09.setNome("Surf Sessions");
		navio09.setSigla("N9");
		navio09.setTamanho(1);
		artilhariaAdapterCampoB.adicionaArtilharia(navio09);
		lsitaArtilhariaCampoB.add(navio09);
		
		Navios navio10	=	new Navios();	
		navio10.setNome("Hawai");
		navio10.setSigla("N0");
		navio10.setTamanho(1);
		artilhariaAdapterCampoB.adicionaArtilharia(navio10);
		lsitaArtilhariaCampoB.add(navio10);
		setArtilhariaAdapterCampoB(artilhariaAdapterCampoB);
		setLsitaArtilhariaCampoB(lsitaArtilhariaCampoB);
	}
	
	
	public void criaHashMapBarcos(){
		
		//Montando as Imagens ON
		
		portaAvioes = new ArrayList<Integer>();
		portaAvioes.add(R.drawable.barco1a);
		
		
		barcoTamanho1 = new ArrayList<Integer>();
		barcoTamanho1.add(R.drawable.barco1_on);
		
		barcoTamanho2 = new ArrayList<Integer>();
		barcoTamanho2.add(R.drawable.barco2a);
		barcoTamanho2.add(R.drawable.barco2b);
		
		barcoTamanho3 = new ArrayList<Integer>();
		barcoTamanho3.add(R.drawable.barco3a);
		barcoTamanho3.add(R.drawable.barco3b);
		barcoTamanho3.add(R.drawable.barco3c);

		barcoTamanho4 = new ArrayList<Integer>();
		barcoTamanho4.add(R.drawable.barco4a);
		barcoTamanho4.add(R.drawable.barco4b);
		barcoTamanho4.add(R.drawable.barco4c);
		barcoTamanho4.add(R.drawable.barco4d);
		
		
		//Montando as Imagens OFF
		
		portaAvioes_Off = new ArrayList<Integer>();
		portaAvioes_Off.add(R.drawable.barco1a_off);
		
		barcoTamanho1_Off = new ArrayList<Integer>();
		barcoTamanho1_Off.add(R.drawable.barco1_off);
		
		barcoTamanho2_Off = new ArrayList<Integer>();
		barcoTamanho2_Off.add(R.drawable.barco2a_off);
		barcoTamanho2_Off.add(R.drawable.barco2b_off);
		
		barcoTamanho3_Off = new ArrayList<Integer>();
		barcoTamanho3_Off.add(R.drawable.barco3a_off);
		barcoTamanho3_Off.add(R.drawable.barco3b_off);
		barcoTamanho3_Off.add(R.drawable.barco3c_off);

		barcoTamanho4_Off = new ArrayList<Integer>();
		barcoTamanho4_Off.add(R.drawable.barco4a_off);
		barcoTamanho4_Off.add(R.drawable.barco4b_off);
		barcoTamanho4_Off.add(R.drawable.barco4c_off);
		barcoTamanho4_Off.add(R.drawable.barco4d_off);

		
		
	}
	
}
