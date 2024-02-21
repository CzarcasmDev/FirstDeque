package hw5;

import java.util.NoSuchElementException;

/**
 * This is a skeleton file for your homework. Complete the functions below. You
 * may also edit the function "main" to test your code.
 * 
 * You should not use any loops or recursions. Your code needs to run in
 * constant time. It is OK if your testing code has loops (like in
 * checkInvariants).
 *
 * You must not add fields or static variables. As always, you must not change
 * the declaration of any method nor the name of the class or of this file.
 */

public class Deque<T> {

	private Node first; 	// A reference to the first item in the Dequeue (or
							// null if empty)
	private Node last; 		// A reference to the last item in the Dequeue (or
							// null if empty)
	private int N; 			// The number of items currently in the Dequeue

	private class Node {

		public T item; 		// The data stored at this node.
		public Node next; 	// The node to the right (or null if there is no
							// node to the right)
		public Node prev; 	// The node to the left (or null if there is no
							// node to the left)
	}

	/**
	 * Construct an empty <code>Deque</code>.
	 */
	public Deque() {
		N = 0;
	}

	/**
	 * Tests if the <code>Dequeue</code> is empty.
	 * 
	 * @return <code>true</code> if this <code>Deque</code> is empty and false
	 *         otherwise.
	 */
	public boolean isEmpty() {
		// TODO - Replace the line below with a correct solution.
		if (N == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the number of items currenlty in this <code>Deque</code>.
	 * 
	 * @return the number of items currenlty in this <code>Deque</code>
	 */
	public int size() {
		// TODO - Repalce the line below with a correct solution.
		return N;
	}

	/**
	 * Inserts an item into the front of this <code>Deque</code>.
	 * 
	 * @param item the item to be inserted
	 */
	public void pushFront(T item) {
		// TODO - Repalce the line below with a correct solution
		if (first == null) {
			Node newNode = new Node();
			newNode.item = item;
			first = newNode;
			last = first;
			N++;
		} 
		else {
			Node newNode = new Node();
			newNode.item = item;
			first.prev = newNode;
			newNode.next = first;
			N++;
			first = newNode;
			if (last == null) {
				last = first;
			}
		}
	}	

	/**
	 * Inserts an item into the back of this <code>Deque</code>.
	 * 
	 * @param item the item to be inserted
	 */
	public void pushBack(T item) {
		// TODO - Repalce the line below with a correct solution
		if (last == null) {
			Node newNode = new Node();
			newNode.item = item;
			N++;
			last = newNode;
			first = last;
		}
		else {
		Node newNode = new Node();
		newNode.item = item;
		N++;
		newNode.prev = last;
		last.next = newNode;
		last = newNode;
		}
	}

	/**
	 * Removes and returns the item at the front of this <code>Deque</code>.
	 * 
	 * @return the item at the front of this <code>Deque</code>.
	 * @throws NoSuchElementException if this <code>Deque</code> is empty.
	 */
	 public T popFront() {
		// TODO - Repalce the line below with a correct solution.
		if (N == 0) {
			throw new NoSuchElementException("Deque is empty.");
		}
		if (first == null) {
			T returnT = last.item;
			first = last;
			if (N > 0) {
				N--;
			}
			return returnT;
		}
		T returnT = first.item;
		first = first.next;
		if (N > 0) {
			N--;
		}
		if (N == 0) {
			last = null;
		}
		return returnT;
	}

	/**
	 * Removes and returns the item at the back of this <code>Deque</code>.
	 * 
	 * @return the item at the back this <code>Deque</code>.
	 * @throws NoSuchElementException if this <code>Deque</code> is empty.
	 */
	public T popBack() {
		// TODO - Repalce the line below with a correct solution.
		if (N == 0) {
			throw new NoSuchElementException("Deque is empty.");
		}
		/* if (last.equals(null)) {
			T returnT = first.item;
			N--;
			return returnT;
		} */ 
		else {
			T returnT = last.item;
			if (last.prev == null) {
				last = null;
				first = null;
				N--;
				return returnT;
			}
			last = last.prev;
			last.next = null;
			N--;
			return returnT;
		}
	}
		
	public static void main(String[] args) {
		
	}
}
