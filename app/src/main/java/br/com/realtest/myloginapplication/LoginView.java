package br.com.realtest.myloginapplication;

/**
 * Created by renato.rezende on 29/07/2017.
 */

public interface LoginView {

    void showProgress(boolean showProgress);
    void setUsernameError(int messageResId);
    void setPasswordError(int messageRedId);

}
