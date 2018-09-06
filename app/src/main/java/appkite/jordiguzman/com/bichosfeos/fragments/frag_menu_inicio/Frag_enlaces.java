package appkite.jordiguzman.com.bichosfeos.fragments.frag_menu_inicio;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import appkite.jordiguzman.com.bichosfeos.MenuImagenes;
import appkite.jordiguzman.com.bichosfeos.R;

/**
 * Created by Jordi Guzman on 25/06/2016.
 */


public class Frag_enlaces extends Fragment{

    View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView= inflater.inflate(R.layout.frag_enlaces, container, false);




        return rootView;
    }



}
