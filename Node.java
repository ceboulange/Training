import java.util.*;
import static java.lang.System.*;

public class Node{
	int data;
	Node next = null;
	
	public Node(int d){
		data = d;
	}
	
	public void appendTail(int d){
		Node end = new Node(d);
		Node n = this;
		if(n != null){
			while(n.next != null){
				n = n.next;
			}
			n.next = end;
		}
	}
	
	public static void removeDupFast(Node n){
		Hashtable<Integer,Boolean> table = new Hashtable<Integer,Boolean>();
		if(n == null) return;
		table.put(n.data, true);
		
		while(n.next != null){
			if(table.containsKey(n.next.data)){
				n.next = n.next.next;
			}
			else{
				table.put(n.next.data, true);
				n = n.next;
			}
		}
	}
	
	public static void removeDupSlow(Node n){
		if(n == null) return;
		
		while(n != null){
			Node r = n;
			while(r.next != null){
				if(r.next.data == n.data){
					r.next = r.next.next;
				}else{
					r = r.next;
				}
			}
			n = n.next;
		}
	}
	
	public String displayNode(){
		String desc = "null";
		Node n = this;
		if(n != null) {
			desc = "Node = " + String.valueOf(n.data);

			while(n.next != null){
				desc += "-" + String.valueOf(n.next.data);
				n = n.next;
			}
		}
		return desc;
	}
	
	public static Node buildNode(int[] array){
		if(array.length == 0) return null;
		Node n = new Node(array[0]);
		Node r = n;
		for(int i=1; i < array.length; i++){
			Node c = new Node(array[i]);
			r.next = c;
			r = r.next;
		}
		
		return n;
	}
	
	public static void main(String[] args){
		
		int size = 100;
		int max = 20;
		int[] array = new int[size];
		
		for (int i = 0; i < size; i++){
			array[i] = (int)(max*Math.random());
        }
		
		Node n1 = buildNode(array);
		Node n2 = buildNode(array);
		
		out.println("Original n1 = " + n1.displayNode());
		removeDupFast(n1);
		out.println("--Duplicates removed");
		out.println("Final n1 = " + n1.displayNode());
		
		out.println("Original n2 = " + n2.displayNode());
		removeDupSlow(n2);
		out.println("--Duplicates removed");
		out.println("Final n1 = " + n2.displayNode());
	}
}