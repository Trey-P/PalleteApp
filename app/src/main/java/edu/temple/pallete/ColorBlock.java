package edu.temple.pallete;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class ColorBlock extends Fragment {
    View v;
    int color;
    Context parent;
    ListView listView;
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

    public void onAttach(Context context)
    {
        super.onAttach(context);
        if(!(context instanceof Colorchanger)){}
        this.parent=context;
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
        Resources res = getResources();
        v = inflater.inflate(R.layout.fragment_color_block,container,false);
        listView = v.findViewById(R.id.listView);
        Backgroundsetter adapter = new Backgroundsetter(parent,android.R.layout.simple_expandable_list_item_1,res.getStringArray(R.array.Colors));
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parentView, View view, int position, long id) {
                String colorName = (String) parentView.getItemAtPosition(position);
                ((Colorchanger) parent).colorSelected(colorName);
            }
        });

        v.setBackgroundColor(color);
        return v ;
        };
    interface Colorchanger{
        void colorSelected(String colorName);
    }

}
