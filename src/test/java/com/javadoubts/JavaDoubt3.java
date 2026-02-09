package com.javadoubts;

public class JavaDoubt3 {
    public static void main(String[] args) {
        Ram r = new Bheem();
        r.printName();
    }
}

interface Ram{
   void printName();
}

class Bheem implements Ram{
    public void printName(){
        System.out.println("My name is Bheem...");
    }
}