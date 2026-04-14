package com.example.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity11_sharedPerferences extends AppCompatActivity {

    EditText ext1;
    Button btn1, btn2;
    TextView txt1;

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main_activity11_shared_perferences);

        txt1 = findViewById(R.id.txt1);
        ext1 = findViewById(R.id.et1);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        sp = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = ext1.getText().toString().trim();
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("name", name);
                editor.apply();

                Toast.makeText(MainActivity11_sharedPerferences.this, "Data Saved", Toast.LENGTH_SHORT).show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = sp.getString("name", "No Data Found");
                txt1.setText(name);
            }
        });
    }
}