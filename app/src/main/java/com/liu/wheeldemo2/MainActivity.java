package com.liu.wheeldemo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.liu.wheeldemo2.adapter.BirthYearAdapter;

import java.util.ArrayList;
import java.util.List;

import kankan.wheel.widget.OnWheelChangedListener;
import kankan.wheel.widget.OnWheelScrollListener;
import kankan.wheel.widget.WheelView;

public class MainActivity extends AppCompatActivity {

    private WheelView mWheelView;
    List<String> mDates = new ArrayList<>();
    private BirthYearAdapter mBirthYearAdapter;

    /**
     * 最大字体
     */
    private static int maxsize = 24;
    /**
     *   最小字体
     */
    private static int minsize = 14;

    private int currentIndex;
    private Button mBtnGoThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniView();
        iniData();
        initListener();

    }

    private void iniView() {

        mWheelView = (WheelView) findViewById(R.id.wheelView);

        mBtnGoThree = (Button) findViewById(R.id.btnGoThree);

    }

    private void iniData() {
        for (int i = 0; i <24; i++) {

            mDates.add(i+"小时内");
        }

        mBirthYearAdapter = new BirthYearAdapter(this,mDates,12,maxsize,minsize);

        mWheelView.setVisibleItems(5);

        mWheelView.setViewAdapter(mBirthYearAdapter);


    }

    private void initListener() {

        /**
         * 滚动中改变
         */
        mWheelView.addChangingListener(new OnWheelChangedListener() {
            @Override
            public void onChanged(WheelView wheel, int oldValue, int newValue) {
                //获取当前的索引
                int currentItem = wheel.getCurrentItem();
                /**
                 * 获取内容
                 */
                String text = (String) mBirthYearAdapter.getItemText(currentItem);
                /**
                 * 设置字体
                 *
                 */

                setItemTextSize(text,mBirthYearAdapter);
               // Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
            }
        });


        /**
         * 滚动完成改变
         */
        mWheelView.addScrollingListener(new OnWheelScrollListener() {
            @Override
            public void onScrollingStarted(WheelView wheel) {

            }

            @Override
            public void onScrollingFinished(WheelView wheel) {
                //获取当前的索引
                int currentItem = wheel.getCurrentItem();
                /**
                 * 获取内容
                 */
                String text = (String) mBirthYearAdapter.getItemText(currentItem);
                /**
                 * 设置字体
                 *
                 */


                setItemTextSize(text,mBirthYearAdapter);
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
            }
        });







        mBtnGoThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CitysActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * 设置字体大小
     * @param currentItemText
     * @param birthYearAdapter
     */
    private  void setItemTextSize(String currentItemText,BirthYearAdapter birthYearAdapter){
            //获取所有的View
        ArrayList<View>  arrayLists = birthYearAdapter.getTextViews();

        int size = arrayLists.size();
        //当前条目的内容
        String currentText;
        for(int i = 0; i < size; i++) {
            TextView textview = (TextView) arrayLists.get(i);
            currentText = textview.getText().toString().trim();

            if (currentItemText.equals(currentText)) {
                textview.setTextSize(maxsize);
            } else {
                textview.setTextSize(minsize);
            }
        }

    }


}
