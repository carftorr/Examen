package com.example.triviamgica;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Preguntas extends AppCompatActivity {

    private TextView preguntas;
    private Button boton1;
    private Button boton2;
    private Button boton3;
    private Button boton4;

    private String respuesta;
    private int respuestaCorrecta = 0;
    private int contadorPreguntas = 1;


    static final private int Trivia_Contador = 5;

    ArrayList<ArrayList<String>> TriviaArray = new ArrayList<>();

    String TriviaData[][] = {
            // {"Pregunta", "Respuesta Correcta", "Opción1", "Opción2", "Opción3"}
            {"¿Dónde comenzaron las Guerras Clon?", "Geonosis", "Tatooine", "Naboo", "Coruscant"},
            {"¿De qué color es el brazo de C-3PO en Star Wars: The Force Awakens?", "Rojo", "Verde", "Negro", "Blanco"},
            {"¿Qué apodo llama Han Solo a Luke Skywalker que lo vuelve loco?", "Niño", "Mocoso", "Bebé", "Nene"},
            {"¿Cuál fue el trabajo que Finn le dijo a Han Solo que tenía en la base Starkiller?", "Saneamiento", "Piloto", "Profesor", "Director"},
            {"¿Quién adoptó a la hija de Padmé Amidala?", "Bail Organa", "Giddean Danu", "Owen y Beru Lars", "Capitán Antilles"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);

        preguntas = findViewById(R.id.txt_preguntas);
        boton1 = findViewById(R.id.btn_opcion1);
        boton2 = findViewById(R.id.btn_opcion2);
        boton3 = findViewById(R.id.btn_opcion3);
        boton4 = findViewById(R.id.btn_opcion4);


        for (int i = 0; i < TriviaData.length; i++) {

            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(TriviaData[i][0]); // Pregunta
            tmpArray.add(TriviaData[i][1]); // Repsuesta Correcta
            tmpArray.add(TriviaData[i][2]); // Opción 1
            tmpArray.add(TriviaData[i][3]); // Opción 2
            tmpArray.add(TriviaData[i][4]); // Opción 3

            TriviaArray.add(tmpArray);
        }

        mostrarSigPregunta();

    }

    public void mostrarSigPregunta() {

        Random random = new Random();
        int randomNum = random.nextInt(TriviaArray.size());

        ArrayList<String> trivia = TriviaArray.get(randomNum);

        preguntas.setText(trivia.get(0));
        respuesta = trivia.get(1);

        trivia.remove(0);
        Collections.shuffle(trivia);

        boton1.setText(trivia.get(0));
        boton2.setText(trivia.get(1));
        boton3.setText(trivia.get(2));
        boton4.setText(trivia.get(3));

        TriviaArray.remove(randomNum);
    }

    public void checkRespuesta(View view) {

        // Get pushed button.
        Button BotonRespuesta = findViewById(view.getId());
        String btnText = BotonRespuesta.getText().toString();

        String alertTitle;

        if (btnText.equals(respuesta)) {
            // Correct
            alertTitle = "Correct!";
            respuestaCorrecta++;

        } else {
            alertTitle = "Wrong...";
        }

        // Create AlertDialog.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("Answer : " + respuesta);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (contadorPreguntas== Trivia_Contador) {
                    // Show Result.
                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    intent.putExtra("RIGHT_ANSWER_COUNT", respuestaCorrecta);
                    startActivity(intent);

                } else {
                    contadorPreguntas++;
                    mostrarSigPregunta();
                }
            }
        });
        builder.setCancelable(false);
        builder.show();
    }


}