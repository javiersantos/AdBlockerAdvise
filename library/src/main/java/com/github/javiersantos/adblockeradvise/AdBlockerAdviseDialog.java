package com.github.javiersantos.adblockeradvise;

import android.content.Context;

public class AdBlockerAdviseDialog {
    private LibraryPreferences libraryPreferences;
    private Context context;
    private boolean onlyOnce;
    private String title;
    private String text;

    /**
     * Shows an Alert Dialog if an Ad blocker is activated with default title and content
     *
     * @param context Context
     */
    public AdBlockerAdviseDialog(Context context) {
        this.libraryPreferences = new LibraryPreferences(context);
        this.context = context;
        this.title = context.getResources().getString(R.string.dialog_title);
        this.text = String.format(context.getResources().getString(R.string.dialog_text), UtilsLibrary.getAppName(context));
        this.onlyOnce = false;
    }

    /**
     * Set a custom title for the dialog (when an ad blocker is enabled)
     *
     * @param title dialog title
     * @return this
     */
    public AdBlockerAdviseDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Set a custom descripion for the dialog (when an ad blocker is enabled)
     *
     * @param content dialog description
     * @return this
     */
    public AdBlockerAdviseDialog setContent(String content) {
        this.text = content;
        return this;
    }

    /**
     * Set if the dialog will be only shown once. Default: false.
     *
     * @param onlyOnce display dialog only once
     */
    public AdBlockerAdviseDialog showOnlyOnce(Boolean onlyOnce) {
        this.onlyOnce = onlyOnce;
        return this;
    }

    /**
     * Shows an Alert Dialog if an Ad blocker is activated with default title and content
     *
     * @param context Context
     * @param onlyOnce Alert Dialog will be showed only one time
     * @deprecated use {@link #AdBlockerAdviseDialog(Context)} instead
     */
    @Deprecated
    public AdBlockerAdviseDialog(Context context, boolean onlyOnce) {
        this.libraryPreferences = new LibraryPreferences(context);
        this.context = context;
        this.title = context.getResources().getString(R.string.dialog_title);
        this.text = String.format(context.getResources().getString(R.string.dialog_text), UtilsLibrary.getAppName(context));
        this.onlyOnce = onlyOnce;
    }

    /**
     * Shows an Alert Dialog if an Ad blocker is activated with custom title and content
     *
     * @param context Context
     * @param title Title of the Alert Dialog
     * @param text Content of the Alert Dialog
     * @deprecated use {@link #AdBlockerAdviseDialog(Context)} instead
     */
    @Deprecated
    public AdBlockerAdviseDialog(Context context, String title, String text) {
        this.libraryPreferences = new LibraryPreferences(context);
        this.context = context;
        this.title = title;
        this.text = text;
        this.onlyOnce = false;
    }

    /**
     * Shows an Alert Dialog if an Ad blocker is activated with custom title and content
     *
     * @param context Context
     * @param title Title of the Alert Dialog
     * @param text Content of the Alert Dialog
     * @param onlyOnce Alert Dialog will be showed only one time
     * @deprecated use {@link #AdBlockerAdviseDialog(Context)} instead
     */
    @Deprecated
    public AdBlockerAdviseDialog(Context context, String title, String text, boolean onlyOnce) {
        this.libraryPreferences = new LibraryPreferences(context);
        this.context = context;
        this.title = title;
        this.text = text;
        this.onlyOnce = onlyOnce;
    }

    /**
     * Execute AdBlockerAdviseDialog in background
     *
     * @deprecated use {@link #start()} instead
     */
    public void show() {
        start();
    }

    /**
     * Execute AdBlockerAdviseDialog in background
     */
    public void start() {
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
