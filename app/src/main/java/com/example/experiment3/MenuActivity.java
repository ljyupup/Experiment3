package com.example.experiment3;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MenuActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_main); // 假设你的布局文件名为 activity_main.xml
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textView = findViewById(R.id.textView); // 确保TextView的ID在布局文件中是textView
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menuItem_fontSizeSmall) {
            textView.setTextSize(10);
            return true;
        } else if (id == R.id.menuItem_fontSizeMedium) {
            textView.setTextSize(16);
            return true;
        } else if (id == R.id.menuItem_fontSizeLarge) {
            textView.setTextSize(20);
            return true;
        } else if (id == R.id.menuItem_normal) {
            Toast.makeText(this, "普通菜单项被点击", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.menuItem_fontColorRed) {
            textView.setTextColor(getResources().getColor(R.color.red)); // 确保在colors.xml中定义了red
            return true;
        } else if (id == R.id.menuItem_fontColorBlack) {
            textView.setTextColor(getResources().getColor(R.color.black)); // 确保在colors.xml中定义了black
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}