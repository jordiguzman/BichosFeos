package appkite.jordiguzman.com.bichosfeos.adaptador;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import appkite.jordiguzman.com.bichosfeos.R;
import appkite.jordiguzman.com.bichosfeos.titulador.TitulosEnlaces;

/**
 * Created by Jordi Guzman on 14/01/2017.
 */

public class AdaptadorEnlaces extends ArrayAdapter {

    private Activity contetx;
    private TitulosEnlaces[] datos;


    public AdaptadorEnlaces(Activity context, TitulosEnlaces[] datos) {
        super(context, R.layout.adaptador_enlaces, datos);
        this.datos=datos;
        this.contetx=context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = contetx.getLayoutInflater();
        View item =inflater.inflate(R.layout.adaptador_enlaces, null);

        TextView titulo = (TextView) item.findViewById(R.id.tv_enlaces);
        titulo.setText(datos[position].getTitulo());

        return item;
    }
}
