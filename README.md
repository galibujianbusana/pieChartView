# pieChartView
扇形图的简单绘制

1:  <com.guoxw.piechartview.com.guoxw.view.MPieChartView
        android:layout_width="200dp"
        android:layout_height="200dp"
        android:id="@+id/pie"
        app:viewHeight="200dp"
        app:viewWidth="200dp"/>
        
2:  
     /*** 传入模块百分比**/
    ArrayList<Float>mPere=new ArrayList<>();
    /**** 模块颜色*/
    ArrayList<Integer>mColor=new ArrayList<>();
    /*** 模块的绘制文字描述*/
    ArrayList<String>mNames=new ArrayList<>();
    pie.setTextSize(16);
    pie.setTextColor(Color.RED);
    pie.setPieData(mPere,mColor,mNames);
3: 然后会自动按照比例进行绘制。
