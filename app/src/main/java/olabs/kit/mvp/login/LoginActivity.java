package olabs.kit.mvp.login;


import android.os.Bundle;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;

import olabs.kit.mvp.BaseActivity;
import olabs.kit.mvp.R;
import olabs.kit.mvp.databinding.ActivityLoginBinding;


public class LoginActivity extends BaseActivity<LoginPresenter,ActivityLoginBinding> implements ILoginView {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        mPresenter = new LoginPresenter(this);
        mViewDataBinding.setPresenter(mPresenter);
    }


    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
