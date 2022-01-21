import java.util.*;

public class amazon {
    static Scanner sc = new Scanner(System.in);
    static String adn = "Tinku";
    static String adp = "Rinku";
    static int pen = 1, id = 1, UBal = 5000;
    static List<String> uc = new ArrayList<>();
    static List<String> uo = new ArrayList<>();
    static List<String> ucn = new ArrayList<>();
    // -------------------------------------------------
    static List<String> mid = new ArrayList<>();
    static List<String> pid = new ArrayList<>();
    static List<String> pt = new ArrayList<>();
    static List<Integer> pp = new ArrayList<>();
    static List<Integer> pc = new ArrayList<>();
    static List<String> pn = new ArrayList<>();
    // ------------------------------------------------
    static List<String> un = new ArrayList<>();
    static List<String> up = new ArrayList<>();
    static List<String> mn = new ArrayList<>();
    static List<String> mp = new ArrayList<>();
    // --------------------------------------------------
    static List<String> tmn = new ArrayList<>();
    static List<String> tmid = new ArrayList<>();
    static List<String> tpn = new ArrayList<>();
    static List<String> tpid = new ArrayList<>();
    static List<String> tpt = new ArrayList<>();
    static List<Integer> tpc = new ArrayList<>();
    static List<Integer> tpp = new ArrayList<>();
    static List<String> tmp = new ArrayList<>();

    public static void Welcome() {
        flush();
        System.out.println("\t\t------------Welcome to amazon.in------------");
        System.out.println("1) Admin");
        System.out.println("2) User");
        System.out.println("3) Merchant");
        System.out.println("4) Exit");
        int a = sc.nextInt();
        sc.nextLine();
        switch (a) {
            case 1:
                Admin();
                break;
            case 2:
                User();
                break;
            case 3:
                Merchant();
                break;
            case 4:
                Exit();
                break;
            default:
                System.out.println("Enter Valid Number!!!");
                System.out.println("Press Enter to Continue");
                String k = sc.nextLine();
                if (k.equals(""))
                    Welcome();
                break;
        }
    }

    public static void Admin() {
        flush();
        System.out.println("\t\t.........Welcome Admin..........\n\nxxxxxxxx Login to Continue xxxxxxxx\n");
        System.out.print("Enter Admin Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Admin Id: ");
        String id = sc.nextLine();
        if (name.equals(adn) && id.equals(adp)) {
            adminwork();
        } else {
            flush();
            System.out.println("Invalid Name OR Password");
            System.out.println("Enter Valid Name & Password!!!");
            System.out.println("Press Enter to Continue");
            String k = sc.nextLine();
            if (k.equals(""))
                Admin();
        }

    }

    public static void adminwork() {
        flush();
        System.out.println("1) Approve Merchant");
        System.out.println("2) Add Merchant");
        System.out.println("3) Remove Merchant");
        System.out.println("4) View Merchant");
        System.out.println("5) View Stocks");
        System.out.println("6) Exit");
        int a = sc.nextInt();
        sc.nextLine();
        switch (a) {
            case 1:
                appmerchant();
                break;
            case 2:
                addmerchant();
                break;
            case 3:
                removemerchant();
                break;
            case 4:
                viewmerchant();
                break;
            case 5:
                viewstocks();
                break;
            case 6:
                Welcome();
                break;
            default:
                System.out.println("Enter Valid Number!!!");
                System.out.println("Press Enter to Continue");
                String k = sc.nextLine();
                if (k.equals(""))
                    adminwork();
                break;
        }
    }

    public static void appmerchant() {
        flush();
        if (tmn.size() <= 0) {
            System.out.println("\t\t----------- NO PENDING REQUESTS FOUND------------");
            Enter();
            String k = sc.nextLine();
            if (k.equals(""))
                adminwork();
        } else {
            System.out.println("\t\t--------------SHOWING LIST OF PENDING REQUESTS---------------\n");
            for (int i = tmn.size() - 1; i >= 0; i--) {
                int nos = tmn.size();
                System.out.println("Total Number of Pending Requests----------> " + nos);
                System.out.println(pen + ")");
                pen++;
                System.out.println("Merchant Name : " + tmn.get(i));
                System.out.println("Merchant Id : " + tmid.get(i));
                System.out.println("Product Type : " + tpt.get(i));
                System.out.println("Product Name : " + tpn.get(i));
                System.out.println("Product Id : " + tpid.get(i));
                System.out.println("Product Count : " + tpc.get(i));
                System.out.println("Product Price : " + tpp.get(i));
                System.out.println("--------------*----------------*---------------");
                System.out.println("*Type Yes To Approve Merchant Or No To delete Merchant Request*");
                String s = sc.nextLine();
                if (s.equals("Yes")) {
                    mn.add(tmn.get(i));
                    mp.add(tmp.get(i));
                    mid.add(tmid.get(i));
                    pn.add(tpn.get(i));
                    pid.add(tpid.get(i));
                    pt.add(tpt.get(i));
                    pc.add(tpc.get(i));
                    pp.add(tpp.get(i));
                    tmn.remove(i);
                    tmp.remove(i);
                    tmid.remove(i);
                    tpn.remove(i);
                    tpid.remove(i);
                    tpt.remove(i);
                    tpc.remove(i);
                    tpp.remove(i);
                    System.out.println("Merchant Added Successfully!!!! ");
                    Enter();
                    String k = sc.nextLine();
                    if (k.equals(""))
                        appmerchant();
                } else if (s.equals("No")) {
                    tmn.remove(i);
                    tmp.remove(i);
                    tmid.remove(i);
                    tpn.remove(i);
                    tpid.remove(i);
                    tpt.remove(i);
                    tpc.remove(i);
                    tpp.remove(i);
                    System.out.println("Merchant Request Removed Successfully!!!");
                    Enter();
                    String k = sc.nextLine();
                    if (k.equals(""))
                        appmerchant();
                } else {
                    System.out.println("Enter Valid Input Either Yes Or No!!!!!!");
                    Enter();
                    String k = sc.nextLine();
                    if (k.equals(""))
                        appmerchant();
                }
            }
        }
    }

    public static void addmerchant() {
        flush();
        System.out.println("\t\t------------ADD MERCHANT DETAILS-------------\n");
        System.out.println("Enter accurate Details!");
        System.out.print("Merchant Name : ");
        String a = sc.nextLine();
        mn.add(a);
        System.out.print("Merchant Password : ");
        String p = sc.nextLine();
        mp.add(p);
        System.out.print("Product Type : ");
        String e = sc.nextLine();
        pt.add(e);
        System.out.print("Product Name : ");
        String c = sc.nextLine();
        pn.add(c);
        System.out.print("Product Count : ");
        int f = sc.nextInt();
        pc.add(f);
        System.out.print("Product Price : ");
        int g = sc.nextInt();
        pp.add(g);
        sc.nextLine();
        System.out.println("\t\tMerchant Added Successfully!!!!!!!!");
        System.out.println("\t\t------------------------------------\n");
        System.out.println("Merchant's Id and His Product's Id is : " + id);
        mid.add(Integer.toString(id));
        pid.add(Integer.toString(id));
        id++;
        System.out.println("\t\t----------x------------x------------\n");
        System.out.println("Press Enter To Continue");
        String k = sc.nextLine();
        if (k.equals(""))
            adminwork();
    }

    public static void removemerchant() {
        flush();
        System.out.println("\t\t-------------- Remove Merchant ---------------");
        System.out.print("Enter Merchant Name To be Removed : ");
        String s = sc.nextLine();
        int a = mn.indexOf(s);
        System.out.println("\t\t-------------Merchant Details--------------");
        System.out.println("Merchant Name : " + mn.get(a));
        System.out.println("Merchant Id : " + mid.get(a));
        System.out.println("Product Type : " + pt.get(a));
        System.out.println("Product Name : " + pn.get(a));
        System.out.println("Product Id : " + pid.get(a));
        System.out.println("Product Count : " + pc.get(a));
        System.out.println("Product Price : " + pp.get(a));
        System.out.println("\t\t--------------------*---------*---------------------");
        System.out.println("Are You Sure to remove Merchant???");
        System.out.println("Enter Yes If You Want to delete Merchant Permanently ( Or ) Enter No to Quit The Process");
        String k = sc.nextLine();
        if (k.equals("Yes")) {
            mn.remove(a);
            mp.remove(a);
            mid.remove(a);
            pn.remove(a);
            pid.remove(a);
            pt.remove(a);
            pc.remove(a);
            pp.remove(a);
            System.out.println("Merchant Removed Successfully!!!");
            Enter();
            String p = sc.nextLine();
            if (p.equals(""))
                adminwork();
        } else if (k.equals("No")) {
            System.out.println("Click Enter to Exit!!!");
            String m = sc.nextLine();
            if (m.equals(""))
                adminwork();
        }
    }

    public static void viewmerchant() {
        flush();
        int a = 1;
        int nos = mn.size();
        if (nos <= 0) {
            System.out.println("------------No Merchants Found----------");
            Enter();
            String k = sc.nextLine();
            if (k.equals(""))
                adminwork();
        } else {
            System.out.println("Total Number of Merchants----------> " + nos);
            for (int i = mn.size() - 1; i >= 0; i--) {
                System.out.println(a + ")");
                a++;
                System.out.println("Merchant Name : " + mn.get(i));
                System.out.println("Merchant Id : " + mid.get(i));
                System.out.println("--------------*----------------*---------------");
            }
            Enter();
            String k = sc.nextLine();
            if (k.equals(""))
                adminwork();
        }
    }

    public static void viewstocks() {
        flush();
        int a = 1;
        int nos = pn.size();
        System.out.println("Total Number of Products----------> " + nos + "\n");
        if (nos <= 0) {
            System.out.println("------------ Products Not Found ----------");
            Enter();
            String k = sc.nextLine();
            if (k.equals(""))
                adminwork();
        }
        System.out.println("\t\t---------Stocks Available-----------");
        for (int i = pn.size() - 1; i >= 0; i--) {
            System.out.println(a + ") Product Type : " + pt.get(i));
            System.out.println("   Product Id : " + pid.get(i));
            System.out.println("   Product Name : " + pn.get(i));
            System.out.println("   Product Count : " + pc.get(i));
            System.out.println("--------------*----------------*---------------");
            a++;
        }
        Enter();
        String k = sc.nextLine();
        if (k.equals(""))
            adminwork();
    }

    public static void User() {
        flush();
        System.out.println("\t\t------------- Welcome User -------------\n");
        System.out.println("1) Login");
        System.out.println("2) Signup");
        System.out.println("3) Exit");
        int a = sc.nextInt();
        sc.nextLine();
        switch (a) {
            case 1:
                ulogin();
                break;
            case 2:
                usign();
                break;
            case 3:
                Welcome();
                break;
            default:
                System.out.println("Enter Valid Number!!");
                System.out.println("Press Enter to Continue");
                String k = sc.nextLine();
                if (k.equals(""))
                    User();
        }

    }

    public static void ulogin() {
        flush();
        System.out.println("\t\t------------ Login to Continue ------------\n");
        System.out.print("Enter Your User Name : ");
        String name = sc.nextLine();
        System.out.print("Enter Password : ");
        String pass = sc.nextLine();
        if (un.contains(name) && up.contains(pass)) {
            uwork();
        } else {
            System.out.println("Invalid User Name Or Password (Or) Account Not Found\nEnter Valid Details Or Signup");
            System.out.println("Press Enter to Continue");
            String k = sc.nextLine();
            if (k.equals(""))
                User();
        }

    }

    public static void usign() {
        flush();
        System.out.println("\t\t-------- SIGN UP TO CONTINUE -------------\n");
        System.out.print("Enter Your Name : ");
        String n1 = sc.nextLine();
        System.out.print("Enter Your Password : ");
        String p1 = sc.nextLine();
        System.out.print("Re-Enter Your Password : ");
        String p2 = sc.nextLine();
        if (p1.equals(p2)) {
            un.add(n1);
            up.add(p1);
            System.out.println("You have successfully Signed up!!!!!!!");
            Enter();
            String k = sc.nextLine();
            if (k.equals(""))
                User();

        } else {
            System.out.println("Re-Enter Your Password Correctly!!!!!");
            Enter();
            String k = sc.nextLine();
            if (k.equals(""))
                User();
        }
    }

    public static void uwork() {
        flush();
        System.out.println("\t\t---------Welcome to amazon shopping----------\n");
        System.out.println("\t<<<<<<<<<<<<<<<<<  Best Sellers And Products Are Listed Below  >>>>>>>>>>>>>>");
        for (int i = 0; i < mn.size(); i++) {
            System.out.println(i + 1 + ")");
            System.out.println("Merchant Name : " + mn.get(i));
            System.out.println("Product Type : " + pt.get(i));
            System.out.println("Product Name : " + pn.get(i));
            System.out.println("Product Id : " + pid.get(i));
            System.out.println("Product Price : " + pp.get(i));
            System.out.println("Stock Available : " + pc.get(i));
            System.out.println("--------------------------------------------------------");
        }
        System.out.println("1) Buy Product");
        System.out.println("2) Cart");
        System.out.println("3) Purchase History");
        System.out.println("4) Wallet Balance");
        System.out.println("5) Exit");
        int a = sc.nextInt();
        sc.nextLine();
        switch (a) {
            case 1:
                byprod();
            case 2:
                cart();
            case 3:
                History();
            case 4:
                walletbal();
            case 5:
                Welcome();
            default:
                System.out.println("Enter Valid Number!!");
                System.out.println("Press Enter to Continue");
                String y = sc.nextLine();
                if (y.equals(""))
                    Welcome();
        }
    }

    public static void byprod() {
        flush();
        System.out.println("\t\t-------Enter Details to Proceed Buying Products--------\n");
        System.out.print("Enter Product Id: ");
        String o = sc.nextLine();
        if (pid.contains(o)) {
            int a = pid.indexOf(o);
            int c = pc.get(a);
            System.out.print("Enter Quantity Required : ");
            int q = sc.nextInt();
            sc.nextLine();
            if (c >= q) {
                flush();
                System.out.println("\t\t----------Select a Payment Method----------\n");
                System.out.println("1) Amazon Pay Balance");
                System.out.println("2) Pay On Delivery");
                System.out.println("3) Quit Ordering");
                int pay = sc.nextInt();
                sc.nextLine();
                switch (pay) {
                    case 1:
                        paywall(a, c, q);
                    case 2:
                        pod(a, c, q);
                    case 3:
                        flush();
                        System.out.println("Ordering Stopped Successfully!!!!");
                        Enter();
                        String l = sc.nextLine();
                        if (l.equals(""))
                            uwork();
                    default:
                        System.out.println("Enter Valid Number!!");
                        System.out.println("Press Enter to Continue");
                        String y = sc.nextLine();
                        if (y.equals(""))
                            uwork();
                }
            } else {
                System.out.println("Stock Currently Unavailable!!!!\nTry again Later!!!!");
                Enter();
                String y = sc.nextLine();
                if (y.equals(""))
                    uwork();
            }
        } else {
            System.out.println("Invalid Product Id!!!");
            Enter();
            String y = sc.nextLine();
            if (y.equals(""))
                uwork();
        }
    }

    public static void paywall(int a, int c, int q) {
        flush();
        System.out.println("You Have Opted to proceed Paying through Amazon Pay");
        if ((pp.get(a) * q) <= UBal) {
            UBal -= (pp.get(a) * q);
            pc.set(a, (c - q));
            uo.add(pn.get(a));
            System.out.println("\t\t--------- Amount Debited From Your Wallet!!! ----------");
            System.out.println(" Your Wallet Balance is ----------> " + UBal + "\n");
            System.out.println("Product Ordered Successfully!!!");
            Enter();
            String h = sc.nextLine();
            if (h.equals(""))
                uwork();
        } else {
            System.out.println("Insufficient Amazon Pay Balance!!!!\nTry another Way of payment for Ordering!");
            Enter();
            String h = sc.nextLine();
            if (h.equals(""))
                byprod();
        }
    }

    public static void pod(int a, int c, int q) {
        flush();
        System.out.println("\t\t--------- You Have Opted for POD! ----------\n");
        int b = pp.get(a) * q;
        pc.set(a, (c - q));
        uo.add(pn.get(a));
        System.out.println("Amount You Have To Pay On Delivery is : " + b);
        Enter();
        String k = sc.nextLine();
        if (k.equals(""))
            uwork();
    }

    public static void cart() {
        flush();
        System.out.println("\t\t-------- CART -------------\n");
        System.out.println("1) Add Product to Cart");
        System.out.println("2) Remove Product From Cart");
        System.out.println("3) View Cart");
        System.out.println("4) Exit");
        int a = sc.nextInt();
        sc.nextLine();
        switch (a) {
            case 1:
                adcart();
            case 2:
                removecart();
            case 3:
                viewcart();
            case 4:
                uwork();
            default:
                flush();
                System.out.println("Enter Valid Number!!!!!!");
                Enter();
                String k = sc.nextLine();
                if (k.equals(""))
                    cart();
        }
    }

    public static void adcart() {
        flush();
        System.out.println("\t\t------------ Add Products To Your Cart ------------\n");
        System.out.print("Enter Product Name to Be Added : ");
        String n = sc.nextLine();
        System.out.print("Enter Product Id to Be Added : ");
        String k = sc.nextLine();
        if (pid.contains(k) && pn.contains(n)) {
            ucn.add(n);
            uc.add(k);
            System.out.println("Product Added Successfully!!!");
            Enter();
            String s = sc.nextLine();
            if (s.equals(""))
                cart();
        } else {
            System.out.println("Product Name (Or) Product Id Not Found!!!");
            Enter();
            String s = sc.nextLine();
            if (s.equals(""))
                cart();
        }
    }

    public static void removecart() {
        flush();
        System.out.println("\t\t------------ Remove Products From Your Cart ------------\n");
        System.out.print("Enter Product Id to Be Removed : ");
        String k = sc.nextLine();
        int a = uc.indexOf(k);
        if (uc.contains(k)) {
            ucn.remove(a);
            uc.remove(a);
            System.out.println("Product Removed Successfully!!!");
            Enter();
            String s = sc.nextLine();
            if (s.equals(""))
                cart();
        } else {
            System.out.println("Product Id Not Found!!!");
            Enter();
            String s = sc.nextLine();
            if (s.equals(""))
                cart();
        }
    }

    public static void viewcart() {
        flush();
        int nos = uc.size();
        if (nos <= 0) {
            System.out.println("\t\t------------ No Products Found In Your Cart ------------\n");
            Enter();
            String k = sc.nextLine();
            if (k.equals(""))
                cart();
        } else {
            System.out.println("\t\t------------ Your Cart ------------\n");
            int a = 1;
            for (int i = uc.size() - 1; i >= 0; i--) {
                System.out.println(a + ") Product Name : " + ucn.get(i));
                System.out.println("   Product Id : " + uc.get(i));
                System.out.println("---------------x------------------x----------------");
                a++;
            }
            Enter();
            String k = sc.nextLine();
            if (k.equals(""))
                cart();
        }
    }

    public static void walletbal() {
        flush();
        System.out.println("\t\t--------- Wallet -----------\n");
        System.out.println("1) Check Amazon Pay Balance");
        System.out.println("2) Add Money to Wallet");
        System.out.println("3) Exit");
        int b = sc.nextInt();
        sc.nextLine();
        switch (b) {
            case 1:
                flush();
                System.out.println("-------*Your Amazon Pay Balance is : " + UBal + " *--------");
                Enter();
                String k = sc.nextLine();
                if (k.equals(""))
                    walletbal();
            case 2:
                flush();
                System.out.println("\t\t----------Add Money To Wallet-----------\n");
                System.out.print("Enter Amount to Be Added : ");
                int s = sc.nextInt();
                sc.nextLine();
                UBal += s;
                System.out.println("\t\t---- Money added to Wallet Successfully!!!----\n");
                Enter();
                String m = sc.nextLine();
                if (m.equals(""))
                    walletbal();
            case 3:
                uwork();
            default:
                flush();
                System.out.println("Enter Valid Number!!");
                System.out.println("Press Enter to Continue");
                String y = sc.nextLine();
                if (y.equals(""))
                    walletbal();
        }
    }

    public static void History() {
        flush();
        int nos = uo.size();
        if (nos > 0) {
            System.out.println("\t\t----------Your Order History-----------");
            for (int i = uo.size() - 1; i >= 0; i--) {
                System.out.println("*)" + uo.get(i));
            }
            System.out.println("\t-----------------x---------------x-----------------");
            Enter();
            String m = sc.nextLine();
            if (m.equals(""))
                uwork();
        } else {
            System.out.println("\t\t------------You Have Not Purchased Anything Yet------------\n");
            Enter();
            String m = sc.nextLine();
            if (m.equals(""))
                uwork();
        }
    }

    public static void Merchant() {
        flush();
        System.out.println("\t\t----------Welcome Merchant-----------\n");
        System.out.println("1) Login");
        System.out.println("2) Signup");
        System.out.println("3) Exit");
        int a = sc.nextInt();
        sc.nextLine();
        switch (a) {
            case 1:
                mlogin();
                break;
            case 2:
                msign();
                break;
            case 3:
                Welcome();
                break;
            default:
                System.out.println("Enter Valid Number!!");
                System.out.println("Press Enter to Continue");
                String k = sc.nextLine();
                if (k.equals(""))
                    Merchant();
        }

    }

    public static void mlogin() {
        flush();
        System.out.println("\t\t------------Login to Continue--------------\n");
        System.out.print("Enter Merchant Name : ");
        String name = sc.nextLine();
        System.out.print("Enter Password : ");
        String pass = sc.nextLine();
        if (mn.contains(name) && mp.contains(pass)) {
            mwork();
        } else {
            System.out
                    .println("Invalid Merchant Name Or Password (Or) Account Not Found\nEnter Valid Details Or Signup");
            System.out.println("Press Enter to Continue!!!");
            String k = sc.nextLine();
            if (k.equals(""))
                Merchant();
        }
    }

    public static void msign() {
        flush();
        System.out.println("\t\t--------SIGN UP TO CONTINUE-------------\n");
        System.out.println("Enter accurate Details");
        System.out.print("Merchant Name : ");
        String a = sc.nextLine();
        tmn.add(a);
        System.out.print("Merchant Password : ");
        String p = sc.nextLine();
        tmp.add(p);
        System.out.print("Product Type : ");
        String e = sc.nextLine();
        tpt.add(e);
        System.out.print("Product Name : ");
        String c = sc.nextLine();
        tpn.add(c);
        System.out.print("Product Count : ");
        int f = sc.nextInt();
        tpc.add(f);
        System.out.print("Product Price : ");
        int g = sc.nextInt();
        tpp.add(g);
        sc.nextLine();
        System.out.println("Details Uploaded Successfully!!!!!!!!");
        System.out
                .println("If Ur Signup request Have Been Approved then Ur Merchant Id and Product Id will Be : " + id);
        tmid.add(Integer.toString(id));
        tpid.add(Integer.toString(id));
        id++;
        System.out.println("----------x---------------x----------");
        System.out.println(
                "Your Request is in Pending State You Could Access Your Account After Admin Accepts Your Request");
        System.out.println("Press Enter To Continue");
        String k = sc.nextLine();
        if (k.equals(""))
            Merchant();

    }

    public static void mwork() {
        flush();
        System.out.println("\t\t------Hello Merchant------\n");
        System.out.println("1) Add Products");
        System.out.println("2) Change Passcode");
        System.out.println("3) View Stocks");
        System.out.println("4) Remove Products");
        System.out.println("5) Exit");
        int a = sc.nextInt();
        sc.nextLine();
        switch (a) {
            case 1:
                adproducts();
                break;
            case 2:
                cngpass();
                break;
            case 3:
                mviewstoc();
                break;
            case 4:
                mremovep();
                break;
            case 5:
                Welcome();
                break;
            default:
                System.out.println("Enter Valid Number!!!!");
                Enter();
                String k = sc.nextLine();
                if (k.equals(""))
                    mwork();
                break;
        }
    }

    public static void adproducts() {
        flush();
        System.out.println("\t\t---------Add Products for Sale----------");
        System.out.print("Merchant Name : ");
        String a = sc.nextLine();
        mn.add(a);
        System.out.print("Merchant Password : ");
        String b = sc.nextLine();
        mp.add(b);
        System.out.print("Product Type : ");
        String e = sc.nextLine();
        pt.add(e);
        System.out.print("Product Name : ");
        String c = sc.nextLine();
        pn.add(c);
        System.out.print("Product Count : ");
        int f = sc.nextInt();
        pc.add(f);
        System.out.print("Product Price : ");
        int g = sc.nextInt();
        pp.add(g);
        sc.nextLine();
        System.out.println("Products Added For Sale Successfully!!!!!!!!\n");
        System.out.println("Ur Merchant Id and Product Id is : " + id);
        mid.add(Integer.toString(id));
        pid.add(Integer.toString(id));
        id++;
        System.out.println("\t\t----------x---------------x----------");
        Enter();
        String k = sc.nextLine();
        if (k.equals(""))
            mwork();
    }

    public static void cngpass() {
        flush();
        System.out.println("\t\t--------------Change Password--------------\n");
        System.out.print("Enter Your Old Password : ");
        String op = sc.nextLine();
        System.out.print("Enter Your New Password : ");
        String np = sc.nextLine();
        int p1 = mp.indexOf(op);
        mp.set(p1, np);
        System.out.println("\t\t--------Password Changed Successfully----------\n");
        Enter();
        String k = sc.nextLine();
        if (k.equals(""))
            mwork();
    }

    public static void mviewstoc() {
        flush();
        System.out.println("\t\t------------Stocks Present------------\n");
        System.out.print("Enter Your Name : ");
        String s = sc.nextLine();
        if (mn.contains(s)) {
            int p1 = mn.indexOf(s);
            System.out.println(
                    "-----------> Product Type : " + pt.get(p1) + "\t-----> Stocks Available For Sale : " + pc.get(p1));
            System.out.println();
            Enter();
            String k = sc.nextLine();
            if (k.equals(""))
                mwork();
        } else {
            System.out.println("Invalid Name!!! Enter Valid Name!!!!\n");
            Enter();
            String k = sc.nextLine();
            if (k.equals(""))
                mwork();
        }
    }

    public static void mremovep() {
        flush();
        System.out.println("\t\t-------------Remove Products---------------\n");
        System.out.print("Enter Product Id : ");
        String s = sc.nextLine();
        if (pid.contains(s)) {
            int a = pid.indexOf(s);
            mn.remove(a);
            mp.remove(a);
            mid.remove(a);
            pt.remove(a);
            pid.remove(a);
            pn.remove(a);
            pp.remove(a);
            pc.remove(a);
            System.out.println("Products Removed Successfully!!!!!");
            Enter();
            String k = sc.nextLine();
            if (k.equals(""))
                mwork();
        } else {
            System.out.println("Product Id Not Found Enter Valid Product Id!!!!");
            Enter();
            String k = sc.nextLine();
            if (k.equals(""))
                mwork();
        }
    }

    public static void Exit() {
        flush();
        System.out.println("\t\t-----------Thank You For Visiting amazon.in-----------");
        System.out.println("Press enter to continue!");
        String k = sc.nextLine();
        if (k.equals("")) {
            Welcome();
        }
    }

    public static void main(String args[]) {
        Welcome();
    }

    public static void flush() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void Enter() {
        System.out.println("Press Enter To Continue!!!");
    }
}