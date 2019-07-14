package com.example.chapter3.homework;


import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.List;

public class PlaceholderFragment extends Fragment {

    private ListView lv;
    LottieAnimationView animationView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        View view= inflater.inflate(R.layout.fragment_placeholder, container, false);

        animationView = (LottieAnimationView)view.findViewById(R.id.animation_view);

        lv = (ListView)view.findViewById(R.id.lv);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),
        android.R.layout.simple_list_item_1,getData());
        lv.setAdapter(arrayAdapter);
        return view;
    }
    private List<String> getData() {
        List<String> data = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            data.add("好友"+i+"号");
        }
        return data;
    }

    private View target;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                ObjectAnimator alp=ObjectAnimator.ofFloat(animationView,"alpha",1f,0);
                alp.setInterpolator(new LinearInterpolator());
                alp.start();
                lv.setVisibility(View.VISIBLE);
                ObjectAnimator alp2=ObjectAnimator.ofFloat(lv,"alpha",0,1f);
                alp2.setInterpolator(new LinearInterpolator());
                alp2.start();
            }
        }, 5000);
    }
}
