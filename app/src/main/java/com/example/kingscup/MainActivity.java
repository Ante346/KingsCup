package com.example.kingscup;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI();

        shuffle();

        refresh();
    }

    private void setupUI() {
        questView = findViewById(R.id.questView);
        backbtn = findViewById(R.id.backButton);
        cardView = findViewById(R.id.cardView);
        playerNameView = findViewById(R.id.nameView);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardCount++;
                refresh();
            }
        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cardCount>0) {
                    cardCount--;
                }
                refresh();
            }
        });
    }

    private void refresh(){
        questView.setText(deck.get(cardCount).getDescription());
    }

    private void shuffle(){
        deck.clear();
        Random random = new Random();
        deck.add(new Card("Herz 2", random.nextInt(400),"Kategorie"));
        deck.add(new Card("Kreuz 2", random.nextInt(400),"Kategorie"));
        deck.add(new Card("Karo 2", random.nextInt(400),"Kategorie"));
        deck.add(new Card("Pik 2", random.nextInt(400),"Kategorie"));
        deck.add(new Card("Herz 3", random.nextInt(400), "Reim"));
        deck.add(new Card("Kreuz 3", random.nextInt(400),"Reim"));
        deck.add(new Card("Karo 3", random.nextInt(400),"Reim"));
        deck.add(new Card("Pik 3", random.nextInt(400),"Reim"));
        deck.add(new Card("Herz 4", random.nextInt(400),"Questionmaster"));
        deck.add(new Card("Kreuz 4", random.nextInt(400),"Questionmaster"));

        deck.add(new Card("Karo 4", random.nextInt(400),"Questionmaster"));
        deck.add(new Card("Pik 4", random.nextInt(400),"Questionmaster"));
        deck.add(new Card("Herz 5", random.nextInt(400),"Counter"));
        deck.add(new Card("Kreuz 5", random.nextInt(400),"Counter"));
        deck.add(new Card("Karo 5", random.nextInt(400),"Counter"));
        deck.add(new Card("Pik 5", random.nextInt(400),"Counter"));
        deck.add(new Card("Herz 6", random.nextInt(400),"Klokarte"));
        deck.add(new Card("Kreuz 6", random.nextInt(400),"Klokarte"));
        deck.add(new Card("Karo 6", random.nextInt(400),"Klokarte"));
        deck.add(new Card("Pik 6", random.nextInt(400),"Klokarte"));

        deck.add(new Card("Herz 7", random.nextInt(400),"selbst trinken"));
        deck.add(new Card("Kreuz 7", random.nextInt(400),"selbst trinken"));
        deck.add(new Card("Karo 7", random.nextInt(400),"selbst trinken"));
        deck.add(new Card("Pik 7", random.nextInt(400),"selbst trinken"));
        deck.add(new Card("Herz 8", random.nextInt(400),"Daumenmaster"));
        deck.add(new Card("Kreuz 8", random.nextInt(400),"Daumenmaster"));
        deck.add(new Card("Karo 8", random.nextInt(400),"Daumenmaster"));
        deck.add(new Card("Pik 8", random.nextInt(400),"Daumenmaster"));
        deck.add(new Card("Herz 9", random.nextInt(400),"Regel ausdenken"));
        deck.add(new Card("Kreuz 9", random.nextInt(400),"Regel ausdenken"));

        deck.add(new Card("Karo 9", random.nextInt(400),"Regel ausdenken"));
        deck.add(new Card("Pik 9", random.nextInt(400),"Regel ausdenken"));
        deck.add(new Card("Herz 10", random.nextInt(400),"10 Schluck verteilen"));
        deck.add(new Card("Kreuz 10", random.nextInt(400),"10 Schluck verteilen"));
        deck.add(new Card("Karo 10", random.nextInt(400),"10 Schluck verteilen"));
        deck.add(new Card("Pik 10", random.nextInt(400),"10 Schluck verteilen"));
        deck.add(new Card("Herz J", random.nextInt(400),"alle Jungen trinken"));
        deck.add(new Card("Kreuz J", random.nextInt(400),"alle Jungen trinken"));
        deck.add(new Card("Karo J", random.nextInt(400),"alle Jungen trinken"));
        deck.add(new Card("Pik J", random.nextInt(400),"alle Jungen trinken"));

        deck.add(new Card("Herz D", random.nextInt(400),"alle Mädchen trinken"));
        deck.add(new Card("Kreuz D", random.nextInt(400),"alle Mädchen trinken"));
        deck.add(new Card("Karo D", random.nextInt(400),"alle Mädchen trinken"));
        deck.add(new Card("Pik D", random.nextInt(400),"alle Mädchen trinken"));
        deck.add(new Card("Herz K", random.nextInt(400),"Kingscup"));
        deck.add(new Card("Kreuz K", random.nextInt(400),"Kingscup"));
        deck.add(new Card("Karo K", random.nextInt(400),"Kingscup"));
        deck.add(new Card("Pik K", random.nextInt(400),"Kingscup"));
        deck.add(new Card("Herz A", random.nextInt(400),"alle trinken"));
        deck.add(new Card("Kreuz A", random.nextInt(400),"alle trinken"));

        deck.add(new Card("Karo A", random.nextInt(400),"alle trinken"));
        deck.add(new Card("Pik A", random.nextInt(400),"alle trinken"));

        deck.sort(Card::compareTo);
    }
}