package com.util.src.impl;

public interface Heap<E> {
	
	public void add(E element);
	
	public E pop();
	
	public void delete(E element);
	
	public boolean isEmpty();
	
	public void orderHeap();
	
}
