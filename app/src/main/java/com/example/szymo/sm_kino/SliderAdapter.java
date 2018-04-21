package com.example.szymo.sm_kino;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by szymo on 25.03.2018.
 */

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    public  SliderAdapter(Context context){
        this.context=context;
    }
    public int [] slideImage={
            R.drawable.poz1,
            R.drawable.poz2,
            R.drawable.poz3,
            R.drawable.poz4,
            R.drawable.poz5,
            R.drawable.poz6
    };
    public String[] naglowki ={
            "Kobiety Mafi","PitBull: Ostani Pies","Czerwona Jaskólka","Wieczór Gier","Lady Bird","Gnomeo I julia"
    };
    public String[] kraj={
            "Polska","Polska","USA","USA,Nimecy","USA","USA"
    };
    public String[] rok={
            "2018","2018","2018","2018","2018","2018"
    };
    public String[] gatnuek={"Dramat","Dramat","Thriller ","Komedia","Komedio Dramat","Animacja"};
    @Override
    public int getCount() {
        return slideImage.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==(RelativeLayout) object;
    }
    @Override
    public  Object instantiateItem(ViewGroup container,int position){
    layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide_layout,container,false);
        ImageView slideImageView=view.findViewById(R.id.plakat);
        TextView slideNaglowki=view.findViewById(R.id.tytul);
        TextView slideKraj=view.findViewById(R.id.kraj);
        TextView slideRok=view.findViewById(R.id.rok);
        TextView sliderGatunek=view.findViewById(R.id.gatunek);
        slideImageView.setImageResource(slideImage[position]);
        slideNaglowki.setText(naglowki[position]);
        slideKraj.setText(kraj[position]);
        slideRok.setText(rok[position]);
        sliderGatunek.setText(gatnuek[position]);
        container.addView(view);

        return  view;
    }

    @Override
    public void destroyItem(ViewGroup container,int position,Object object){
        container.removeView((RelativeLayout)object);
    }
}
