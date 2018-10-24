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

public class PalleteActivity extends AppCompatActivity implements ColorBlock.Colorchanger{
    Spinner spinner;
    ListView listView;
    colorDetail canvas;
    //private boolean spinnertouch = false;
    boolean singlepane;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pallete);
        final ColorBlock colorBlock = new ColorBlock();
        final String Colors[]= {"White","Red","Green", "Blue","Yellow","Magenta"};

        singlepane = findViewById(R.id.container_2) == null;
        //final Bundle bundle = new Bundle();
        //spinner = findViewById(R.id.spinner);
        //Resources res = getResources();
        //Backgroundsetter adapter = new Backgroundsetter(PalleteActivity.this,android.R.layout.simple_dropdown_item_1line,res.getStringArray(R.array.Colors));
        //spinner.setAdapter(adapter);
        /*spinner.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                spinnertouch= true;
                return false;
            }
        });
        */
        canvas =colorDetail.newInstance("White");
        FragmentManager fm = getSupportFragmentManager();
         FragmentTransaction ft = fm.beginTransaction();

         ft.replace(R.id.container_1,new ColorBlock()).addToBackStack(null).commit();

         if (!singlepane)
         {
             FragmentManager fm2 = getSupportFragmentManager();
             FragmentTransaction ft2 = fm.beginTransaction();

             ft2.add(R.id.container_2,canvas).addToBackStack(null).commit();
         }
       /* ft.add(R.id.container_1, colorBlock).addToBackStack(null).commit();

                ColorBlock colorBlock2 = new ColorBlock();
                FragmentManager FR = getSupportFragmentManager();
                FragmentTransaction FT2 = FR.beginTransaction();
                colorBlock2.changeColor(Color.parseColor(Colors[position]));
                FT2.add(R.id.container_1, colorBlock2).addToBackStack(null).commit();

                */
            }

    @Override
    public void colorSelected(String colorName) {
        if (singlepane)
        {
            colorDetail CD = colorDetail.newInstance(colorName);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.container_1,CD).addToBackStack(null).commit();

        }
        else{
            canvas.change(colorName);
        }
    }
}
