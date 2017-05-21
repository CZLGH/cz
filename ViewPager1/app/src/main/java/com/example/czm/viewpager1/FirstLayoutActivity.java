package com.example.czm.viewpager1;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import java.util.ArrayList;
import java.util.List;




public class FirstLayoutActivity extends AppCompatActivity {
       private List<View>viewList;
        private ViewPager pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        viewList=new ArrayList<View>();
        View view1=View.inflate(this,R.layout.view1,null);
        View view2=View.inflate(this,R.layout.view2,null);
        View view3=View.inflate(this,R.layout.view3,null);
        View view4=View.inflate(this,R.layout.view4,null);

        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        viewList.add(view4);
         pager=(ViewPager) findViewById(R.id.pager);
        MypagerAdapter Adapter=new MypagerAdapter(viewList);
        pager.setAdapter(Adapter);
    }
}
