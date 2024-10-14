package mainHomework.lv4.dataStructure;

import mainHomework.lv4.enums.DataStructureType;
import mainHomework.lv4.enums.SortedType;
import mainHomework.lv4.enums.SortingAlgorithmType;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class LinkedListStructure extends DataStructure {
    private Node head;
    private int size = 0;

    private static class Node {
        Double data;
        Node next;

        Node(Double data) {
            this.data = data;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if list contains a specific value
    @Override
    public boolean contains(Double target) {
        Node current = this.head;
        while (current != null) {
            if (current.data.equals(target)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Add element to the end of the list
    @Override
    public void add(Double data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    @Override
    public void removeLastElement() {
        if (this.head == null) {
            throw new NoSuchElementException("List is empty.");
        }

        if (this.head.next == null) {
            this.head = null;
        } else {
            Node current = this.head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
        size--;
    }

    @Override
    public void clear() {
        this.head = null;
    }

    @Override
    public void sort(SortedType sortedType, SortingAlgorithmType sortingAlgorithmType) {
        if (sortedType == SortedType.SKIP || this.head == null || this.head.next == null) {
            return;
        }
        Node current = this.head;

        // Perform selection sort on the linked list
        while (current != null) {
            Node minOrMax = getNode(sortedType, current);

            // Swap the current node with the minOrMax node
            if (minOrMax != current) {
                Double temp = current.data;
                current.data = minOrMax.data;
                minOrMax.data = temp;
            }

            current = current.next; // Move to the next node and repeat
        }
    }

    private static Node getNode(SortedType sortedType, Node current) {
        Node minOrMax = current;
        Node iterator = current.next;

        // Traverse remaining list to find the minimum (for ASCENDING) or maximum (for DESCENDING)
        while (iterator != null) {
            if (sortedType == SortedType.ASCENDING) {
                if (iterator.data < minOrMax.data) {
                    minOrMax = iterator;
                }
            } else if (sortedType == SortedType.DESCENDING) {
                if (iterator.data > minOrMax.data) {
                    minOrMax = iterator;
                }
            }
            iterator = iterator.next;
        }
        return minOrMax;
    }

    @Override
    public void print() {
        Node current = this.head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println();
    }

    @Override
    public List<Double> getResultsGreaterThan(double threshold) {
        return Arrays.stream(toArray()).filter(result -> result > threshold)
                .toList();
    }

    // Get element at specific index
    public Double get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }

        Node current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    // Get size of the list

    // Convert list to array
    public Double[] toArray() {
        Double[] array = new Double[size];
        Node current = this.head;
        for (int i = 0; i < size; i++) {
            array[i] = current.data;
            current = current.next;
        }
        return array;
    }
}