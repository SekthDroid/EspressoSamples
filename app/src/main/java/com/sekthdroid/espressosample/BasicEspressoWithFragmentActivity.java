package com.sekthdroid.espressosample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sekthdroid.espressosample.fragments.EditorFragment;
import com.sekthdroid.espressosample.fragments.FooterMainFragment;

public class BasicEspressoWithFragmentActivity extends AppCompatActivity implements EditorFragment.OnInputChangedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_espresso_with_fragment);
    }

    @Override
    public void onInputChanged(String input) {
        FooterMainFragment fragment = (FooterMainFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_footer);
        if (fragment != null) {
            fragment.updateFooter(input);
        }
    }
}
