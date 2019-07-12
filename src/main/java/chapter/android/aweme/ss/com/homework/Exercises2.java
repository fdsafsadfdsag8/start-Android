package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class Exercises2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View inflate=LayoutInflater.from(this).inflate(R.layout.im_list_item,null);
        setContentView(inflate);
        System.out.println(getViewCount(inflate));
    }

    public static int getViewCount(View view) {
        //todo 补全你的代码
        int count=0;
        if(view==null) return 0;
        if(view instanceof ViewGroup) {//如果这个view为ViewGroup类型
            count++;//算上当前父节点
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View view1 = ((ViewGroup) view).getChildAt(i);
                if (view1 instanceof ViewGroup) {
                    count += getViewCount(view1);
                } else {
                    count++;
                }
            }
        }
        return count;
    }
}
