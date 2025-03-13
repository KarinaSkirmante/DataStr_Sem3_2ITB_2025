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
			System.out.println("----------------ENQUEUE------------------");
			heapForIntegers.print();
			System.out.println("----------------DEQUEU------------------");
			System.out.println(heapForIntegers.dequeue());//41
			System.out.println(heapForIntegers.dequeue());//33
			System.out.println("----------------AFTER DEQUEUE------------------");
			heapForIntegers.print();//tikai 32 (vecāks) -> 5 (kreisais bērns) -> 2 (labais bērns)
			
			System.out.println("----------------MAKE EMPTY------------------");
			heapForIntegers.makeEmpty();
			heapForIntegers.enqueue(100);
			heapForIntegers.enqueue(1000);
			heapForIntegers.print();//1000 (vecāks) un 100 (kreisais bērns)
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
