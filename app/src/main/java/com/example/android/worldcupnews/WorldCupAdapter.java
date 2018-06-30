package com.example.android.worldcupnews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class WorldCupAdapter extends ArrayAdapter<WorldCup> {


    public WorldCupAdapter(Context context, List<WorldCup> worldCup) {
        super( context, 0, worldCup );
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from( getContext() ).inflate(
                    R.layout.list_item, parent, false );
        }


        WorldCup currentWorldCup = getItem( position );


        String type = currentWorldCup.getType();


        String title = currentWorldCup.getWebTitle();


        //Find the TextView with view ID location
        TextView titleView = (TextView) listItemView.findViewById( R.id.title );

        titleView.setText( title );

        // Find the TextView with view ID location offset
        TextView typeView = (TextView) listItemView.findViewById( R.id.type );

        typeView.setText( type );

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById( R.id.date );

        String formattedDate = currentWorldCup.getWebPublicationDate();


        dateView.setText( formattedDate );

        // Return the list item view
        return listItemView;
    }

}



