package com.example.android.worldcupnews;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;


public class WorldCupLoader extends AsyncTaskLoader<List<WorldCup>> {

    private static final String LOG_TAG = WorldCupLoader.class.getName();

    private String mUrl;

    public WorldCupLoader(Context context, String url) {
        super( context );
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }


    @Override
    public List<WorldCup> loadInBackground() {
        if (mUrl == null) {
            return null;
        }


        // Perform the network request, parse the response, and extract a list of news from The Guardian.
        List<WorldCup> worldCup = QueryUtils.fetchWorldCupData( mUrl );
        return worldCup;
    }
}
