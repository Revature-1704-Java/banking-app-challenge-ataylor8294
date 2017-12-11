package main.java;
import java.io.Serializable;
import java.util.*;
public class Account implements Serializable{
    private String name;
    private float money;
    private String pass;
    Map<String, String> accountinfo;


    public Account(String name, String pass, float account ){
        this.name = name;
        this.pass= pass;

        money =account;
    }
    public float checkFunds(){
        return money;
    }
    public void Withdraw(float amount){
        if (money>=amount){
            money = money -amount;
        }
        else{
            System.out.println("You dont have enough money for that transaction");
        }
    }
    public void Deposit(float amount){
        money = money +amount;
    }
    public String toString(){
        return "Name: "+name+" Password "+ pass +"Money "+money;
    }
    public String getPass(){
        return pass;

    }
    public String getName(){
        return name;
    }

}