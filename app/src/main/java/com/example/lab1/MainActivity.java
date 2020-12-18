package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {

    public Button convert_am_button;
    public Button convert_eu_button;

    public Button about_button;
    public Button rules_button;
    public LinearLayout buttonsOpen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        about_button = (Button) findViewById((R.id.openAbout));
        rules_button = (Button) findViewById((R.id.openRules));

        convert_eu_button = findViewById(R.id.convert_eu_button);
        convert_am_button = findViewById(R.id.convert_am_button);
        buttonsOpen = (LinearLayout) findViewById((R.id.buttons));

        EuropeFragment europeFragment = (EuropeFragment)getFragmentManager().findFragmentById(R.id.europeFragment);
        AmericaFragment americaFragment = (AmericaFragment)getFragmentManager().findFragmentById(R.id.americaFragment);

        AboutFragment aboutFragment = (AboutFragment)getFragmentManager().findFragmentById(R.id.aboutFragment);
        RulesFragment rulesFragment = (RulesFragment)getFragmentManager().findFragmentById(R.id.rulesFragment);

        europeFragment.getView().setVisibility(View.GONE);
        americaFragment.getView().setVisibility(View.GONE);
        aboutFragment.getView().setVisibility(View.GONE);
        rulesFragment.getView().setVisibility(View.GONE);

    }


    public void openAMconverter(View view) {
        AmericaFragment am_fr = (AmericaFragment) getFragmentManager().findFragmentById(R.id.americaFragment);
        am_fr.getView().setVisibility(View.VISIBLE);
        buttonsOpen.setVisibility(View.GONE);
    }

    public void openEUconverter(View view) {
        EuropeFragment eu_fr = (EuropeFragment) getFragmentManager().findFragmentById(R.id.europeFragment);
        eu_fr.getView().setVisibility(View.VISIBLE);
        buttonsOpen.setVisibility(View.GONE);
    }


    public void openAbout(View view) {
        AboutFragment about = (AboutFragment)getFragmentManager().findFragmentById(R.id.aboutFragment);
        about.getView().setVisibility(View.VISIBLE);
        buttonsOpen.setVisibility(View.GONE);
    }

    public void openRules(View view) {
        RulesFragment rules = (RulesFragment)getFragmentManager().findFragmentById(R.id.rulesFragment);
        rules.getView().setVisibility(View.VISIBLE);
        buttonsOpen.setVisibility(View.GONE);
    }

    public void closeButton(View view) {

        AboutFragment aboutF = (AboutFragment)getFragmentManager().findFragmentById(R.id.aboutFragment);
        aboutF.getView().setVisibility(View.GONE);


        AmericaFragment americaF = (AmericaFragment) getFragmentManager().findFragmentById(R.id.americaFragment);
        americaF.getView().setVisibility(View.GONE);


        EuropeFragment europeF = (EuropeFragment) getFragmentManager().findFragmentById(R.id.europeFragment);
        europeF.getView().setVisibility(View.GONE);


        RulesFragment rulesF = (RulesFragment)getFragmentManager().findFragmentById(R.id.rulesFragment);
        rulesF.getView().setVisibility(View.GONE);
        buttonsOpen.setVisibility(View.VISIBLE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.set_eu) {
            EuropeFragment europe = (EuropeFragment) getFragmentManager().findFragmentById(R.id.europeFragment);
            europe.getView().setVisibility(View.VISIBLE);
            buttonsOpen.setVisibility(View.GONE);
        }
        if (id == R.id.set_am) {
            AmericaFragment america = (AmericaFragment) getFragmentManager().findFragmentById(R.id.americaFragment);
            america.getView().setVisibility(View.VISIBLE);
            buttonsOpen.setVisibility(View.GONE);

        }
        if (id == R.id.set_about) {
            AboutFragment mapFragment = (AboutFragment) getFragmentManager().findFragmentById(R.id.aboutFragment);
            mapFragment.getView().setVisibility(View.VISIBLE);
            buttonsOpen.setVisibility(View.GONE);

        }
        if (id == R.id.set_rules) {
            RulesFragment rule = (RulesFragment) getFragmentManager().findFragmentById(R.id.rulesFragment);
            rule.getView().setVisibility(View.VISIBLE);
            buttonsOpen.setVisibility(View.GONE);

        }
        if (id == R.id.set_share) {
            EuropeFragment europeFragment = (EuropeFragment) getFragmentManager().findFragmentById(R.id.europeFragment);

            if (europeFragment.isResumed()) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareBody = "Ось така сума виходить: " + europeFragment.result_field_eu.getText();
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareBody);
                myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(myIntent, "Share result"));
                return true;
            } else {
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }


}
