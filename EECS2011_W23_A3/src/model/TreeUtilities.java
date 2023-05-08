package model;

import tests.SLLNode;
import tests.TreeNode;

public class TreeUtilities {
	
	
	public SLLNode<Integer> getElementsOfRanks(TreeNode<Integer> n2, int i, int j) {
		SLLNode<Integer> result = null;
		if(i == 0 && j == 0) {
			return result;
		}
		SLLNode<Integer> list = null;
		list = getList(n2, list);
		SLLNode<Integer> currenti = list;
		for(int k = 0; k < i-1; k++) {
			currenti = currenti.getNext();
		}
		SLLNode<Integer> currentj = list;
		for(int k = 0; k < j-1; k++) {
			currentj = currentj.getNext();
		}
		
		SLLNode<Integer> curr = currenti;
		SLLNode<Integer> res = new SLLNode<Integer>(curr.getElement(), null);
		result = res;
		while(curr.getElement() != currentj.getElement()) {
			SLLNode<Integer> newNode = null;
			if(curr.getNext() != null) {
				 newNode = new SLLNode<Integer>(curr.getNext().getElement(), null);
			}
			res.setNext(newNode);
			res = newNode;
			curr = curr.getNext();
			
		}
		return result;
		
	}
	
	private SLLNode<Integer> getList(TreeNode<Integer> n, SLLNode<Integer> head) {
		if(n == null) {
			return head;
		}else {
			SLLNode<Integer> curr = head;
			SLLNode<Integer> newNode = new SLLNode<Integer>(n.getElement(), null);
			if(curr == null) {
				head = newNode;
			}else {
				if(n.getElement() < head.getElement()) {
					
					newNode.setNext(head);
					head = newNode;
				}else {
					while (curr.getNext() != null && curr.getNext().getElement() < n.getElement()) {
						curr = curr.getNext();
					}
					
					newNode.setNext(curr.getNext());
					curr.setNext(newNode);
				}
			}
			
			for(SLLNode<TreeNode<Integer>> c = n.getChildren(); c != null; c = c.getNext()) {
				head = getList(c.getElement(), head);
			}
		}
		
		return head;
	}
	

	
	public int numOfDescendants(TreeNode<Integer> t) {

		if(t == null) {
			return 0;
		}
		else {
			int res = 0;
			for(SLLNode<TreeNode<Integer>> c = t.getChildren(); c!= null; c = c.getNext()) {
				res += 1 + numOfDescendants(c.getElement());
			}

			return res;
		}
		
	}
	
	public int sumOfDescendants(TreeNode<Integer> t, int res) {

		if(t == null) {
			return 0;
		}
		else {
			res = 0;
			for(SLLNode<TreeNode<Integer>> c = t.getChildren(); c!= null; c = c.getNext()) {
				res += c.getElement().getElement() + sumOfDescendants(c.getElement(), res);
			}

			return res;
		}
		
	}
	
	public TreeNode<String> get(TreeNode<Integer> n, TreeNode<String> res){
	if(n == null) {
		 return res;
	
	}else {
		int sum = 0;
		sum = sumOfDescendants(n, sum) + n.getElement();
		int num = numOfDescendants(n) + 1;
		String s = "Number of descendants: " + num + "; Sum of descendants: " + sum;
		res = new TreeNode<String>(s);
		for(SLLNode<TreeNode<Integer>> c = n.getChildren(); c!= null; c = c.getNext()) {
			 sum = sumOfDescendants(c.getElement(), sum) + c.getElement().getElement();
			 num = numOfDescendants(c.getElement()) + 1;
			 s = "Number of descendants: " + num + "; Sum of descendants: " + sum;
			TreeNode<String> node = new TreeNode<>(s);

			node = get(c.getElement(), res);
			
			res.addChild(node);
			node.setParent(res);
		}
		return res;
	}
	
	
}
	


		public TreeNode<String> getStats(TreeNode<Integer> n2) {
			TreeNode<String> res = null;
			res = get(n2, res);
			res.setParent(null);
			return res;
		}	
			
		



}
