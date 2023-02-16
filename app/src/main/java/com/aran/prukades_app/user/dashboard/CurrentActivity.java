package com.aran.prukades_app.user.dashboard;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import com.aran.prukades_app.R;
import com.aran.prukades_app.user.dashboard.fragments.CartFragment;
import com.aran.prukades_app.user.dashboard.fragments.HistoryFragment;
import com.aran.prukades_app.user.dashboard.fragments.ProfileFragment;
import com.aran.prukades_app.user.dashboard.fragments.SettingFragment;
import com.aran.prukades_app.user.dashboard.fragments.ShopFragment;

import nl.joery.animatedbottombar.AnimatedBottomBar;

public class CurrentActivity extends AppCompatActivity {

    private static final String TAG = CurrentActivity.class.getSimpleName();

    AnimatedBottomBar bottomBar;
    Toolbar toolbar;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        bottomBar = findViewById(R.id.bottom_bar);
        bottomBar.setOnTabSelectListener(new AnimatedBottomBar.OnTabSelectListener() {
            @Override
            public void onTabSelected(int lastIndex, @Nullable AnimatedBottomBar.Tab lastTab, int newIndex, @NonNull AnimatedBottomBar.Tab newTab) {
                Fragment fragment = null;
                switch (newTab.getId()){
                    case R.id.belanja:
                        fragment = new ShopFragment();
                        break;
                    case R.id.history:
                        fragment = new HistoryFragment();
                        break;
                    case R.id.keranjang:
                        fragment = new CartFragment();
                        break;
                    case R.id.profil:
                        fragment = new ProfileFragment();
                        break;
                    case R.id.pengaturan:
                        fragment = new SettingFragment();
                        break;
                }
                if (fragment != null) {
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
                } else {
                    Log.d(TAG, "Error ii we fokus ko");
                }
            }

            @Override
            public void onTabReselected(int i, @NonNull AnimatedBottomBar.Tab tab) {
            }
        });

        bottomBar.selectTabAt(0,true);
        bottomBar.isShown();

    }
}