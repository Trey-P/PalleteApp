package edu.temple.pallete;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Wallpaper extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper);
        Intent intent = getIntent();
        String Colorset = intent.getStringExtra("Color");
        View root = findViewById(R.id.cons);
        View backroot = root.getRootView();
        backroot.setBackgroundColor(Color.parseColor(Colorset));

    }

}
