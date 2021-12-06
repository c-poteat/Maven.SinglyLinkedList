package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {

    @Test
    public void add() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<Integer>();
        //given
        Integer expected = 2;
        //when
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        Integer actual = singlyLinkedList.size();
        //then
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void remove() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<Integer>();
        //given
        int expected = 1;
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        //when
        singlyLinkedList.remove(0);
        //then
        int actual = singlyLinkedList.size();
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void contains() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<Integer>();
        //given
        singlyLinkedList.add(1);
        singlyLinkedList.add(3);
        //when
        Boolean actual = singlyLinkedList.contains(1);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void find() {
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<String>();
        //given
        int expected = 1;
        singlyLinkedList.add("Dave");
        singlyLinkedList.add("Cay");
        //when
        int actual = singlyLinkedList.find("Cay");
        //then
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void size() {
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<String>();
        //given
        int expected = 3;
        singlyLinkedList.add("John");
        singlyLinkedList.add("Dave");
        singlyLinkedList.add("Cay");
        //when
        int actual = singlyLinkedList.size();
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void get() {
        //given
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<Integer>();
        Integer expected = 2;
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        //when
        Integer actual = singlyLinkedList.get(1);
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void copy() {
        //given
        String expected = "Cay";
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<String>();
        singlyLinkedList.add("Cay");
        singlyLinkedList.add("Dave");
        //when
        SinglyLinkedList newList = singlyLinkedList.copy();
        String actual = (String) newList.get(0);
        //then
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void sort() {
        //given
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<Integer>();
        singlyLinkedList.add(1);
        singlyLinkedList.add(3);
        singlyLinkedList.add(2);
        Integer expected1 = 1;
        Integer expected2 = 2;
        Integer expected3 = 3;
        //when
        singlyLinkedList.sort();
        Integer actual1 = singlyLinkedList.get(0);
        Integer actual2 = singlyLinkedList.get(1);
        Integer actual3 = singlyLinkedList.get(2);

        Assert.assertEquals(expected1,actual1);
        Assert.assertEquals(expected2,actual2);
        Assert.assertEquals(expected3,actual3);

    }
}
