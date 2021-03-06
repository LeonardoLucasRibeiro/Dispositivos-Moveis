package br.com.iesb.batalhanavalandroid;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(40, 40));
            //imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(1, 1, 1, 1);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }
    
    public View setImageView(View convertView, int imagem) {
        ImageView imageView = (ImageView) convertView;
        imageView.setImageResource(imagem);
        return imageView;
    }
    
    

    public void iniciaMontaThumbs(){
    	for(int i=0; i<100; i++){
    		mThumbIds[i] = R.drawable.quadrado; 
    	}
    }


    public void iniciaMontaThumbsJogador( List<Artilharia> listaArtilhariaJogador){
    	//HashMap<Integer, Integer> mapsDeBarcos = MainActivity.barcoTamanho1;
    	int tamamanhoArtilharia;
    	int imagem;
    	HashMap<Integer, Integer> mapsDeBarcos;
    	for(Artilharia artilharia : listaArtilhariaJogador){
    		for(String item: artilharia.getPosicoes()){
    			mThumbIds[Integer.parseInt(item)] =  artilharia.getImagens().get(Integer.parseInt(item)); 
    		}	
    	}
    }
    
    

    public Integer[] getmThumbIds() {
		return mThumbIds;
	}

	public void setmThumbIds(Integer[] mThumbIds) {
		this.mThumbIds = mThumbIds;
	}

	 public int getmThumbId(int position) {
			return mThumbIds[position];
	}

	public void setmThumbId(int position, int resource) {
			this.mThumbIds[position] = resource;
	}



// references to our images
   private Integer[] mThumbIds = new Integer[100];
}