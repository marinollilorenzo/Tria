package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView img11;
    ImageView img12;
    ImageView img13;
    ImageView img21;
    ImageView img22;
    ImageView img23;
    ImageView img31;
    ImageView img32;
    ImageView img33;
    Button rigiocaButton;

    TextView txtRisultato;

    Boolean player = false, finito = false;

    String nome1 = "X";
    String nome2 = "O";

    private ArrayList<String> tria               = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img11         = findViewById(R.id.img11);
        img12         = findViewById(R.id.img12);
        img13         = findViewById(R.id.img13);
        img21         = findViewById(R.id.img21);
        img22         = findViewById(R.id.img22);
        img23         = findViewById(R.id.img23);
        img31         = findViewById(R.id.img31);
        img32         = findViewById(R.id.img32);
        img33         = findViewById(R.id.img33);
        txtRisultato  = findViewById(R.id.txtRisultato);
        rigiocaButton = findViewById(R.id.rigioca);

        rigiocaButton.setEnabled(false);

        for(int i =0; i< 9; i++) {
            tria.add("-1");
        }

        mostraGiocatore();
        rigiocaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();

            }
        });

        img11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mossa(0);
            }
        });
        img12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mossa(1);
            }
        });
        img13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mossa(2);
            }
        });
        img21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mossa(3);
            }
        });
        img22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mossa(4);
            }
        });
        img23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mossa(5);
            }
        });
        img31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mossa(6);
            }
        });
        img32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mossa(7);
            }
        });
        img33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mossa(8);
            }
        });





    }

    public void mossa(int m) {
        if(!finito) {
            if (tria.get(m).equals("-1")) {
                if (player) {
                    switch (m) {
                        case 0:
                            img11.setImageDrawable(getDrawable(R.drawable.mossa_x));
                            break;
                        case 1:
                            img12.setImageDrawable(getDrawable(R.drawable.mossa_x));
                            break;
                        case 2:
                            img13.setImageDrawable(getDrawable(R.drawable.mossa_x));
                            break;
                        case 3:
                            img21.setImageDrawable(getDrawable(R.drawable.mossa_x));
                            break;
                        case 4:
                            img22.setImageDrawable(getDrawable(R.drawable.mossa_x));
                            break;
                        case 5:
                            img23.setImageDrawable(getDrawable(R.drawable.mossa_x));
                            break;
                        case 6:
                            img31.setImageDrawable(getDrawable(R.drawable.mossa_x));
                            break;
                        case 7:
                            img32.setImageDrawable(getDrawable(R.drawable.mossa_x));
                            break;
                        case 8:
                            img33.setImageDrawable(getDrawable(R.drawable.mossa_x));
                            break;
                    }
                    tria.set(m, "1");
                } else {
                    switch (m) {
                        case 0:
                            img11.setImageDrawable(getDrawable(R.drawable.mossa_o));
                            break;
                        case 1:
                            img12.setImageDrawable(getDrawable(R.drawable.mossa_o));
                            break;
                        case 2:
                            img13.setImageDrawable(getDrawable(R.drawable.mossa_o));
                            break;
                        case 3:
                            img21.setImageDrawable(getDrawable(R.drawable.mossa_o));
                            break;
                        case 4:
                            img22.setImageDrawable(getDrawable(R.drawable.mossa_o));
                            break;
                        case 5:
                            img23.setImageDrawable(getDrawable(R.drawable.mossa_o));
                            break;
                        case 6:
                            img31.setImageDrawable(getDrawable(R.drawable.mossa_o));
                            break;
                        case 7:
                            img32.setImageDrawable(getDrawable(R.drawable.mossa_o));
                            break;
                        case 8:
                            img33.setImageDrawable(getDrawable(R.drawable.mossa_o));
                            break;
                    }
                    tria.set(m, "0");
                }

                if (checkWin()) {
                    txtRisultato.setText("HA VINTO " + getPlayer() + "!");
                    finito = true;
                    rigiocaButton.setEnabled(true);
                }
                else if (checkDraw()) {
                    txtRisultato.setText("PAREGGIO!");
                    finito = true;
                    rigiocaButton.setEnabled(true);
                }else {

                player = !player;
                mostraGiocatore();
                }
            }
        }
    }

    public boolean checkDraw(){
        boolean t = true;
        for(int i = 0; i < tria.size(); i++)
            if(tria.get(i).equals("-1"))
                t = false;
        return t;
    }
    public String getPlayer(){
        if(player)
            return nome1;
        else
            return nome2;
    }
    public void mostraGiocatore() {
        if(player) {
            txtRisultato.setText("Gioca " + nome1);
        }
        else {
            txtRisultato.setText("Gioca " + nome2);
        }
    }

    public boolean checkWin(){
        for(int i = 0; i < 9; i+=3){
            if(checkX(tria.get(i)) && checkX(tria.get(i+1)) && checkX(tria.get(i+2)))
                return true;
        }
        for(int i = 0; i < 3; i++){
            if(checkX(tria.get(i)) && checkX(tria.get(i+3)) && checkX(tria.get(i+6)))
                return true;
        }
        if(checkX(tria.get(0)) && checkX(tria.get(4)) && checkX(tria.get(8)))
            return true;
        if(checkX(tria.get(2)) && checkX(tria.get(4)) && checkX(tria.get(6)))
            return true;
        for(int i = 0; i < 9; i+=3){
            if(checkO(tria.get(i)) && checkO(tria.get(i+1)) && checkO(tria.get(i+2)))
                return true;
        }
        for(int i = 0; i < 3; i++){
            if(checkO(tria.get(i)) && checkO(tria.get(i+3)) && checkO(tria.get(i+6)))
                return true;
        }
        if(checkO(tria.get(0)) && checkO(tria.get(4)) && checkO(tria.get(8)))
            return true;
        if(checkO(tria.get(2)) && checkO(tria.get(4)) && checkO(tria.get(6)))
            return true;
        return false;
    }
    public boolean checkO(String x){
        return x.equals("0");
    }
    public boolean checkX(String x){
        return x.equals("1");
    }
    public void resetGame() {
        // Resetta tutte le immagini
        img11.setImageDrawable(getDrawable(R.drawable.android));
        img12.setImageDrawable(getDrawable(R.drawable.android));
        img13.setImageDrawable(getDrawable(R.drawable.android));
        img21.setImageDrawable(getDrawable(R.drawable.android));
        img22.setImageDrawable(getDrawable(R.drawable.android));
        img23.setImageDrawable(getDrawable(R.drawable.android));
        img31.setImageDrawable(getDrawable(R.drawable.android));
        img32.setImageDrawable(getDrawable(R.drawable.android));
        img33.setImageDrawable(getDrawable(R.drawable.android));

        // Resetta il testo del risultato
        txtRisultato.setText("");

        // Resetta lo stato del gioco
        for (int i = 0; i < 9; i++) {
            tria.set(i, "-1");
        }
        player = false;
        finito = false;

        // Abilita di nuovo tutte le immagini per i click
        img11.setEnabled(true);
        img12.setEnabled(true);
        img13.setEnabled(true);
        img21.setEnabled(true);
        img22.setEnabled(true);
        img23.setEnabled(true);
        img31.setEnabled(true);
        img32.setEnabled(true);
        img33.setEnabled(true);

        // Disabilita il pulsante rigioca
        rigiocaButton.setEnabled(false);

        // Mostra il giocatore corrente
        mostraGiocatore();
    }

}