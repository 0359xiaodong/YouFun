package com.deakee.youfun.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.deakee.youfun.R;

import in.srain.cube.util.CLog;

/**
 * Created by Deekea on 2015/3/9.
 */
public class LoginFragment extends DialogFragment {
    private final String TAG = "LoginFragment";

    private View mRootView;
    private Context mContext;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if(mRootView == null) {
            mContext = getActivity();
            mRootView = inflater.inflate(R.layout.fragment_login, container, false);
        } else {
            ((ViewGroup)this.mRootView.getParent()).removeView(this.mRootView);
        }
        return mRootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int style = DialogFragment.STYLE_NO_TITLE, theme = 0;
        setStyle(style,theme);
    }

    @Override
    public void onResume() {
        super.onResume();
        initView();
    }

    private void initView() {
        TextView createAccount = (TextView) mRootView.findViewById(R.id.login_create_account);
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CLog.d(TAG, "Create Account On Click");
//                LoginFragment.this.dismiss();
            }
        });
    }


}
