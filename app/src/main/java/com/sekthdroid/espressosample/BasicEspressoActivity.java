package com.sekthdroid.espressosample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BasicEspressoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_change).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((TextView)findViewById(R.id.tv_label)).setText(R.string.changed);
            }
        });

        findViewById(R.id.btn_reset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((TextView)findViewById(R.id.tv_label)).setText(R.string.hello_world);
            }
        });

        findViewById(R.id.btn_set).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = ((EditText)findViewById(R.id.et_input)).getText().toString();
                if (input.isEmpty()){
                    Toast.makeText(BasicEspressoActivity.this, R.string.empty_input, Toast.LENGTH_SHORT).show();
                }else {
                    ((TextView)findViewById(R.id.tv_label)).setText(input);
                }
            }
        });
    }
}
