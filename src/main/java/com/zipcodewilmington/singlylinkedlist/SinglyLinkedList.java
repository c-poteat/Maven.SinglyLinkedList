package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T extends Comparable> {

    private Node<T> head;
    private Node<T> tail;

    private class Node<T> {
        private T data;
        private Node<T> next;

        public Node() {
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public Node(T data) {
            this.data = data;
        }
    }

    public void add(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void remove(int index) {
        //given the index to remove
        //iterate through the list
        Node<T> currentNode = head, previousNode = null;
        int currentIndex = 0;
        //check if the current node exist
        while (currentNode != null && currentIndex != index) {
            //keeping track of the previous node
            previousNode = currentNode;
            //continuing the iteration
            currentNode = currentNode.next;
            //iterate through the next node
            currentIndex++;
        }
        //remove the index
        if (currentIndex == index) {
            //checking if the previous node is not null
            if (previousNode != null) {
                //then we can add the previous node to the node after
                previousNode.next = currentNode.next;
            }
            //checking that the current node is the head
            if (currentNode == head) {
                //and also if the current node is null
                if (currentNode == null || currentNode.next == null) {
                    //return head as null;
                    head = null;
                } else {
                    //the new head will be the next node
                    head = currentNode.next;
                }
                //current is the tail
            } else if (currentNode == tail) {
                //the tail is the previous node
                tail = previousNode;
            }

        }

    }

    public Boolean contains(T element) {
        //given a T element
        //loop through the list starting from the head
        //each time check if it contains the element
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.data != element) {
                currentNode = currentNode.next;
            } else {
                return true;
            }
        }
        return false;

    }

    public int find(T element) {
        //create indexCounter
        //iterate through the node
        //when you find the element
        //return the index where element is found
        int currentIndex = 0;
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.data != element) {
                currentNode = currentNode.next;
                currentIndex++;
            }
            if (currentNode.data == element) {
                return currentIndex;
            }
        }

        return -1;
    }


    public int size() {
        int currentIndex = 0;
        Node<T> currentNode = head;
        while (currentNode != null) {
            currentNode = currentNode.next;
            currentIndex++;
        }
        return currentIndex;
    }

    public T get(int index) {
        //iterate through the index
        //return the element within that index
        int currentIndex = 0;
        Node<T> currentNode = head;
        while (currentNode != null && currentIndex != index) {
            currentNode = currentNode.next;
            currentIndex++;
        }
        if (currentIndex == index && currentNode != null) {
            return currentNode.data;
        }
        return null;
    }

    public SinglyLinkedList<T> copy() {

        SinglyLinkedList<T> newList = new SinglyLinkedList<T>();
        Node<T> currentNode = head;

        while (currentNode != null) {
            newList.add(currentNode.data);
            currentNode = currentNode.next;
        }

        return newList;
    }

    public void sort() {
        //bubble sort
        //.compareTo() - gives you a return of 1, 0 , -1 - relative comparison
        //iterate through the list
        //find the largest element and move it to the end
        //continue to iterate through the list until the values are in order from smallest to largest
        int initialSize = size();
        int remaining = initialSize;
        for (int i = 0; i < initialSize; i++) {
            int smallestIndex = 0;
            T smallestElement = get(0);
            for (int j = 1; j < remaining; j++) {
                T currentElement = get(j);
                if (currentElement.compareTo(smallestElement) < 0) {
                    smallestElement = currentElement;
                    smallestIndex = j;
                }
            }
            remove(smallestIndex);
            add(smallestElement);
            remaining--;
        }
    }
}