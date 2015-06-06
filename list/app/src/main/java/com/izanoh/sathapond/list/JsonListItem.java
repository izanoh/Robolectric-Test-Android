package com.izanoh.sathapond.list;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by staporn on 6/2/2015 AD.
 */
public class JsonListItem {
    public List<JsonItem> itemListA;
    public List<JsonItem> itemListB;

    public void genItemListA()
    {
        itemListA = new LinkedList<>();
        itemListA.add(new JsonItem(1,"detail A 1"));
        itemListA.add(new JsonItem(2,"detail A 2"));
    }
    public void genItemListB()
    {
        itemListB = new LinkedList<>();
        itemListB.add(new JsonItem(1,"detail B 1"));
        itemListB.add(new JsonItem(2,"detail B 2"));
    }
}