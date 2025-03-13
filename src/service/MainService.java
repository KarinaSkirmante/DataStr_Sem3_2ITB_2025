package service;

import datastr.MyHeap;

public class MainService {

	public static void main(String[] args) {
		MyHeap<Integer> heapForIntegers = new MyHeap<Integer>(2);
		
		heapForIntegers.enqueue(2);
		heapForIntegers.enqueue(32);
		heapForIntegers.enqueue(33);
		heapForIntegers.enqueue(5);
		heapForIntegers.enqueue(41);
		
		try {
			heapForIntegers.print();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
