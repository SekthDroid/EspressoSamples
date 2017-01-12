package com.sekthdroid.espressosample.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.sekthdroid.espressosample.R;

/**
 * Created by SekthDroid on 12/1/17.
 */

public class EditorFragment extends Fragment {
    private static final String TAG = "SampleMainFragment";

    private Button mChangeFooterView;
    private EditText mFooterInputView;
    private OnInputChangedListener listener;

    public interface OnInputChangedListener {
        void onInputChanged(String input);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            this.listener = (OnInputChangedListener) context;
        } catch (ClassCastException ex) {
            Log.d(TAG, "onAttach: ".concat(ex.getMessage()));
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_editor, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mFooterInputView = (EditText) view.findViewById(R.id.et_input);
        mChangeFooterView = (Button) view.findViewById(R.id.btn_set_footer);
        mChangeFooterView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = mFooterInputView.getText().toString();

                if (!input.isEmpty() && listener != null) {
                    listener.onInputChanged(input);
                }
            }
        });
    }
}