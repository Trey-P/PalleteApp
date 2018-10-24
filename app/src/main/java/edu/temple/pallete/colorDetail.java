package edu.temple.pallete;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 */
public class colorDetail extends Fragment {
    Context context;
    View v;
    String color = "RED";

    public static String COLOR_KEY= "Red";

    public colorDetail() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         Bundle bundle = getArguments();
        this.color= bundle.getString(COLOR_KEY);
    }

    public static colorDetail newInstance(String Color)
    {
        colorDetail cD = new colorDetail();
        Bundle bundle = new Bundle();
        bundle.putString(colorDetail.COLOR_KEY,Color);
        cD.setArguments(bundle);
        return cD;
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        this.context=context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_color_detail, container, false);
        change(color);
        return v;
    }

    public void change(String newColor)
    {

        v.setBackgroundColor(Color.parseColor(newColor));
    }
}
