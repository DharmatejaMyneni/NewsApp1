package com.example.android.newsapp1;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;


/**
 * Created by dharm on 03-09-2018.
 */
class NewsLoader extends AsyncTaskLoader<List<News>> {

    /**
     * Query URL
     */
    private final String queryUrl;

    /**
     * Constructs a new {@link NewsLoader}.
     *
     * @param context of the activity
     * @param url     to load data from
     */
    public NewsLoader(Context context, String url) {
        super(context);
        queryUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<News> loadInBackground() {
        if (queryUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of news (and return this data at the end)
        return QueryUtils.fetchNewsData(queryUrl);
    }
}