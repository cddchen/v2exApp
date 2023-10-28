package com.sola.v2ex_android.ui.base;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.sola.v2ex_android.R;
import com.sola.v2ex_android.util.LogUtil;

import java.lang.ref.WeakReference;

/**
 * Created by wei on 2016/10/31.
 */

public abstract class BaseSwipeRefreshFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    SwipeRefreshLayout mSwipeRefreshLayout;
    public Handler mHandle;
    private View mRootView;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void initViews(View view){
        mHandle = new MyHandler(getActivity());
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swiperefreshlayout);
        if (null != mSwipeRefreshLayout) {
            mSwipeRefreshLayout.setOnRefreshListener(this);
            mSwipeRefreshLayout.setColorSchemeResources(
                    android.R.color.holo_green_light, android.R.color.holo_blue_bright,
                    android.R.color.holo_orange_light, android.R.color.holo_red_light);
        }

    }

    public void setSwipeRefreshEnabled(boolean isEnable){
        if (null != mSwipeRefreshLayout)
            mSwipeRefreshLayout.setEnabled(isEnable);
    }

    public void setSwipeRefreshLayoutRefresh(boolean refresh){
        LogUtil.d("BaseSwipeRefreshFragment","setSwipeRefreshLayoutRefresh");
        LogUtil.d("BaseSwipeRefreshFragment","mSwipeRefreshLayout" + mSwipeRefreshLayout);
        if (null != mSwipeRefreshLayout){
            if (refresh){
                LogUtil.d("BaseSwipeRefreshFragment","in refresh");
                    mHandle.post(new Runnable() {
                        @Override
                        public void run() {
                            mSwipeRefreshLayout.setRefreshing(true);
                        }
                    });
            }else {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        }
    }

    private static class MyHandler extends Handler {

        private WeakReference<Activity> mReference;

        public MyHandler(Activity fragment) {
            mReference = new WeakReference<>(fragment);
        }
    }


}
