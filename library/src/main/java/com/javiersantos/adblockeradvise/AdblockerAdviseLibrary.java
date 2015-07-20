package com.javiersantos.adblockeradvise;

import android.content.Context;
import android.support.annotation.Nullable;

public class AdblockerAdviseLibrary {

    /**
     * Checks if an Ad blocker is activated
     * @param context
     * @return true if an Ad blocker is activated and false otherwise
     */
    static Boolean isAdblockerActivated(Context context) {
        Boolean res = false;
        if (UtilsChecker.isAdblockActivated()) {
            res = true;
        }

        return res;
    }

    /**
     * Shows an Alert Dialog if an Ad blocker is activated
     * @param context
     * @param title Title of the Alert Dialog
     * @param text Content of the Alert Dialog
     * @param onlyOnce Alert Dialog will be showed only one time
     */
    static void showAlertDialog(Context context, @Nullable String title, @Nullable String text, Boolean onlyOnce) {
        Boolean res = false;
        if (onlyOnce) {
            LibraryPreferences libraryPreferences = new LibraryPreferences(context);
            if (!libraryPreferences.getAdblockerAdvise()) {
                res = isAdblockerActivated(context);
            }
        } else {
            res = isAdblockerActivated(context);
        }

        if (res) {
            UtilsDialog.showTitleContent(context, title, text);
        }
    }

}
