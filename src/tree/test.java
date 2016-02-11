package tree;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class test {
	
	
	public static ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null){
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode evenHead = p2;
        ListNode p3 = p2.next;
        boolean odd = true;
        while(p3!=null){
                if(odd == true){
                    odd = false;
                }else{
                    odd = true;
                }
                p1.next = p3;
                p1 = p2;
                p2 = p3;
                p3 = p3.next;
        }
        System.out.println(odd);
        if(odd == false){
            p2.next = evenHead;
            p1.next = null;
            
        }else{
            p1.next = evenHead;
            p2.next = null;
        }
        
        return head;
        
    }


	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		a.next = b;
		b.next = c;
		c.next = null;
		ListNode d = oddEvenList(a);
		while(d!=null){
			System.out.println(d.val);
			d= d.next;
		}
		
	}

}
