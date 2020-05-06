package com.util.src.impl;

import java.util.Collections;
import java.util.List;

public abstract class AbstractHeap<E> implements Heap<E> {

	protected List<E> heap = null;

	@Override
	public void add(E element) {
		heap.add(element);
		orderHeap();
//		System.out.println(heap);
	}

	@Override
	public E pop() {
		E result = heap.remove(0);
//		System.out.println(heap);
		orderHeap();
//		System.out.println(heap);
		return result;
	}

	@Override
	public void delete(E element) {
		if (heap.indexOf(element) == 0) {
			pop();
		} else {
			heap.remove(element);
		}
	}

	@Override
	public boolean isEmpty() {
		return heap.isEmpty();
	}

	@Override
	public void orderHeap() {
		orderHeap(0);
	}

	protected void swap(int i, int j) {
		Collections.swap(heap, i, j);
	}

	protected abstract void orderHeap(int n);

	protected abstract int getLeftNodeIndex(int currentNode);

	protected abstract int getRightNodeIndex(int currentNode);
}
