package com.example.parker.facemaker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener, SeekBar.OnSeekBarChangeListener, OnClickListener {
    //RadioButton variables
    protected RadioButton hairSelect;
    protected RadioButton eyesSelect;
    protected RadioButton skinSelect;

    //SeekBar variables
    protected SeekBar redBar;
    protected SeekBar greenBar;
    protected SeekBar blueBar;

    //TextView variables
    protected TextView redValue;
    protected TextView greenValue;
    protected TextView blueValue;

    //Spinner variables
    protected Spinner hairSpin;
    protected Spinner eyesSpin;
    protected Spinner noseSpin;

    //String[] hairOptions;
    //String[] eyesOptions;
    //String[] noseOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //Initialize all of the RadioButtons
        hairSelect = (RadioButton)findViewById(R.id.selectHair);
        hairSelect.setOnClickListener(this);

        eyesSelect = (RadioButton)findViewById(R.id.selectEyes);
        eyesSelect.setOnClickListener(this);

        skinSelect = (RadioButton)findViewById(R.id.selectSkin);
        skinSelect.setOnClickListener(this);

        //Initialize all of the SeekBars
        redBar = (SeekBar)findViewById(R.id.redBar);
        redBar.setOnSeekBarChangeListener(this);

        greenBar = (SeekBar)findViewById(R.id.greenBar);
        greenBar.setOnSeekBarChangeListener(this);

        blueBar = (SeekBar)findViewById(R.id.blueBar);
        blueBar.setOnSeekBarChangeListener(this);

        //Initialize rgb value TextViews
        redValue = (TextView)findViewById(R.id.redValue);
        greenValue = (TextView)findViewById(R.id.greenValue);
        blueValue = (TextView)findViewById(R.id.blueValue);

        //Initialize Spinners
        hairSpin = (Spinner)findViewById(R.id.hairSpinner);
        hairSpin.setAdapter((SpinnerAdapter) this);

       // hairOptions = getResources().getStringArray(R.array.hair_select);
       // eyesOptions = getResources().getStringArray(R.array.eyes_select);
       // noseOptions = getResources().getStringArray(R.array.nose_select);
    }

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
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.selectHair){
            hairSelect.setChecked(true);
            eyesSelect.setChecked(false);
            skinSelect.setChecked(false);
        }
        else if(v.getId() == R.id.selectEyes){
            hairSelect.setChecked(false);
            eyesSelect.setChecked(true);
            skinSelect.setChecked(false);
        }
        else if(v.getId() == R.id.selectSkin){
            hairSelect.setChecked(false);
            eyesSelect.setChecked(false);
            skinSelect.setChecked(true);
        }

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if(seekBar == redBar){
            redValue.setText("Red: "+progress);
        }
        else if(seekBar == blueBar){
            blueValue.setText("Blue: "+progress);
        }
        else if(seekBar == greenBar){
            greenValue.setText("Green: "+progress);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
