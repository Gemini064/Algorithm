package practice.StableMarriage;

public class FreeMan {
	class Node {
		private int manId;
		private Node next;

		public void setId(int manId) {
			this.manId = manId;
		}

		public int getId() {
			return manId;
		}

		public void setNext(Node nx) {
			next = nx;
		}

		public Node getNext() {
			return next;
		}
	}

	private Node head;

	public FreeMan() {
		head = new Node();
		head.next = null;
	}

	public void insertFirst(int value) {
		Node newNode = new Node();
		newNode.setId(value);
		newNode.setNext(head.getNext());
		head.setNext(newNode);
	}

	public void removeFirst() {
		Node firstNode = head.getNext();
		head.setNext(firstNode.getNext());
	}

	public int getFirstId() {
		if (head.getNext() != null)
			return head.getNext().getId();
		else 
			return 0;
	}

	public int getLength() {
		Node N = head;
		int count = 0;
		while(N.getNext() != null) {
			N = N.getNext();
			count++;
		}
		return count;
	}
}