package com.util.src.impl;

import java.util.ArrayList;
import java.util.Comparator;

public class MaxHeap<E> extends AbstractHeap<E> {
	private Comparator<E> compare = null;

	public MaxHeap(Object compare) {
		// Default setting
		heap = new ArrayList<E>();
		this.compare = (Comparator<E>) compare;
	}

	public MaxHeap(int size, Object compare) {
		heap = new ArrayList<E>(size);
		this.compare = (Comparator<E>) compare;
	}

	@Override
	public void orderHeap(int node) {
		int leftNode = getLeftNodeIndex(node);
		if (leftNode != -1) {
			orderHeap(leftNode);
		}
		int rightNode = getRightNodeIndex(node);
		if (rightNode != -1) {
			orderHeap(rightNode);
		}
		if (leftNode != -1 && rightNode != -1) {
			orderMaxHeapNode(node, leftNode, rightNode);
		} else if (leftNode != -1) {
			if (compare.compare(heap.get(leftNode), heap.get(node)) == 1) {
				swap(leftNode, node);
			}
		} else if (rightNode != -1) {
			if (compare.compare(heap.get(rightNode), heap.get(node)) == 1) {
				swap(rightNode, node);
			}
		}
	}

	private void orderMaxHeapNode(int node, int leftNode, int rightNode) {
		if (leftNode != -1 && rightNode != -1) {
			if (compare.compare(heap.get(leftNode), heap.get(rightNode)) == 1
					&& compare.compare(heap.get(leftNode), heap.get(node)) == 1) {
				swap(node, leftNode);
			} else if (compare.compare(heap.get(rightNode), heap.get(leftNode)) == 1
					&& compare.compare(heap.get(rightNode), heap.get(node)) == 1) {
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
}
