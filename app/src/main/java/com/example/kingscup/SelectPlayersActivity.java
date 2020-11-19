package com.example.kingscup;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SelectPlayersActivity extends AppCompatActivity {

    private Spinner mspin;
    private ListView list;
    private ArrayList<PlayerListItem> playerList = new ArrayList<>();
    private int playerNumber = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_players);

        setupPlayerNumber();

        setupUI();
    }

    private void setupPlayerNumber(){
        playerList.clear();
        for(int i=1;i<=playerNumber;i++){
            playerList.add(new PlayerListItem(i));
        }
    }

    private void setupUI() {
        mspin=(Spinner) findViewById(R.id.spinner);
        Integer[] items = new Integer[]{1,2,3,4,5,6,7,8};
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item, items);
        mspin.setAdapter(adapter);

        mspin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                playerNumber = position+1;
                setupPlayerNumber();
                setUpList();
                System.out.println(playerNumber);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        list = findViewById(R.id.playersListView);

        setUpList();
    }

    private void setUpList() {
        PlayerListArrayAdapter adapter = new PlayerListArrayAdapter(this, -1, playerList);

        //Der Adapter wird dem ListView zugewiesen
        list.setAdapter(adapter);
    }
}
