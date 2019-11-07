package com.config.pad.content.libding.rerxmvp.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.config.pad.content.libding.rerxmvp.interfaceUtils.interfaceUtilsAll;
import com.config.pad.content.libding.widget.LoadingActivityDialog;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 *
 */
public abstract class BaseFragment extends Fragment implements interfaceUtilsAll.IBaseView{
    protected String TAG = getClass().getSimpleName();
    protected Unbinder mUnbinder;
    protected View mRootView;
    protected Activity mActivity;

    private LoadingActivityDialog loadDialogView1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(getLayoutId(), container, false);
        if (mUnbinder == null) mUnbinder = ButterKnife.bind(this, mRootView);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadData(savedInstanceState);
    }

    protected abstract int getLayoutId();

    public abstract void initView(View view, Bundle savedInstanceState);

    public abstract void loadData(Bundle args);

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder != null) {
            mUnbinder.unbind();
            mUnbinder = null;
        }
    }

    @Override
    public void showProgress() {
        loadDialogView1 = LoadingActivityDialog.createDialog(getActivity());
        loadDialogView1.show();
    }

    @Override
    public void hideProgress() {
        loadDialogView1.dismiss();
    }

    @Override
    public void showToast(String content) {
        Toast.makeText(getActivity(), content, Toast.LENGTH_LONG).show();
    }
}
