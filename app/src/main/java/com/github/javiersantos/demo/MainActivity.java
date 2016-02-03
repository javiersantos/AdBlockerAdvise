package com.github.javiersantos.demo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.github.javiersantos.adblockeradvise.*;


public class MainActivity extends AppCompatActivity {
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.github.javiersantos.demo.R.layout.activity_main);
        this.context = this;

        initUI();
        initAdBlocker();

    }

    private void initUI() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.app_name);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
    }

    private void initAdBlocker() {
        // Default AdBlockerAdviseDialog
        final AdBlockerAdviseDialog adBlockerAdviseDialog = new AdBlockerAdviseDialog(context);

        // Custom AdBlockerAdviseDialog
        final AdBlockerAdviseDialog adBlockerAdviseDialogCustom = new AdBlockerAdviseDialog(context);
        adBlockerAdviseDialogCustom.setTitle(getResources().getString(R.string.custom_dialog));
        adBlockerAdviseDialogCustom.setContent(getResources().getString(R.string.custom_dialog_content));

        CardView card_again = (CardView) findViewById(R.id.card_again);
        CardView card_custom = (CardView) findViewById(R.id.card_custom);
        TextView card_title = (TextView) findViewById(R.id.adblockeradvise_title);
        TextView card_description = (TextView) findViewById(R.id.adblockeradvise_description);

        if (AdBlockerAdvise.isAdBlockerActivated()) {
            adBlockerAdviseDialog.show();
            card_title.setText(getResources().getString(R.string.yes_adblocker));
            card_description.setText(getResources().getString(R.string.yes_adblocker_description));
        } else {
            card_title.setText(getResources().getString(R.string.no_adblocker));
            card_description.setText(getResources().getString(R.string.no_adblocker_description));
            card_custom.setVisibility(View.GONE);
            card_again.setVisibility(View.GONE);
        }

        card_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adBlockerAdviseDialog.show();
            }
        });

        card_custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adBlockerAdviseDialogCustom.show();
            }
        });

    }

}
