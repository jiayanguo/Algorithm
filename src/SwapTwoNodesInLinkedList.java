/**
 * Created by jiayanguo on 9/7/16.
 *
 * Description:
 * Given a linked list and two values v1 and v2. Swap the two nodes in the linked list with values v1 and v2. It's guaranteed there is no duplicate values in the linked list. If v1 or v2 does not exist in the given linked list, do nothing.


 */
public class SwapTwoNodesInLinkedList {


    public static class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; }
         }

    /**
     * @param head a ListNode
     * @oaram v1 an integer
     * @param v2 an integer
     * @return a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = dummy;
        while (q.next != null && p.next != null) {
            if(p.next.val != v1) {
                p = p.next;
            }
            if(q.next.val != v2) {
                q = q.next;
            }

            if (q.next != null && p.next != null && p.next.val == v1 && q.next.val == v2) break;
        }

        if ( q.next != null && p.next != null && p.next.val == v1 && q.next.val == v2) {
            ListNode temp = p.next;
            p.next = q.next;
            q.next = temp;

            temp = p.next.next;
            p.next.next = q.next.next;
            q.next.next =temp;
            if( p == dummy) return q.next;
            if (q == dummy) return q.next;
        }

        return head;

    }

    public static void main(String[] args){
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(5);
        n1.next= n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        SwapTwoNodesInLinkedList swapTwoNodesInLinkedList = new SwapTwoNodesInLinkedList();
        ListNode p = n1;

        System.out.println("===========Before swap=========");
        while (p != null){
            System.out.print(p.val + " ");
            p = p.next;
        }
        p=n1;

        System.out.println("\n===========After swap=========");
        swapTwoNodesInLinkedList.swapNodes (n1, 2, 3);

        while (p != null){
            System.out.print(p.val + " ");
            p = p.next;
        }
    }

}
