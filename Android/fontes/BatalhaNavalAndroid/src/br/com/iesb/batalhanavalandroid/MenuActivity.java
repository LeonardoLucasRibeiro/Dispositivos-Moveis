package br.com.iesb.batalhanavalandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.menu);
	}
	
	public void jogador(View v){
		startActivity(new Intent(this,DoisJogadoresActivity.class));
	}
	public void computador(View v){
		startActivity(new Intent(this,JogadorComputadorActivity.class));
	}
}
