package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button rzuc, resetbtn;
    ImageView im1, im2, im3, im4, im5;
    TextView losowanie, wynik;

    int wynikGry = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        rzuc = findViewById(R.id.rzuc);
        resetbtn = findViewById(R.id.button2);

        im1 = findViewById(R.id.imageView1);
        im2 = findViewById(R.id.imageView2);
        im3 = findViewById(R.id.imageView3);
        im4 = findViewById(R.id.imageView4);
        im5 = findViewById(R.id.imageView5);

        losowanie = findViewById(R.id.textViewlosownaie);
        wynik = findViewById(R.id.wynik);

        ArrayList<Integer> obrazy = new ArrayList<>();

        obrazy.add(R.drawable.question);
        obrazy.add(R.drawable.k1);
        obrazy.add(R.drawable.k2);
        obrazy.add(R.drawable.k3);
        obrazy.add(R.drawable.k4);
        obrazy.add(R.drawable.k5);
        obrazy.add(R.drawable.k6);

        rzuc.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Random random = new Random();

                        int[] kosci = new int[5];

                        for (int i = 0; i < 5; i++) {
                            kosci[i] = random.nextInt(6) + 1;
                        }

                        im1.setImageResource(obrazy.get(kosci[0]));
                        im2.setImageResource(obrazy.get(kosci[1]));
                        im3.setImageResource(obrazy.get(kosci[2]));
                        im4.setImageResource(obrazy.get(kosci[3]));
                        im5.setImageResource(obrazy.get(kosci[4]));

                        int[] wystapienia = new int[7];

                        for (int i = 0; i < 5; i++) {
                            wystapienia[kosci[i]]++;
                        }

                        int suma = 0;

                        for (int i = 1; i <= 6; i++) {

                            if (wystapienia[i] >= 2) {
                                suma += i * wystapienia[i];
                            }
                        }

                        losowanie.setText("Wynik tego losowania: " + suma);

                        wynikGry += suma;

                        wynik.setText("Wynik gry: " + wynikGry);
                    }
                }
        );

        resetbtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        wynikGry = 0;

                        losowanie.setText("Wynik tego losowania:");
                        wynik.setText("Wynik gry");

                        im1.setImageResource(R.drawable.question);
                        im2.setImageResource(R.drawable.question);
                        im3.setImageResource(R.drawable.question);
                        im4.setImageResource(R.drawable.question);
                        im5.setImageResource(R.drawable.question);
                    }
                }
        );
    }


}