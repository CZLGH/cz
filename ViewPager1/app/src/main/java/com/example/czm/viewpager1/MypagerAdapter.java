package com.example.czm.viewpager1;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by czm on 2017/5/18.
 */
    public class MypagerAdapter extends PagerAdapter{
    private List<View> viewList;
    public MypagerAdapter(List<View>viewList) {

            this.viewList=viewList;
    }

    @Override
    public int getCount() {

       return Integer.MAX_VALUE;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        position %= viewList.size();
        if (position<0){
            position = viewList.size()+position;
        }
        ImageView view = viewList.get(position);
        //如果View已经在之前添加到了一个父组件，则必须先remove，否则会抛出IllegalStateException。
        ViewParent vp =view.getParent();
        if (vp!=null){
            ViewGroup parent = (ViewGroup)vp;
            parent.removeView(view);
        }
        container.addView(view);
        //add listeners here if necessary
        return view;
    }


    @Override
    public void destroyItem(ViewGroup container, int position,Object object) {

    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0==arg1;
    }




}
