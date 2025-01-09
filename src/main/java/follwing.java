import java.util.*;
public class follwing {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		
		int [] arr = {5,8,12,1};
		Node <Integer> first = bulid(arr);
		System.out.println(repeat(first));
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
	
	public static boolean similar(Node <Integer> p) {
		if (!p.hasNext()) {
			return true;
		}
		if (p.getValue()>0 && p.getNext().getValue()<0 ||
			p.getValue()<0 && p.getNext().getValue()>0) {
			return false;
		}
		return similar(p.getNext());
	}
	// הסיבוכיות תהייה n בריבוע
	public static boolean repeat(Node <Integer> list) {
		if (list==null || list.getNext()== null) {
			return true;
		}
		Node <Integer> p = list.getNext();
		while (p!= null) {
			if (p.getValue().equals(list.getValue())) {
	            return false; 
	        }
	        p = p.getNext();
	    }
		return repeat(list.getNext());
	}
}
