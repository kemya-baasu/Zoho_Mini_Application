import java.util.*;

public class Library {
    static Scanner sc = new Scanner(System.in);
    static String aname = "Tinku", apass = "Rinku";
    static ArrayList<Bookdetails> Bookdetaillist = new ArrayList<>();
    static ArrayList<Users> userlist = new ArrayList<>();
    static ArrayList<cart> cartlist = new ArrayList<>();
    static ArrayList<uborrow> borrowlist = new ArrayList<>();
    static int currentuser = -1;

    public static void Welcome() {
        Flush();
        System.out.println("\t\t---- Welcome to Library Management System! ----");
        System.out.println("1) Admin");
        System.out.println("2) User");
        System.out.println("3) Exit");
        int a = sc.nextInt();
        sc.nextLine();
        switch (a) {
            case 1 -> alogin();
            case 2 -> user();
            case 3 -> Exit();
            default -> {
                System.out.println("Enter Number Between 1 & 3");
                Enter();
                String j = sc.nextLine();
                if (j.equals(""))
                    Welcome();
            }
        }
    }

    public static void Exit() {
        Flush();
        System.out.println("----Thank You For Visiting Library Management System!----");
        Enter();
        String s = sc.nextLine();
        if (s.equals("")) {
        }
    }

    public static void alogin() {
        Flush();
        System.out.println("\t\t-------- Login to Continue --------");
        System.out.print("Enter Your Name : ");
        String name = sc.nextLine();
        System.out.print("Enter Your Password : ");
        String pass = sc.nextLine();
        if (aname.equals(name) && apass.equals(pass)) {
            admin();
        } else {
            System.out.println("Invalid User Name OR Password!");
            Enter();
            String k = sc.nextLine();
            if (k.equals(""))
                Welcome();
        }
    }

    public static void admin() {
        Flush();
        System.out.println("\t\t-------Welcome Admin -------");
        System.out.println("1) Add Book");
        System.out.println("2) Remove Book");
        System.out.println("3) View Books");
        System.out.println("4) Modify Book Details");
        System.out.println("5) Borrower Details");
        System.out.println("6) Exit");
        int a = sc.nextInt();
        sc.nextLine();
        switch (a) {
            case 1 -> addbook();
            case 2 -> removebook();
            case 3 -> viewbook();
            case 4 -> modifybook();
            case 5 -> borrowerdetail();
            case 6 -> Welcome();
            default -> {
                System.out.println("Enter Number Between 1 & 6");
                Enter();
                String j = sc.nextLine();
                if (j.equals(""))
                    admin();
            }
        }

    }

    public static void addbook() {
        Flush();
        System.out.println("\t\t------ Add Book -------");
        System.out.print("Enter Book Name : ");
        String name = sc.nextLine();
        System.out.print("Enter Book Type : ");
        String booktype = sc.nextLine();
        System.out.print("Enter Author Name : ");
        String authour = sc.nextLine();
        System.out.print("Enter Book count : ");
        int c = sc.nextInt();
        sc.nextLine();
        System.out.println("Book Id is : " + "BID" + Bookdetaillist.size());
        Bookdetaillist.add(new Bookdetails(name, booktype, authour, "BID" + Bookdetaillist.size(), c));
        System.out.println("Book Added Successfully!");
        System.out.println("\t\t---------------------------------");
        Enter();
        String k = sc.nextLine();
        if (k.equals(""))
            admin();

    }

    public static void removebook() {
        Flush();
        System.out.println("\t\t------ Remove Book -------");
        System.out.print("Enter Book ID To be Removed : ");
        String id = sc.nextLine();
        int count = 0;
        for (int i = 0; i < Bookdetaillist.size(); i++) {
            if (Bookdetaillist.get(i).bookid.equals(id)) {
                int a = i;
                Bookdetaillist.remove(a);
                count++;
            }
        }
        if (count == 0) {
            Flush();
            System.out.println("Invalid Book Id!");
            Enter();
            String k = sc.nextLine();
            if (k.equals(""))
                admin();
        }

    }

    public static void viewbook() {
        Flush();
        System.out.println("\t\t------ View Books -------\n");
        System.out.println("1) View Book Details By Id");
        System.out.println("2) View All");
        System.out.println("3) Exit");
        int a = sc.nextInt();
        sc.nextLine();
        switch (a) {
            case 1 -> viewbookid();
            case 2 -> viewall();
            case 3 -> admin();
            default -> {
                System.out.println("Enter Number Between 1 & 3");
                Enter();
                String j = sc.nextLine();
                if (j.equals(""))
                    viewbook();
            }
        }
    }

    public static void viewbookid() {
        Flush();
        System.out.println("\t\t---------- View By Id -----------");
        System.out.print("Enter Book Id to View Details : ");
        String id = sc.nextLine();
        int count = 0;
        for (int i = 0; i < Bookdetaillist.size(); i++) {
            if (Bookdetaillist.get(i).bookid.equals(id)) {
                System.out.println("Book Name : " + Bookdetaillist.get(i).name);
                System.out.println("Book Id : " + Bookdetaillist.get(i).bookid);
                System.out.println("Book Type : " + Bookdetaillist.get(i).booktype);
                System.out.println("Book Authour : " + Bookdetaillist.get(i).authour);
                System.out.println("Book Count : " + Bookdetaillist.get(i).count);
                System.out.println("--------------x------------x---------------");
                count++;
                Enter();
                String k = sc.nextLine();
                if (k.equals(""))
                    viewbook();
            }
        }
        if (count == 0) {
            Flush();
            System.out.println("Book Not Found!");
            Enter();
            String k = sc.nextLine();
            if (k.equals(""))
                viewbook();
        }

    }

    public static void viewall() {
        if (Bookdetaillist.size() <= 0) {
            Flush();
            System.out.println("------ No Books Available In the Library ------");
            Enter();
            String k = sc.nextLine();
            if (k.equals(""))
                admin();
        } else {
            Flush();
            System.out.println("\t\t---------- List Of All Books Available ---------");
            for (int i = 0; i < Bookdetaillist.size(); i++) {
                System.out.println("Book Name : " + Bookdetaillist.get(i).name);
                System.out.println("Book Id : " + Bookdetaillist.get(i).bookid);
                System.out.println("Book Type : " + Bookdetaillist.get(i).booktype);
                System.out.println("Book Authour : " + Bookdetaillist.get(i).authour);
                System.out.println("Book Count : " + Bookdetaillist.get(i).count);
                System.out.println("--------------x------------x---------------");
            }
            Enter();
            String k = sc.nextLine();
            if (k.equals(""))
                viewbook();
        }

    }

    public static void modifybook() {
        Flush();
        System.out.println("\t\t--------- Modify Book Details ----------");
        System.out.print("Enter Book Id to be Modified : ");
        String id = sc.nextLine();
        int count = 0;
        for (int i = 0; i < Bookdetaillist.size(); i++) {
            if (Bookdetaillist.get(i).bookid.equals(id)) {
                count++;
                modify(i);
            }

        }
        if (count == 0) {
            Flush();
            System.out.println("Book Not Found!");
            Enter();
            String k = sc.nextLine();
            if (k.equals(""))
                admin();
        }
    }

    public static void modify(int i) {
        Flush();
        System.out.println("\t\t--------- Modify Book Details ----------");
        System.out.println("1) Modify Book Name");
        System.out.println("2) Modify Book Type");
        System.out.println("3) Modify Author Name");
        System.out.println("4) Modify Book Count");
        System.out.println("5) Exit");
        int a = sc.nextInt();
        sc.nextLine();
        switch (a) {
            case 1 -> modifyname(i);
            case 2 -> modifytype(i);
            case 3 -> modifyauthor(i);
            case 4 -> modifycount(i);
            case 5 -> admin();
            default -> {
                System.out.println("Enter Number Between 1 & 5");
                Enter();
                String k = sc.nextLine();
                if (k.equals(""))
                    modify(i);

            }
        }
    }

    public static void modifyname(int i) {
        Flush();
        System.out.println("Current Book Name : " + Bookdetaillist.get(i).name);
        System.out.print("Enter New Book Name : ");
        String bname = sc.nextLine();
        Bookdetaillist.get(i).name = bname;
        System.out.println("Book Name Updated Successfully!");
        Enter();
        String k = sc.nextLine();
        if (k.equals(""))
            modify(i);

    }

    public static void modifytype(int i) {
        Flush();
        System.out.println("Current Book Type : " + Bookdetaillist.get(i).booktype);
        System.out.print("Enter New Book Type : ");
        String btype = sc.nextLine();
        Bookdetaillist.get(i).booktype = btype;
        System.out.println("Book Type Updated Successfully!");
        Enter();
        String k = sc.nextLine();
        if (k.equals(""))
            modify(i);
    }

    public static void modifyauthor(int i) {
        Flush();
        System.out.println("Current Author Name : " + Bookdetaillist.get(i).authour);
        System.out.print("Enter New Author Name : ");
        String bauthor = sc.nextLine();
        Bookdetaillist.get(i).authour = bauthor;
        System.out.println("Author Name Updated Successfully!");
        Enter();
        String k = sc.nextLine();
        if (k.equals(""))
            modify(i);
    }

    public static void modifycount(int i) {
        Flush();
        System.out.println("Current Book Count : " + Bookdetaillist.get(i).count);
        System.out.print("Enter New Book Count : ");
        int bcount = sc.nextInt();
        Bookdetaillist.get(i).count = bcount;
        System.out.println("Book Count Updated Successfully!");
        Enter();
        String k = sc.nextLine();
        if (k.equals(""))
            modify(i);
    }

    public static void borrowerdetail() {
        Flush();
        System.out.println("\t\t------- Borrow Details -------");
        System.out.println("1) Current Borrowers Details");
        System.out.println("2) Returned Borrowers");
        System.out.println("3) Exit");
        int a = sc.nextInt();
        sc.nextLine();
        switch (a) {
            case 1 -> cuborrower();
            case 2 -> retborrower();
            case 3 -> admin();
            default -> {
                System.out.println("Enter Number Between 1 & 3");
                Enter();
                String k = sc.nextLine();
                if (k.equals(""))
                    borrowerdetail();
            }
        }

    }

    public static void cuborrower() {
        Flush();
        System.out.println("\t\t-------- Current Borrowers ---------\n");
        int c = 0;
        for (int i = 0; i < borrowlist.size(); i++) {
            if (borrowlist.get(i).breturn.equals("Yes")) {
                c++;
                System.out.println("Borrower Id : " + borrowlist.get(i).uid);
                System.out.println("Borrowed Book Name : " + borrowlist.get(i).bname);
                System.out.println("Book Id : " + borrowlist.get(i).bid);
                System.out.println("Book Type : " + borrowlist.get(i).btype);
                System.out.println("Book Authour : " + borrowlist.get(i).author);
                System.out.println("Book Count : " + borrowlist.get(i).bcount);
                System.out.println("Return Status : " + borrowlist.get(i).breturn);
                System.out.println("-----------------------------------------");
            }

        }
        if (c == 0) {
            System.out.println("\t\t\tNo Current Borrowers!");
            Enter();
            String k = sc.nextLine();
            if (k.equals(""))
                borrowerdetail();
        } else {
            Enter();
            String k = sc.nextLine();
            if (k.equals(""))
                borrowerdetail();
        }
    }

    public static void retborrower() {
        Flush();
        System.out.println("\t\t-------- Returned Book Borrowers ---------\n");
        int c = 0;
        for (int i = 0; i < borrowlist.size(); i++) {
            if (borrowlist.get(i).breturn.equals("No")) {
                c++;
                System.out.println("Borrower Id : " + borrowlist.get(i).uid);
                System.out.println("Borrowed Book Name : " + borrowlist.get(i).bname);
                System.out.println("Book Id : " + borrowlist.get(i).bid);
                System.out.println("Book Type : " + borrowlist.get(i).btype);
                System.out.println("Book Authour : " + borrowlist.get(i).author);
                System.out.println("Book Count : " + borrowlist.get(i).bcount);
                System.out.println("Return Status : " + borrowlist.get(i).breturn);
                System.out.println("-----------------------------------------");
            }

        }
        if (c == 0) {
            System.out.println("\t\t\tNo Returned Book Borrowers!");
            Enter();
            String k = sc.nextLine();
            if (k.equals(""))
                borrowerdetail();
        } else {
            Enter();
            String k = sc.nextLine();
            if (k.equals(""))
                borrowerdetail();
        }
    }

    public static void user() {
        Flush();
        System.out.println("\t\t----- Welcome! ------");
        System.out.println("1) Login");
        System.out.println("2) Signup");
        System.out.println("3) Exit");
        int a = sc.nextInt();
        sc.nextLine();
        switch (a) {
            case 1 -> ulog();
            case 2 -> usign();
            case 3 -> Welcome();
            default -> {
                System.out.println("Enter Number Between 1 & 3");

            }
        }
    }

    public static void ulog() {
        currentuser = -1;
        Flush();
        System.out.println("\t\t---------- Login to Continue! -----------");
        System.out.print("Enter Your Name : ");
        String uname = sc.nextLine();
        System.out.print("Enter Password : ");
        String pass = sc.nextLine();
        int c = 0;
        for (int i = 0; i < userlist.size(); i++) {
            if (userlist.get(i).name.equals(uname) && userlist.get(i).password.equals(pass)) {
                c++;
                currentuser = i;
                userwork();
            }
        }
        if (c == 0) {
            System.out.println("User Not Found!\nSignup To Login!");
            Enter();
            String k = sc.nextLine();
            if (k.equals(""))
                user();

        }

    }

    public static void usign() {
        Flush();
        System.out.println("\t\t------ Sign In To Continue! -------");
        System.out.print("Enter Your Name : ");
        String uname = sc.nextLine();
        int c = 0;
        for (int i = 0; i < userlist.size(); i++) {
            if (userlist.get(i).name.equals(uname)) {
                System.out.println("Username Already Exists try another user name!");
                c++;
                Enter();
                String k = sc.nextLine();
                if (k.equals(""))
                    usign();
            }
        }
        if (c == 0) {
            System.out.print("Enter Password : ");
            String upass = sc.nextLine();
            System.out.print("Re-Enter Password : ");
            String pass2 = sc.nextLine();
            if (upass.equals(pass2)) {
                String uid = "UID" + userlist.size();
                System.out.println("Your User Id is : " + uid);
                userlist.add(new Users(uname, upass, uid));
                System.out.println("Account Created Successfully !");
                Enter();
                String k = sc.nextLine();
                if (k.equals(""))
                    user();
            } else {
                System.out.println("Re-Enter Password Correctly!");
                Enter();
                String k = sc.nextLine();
                if (k.equals(""))
                    usign();
            }
        }

    }

    public static void userwork() {
        Flush();
        System.out.println("\t\t------- User Work --------");
        System.out.println("1) View Available Books");
        System.out.println("2) Borrow Book");
        System.out.println("3) Return Book");
        System.out.println("4) Borrow History");
        System.out.println("5) Cart");
        System.out.println("6) Exit");
        int a = sc.nextInt();
        sc.nextLine();
        switch (a) {
            case 1 -> uviewbook();
            case 2 -> borrobook();
            case 3 -> returnbook();
            case 4 -> borrowhistory();
            case 5 -> cart();
            case 6 -> Welcome();
            default -> {
                System.out.println("Enter Number Between 1 & 6");
                Enter();
                String k = sc.nextLine();
                if (k.equals(""))
                    userwork();
            }
        }

    }

    public static void uviewbook() {
        Flush();
        if (Bookdetaillist.size() <= 0) {
            System.out.println("------ No Books Available In the Library ------");
            Enter();
            String k = sc.nextLine();
            if (k.equals(""))
                admin();
        } else {
            System.out.println("\t\t---------- List Of All Books Available ---------");
            for (int i = 0; i < Bookdetaillist.size(); i++) {
                System.out.println("Book Name : " + Bookdetaillist.get(i).name);
                System.out.println("Book Id : " + Bookdetaillist.get(i).bookid);
                System.out.println("Book Type : " + Bookdetaillist.get(i).booktype);
                System.out.println("Book Authour : " + Bookdetaillist.get(i).authour);
                System.out.println("Book Count : " + Bookdetaillist.get(i).count);
                System.out.println("-----------------------------------------");

            }
            Enter();
            String k = sc.nextLine();
            if (k.equals(""))
                userwork();
        }
    }

    public static void borrobook() {
        Flush();
        System.out.println("\t\t------ Borrow Book -------");
        System.out.print("Enter Book Id to Be Borrowed : ");
        String booid = sc.nextLine();
        int c = 0;
        for (int i = 0; i < Bookdetaillist.size(); i++) {
            if (Bookdetaillist.get(i).bookid.equals(booid)) {
                c++;
                System.out.print("Enter Number Of Books Needed : ");
                int num = sc.nextInt();
                sc.nextLine();
                if (Bookdetaillist.get(i).count >= num) {
                    Bookdetaillist.get(i).count -= num;
                    borrowlist.add(new uborrow(userlist.get(currentuser).userid, Bookdetaillist.get(i).name,
                            Bookdetaillist.get(i).bookid, Bookdetaillist.get(i).booktype, num, 0,
                            Bookdetaillist.get(i).authour, "Yes"));
                    System.out.println("Book Borrowed Successfully!");
                    Enter();
                    String k = sc.nextLine();
                    if (k.equals(""))
                        userwork();

                } else {
                    System.out.println("Stock Available In Library is less than the Number Of Books You Needed");
                    Enter();
                    String k = sc.nextLine();
                    if (k.equals(""))
                        userwork();
                }

            }
        }
        if (c == 0) {
            System.out.println("Enter Correct Book Id");
            Enter();
            String m = sc.nextLine();
            if (m.equals(""))
                userwork();
        }

    }

    public static void returnbook() {
        Flush();
        System.out.println("\t\t------ Return Book -------");
        System.out.print("Enter Book Id to Be Returned : ");
        String booid = sc.nextLine();
        int c = 0;
        for (int i = 0; i < borrowlist.size(); i++) {
            if (borrowlist.get(i).bid.equals(booid) && borrowlist.get(i).uid.equals(userlist.get(currentuser).userid)) {
                c++;
                System.out.print("Enter Number Of Books to be Returned : ");
                int num = sc.nextInt();
                sc.nextLine();
                Bookdetaillist.get(i).count += num;
                borrowlist.get(i).returncount += num;
                if (borrowlist.get(i).bcount == borrowlist.get(i).returncount) {
                    borrowlist.get(i).breturn = "No";
                }
                System.out.println("Book Returned Successfully!");
                Enter();
                String k = sc.nextLine();
                if (k.equals(""))
                    userwork();

            }
        }
        if (c == 0)

        {
            System.out.println("Enter Correct Book Id");
            Enter();
            String m = sc.nextLine();
            if (m.equals(""))
                userwork();
        }
    }

    public static void borrowhistory() {
        Flush();
        System.out.println("\t\t--------- Borrow History ----------");
        System.out.println("1) Books Borrowed");
        System.out.println("2) Books Returned");
        System.out.println("3) Exit");
        int a = sc.nextInt();
        sc.nextLine();
        switch (a) {
            case 1 -> bhist();
            case 2 -> rhist();
            case 3 -> userwork();
            default -> {
                System.out.println("Enter Number Between 1 & 3");
                Enter();
                String j = sc.nextLine();
                if (j.equals(""))
                    borrowhistory();

            }
        }
    }

    public static void bhist() {
        Flush();
        System.out.println("\t\t-------- Borrow History ----------");
        int c = 0;
        for (int i = 0; i < borrowlist.size(); i++) {
            if (borrowlist.get(i).uid.equals(userlist.get(currentuser).userid)
                    && borrowlist.get(i).breturn.equals("Yes")) {
                c++;
                System.out.println("Book Name : " + borrowlist.get(i).bname);
                System.out.println("Book Id : " + borrowlist.get(i).bid);
                System.out.println("Book Type : " + borrowlist.get(i).btype);
                System.out.println("Book Authour : " + borrowlist.get(i).author);
                System.out.println("Book Count : " + borrowlist.get(i).bcount);
                System.out.println("Borrow Status : " + borrowlist.get(i).breturn);
                System.out.println("-----------------------------------------");
            }
        }
        if (c == 0) {
            System.out.println("No Current Borrow History!");
            Enter();
            String j = sc.nextLine();
            if (j.equals(""))
                borrowhistory();
        } else {
            Enter();
            String j = sc.nextLine();
            if (j.equals(""))
                borrowhistory();
        }

    }

    public static void rhist() {
        Flush();
        System.out.println("\t\t-------- Return History ----------");
        int c = 0;
        for (int i = 0; i < borrowlist.size(); i++) {
            if (borrowlist.get(i).uid.equals(userlist.get(currentuser).userid)
                    && borrowlist.get(i).breturn.equals("No")) {
                c++;
                System.out.println("Book Name : " + borrowlist.get(i).bname);
                System.out.println("Book Id : " + borrowlist.get(i).bid);
                System.out.println("Book Type : " + borrowlist.get(i).btype);
                System.out.println("Book Authour : " + borrowlist.get(i).author);
                System.out.println("Book Count : " + borrowlist.get(i).bcount);
                System.out.println("Borrow Status : " + borrowlist.get(i).breturn);
                System.out.println("-----------------------------------------");
            }
        }
        if (c == 0) {
            System.out.println("No Current Return History!");
            Enter();
            String j = sc.nextLine();
            if (j.equals(""))
                borrowhistory();
        } else {
            Enter();
            String j = sc.nextLine();
            if (j.equals(""))
                borrowhistory();
        }
    }

    public static void cart() {
        Flush();
        System.out.println("\t\t--------- Cart -----------");
        System.out.println("1) Add Books To Cart");
        System.out.println("2) Remove Book From Cart");
        System.out.println("3) View Cart");
        System.out.println("4) Exit");
        int a = sc.nextInt();
        sc.nextLine();
        switch (a) {
            case 1 -> addcart();
            case 2 -> removecart();
            case 3 -> viewcart();
            case 4 -> userwork();
            default -> {
                System.out.println("Enter Number Between 1 & 3");
                Enter();
                String j = sc.nextLine();
                if (j.equals(""))
                    cart();
            }
        }

    }

    public static void addcart() {
        Flush();
        System.out.println("\t\t-------- Add Books To Cart ----------");
        System.out.print("Enter Book Id To Be Added to Cart : ");
        String booid = sc.nextLine();
        int in = 0;
        for (int i = 0; i < Bookdetaillist.size(); i++) {
            if (Bookdetaillist.get(i).bookid.equals(booid)) {
                in++;
                cartlist.add(new cart(userlist.get(currentuser).userid, booid, Bookdetaillist.get(i).name,
                        Bookdetaillist.get(i).booktype, Bookdetaillist.get(i).authour));
                System.out.println("Book Added To Cart Successfully!");
                Enter();
                String j = sc.nextLine();
                if (j.equals(""))
                    cart();
            }
        }
        if (in == 0) {
            System.out.println("Book Id Not Found!");
            Enter();
            String j = sc.nextLine();
            if (j.equals(""))
                cart();
        }
    }

    public static void removecart() {
        Flush();
        System.out.println("\t\t-------- Remove Books From Cart ----------");
        System.out.print("Enter Book Id To Be Removed From Cart : ");
        String booid = sc.nextLine();
        int in = 0;
        for (int i = 0; i < cartlist.size(); i++) {
            if (cartlist.get(i).bookid.equals(booid) && cartlist.get(i).uid.equals(userlist.get(currentuser).userid)) {
                in++;
                cartlist.remove(i);
                System.out.println("Book Removed From Cart Successfully!");
                Enter();
                String j = sc.nextLine();
                if (j.equals(""))
                    cart();
            }
        }
        if (in == 0) {
            System.out.println("Book Id Not Found!");
            Enter();
            String j = sc.nextLine();
            if (j.equals(""))
                cart();
        }
    }

    public static void viewcart() {
        Flush();
        System.out.println("\t\t--------- Your Cart -----------\n");
        int c = 0;
        for (int i = 0; i < cartlist.size(); i++) {
            if (cartlist.get(i).uid.equals(userlist.get(currentuser).userid)) {
                c++;
                System.out.println("Book Name : " + cartlist.get(i).bname);
                System.out.println("Book Id : " + cartlist.get(i).bookid);
                System.out.println("Book Type : " + cartlist.get(i).btype);
                System.out.println("Book Authour : " + cartlist.get(i).bauthour);
                System.out.println("-----------------------------------------");
            }
        }
        if (c == 0) {
            System.out.println("\t\t\t Empty!!!\n");
            Enter();
            String k = sc.nextLine();
            if (k.equals(""))
                cart();
        } else {
            Enter();
            String k = sc.nextLine();
            if (k.equals(""))
                cart();
        }
    }

    public static void main(String args[]) {
        Welcome();
    }

    public static void Enter() {
        System.out.println("Press Enter To Continue!");
    }

    public static void Flush() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

}

class Users {
    String name, password, userid;

    Users(String name, String password, String userid) {
        this.name = name;
        this.password = password;
        this.userid = userid;
    }
}

class Bookdetails {
    String name, authour, bookid, booktype;
    int count;

    Bookdetails(String name, String booktype, String authour, String bookid, int count) {
        this.name = name;
        this.booktype = booktype;
        this.authour = authour;
        this.bookid = bookid;
        this.count = count;
    }
}

class uborrow {
    String bname, author, bid, breturn, uid, btype;
    int bcount, returncount;

    uborrow(String uid, String bname, String bid, String btype, int bcount, int returncount, String author,
            String breturn) {
        this.bname = bname;
        this.author = author;
        this.bid = bid;
        this.btype = btype;
        this.breturn = breturn;
        this.uid = uid;
        this.bcount = bcount;
        this.returncount = returncount;

    }
}

class cart {
    String uid, bookid, bname, btype, bauthour;

    cart(String uid, String bookid, String bname, String btype, String bauthour) {
        this.uid = uid;
        this.bname = bname;
        this.bookid = bookid;
        this.btype = btype;
        this.bauthour = bauthour;
    }
}
