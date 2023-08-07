class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {								// reversing a singly-linked list
		if (head == null) return head;
		ListNode curr = head, after = null, before = null;
		while(curr != null){
			after     = curr.next;
			curr.next = before;
			before    = curr;
			curr      = after;
		}
		return before;
    }

	public class ListNode {														// Definition for singly-linked list.
		final int val;
		ListNode next = null;
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode prev) { this.val = val; prev.next = this; }
	}

	// ----------- TESTING ------------
	public ListNode makeList0(){												// ListNode = [] 
		return null;
	}
	public ListNode makeList1(){												// ListNode = [1]
		return new ListNode(1);
	}
	public ListNode makeList6(){												// ListNode = [1 2 3 4 5 6] 
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2,a);
		ListNode c = new ListNode(3,b);
		ListNode d = new ListNode(4,c);
		ListNode e = new ListNode(5,d);
		ListNode f = new ListNode(6,e);
		return a;
	}
	public String print(final ListNode head){									// printing method of our singly-linked list
		String s = null;
		ListNode p = head;
		while(p != null){
			if( s == null) s = "" + p.val; else s += " " + p.val;
			p = p.next;
		}
		return s == null ? "" : s;
	}
	public static void test0(String ta){										// empty ListNode test
		ReverseLinkedList s = new ReverseLinkedList();
		ListNode head = s.makeList0();
		String tb = "";
		String rb = s.print(head);
		assert(tb.equals(rb));

		ListNode r = s.reverseList(head);
		String ra = s.print(r);
		assert(ta.equals(ra));
	}
	public static void test1(String ta){										// empty ListNode test
		ReverseLinkedList s = new ReverseLinkedList();
		ListNode head = s.makeList1();
		String tb = "1";
		String rb = s.print(head);
		assert(tb.equals(rb));

		ListNode r = s.reverseList(head);
		String ra = s.print(r);
		assert(ta.equals(ra));
	}
	public static void test6(String ta){										// 6 element ListNode test
		ReverseLinkedList s = new ReverseLinkedList();
		ListNode head = s.makeList6();
		String tb = "1 2 3 4 5 6";
		String rb = s.print(head);
		assert(tb.equals(rb));

		ListNode r = s.reverseList(head);
		String ra = s.print(r);
		assert(ta.equals(ra));
	}
	public static void main(String[] args){										// main test for singly-linked list
		test0("");
		test1("1");
		test6("6 5 4 3 2 1");

	}
}
