package com.zzht.fitapp2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.zzht.fitapp2.db.UserDB;
import com.zzht.fitapp2.domain.Person;

import java.util.List;

public class Register extends AppCompatActivity implements View.OnClickListener {
    ImageView iv_reg;
    EditText et_reg_user;
    EditText et_reg_password;
    EditText et_reg_phone;
    Button reg_register;
    List<Person> personList;
    int index = 0;
    UserDB userDB = new UserDB(Register.this, "USER.db", null, 2);
    int[] images = {R.drawable.head1, R.drawable.head2,R.drawable.head3,
            R.drawable.head4,R.drawable.head5, R.drawable.head6,
            R.drawable.head7,R.drawable.head8,R.drawable.head9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        iv_reg = findViewById(R.id.iv_reg);
        et_reg_user = findViewById(R.id.et_reg_user);
        et_reg_password = findViewById(R.id.et_reg_password);
        et_reg_phone = findViewById(R.id.et_reg_phone);
        reg_register = findViewById(R.id.btn_finish);
        reg_register.setOnClickListener(this);
        iv_reg.setOnClickListener(this);

        /**
         * 顶部栏
         */
        //顶部栏名称
        Register.this.setTitle("用户注册");
        //顶部返回键
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        int color = this.getResources().getColor(R.color.colorPrimary);
        ColorDrawable drawable = new ColorDrawable(color);
        //actionBar.setBackgroundDrawable(drawable);

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
            case R.id.iv_reg:
                Intent intent = new Intent(Register.this, Image.class);
                startActivityForResult(intent, 111);
                break;
            case R.id.btn_finish:
                String account = et_reg_user.getText().toString().trim();
                String password = et_reg_password.getText().toString().trim();
                String phone = et_reg_phone.getText().toString().trim();

                if (account.equals("") || phone.equals("") || password.equals("")) {
                    Toast.makeText(this, "请将信息填写完整", Toast.LENGTH_SHORT).show();
                } else {
                    personList = userDB.select(account);
                    if (personList.size() == 0) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("image",index);
                        contentValues.put("name", account);
                        contentValues.put("password", password);
                        contentValues.put("phone", phone);
                        userDB.insert(contentValues);
                        Toast.makeText(this, "注册成功！", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(this, "账号已存在！", Toast.LENGTH_SHORT).show();
                    }
                }

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        index = data.getIntExtra("number",-1);
        iv_reg.setImageResource(images[index]);
    }
}