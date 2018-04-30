package com.example.gebruiker.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Get access to the layout's views.
        TextView name = findViewById(R.id.name);
        ImageView picture = findViewById(R.id.pic);
        RatingBar rating = findViewById(R.id.ratingBar);
        TextView biografy = findViewById(R.id.bio);

        rating.setOnRatingBarChangeListener(new OnRatingBarChangeListener());

        // Extract value from the intent.
        Intent intent = getIntent();
        Friend retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        // Set textview.
        name.setText(retrievedFriend.getName());
        biografy.setText(retrievedFriend.getBio());

        // Set imageview.
        picture.setImageResource(retrievedFriend.getDrawableId());

        // Set ratingbar.
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        Float aStoredFloat = prefs.getFloat(name.getText().toString(), 0);

        if (aStoredFloat != null) {
            rating.setRating(aStoredFloat);
            } else {
                rating.setRating(0);
            }
        }


    public class OnRatingBarChangeListener implements RatingBar.OnRatingBarChangeListener {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

            TextView name = findViewById(R.id.name);
            SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();
            editor.putFloat(name.getText().toString(), rating);
            editor.apply();
        }
    }
}