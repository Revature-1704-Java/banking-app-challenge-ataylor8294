import com.sun.javafx.runtime.SystemProperties;

public class App 
{
    public static void main( String[] args )
    {
        Parsing.start();
        Parsing.listAccount();
        boolean running =true;
        boolean login = false;
        while (running){
        int result=0;
            if (!login)
            {
              menu1();
              login = Parsing.getInput(1);  
            }
            else{
                menu2();
               login= Parsing.getInput(2);
            }
        }
        
    }
    public static void menu1(){
        System.out.println("Welcome to Swiss Banking plus");
        System.out.println("To login press 1, To Create an account press 2, To Quit appliication press 3");

    } 
    public static void menu2(){
        System.out.println("1: Check your balance");
        System.out.println("2: Deposit money");
        System.out.println("3: Withdraw Money");
        System.out.println("4: Quit Application");
        System.out.println("5: Logout");
        Parsing.getInput(2);

    }
}
