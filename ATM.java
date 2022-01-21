import java.util.*;

public class ATM {
    static Scanner sc = new Scanner(System.in);
    static int Mbalance = 50000;
    static int[] Mdep = { 10, 40, 25, 50 };
    static int ubal = 8000;
    static String name1 = "Tinku";
    static String pass1 = "Rinku";
    static List<Integer> l = new ArrayList<>();
    static List<String> l1 = new ArrayList<>();
    static int lock = 0;
    static int ucount = 0;

    public static void welcome() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Welcome to Canara Bank");
        System.out.println("1) Click 1 if You are an ADMIN");
        System.out.println("2) Click 2 if You are a USER");
        System.out.println("3) Click 3 to EXIT");
        int n = sc.nextInt();
        sc.nextLine();
        if (n == 1)
            admin();
        else if (n == 2)
            user();
        else
            exit();

    }

    public static void admin() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Welome ADMIN!!!");
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter your password: ");
        String k = sc.nextLine();
        if (name.equals(name1) && k.equals(pass1) && lock < 3) {
            adminwork();
        } else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            if (lock < 3) {
                System.out.println("Invalid user name Password");
                System.out.println("Enter valid Details");
                lock++;
                System.out.println("Press enter to continueee");
                String a = sc.nextLine();
                if (a.equals("")) {
                    admin();
                }
            } else {
                System.out.println("You Have Exceeded Your Login Limit\nTry Again After 24 Hours");
                System.out.println("Press enter to continueee");
                String a = sc.nextLine();
                if (a.equals("")) {
                    welcome();
                }
            }

        }

    }

    public static void adminwork() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("1)Click 1 to Check ATM Balance");
        System.out.println("2)Click 2 to Deposit Money");
        System.out.println("3)Click 3 to Exit");
        int k = sc.nextInt();

        switch (k) {
            case 1:
                atmbalance();
                break;
            case 2:
                deposite();
                break;
            case 3:
                welcome();
                break;
            default:
                System.out.println("Error occured!!!!!!!!!!");
                welcome();
                break;
        }
    }

    public static void atmbalance() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("ATM Balance is: " + Mbalance);
        System.out.println("No of $2000 ----->" + Mdep[0]);
        System.out.println("No of $500 ----->" + Mdep[1]);
        System.out.println("No of $200 ----->" + Mdep[2]);
        System.out.println("No of $100 ----->" + Mdep[3]);
        System.out.println("Press enter to continueee");
        sc.nextLine();
        String k = sc.nextLine();
        if (k.equals("")) {
            adminwork();
        }
    }

    public static void deposite() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Enter no of notes: ");
        System.out.print("No of 2000 Notes: ");
        sc.nextLine();
        Mdep[0] = sc.nextInt();
        System.out.print("No of 500 Notes: ");
        sc.nextLine();
        Mdep[1] = sc.nextInt();
        System.out.print("No of 200 Notes: ");
        sc.nextLine();
        Mdep[2] = sc.nextInt();
        System.out.print("No of 100 Notes: ");
        sc.nextLine();
        Mdep[3] = sc.nextInt();
        sc.nextLine();
        Mbalance += Mdep[0] * 2000 + Mdep[1] * 500 + Mdep[2] * 200 + Mdep[3] * 100;
        System.out.println("Amount Added Successfully: ");
        System.out.println("Total amount is: " + Mbalance);
        System.out.println("Press enter to continueee");
        // sc.nextLine();
        String a = sc.nextLine();
        if (a.equals("")) {
            adminwork();
        }
    }

    public static void user() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Welcome USER!!!");
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter your password: ");
        String k = sc.nextLine();
        if (name.equals(name1) && k.equals(pass1) && ucount < 3) {
            userwork();
        } else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            if (ucount < 3) {
                System.out.println("Invalid user name Password!!!!");
                System.out.println("Enter valid Details");
                ucount++;
                System.out.println("Press enter to continueee");
                String a = sc.nextLine();
                if (a.equals("")) {
                    user();
                }
            } else {
                System.out.println("You have Exceeded Your Login Limit!!!\n Try After 24 Hours");
                System.out.println("Press enter to continueee");
                String a = sc.nextLine();
                if (a.equals("")) {
                    welcome();
                }
            }
        }
    }

    public static void userwork() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("1) Balace Enquiry");
        System.out.println("2) Withdrawal");
        System.out.println("3) Pin change");
        System.out.println("4) Money Transfer");
        System.out.println("5) Mini Statement");
        System.out.println("6) Exit");
        int k = sc.nextInt();
        sc.nextLine();
        switch (k) {
            case 1:
                ube();
            case 2:
                withdraw();
            case 3:
                upinc();
            case 4:
                utransfer();
            case 5:
                statement();
            case 6:
                welcome();
            default:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Error occured!!!!!");
                System.out.println("Press enter to continueee");
                String a = sc.nextLine();
                if (a.equals("")) {
                    userwork();
                }
        }
    }

    public static void ube() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Your Account Balance is: " + ubal);
        System.out.println("Press enter to continueee");
        String k = sc.nextLine();
        if (k.equals("")) {
            userwork();
        }

    }

    public static void withdraw() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.print("Enter the amount to be withdrawn:");
        int k = sc.nextInt();
        sc.nextLine();
        if (k <= ubal) {
            l.add(k);
            l1.add("w");
            ubal -= k;
            System.out.println("Available user balance :" + ubal);
            while (k > 0) {
                if (k >= 2000 && Mdep[0] > 0) {
                    Mdep[0]--;
                    k -= 2000;
                } else if (k >= 500 && Mdep[1] > 0) {
                    Mdep[1]--;
                    k -= 500;
                } else if (k >= 200 && Mdep[2] > 0) {
                    Mdep[2]--;
                    k -= 200;
                } else if (k >= 100 && Mdep[3] > 0) {
                    Mdep[3]--;
                    k -= 100;
                }
                Mbalance -= k;
                System.out.println("Press enter to continueee");
                String a = sc.nextLine();
                if (a.equals(""))
                    userwork();

            }
        } else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Sorry Insufficient Balance:");
            System.out.println("Press enter to continueee");
            String a = sc.nextLine();
            if (a.equals(""))
                userwork();
        }
    }

    public static void upinc() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.print("Enter your old pin:");
        String a = sc.nextLine();
        System.out.print("Enter your new pin:");
        String b = sc.nextLine();
        if (a.equals(pass1) && !(a == b)) {
            pass1 = b;
            System.out.println("-------Pin Changed Successfully!!!!-------");
            System.out.println("Press Enter to Continue");
            String k = sc.nextLine();
            if (k.equals("")) {
                userwork();
            }
        } else {
            System.out.println("Enter Valid Pin!!!!");
            System.out.println("Press Enter to Continue");
            String k = sc.nextLine();
            if (k.equals("")) {
                userwork();
            }
        }
    }

    public static void utransfer() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.print("Enter Account Number: ");
        String a = sc.nextLine();
        if (a.contains("CNRB")) {
            System.out.print("Enter Amount to be Tranferred: ");
            int am = sc.nextInt();
            sc.nextLine();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            if (am < ubal && am < Mbalance) {
                ubal -= am;
                Mbalance -= am;
                System.out.println("Transaction Success!!!!");
                l.add(am);
                l1.add("t");
                System.out.println("Press enter to continueee");
                String k = sc.nextLine();
                if (k.equals("")) {
                    userwork();
                }
            } else if (am > Mbalance) {
                System.out.println("Insufficient Balance in ATM!!!");
                System.out.println("Press enter to continueee");
                String k = sc.nextLine();
                if (k.equals("")) {
                    utransfer();
                }
            } else if (am > ubal) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Insufficient Balance!!!!");
                System.out.println("Your Balance is:" + ubal);
                System.out.println("Press enter to continueee");
                String k = sc.nextLine();
                if (k.equals("")) {
                    utransfer();
                }
            }
        } else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Invalid Account Number!!!!!");
            System.out.println("Enter valid Account Number!!!!");
            System.out.println("Press enter to continueee");
            String k = sc.nextLine();
            if (k.equals("")) {
                utransfer();
            }
        }
    }

    public static void statement() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
        System.out.println("----------Transactions Made-----------");
        int i, a = 1;
        for (i = l.size() - 1; i >= 0; i--) {
            if (a <= 5) {
                if (l1.get(i).equals("t")) {
                    System.out.println(a + ") " + l.get(i) + " Transferred");
                    a++;
                } else if (l1.get(i).equals("w")) {
                    System.out.println(a + ") " + l.get(i) + " Withdrawn");
                    a++;
                }
            }
        }
        System.out.println("Thank you for visiting!!!!!!!!");
        System.out.println("Press enter to continueee");
        String k = sc.nextLine();
        if (k.equals("")) {
            userwork();
        }
    }

    public static void exit() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Thank you for visiting!!!!!!!!");
        System.out.println("Press enter to continueee");
        String k = sc.nextLine();
        if (k.equals("")) {
            welcome();
        }
    }

    public static void main(String args[]) {
        welcome();

    }

}