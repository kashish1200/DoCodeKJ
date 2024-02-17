Complexity
Time complexity: O(n)
Space complexity: O(1)

Code
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode oddStart = head, evenStart = head.next;
        ListNode oddEnd = oddStart, evenEnd = evenStart;
        ListNode temp = evenStart.next;
        int i = 3;
        while(temp != null){
            //odd positioned
            if(i%2!=0){
                oddEnd.next = temp;
                oddEnd = oddEnd.next;
            }
            //even positioned
            if(i%2==0){
                evenEnd.next = temp;
                evenEnd = evenEnd.next;
            }
            temp = temp.next;
            i++;
        }
        oddEnd.next = evenStart;
        evenEnd.next = null;
        return oddStart;  
    }
}
