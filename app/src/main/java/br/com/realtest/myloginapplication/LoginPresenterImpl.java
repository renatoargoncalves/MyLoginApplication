package br.com.realtest.myloginapplication;

import android.text.TextUtils;

/**
 * Created by renato.rezende on 29/07/2017.
 */

public class LoginPresenterImpl implements LoginPresenter {

    private LoginView loginView;
    private LoginModel loginModel;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginModel = new LoginModelImpl();
    }

    @Override
    public void validateCredentials(String username, String password) {

        if (TextUtils.isEmpty(username)) {
            loginView.setUsernameError(R.string.error_field_required);
            return;
        }

        if (!isEmailValid(username)) {
            loginView.setUsernameError(R.string.error_invalid_email);
            return;
        }

        if (TextUtils.isEmpty(password)) {
            loginView.setPasswordError(R.string.error_field_required);
            return;
        }

        if (!isPasswordValid(password)) {
            loginView.setPasswordError(R.string.error_invalid_password);
            return;
        }

        loginView.showProgress(true);
        loginModel.login(username, password);
    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }

}
