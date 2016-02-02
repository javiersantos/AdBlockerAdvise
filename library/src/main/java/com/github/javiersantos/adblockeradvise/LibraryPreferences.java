package com.github.javiersantos.adblockeradvise;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

class LibraryPreferences {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public static final String KeyAdBlockerAdvise = "prefAdBlockerAdvise";

    public LibraryPreferences(Context context) {
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.editor = sharedPreferences.edit();
    }

    public Boolean getAdBlockerAdvise() {
        return sharedPreferences.getBoolean(KeyAdBlockerAdvise, false);
    }

    public void setAdBlockerAdvise(Boolean res) {
        editor.putBoolean(KeyAdBlockerAdvise, res);
        editor.commit();
    }

}
