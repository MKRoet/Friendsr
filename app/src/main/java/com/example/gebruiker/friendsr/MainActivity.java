package com.example.gebruiker.friendsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Empty list to add friends.
    ArrayList<Friend> friends = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create reference to drawables.
        int idArya = getResources().getIdentifier("arya", "drawable",  getPackageName());
        int idCersei = getResources().getIdentifier("cersei", "drawable",  getPackageName());
        int idDaenerys = getResources().getIdentifier("daenerys", "drawable",  getPackageName());
        int idJaime = getResources().getIdentifier("jaime", "drawable",  getPackageName());
        int idJon = getResources().getIdentifier("jon", "drawable",  getPackageName());
        int idJorah = getResources().getIdentifier("jorah", "drawable",  getPackageName());
        int idMargaery = getResources().getIdentifier("margaery", "drawable",  getPackageName());
        int idMelisandre = getResources().getIdentifier("melisandre", "drawable",  getPackageName());
        int idSansa = getResources().getIdentifier("sansa", "drawable",  getPackageName());
        int idTyrion = getResources().getIdentifier("tyrion", "drawable",  getPackageName());

        // Add friends to the arraylist.
        friends.add(new Friend("Arya", "Age: 17", idArya));
        friends.add(new Friend("Cersei", "Age: 42", idCersei));
        friends.add(new Friend("Daenerys", "Age: 22", idDaenerys));
        friends.add(new Friend("Jaime", "Age: 42", idJaime));
        friends.add(new Friend("Jon", "Age: 22", idJon));
        friends.add(new Friend("Jorah", "Age: 50", idJorah));
        friends.add(new Friend("Margaery", "Age: 26", idMargaery));
        friends.add(new Friend("Melisandre", "Age: 41", idMelisandre));
        friends.add(new Friend("Sansa", "Age: 19", idSansa));
        friends.add(new Friend("Tyrion", "Age: 38", idTyrion));

        // Initialize adapter with gridview.
        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);
        GridView gridview = findViewById(R.id.mainGrid);
        gridview.setAdapter(adapter);

        GridClick listener = new GridClick();
        gridview.setOnItemClickListener(listener);

    }

    private class GridClick implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            // Direct user to next activity with saving the correct information.
            Friend clickedFriend = (Friend) adapterView.getItemAtPosition(i);
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);
        }
    }


}
