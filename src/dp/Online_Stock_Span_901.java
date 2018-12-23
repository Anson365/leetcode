package dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 9/9/18.
 */
public class Online_Stock_Span_901 {
    private List<Element> list  ;

    public Online_Stock_Span_901() {
        list = new ArrayList<>();
    }
    public int next(int price) {
        int result;
        if (list.isEmpty()) {
            result = 1;
            list.add(new Element(price, result, -1));
        } else {
            Element element = doHelp(list.size() - 1, price);
//            if (element == null) {
//                result = 1;
//                element = new Element(price, result, -1);
//            }
            list.add(element);
            result = element.getCount();
        }
        return result;
    }

    private Element doHelp(int index, int price) {
        if (index < 0) {
            return new Element(price, 1, index);
        }
        Element element = list.get(index);
        if (price >= element.getPrice()) {
            Element tempElement = doHelp(element.getNext(), price);

            return new Element(price, tempElement.getCount() + element.getCount(), tempElement.getNext());
        } else {
            return new Element(price, 1, index);
        }
    }
    class Element {
        private Integer price;
        private Integer count;
        private Integer next;

        public Element(Integer price, Integer count, Integer next) {
            this.price = price;
            this.count = count;
            this.next = next;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public Integer getNext() {
            return next;
        }

        public void setNext(Integer next) {
            this.next = next;
        }
    }


//    public static void main(String[] args) {
//        Online_Stock_Span_901 online_stock_span_901 = new Online_Stock_Span_901();
//        int temp;
//        temp = online_stock_span_901.next(100);
//        System.out.println(temp);
//
//        temp = online_stock_span_901.next(80);
//        System.out.println(temp);
//
//        temp = online_stock_span_901.next(60);
//        System.out.println(temp);
//
//        temp = online_stock_span_901.next(70);
//        System.out.println(temp);
//
//        temp = online_stock_span_901.next(60);
//        System.out.println(temp);
//
//        temp = online_stock_span_901.next(75);
//        System.out.println(temp);
//
//        temp = online_stock_span_901.next(85);
//        System.out.println(temp);
//
//
//
//    }
}
