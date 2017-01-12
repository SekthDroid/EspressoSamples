package com.sekthdroid.espressosample.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sekthdroid.espressosample.R;

/**
 * Created by SekthDroid on 12/1/17.
 */

public class FooterMainFragment extends Fragment {
    private TextView mFooterView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_footer, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mFooterView = (TextView) view.findViewById(R.id.tv_footer);
    }

    public void updateFooter(String input) {
        mFooterView.setText(input);
    }
}
