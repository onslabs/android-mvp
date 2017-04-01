package olabs.kit.mvp.login;


import olabs.kit.mvp.BasePresenter;
import olabs.kit.mvp.login.listener.LoginAPIListener;
import olabs.kit.mvp.login.model.LoginResponse;

/**
 * Created by ttnd on 27/2/17.
 */
public class LoginPresenter extends BasePresenter {
    private ILoginView mLoginView;
    private LoginAPIListener mLoginAPIListener;

    public LoginPresenter(ILoginView loginView){
        super(loginView);
        mLoginView = loginView;
        mLoginAPIListener = new LoginAPIListener(this);
    }

    public void onLogin(String username,String password){
        mLoginAPIListener.doLogin(username,password);

    }

    public void onRegister(){
        mLoginView.showMessage("To be developed by the user");
    }

    public void onLoginSuccess(LoginResponse loginResponse) {
        mLoginView.showMessage(loginResponse.getMessage());
    }
}
