package chapter.android.aweme.ss.com.homework;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class index extends AppCompatActivity {

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        lv = (ListView) findViewById(R.id.lv);

        //定义一个动态数组
        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String,Object>>();

        //在数组中存放数据
        for(int i=0;i<10;i++)
        {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemImage", R.drawable.icon_girl);//加入图片
            map.put("ItemTitle", "抖音");
            map.put("ItemText", "xxxxx");
            map.put("ItemText2", "刚刚");
            listItem.add(map);
        }

        SimpleAdapter mSimpleAdapter = new SimpleAdapter(this,listItem,//需要绑定的数据
                R.layout.activity_index,//每一行的布局
                //动态数组中的数据源的键对应到定义布局的View中
                new String[] {"ItemImage","ItemTitle", "ItemText","ItemText2"},
                new int[] {R.id.img_1,R.id.tv_1,R.id.tv_2,R.id.tv_3});

        lv.setAdapter(mSimpleAdapter);//为ListView绑定适配器

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,long id) {
                //setTitle("你点击了第"+position+"行");//设置标题栏显示点击的行
               Toast.makeText(index.this,"点击了第"+position+"行",Toast.LENGTH_LONG).show();
            }
        });
    }
}
