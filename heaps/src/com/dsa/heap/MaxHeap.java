package com.dsa.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxHeap {

    private List<Integer> heap;

    public List<Integer> getHeap() {
        return Collections.unmodifiableList(heap);
    }

    public MaxHeap() {
        heap = new ArrayList<>();
        heap.add(-1);
    }

    public int viewMax() throws IllegalAccessException {
        if (isEmpty()) {
            throw new IllegalAccessException();
        }
        return heap.get(1);
    }

    public int deleteMax() throws IllegalAccessException {
        if (isEmpty()) {
            throw new IllegalAccessException();
        }
        int max = heap.get(1);
        swap(1, heap.size()-1);
        heap.remove(heap.size()-1);
        if (!heap.isEmpty()) {
            maxify();
        }

        return max;
    }

    private boolean isEmpty() {
        return heap.size() == 1;
    }

    public void insert(int item) {
        heap.add(item);
        try {
            maxify();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void maxify() throws IllegalAccessException {
        for (int i = (heap.size()-1)/2 ; i>=1 ; i--) {
            maxifyRecursively(i);
        }
    }

    public void maxifyRecursively(int index) throws IllegalAccessException {

        if (index < 1 || index > heap.size()) {
            throw new IllegalAccessException();
        }

        int leftIndex = 2*index;
        int rightIndex = 2*index + 1;

        int current = heap.get(index);
        int largest = current;
        int largestIndex = index;

        if (leftIndex < heap.size() && heap.get(leftIndex) > largest) {
            largest = heap.get(leftIndex);
            largestIndex = leftIndex;
        }

        if (rightIndex < heap.size() && heap.get(rightIndex) > largest) {
            largest = heap.get(rightIndex);
            largestIndex = rightIndex;
        }

        if (largest != current) {
            swap(index, largestIndex);
            maxifyRecursively(largestIndex);
        }

    }

    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

}
