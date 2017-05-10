package sam;

public class Main {
 
	public static void main(String[] args) {
 
		List l = new List();
		l.head = new Node(1);
		l.tail = new Node(10);
		
		l.head.next = l.tail;
		
		
		Node x = new Node(2);
		l.insert(x);
		Node a = new Node(5);
		l.insert(a);
 
		
		l.print();
		l.printTail();
		l.printHead();
	}
 
}