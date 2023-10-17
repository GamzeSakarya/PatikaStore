package com.company;

import java.util.Comparator;

public class SortedMobilePhoneByID implements Comparator<MobilePhone> {

    @Override
    public int compare(MobilePhone o1, MobilePhone o2) {
        return o1.getId() - o2.getId();
    }
}
