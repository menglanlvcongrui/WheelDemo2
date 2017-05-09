package com.liu.wheeldemo2.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.liu.wheeldemo2.R;

import java.util.List;

import kankan.wheel.widget.adapters.AbstractWheelTextAdapter;

/**
 * @Description: 描述
 * @AUTHOR 刘楠  Create By 2016/10/10 0010 10:16
 */
public class BirthYearAdapter extends AbstractWheelTextAdapter {

    Context mContext;
    List<String> mDatas;

    /**
     *
     * @param context 上下文
     * @param datas 数据
     * @param currentIndex 当前索引
     * @param maxSize 字体最大值
     * @param minSize 字体最小值
     */
    public BirthYearAdapter(Context context,List<String> datas,int currentIndex,int maxSize,int minSize) {
        super(context,R.layout.item_birth_year,NO_RESOURCE,currentIndex,maxSize,minSize);
        mContext = context;
        mDatas = datas;
        setItemTextResource(R.id.tempValue);
    }

    @Override
    public CharSequence getItemText(int index) {
        return mDatas.get(index);
    }

    @Override
    public int getItemsCount() {
        return mDatas.size();
    }


    @Override
    public View getItem(int index, View convertView, ViewGroup parent) {

        View view  = super.getItem(index,convertView,parent);

        return view;
//        return super.getItem(index, convertView, parent);
    }


    public  String getText(int index){
        return mDatas.get(index);
    }
}
