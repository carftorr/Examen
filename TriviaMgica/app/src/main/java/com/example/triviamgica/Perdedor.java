package com.example.triviamgica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Perdedor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perdedor);

        TextView Contador = findViewById(R.id.txt_contador);

        int score = getIntent().getIntExtra("RIGHT_ANSWER_COUNT", 0);

        Contador.setText("Has contestado "+ score + " preguntas.");
    }

    public void regresoPreguntas(View view) {
        startActivity(new Intent(getApplicationContext(), Preguntas.class));
    }
}