package com.example.experiment3;

import android.graphics.Color;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContextActivity extends AppCompatActivity {

    private ListView listView;
    private List<Map<String, Object>> list;
    private SparseBooleanArray selectedItems = new SparseBooleanArray();
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.context_list);
        Toolbar toolbar = findViewById(R.id.context_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Selected:");

        listView = findViewById(R.id.context_listView);
        initDataList();
        String[] from = {"content"};
        int[] to = {R.id.context_itemText};
        final SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.context_item, from, to);
        listView.setAdapter(adapter);

        // 设置单击监听
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                toggleSelection(position);
//            }
//        });
        // 添加长按监听器
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                toggleSelection(position);
                // 返回 true 表示已经处理了长按事件，系统不会触发点击事件
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.context_menu, menu);
        this.menu = menu;
        updateMenuTitle();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_done) {
            // 处理“Done”菜单项，清空选中状态
            clearSelection();
            updateMenuTitle();
            return true;
        } else if (id == R.id.action_cancel) {
            // 处理“Cancel”菜单项，清空选中状态
            clearSelection();
            updateMenuTitle();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void toggleSelection(int position) {
        if (selectedItems.get(position, false)) {
            selectedItems.delete(position);
        } else {
            selectedItems.put(position, true);
        }
        updateListView();
        updateMenuTitle();
    }

    private void clearSelection() {
        selectedItems.clear();
        updateListView();
    }

    private void updateListView() {
        for (int i = 0; i < listView.getCount(); i++) {
            View view = listView.getChildAt(i - listView.getFirstVisiblePosition());
            if (view != null) {
                view.setBackgroundColor(selectedItems.get(i, false) ? Color.BLUE : Color.TRANSPARENT);
            }
        }
    }

    private void updateMenuTitle() {
        if (menu != null) {
            if (selectedItems != null) {
                getSupportActionBar().setTitle("Selected:"+ selectedItems.size());
            }
        }

        // 更新Toolbar上的TextView
    }

    private void initDataList() {
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("content", "SimpleAdapter" + i);
            list.add(map);
        }
    }
}