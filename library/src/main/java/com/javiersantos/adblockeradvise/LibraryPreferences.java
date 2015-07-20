package com.javiersantos.adblockeradvise;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

class LibraryPreferences {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;

    public static final String KeyAdblockerAdvise = "prefAdblockerAdvise";

    public LibraryPreferences(Context context) {
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.editor = sharedPreferences.edit();
        this.context = context;
    }

    public Boolean getAdblockerAdvise() {
        return sharedPreferences.getBoolean(KeyAdblockerAdvise, false);
    }

    public void setAdblockerAdvise(Boolean res) {
        editor.putBoolean(KeyAdblockerAdvise, res);
        editor.commit();
    }

}
