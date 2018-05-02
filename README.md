# pieChartView
扇形图的简单绘制

1:  <br>
<com.guoxw.piechartview.com.guoxw.view.MPieChartView  <br>
        android:layout_width="200dp"     <br>
        android:layout_height="200dp" <br>
        android:id="@+id/pie"<br>
        app:viewHeight="200dp"<br>
        app:viewWidth="200dp"/><br>
        
2:  <br>
     /*** 传入模块百分比**/<br>
    ArrayList<Float>mPere=new ArrayList<>();<br>
    /**** 模块颜色*/<br>
    ArrayList<Integer>mColor=new ArrayList<>();<br>
    /*** 模块的绘制文字描述*/<br>
    ArrayList<String>mNames=new ArrayList<>();<br>
    pie.setTextSize(16);<br>
    pie.setTextColor(Color.RED);<br>
    pie.setPieData(mPere,mColor,mNames);<br>
3: 然后会自动按照比例进行绘制。<br>
