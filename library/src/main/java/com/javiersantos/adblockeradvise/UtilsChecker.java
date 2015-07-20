package com.javiersantos.adblockeradvise;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

class UtilsChecker {

    static Boolean isAdblockActivated() {
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }
}
