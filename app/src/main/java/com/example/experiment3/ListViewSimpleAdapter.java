package com.example.experiment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewSimpleAdapter extends AppCompatActivity {
    ListView listView;
    int[] imageArr={R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};
    String[] titleArr={"Lion","Tiger","Monkey","Dog","Cat","Elephant"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_simple_adapter);
        //连接listView
        listView=(ListView)findViewById(R.id.ListViewsimple);
        //创建SimpleAdapter适配器
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,getData(),R.layout.layoutitem1,
                new String[]{"img","name","content"},new int[]{R.id.lion,R.id.textTitle});
        //为listview添加SimpleAdapter适配器
        listView.setAdapter(simpleAdapter);
        // 设置ListView的点击事件监听器
        listView.setOnItemClickListener(new MyListener());
    }


    class MyListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            /*adapterView是指当前的listview；
             *view是当前listview中的item的view的布局,就是可用这个view获取里面控件id后操作控件
             * i是当前item在listview中适配器的位置
             * l是当前item在listview里第几行的位置
             */
            //获得选中项中的HashMap对象
            HashMap<String,String> map=(HashMap<String,String>)adapterView.getItemAtPosition(i);
            String Text=map.get("name");
            Toast.makeText(ListViewSimpleAdapter.this,Text, Toast.LENGTH_SHORT).show();
        }
    }
    private List<? extends Map<String,?>> getData() {
        List<Map<String,Object>> list;
        Map<String,Object> map;
        list=new ArrayList<Map<String,Object>>();
        for(int i=0;i<imageArr.length;i++){
            map=new HashMap<String,Object>();
            map.put("img",imageArr[i]);
            map.put("name",titleArr[i]);
            list.add(map);
        }
        return list;
    }
}