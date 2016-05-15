package com.github.javiersantos.adblockeradvise;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

class UtilsUI {

    static AlertDialog showTitleContent(Context context, String title, String text) {
        return new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(text)
                .setPositiveButton(context.getResources().getString(R.string.dialog_button), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {}
                })
                .setCancelable(false).show();
    }

}
