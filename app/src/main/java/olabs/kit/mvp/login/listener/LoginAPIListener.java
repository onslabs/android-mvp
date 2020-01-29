package olabs.kit.mvp.login.listener;

import olabs.kit.mvp.CallbackManager;
import olabs.kit.mvp.login.API.ILoginAPI;
import olabs.kit.mvp.login.LoginPresenter;
import olabs.kit.mvp.login.model.LoginResponse;
import olabs.kit.mvp.networx.RetroError;
import retrofit2.Call;

/**
 * Created by ttnd on 27/2/17.
 */

public class LoginAPIListener extends CallbackManager {
    LoginPresenter mLoginPresenter;
    protected ILoginAPI mLoginAPI;
    public LoginAPIListener(LoginPresenter loginPresenter) {
        mLoginAPI = (ILoginAPI) getServiceClient(ILoginAPI.class);
        this.mLoginPresenter = loginPresenter;

    }

    public void doLogin(String username,String password) {
        Call<LoginResponse> call = mLoginAPI.doLogin(username, password);
        call.enqueue(this);
    }

    @Override
    protected void onSuccess(Object o) {
        if(o instanceof LoginResponse){
            mLoginPresenter.onLoginSuccess((LoginResponse) o);
        }

    }

    @Override
    protected void onError(RetroError retroError) {
        mLoginPresenter.onError(retroError);
    }
}
