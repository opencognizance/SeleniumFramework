package org.framework.utilities;

import java.util.Comparator;

public class ComparatorFunction implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        String string1 = (String) o1;
        String string2 = (String) o2;

        return string1.compareTo(string2);
    }
}
