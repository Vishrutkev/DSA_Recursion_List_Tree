package model;

import java.util.Stack;

import tests.Expression;
import tests.Operand;
import tests.Operator;
import tests.SLLNode;
import tests.TreeNode;

public class TreeUtilities {

	
	public TreeNode<Expression> getInfixTree(SLLNode<Expression> expression){
		if (expression == null) {
			return null;
		}
		Stack<TreeNode<Expression>> t = new Stack<>();
		Stack<Expression> s = new Stack<>();
		if(expression.getNext() == null) {
			Expression e = expression.getElement();
			TreeNode<Expression> te = new TreeNode<Expression>(e);
			return te;
		}
		while(expression != null) {

			Expression e = expression.getElement();
			if(e instanceof Operand) {
				s.add(e);
			}else if(e instanceof Operator) {
				if(s.size() >= 2) {
					Expression e2 = s.pop();
					Expression e1 = s.pop();
					TreeNode<Expression> te = new TreeNode<Expression>(e);
					TreeNode<Expression> te1 = new TreeNode<Expression>(e1);
					TreeNode<Expression> te2 = new TreeNode<Expression>(e2);
					te.addChild(te1); te1.setParent(te);
					te.addChild(te2); te2.setParent(te);
					t.add(te);
					if(!s.isEmpty()) {
						TreeNode<Expression> node = new TreeNode<Expression>(s.pop());
						t.add(node);
					}
					
				}else {
					if(s.isEmpty() && (t.size() == 2)) {
						TreeNode<Expression> fi = t.pop();
						if(fi.getChildren() == null) {
							TreeNode<Expression> tm = t.pop();
							TreeNode<Expression> te = new TreeNode<Expression>(e);
							te.addChild(fi); fi.setParent(te);
							te.addChild(tm); tm.setParent(te);
							t.add(te);
						}else {
							TreeNode<Expression> tm = t.pop();
							TreeNode<Expression> te = new TreeNode<Expression>(e);
							te.addChild(tm); tm.setParent(te);
							te.addChild(fi); fi.setParent(te);
							t.add(te);
						}

					}
					else if((s.size() == 1)) {
						 TreeNode<Expression> tm = t.pop();
						 TreeNode<Expression> te = new TreeNode<Expression>(e);
						 Expression e1 = s.pop();
						 TreeNode<Expression> te1 = new TreeNode<Expression>(e1);
						 te.addChild(tm); tm.setParent(te);
						 te.addChild(te1); te1.setParent(te);
						 t.add(te);							 
				
					 }
				}
			}
			
			
			
			expression = expression.getNext();
		}
		return t.pop();
	}
	

	public String getInOrderSeq(TreeNode<Expression> node) {
		
        if (node == null) {
            return null;
        }
        String res = "(";
        String n = "";
        Expression e =  node.getElement();
        if(e instanceof Operand) {
        	int v = ((Operand)e).getValue();
        	 n = String.format("%d", v);
        }else {
        	char c = ((Operator)e).getOperator();
        	n += c;
        	
        }
        
        
        res += n;
        SLLNode<TreeNode<Expression>> children = node.getChildren();
        if (children != null) {
        	String sl = getInOrderSeq(children.getElement());
        	String sr = getInOrderSeq(children.getNext().getElement());
        
        	if(res.charAt(0) == '(') {
        		res = res.substring(1);
        	}
        	sl = "(" + sl;
        	sl +=  " " + res + " " + sr + ")";
        	return sl;

        }
        return res.substring(1);
    }


	public String getInfixSequence(SLLNode<Expression> expression) {
		
		TreeNode<Expression> t = getInfixTree(expression);
		String res = getInOrderSeq(t);
		return res;
	}



}
