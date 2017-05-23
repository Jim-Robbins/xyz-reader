package com.example.xyzreader.remote;

import android.util.Log;

import java.net.MalformedURLException;
import java.net.URL;

public class Config {
    public static final URL BASE_URL;
    private static String TAG = Config.class.toString();

    static {
        URL url = null;
        try {
            String apiKey = "9e0654f284bf4f42bbbdb5d6adec1dd3";
            url = new URL("https://newsapi.org/v1/articles?source=the-new-york-times&apiKey="+apiKey );
        } catch (MalformedURLException ignored) {
            // TODO: throw a real error
            Log.e(TAG, "Please check your internet connection.");
        }

        BASE_URL = url;
    }
}
