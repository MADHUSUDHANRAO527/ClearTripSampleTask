package com.example.goodworklabs.cleartriptask.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.goodworklabs.cleartriptask.R;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Madhu on 17/04/17.
 */
public class BaseActivity extends AppCompatActivity {
    public Stack<Fragment> mFragmentStack = null;
    public ArrayList<String> mNotificationStack;
    FragmentManager mFragmentManager;
    Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        mFragmentManager = getSupportFragmentManager();
    }

    public static void showToastErrorMessage(Context context, String error) {
        showToast(context, error);
    }

    public static void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
    public void attachFragment(Fragment fragment, String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment, tag)
                .disallowAddToBackStack()
                .commit();
    }
}
