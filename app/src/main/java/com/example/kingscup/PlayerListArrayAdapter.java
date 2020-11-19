package com.example.kingscup;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;

public class PlayerListArrayAdapter extends ArrayAdapter<PlayerListItem> {
    private final Context context;
    private final ArrayList<PlayerListItem> items;

    public PlayerListArrayAdapter(@NonNull Context context, int resource, @NonNull ArrayList<PlayerListItem> objects) {
        super(context, resource, objects);
        this.context = context;
        this.items = objects;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //the values are put in the list item
        View rowView = inflater.inflate(R.layout.players_list_item, parent, false);
        TextView playerCount = (TextView) rowView.findViewById(R.id.playerNumberView);
        EditText playerNameField = (EditText) rowView.findViewById(R.id.playerNameField);

        playerCount.setText("Player"+items.get(position).getNumber());

        return rowView;
    }
}
