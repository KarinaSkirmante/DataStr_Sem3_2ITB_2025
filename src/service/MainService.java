package service;

import datastr.MyHeap;
import model.Patient;

public class MainService {

	public static void main(String[] args) {
		System.out.println("----------------HEAP (INTEGERS)------------------");
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
		
		System.out.println("----------------HEAP (PATIENTS)------------------");
		MyHeap<Patient> heapForPatients = new MyHeap<Patient>(2);
		heapForPatients.enqueue(new Patient("Jānis", "Bērziņš", 5));
		heapForPatients.enqueue(new Patient("Līga", "Jaukā", 6));
		heapForPatients.enqueue(new Patient("Pēteris", "Nejaukais", 2));
		heapForPatients.enqueue(new Patient("Baiba", "Kalniņa", 10));
		
		try {
			System.out.println("----------------ENQUEUE------------------");
			heapForPatients.print();
			System.out.println("----------------DEQUEU------------------");
			System.out.println(heapForPatients.dequeue());//Baiba
			System.out.println(heapForPatients.dequeue());//Līga
			System.out.println("----------------AFTER DEQUEUE------------------");
			heapForPatients.print();//Jānis (vecaks), Pēteris (kreisais bērns)
			System.out.println("----------------MAKE EMPTY------------------");
			heapForPatients.makeEmpty();
			heapForPatients.enqueue(new Patient("Kaspars", "Gudrais", 4));
			heapForPatients.enqueue(new Patient("Ilze", "Zinīte", 7));
			heapForPatients.print();//Ilze (vecaks), Kaspars (kreisais bērns)
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
