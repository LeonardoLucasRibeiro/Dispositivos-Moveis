package br.com.iesb.batalhanavalandroid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
	
//		public static void main (String args[]){	
//			
//			ArtilhariaAdapater<ArtilhariaInterface> artilhariaAdapter	= new ArtilhariaAdapater<ArtilhariaInterface>(10);
//
//			List<Artilharia> lsitaArtilharia = new ArrayList<Artilharia>();
//			
//			//1 porta aviões
//			PortaAvioes portaAviao = new PortaAvioes();
//			portaAviao.setNome("Derruba Flamenguistas");
//			portaAviao.setSigla("P1");
//			portaAviao.setTamanho(3);
//			artilhariaAdapter.adicionaArtilharia(portaAviao);
//			lsitaArtilharia.add(portaAviao);
//			
//			//1 navio de 4 canos
//			Navios navio01	=	new Navios();	
//			navio01.setNome("Avalanche Vasca’na");
//			navio01.setSigla("N1");
//			navio01.setTamanho(4);
//			artilhariaAdapter.adicionaArtilharia(navio01);
//			lsitaArtilharia.add(navio01);
//			
//			//2 navios de 3 canos
//			Navios navio02	=	new Navios();	
//			navio02.setNome("Trem Bala Vasca’no");
//			navio02.setSigla("N2");
//			navio02.setTamanho(3);
//			artilhariaAdapter.adicionaArtilharia(navio02);
//			lsitaArtilharia.add(navio02);
//			
//			Navios navio03	=	new Navios();	
//			navio03.setNome("Edmundo Animal");
//			navio03.setSigla("N3");
//			navio03.setTamanho(3);
//			artilhariaAdapter.adicionaArtilharia(navio03);
//			lsitaArtilharia.add(navio03);
//			
//			
//			//3 navios de 2 canos
//			Navios navio04	=	new Navios();	
//			navio04.setNome("Juniho Pernambucano Reizinho da Colina");
//			navio04.setSigla("N4");
//			navio04.setTamanho(2);
//			artilhariaAdapter.adicionaArtilharia(navio04);
//			lsitaArtilharia.add(navio04);
//			
//			Navios navio05	=	new Navios();	
//			navio05.setNome("Gigante da Colina");
//			navio05.setSigla("N5");
//			navio05.setTamanho(2);
//			artilhariaAdapter.adicionaArtilharia(navio05);
//			lsitaArtilharia.add(navio05);
//			
//			Navios navio06	=	new Navios();	
//			navio06.setNome("Caldeirão de São Jenuário");
//			navio06.setSigla("N6");
//			navio06.setTamanho(2);
//			artilhariaAdapter.adicionaArtilharia(navio06);
//			lsitaArtilharia.add(navio06);
//			
//			
//			//4 navios de 1 cano
//			Navios navio07	=	new Navios();	
//			navio07.setNome("Menguinho");
//			navio07.setSigla("N7");
//			navio07.setTamanho(1);
//			artilhariaAdapter.adicionaArtilharia(navio07);
//			lsitaArtilharia.add(navio07);
//			
//			Navios navio08	=	new Navios();	
//			navio08.setNome("Fraaaamengoooo");
//			navio08.setSigla("N8");
//			navio08.setTamanho(1);
//			artilhariaAdapter.adicionaArtilharia(navio08);
//			lsitaArtilharia.add(navio08);
//			
//			Navios navio09	=	new Navios();	
//			navio09.setNome("Juiz é jogador do Menguinho");
//			navio09.setSigla("N9");
//			navio09.setTamanho(1);
//			artilhariaAdapter.adicionaArtilharia(navio09);
//			lsitaArtilharia.add(navio09);
//			
//			Navios navio10	=	new Navios();	
//			navio10.setNome("Uma vez framengo, NUNCA mais framengo");
//			navio10.setSigla("N0");
//			navio10.setTamanho(1);
//			artilhariaAdapter.adicionaArtilharia(navio10);
//			lsitaArtilharia.add(navio10);
//			
//			
//			artilhariaAdapter.desenhaCampoBatalha(lsitaArtilharia);
//			
//			int numeroTentativas = 0;
//			boolean jogo = true;
//			while(jogo){
//				 String tentativa = getUserInput("Entre com um palpite");
//				 artilhariaAdapter.analisaTiro(tentativa,lsitaArtilharia);
//				 artilhariaAdapter.analisaCampoBatalha(lsitaArtilharia);
//				 numeroTentativas++;
//				 if(numeroTentativas == 30){
//					 System.out.println("N‹o Deu!!!! Voc� n‹o conseguiu destruir os navios e avi›es do seu advers‡rio.");
//					 jogo = false;
//				 }
//			}
//		}
//		
//		
//		public static  String getUserInput(String prompt) {
//		     String inputLine = null;
//		     System.out.print(prompt + "  ");
//		     try {
//		       BufferedReader is = new BufferedReader(
//			 new InputStreamReader(System.in));
//		       inputLine = is.readLine();
//		       if (inputLine.length() == 0 )  return null; 
//		     } catch (IOException e) {
//		       System.out.println("IOException: " + e);
//		     }
//		     return inputLine.toUpperCase();
//		}

}
