package edu.temple.pallete;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class ColorBlock extends Fragment {
    View v;
    int color;
    public static String Color_key = "TRANSPARENT";
    public ColorBlock() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // Bundle bundle = getArguments();
       // color= bundle.getInt(Color_key);
    }

    public static ColorBlock newInstance(int test){
        ColorBlock ColorFragment = new ColorBlock();
        Bundle bundle = new Bundle();
        bundle.putInt(ColorFragment.Color_key, test);
        ColorFragment.setArguments(bundle);
        return ColorFragment;
    }
    public void changeColor(int Color)
    {
        this.color=Color;
        if (v !=null)
            v.setBackgroundColor(Color);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Its in onCreateView where we assign the button and the instance to the instance variable to V is null prior too
        // Inflate the layout for this frag
        v = inflater.inflate(R.layout.fragment_color_block,container,false);
        v.setBackgroundColor(color);
        return v ;
        };


}
