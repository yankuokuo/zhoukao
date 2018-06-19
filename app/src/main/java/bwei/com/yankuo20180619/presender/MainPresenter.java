package bwei.com.yankuo20180619.presender;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import bwei.com.yankuo20180619.model.MianModel;
import bwei.com.yankuo20180619.view.LoginView;
import bwei.com.yankuo20180619.view.MainActivity;

public class MainPresenter {
    LoginView loginView;
    private final MianModel mianModel;

    public MainPresenter(LoginView loginView) {
        this.loginView = loginView;
        mianModel = new MianModel();
    }
    public void login(String account,String password){
        if (account==null){
        }
        mianModel.login(account, password, new MianModel.getcadeModelCallback() {
            @Override
            public void getuscss(String msg) {
                loginView.getuscss(msg);
            }

            @Override
            public void geterror(String error) {

            }
        });
    }

}
