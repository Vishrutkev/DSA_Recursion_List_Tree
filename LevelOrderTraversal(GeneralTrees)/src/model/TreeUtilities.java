package model;

import tests.SLLNode;
import tests.TreeNode;

public class TreeUtilities {

	public SLLNode<Integer> getElementsOfRanks(TreeNode<Integer> n2, int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	public TreeNode<String> getStats(TreeNode<Integer> n1) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public static SLLNode<TreeNode<Integer>> getList(TreeNode<Integer> n){
		SLLNode<TreeNode<Integer>> list = new SLLNode<TreeNode<Integer>>(n, null);
		Integer i = 0;
		Integer t = 0;
		Integer l = 0;
		return getListHelper(n, list, i, t, l);

		
		
	}
	
	public static SLLNode<TreeNode<Integer>> getListHelper(TreeNode<Integer> n, SLLNode<TreeNode<Integer>> list, Integer i, Integer t, Integer l){
		
		if(i == 2) {
			return list;
			
		}else if(n.getChildren() == null) {
			return list;
		}
		
			SLLNode<TreeNode<Integer>> children = n.getChildren();
			addLast(list, children);
			t = 0;
			while(children != null) {
				i+=1; 

				getListHelper(children.getElement(), list, i, t, l);
				
				i-=1;
				children = children.getNext();
				
			}
			
		return list;
	}
	
	public static SLLNode<TreeNode<Integer>> addLast(SLLNode<TreeNode<Integer>> list, SLLNode<TreeNode<Integer>> children){

			SLLNode<TreeNode<Integer>> currentofList = list;
			while(currentofList.getNext() != null) {
				currentofList = currentofList.getNext();
			}
			currentofList.setNext(children);
			return list;
}
	
	public static Integer getSibling(TreeNode<Integer> n, Integer res){
		if(n.getParent() == null) {
			return null;
		}
		TreeNode<Integer> p = n.getParent();
		SLLNode<TreeNode<Integer>> c = p.getChildren();
		if(c.getNext() == null) {
			return 1;
		}
		while( c != null) {
			if(n.getParent().getChildren().getNext() != null) {
				
				res ++;
			}
			c = c.getNext();
		}
		return res;
	}
	
	
	
	
	
	public static SLLNode<TreeNode<Integer>> getPostOrder(TreeNode<Integer> n){
		SLLNode<TreeNode<Integer>> list = new SLLNode<>(null, null);
		return postHelper(n, list);
	}

	
	public static SLLNode<TreeNode<Integer>> postHelper(TreeNode<Integer> n, SLLNode<TreeNode<Integer>> list){
		if(n == null) {
			return null;
		}else if(n.getChildren() == null) {
			addLast(list, n);
			return list;
		}else {
			SLLNode<TreeNode<Integer>> children = n.getChildren();
			while(children != null) {
				list = postHelper(children.getElement(), list);
				
				children = children.getNext();
				
			}
			addLast(list, n);
		}
		return list;
	}
	
	public static void addLast(SLLNode<TreeNode<Integer>> list, TreeNode<Integer> c){

		SLLNode<TreeNode<Integer>> cl = new SLLNode<TreeNode<Integer>>(c, null);
		SLLNode<TreeNode<Integer>> currentofList = list;
		while(currentofList.getNext() != null) {
			currentofList = currentofList.getNext();
		}
		if(currentofList.getElement() == null) {
			currentofList.setElement(c);
			return;
		}
		currentofList.setNext(cl);
}
	
	public static SLLNode<TreeNode<Integer>> getPreOrder(TreeNode<Integer> n){
		SLLNode<TreeNode<Integer>> list = new SLLNode<>(n, null);
		return preHelper(n, list);
	}
	
	public static SLLNode<TreeNode<Integer>> preHelper(TreeNode<Integer> n, SLLNode<TreeNode<Integer>> list){
		if(n == null) {
			return null;
		}else if(n.getChildren() == null) {
			return list;
		}else {
			SLLNode<TreeNode<Integer>> children = n.getChildren();
			
			while(children != null) {
				addLast(list, children.getElement());
				list = preHelper(children.getElement(), list);
				children = children.getNext();
			}
		}
		return list;
	}
	
	



	
	
	public static void main(String args[]) {
		TreeNode<Integer> n1 = new TreeNode<>(23);
		TreeNode<Integer> n2 = new TreeNode<>(46);
		TreeNode<Integer> n3 = new TreeNode<>(69);
		TreeNode<Integer> n4 = new TreeNode<>(92);
		TreeNode<Integer> n5 = new TreeNode<>(115);
		TreeNode<Integer> n6 = new TreeNode<>(138);
		TreeNode<Integer> n7 = new TreeNode<>(161);
		TreeNode<Integer> n8 = new TreeNode<>(50);
		
		n2.addChild(n1); n1.setParent(n2);
		n2.addChild(n5); n5.setParent(n2);
		n2.addChild(n7); n7.setParent(n2);
		n1.addChild(n4); n4.setParent(n1);
		n1.addChild(n3); n3.setParent(n1);
		n5.addChild(n6); n6.setParent(n5);
		n5.addChild(n8); n8.setParent(n5);
		
//		TreeNode<Integer> n1 = new TreeNode<>(1);
//		TreeNode<Integer> n2 = new TreeNode<>(2);
//		TreeNode<Integer> n3 = new TreeNode<>(3);
//		TreeNode<Integer> n4 = new TreeNode<>(4);
//		TreeNode<Integer> n5 = new TreeNode<>(5);
//		TreeNode<Integer> n6 = new TreeNode<>(6);
//		TreeNode<Integer> n7 = new TreeNode<>(7);
//		TreeNode<Integer> n8 = new TreeNode<>(8);
//		TreeNode<Integer> n9 = new TreeNode<>(9);
//		TreeNode<Integer> n10 = new TreeNode<>(10);
//		TreeNode<Integer> n11 = new TreeNode<>(11);
//		
//		
//		n1.addChild(n2); n2.setParent(n1);
//		n1.addChild(n3); n3.setParent(n1);
//		n2.addChild(n4); n4.setParent(n2);
//		n2.addChild(n5); n5.setParent(n2);
//		n4.addChild(n9); n9.setParent(n4);
//		n2.addChild(n6); n6.setParent(n2);
//		n3.addChild(n7); n7.setParent(n3);
//		n3.addChild(n8); n8.setParent(n3);
//		n5.addChild(n10); n10.setParent(n5);
//		n6.addChild(n11); n11.setParent(n6);
		
		TreeUtilities u = new TreeUtilities();
//		SLLNode<TreeNode<Integer>> list = u.getList(n1);
//		SLLNode<TreeNode<Integer>> curr = list;
//		while(curr != null) {
//			System.out.println(curr.getElement().getElement());
//			curr = curr.getNext();
//		}
//
//		System.out.println(getSibling(n2, 0));
		
		SLLNode<TreeNode<Integer>> list = getList(n2);
		while(list != null) {
			System.out.println(list.getElement().getElement());
			list = list.getNext();
		}
	}

}
