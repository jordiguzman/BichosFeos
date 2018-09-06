package appkite.jordiguzman.com.bichosfeos.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;

import appkite.jordiguzman.com.bichosfeos.R;

/**
 * Created by Jordi Guzman on 30/06/2016.
 */
public class DialogoAyudaImagenes extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = getActivity().getLayoutInflater();
        final AlertDialog.Builder dialogoInicio = new AlertDialog.Builder(new ContextThemeWrapper(getActivity(), R.style.AlertDialogCustom_));


        dialogoInicio.setView(inflater.inflate(R.layout.dialogo_ayuda_imagenes, null))
                .setPositiveButton(R.string.dialogo_salir, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            finalize();
                        } catch (Throwable throwable) {
                            throwable.printStackTrace();
                        }

                    }
                });


        return dialogoInicio.create();
    }
}
