package model;

import tests.Node;

public class ListUtilities {

	public Node<String> getAllPrefixes(Node<Integer> input, int m, int n){
		String s = "";
		Node<String> res = new Node<>(null, null);
		Node<String> curr = res;
	
			Node<Integer> current = input;
			for(int i = m; i <= n; i++) {
				s = "[";
				for(int j = 0; j < m; j++) {
					s += current.getElement();
					if (j == m-1) {
						s += "]";
						res.setElement(s);
						if(m == n) {
							res.setNext(null);
						}else {
							res.setNext(new Node<>(null, null));
						}
						
						
					    current = input;
						res = res.getNext();
					}else {
						s += ", ";
						current = current.getNext();
					}
				}
				m++;
				
			}
			
		
		return curr;
	}
		
		

	public Node<Integer> getMergedChain(Node<Integer> leftChain, Node<Integer> rightChain) {
	Node<Integer> res = new Node<>(null, null);
	Node<Integer> curr = res;
	if((leftChain == null) && (rightChain!= null)){
		Node<Integer> c = rightChain;
		while(c != null) {
			res.setElement(c.getElement());
			if(c.getNext() == null) {
				res.setNext(null);
			}else {
				res.setNext(new Node<Integer> (null, null));
				res = res.getNext();				}
			
			c = c.getNext();
		}
		return curr;
	}else if((leftChain!= null) && (rightChain == null)){
		Node<Integer> c = leftChain;
		while(c != null) {
			res.setElement(c.getElement());
			if(c.getNext() == null) {
				res.setNext(null);
			}else {
				res.setNext(new Node<Integer> (null, null));
				res = res.getNext();				}
			
			c = c.getNext();
		}
		return curr;
	}else if((leftChain == null) && (rightChain == null)){
		return null;
	}else {
		Node<Integer> current = leftChain;
		while(current != null) {
			if(leftChain.getElement() <= rightChain.getElement()) {
				res.setElement(leftChain.getElement());
				res.setNext(new Node<Integer>(null, null));
				res = res.getNext();
				res.setElement(rightChain.getElement());
				if(current.getNext() == null) {
					res.setNext(null);
				}else {
					res.setNext(new Node<Integer>(null, null));
					res = res.getNext();
				}
				current = current.getNext();
				leftChain = leftChain.getNext();	
				rightChain = rightChain.getNext();
			}else {
				res.setElement(rightChain.getElement());

				res.setNext(new Node<Integer>(null, null));
				res = res.getNext();
				
				res.setElement(leftChain.getElement());
				if(current.getNext() == null) {
					res.setNext(null);
				}else {
					res.setNext(new Node<Integer>(null, null));
					res = res.getNext();
				}
				
				current = current.getNext();
				rightChain = rightChain.getNext();
				leftChain = leftChain.getNext();
			}
		}
		
	}
	return curr;
}
	private static Integer fib(int n) {
		if(n < 2) {
			return 1;
		}else {
			return fib(n-1) + fib(n-2);
		}
		
	}


	public Node<Integer> getInterleavedArithmeticFibonacciSequences(int arithStart, int diff, int arithSize, int fibSize) {
		if((arithSize == 0) && (fibSize == 0)) {
			return null;
		}
		Node<Integer> res = new Node<>(null, null);
		Node<Integer> curr = res;
		int f = 0;
		int nu = 0;
		int fibIdx = 0;
		int arithIdx = 0;
		int idx = fibSize+arithSize;
		for(int i = 0; i < idx; i++) {
			if(arithIdx < arithSize){
				res.setElement(arithStart);
				arithStart+=3;
				if(nu == idx-1) {
					res.setNext(null);
				}else {
					res.setNext(new Node<Integer>(null, null));
					res = res.getNext();
				}
				arithIdx++; nu++;
			} 
			if(fibIdx < fibSize) {
				res.setElement(fib(f));
				if(nu == idx-1) {
					res.setNext(null);
				}else {
					res.setNext(new Node<Integer>(null, null));
					res = res.getNext();
				}
				fibIdx++; f++; nu++;
			}
		}
		
		
		
		return curr;
	}


	public Node<String> getGroupedStrings(Node<String> input, int i, int j) {
		
		Node<String> res;
		if(input == null) {
			 res = null;
		}else {
			 res = new Node<>(null, null);
		}
		int idx = 0;
		int nd = 0;
		Node<String> curr = res;
		Node<String> current = input;
		while(current!= null) {
			int len = current.getElement().length();
			if(len < i) {
				res.setElement(current.getElement());
				nd++;
				res.setNext(new Node<String>(null, null));
				res = res.getNext();
							
			}
			idx++;
			current = current.getNext();
		}
		current = input;
		while(current!= null) {
			int len = current.getElement().length();
			if((len >= i) &&  (len < j)){
				res.setElement(current.getElement());
				nd++;
				res.setNext(new Node<String>(null, null));
				res = res.getNext();
					
			}
			current = current.getNext();
		}
		current = input;
		while(current!= null) {
			int len = current.getElement().length();
			if(len >= j) {
				res.setElement(current.getElement());
				nd++;
				if(nd == idx) {
					res.setNext(null);
					
				}else {
					res.setNext(new Node<String>(null, null));
					res = res.getNext();
				}
				
				
			}

			current = current.getNext();
			
		}
		
		return curr;
	}
	
	public static Node<Integer> getNodeAt(Node<Integer> node, int i){
		if(i < 0 || i > len(node)) {
			throw new IllegalArgumentException();
		}
		Node<Integer> head = node;
		int idx = 0;
		while((head != null) && (idx < i)){
			
			
			head = head.getNext();
			idx++;
			
		}
		
		
		
		
		return head;
		
	}
	public static int len(Node<Integer> node) {
		Node<Integer> head = node;
		int len = 0;
		while(head != null) {
			
			len++;
			head = head.getNext();
		}		
		return len;
		
	}
	

	public static Node<Integer> circularNode(Node<Integer> node, int n){
		int len = len(node);
		if(node == null || n == 0 || n % len == 0) {
			return node;
		}
		Node<Integer> curr = node;
		Node<Integer> tail = getNodeAt(node, len-1);

		
		Node<Integer> bef = node;
		Node<Integer> befNode = bef;
		
		int move = n%len;
		Node<Integer> before = getNodeAt(node, move-1);
		Node<Integer> after = before.getNext();		

		while(before.getElement() != curr.getElement()) {
			curr = curr.getNext();
			bef = bef.getNext();
		}
		
		bef.setNext(null);
		Node<Integer> afterNode = after;
		tail.setNext(befNode);
		return after;		
	
	}
	

	
	public static void main(String args[]) {
		
		ListUtilities util = new ListUtilities();
		Node<Integer> input = 
				new Node<Integer>(1, 
				new Node<Integer>(2, 
				new Node<Integer>(3, 
				new Node<Integer>(4, 
				new Node<Integer>(5, null)))));
		
		Node<Integer> newNode = circularNode(input, 0);
		System.out.println(newNode.getNext().getNext().getNext().getNext().getElement());
	}



	}
  