class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }

        int iterator = 0;
        Node temp = head;
        HashMap<Node, Integer> map = new HashMap<>();
        Node prevNode = new Node(-1);
        Node newHead = prevNode;

        while(temp != null){
            Node newNode = new Node(temp.val);
            map.put(temp, iterator);
            iterator++;
            prevNode.next = newNode;
            prevNode = prevNode.next;
            temp = temp.next;  
        }

        temp = head;
        newHead = newHead.next;
        Node tempNewHead = newHead;

        while(temp != null){
            if(temp.random == null){
                tempNewHead.random = null;
            } else {
                int pos = map.get(temp.random);
                Node tempPos = newHead;
                for(int i = 0; i < pos; i++){
                    tempPos = tempPos.next;
                }
                tempNewHead.random = tempPos;
            }
            temp = temp.next; 
            tempNewHead = tempNewHead.next;  
        }

        return newHead;
    }
}