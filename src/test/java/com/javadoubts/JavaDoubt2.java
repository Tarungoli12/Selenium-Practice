package com.javadoubts;

public class JavaDoubt2 {
    public static void main(String[] args) {
        Child c = new Child();
    }
}

class Parent{
    private int cID;
    private String cName;
    public Parent(){
        cID = 1;
        cName = "Ram";
        System.out.println(cID + " " + cName);
    }
}

class Child extends Parent{
}