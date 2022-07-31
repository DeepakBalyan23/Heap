package main;

import java.util.Arrays;
import java.util.LinkedList;

import heap.Heap;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Heap h = new Heap(new LinkedList<>( Arrays.asList(null,50, 30, 40, 10,5,20,30)));
		System.out.println(h);
		h.insert(60);
		System.out.println(h);
		h.insert(45);
		System.out.println(h);
		h.deleteRoot();
		System.out.println(h);
		h.deleteRoot();
		System.out.println(h);
	}

}
