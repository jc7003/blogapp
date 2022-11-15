package com.owen.blogapp;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTabHost;

import com.owen.blogapp.fragment.CustomViewFragmentSupport;
import com.owen.blogapp.fragment.IndexTabFragmentSupport;
import com.owen.blogapp.fragment.SettingFragmentSupport;

public class MainActivity extends FragmentActivity {

    private FragmentTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabHost = findViewById(R.id.tabshost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        Bundle bundle = new Bundle();
        bundle.putString(IndexTabFragmentSupport.ID, "index");
        mTabHost.addTab(mTabHost.newTabSpec("index").setIndicator("", getDrawable(R.drawable.ic_android_black_24dp)),
                IndexTabFragmentSupport.class, bundle);

        bundle = new Bundle();
        bundle.putString(IndexTabFragmentSupport.ID, "list");
        mTabHost.addTab(mTabHost.newTabSpec("list").setIndicator("", getDrawable(R.drawable.ic_apps_black_24dp)),
                SettingFragmentSupport.class, bundle);
        bundle = new Bundle();
        bundle.putString(IndexTabFragmentSupport.ID, "test");
        mTabHost.addTab(mTabHost.newTabSpec("test").setIndicator("", getDrawable(R.drawable.ic_add_black_24dp)),
                CustomViewFragmentSupport.class, bundle);
        bundle = new Bundle();
        bundle.putString(IndexTabFragmentSupport.ID, "test2");
        mTabHost.addTab(mTabHost.newTabSpec("test2").setIndicator("", getDrawable(R.drawable.ic_free_breakfast_black_24dp)),
                IndexTabFragmentSupport.class, bundle);

        bundle = new Bundle();
        bundle.putString(IndexTabFragmentSupport.ID, "account");
        mTabHost.addTab(mTabHost.newTabSpec("account").setIndicator("", getDrawable(R.drawable.ic_assignment_ind_black_24dp)),
                IndexTabFragmentSupport.class, bundle);

//        mTabHost.addTab(mTabHost.newTabSpec("simple").setIndicator("Index"),
//                FragmentStackSupport.CountingFragment.class, null);
//        mTabHost.addTab(mTabHost.newTabSpec("contacts").setIndicator("Contacts"),
//                LoaderCursorSupport.CursorLoaderListFragment.class, null);
//        mTabHost.addTab(mTabHost.newTabSpec("custom").setIndicator("Custom"),
//                LoaderCustomSupport.AppListFragment.class, null);
//        mTabHost.addTab(mTabHost.newTabSpec("throttle").setIndicator("Throttle"),
//                LoaderThrottleSupport.ThrottledLoaderListFragment.class, null);

    }
}
