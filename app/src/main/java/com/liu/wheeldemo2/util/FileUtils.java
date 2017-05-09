package com.liu.wheeldemo2.util;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Description: 描述
 * @AUTHOR 刘楠  Create By 2016/10/10 0010 13:23
 */
public class FileUtils {

    public static String readAssetsFile(Context context,String filename){
        StringBuilder sb = new StringBuilder();
        BufferedReader br =null;
        InputStream in =null;
        try {
             in = context.getAssets().open(filename);

            br = new BufferedReader(new InputStreamReader(in,"UTF-8"));
            String         temp;
            while(br!=null&&null!=(temp=br.readLine())){
                sb.append(temp);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }finally {

            if(in!=null){
                try {
                    in.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }

            if(br!=null){
                try {
                    br.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }

        }


        return  sb.toString();

    }
}
