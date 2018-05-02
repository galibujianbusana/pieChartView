package com.guoxw.piechartview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.guoxw.piechartview.com.guoxw.view.MPieChartView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Float>mPere=new ArrayList<>();
    ArrayList<Integer>mColor=new ArrayList<>();
    ArrayList<String>mNames=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MPieChartView pie=findViewById(R.id.pie);
        for (int i=0;i<5;i++){
            mPere.add(0.2f);
            mNames.add("占比20%");

        }
        mColor.add(Color.RED);
        mColor.add(Color.BLUE);
        mColor.add(Color.YELLOW);
        mColor.add(Color.GREEN);
        mColor.add(Color.GRAY);
        pie.setTextSize(16);
        pie.setTextColor(Color.RED);
        pie.setPieData(mPere,mColor,mNames);

    }

}
