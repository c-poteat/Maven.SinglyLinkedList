package com.zipcodewilmington.singlylinkedlist;

public class Node {

    private Integer data;
    private Node next;

    public Node() {

    }

    public Node(Integer data, Node next) {
        this.data = data;
        this.next = next;
    }

public Node(Integer data) {
    this.data = data;
}

}