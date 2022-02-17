import java.util.*;

public class Split {
    static int a, balance = 10000, balance2 = 5000, n = 0;
    static String a1 = "";
    static ArrayList<String> l1 = new ArrayList<>();
    static ArrayList<String> l2 = new ArrayList<>();
    static ArrayList<String> l3 = new ArrayList<>();
    static ArrayList<String> l4 = new ArrayList<>();
    static ArrayList<String> l5 = new ArrayList<>();
    static ArrayList<String> l6 = new ArrayList<>();
    static ArrayList<String> l7 = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Flush();
        l1.add("Tinku");
        l1.add("Pranauv");
        l1.add("Rajee");
        l2.add("Rinku");
        l4.add("1");
        l4.add("2");
        l4.add("3");
        welcome();
    }

    public static void welcome() {
        Flush();
        System.out.println("\t\t------------ Split Wise ------------");
        System.out.println("1.LOGIN");
        System.out.println("2.EXIT");
        a = sc.nextInt();
        sc.nextLine();
        if (a == 1) {
            login();
        } else {
            welcome();
        }
    }

    public static void login() {
        Flush();
        System.out.println("\t\t------------ Login -----------");
        System.out.print("Enter Name : ");
        a1 = sc.nextLine();
        System.out.print("Enter Password : ");
        String a2 = sc.nextLine();
        if (l1.contains(a1) && l2.contains(a2)) {
            System.out.println("\t\tWELCOME " + a1);
            System.out.println();
            int i = l1.indexOf(a1);
            l3.add(a1);
            l1.remove(i);
            user();
        } else {
            welcome();

        }
    }

    public static void user() {
        Flush();
        System.out.println("1.SHOP");
        System.out.println("2.PAY");
        System.out.println("3.CHECK");
        System.out.println("4.EXIT");
        int ll = sc.nextInt();
        if (ll == 1)
            shop();
        else if (ll == 2)
            pay();
        else if (ll == 3)
            check();
        else
            welcome();
    }

    public static void shop() {
        Flush();
        System.out.println("1.Canteen");
        System.out.println("2.Textiles");
        System.out.println("3.Travel Charge");
        System.out.println("4.Exit");
        System.out.println();
        int k = sc.nextInt();
        if (k == 1)
            gotoo();
        else if (k == 2)
            gotoo();
        else if (k == 3)
            gotoo();
        else
            welcome();
    }

    public static void gotoo() {
        Flush();
        System.out.println("1.CALL FRIENDS");
        System.out.println("2.EXIT");
        int k = sc.nextInt();
        if (k == 1) {
            for (int i = 0; i < l1.size(); i++) {
                System.out.println("-------------------------------------------------");
                System.out.println("id: " + l1.indexOf(l1.get(i)) + " NAME : " + l1.get(i));
            }
            System.out.println();
            System.out.println("ENTER THE NUMBER OF FRIENDS ");
            int pp = sc.nextInt();
            System.out.println("ENTER THE NAME");
            for (int i = 0; i < pp; i++) {
                String ka = sc.next();
                l3.add(ka);
            }
            System.out.println(l3);
            l1.add(a1);
            bill();
        } else
            welcome();

    }

    static int bb;

    public static void bill() {
        Flush();
        System.out.println("\t\tTOTAL BILL IS: 1250");
        System.out.println();
        for (int i = 0; i < l3.size(); i++) {
            System.out.println("-----------------------------------------------");
            System.out.println("NAME : " + l3.get(i) + "   " + "ID : " + l4.get(i));
        }
        System.out.println("WHO WANT TO PAY THE BILL");
        String u = sc.next();
        int kp = l4.indexOf(u);
        System.out.println(kp);
        System.out.println();
        System.out.println(l3.get(kp) + " HAS PAID THE BILL");
        System.out.println();
        l6.add(l3.get(kp));
        l3.remove(kp);
        l5.addAll(l3);
        bb = 1250;
        balance -= bb;
        System.out.println();
        System.out.println("-------ENTER TO CONTINUE------");
        sc.nextLine();
        String s = sc.nextLine();
        if (s.equals(""))
            user();
    }

    public static void check() {
        Flush();
        if (l5.contains(a1)) {
            System.out.println("YOU HAVE TO PAY " + l6.get(0));
            System.out.println(bb / 3);
        } else if (l6.contains(a1)) {
            System.out.println("YOU NEED TO COLLECT THE MONEY FROM ");
            for (int i = 0; i < l5.size(); i++) {
                System.out.println(l5.get(i));
                System.out.println();
            }
            System.out.println("YOUR BALANCE IS " + balance);
            if (balance >= (bb / 3) * 3) {
                l7.addAll(l6);
                l6.clear();

            }
        } else {
            if (l7.contains(a1))
                System.out.println("YOUR BALANCE IS " + balance);
            else
                System.out.println("YOUR BALANCE IS " + balance2);
        }
        System.out.println();
        System.out.println("-------ENTER TO CONTINUE------");
        sc.nextLine();
        String s = sc.nextLine();
        if (s.equals(""))
            user();
    }

    public static void pay() {
        Flush();
        if (l5.contains(a1)) {
            System.out.println("YOU NEED TO PAY " + l6.get(0) + " " + bb / 3);
            System.out.println();
            System.out.println("ENTER THE AMOUNT");
            int amount = sc.nextInt();
            balance += amount;
            balance2 -= amount;
            int id = l5.indexOf(a1);
            l5.remove(id);
            System.out.println(l6);
            System.out.println();
            System.out.println("SUCCESSFULLY PAID");
        } else {
            System.out.println("NO NEED TO PAY");
        }
        System.out.println();
        System.out.println("-------ENTER TO CONTINUE------");
        sc.nextLine();
        String s = sc.nextLine();
        if (s.equals(""))
            user();
    }

    public static void Flush() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}