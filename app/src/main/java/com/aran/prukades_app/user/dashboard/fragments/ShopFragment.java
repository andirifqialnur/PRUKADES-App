package com.aran.prukades_app.user.dashboard.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.aran.prukades_app.R;
import com.aran.prukades_app.user.dashboard.fragments.carousel.Banner;
import com.aran.prukades_app.user.dashboard.fragments.carousel.FragmentSlider;
import com.aran.prukades_app.user.dashboard.fragments.carousel.SliderIndicator;
import com.aran.prukades_app.user.dashboard.fragments.carousel.SliderPagerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShopFragment extends Fragment {

    private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;

    private Banner banner;
    private LinearLayout mLinearLayout;

    public ShopFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_shop, container, false);

        banner = view.findViewById(R.id.sliderView);
        mLinearLayout = view.findViewById(R.id.pagesContainer);

        setupSlider();
        return view;
    }

    private void setupSlider() {
        banner.setDurationScroll(800);
        List<Fragment> fragments = new ArrayList<>();

        // image
        fragments.add(FragmentSlider.newInstance(String.valueOf(R.drawable.slider1)));
        fragments.add(FragmentSlider.newInstance(String.valueOf(R.drawable.slider2)));
        fragments.add(FragmentSlider.newInstance(String.valueOf(R.drawable.slider3)));

        mAdapter = new SliderPagerAdapter(getParentFragmentManager(), fragments);
        banner.setAdapter(mAdapter);

        mIndicator = new SliderIndicator(this.requireActivity(), mLinearLayout, banner, R.drawable.indicator_circle);
    }
}