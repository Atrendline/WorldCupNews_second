package com.example.android.worldcupnews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class WorldCupAdapter extends ArrayAdapter<WorldCup> {


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

        return listItemView;
    }

    private String formatDate(Date dateObject) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss.SSSZ" );
        return dateFormat.format( dateObject );
    }
}



