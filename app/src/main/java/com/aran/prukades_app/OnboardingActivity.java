package com.aran.prukades_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OnboardingActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private LinearLayout dotLayout;
    private SliderAdapter sliderAdapter;
    private TextView[] mDots;

    private Button nxt, prv;
    private int currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        setContentView(R.layout.activity_onboarding);

        viewPager = (ViewPager) findViewById(R.id.on_boarding_view);
        dotLayout = (LinearLayout) findViewById(R.id.indicator);

        nxt = (Button) findViewById(R.id.next_btn);
        prv = (Button) findViewById(R.id.prev_btn);

        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        viewPager.addOnPageChangeListener(viewListener);

        nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(currentPage + 1);
            }
        });

        prv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(currentPage - 1);
            }
        });

    }

    public void addDotsIndicator(int position) {
        mDots = new TextView[3];
        dotLayout.removeAllViews();

        for (int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.orange_secondary));

            dotLayout.addView(mDots[i]);
        }

        if (mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.orange_primary));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int p, float v, int i) {

        }

        @Override
        public void onPageSelected(int p) {

            addDotsIndicator(p);
            currentPage = p;

            if (p == 0) {
                nxt.setEnabled(true);
                prv.setEnabled(false);
                prv.setVisibility(View.INVISIBLE);

                nxt.setText("Selanjutnya");
                prv.setText("");
            } else if(p == mDots.length - 1) {
                nxt.setEnabled(true);
                prv.setEnabled(true);
                prv.setVisibility(View.VISIBLE);

                nxt.setText("Masuk");
                prv.setText("Sebelumnya");
            } else {
                nxt.setEnabled(true);
                prv.setEnabled(true);
                prv.setVisibility(View.VISIBLE);

                nxt.setText("Selanjutnya");
                prv.setText("Sebelumnya");
            }

        }

        @Override
        public void onPageScrollStateChanged(int s) {

        }
    };
}