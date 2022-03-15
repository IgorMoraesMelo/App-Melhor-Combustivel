package com.example.alcoolougasolina20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.PagerSnapHelper;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText txtGasolina;
    private TextInputEditText txtAlcool;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    txtGasolina = findViewById(R.id.txtGasolina);
    txtAlcool = findViewById(R.id.txtAlcool);
    txtResultado = findViewById(R.id.txtResultado);

    }

    // Metodo para calcular melhor combustivel
    @SuppressLint("SetTextI18n")
    public void calcularMelhorCombustivel(View view){

        String gasolina = txtGasolina.getText().toString();
        String alcool = txtAlcool.getText().toString();

            // Retorno do metodo de validação
        boolean camposValidados = validacao(gasolina, alcool);

            // Condicional de calculo do melhor combustivel com campos validados
        if(camposValidados) {
            double vGasolina = Double.parseDouble(gasolina);
            double vAlcool = Double.parseDouble(alcool);

            double melhorCombustivel = vAlcool / vGasolina;

            if (melhorCombustivel <= 0.7) {
                txtResultado.setText("Vá de Gasolina!");
            } else {
                txtResultado.setText("Vá de Alcool!");
            }

        }else{
            txtResultado.setText("Preencha todos os campos!");
        }

    }

        // Validação dos campos gasolina e alcool
    public boolean validacao(String pGasolina, String pAlcool){

        boolean validacao = true;

        if(pGasolina == null || pGasolina.equals("")){
            validacao = false;
        }else if(pAlcool == null || pAlcool.equals("")){
            validacao = false;
        }
        return validacao;

    }


    }

