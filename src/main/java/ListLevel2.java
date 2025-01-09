import java.util.*;
public class ListLevel2 {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		
		int [] arr3 = {0,3,6,5,6,7,90};
		int [] arr4 = {5, 8, 3, 3, 6, 9};
		Node <Integer> L1 = bulid(arr4);
		Node <Integer> L2 = bulid(arr3);
		
		//System.out.println(ex1(L1,L2));
		System.out.println(ex6(L1));
		
	}
	public static Node <Integer> bulid(int [] a){
		Node <Integer> first = new Node<Integer> (a[0]);
		Node <Integer> prev = first;
		for (int i=1; i<a.length; i++) {
			Node <Integer> current = new Node<Integer>(a[i]);
			prev.setNext(current);
			prev = current;
			
		}
		return first;
	}
	
	public static Node<Integer> ex1(Node<Integer> L1, Node<Integer> L2){
		Node <Integer> h3 = new Node <Integer> (-1);
		Node <Integer> current = h3;
		Node <Integer> h = L1;
		Node <Integer> p = L2;
	    while (h != null) {
	    	while (p != null) {
	    		if (h.getValue() <= p.getValue()) {
	    			current.setNext(h);
	    			h = h.getNext();
	    		}
	    		else {
	    			current.setNext(p);
	    		p = p.getNext();}
	    		current = current.getNext();
	    	}
	    }
	    return h3.getNext();
	}
	
	public static Node<Integer> ex2(Node<Integer> list){
		Node<Integer> dummy = new Node <Integer>(-1,list);
		Node<Integer> head = new Node<Integer> (-1);
		Node<Integer> p = dummy;
		Node<Integer> h = head;
		while (dummy.hasNext()) {
			p = dummy;
			Node <Integer> m = dummy;
			int min = p.getNext().getValue();
			
			while (p.hasNext()) {
				if (p.getNext().getValue() < min) {
					m = p;
					min = p.getNext().getValue();
				}
				p = p.getNext();
			}
			
			h.setNext(m.getNext());
			h = h.getNext();
			m.setNext(m.getNext().getNext());
		}
		return head.getNext();
	}
	
	public static Node<Integer> ex2b(Node<Integer> list){
		Node<Integer> dummy = new Node<Integer> (-1,list);
		Node<Integer> p = dummy; // current
		Node<Integer> last = dummy;
		
		while(last.hasNext()) {
			p = last;
			Node<Integer> m = dummy;
			int min = p.getNext().getValue();
			
			while (p.hasNext()) {
				if (p.getNext().getValue()<min) {
					m = p;
					min = p.getNext().getValue();
				}
				p = p.getNext();
			}
			
			last.setNext(m.getNext());
			last = last.getNext();
			last.setNext(m);
			m.setNext(m.getNext().getNext());
		}
		return dummy.getNext();
	}
	
	public static boolean ex4(Node<Integer> list) { // if all the values are different
		Node <Integer> p = list;
		while (p != null) {
			Node <Integer> h = p.getNext();
			while (h!=null) {
				if (h.getValue().equals(p.getValue())) {
					return false;
				}
				h = h.getNext();
			}
			p = p.getNext();
		}
		return true;
	}
	
	public static Node<Integer> ex5(Node<Integer> list){ //making a new list where each value appears once
		Node <Integer> p = list;
		Node <Integer> dummy = new Node<Integer> (-1);
		Node<Integer> t = dummy;
		
		while (p!=null){
			int count = 0;
			Node <Integer> h = list;
			while (h!=null) {
				if (h.getValue().equals(p.getValue())) {
					count ++;
				}
				h = h.getNext();
			}
			if (count == 1) {
				t.setNext(new Node<Integer>(p.getValue())); 
	            t = t.getNext();
			}
			p = p.getNext();
		}
		return dummy.getNext();
	}
	
	public static int ex6(Node <Integer> list) {
		int count = 1;
		int maxCount = 0;
		Node <Integer> p = list;
		while(p.getNext()!=null) {
			if (p.getNext().getValue()>=p.getValue()) {
				count ++;
			}
			else {
				if (count > maxCount) {
					maxCount = count;
				}
				count = 1;
			}
			p = p.getNext();
		}
		if (count > maxCount) {
			maxCount = count;
		}
		return maxCount;
	}
}
