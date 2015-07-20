package com.javiersantos.adblockeradvisedemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.javiersantos.adblockeradvise.*;


public class MainActivity extends AppCompatActivity {
    private Context context;
    private Toolbar toolbar;
    private CardView card_again;
    private CardView card_custom;
    private TextView card_title;
    private TextView card_description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.context = this;

        initUI();
        initAdBlocker();

    }

    private void initUI() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.app_name);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
    }

    private void initAdBlocker() {
        final AdBlockerAdviseDialog adBlockerAdviseDialog = new AdBlockerAdviseDialog(context, false);
        final AdBlockerAdviseDialog adBlockerAdviseDialogCustom = new AdBlockerAdviseDialog(context,
                getResources().getString(R.string.custom_dialog),
                getResources().getString(R.string.custom_dialog_content),
                false);

        card_again = (CardView) findViewById(R.id.card_again);
        card_custom = (CardView) findViewById(R.id.card_custom);
        card_title = (TextView) findViewById(R.id.adblockeradvise_title);
        card_description = (TextView) findViewById(R.id.adblockeradvise_description);

        if (AdBlockerAdvise.isAdBlockerActivated()) {
            adBlockerAdviseDialog.show();
            card_title.setText(getResources().getString(R.string.yes_adblocker));
            card_description.setText(getResources().getString(R.string.yes_adblocker_description));
        } else {
            card_title.setText(getResources().getString(R.string.no_adblocker));
            card_description.setText(getResources().getString(R.string.no_adblocker_description));
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
