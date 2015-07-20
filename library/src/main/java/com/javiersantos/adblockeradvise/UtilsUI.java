package com.javiersantos.adblockeradvise;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;

class UtilsUI {

    static MaterialDialog showTitleContent(Context context, String title, String text) {
        MaterialDialog.Builder materialBuilder = new MaterialDialog.Builder(context);
        materialBuilder.title(title);
        materialBuilder.content(text);
        materialBuilder.positiveText(context.getResources().getString(R.string.dialog_button));
        materialBuilder.cancelable(false);
        materialBuilder.callback(new MaterialDialog.ButtonCallback() {
            @Override
            public void onPositive(MaterialDialog dialog) {
                dialog.dismiss();
            }
        });

        return materialBuilder.show();
    }

}
