package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T> {

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

        public void add(T data) {
            //Create a new node
            Node newNode = new Node(data);
            if (head == null) {
                //If list is empty, both head and tail will point to new node
                head = newNode;
                tail = newNode;
            } else {
                //newNode will be added after tail such that tail's next will point to newNode
                tail.next = newNode;
                // newNode will become new tail of the list
                tail = newNode;
            }
        }

        public void remove(int index) {
            //iterate through the singlyList
            Node currentNode = head, previousNode = null;
            int currentIndex = 0;
            //check if the current node exist
            while (currentNode != null && currentIndex != index) {
                previousNode = currentNode;
                // continuing the iteration
                currentNode = currentNode.next;
                currentIndex++;
            }
            // remove the index
            if (currentIndex == index) {
                //checking of the previous node is not null
                if (previousNode != null) {
                    // pointing the previous node to the node after
                    previousNode.next = currentNode.next;
                }
                // checking that the current node is the head
                if (currentNode == head) {
                    // and also if the current node is null
                    if (currentNode == null || currentNode.next == null) {
                        // return head as null;
                        head = null;
                    } else {
                        // the new heas will be the next node
                        head = currentNode.next;
                    }
                    // current is the tail
                } else if (currentNode == tail) {
                    // the tail is the previous one
                    tail = previousNode;
                }
            }
        }

        public Boolean contains(T element) {
            Node currentNode = head;
            while (currentNode != null) {
                if (currentNode != element) {
                    if (currentNode.data != element) {
                        currentNode = currentNode.next;
                    } else {
                        return true;
                    }
                }
            }
            return false;
        }
        
        public int find(T element) {
            int currentIndex = 0;
            Node currentNode = head;
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
            Node currentNode = head;
            while (currentNode != null) {
                currentIndex++;
            }
            return currentIndex;
        }

        public T get(int index) {
            int currentIndex = 0;
            Node currentNode = head;
            while (currentNode != null && currentIndex != index) {
                currentNode = currentNode.next;
                currentIndex++;
            }
            if (currentIndex == index && currentNode != null) {
                return (T) currentNode.data;
            }
            return null;
        }

        public SinglyLinkedList<T> copy() {
            SinglyLinkedList<T> newList = new SinglyLinkedList<T>();
            Node currentNode = head;

            while (currentNode != null) {
                newList.add(currentNode.data);
                currentNode = currentNode.next;
            }
            return newList;
        }

        public void sort() {

        }

    }
}
