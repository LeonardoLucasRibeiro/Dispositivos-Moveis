package br.com.iesb.batalhanavalandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AberturaActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.inicio);
	}
	
	public void iniciaJogo(View v){
		startActivity(new Intent(this,DoisJogadoresActivity.class));
	}
}
