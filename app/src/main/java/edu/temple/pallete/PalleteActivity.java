package edu.temple.pallete;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.List;

public class PalleteActivity extends AppCompatActivity {
    Spinner spinner;
    ListView listView;
    private boolean spinnertouch = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pallete);
        final ColorBlock colorBlock = new ColorBlock();
        final String Colors[]= {"White","Red","Green", "Blue","Yellow","Magenta"};
        final Bundle bundle = new Bundle();
        spinner = findViewById(R.id.spinner);
        Resources res = getResources();
        Backgroundsetter adapter = new Backgroundsetter(PalleteActivity.this,android.R.layout.simple_dropdown_item_1line,res.getStringArray(R.array.Colors));
        spinner.setAdapter(adapter);
        spinner.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                spinnertouch= true;
                return false;
            }
        });
        FragmentManager fm = getSupportFragmentManager();
         FragmentTransaction ft = fm.beginTransaction();

        ft.add(R.id.container_1, colorBlock).addToBackStack(null).commit();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (!spinnertouch) return;
                ColorBlock colorBlock2 = new ColorBlock();
                FragmentManager FR = getSupportFragmentManager();
                FragmentTransaction FT2 = FR.beginTransaction();
                colorBlock2.changeColor(Color.parseColor(Colors[position]));
                FT2.add(R.id.container_1, colorBlock2).addToBackStack(null).commit();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    /*
    public void setFragment(Fragment fragment, String color)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        //Next describe the action you would like to perform
        //Bundle bundle = new Bundle();
        //bundle.putInt(ColorBlock.Color_key, Color.parseColor(color));
        ft.add(R.id.container_1, fragment)
                .addToBackStack(null)
                .commit();
    }
    */
}
