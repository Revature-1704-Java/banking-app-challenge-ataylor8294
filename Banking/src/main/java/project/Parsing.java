
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

import com.sun.javafx.runtime.SystemProperties;

import main.java.Account;


public class Parsing{

    public static ArrayList<Account> newaccounts = new ArrayList<Account>();
    public static Account current;
    public static void start(){
        try{
            Account a;
            int count =0;
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("Accounts.ser"));
            while (count<100){
                a = (Account) is.readObject();
                newaccounts.add(a);
                count++;
            }
        }
        catch(EOFException e){

        }
        catch(IOException e){

        }
        catch (ClassNotFoundException e){
        }
    }
    public static boolean getInput(int men)
    {
        int choice;
        boolean found =false;
        Scanner scan = new Scanner(System.in);
        if (men ==1){
            while (!scan.hasNextInt())
            {

            }
            choice = scan.nextInt();
            switch(choice){
            case 1: boolean xyz =findAccount();
            if (xyz){

            }
            else{
                System.out.println("login failed. Incorrect name and password compbination");
            }
            return xyz;
            case 2: System.out.println("How much?");
                float and;
                and =scan.nextFloat();
                current.Deposit(and);createAccount();
            return true;
            case 3: finish();
            break;
            default: System.out.println("Not a valid command");
            return false;
            }
        }
        else if(men==2){
            choice = scan.nextInt();
            switch (choice){
                case 1: System.out.println(current.checkFunds());
                break;
                case 2: System.out.println("How much?");
                float and;
                and =scan.nextFloat();
                current.Deposit(and);
                break;
                case 3: System.out.println("How much?");
                float andi;
                andi =scan.nextFloat();
                current.Withdraw(andi);
                break;
                case 4: finish();
                break;
                case 5: 
                return false;
                default: System.out.println("Incorrect command");
                return true;

            }
        }

        return true;
    }
    public static boolean findAccount(){
        System.out.println("What is your name?");
        Scanner scan = new Scanner(System.in);
        String name;
        String pass;
        boolean found = false;
        name = scan.next();
        System.out.println("Whats your password");
        pass = scan.next();
        for (Account i : newaccounts){
            if (name.equalsIgnoreCase(i.getName())){
                if (pass.equalsIgnoreCase(i.getPass())){
                    found =true;
                    current = i;
                }
            }
        }
        
        return found;
        
    }
    public static void listAccount(){
        for (Account a: newaccounts){
            System.out.println(a.toString());
        }
    }
    public static void finish(){
        try{
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Accounts.ser"));
        for (Account a: newaccounts){
            os.writeObject(a);
        }
    }
        catch(IOException e){

        }
        finally{
            System.exit(0);
        }
    }
    public static void createAccount(){
        String name;
        String pass;
        float money=0.0f;
        System.out.println("Whats your first name?");
        Scanner scan = new Scanner(System.in);
        name = scan.next();
        System.out.println("Whats your password?");
        pass = scan.next();
        while (pass.length()<6){
            System.out.println("Password must be at least six characters");
            pass = scan.next();
        }
        System.out.println("How much money is iin your account? No cents");
        DecimalFormat df = new DecimalFormat();
        money = scan.nextFloat();
        Account a = new Account(name, pass, money);
        newaccounts.add(a);
        System.out.println("Congragulations you are now logged in");
        current = a;

        
        
    }
}



