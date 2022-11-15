package com.owen.blogapp.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.owen.blogapp.R;

/**
 * Created by owen on 2017/12/10.
 */

public class SettingFragmentSupport extends Fragment implements View.OnClickListener {
    private static final String TAG = SettingFragmentSupport.class.getSimpleName();
    public static String ID = TAG + ".ID";

    private RecyclerView mRecyclerView;
    private TextView mTextView;

    public static SettingFragmentSupport newInstance(String id) {
        Bundle args = new Bundle();
        args.putString(ID, id);
        SettingFragmentSupport fragment = new SettingFragmentSupport();
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
        View root = inflater.inflate(R.layout.fragment_list, container, false);
        mRecyclerView = root.findViewById(R.id.recycler_view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(),
                ((LinearLayoutManager) mRecyclerView.getLayoutManager()).getOrientation()));

        mTextView = root.findViewById(R.id.item_name);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //一般方式 直接使用getStringArray來處理
        //getResources().getStringArray(R.array.setting_array);

        // 利用TypedArray 便可知道 id 與 string
        // 方便處理 item click 後續處理
        TypedArray array = getResources().obtainTypedArray(R.array.setting_array);
        for (int i = 0; i < array.length(); i++) {
            // getResourceId(int index, int default value )
            System.out.println("id:" + array.getResourceId(i, 0) + ", String :" + array.getString(i));
        }
        mRecyclerView.setAdapter(new Adapter(array));

//        array.recycle();
    }

    @Override
    public void onClick(View v) {
        switch ((int) v.getTag()) {
            case R.string.app_text_size:
                //do something
                break;
            case R.string.app_text_color:
                //do something
                break;
            case R.string.app_background:
                //do something
                break;
        }

        mTextView.setText((int) v.getTag());
    }

    private class Adapter extends RecyclerView.Adapter<ItemVH> {

        private TypedArray mItemsArray;

        public Adapter(TypedArray array) {
            mItemsArray = array;
        }

        @Override
        public ItemVH onCreateViewHolder(ViewGroup parent, int viewType) {
            View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
            root.setOnClickListener(SettingFragmentSupport.this);
            return new ItemVH(root);
        }

        @Override
        public void onBindViewHolder(ItemVH holder, int position) {
            holder.setText(mItemsArray.getString(position));
            holder.setTag(mItemsArray.getResourceId(position, 0));
        }

        @Override
        public int getItemCount() {
            if (mItemsArray != null)
                return mItemsArray.length();

            return 0;
        }
    }

    private class ItemVH extends RecyclerView.ViewHolder {

        private TextView mTextView;
        private View mRoot;

        public ItemVH(View itemView) {
            super(itemView);
            mRoot = itemView;
            mTextView = itemView.findViewById(R.id.list_item_text);
        }

        public void setText(String text) {
            mTextView.setText(text);
        }

        public void setTag(int id) {
            mRoot.setTag(id);
        }
    }
}
