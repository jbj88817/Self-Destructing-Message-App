package com.example.bojie.ribbit;

import android.app.Application;

import com.parse.Parse;

public class RibbitApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "tIJtDxMfC6tzgfcugeISNXv7uAhzeKxtoOaOKG22",
                "B3Co0U3hz1q0tfEVasgV29AKMBg2ZepQzUBVk6FN");

    }
}
