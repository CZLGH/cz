package com.example.czm.viewpager2;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class FirstLayoutActivity extends Activity implements OnPageChangeListener {

    private List<ImageView> imageViewList;
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView();
        initView();
    }

    public void setView() {
        setContentView(R.layout.first_layout);

    }

    public void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        prepareData();
        ViewPagerAdapter adapter = new ViewPagerAdapter();
        mViewPager.setAdapter(adapter);
        mViewPager.setOnPageChangeListener(this);
    }

    private void prepareData() {
        imageViewList = new ArrayList<ImageView>();
        int[] imageResIDs = getImageResIDs();
        ImageView iv;
        for (int i = 0; i < imageResIDs.length; i++) {
            iv = new ImageView(this);
            iv.setBackgroundResource(imageResIDs[i]);
            imageViewList.add(iv);

        }
    }

    /**
     * 在此处本来是5张图片，现在在数组首尾各加了一张图
     * @return
     */
    private int[] getImageResIDs() {
        return new int[]{
                R.drawable.img_1,
                R.drawable.img_2,
                R.drawable.img_3,
                R.drawable.img_4,
                R.drawable.img_5,
                R.drawable.img_6,
                R.drawable.img_7,

        };
    }

    class ViewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return imageViewList.size();
        }

        /**
         * 判断出去的view是否等于进来的view 如果为true直接复用
         */
        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        /**
         * 销毁预加载以外的view对象, 会把需要销毁的对象的索引位置传进来就是position
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(imageViewList.get(position));
        }

        /**
         * 创建一个view
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(imageViewList.get(position));
            return imageViewList.get(position);
        }
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }

    @Override
    public void onPageSelected(int position) {
        if ( imageViewList.size() > 1) { //多于1，才会循环跳转
            if ( position < 1) { //首位之前，跳转到末尾（N）
                position = 5;
                mViewPager.setCurrentItem(position,false);
            } else if ( position > 5) { //末位之后，跳转到首位（1）
                mViewPager.setCurrentItem(1,false); //false:不显示跳转过程的动画
                position = 1;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}