import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.SQLOutput;
import java.util.*;
class bankaccount{
    static  void register(){
        Scanner sc=new Scanner(System.in);
        System.out.println("");
        System.out.println("Enter your name :");
        ATM1.name=sc.nextLine();
        System.out.println("Enter username :");
        String user=sc.nextLine();
        System.out.println("Enter password :");
        String pass=sc.nextLine();
        System.out.println("Enter your Account number :");
        ATM1.accnumber=sc.nextLine();
        System.out.println("REGISTRATION HAS BEEN DONE SUCCESSFULLY!");
        System.out.println("---------------------------");
        ATM1.prompt();
        while(true){
            display(ATM1.name);
            int choice=sc.nextInt();
            if(choice==1){
                login(user,pass);
                break;
            }
            else {
                if(choice==2){
                    System.exit(0);
                }
                else{
                    System.out.println("Invalid ! Enter again!");
                }
            }
        }
    }
    static void display(String name){}
    static void login(String user,String pass){}
}
class transaction{
    static void withdraw(){
        Scanner sc=new Scanner(System.in);
        System.out.println("----------------");
        System.out.println("Enter amount to withdraw :");
        int wamt=sc.nextInt();
        if(wamt<=ATM1.balance){
            ATM1.balance=ATM1.balance-wamt;
            ATM1.history.add(Integer.toString(wamt));
            ATM1.history.add("Withdraw");
            System.out.println("Amount Rs"+wamt+"/-has been withdrawn successfully");
            System.out.println("---------------------------");
        }
        else{
            System.out.println("There is a insufficient balance to withdraw the cash");
            System.out.println("---------------------------");
        }
        ATM1.prompt();
    }
    static void deposit(){
        Scanner sc=new Scanner(System.in);
        System.out.println("----------------");
        System.out.print("Enter amount to deposit :");
        int damt=sc.nextInt();
        ATM1.updatebalance(damt);
        ATM1.history.add(Integer.toString(damt));
        ATM1.history.add("Deposit");
        System.out.println("Amount Rs."+damt+"/-has been deposited in to your account successful!");
        System.out.println("---------------------------");
        ATM1.prompt();
    }
    static void transfer(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the receiver name:");
        String s=sc.nextLine();
        System.out.println("Enter the account number of the receiver");
        int num=sc.nextInt();
        System.out.println("Enter the amount to be transferred :");
        int tamt=sc.nextInt();
        if(tamt<=ATM1.balance){
            ATM1.balance=ATM1.balance-tamt;
            ATM1.history.add(Integer.toString(tamt));
            ATM1.history.add("transferred");
            System.out.println("Amount Rs."+tamt+"/- has been transferred successfully");
            System.out.println("---------------------------");
        }
        else{
            System.out.println("There is an insufficient balance to transfer the cash");
            System.out.println("---------------------------");
        }
    }
}
class check{
    static void checkbalance(){
        System.out.println("------------------");
        System.out.println("The available balance in the bank account :");
        ATM1.showbalance();
        System.out.println("---------------------------");
        ATM1.prompt();
    }
}
class his{
    static void transactionhistory(){
            System.out.println("---------------------");
            System.out.println("Transaction History :");
            int k=0;
            if(ATM1.balance>0){
            for(int i=0;i<(ATM1.history.size()/2);i++)
            {
                for(int j=0;j<2;j++)
                {
                    System.out.print(ATM1.history.get(k)+" ");
                    k++;
                }
                System.out.println("---------------------");
            }
            }
            else {
                System.out.println("your account is empty");
            }
            ATM1.prompt();
    }
}
public class ATM1 {
    public static String name;
    public static int balance=0;
    public static String accnumber;
    public static ArrayList<String> history=new ArrayList<String>();

    static void updatebalance(int dcash){
        balance=balance+dcash;
    }
    static void showbalance(){
        System.out.println(balance);
    }
    public static void homepage(){
        System.out.println("\033[H\033[2J");
        Scanner sc=new Scanner(System.in);
        System.out.println("WELCOME TO ATM INTERFACE");
        System.out.println("");
        System.out.println("select option :");
        System.out.println("1. Register");
        System.out.println("2. Exit");
        System.out.println("Enter choice");
        int choice =sc.nextInt();
        if (choice==1){
                bankaccount.register();
        }
        else {
            if(choice==2){
                System.exit(0);
            }
            else{
                System.out.println("select a value only from the given options :");
                homepage();
            }
        }
    }
    static void prompt(){
        Scanner sc=new Scanner(System.in);
        System.out.println("WELCOME "+ATM1.name+"! TO ATM SYSTEM");
        System.out.println("---------------------");
        System.out.println("Select option : ");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Transfer");
        System.out.println("4. Check balance");
        System.out.println("5. Transaction History");
        System.out.println("6. Exit");
        System.out.print("Enter your choice : ");
        int choice=sc.nextInt();
        switch (choice) {
            case 1:
                transaction.withdraw();
            case 2:
                transaction.deposit();
            case 3:
                transaction.transfer();
            case 4:
                check.checkbalance();
            case 5:
                his.transactionhistory();
            case 6:
                System.exit(0);
        }
    }

    public static void main(String[] args) {
        homepage();
    }
}