package com.example.android.worldcupnews;

public class WorldCup {

    private String mSection;

    private String mTitle;

    private String mAuthor;

    private String mWebPublicationDate;

    private String mUrl;

    public WorldCup(String sectionName, String webTitle, String author, String webPublicationDate, String url) {
        mSection = sectionName;
        mTitle = webTitle;
        mWebPublicationDate = webPublicationDate;
        mAuthor = author;
        mUrl = url;
    }

    public String getSection() {
        return mSection;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getWebTitle() {
        return mTitle;
    }

    public String getWebPublicationDate() {
        return mWebPublicationDate;
    }

    public String getUrl() {
        return mUrl;
    }
}
