package com.javiersantos.adblockeradvise;

import android.content.Context;

public class AdBlockerAdviseDialog {
    private LibraryPreferences libraryPreferences;
    private Context context;
    private boolean onlyOnce = false;
    private String title;
    private String text;

    /**
     * Shows an Alert Dialog if an Ad blocker is activated with default title and content
     * @param context
     * @param onlyOnce Alert Dialog will be showed only one time
     */
    public AdBlockerAdviseDialog(Context context, boolean onlyOnce) {
        this.libraryPreferences = new LibraryPreferences(context);
        this.context = context;
        this.title = context.getResources().getString(R.string.dialog_title);
        this.text = String.format(context.getResources().getString(R.string.dialog_text), UtilsLibrary.getAppName(context));
        this.onlyOnce = onlyOnce;
    }

    /**
     * Shows an Alert Dialog if an Ad blocker is activated with custom title and content
     * @param context
     * @param title Title of the Alert Dialog
     * @param text Content of the Alert Dialog
     * @param onlyOnce Alert Dialog will be showed only one time
     */
    public AdBlockerAdviseDialog(Context context, String title, String text, boolean onlyOnce) {
        this.libraryPreferences = new LibraryPreferences(context);
        this.context = context;
        this.title = title;
        this.text = text;
        this.onlyOnce = onlyOnce;
    }

    public void show() {
        Boolean res = false;
        if (onlyOnce) {
            if (!libraryPreferences.getAdBlockerAdvise()) {
                res = UtilsLibrary.isAdBlockerActivated();
                libraryPreferences.setAdBlockerAdvise(true);
            }
        } else {
            res = UtilsLibrary.isAdBlockerActivated();
        }

        if (res) {
            UtilsUI.showTitleContent(context, title, text);
        }
    }

}
