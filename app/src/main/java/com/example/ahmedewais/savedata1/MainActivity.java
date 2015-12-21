package com.example.ahmedewais.savedata1;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences prefs;
    private String prefName = "MyPref";
    private EditText editText;
    private Button btn;
    private static final String TEXT_VALUE_KEY = "textvalue";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //---get the SharedPreferences object---
                prefs = getSharedPreferences(prefName, MODE_PRIVATE);
                //prefs = getPreferences(MODE_PRIVATE);

                SharedPreferences.Editor editor = prefs.edit();


                editor.putString(TEXT_VALUE_KEY, editText.getText().toString());
                //---saves the values---
                editor.commit();

                Toast.makeText(getBaseContext(),
                        "Data Are Saved",
                        Toast.LENGTH_SHORT).show();
            }
        });

        prefs = getSharedPreferences(prefName, MODE_PRIVATE);

    }
}
