package com.example.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    CheckBox chkluuthongtin;
    EditText edtUsername, edtPassword;
    Button btnLogin;
    SharedPreferences luutru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        anhxa();

        luutru = getSharedPreferences("myfile", Context.MODE_PRIVATE);
        // lấy thông tin ra đưa lên from
        Boolean luuthongtin = luutru.getBoolean("save", false);
        if (luuthongtin) {
            edtUsername.setText(luutru.getString("user",""));
            edtPassword.setText(luutru.getString("pass",""));
            chkluuthongtin.setChecked(true);
        }


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                edtUsername.getText().toString();
//                edtPassword.getText().toString();
//
                String user = edtUsername.getText().toString();
                String pass = edtPassword.getText().toString();

                if(user.equals("admin") && pass.equals("123")) {
                    Toast.makeText(getApplicationContext(),"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor = luutru.edit();
                    if (chkluuthongtin.isChecked()){
//                        editor.putString("user", user);
//                        editor.putString("pass", pass);
                        editor.putBoolean("save", chkluuthongtin.isChecked());
                        editor.commit();
                    }
                    Intent intent_1 = new Intent(Login.this, MainActivity.class);
                    startActivity(intent_1);
                }else {
                    Toast.makeText(getApplicationContext(),"Tài khoản hoặc mật khẩu không đúng !",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    public void anhxa() {
        edtUsername = (EditText) findViewById(R.id.edituser);
        edtPassword = (EditText) findViewById(R.id.editpass);
        chkluuthongtin = (CheckBox) findViewById(R.id.check);
        btnLogin = (Button) findViewById(R.id.bntlogin);
    }
}
