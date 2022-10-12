import java.util.Scanner;

class DLLNode {
	DLLNode parentNode;
	int nodeValue;
	DLLNode childNode;
	
	public DLLNode(int nodeValue) {
		parentNode = null;
		this.nodeValue = nodeValue;
		childNode = null;
	}
}

class DLLCompute {
	private static DLLNode newNode;
	private static DLLNode headNode = null;
	private static DLLNode tailNode = null;
	private static DLLNode tempNode;
	
	public static void add(int nodeValue) {
		newNode = new DLLNode(nodeValue);
		if(headNode != null) {
			tailNode.childNode = newNode;
			newNode.parentNode = tailNode;
			tailNode = newNode;
		}
		else
		{
			headNode = newNode;
			tailNode = newNode;
		}
	}
	
	public static void displayFromHead() {
		tempNode = headNode;
		if(tempNode != null) {
			while(tempNode.childNode != null) {
				System.out.print(tempNode.nodeValue+" ");
				tempNode = tempNode.childNode;
			}
			System.out.println(tempNode.nodeValue);
		}
	}
	
	public static void displayFromTail() {
		tempNode = tailNode;
		if(tempNode != null) {
			while(tempNode.parentNode != null) {
				System.out.print(tempNode.nodeValue+" ");
				tempNode = tempNode.parentNode;
			}
			System.out.println(tempNode.nodeValue);
		}
	}
}

public class DoublyLinkedList {
	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			System.out.print("Enter the number of elements to insert:");
			int numberOfElements = scan.nextInt();
			int count = 1;
			for(;count<=numberOfElements;count++) {
				System.out.print("Enter the "+count+" element value:"); 
				DLLCompute.add(scan.nextInt());
			}
			scan.close();
		}
		System.out.print("Show data's from Head Postition:");
		DLLCompute.displayFromHead();
		System.out.print("Show data's from Tail Postition:");
		DLLCompute.displayFromTail();
	}
}