package com.github.javiersantos.adblockeradvise;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

class UtilsLibrary {

    static Boolean isAdBlockerActivated() {
        Boolean res = false;

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("/etc/hosts")));
            String line;

            while ((line = in.readLine()) != null) {
                if (line.contains("admob")) {
                    res = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }

    static String getAppName(Context context) {
        return context.getString(context.getApplicationInfo().labelRes);
    }

}
