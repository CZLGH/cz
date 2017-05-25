package com.example.czm.listviewtest3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private SimpleAdapter sim_adapter;
    private List<Map<String,Object>>datalist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        listView=(ListView) findViewById(R.id.list_view);
        sim_adapter=new SimpleAdapter(this,getdata(),R.layout.item,new String[]{"pic","text"},new int[]{R.,R.id.text});
    }
    private List<Map<String,Object>> getdata()
    {
        for(int i=0;i<20;i++){
            Map<String,Object>map=new HashMap<String,Object>();
            map.put("pic",R.mipmap.ic_launcher);
            map.put("text","水果"+i);
            datalist.add(map);
        }
        return datalist;
    }
}
