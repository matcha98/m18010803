package com.matcha.m18010803;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    String str[] = {"AA", "BB", "CCC", "DDDD", "EE"};
    ArrayList<Map<String, Object>> mylist = new ArrayList();
    boolean[] chks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HashMap<String, Object> m1 = new HashMap<>();
        m1.put("city", "台北");
        m1.put("code", "02");
        m1.put("img", R.drawable.tpe);
        mylist.add(m1);
        HashMap<String, Object> m2 = new HashMap<>();
        m2.put("city", "台中");
        m2.put("code", "04");
        m2.put("img", R.drawable.tc);
        mylist.add(m2);
        HashMap<String, Object> m3 = new HashMap<>();
        m3.put("city", "台南");
        m3.put("code", "06");
        m3.put("img", R.drawable.tn);
        mylist.add(m3);
        HashMap<String, Object> m4 = new HashMap<>();
        m4.put("city", "高雄");
        m4.put("code", "07");
        m4.put("img", R.drawable.kh);
        mylist.add(m4);
        HashMap<String, Object> m5 = new HashMap<>();
        m5.put("city", "2台北");
        m5.put("code", "202");
        m5.put("img", R.drawable.tpe);
        mylist.add(m5);
        HashMap<String, Object> m6 = new HashMap<>();
        m6.put("city", "2台中");
        m6.put("code", "204");
        m6.put("img", R.drawable.tc);
        mylist.add(m6);
        HashMap<String, Object> m7 = new HashMap<>();
        m7.put("city", "2台南");
        m7.put("code", "206");
        m7.put("img", R.drawable.tn);
        mylist.add(m7);
        HashMap<String, Object> m8 = new HashMap<>();
        m8.put("city", "2高雄");
        m8.put("code", "207");
        m8.put("img", R.drawable.kh);
        mylist.add(m8);

        lv=findViewById(R.id.listView);
        MyAdapter adapter=new MyAdapter(mylist,MainActivity.this);
        lv.setAdapter(adapter);
        chks=adapter.getChks();

        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder sb=new StringBuilder();
                for(int i=0;i<mylist.size();i++)
                {
                    if(chks[i])
                    {
                        sb.append(mylist.get(i).get("city")+", ");
                    }
                }
                Toast.makeText(MainActivity.this,sb,Toast.LENGTH_LONG).show();
            }
        });

    }

}
