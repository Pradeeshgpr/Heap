package com.util.src.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MinHeap<E> extends AbstractHeap<E> {

	private List<E> heap = null;

	private Comparator<E> compare = null;

	public MinHeap(Object compare) {
		// Default setting
		heap = new ArrayList<E>();
		this.compare = (Comparator<E>) compare;
	}

	public MinHeap(int size, Object compare) {
		heap = new ArrayList<E>(size);
		this.compare = (Comparator<E>) compare;
	}

	@Override
	public void add(E element) {
		heap.add(element);
		orderHeap();
	}

	@Override
	public E pop() {
		E result = heap.remove(0);
		orderHeap();
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

	/**
	 * left node : (2*i) right node : ((2*i) + 1)
	 */
	@Override
	public void orderHeap() {
		orderHeap(0);
	}

	public void orderHeap(int node) {
		int leftNode = getLeftNodeIndex(node);
		int rightNode = getRightNodeIndex(node);
		if (leftNode != -1 && rightNode != -1) {
			orderMaxHeapNode(node, leftNode, rightNode);
		} else if (leftNode != -1) {
			if (compare.compare(heap.get(leftNode), heap.get(node)) == -1) {
				swap(leftNode, node);
			}
		} else if (rightNode != -1) {
			if (compare.compare(heap.get(rightNode), heap.get(node)) == -1) {
				swap(rightNode, node);
			}
		}
	}

	private void orderMaxHeapNode(int node, int leftNode, int rightNode) {
		if (leftNode != -1 && rightNode != -1) {
			if (compare.compare(heap.get(leftNode), heap.get(rightNode)) == -1
					&& compare.compare(heap.get(leftNode), heap.get(node)) == -1) {
				swap(node, leftNode);
			} else if (compare.compare(heap.get(rightNode), heap.get(leftNode)) == -1
					&& compare.compare(heap.get(rightNode), heap.get(node)) == -1) {
				swap(node, rightNode);
			}
		}
	}

	@Override
	protected int getLeftNodeIndex(int currentNode) {
		if (heap.size() > ((2 * currentNode) + 1)) {
			return (2 * currentNode) + 1;
		}
		return -1;
	}

	@Override
	protected int getRightNodeIndex(int currentNode) {
		if (heap.size() > ((2 * currentNode) + 2)) {
			return (2 * currentNode) + 2;
		}
		return -1;
	}

	protected void swap(int i, int j) {
		Collections.swap(heap, i, j);
	}

}
