package com.example.android.worldcupnews;

public class WorldCup {

    /**
     * Type of the article
     */
    private String mType;

    /**
     * Title of the article
     */
    private String mTitle;

    /**
     * Publication date of the article
     */
    private String mWebPublicationDate;

    /**
     * Website URL of The Guardian
     */

    private String mUrl;

    public WorldCup(String type, String webTitle, String webPublicationDate, String url) {
        mType = type;
        mTitle = webTitle;
        mWebPublicationDate = webPublicationDate;
        mUrl = url;
    }

    /**
     * Returns the type of the article.
     */
    public String getType() {
        return mType;
    }

    /**
     * Returns the title of the article.
     */
    public String getWebTitle() {
        return mTitle;
    }

    /**
     * Returns the date of the article.
     */
    public String getWebPublicationDate() {
        return mWebPublicationDate;
    }

    /**
     * Returns the website URL to find the exact article.
     */
    public String getUrl() {
        return mUrl;
    }
}
