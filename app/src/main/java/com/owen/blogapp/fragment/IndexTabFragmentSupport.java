package com.owen.blogapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.owen.blogapp.R;

/**
 * Created by owen on 2017/12/10.
 */

public class IndexTabFragmentSupport extends Fragment {
    private static final String TAG = IndexTabFragmentSupport.class.getSimpleName();
    public static String ID = TAG + ".ID";

    public static IndexTabFragmentSupport newInstance(String id) {
        Bundle args = new Bundle();
        args.putString(ID, id);
        IndexTabFragmentSupport fragment = new IndexTabFragmentSupport();
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
        View root = inflater.inflate(R.layout.fragment_index, container, false);
        ((TextView)root.findViewById(R.id.textview_id)).setText(getArguments().getString(ID));
        return root;
    }
}
