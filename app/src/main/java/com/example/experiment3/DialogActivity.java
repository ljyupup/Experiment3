package com.example.experiment3;


import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_main); // 假设你的布局文件名为 activity_main.xml

        // 触发 AlertDialog 的按钮或其他事件（这里以按钮点击为例）
        Button showDialogButton = findViewById(R.id.bt_login); // 替换为实际按钮的 ID
        showDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomAlertDialog();
            }
        });
    }

    private void showCustomAlertDialog() {
        // 创建 AlertDialog.Builder 对象
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final AlertDialog dialog=builder.create();
        // 使用 LayoutInflater 加载布局文件
        final View view=View.inflate(this,R.layout.dialog_layout,null);
        dialog.setView(view);
        dialog.show();

        // 设置布局中的控件（可选）
        TextView title = view.findViewById(R.id.Title);
        EditText username = view.findViewById(R.id.admin);
        EditText password = view.findViewById(R.id.pwd);
        Button cancelButton = view.findViewById(R.id.bt_black_cancel);
        Button signInButton = view.findViewById(R.id.bt_black_sign_in);

        // 为取消按钮设置点击监听器（可选）
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 关闭对话框
                dialog.dismiss();
            }
        });

        // 为登录按钮设置点击监听器（可选）
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 处理登录逻辑
                String user = username.getText().toString();
                String pwd = password.getText().toString();
                // ...

                // 关闭对话框
                dialog.dismiss();
            }
        });

        // 将布局添加到 AlertDialog.Builder
        builder.setView(view);

        // 设置 AlertDialog 的其他属性（可选）
        builder.setTitle("Login"); // 设置标题（可选）


    }
}