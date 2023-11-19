package com.example.arraylist;

public class ArrayListTest {
    public static void main(String[] args) {
        Array array = new Array(3);
        array.insert(10);
        array.insert(20);
        array.insert(30);
        array.print();
        array.removeAt(2);
        array.insert(90);
        array.insert(79);
        array.print();

    }
}
