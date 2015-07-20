package com.javiersantos.adblockeradvise;

import android.content.Context;
import android.content.pm.PackageManager;

import com.afollestad.materialdialogs.MaterialDialog;
import com.javiersantos.appupdater.R;

class UtilsDialog {

    static MaterialDialog showTitleContent(Context context, String title, String text) {
        MaterialDialog.Builder materialBuilder = new MaterialDialog.Builder(context);
        if (title == null) {
            materialBuilder.title(context.getResources().getString(R.string.dialog_title));
        } else {
            materialBuilder.title(title);
        }
        if (text == null) {
            String appName;
            try {
                appName = context.getPackageManager().getApplicationInfo(context.getApplicationInfo().packageName, 0).toString();
            } catch (PackageManager.NameNotFoundException e) {
                appName = context.getResources().getString(R.string.dialog_this_app);
                e.printStackTrace();
            }
            materialBuilder.content(String.format(context.getResources().getString(R.string.dialog_text), appName));
        } else {
            materialBuilder.content(text);
        }
        materialBuilder.positiveText(context.getResources().getString(R.string.dialog_button));
        materialBuilder.cancelable(true);
        materialBuilder.callback(new MaterialDialog.ButtonCallback() {
            @Override
            public void onPositive(MaterialDialog dialog) {
                dialog.dismiss();
            }
        });

        return materialBuilder.show();
    }

}
