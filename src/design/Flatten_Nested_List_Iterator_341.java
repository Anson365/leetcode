package design;

import BaseConstruction.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 9/6/18.
 */
public class Flatten_Nested_List_Iterator_341 implements Iterator<Integer> {
    private List<Integer> flattenList;
    private Iterator<Integer> iterator;

    public Flatten_Nested_List_Iterator_341(List<NestedInteger> nestedList) {
        flattenList = new ArrayList<>();
        doFlatten(nestedList);
        iterator = flattenList.iterator();
    }

    private void doFlatten(List<NestedInteger> nestedIntegerList) {
        for (NestedInteger temp : nestedIntegerList) {
            if (temp.isInteger()) {
                flattenList.add(temp.getInteger());
            } else {
                doFlatten(temp.getList());
            }
        }
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Integer next() {
        return iterator.next();
    }
}
