package olabs.kit.mvp.login.model;

import com.google.gson.annotations.SerializedName;

import olabs.kit.mvp.BaseRequest;


/**
 * Created by Jitendra Kumar on 2/11/16.
 */

public class LoginRequest extends BaseRequest {
    @SerializedName("username")
    String username ;

    @SerializedName("password")
    String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
