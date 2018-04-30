package com.example.gebruiker.friendsr;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.media.CamcorderProfile.get;

public class FriendsAdapter extends ArrayAdapter<Friend> {
    public FriendsAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Friend> objects) {
        super(context, resource, objects);
        friends = objects;
    }

    ArrayList<Friend> friends;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

        // Get access to the layout's views.
        TextView name = convertView.findViewById(R.id.textName);
        ImageView picture = convertView.findViewById(R.id.imagePic);

        // Set textview.
        Friend currentFriend = friends.get(position);
        name.setText(currentFriend.name);

        // Set imageview.
        int idDrawable = currentFriend.getDrawableId();
        picture.setImageResource(idDrawable);

        return convertView;
    }
}
