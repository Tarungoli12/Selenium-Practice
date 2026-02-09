package com.javadoubts;

public class JavaDoubt1 {
    public static void main(String[] args) {
        Customer c1 = new Customer();
        System.out.println("First Object");
        System.out.println(c1.getCID() + " " + c1.getCName() + " " + c1.getCNum());

        System.out.println("Second Object");
        Customer c2 = new Customer(2,"Sankar",91736820);
        System.out.println(c2.getCID() + " " + c2.getCName() + " " + c2.getCNum());
        
        System.out.println("First Object");
        System.out.println(c1.getCID() + " " + c1.getCName() + " " + c1.getCNum());
    }
}

class Customer{
    private int cID;
    private String cName;
    private long cNum;

    public Customer(){
        cID = 1;
        cName = "Tarun";
        cNum = 98266715L;
    }

    public Customer(int cID,String cName,long cNum){
        this.cID = cID;
        this.cName =cName;
        this.cNum = cNum;
    }

    public int getCID(){
        return cID;
    }
    public String getCName(){
        return cName;
    }
    public long getCNum(){
        return cNum;
    }
}
