import java.util.*;

public class Railway {
    static Scanner sc = new Scanner(System.in);
    static String Adname = "Tinku", Adpass = "Rinku";
    static int Boo[][] = new int[5][7];
    static ArrayList<Waiting> Waitingl = new ArrayList<>();
    static ArrayList<Bookings> Books = new ArrayList<>();
    static ArrayList<User> Userl = new ArrayList<>();
    static int Index = -1;

    public static void Welcome() {
        Userl.add(new User("Kemya", "1234", "UID00"));
        Flush();
        boolean flag = true;
        System.out.println("\t\t----------Welcome to Railway Reservation Services----------\n");
        System.out.println("1) Admin");
        System.out.println("2) Passesngers");
        System.out.println("3) Exit");
        int a = sc.nextInt();
        sc.nextLine();
        while (flag) {
            switch (a) {
                case 1:
                    Admin();
                    break;
                case 2:
                    Passen();
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("Enter Valid Number!");
                    Welcome();
                    break;
            }
        }

    }

    public static void Admin() {
        Flush();
        System.out.println("\t\t---------- Login to Continue -----------\n");
        System.out.print("Enter Ur Name : ");
        String a = sc.nextLine();
        System.out.print("Enter Ur Passcode : ");
        String b = sc.nextLine();
        if (Adname.equals(a) && Adpass.equals(b)) {
            Adwork();
        } else {
            System.out.println("Invalid Name Or Passcode!");
            Enter();
            String k = sc.nextLine();
            if (k.equals(""))
                Welcome();
        }

    }

    public static void Adwork() {
        Flush();
        System.out.println("\t\tWelcome Admin!!!\n");
        System.out.println("1) View Booked Tickets");
        System.out.println("2) View Reserved Tickets");
        System.out.println("3) Exit");
        int a = sc.nextInt();
        sc.nextLine();
        switch (a) {
            case 1:
                Viewbooked();
                break;
            case 2:
                Viewreserved();
                break;
            case 3:
                Welcome();
                break;
            default:
                System.out.println("Enter Valid Number!");
                Adwork();
                break;
        }
    }

    public static void Viewbooked() {
        Flush();
        System.out.println("\t\t-------- Booked Tickets ---------");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(Boo[i][j]);
            }
            System.out.println("");
        }
        System.out.println("\t\t---------------x----------x---------------\n");
        Enter();
        String k = sc.nextLine();
        if (k.equals(""))
            Adwork();

    }

    public static void Viewreserved() {
        Flush();
        System.out.println("\t\t-------- Waiting Lists ---------");
        int c = 0;
        for (int i = 0; i < Waitingl.size(); i++) {
            c++;
            System.out.println("User Id : " + Waitingl.get(i).uid);
            System.out.println("Starting station : " + Waitingl.get(i).start);
            System.out.println("Ending station : " + Waitingl.get(i).end);
            System.out.println("\t\t---------------x----------x---------------\n");
        }
        if (c == 0) {
            System.out.println("\t\t\tEmpty!!!");
        }
        Enter();
        String k = sc.nextLine();
        if (k.equals(""))
            Adwork();
    }

    public static void Passen() {
        Flush();
        System.out.println("\t\t-------- Welcome Passenger! --------");
        System.out.println("1) Login");
        System.out.println("2) Signup");
        System.out.println("3) Exit");
        int a = sc.nextInt();
        sc.nextLine();
        switch (a) {
            case 1:
                Plog();
                break;
            case 2:
                Psign();
                break;
            case 3:
                Welcome();
                break;
            default:
                System.out.println("Enter Valid Number!");
                Passen();
                break;
        }
    }

    public static void Plog() {
        Index = -1;
        Flush();
        System.out.println("\t\t-------------Login To Continue!---------------\n");
        System.out.print("Enter Your Name : ");
        String name = sc.nextLine();
        System.out.print("Enter Your Password : ");
        String pass = sc.nextLine();
        for (int i = 0; i < Userl.size(); i++) {
            if ((Userl.get(i).name.equals(name)) && (Userl.get(i).password.equals(pass))) {
                Index = i;
                Pwork();
            }
        }
        if (Index < 0) {
            System.out.println("Invalid Name Or Password!");
            System.out.println("Enter Valid Details!");
            Enter();
            String k = sc.nextLine();
            if (k.equals(""))
                Passen();
        }

    }

    public static void Psign() {
        Flush();
        System.out.println("\t\t----Signup to Continue!----\n");
        System.out.print("Enter Your Name : ");
        String a = sc.nextLine();
        System.out.print("Enter Password : ");
        String b = sc.nextLine();
        System.out.print("Re-enter Password : ");
        String c = sc.nextLine();
        if (b.equals(c)) {
            Userl.add(new User(a, b, "UID" + Userl.size()));
            System.out.println("You Have Successfully Signed up!");
            Enter();
            String k = sc.nextLine();
            if (k.equals(""))
                Passen();
        } else {
            System.out.println("Re-enter Password Correctly!");
            Enter();
            String k = sc.nextLine();
            if (k.equals(""))
                Psign();

        }
    }

    public static void Pwork() {
        Flush();
        System.out.println("\t\t--------- Welcome Passenger! ----------\n");
        System.out.println("1) Ticket Booking");
        System.out.println("2) Ticket Cancellation");
        System.out.println("3) Booking History");
        System.out.println("4) Exit");
        int a = sc.nextInt();
        sc.nextLine();
        switch (a) {
            case 1 -> Tbook();
            case 2 -> Tcancel();
            case 3 -> Thistory();
            case 4 -> Welcome();
            default -> {
                System.out.println("Enter valid Number!");
                Enter();
                String k = sc.nextLine();
                if (k.equals(""))
                    Pwork();
            }
        }

    }

    public static void Tbook() {
        Flush();
        System.out.println("\t\t------ Booking -------\n");
        System.out.print("Enter No Of Passengers : ");
        int a = sc.nextInt();
        for (int i = 0; i < a; i++) {
            System.out.println(
                    "1) Coimbatore\n2) Tirupur\n3) Erode\n4) Chennai\n5) Cochin\n6) Banglore\n7) Mysore");
            System.out.print("Enter Starting Point for Passenger : ");
            int s = sc.nextInt();
            System.out.print("Enter Ending Point for Passenger : ");
            int e = sc.nextInt();
            sc.nextLine();
            int Seatnum = 0;
            for (int seat = 0; seat < Boo.length; seat++) {
                int sum = 0;
                for (int station = s - 1; station <= e - 1; station++) {
                    sum += Boo[seat][station];
                }
                if (sum == 0) {
                    System.out.println("Seat Number " + seat + 1 + " Booked!");
                    String Ticketid = "TICKET" + Books.size();
                    System.out.println("Your Ticket Id is : " + Ticketid);
                    Books.add(new Bookings(Userl.get(Index).id, s, e, Ticketid, "No", seat + 1));
                    for (int k = s - 1; k <= e - 1; k++) {
                        Boo[seat][k] = i + 1;
                    }
                    Seatnum = 1;
                    break;
                }
            }
            for (int n = 0; n < 5; n++) {
                for (int stat = 0; stat < 7; stat++) {
                    System.out.print(Boo[n][stat]);
                }
                System.out.println();
            }
            if (Seatnum == 0 && Waitingl.size() < 5) {
                System.out.println("Putting You In Waiting List!");
                Waitingl.add(new Waiting(Userl.get(Index).id, s, e));
            } else if (Waitingl.size() == 5) {
                System.out.println("Seats Not Available!");
            } else {
                Seatnum = 0;
            }
            for (Waiting l : Waitingl) {
                System.out.println(l.uid + " " + l.start + " " + l.end);
            }
        }
        Enter();
        String l = sc.nextLine();
        if (l.equals(""))
            Pwork();

    }

    public static void Tcancel() {
        Flush();
        System.out.println("\t\t-------------------Ticket Cancelling -----------------\n");
        System.out.print("Enter Your Ticket ID(eg:TICKET1) : ");
        String t = sc.nextLine();
        int count = 0;
        for (int i = 0; i < Books.size(); i++) {
            if (Books.get(i).Ticketid.equals(t) && Userl.get(Index).id.equals(Books.get(i).uid)
                    && Books.get(i).travel.equals("No")) {
                System.out.println("Enter Yes To Confirm Cancellation");
                String s = sc.nextLine();
                count++;
                if (s.equals("Yes")) {
                    Books.get(i).travel = "Cancelled";
                    System.out.println("Ticket cancelled Successfully");
                    for (int k = 0; k < Boo.length; k++) {
                        for (int w = Books.get(i).start - 1; w < Books.get(i).end; w++) {
                            Boo[Books.get(i).seatno - 1][w] = 0;
                        }
                        for (int j = 0; j < Waitingl.size(); j++) {
                            for (int p = 0; p < Boo.length; p++) {
                                int sum = 0;
                                for (int o = Books.get(j).start - 1; o < Books.get(j).end; o++) {
                                    sum += Boo[p][o];
                                }
                                if (sum == 0) {
                                    System.out.println("seat Allocated " + (k + 1));
                                    String Ticketid = "TICKET" + Books.size();
                                    System.out.println("Your Ticket Id is : " + Ticketid);
                                    Books.add(new Bookings(Waitingl.get(j).uid, Waitingl.get(j).start,
                                            Waitingl.get(j).end,
                                            Ticketid, "No", k + 1));
                                    for (int n = Waitingl.get(j).start - 1; n < Waitingl.get(j).end; n++) {
                                        Boo[k][n] = i + 1;
                                    }
                                    Waitingl.remove(j);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (count == 0) {
            System.out.println("User Not Found Or User Already Travelled");
            Enter();
            String l = sc.nextLine();
            if (l.equals(""))
                Pwork();
        } else {
            Enter();
            String l = sc.nextLine();
            if (l.equals(""))
                Pwork();
        }

    }

    public static void Thistory() {
        Flush();
        System.out.println("\t\t---------- Your Travel History! ---------");
        int a = 1;
        for (int i = Books.size() - 1; i >= 0; i--) {
            if (Books.get(Index).uid.equals(Userl.get(Index).id)) {
                System.out.println(a + ") Starting point : " + Books.get(Index).start);
                System.out.println("   Ending point : " + Books.get(Index).end);
                System.out.println("   Seat Number : " + Books.get(Index).seatno);
                System.out.println("   Ticket ID : " + Books.get(Index).Ticketid);
                System.out.println("   Ticket Expirey : " + Books.get(Index).travel);
                System.out.println("------------------------------------------------");
                a++;
            }
        }
        if (a == 1) {
            System.out.println("\t\t\tEmpty!!!");
        }
        Enter();
        String k = sc.nextLine();
        if (k.equals(""))
            Pwork();

    }

    public static void Exit() {
        Flush();
        System.out.println("----Thank You For Visiting Railway Reservation Services----");
        Enter();
        String k = sc.nextLine();
        if (k.equals("")) {

        }
    }

    public static void Flush() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    public static void Enter() {
        System.out.println("Press Enter to Continue!!!");
    }

    public static void main(String args[]) {
        Flush();
        Welcome();
    }
}

class Bookings {
    String uid, Ticketid, travel;
    int start, end, seatno;

    Bookings(String uid, int start, int end, String Ticketid, String travel, int seatno) {
        this.uid = uid;
        this.start = start;
        this.end = end;
        this.Ticketid = Ticketid;
        this.travel = travel;
        this.seatno = seatno;

    }

}

class Waiting {
    String uid;
    int start, end;

    Waiting(String uid, int start, int end) {
        this.uid = uid;
        this.start = start;
        this.end = end;

    }

}

class User {
    String name, password, id;

    User(String uname, String upass, String uid) {
        this.name = uname;
        this.password = upass;
        this.id = uid;
    }
}
