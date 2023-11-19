package com.example.stacks.questions;

public class Main {
    public static void main(String[] args) {
        String exp = "(1 + 2) = {3} <zzz>";
        Expression e = new Expression();

        System.out.println(e.isBalanced(exp));
    }
}
