package com.example.goodworklabs.cleartriptask.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.example.goodworklabs.cleartriptask.Fragments.ActivitiesFragment;
import com.example.goodworklabs.cleartriptask.Fragments.EatOutFragment;
import com.example.goodworklabs.cleartriptask.Fragments.EventsFragment;
import com.example.goodworklabs.cleartriptask.Fragments.YouFragment;
import com.example.goodworklabs.cleartriptask.R;

public class MainActivity extends BaseActivity {
    private static final String ACTIVITIES_FRAGMENT = "ACTIVITIES_FRAGMENT";
    private static final String EAT_OUT_FRAGMENT = "EAT_OUT_FRAGMENT";
    private static final String EVENTS_FRAGMENT = "EVENTS_FRAGMENT";
    private static final String YOU_FRAGMENT = "YOU_FRAGMENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nv);

        openActivitiesFragment();

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.activities:
                                openActivitiesFragment();
                                break;
                            case R.id.eat_out:
                                EatOutFragment eatOutFragment = EatOutFragment.newInstance();
                                attachFragment(eatOutFragment, EAT_OUT_FRAGMENT);
                                break;
                            case R.id.events:
                                EventsFragment eventsFragment = EventsFragment.newInstance();
                                attachFragment(eventsFragment, EVENTS_FRAGMENT);
                                break;
                            case R.id.you:
                                YouFragment youFragment = YouFragment.newInstance();
                                attachFragment(youFragment, YOU_FRAGMENT);
                                break;
                        }
                        return true;
                    }
                }
        );
    }

    private void openActivitiesFragment() {
        ActivitiesFragment activitiesFragment = ActivitiesFragment.newInstance();
        attachFragment(activitiesFragment, ACTIVITIES_FRAGMENT);
    }
}
