package appkite.jordiguzman.com.bichosfeos.fragments.fragment_imagenes;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import appkite.jordiguzman.com.bichosfeos.R;

/**
 * Created by Jordi Guzman on 25/06/2016.
 */


public class Frag_img_escarabajos extends Fragment{

    View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView= inflater.inflate(R.layout.frag_imagenes_escarabajo, container, false);




        return rootView;
    }

}
