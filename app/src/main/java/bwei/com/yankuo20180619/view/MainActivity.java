package bwei.com.yankuo20180619.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import bwei.com.yankuo20180619.R;
import bwei.com.yankuo20180619.presender.MainPresenter;

public class MainActivity extends Activity implements View.OnClickListener,LoginView{

    private EditText ed01,ed02,ed03;
    private Button button;
    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed01 = findViewById(R.id.main_ed1);
        ed02=findViewById(R.id.main_ed2);
        ed03=findViewById(R.id.main_ed3);
        button= findViewById(R.id.main_button);
        button.setOnClickListener(this);
        mainPresenter = new MainPresenter(this);
    }
    @Override
    public void onClick(View v) {
        String main_ed01 = ed01.getText().toString();
        String main_ed02 = ed02.getText().toString();
        String main_ed03 = ed03.getText().toString();
        mainPresenter.login(main_ed01,main_ed02);
    }

    @Override
    public void getuscss(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this,"成功"+msg,Toast.LENGTH_SHORT).show();
                if (msg.equals("注册成功")){
                    Intent intent = new Intent(MainActivity.this, TwoActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void geterror(String error) {

    }
}
