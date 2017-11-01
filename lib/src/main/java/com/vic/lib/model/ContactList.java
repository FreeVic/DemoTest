package com.vic.lib.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangshengli on 2017/10/26.
 */

public class ContactList {
    List<Contact> list = new ArrayList<>();

    public List<Contact> getList() {
        return list;
    }

    public void setList(List<Contact> list) {
        this.list = list;
    }
}
