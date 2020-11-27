package com.example.triviamgica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Perdedor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perdedor);

        TextView Contador = findViewById(R.id.txt_contador);

        int score = getIntent().getIntExtra("RIGHT_ANSWER_COUNT", 0);

        Contador.setText("Ha contestado "+ score + " preguntas correctas.");
    }

    public void regresoPreguntas(View view) {
        startActivity(new Intent(getApplicationContext(), Preguntas.class));
    }

    public void salir(View view) {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

}