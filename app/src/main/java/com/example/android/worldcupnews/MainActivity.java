//Source: Udacity ABND Earthquake app/

package com.example.android.worldcupnews;

import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity
        implements LoaderCallbacks<List<WorldCup>> {

    private static final String LOG_TAG = MainActivity.class.getName();


    /**
     * URL for worldcup data from The Guardian dataset
     */
    private static final String GUARDIAN_REQUEST_URL =

            "https://content.guardianapis.com/search?q=fifa%20world%20cup&api-key=9306b177-3884-4146-8724-9e84db49c350";

    private static final int GUARDIAN_LOADER_ID = 1;


    private WorldCupAdapter mAdapter;

    /**
     * TextView that is displayed when the list is empty
     */
    private TextView mEmptyStateTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        ListView worldCupListView = (ListView) findViewById( R.id.list );
        mEmptyStateTextView = (TextView) findViewById( R.id.empty_view );
        worldCupListView.setEmptyView( mEmptyStateTextView );


        mAdapter = new WorldCupAdapter( this, new ArrayList<WorldCup>() );


        worldCupListView.setAdapter( mAdapter );


        worldCupListView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                WorldCup currentWorldCup = mAdapter.getItem( position );


                Uri worldCupUri = Uri.parse( currentWorldCup.getUrl() );


                Intent websiteIntent = new Intent( Intent.ACTION_VIEW, worldCupUri );


                startActivity( websiteIntent );
            }
        } );

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService( Context.CONNECTIVITY_SERVICE );


        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();


        if (networkInfo != null && networkInfo.isConnected()) {

            LoaderManager loaderManager = getLoaderManager();


            loaderManager.initLoader( GUARDIAN_LOADER_ID, null, this );
        } else {

            View loadingIndicator = findViewById( R.id.loading_indicator );
            loadingIndicator.setVisibility( View.GONE );


            mEmptyStateTextView.setText( R.string.no_internet_connection );
        }
    }

    @Override
    public Loader<List<WorldCup>> onCreateLoader(int i, Bundle bundle) {

        return new WorldCupLoader( this, GUARDIAN_REQUEST_URL );
    }

    @Override
    public void onLoadFinished(Loader<List<WorldCup>> loader, List<WorldCup> worldCup) {

        View loadingIndicator = findViewById( R.id.loading_indicator );
        loadingIndicator.setVisibility( View.GONE );


        mEmptyStateTextView.setText( R.string.no_news );


        if (worldCup != null && !worldCup.isEmpty()) {
            mAdapter.addAll( worldCup );
        }
    }

    @Override
    public void onLoaderReset(Loader<List<WorldCup>> loader) {

        mAdapter.clear();
    }

}



