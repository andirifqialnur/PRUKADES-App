package com.aran.prukades_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter (Context context) {
        this.context = context;
    }

    //Arrays
    public String[] slide_title1 = {
            "Produk",
            "Pembayaran",
            "Konfirmasi"
    };

    public String[] slide_title2 = {
            "Lokal",
            "Mudah",
            "Pesanan"
    };

    public int[] slide_image = {
            R.drawable.onboarding1,
            R.drawable.onboarding2,
            R.drawable.onboarding3
    };

    public String[] slide_title3 = {
            "Produk Lokal Khas Soppeng",
            "Pembayaran yang mudah",
            "Konfirmasi pesanan yang cepat"
    };

    public String[] slide_desc = {
            "Lorem ipsum dolor sit amet consectetur. In rhoncus donec id euismod egestas iaculis sit at nunc.",
            "Lorem ipsum dolor sit amet consectetur. In rhoncus donec id euismod egestas iaculis sit at nunc.",
            "Lorem ipsum dolor sit amet consectetur. In rhoncus donec id euismod egestas iaculis sit at nunc."
    };

    @Override
    public int getCount() {
        return slide_title1.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider, container, false);

        TextView vslide_title1 = (TextView) view.findViewById(R.id.id_title);
        TextView vslide_title2 = (TextView) view.findViewById(R.id.id_title2);
        ImageView vslide_image = (ImageView) view.findViewById(R.id.image_onboarding);
        TextView vslide_title3 = (TextView) view.findViewById(R.id.id_title3);
        TextView vslide_desc = (TextView) view.findViewById(R.id.id_onbard_desc);

        vslide_title1.setText(slide_title1[position]);
        vslide_title2.setText(slide_title2[position]);
        vslide_image.setImageResource(slide_image[position]);
        vslide_title3.setText(slide_title3[position]);
        vslide_desc.setText(slide_desc[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int postition, Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
