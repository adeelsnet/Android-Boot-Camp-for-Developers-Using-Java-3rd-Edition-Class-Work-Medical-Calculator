package com.example.medicalcalculator;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private RadioButton lbToKilo, kiloToLb;
    private TextView outputResult;
    private double weightEntered, convertedWeight;
    private double conversionRate = 2.2;
    private DecimalFormat formatter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        editText = findViewById(R.id.txtWeight);
        lbToKilo = findViewById(R.id.poundsToKilo);
        kiloToLb = findViewById(R.id.kiloToPounds);
        outputResult = findViewById(R.id.outputResult);
        formatter = new DecimalFormat("#.#");

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = editText.getText().toString();
                if(input.equals("")){
                        Toast.makeText(MainActivity.this,
                                "Please Enter a number first!",
                                Toast.LENGTH_LONG).show();
                } else {
                    weightEntered = Double.parseDouble(input);

                    if(lbToKilo.isChecked()) {
                        if(weightEntered <= 500 ){
                            convertedWeight = weightEntered / conversionRate;
                            outputResult.setText(formatter.format(convertedWeight) + " Kilograms");
                        /*Snackbar.make(view, "Success!",
                                Snackbar.LENGTH_LONG).show();*/
                        }
                        else {
                            Toast.makeText(MainActivity.this,
                                    "Pounds must be less than 500",
                                    Toast.LENGTH_LONG).show();
                        }
                    } else if(kiloToLb.isChecked()) {

                        if(weightEntered <= 225 ){
                            convertedWeight = weightEntered * conversionRate;
                            outputResult.setText(formatter.format(convertedWeight) + " Pounds");
                        /*Snackbar.make(view, "Success!",
                                Snackbar.LENGTH_LONG).show();*/
                        }
                        else {
                            Toast.makeText(MainActivity.this,
                                    "Kilograms must be less than 500",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                    else {
                        Toast.makeText(MainActivity.this,
                                "Please choose kilos --> lbs OR lbs --> kilos",
                                Toast.LENGTH_LONG).show();
                    }

                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                }
            }
        });
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
