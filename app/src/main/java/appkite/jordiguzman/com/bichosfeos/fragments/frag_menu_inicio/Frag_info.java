package appkite.jordiguzman.com.bichosfeos.fragments.frag_menu_inicio;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import appkite.jordiguzman.com.bichosfeos.R;

/**
 * Created by Jordi Guzman on 25/06/2016.
 */
public class Frag_info extends Fragment{

    View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView= inflater.inflate(R.layout.frag_info, container, false);



        return rootView;
    }

}
