package sam;

public class List {
	
	Node head;
	Node tail;
	
	public void insert(Node x) {
		
		tail.next = x;
		Node temp = tail;
		tail = x;
		
	}
	
	public void print() {
		Node p = head;
		while(p != null) {
			System.out.println(p.val);
			p = p.next;
		}
	}
	public void printHead() {
		System.out.println("Head: " + head.val);
	}
	public void printTail() {
		System.out.println("Tail: " + tail.val);
	}
}
