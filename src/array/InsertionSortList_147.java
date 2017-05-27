package array;

import BaseConstruction.ListNode;

/**
 * Created by ludao on 2017/5/27.
 */
public class InsertionSortList_147 {

    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode list = new ListNode(head.val);
        while (head.next!=null){
            ListNode temp = list;
            ListNode post = null;
            ListNode index = head.next;
            int indexVal = index.val;
            while(true){
                int compare = temp.val;
                if(compare<indexVal){
                    if(temp.next==null){
                        temp.next = new ListNode(indexVal);
                        head = head.next;
                        break;
                    }else {
                        post = temp;
                        temp = temp.next;
                    }
                }else {
                    if(post!=null) {
                        post.next = new ListNode(indexVal);
                        post.next.next = temp;
                    }else {
                        list = new ListNode(indexVal);
                        list.next = temp;
                    }
                    head = head.next;
                    break;
                }
            }
        }
        return list;
    }


    public static void main(String[] args){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        InsertionSortList_147 insertionSortList_147 = new InsertionSortList_147();
        ListNode result = insertionSortList_147.insertionSortList(listNode1);
        System.out.print(true);
    }
}
