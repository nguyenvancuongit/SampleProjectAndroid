package com.app.temp.base.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.app.temp.base.activity.BaseActivity;
import com.app.temp.network.API;
import com.app.temp.views.ConfirmDialog;
import com.app.temp.views.MessageDialog;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import io.reactivex.disposables.Disposable;

/**
 * Created by nguyen_van_cuong on 10/10/2017.
 */

public abstract class BaseFragment extends Fragment {

    protected Disposable disposable;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTagLog();
        setDisposable();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    /**
     * setup for log
     */
    private void setTagLog() {
        ((BaseActivity) Objects.requireNonNull(getActivity())).TAG = this.getClass().getName();
    }

    protected void printLog(String log) {
        ((BaseActivity) Objects.requireNonNull(getActivity())).printLog(log);
    }

    /**
     * setup for dialog
     */
    protected void showMessage(String pMsg) {
        ((BaseActivity) Objects.requireNonNull(getActivity())).showMessage(pMsg);
    }

    public void showMessageWithCallback(String pMsg, MessageDialog.MessageDialogCallback pCallback) {
        ((BaseActivity) Objects.requireNonNull(getActivity())).showMessageWithCallback(pMsg, pCallback);
    }

    public void showConfirmWithCallback(String pMsg, ConfirmDialog.ConfirmDialogCallback pCallback) {
        ((BaseActivity) Objects.requireNonNull(getActivity())).showConfirmWithCallback(pMsg, pCallback);
    }

    public void showConfirmWithCustomTextAndCallback(String pMsg, String pCancelText, String pConfirmText, ConfirmDialog.ConfirmDialogCallback pCallback) {
        ((BaseActivity) Objects.requireNonNull(getActivity())).showConfirmWithCustomTextAndCallback(pMsg, pCancelText, pConfirmText, pCallback);
    }

    public void showConfirmWithTitleAndCallback(String pTitle, String pMsg, String pCancelText, String pConfirmText, ConfirmDialog.ConfirmDialogCallback pCallback) {
        ((BaseActivity) Objects.requireNonNull(getActivity())).showConfirmWithTitleAndCallback(pTitle, pMsg, pCancelText, pConfirmText, pCallback);
    }

    /**
     * setup for Toast
     */
    public void showToast(String pMsg) {
        ((BaseActivity) Objects.requireNonNull(getActivity())).showToast(pMsg);
    }

    public void hideToast() {
        ((BaseActivity) Objects.requireNonNull(getActivity())).hideToast();
    }

    /**
     * setup for loading
     */
    public void showLoading() {
        ((BaseActivity) Objects.requireNonNull(getActivity())).showLoading();
    }

    public void hideLoading() {
        ((BaseActivity) Objects.requireNonNull(getActivity())).hideLoading();
    }

    /**
     * setup for Api
     */
    protected API getApi() {
        return ((BaseActivity) Objects.requireNonNull(getActivity())).getApi();
    }

    private void setDisposable() {
        disposable = ((BaseActivity) Objects.requireNonNull(getActivity())).getDisposable();
    }

    /**
     * hides the soft keyboard
     */
    protected void hideSoftKeyboard() {
        try {
            Objects.requireNonNull(Objects.requireNonNull(getActivity()).getCurrentFocus()).post(() -> {
                try {
                    InputMethodManager inputManager = (InputMethodManager) getActivity()
                            .getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(Objects.requireNonNull(getActivity()
                                    .getCurrentFocus()).getApplicationWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
