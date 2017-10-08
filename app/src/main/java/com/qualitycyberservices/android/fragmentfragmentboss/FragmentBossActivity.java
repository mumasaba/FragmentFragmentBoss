package com.qualitycyberservices.android.fragmentfragmentboss;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Created by b3nn on 7/24/17.
 * This is the Activity that is Hosting a Fragment - BossFragmentFragment.
 */

public class FragmentBossActivity extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_fragment_boss );

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById( R.id.fragmentContainer );

        if ( fragment == null ) {
            fragment = new BossFragmentFragment();
            fm.beginTransaction().add( R.id.fragmentContainer, fragment ).commit();
        }
    }
}
