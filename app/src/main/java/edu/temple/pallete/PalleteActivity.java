package edu.temple.pallete;

import android.content.Intent;
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

        final String Colors[]= {"White","Red","Green", "Blue","Yellow","Magenta"};
        spinner = findViewById(R.id.spinner);
        Backgroundsetter adapter = new Backgroundsetter(PalleteActivity.this,android.R.layout.simple_dropdown_item_1line, Colors);
        spinner.setAdapter(adapter);
        spinner.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                spinnertouch= true;
                return false;
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (!spinnertouch) return;
                Intent startDashBoard = new Intent(PalleteActivity.this,Wallpaper.class);
                startDashBoard.putExtra("Color",Colors[position]);
                startActivity(startDashBoard);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
