package com.example.kingscup;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Card> deck = new ArrayList<>();
    private TextView questView;
    private Button backbtn;
    private ImageView cardView;
    private TextView playerNameView;
    private int cardCount = 0;
    private int playerCount = 0;
    private String[] players;
    private int kingCount = 0;
    private TextView gameOverText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        players = intent.getStringArrayExtra("players");

        setupUI();

        shuffle();

        refresh();
    }

    private void setupUI() {
        questView = findViewById(R.id.questView);
        backbtn = findViewById(R.id.backButton);
        cardView = findViewById(R.id.cardView);
        playerNameView = findViewById(R.id.nameView);
        gameOverText = findViewById(R.id.gameOverView);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(kingCount!=4) {
                    cardCount++;
                    if (playerCount < players.length - 1) {
                        playerCount++;
                    } else {
                        playerCount = 0;
                    }
                    refresh();
                }
            }
        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(kingCount!=4) {
                    if (cardCount > 0) {
                        cardCount--;

                        if (playerCount > 0) {
                            playerCount--;
                        } else {
                            playerCount = players.length - 1;
                        }
                    }
                    refresh();
                }
            }
        });
    }

    private void refresh(){
        if(deck.get(cardCount).getDescription().equals("Kingscup")){
            kingCount++;
        }
        if(kingCount==4){
            gameOverText.setText(players[playerCount]+" hat verloren");
            gameOverText.setVisibility(View.VISIBLE);
        }
        questView.setText(deck.get(cardCount).getDescription());
        playerNameView.setText(players[playerCount]);
        cardView.setImageResource(deck.get(cardCount).getResource());
    }

    private void shuffle(){
        deck.clear();
        Random random = new Random();
        deck.add(new Card("Herz 2", random.nextInt(400),"Kategorie",R.drawable._2ofhearts));
        deck.add(new Card("Kreuz 2", random.nextInt(400),"Kategorie",R.drawable._2ofcross));
        deck.add(new Card("Karo 2", random.nextInt(400),"Kategorie",R.drawable._2ofdiamonds));
        deck.add(new Card("Pik 2", random.nextInt(400),"Kategorie",R.drawable._2ofclubs));
        deck.add(new Card("Herz 3", random.nextInt(400), "Reim",R.drawable._3ofhearts));
        deck.add(new Card("Kreuz 3", random.nextInt(400),"Reim",R.drawable._3ofcross));
        deck.add(new Card("Karo 3", random.nextInt(400),"Reim",R.drawable._3ofdiamonds));
        deck.add(new Card("Pik 3", random.nextInt(400),"Reim",R.drawable._3ofclubs));
        deck.add(new Card("Herz 4", random.nextInt(400),"Questionmaster",R.drawable._4ofhearts));
        deck.add(new Card("Kreuz 4", random.nextInt(400),"Questionmaster",R.drawable._4ofcross));

        deck.add(new Card("Karo 4", random.nextInt(400),"Questionmaster",R.drawable._4ofdiamonds));
        deck.add(new Card("Pik 4", random.nextInt(400),"Questionmaster",R.drawable._4ofclubs));
        deck.add(new Card("Herz 5", random.nextInt(400),"Counter",R.drawable._5ofhearts));
        deck.add(new Card("Kreuz 5", random.nextInt(400),"Counter",R.drawable._5ofcross));
        deck.add(new Card("Karo 5", random.nextInt(400),"Counter",R.drawable._5ofdiamonds));
        deck.add(new Card("Pik 5", random.nextInt(400),"Counter",R.drawable._5ofclubs));
        deck.add(new Card("Herz 6", random.nextInt(400),"Klokarte",R.drawable._6ofhearts));
        deck.add(new Card("Kreuz 6", random.nextInt(400),"Klokarte",R.drawable._6ofcross));
        deck.add(new Card("Karo 6", random.nextInt(400),"Klokarte",R.drawable._6ofdiamonds));
        deck.add(new Card("Pik 6", random.nextInt(400),"Klokarte",R.drawable._6ofclubs));

        deck.add(new Card("Herz 7", random.nextInt(400),"selbst trinken",R.drawable._7ofhearts));
        deck.add(new Card("Kreuz 7", random.nextInt(400),"selbst trinken",R.drawable._7ofcross));
        deck.add(new Card("Karo 7", random.nextInt(400),"selbst trinken",R.drawable._7ofdiamonds));
        deck.add(new Card("Pik 7", random.nextInt(400),"selbst trinken",R.drawable._7ofclubs));
        deck.add(new Card("Herz 8", random.nextInt(400),"Daumenmaster",R.drawable._8ofhearts));
        deck.add(new Card("Kreuz 8", random.nextInt(400),"Daumenmaster",R.drawable._8ofcross));
        deck.add(new Card("Karo 8", random.nextInt(400),"Daumenmaster",R.drawable._8ofdiamonds));
        deck.add(new Card("Pik 8", random.nextInt(400),"Daumenmaster",R.drawable._8ofclubs));
        deck.add(new Card("Herz 9", random.nextInt(400),"Regel ausdenken",R.drawable._9ofhearts));
        deck.add(new Card("Kreuz 9", random.nextInt(400),"Regel ausdenken",R.drawable._9ofcross));

        deck.add(new Card("Karo 9", random.nextInt(400),"Regel ausdenken",R.drawable._9ofdiamonds));
        deck.add(new Card("Pik 9", random.nextInt(400),"Regel ausdenken",R.drawable._9ofclubs));
        deck.add(new Card("Herz 10", random.nextInt(400),"10 Schluck verteilen",R.drawable._10ofhearts));
        deck.add(new Card("Kreuz 10", random.nextInt(400),"10 Schluck verteilen",R.drawable._10ofcross));
        deck.add(new Card("Karo 10", random.nextInt(400),"10 Schluck verteilen",R.drawable._10ofdiamonds));
        deck.add(new Card("Pik 10", random.nextInt(400),"10 Schluck verteilen",R.drawable._10ofclubs));
        deck.add(new Card("Herz J", random.nextInt(400),"alle Jungen trinken",R.drawable._jofhearts));
        deck.add(new Card("Kreuz J", random.nextInt(400),"alle Jungen trinken",R.drawable._jofcross));
        deck.add(new Card("Karo J", random.nextInt(400),"alle Jungen trinken",R.drawable._jofdiamonds));
        deck.add(new Card("Pik J", random.nextInt(400),"alle Jungen trinken",R.drawable._jofclubs));

        deck.add(new Card("Herz D", random.nextInt(400),"alle Mädchen trinken",R.drawable._dofhearts));
        deck.add(new Card("Kreuz D", random.nextInt(400),"alle Mädchen trinken",R.drawable._dofcross));
        deck.add(new Card("Karo D", random.nextInt(400),"alle Mädchen trinken",R.drawable._dofdiamonds));
        deck.add(new Card("Pik D", random.nextInt(400),"alle Mädchen trinken",R.drawable._dofclubs));
        deck.add(new Card("Herz K", random.nextInt(400),"Kingscup",R.drawable._kofhearts));
        deck.add(new Card("Kreuz K", random.nextInt(400),"Kingscup",R.drawable._kofcross));
        deck.add(new Card("Karo K", random.nextInt(400),"Kingscup",R.drawable._kofdiamonds));
        deck.add(new Card("Pik K", random.nextInt(400),"Kingscup",R.drawable._kofclubs));
        deck.add(new Card("Herz A", random.nextInt(400),"alle trinken",R.drawable._aofhearts));
        deck.add(new Card("Kreuz A", random.nextInt(400),"alle trinken",R.drawable._aofcross));

        deck.add(new Card("Karo A", random.nextInt(400),"alle trinken",R.drawable._aofdiamonds));
        deck.add(new Card("Pik A", random.nextInt(400),"alle trinken",R.drawable._aofclubs));

        deck.sort(Card::compareTo);
    }
}