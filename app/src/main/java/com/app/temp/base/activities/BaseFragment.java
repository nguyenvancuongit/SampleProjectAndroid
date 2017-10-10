package com.app.temp.base.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.app.temp.base.views.ConfirmDialog;
import com.app.temp.base.views.MessageDialog;

/**
 * Created by nguyen_van_cuong on 10/10/2017.
 */

public abstract class BaseFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTagLog();
    }

    /**
     * setup for log
     */
    public void setTagLog() {
        ((BaseActivity) getActivity()).TAG = this.getClass().getName();
    }

    public void printLog(String log) {
        ((BaseActivity) getActivity()).printLog(log);
    }

    /**
     * setup for dialog
     */
    public void showMessage(String pMsg) {
        ((BaseActivity) getActivity()).showMessage(pMsg);
    }

    public void showMessageWithCallback(String pMsg, MessageDialog.MessageDialogCallback pCallback) {
        ((BaseActivity) getActivity()).showMessageWithCallback(pMsg, pCallback);
    }

    public void showConfirmWithCallback(String pMsg, ConfirmDialog.ConfirmDialogCallback pCallback) {
        ((BaseActivity) getActivity()).showConfirmWithCallback(pMsg, pCallback);
    }

    public void showConfirmWithCustomTextAndCallback(String pMsg, String pCancelText, String pConfirmText, ConfirmDialog.ConfirmDialogCallback pCallback) {
        ((BaseActivity) getActivity()).showConfirmWithCustomTextAndCallback(pMsg, pCancelText, pConfirmText, pCallback);
    }

    public void showConfirmWithTitleAndCallback(String pTitle, String pMsg, String pCancelText, String pConfirmText, ConfirmDialog.ConfirmDialogCallback pCallback) {
        ((BaseActivity) getActivity()).showConfirmWithTitleAndCallback(pTitle, pMsg, pCancelText, pConfirmText, pCallback);
    }

    /**
     * setup for Toast
     */
    public void showToast(String pMsg) {
        ((BaseActivity) getActivity()).showToast(pMsg);
    }

    public void hideToast() {
        ((BaseActivity) getActivity()).hideToast();
    }

    /**
     * setup for loading
     */
    public void showLoading() {
        ((BaseActivity) getActivity()).showLoading();
    }

    public void hideLoading() {
        ((BaseActivity) getActivity()).hideLoading();
    }
}