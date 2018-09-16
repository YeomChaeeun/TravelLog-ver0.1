package com.example.admin.travellog.models;

/**
 * Created by a on 2018-09-16.
 */

public class Memo {
    private String memoTitle;
    private double latitude;
    private double longitude;
    private String memoContent;
    private long date;

    public Memo(String memoTitle, double latitude, double longitude, String memoContent, long date) {
        this.memoTitle = memoTitle;
        this.latitude = latitude;
        this.longitude = longitude;
        this.memoContent = memoContent;
        this.date = date;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getMemoTitle() {
        return memoTitle;
    }

    public void setMemoTitle(String memoTitle) {
        this.memoTitle = memoTitle;
    }

    public String getMemoContent() {
        return memoContent;
    }

    public void setMemoContent(String memoContent) {
        this.memoContent = memoContent;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Memo{" +
                "memoTitle='" + memoTitle + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", memoContent='" + memoContent + '\'' +
                ", date=" + date +
                '}';
    }
}
