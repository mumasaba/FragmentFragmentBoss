package com.qualitycyberservices.android.fragmentfragmentboss;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by b3nn on 7/25/17.
 * Slave dialog to the boss fragment.
 */

public class SlaveFragmentFragment extends DialogFragment {
    private EditText mNewWordField;
    public static final String EXTRA_INPUT = "com.qualitycyberservices.android.fragmentfragmentboss.input";

    @NonNull
    @Override
    public Dialog onCreateDialog( Bundle savedInstanceState ) {
        View v = getActivity().getLayoutInflater().inflate( R.layout.dialog_slave_fragment_fragment, new ConstraintLayout( getActivity() ) );

        mNewWordField = ( EditText )v.findViewById( R.id.new_word_value );

        Dialog alertDialog = new AlertDialog.Builder( getActivity() ).setTitle( R.string.slave_dialog_title ).setView( v )
                .setPositiveButton( android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick( DialogInterface dialogInterface, int i ) {
                        String input = mNewWordField.getText().toString().trim();

                        if ( input.length() != 0 ) {
                            sendResult( Activity.RESULT_OK, input );
                        } else {
                            Toast.makeText( getActivity(), "New Word is empty, please insert a word.", Toast.LENGTH_SHORT ).show();
                        }
                    }
                } ).setNegativeButton( android.R.string.cancel, null ).create();

        alertDialog.getWindow().setSoftInputMode( WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE );

        return alertDialog;
    }

    private void sendResult( int resultCode, String result ) {

        if ( getTargetFragment() == null )
            return;

        Intent i = new Intent();
        i.putExtra( EXTRA_INPUT, result );

        getTargetFragment().onActivityResult( getTargetRequestCode(), resultCode, i );
    }
}
