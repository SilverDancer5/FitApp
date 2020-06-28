package com.zzht.fitapp2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.zzht.fitapp2.db.UserDB;
import com.zzht.fitapp2.domain.Person;

import java.util.List;

public class LogIn extends AppCompatActivity implements View.OnClickListener {


    EditText et_login_user;
    EditText et_login_password;
    ImageView log_in;
    Button agreement;
    Button log_register;
    List<Person> personList;
    UserDB userDB = new UserDB(LogIn.this,"USER.db",null,2);
static String name = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        et_login_user = findViewById(R.id.et_login_user);
        et_login_password = findViewById(R.id.et_login_password);
        log_in = findViewById(R.id.log_in);
        agreement = findViewById(R.id.btn_agreement);
        log_register = findViewById(R.id.btn_register);
        log_register.setOnClickListener(this);
        log_in.setOnClickListener(this);

        agreement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LogIn.this, "你已经同意了", Toast.LENGTH_SHORT).show();
            }
        });

        /**
         * 顶部栏
         */
        //顶部栏名称
        LogIn.this.setTitle("用户登录");
        //顶部返回键
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        int color = this.getResources().getColor(R.color.colorPrimary);
        ColorDrawable drawable = new ColorDrawable(color);
//        actionBar.setBackgroundDrawable(drawable);

        this.getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.log_in:
                String account = et_login_user.getText().toString().trim();
                String password = et_login_password.getText().toString().trim();

                personList = userDB.select(account);

                if(account.equals("") && password.equals("")) {
                    Log.i("null", "null");
                    Toast.makeText(this, "不能为空！", Toast.LENGTH_SHORT).show();
                }
                if (personList.size() == 0) {
                    Toast.makeText(this, "账号不存在！", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.equals(personList.get(0).getPassword()) && password != null && account != null) {
                        Toast.makeText(this, "登录成功！", Toast.LENGTH_SHORT).show();
                        name = account;
                        Intent intent = new Intent(LogIn.this, MainActivity.class);
                        String userName = et_login_user.getText().toString();


                        intent.putExtra("userName", userName);
                        Config.userId=personList.get(0).getId();
                        Log.i("thb1", "onClick: "+personList.get(0).getId());
                        startActivity(intent);

                    } else {
                        Toast.makeText(this, "密码错误！", Toast.LENGTH_SHORT).show();
                    }
                }
                break;

            case R.id.btn_register:
                Intent intent = new Intent(v.getContext(), Register.class);
                startActivity(intent);
                break;
        }
    }
}