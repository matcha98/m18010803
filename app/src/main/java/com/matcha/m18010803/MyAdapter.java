package com.matcha.m18010803;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Student on 2018/1/9.
 */

public class MyAdapter extends BaseAdapter {

    ArrayList<Map<String, Object>> mylist = new ArrayList();
    boolean[] chks=new boolean[8];
    Context context;

    public MyAdapter(ArrayList mylist,Context context)
    {
        this.mylist=mylist;
        this.context=context;
    }

    @Override
    public int getCount() {
        return mylist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup)
    {
        Log.d("GetView", "position:" + position);
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.layout1, null);

        TextView tv = v.findViewById(R.id.textView);
        tv.setText(mylist.get(position).get("city").toString());
        TextView tv2 = v.findViewById(R.id.textView2);
        tv2.setText(mylist.get(position).get("code").toString());
        ImageView img = v.findViewById(R.id.imageView);
        img.setImageResource((Integer) mylist.get(position).get("img"));
        CheckBox chk=v.findViewById(R.id.checkBox);
        //重新繪製時,設定是否有打勾
        chk.setChecked(chks[position]);
        //記錄CheckBox是否打勾
        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                chks[position]=b;
            }
        });

        return v;
    }

    //回傳CheckBox是否有打勾的boolean陣列
    public boolean[] getChks()
    {
        return chks;
    }
}
