package com.util.src.main;

import java.util.Comparator;

import com.util.src.impl.Heap;
import com.util.src.impl.MinHeap;

public class Main {

	public static void main(String[] args) {
		Heap<Integer> heap = new MinHeap<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer arg0, Integer arg1) {
				return arg0.compareTo(arg1);
			}
		});
		heap.add(2);
		heap.add(3);
		heap.add(1);
		heap.add(10);
		heap.add(7);
		heap.delete(1);
		while (!heap.isEmpty()) {
			System.out.println(heap.pop());
		}
	}

}
