package com.vic.restart;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.widget.ListView;

import com.vic.R;
import com.vic.adapter.SimpleViewAdapter;
import com.vic.applib.activity.BaseActivity;
import com.vic.applib.test.ApiWrapper;
import com.vic.lib.model.Person;
import com.vic.lib.rx7.RxRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Vic on 2017/8/10 0010.
 */

public class FiveActivity extends BaseActivity {

    private ListView listView;
    private SimpleViewAdapter adapter;
    ApiWrapper apiWrapper = new ApiWrapper();
    private int i = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);
        listView = (ListView) findViewById(R.id.list);
        adapter = new SimpleViewAdapter();
        listView.setAdapter(adapter);
        testList0();
        testList0();
    }

    private void testList0(){
        apiWrapper.runThread(new RxRunnable<List<Person>>() {

            @Override
            public List<Person> run() {
                SystemClock.sleep(new Random().nextInt(200));
                Random random = new Random();
                int size = new Random().nextInt(30);
                ArrayList<Person> persons = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    persons.add(new Person(String.valueOf(random.nextInt(900)), 1));
                }
                return persons;

            }

            @Override
            public void onUI(List<Person> persons) {
                adapter.setList(persons);
//                if(new Random().nextBoolean())
                    adapter.notifyDataSetChanged();
                if(i<20)
                    testList0();
                i++;
                System.out.println("update i="+i);
            }

            @Override
            public void onError(Throwable error) {

            }
        });
    }

    private void testList() {
        Random random = new Random(1000);
        while(true){
            ArrayList<Person> persons = new ArrayList<>();
            for(int i=0;i<10;i++){
                persons.add(new Person(String.valueOf(random.nextInt()),1));
            }
            adapter.setList(persons);
            adapter.notifyDataSetChanged();
            SystemClock.sleep(1000);
        }
    }


}
