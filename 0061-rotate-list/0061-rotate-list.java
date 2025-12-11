class Solution{
    public ListNode rotateRight(ListNode head, int k) {
    if(head == null || head.next == null || k == 0){
        return head;
    }

    // Find length and make it circular
    int len = 1;
    ListNode temp = head;
    while(temp.next != null){
        len++;
        temp = temp.next;
    } 
    temp.next = head; // Make circular

    // Find the new tail (which is at position len - k - 1)
    k = k % len;
    int stepsToNewTail = len - k - 1;
    
    temp = head;
    for(int i = 0; i < stepsToNewTail; i++){
        temp = temp.next;
    }

    ListNode newHead = temp.next;
    temp.next = null; // Break the circle

    return newHead;
}
}