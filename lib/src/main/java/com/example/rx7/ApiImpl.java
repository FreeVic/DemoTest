package com.example.rx7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Vic on 2017/5/5 0005.
 */
public class ApiImpl implements Api {
    @Override
    public void queryCats(String query, CatsQueryCallback queryCallback) {
        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(new Cat(12));
        cats.add(new Cat(1));
        cats.add(new Cat(4));
        queryCallback.onCatListReceived(cats);
    }

    @Override
    public void store(Cat cat, StoreCallback storeCallback) {
        storeCallback.onCatStored(cat.toString());
    }

    @Override
    public void findCutest(List<Cat> list,FindCallback findCallBack) {
        findCallBack.onCatFound(Collections.max(list));
    }
}
