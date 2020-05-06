package com.util.src.impl;

public abstract class AbstractHeap<E> implements Heap<E> {

	protected abstract int getLeftNodeIndex(int currentNode);

	protected abstract int getRightNodeIndex(int currentNode);
}
