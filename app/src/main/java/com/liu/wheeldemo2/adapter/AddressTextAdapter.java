package com.liu.wheeldemo2.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.liu.wheeldemo2.R;

import java.util.List;

import kankan.wheel.widget.adapters.AbstractWheelTextAdapter;

/**
 * @Description: 描述
 * @AUTHOR 刘楠  Create By 2016/10/9 0009 16:23
 */
public class AddressTextAdapter extends AbstractWheelTextAdapter {
    List<String> mDatas;
    Context mContext;

    public AddressTextAdapter(Context context, List<String> datas,int currentIndex,int maxSize ,int minSize) {
        super(context, R.layout.item_address,NO_RESOURCE,currentIndex,maxSize,minSize);
        mContext = context;
        mDatas=datas;
        setItemTextResource(R.id.tempValue);
    }

    @Override
    protected CharSequence getItemText(int index) {
        return mDatas.get(index);
    }

    @Override
    public int getItemsCount() {
        return mDatas.size();
    }

    @Override
    public View getItem(int index, View convertView, ViewGroup parent) {


        View view = super.getItem(index,convertView,parent);

        return view;
    }

    public String getName(int index){
        return mDatas.get(index);
    }




}
