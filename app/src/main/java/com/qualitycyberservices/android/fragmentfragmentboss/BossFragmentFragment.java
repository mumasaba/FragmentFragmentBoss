package com.qualitycyberservices.android.fragmentfragmentboss;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by b3nn on 7/24/17.
 * The main Fragment, which is the boss of a Dialog fragment
 */

public class BossFragmentFragment extends Fragment {
    private TextView mWordTextView;
    private static final String DIALOG_SLAVE_FRAGMENT_FRAGMENT = "new_word";
    private static final int REQUEST_INPUT = 0;

    @Override
    public void onCreate( @Nullable Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setHasOptionsMenu( true );
    }

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
        View v = inflater.inflate( R.layout.fragment_boss_fragment, container, false );

        mWordTextView = ( TextView )v.findViewById( R.id.word_text_view );

        return v;
    }

    @Override
    public void onCreateOptionsMenu( Menu menu, MenuInflater inflater ) {
        super.onCreateOptionsMenu( menu, inflater );
        inflater.inflate( R.menu.fragment_boss_fragment, menu );
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item ) {

        switch ( item.getItemId() ) {

            // Show the dialog when the add options menu item is clicked
            case R.id.menu_item_add_word:
                FragmentManager fm = getFragmentManager();
                SlaveFragmentFragment dialog = new SlaveFragmentFragment();
                dialog.setTargetFragment( BossFragmentFragment.this, REQUEST_INPUT );
                dialog.show( fm, DIALOG_SLAVE_FRAGMENT_FRAGMENT );

                return true;

            default:
                return super.onOptionsItemSelected( item );
        }
    }

    @Override
    public void onActivityResult( int requestCode, int resultCode, Intent data ) {

        if ( resultCode != Activity.RESULT_OK )
            return;

        if ( requestCode == REQUEST_INPUT ) {
            String input = data.getStringExtra( SlaveFragmentFragment.EXTRA_INPUT );
            mWordTextView.setText( input );
        }
    }
}
