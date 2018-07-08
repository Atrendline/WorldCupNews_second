package com.example.android.worldcupnews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class WorldCupAdapter extends ArrayAdapter<WorldCup> {

    private static final String LOCATION_SEPARATOR = "T";

    private int author;
    private int section;


    public WorldCupAdapter(Context context, List<WorldCup> worldCup) {
        super( context, 0, worldCup );
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from( getContext() ).inflate(
                    R.layout.list_item, parent, false );
        }


        WorldCup currentWorldCup = getItem( position );

        TextView titleTextView = (TextView) listItemView.findViewById( R.id.title_text_view );
        String title = currentWorldCup.getWebTitle();
        titleTextView.setText( title );

        TextView sectionTextView = (TextView) listItemView.findViewById( R.id.section_text_view );
        String section = currentWorldCup.getSection();
        sectionTextView.setText( section );

        TextView authorTextView = (TextView) listItemView.findViewById( R.id.author_text_view );
        String author = currentWorldCup.getAuthor();
        authorTextView.setText( author );

        TextView dateTextView = (TextView) listItemView.findViewById( R.id.date_text_view );
        String formattedDate = currentWorldCup.getWebPublicationDate();
        dateTextView.setText( formattedDate );

        String[] parts = formattedDate.split( LOCATION_SEPARATOR );
        String date = parts[0];

        dateTextView.setText( date );

        return listItemView;
    }


}



