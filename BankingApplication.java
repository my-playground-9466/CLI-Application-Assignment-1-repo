import java.util.Arrays;
import java.util.Scanner;

public class BankingApplication{
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        final String CLEAR = "\033[H\033[2J";
        final String COLOR_BLUE_BOLD = "\033[34;1m";
        final String COLOR_RED_BOLD = "\033[31;1m";
        final String COLOR_GREEN_BOLD = "\033[33;1m";
        final String RESET = "\033[0m";

        final String DASHBOARD = "💰Welcome to Smart Banking App";
        final String OPEN_ACCOUNT = "Open New Account";
        final String DEPOSIT_MONEY = "Deposit Money";
        final String WITHDRAW_MONEY = "Withdraw Money";
        final String TRANSFER_MONEY = "Transfer Money";
        final String CHECK_BALANCE = "Check Account Balance";
        final String DROP_ACCOUNT = "Drop Existing Account";

        String[] accounts = new String[0];
        String[] customerNames = new String[0];
        double[] balance = new double[0];

        String screen = DASHBOARD;

        do{
            final String APP_TITLE = String.format("%s%s%s",COLOR_BLUE_BOLD,screen,RESET);

            System.out.println(CLEAR);
            System.out.println("\t"+ APP_TITLE + "\n");

            switch(screen){
                case DASHBOARD:
                    System.out.println("\t[1]. Open New Account");
                    System.out.println("\t[2]. Deposit Money");
                    System.out.println("\t[3]. Withdraw Money");
                    System.out.println("\t[4]. Transfer Money");
                    System.out.println("\t[5]. Check Account Balance");
                    System.out.println("\t[6]. Drop Existing Account");
                    System.out.println("\t[7]. Exit");
                    System.out.println("\tEnter an option to continue");
                    int option = scanner.nextInt();
                    scanner.nextLine();

                    switch(option){
                        case 1: screen = OPEN_ACCOUNT; break;
                        case 2: screen = DEPOSIT_MONEY; break;
                        case 3: screen = WITHDRAW_MONEY; break;
                        case 4: screen = TRANSFER_MONEY; break;
                        case 5: screen = CHECK_BALANCE; break;
                        case 6: screen = DROP_ACCOUNT; break;
                        case 7: System.out.println(CLEAR); System.exit(0);
                        default: continue;
                    }
                    break;

                case OPEN_ACCOUNT:
                    String accountNumber;
                    String name;
                    double diposit;
                    boolean valid;

                    accountNumber = String.format("SDB-%05d",(accounts.length + 1));

                    System.out.printf("Account ID: %s \n", (accountNumber));

                    do{
                        valid = true;
                        System.out.println("Enter Account Holder's name :");
                        name = scanner.nextLine().strip();
                    
                    
                        if(name.isBlank()){
                            System.out.printf("%sName can't be empty%s\n", COLOR_RED_BOLD, RESET);
                            valid = false;
                            continue;
                        }
                            for (int i = 0; i < name.length(); i++) {
                                if (!(Character.isLetter(name.charAt(i)) || Character.isSpaceChar(name.charAt(i))) ) {
                                    System.out.printf("%sInvalid Name%s\n", COLOR_RED_BOLD, RESET);
                                    valid = false;
                                    break;
                                }
                            }   


                    }while(!valid);

                    do{
                        valid = true;
                        System.out.print("Enter the initial diposit ammount (Rs.) :");
                        diposit = scanner.nextDouble();
                        scanner.nextLine();

                        if( diposit < 5000.00){
                            System.out.printf("%sInsufficiant Amount%s\n", COLOR_RED_BOLD, RESET);
                            valid=false;
                        
                        }
                        

                    }while(!valid);
                    

                    String[] newAccounts = new String[accounts.length+1];
                    String[] newCustomerNames = new String[customerNames.length+1];
                    double[] newBalance = new double[balance.length+1];

                    for(int i=0; i<accounts.length;i++){
                        newAccounts[i] = accounts[i];
                        newCustomerNames[i] = customerNames[i];
                        newBalance[i] = balance[i];

                    }

                    newAccounts[newAccounts.length - 1] = accountNumber;
                    newCustomerNames[newCustomerNames.length-1] = name;
                    newBalance[newBalance.length-1] = diposit;

                    accounts=newAccounts;
                    customerNames=newCustomerNames;
                    balance=newBalance;
                    System.out.println();

                    System.out.println("Account has been created successfully.");
                    System.out.println("Do you want to continue adding (Y/n)? ");
                    if(scanner.nextLine().strip().toUpperCase().equals("Y")) continue;
                    screen = DASHBOARD;
                    break;

                


                }

               

            


        }while(true);



        
    }
}