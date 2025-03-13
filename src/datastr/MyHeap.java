package datastr;

public class MyHeap <Ttype> {
	private Ttype[] heap;
	private final int DEFAULT_SIZE = 7;
	private int size = DEFAULT_SIZE;
	private int counter = 0;
	
	public MyHeap() {
		heap = (Ttype[]) new Object[size];
	}
	
	//argumenta konstruktors
	public MyHeap(int inputSize) {
		if(inputSize > 0) {
			size = inputSize;
		}
		heap = (Ttype[])new Object[size];		
	}
	
	private boolean isFull() {
		return (size == counter);
	}
	
	private boolean isEmpty()
	{
		return (counter == 0);
	}
	
	public int lenght()
	{
		return counter;
	}
	
	
	private void resize() {
		if(size < 100)
		{
			size = size * 2;
		}
		else
		{
			size = (int)(size * 1.5); //135.7 -> 135
		}
		
		Ttype[] heapNew = (Ttype[])new Object[size];
		
		for(int i = 0 ; i < counter; i++) {
			heapNew[i] = heap[i];	
		}
		
		heap = heapNew;
		
		System.gc();
			
	}
	
	
	
	
	public void enqueue(Ttype element) {
		if(isFull())
		{
			resize();
		}
		
		
		heap[counter] = element;
		counter++;
		//izsaucam reheapUp no tās sūnas, kur ievietojam jauno elementu
		reheapUp(counter-1);
	}
	
	
	private void reheapUp(int currentIndex) {
		//kreisā bērna index =  vecāka index * 2 + 1
		//labā bērna index = vecāka index * 2 + 2
		
		//vecāka index = (kreisā bērna index -1 )/2
		//vecāka index = (labā bērna index -2 )/2
		
		
		
		int parentIndex = (int)(currentIndex -1 )/2; //mākslīgi labajam bērnam nogriežam .5
		
		if(parentIndex >= 0)
		{
			if( ((Comparable)heap[currentIndex]).compareTo(heap[parentIndex]) == 1)
			{
				swap(currentIndex, parentIndex);
				reheapUp(parentIndex);
			}
		}
		
		
		
		
	}
	private void swap(int index1, int index2) {
		Ttype temp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = temp;
	}
	//remove - dequeue
	//TODO
	public Ttype dequeue() throws Exception{
		if(isEmpty())
		{
			throw new Exception("Heap is empty and it is not possible to retrieve max element");
		}
		
		Ttype maxElement = heap[0];
		
		heap[0] = heap[counter-1];
		counter--;
		reheapDown(0);
	
		return maxElement;
	
	}
	//reheapDown
	//TODO
	private void reheapDown(int currentParentIndex)
	{
		int indexLeftChild = currentParentIndex * 2 + 1;
		int indexRightChild = currentParentIndex * 2 + 2;
		
		//  ja eksistē abi bērni:
		if(indexLeftChild < counter && indexRightChild < counter)
		{
			//    ja kreisai bērns ir lielāks par labo -> kreiso bērnu salīdzinam
			
			if(((Comparable)(heap[indexLeftChild])).compareTo(heap[indexRightChild]) == 1)
			{
				//      ar pasu elementu 
				
			if(((Comparable)(heap[indexLeftChild])).compareTo(heap[currentParentIndex]) ==1)
			{
				//un pēc nepieciesamības mainām vietām
				swap(indexLeftChild, currentParentIndex);
				//un izsaucam rekursīvi reheapDown
				reheapDown(indexLeftChild);
			
			}
				
			}
			else //labais bērns ir lielāks par kreiso
			{
				if(((Comparable)(heap[indexRightChild])).compareTo(heap[currentParentIndex]) ==1)
				{
					//un pēc nepieciesamības mainām vietām
					swap(indexRightChild, currentParentIndex);
					//un izsaucam rekursīvi reheapDown
					reheapDown(indexRightChild);
				
				}
			}		
		}

	
	
		//ja eksistē tikai kreisais bērns
		else if(indexLeftChild < counter && indexRightChild >= counter)
		{
		//   salīdzinām so kreiso bērnu ar pasu elementu un pēc nepieciešamības mainām vietā
			if(((Comparable)(heap[indexLeftChild])).compareTo(heap[currentParentIndex]) ==1)
			{
				//un pēc nepieciesamības mainām vietām
				swap(indexLeftChild, currentParentIndex);
			}
		}
	
		
	//ja nav bērnu vispār (varbūt var neapstrādat)
	
	
	}
	//print
	public void print() throws Exception{
		if(isEmpty())
		{
			throw new Exception("heap is empty and it is not possible to print elements");
		}
		
		printHelp(0);
		
		
	}
	
	private void printHelp(int currentParentIndex) {
		System.out.println("P -> " + heap[currentParentIndex]);
		//noskaidrojam bērnu ideksus
		int indexLeftChild = currentParentIndex * 2 + 1;
		int indexRightChild = currentParentIndex * 2 + 2;
		//ja eksistē kreisais bērns
		if(indexLeftChild < counter)
		{
			System.out.println("Left ch -> " + heap[indexLeftChild] + "(" + heap[currentParentIndex]+ ")");
			printHelp(indexLeftChild);
		}
		//ja eksistē labais bērns
		if(indexRightChild < counter)
		{
			System.out.println("Right ch -> " + heap[indexRightChild] + "(" + heap[currentParentIndex]+ ")");
			printHelp(indexRightChild);
		}
	}
	
	
	
	
	//makeempty
	public void makeEmpty()
	{
		counter=0;
		size = DEFAULT_SIZE;
		heap = (Ttype[])new Object[size];
		System.gc();
	}
	
	

}
