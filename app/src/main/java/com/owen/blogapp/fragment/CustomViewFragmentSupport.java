package com.owen.blogapp.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

import com.owen.blogapp.R;

/**
 * Created by owen on 2017/12/10.
 */

public class CustomViewFragmentSupport extends Fragment {
    private static final String TAG = CustomViewFragmentSupport.class.getSimpleName();
    public static String ID = TAG + ".ID";
    private View mProgress;

    public static CustomViewFragmentSupport newInstance(String id) {
        Bundle args = new Bundle();
        args.putString(ID, id);
        CustomViewFragmentSupport fragment = new CustomViewFragmentSupport();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_custom_view, container, false);
        mProgress = root.findViewById(R.id.progress);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();

        Animation am = new RotateAnimation(0, 359, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        am.setDuration(2000);
        am.setRepeatCount(Animation.INFINITE);
        mProgress.setAnimation(am);
        am.startNow();
    }
}
