package com.github.javiersantos.adblockeradvise;

public class AdBlockerAdvise {

    /**
     * Checks if an Ad blocker is activated
     *
     * @return true if an Ad blocker is activated and false otherwise
     */
    public static Boolean isAdBlockerActivated() {
        Boolean res = false;
        if (UtilsLibrary.isAdBlockerActivated()) {
            res = true;
        }

        return res;
    }

}
