package model;

import java.util.ArrayList;
import java.util.HashSet;

public class RecursiveMethods {

	public String task1(String input) {
		String result = "";
		if(input.length() == 0) {
			return result;
		}else if((input.charAt(0) == '(') && (input.charAt(input.length()-1) == ')')) {
			return input;
		}else {
			 if((input.charAt(0) != '(') && (input.charAt(input.length()-1) == ')')){
				return task1(input.substring(1));
			}else if((input.charAt(0) == '(') && (input.charAt(input.length()-1) != ')')){
				return task1(input.substring(0,input.length()-1));
			}else {
				return task1(input.substring(1, input.length()-1));
			}
		}
	}
	
	
	

	public boolean task2(int[] input, int target) {
		return helper(input, target, 0);
		
	}
	
	private boolean helper(int[] input, int target, int from) {
		if(from >= input.length) {
			return (target == 0);
		}
		return (helper(input, target - input[from], from + 1) || helper(input, target, from + 1));

	}
	
	public static int power(int deno, int nume) {
		if(nume == 0) {
			return 1;
		}else {
			return deno * power(deno, nume - 1);
		}

	}
	
	
	
	public int task3(int h, int c) {
		if((h < 0)) {
			return 0;
		}else if (h == 0) {
			return 1;
		}else {
			int s = 0;
			for (int i = 1; i <= c; i++) {
				s += task3(h - i, c);
			}
			return s;
			
		}
	}
	
	
	
	
	
	public HashSet<ArrayList<Integer>> task4(int h, int c) {
		
		HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		return helper2(h, c, set, new ArrayList<Integer>()); 
	}
	

	private HashSet<ArrayList<Integer>> helper2(int h, int c, HashSet<ArrayList<Integer>> p, ArrayList<Integer> li) {
		
		if((h < 0)) {
			return p;
		}
		
		if (h == 0) {
			p.add(new ArrayList<Integer>(li));
		}
		
			for (Integer i = 1; i <= c; i++) {
				li.add(i);
				helper2(h - i, c, p, li);
				li.remove(li.size()-1);
			}
			
			return p;
		
		}
	
	

	

	
	
	


	
	
}
