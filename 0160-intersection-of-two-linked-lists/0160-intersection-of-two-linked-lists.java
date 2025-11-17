/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        HashSet <ListNode> set = new HashSet<>();

        ListNode temp = headA;

        while(temp !=null && temp.next !=null){
            set.add(temp);
            temp = temp.next;
        }

        temp = headB;

        while(temp!=null && temp.next!=null){
            if(set.contains(temp)){
                return temp;
            }else{
                temp = temp.next;
            }
        }

        return null;
    }
}