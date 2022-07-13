package com.dsa.heap;

import java.text.MessageFormat;

public class HeapDriver {
    public static void main(String[] args) throws IllegalAccessException {

        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(6);
        maxHeap.insert(7);
        maxHeap.insert(5);
        maxHeap.insert(8);
        maxHeap.insert(1);
        maxHeap.insert(4);
        maxHeap.insert(2);
        System.out.println("Initial state: "+maxHeap.getHeap());
        maxHeap.insert(10);
        System.out.println("After inserting 10: "+maxHeap.getHeap());
        System.out.println("Max value: "+maxHeap.viewMax());
        int deletedMax = maxHeap.deleteMax();
        System.out.println(MessageFormat.format("After deleting max value ({0}): {1}",deletedMax, maxHeap.getHeap()));
        for (int i = 0 ; i < 9 ; i++) {
            System.out.println("Deleted "+maxHeap.deleteMax());
        }
    }
}
