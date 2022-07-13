package LibraryManagementSystem;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;



public class MainClass implements BookManagement,UserManagement {
    static Scanner sc = new Scanner(System.in);

    @Override
    public ArrayList<Book> AddBook(ArrayList booklist) {
        String bookCode;
        //System.out.println(booklist);
        we:
        while (true) {
            System.out.println("Enter the Book_Code");
            bookCode = sc.nextLine();
            Iterator iterator = booklist.iterator();
            while (iterator.hasNext()) {
                Book o = (Book) iterator.next();
                if (bookCode.equals(o.getBookCode())) {
                    System.out.println("Duplicate Code. Please enter unique Book.txt-Code");
                    continue we;
                }
            }
            break;
        }
        System.out.println("Enter the book_Name");
        String book_Name = sc.nextLine();
        System.out.println("Enter the author");
        String author = sc.nextLine();
        System.out.println("Enter the subject");
        String subject = sc.nextLine();
        String Issue_Status = "Available";
        String Issued_To = "NotIssued";


        Book b1 = new Book(bookCode, book_Name, author, subject, Issue_Status, Issued_To, null, null);
        booklist.add(b1);
        System.out.println(" Book Added Successfully");

        return booklist;
    }

    @Override
    public ArrayList<User> AddUser(ArrayList userlist) throws IOException {
        String User_Id, a;
        System.out.println("Enter the User name");
        String Name = sc.nextLine();
        we1:
        while (true) {
            System.out.println("Enter the user_Id");
            User_Id = sc.nextLine();
            Iterator iterator = userlist.iterator();
            while (iterator.hasNext()) {
                User o = (User) iterator.next();
                if (User_Id.equals(o.getUser_Id())) {
                    System.out.println("Duplicate Code. Please enter unique user_Id");
                    continue we1;
                }
            }
            break;
        }
        double Fine_Amount = 0;
        String Books_Issued = "null";

        User u1 = new User(Name, User_Id, Fine_Amount, Books_Issued, null, null);
        userlist.add(u1);
        System.out.println(" User Added Successfully");


        return userlist;
    }

    @Override
    public void ViewBooksList(ArrayList booklist) {
        ViewBooksList();
        Iterator iterator = booklist.iterator();
        while (iterator.hasNext()) {
            Book o = (Book) iterator.next();
            System.out.printf("%7s %14s %17s %25s 15%s %13s %16s \n", o.getBookCode(), o.getBookName(), o.getAuthor(), o.getSubject(), o.getIssue_Status(), o.getIssued_To(), o.getIssued_Date(), o.getReturned_date());
        }
        System.out.println("\n-------------------------------------------------------------" +
                "----------------------------------------" +
                "---------------------");
    }

    public void ViewBooksList() {

        System.out.println("-------------------------------------------------------------" +
                "----------------------------------------" +
                "---------------------");
        System.out.printf("%7s %14s %17s %25s %15s %13s %16s", "Book_Code", "Book_Name", "author", "subject", "issue_Status", "issued_To", "issued_Date", "returned_date");
        System.out.println("\n-------------------------------------------------------------" +
                "----------------------------------------" +
                "---------------------");
    }

    @Override
    public void ViewByBookCode(ArrayList booklist) {
        we3:
        while (true) {
            System.out.println("Enter Book_Code");
            String Book_Code = sc.nextLine();
            Iterator iterator = booklist.iterator();
            int count = 0;
            while (iterator.hasNext()) {
                Book o = (Book) iterator.next();
                boolean search = o.getBookCode().equals(Book_Code);
                if (search == true) {
                    ViewByBookCode();
                    System.out.printf(" Book_Code = " + o.getBookCode() + "\n" +
                            " Book_Name = " + o.getBookName() + "\n" +
                            " author_Name = " + o.getAuthor() + "\n" +
                            " subject = " + o.getSubject() + "\n" +
                            " issue_Status = " + o.getIssue_Status() + "\n" +
                            " issued_To = " + o.getIssued_To() + "\n" +
                            " issued_Date = " + o.getIssued_Date() + "\n" +
                            " Returned_Date = " + o.getReturned_date());
                    System.out.println("\n-------------------------------------------------------------");
                    count++;
                    break we3;
                }
            }
            if (count == 0) {
                System.out.println(" Book Not Found ");
                System.out.println("-----------------------------------------------");
            }
        }
    }

    public void ViewByBookCode() {
        System.out.println("-------------------------------------------------------------");
        System.out.printf("Library Details:");
        System.out.println("\n-------------------------------------------------------------");
    }

    @Override
    public ArrayList<Book> SortBook(ArrayList booklist) {
        Collections.sort(booklist);
        return null;
    }

    @Override
    public void CheckBookAvailability() throws IOException {

        ArrayList booklist = read();
        // System.out.println(booklist);
        System.out.println(" Enter the Book_Code to Check Availability");
        String Book_Code = sc.nextLine();
        String IssuedTo = "";
        Iterator iterator = booklist.iterator();
        boolean flag = false;
        int count = 0;
        we:
        while (iterator.hasNext()) {
            Book o = (Book) iterator.next();
            if (o.getBookCode().equals(Book_Code)) {
                if (o.getIssue_Status().equals("Issued")) {
                    Book_Code = o.getBookCode();
                    IssuedTo = o.getIssued_To();
                    flag = true;
                    break;
                }
                count++;
            }
        }
        if (count == 0) {
            System.out.println(" oops book not available ");
        } else {
            System.out.println(Book_Code + " available in library");
        }
        if (flag == true) {
            System.out.println(" " + Book_Code + " assigned to " + IssuedTo);
            CheckBookAvailability();
        } else {
            System.out.println("----------------------------");
            System.out.println(" Do you want Check other book (Y/N)");
            String a = sc.nextLine();
            if (a.equals("Y")) {
                CheckBookAvailability();
            }
        }
        File file = new File("C:\\Users\\Rahul Dravid\\IdeaProjects\\Library Management System\\src\\LibraryManagementSystem\\Book.txt");

        FileWriter writer = new FileWriter(file);
        BufferedWriter buffer = new BufferedWriter(writer);
        for (int i = 0; i < booklist.size(); i++) {
            buffer.write(booklist.get(i).toString() + "\n");

        }
        buffer.write("\n");
        buffer.close();

    }

    @Override
    public void MarkAsIssued() throws IOException {
        ArrayList booklist = read();
        ArrayList userlist = read2();
//        System.out.println(booklist);
//        System.out.println(userlist);

        System.out.println("----------------------------------------");
        System.out.printf("%7s %14s %13s", "Book_Code", "Book_Name", "Status");
        System.out.println("\n----------------------------------------");
        Iterator iterator = booklist.iterator();
        while (iterator.hasNext()) {
            Book o = (Book) iterator.next();
            System.out.printf("%7s %14s %17s \n", o.getBookCode(), o.getBookName(), o.getIssue_Status());
        }
        System.out.println("\n----------------------------------------");
        String a;
        we:
        while (true) {
            System.out.println(" Enter the Book_Code");
            String Book_Code = sc.nextLine();
            System.out.println(" Enter the user_Id");
            String User_Id = sc.nextLine();
            int count = 0;
            int count1 = 0;
            Iterator iterator3 = booklist.iterator();
            Iterator iterator1 = userlist.iterator();
            we1:
            while (iterator3.hasNext()) {
                Book o = (Book) iterator3.next();
                if (o.getBookCode().equals(Book_Code)) {
                    User u = (User) iterator1.next();
                    if (u.getUser_Id().equals(User_Id)) {
                        count1++;
                        if (o.getIssue_Status().equals("Available")) {
                            o.setIssue_Status("Issued");
                            o.setIssued_To(User_Id);
                            o.setIssued_Date(LocalDateTime.now());
                            o.setReturned_date(LocalDateTime.now().plusDays(7));
                            count++;
                            break we1;
                        } else {
                            System.out.println("Book is already issued on " + o.getIssued_Date() + " to " + o.getIssued_To());
                            System.out.println(" try other Book ");
                            count++;
                            continue we;
                        }
                    }
                    count++;
                }
            }
            if (count1 == 0) {
                System.out.println(" please enter valid user_Id ");
                continue we;
            }
            if (count == 0) {
                System.out.println(" Please enter a valid Book_Id ");
                continue we;
            }

            we3:
            while (iterator1.hasNext()) {
                User u = (User) iterator1.next();
                if (u.getUser_Id().equals(User_Id)) {
                    u.setBooks_Issued(Book_Code);
                    u.setDate_Issued(LocalDateTime.now());
                    u.setReturn_Date(LocalDateTime.now().plusDays(7));
                    System.out.println("Book " + Book_Code + " issued to user " + User_Id + " successfully");
                    break we3;
                }
            }

            System.out.println("-----------------------------------------\n");
            System.out.println("Do you want to issue another book(Y/N)  ");
            a = sc.nextLine();
            if (a.equals("Y")) {
                continue we;
            } else {
                break we;
            }
        }
        //write to the Book.txt
        File file = new File("C:\\Users\\Rahul Dravid\\IdeaProjects\\Library Management System\\src\\LibraryManagementSystem\\User.txt");

        FileWriter writer = new FileWriter(file);
        BufferedWriter buffer = new BufferedWriter(writer);
        for (int i = 0; i < userlist.size(); i++) {
            buffer.write(userlist.get(i).toString() + "\n");

        }
        buffer.write("\n");
        // System.out.println(booklist);
        buffer.close();
        //write to the User.txt
        File file2 = new File("C:\\Users\\Rahul Dravid\\IdeaProjects\\Library Management System\\src\\LibraryManagementSystem\\Book.txt");

        FileWriter writer2 = new FileWriter(file2);
        BufferedWriter buffer2 = new BufferedWriter(writer2);
        for (int i = 0; i < booklist.size(); i++) {
            buffer2.write(booklist.get(i).toString() + "\n");

        }
        buffer2.write("\n");
        buffer2.close();
    }

    @Override
    public void MarkAsReturned() throws IOException {
        ArrayList booklist = read();
        ArrayList userlist = read2();
        String a;
        we:
        while (true) {
            System.out.println(" Enter the Book_Code");
            String Book_Code = sc.nextLine();
            //System.out.println(Book_Code);
            Iterator iterator3 = booklist.iterator();
            int count = 0;
            Boolean flag = false;
            we1:
            while (iterator3.hasNext()) {
                Book o = (Book) iterator3.next();
                if (o.getBookCode().equals(Book_Code)) {
                    if (o.getIssue_Status().equals("Issued")) {
                        o.setIssue_Status("Available");
                        o.setIssued_To("NotIssued");
                        o.setIssued_Date(null);
                        o.setReturned_date(null);
                        count++;
                        break we1;
                    }
                    count++;
                    flag = true;
                }
            }
            if (flag == true) {
                System.out.println(" Book is Already returned ");
                System.out.println(" try other book ");
                MarkAsReturned();
            }
            if (count == 0) {
                System.out.println(" please enter the Valid Book code");
                MarkAsReturned();
            }
            Iterator iterator1 = userlist.iterator();
            we3:
            while (iterator1.hasNext()) {
                User u = (User) iterator1.next();
                if (u.getBooks_Issued().equals(Book_Code)) {
                    u.setDate_Issued(null);
                    u.setReturn_Date(null);
                    System.out.println(" Book Returned Successfully ");
                    break we3;
                }
            }

            System.out.println("-----------------------------------------");
            System.out.println("Do you want to return another book(Y/N)  ");
            a = sc.nextLine();
            if (a.equals("Y")) {
                continue we;
            } else {
                break we;
            }
        }
        //write to the Book.txt
        File file = new File("C:\\Users\\Rahul Dravid\\IdeaProjects\\Library Management System\\src\\LibraryManagementSystem\\User.txt");

        FileWriter writer = new FileWriter(file);
        BufferedWriter buffer = new BufferedWriter(writer);
        for (int i = 0; i < userlist.size(); i++) {
            buffer.write(userlist.get(i).toString() + "\n");

        }
        buffer.write("\n");
        //System.out.println(userlist);
        buffer.close();
        //write to the User.txt
        File file2 = new File("C:\\Users\\Rahul Dravid\\IdeaProjects\\Library Management System\\src\\LibraryManagementSystem\\Book.txt");

        FileWriter writer2 = new FileWriter(file2);
        BufferedWriter buffer2 = new BufferedWriter(writer2);
        for (int i = 0; i < booklist.size(); i++) {
            buffer2.write(booklist.get(i).toString() + "\n");
        }
        buffer2.write("\n");
        //System.out.println(booklist);
        buffer2.close();
    }


    @Override
    public ArrayList<Book> DeleteBookByBookCode(ArrayList booklist) {
        if (booklist.isEmpty()) {
            System.out.println(" List is Empty ");
            System.out.println("-----------------------------------");
        } else {
            we4:
            while (true) {
                System.out.println("Enter Book_Code");
                String Book_Code = sc.nextLine();
                Iterator iterator = booklist.iterator();
                int count = 0;
                while (iterator.hasNext()) {
                    Book o = (Book) iterator.next();
                    boolean search = o.getBookCode().equals(Book_Code);
                    if (search == true) {
                        iterator.remove();
                        System.out.println(" Book deleted Successfully");
                        count++;
                        break we4;
                    }
                }
                if (count == 0) {
                    System.out.println(" Book code is not available ");
                    System.out.println("-----------------------------------------------");
                    continue we4;
                }
            }
        }
        //System.out.println(booklist);

        return booklist;
    }


//    public ArrayList ExportAll(ArrayList l1){
//        ViewBooksList();
//        Iterator iterator = l1.iterator();
//        while (iterator.hasNext()) {
//            Book o = (Book) iterator.next();
//            System.out.printf("%7s %14s %17s %25s 15%s %13s %16s \n",o.getBookCode(),o.getBookName(),o.getAuthor(),o.getSubject(),o.getIssue_Status(), o.getIssued_To(),o.getIssued_Date(),o.getReturned_date() );
//        }
//        System.out.println("\n-------------------------------------------------------------" +
//                "----------------------------------------" +
//                "---------------------");
//        return l1;
//    }


    @Override
    public ArrayList<User> DeleteUser(ArrayList userlist) {
        if (userlist.isEmpty()) {
            System.out.println(" List is Empty ");
            System.out.println("-----------------------------------");
        } else {
            we4:
            while (true) {
                System.out.println("Enter User_Code");
                String Book_Code = sc.nextLine();
                Iterator iterator = userlist.iterator();
                int count = 0;
                while (iterator.hasNext()) {
                    User o = (User) iterator.next();
                    boolean search = o.getUser_Id().equals(Book_Code);
                    if (search == true) {
                        iterator.remove();
                        System.out.println(" User deleted Successfully");
                        count++;
                        break we4;
                    }
                }
                if (count == 0) {
                    System.out.println(" User code is not available ");
                    System.out.println("-----------------------------------------------");
                    continue we4;
                }
            }
        }
        return userlist;
    }

    @Override
    public void Exit() {

    }

    public ArrayList<Book> read() throws FileNotFoundException {
        ArrayList<Book> booklist = new ArrayList<>();

        File file1 = new File("C:\\Users\\Rahul Dravid\\IdeaProjects\\Library Management System\\src\\LibraryManagementSystem\\Book.txt");
        BufferedReader br = new BufferedReader(new FileReader(file1));
        try {
            String str = null; //file to string conversion
            while ((str = br.readLine()) != null) {
                String[] split = str.split(",");//split string
                LocalDateTime localDateTime;
                LocalDateTime localDateTime1;
                if (split[6].equals("null")) {
                    localDateTime = null;
                } else {
                    localDateTime = LocalDateTime.parse(split[6]);
                }
                if (split[7].equals("null")) {
                    localDateTime1 = null;
                } else {
                    localDateTime1 = LocalDateTime.parse(split[7]);
                }
                Book b2 = new Book(split[0], split[1], split[2], split[3], split[4], split[5], localDateTime, localDateTime1);
                booklist.add(b2);
            }
            // System.out.println(booklist);
        } catch (ArrayIndexOutOfBoundsException | IOException e) {

        }
        return booklist;
    }


    public ArrayList<User> read2() throws FileNotFoundException {
        ArrayList<User> userlist = new ArrayList<>();

        File file1 = new File("C:\\Users\\Rahul Dravid\\IdeaProjects\\Library Management System\\src\\LibraryManagementSystem\\User.txt");
        BufferedReader br = new BufferedReader(new FileReader(file1));
        try {
            String str = null; //file to string conversion
            while ((str = br.readLine()) != null) {
                String[] split = str.split(",");//split string
                LocalDateTime localDateTime;
                LocalDateTime localDateTime1;
                if (split[4].equals("null")) {
                    localDateTime = null;
                } else {
                    localDateTime = LocalDateTime.parse(split[4]);
                }
                if (split[5].equals("null")) {
                    localDateTime1 = null;
                } else {
                    localDateTime1 = LocalDateTime.parse(split[5]);
                }
                User u2 = new User(split[0], split[1], Double.parseDouble(split[2]), split[3], localDateTime, localDateTime1);
                userlist.add(u2);
                //System.out.println(userlist);
            }
        } catch (ArrayIndexOutOfBoundsException | IOException e) {
        }
        return userlist;
    }

    public static void main(String[] args) throws IOException, InterruptedException {


        MainClass m = new MainClass();
        ArrayList booklist = m.read();
        ArrayList userlist = m.read2();
//       System.out.println(booklist);
//       System.out.println(userlist);

        boolean condition = true;
        while (condition) {
            System.out.println("Menu: \n" +
                    "************Library Management System************* \n" +
                    "1.Add Book.txt \n" +
                    "2.Add User \n" +
                    "3.View Books List  \n" +
                    "4.View by Book-Code  \n" +
                    "5.Delete Book by Book-Code  \n" +
                    "6.Check Book Availability \n" +
                    "7.Mark as Issued   \n" +
                    "8.Mark as Returned  \n" +
                    "9.Generate Report \n "
                    + "10.Exit \n" + " Enter Your Choice ");

            Scanner sc = new Scanner(System.in);
            int ch = sc.nextInt();

            switch (ch) {

                case 1:
                    sc.nextLine();
                    we:
                    while (true) {
                        String a;
                        booklist = m.AddBook(booklist);

                        File file = new File("C:\\Users\\Rahul Dravid\\IdeaProjects\\Library Management System\\src\\LibraryManagementSystem\\Book.txt");

                        FileWriter writer = new FileWriter(file);
                        BufferedWriter buffer = new BufferedWriter(writer);
                        for (int i = 0; i < booklist.size(); i++) {
                            buffer.write(booklist.get(i).toString() + "\n");

                        }
                        buffer.write("\n");
                        buffer.close();
                        System.out.println(" Do you want to add another book (Y/N)");
                        a = sc.nextLine();
                        if (a.equals("Y")) {
                            continue we;
                        } else {
                            break we;
                        }
                    }
                    break;

                case 2:
                    sc.nextLine();
                    we:
                    while (true) {
                        String a;
                        userlist = m.AddUser(userlist);

                        File file = new File("C:\\Users\\Rahul Dravid\\IdeaProjects\\Library Management System\\src\\LibraryManagementSystem\\User.txt");

                        FileWriter writer = new FileWriter(file);
                        BufferedWriter buffer = new BufferedWriter(writer);
                        for (int i = 0; i < userlist.size(); i++) {
                            buffer.write(userlist.get(i).toString() + "\n");

                        }
                        buffer.write("\n");
                        buffer.close();
                        System.out.println(" Do you want to add another User (Y/N)");
                        a = sc.nextLine();
                        if (a.equals("Y")) {
                            continue we;
                        } else {
                            break we;
                        }
                    }
                    break;
                case 3:
                    m.ViewBooksList(booklist);
                    break;

                case 4:
                    m.ViewByBookCode(booklist);
                    break;

                case 5:
                    sc.nextLine();
                    we:
                    while (true) {
                        String a;
                        booklist = m.DeleteBookByBookCode(booklist);
                        //sc.nextLine();
                        File file = new File("C:\\Users\\Rahul Dravid\\IdeaProjects\\Library Management System\\src\\LibraryManagementSystem\\Book.txt");

                        FileWriter writer = new FileWriter(file);
                        BufferedWriter buffer = new BufferedWriter(writer);
                        for (int i = 0; i < booklist.size(); i++) {
                            buffer.write(booklist.get(i).toString() + "\n");

                        }
                        buffer.write("\n");
                        buffer.close();
                        System.out.println(" Do you want to delete another User (Y/N)");
                        a = sc.nextLine();
                        if (a.equals("Y")) {
                            continue we;
                        } else {
                            break we;
                        }
                    }
                    break;

                case 6:
                    m.CheckBookAvailability();
                    break;

                case 7:
                    m.MarkAsIssued();
                    break;

                case 8:
                    m.MarkAsReturned();
                    break;

                case 9:
                    m.GenerateReport();
                    break;
                case 10:
                    condition = false;
                    break;

                default:
                    System.out.println("Please enter a valid choice..");
            }
        }
    }

    public void GenerateReport() throws FileNotFoundException {
        System.out.println("******** Choose Report Type*********  ");
        System.out.println("1.Export All \n" +
                "2.Export By Availability \n" +
                "3.Export By Issued ");
        int ch = sc.nextInt();
        switch (ch) {
            case 1:
                ArrayList temp=new ArrayList<>();
                ArrayList booklist=read();
                Iterator iterator = booklist.iterator();
                while (iterator.hasNext()) {
                    Book o = (Book) iterator.next();
                    temp.add(o);
                }
                Thread1 e=new Thread1(temp);
               e.start();
                Thread2 vi=new Thread2(temp);
                vi.start();

                break;
            case 2:  ArrayList temp1=new ArrayList<>();
                ArrayList booklist1=read();
                Iterator iterator1 = booklist1.iterator();
                while (iterator1.hasNext()) {
                    Book o = (Book) iterator1.next();
                    if (o.getIssue_Status().equals("Available")) {
                        temp1.add(o);
                    }
                }
                Thread1 t1=new Thread1(temp1);
                t1.start();
                Thread2 t2=new Thread2(temp1);
                t2.start();


                break;
            case 3: ArrayList temp2=new ArrayList<>();
                ArrayList booklist2=read();
                Iterator iterator2 = booklist2.iterator();
                while (iterator2.hasNext()) {
                    Book o = (Book) iterator2.next();
                    if (o.getIssue_Status().equals("Issued")) {
                        temp2.add(o);
                    }
                }
                  Thread1 t11=new Thread1(temp2);
                 t11.start();
                    Thread2 t22=new Thread2(temp2);
                  t22.start();
                break;
            default:
                System.out.println("Please enter a valid choice..");
        }
    }
}

    class Thread1 extends Thread{
        ArrayList temp = new ArrayList();
        public Thread1(ArrayList booklist) {
            for (int i = 0; i < booklist.size(); i++) {

                temp.add(booklist.get(i));
            }
        }
            @Override
            public void run() {
                for (int i = 0; i < temp.size()/2; i++) {
                    System.out.println("Thread 1 running");
                    File file = new File("C:\\Users\\Rahul Dravid\\IdeaProjects\\Library Management System\\src\\LibraryManagementSystem\\Report.txt");

                    FileWriter writer = null;
                    try {
                        writer = new FileWriter(file);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    BufferedWriter buffer = new BufferedWriter(writer);
                    for (int j = 0; j < temp.size(); j++) {
                        try {
                            buffer.write(temp.get(j).toString() + "\n");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    try {
                        buffer.write("\n");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        buffer.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        Thread1.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }

    }

    class  Thread2 extends Thread {

        ArrayList temp = new ArrayList();
        public Thread2(ArrayList booklist) {
            for (int i = 0; i < booklist.size(); i++) {
                temp.add(booklist.get(i));
            }
        }
        @Override
        public void run() {
            for (int i = temp.size()/2; i < temp.size(); i++) {
                System.out.println(" Thread 2 running");
                File file = new File("C:\\Users\\Rahul Dravid\\IdeaProjects\\Library Management System\\src\\LibraryManagementSystem\\Report.txt");

                FileWriter writer = null;
                try {
                    writer = new FileWriter(file);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                BufferedWriter buffer = new BufferedWriter(writer);
                for (int j = 0; j < temp.size(); j++) {
                    try {
                        buffer.write(temp.get(j).toString() + "\n");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                try {
                    buffer.write("\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    buffer.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    Thread2.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }

    }

//    class  ViewIssue extends Thread{
//
//        ArrayList temp = new ArrayList();
//        public ViewIssue(ArrayList booklist) {
//            for (int i = 0; i < booklist.size(); i++) {
//                temp.add(booklist.get(i));
//            }
//        }
//        @Override
//        public void run() {
//
//            File file = new File("C:\\Users\\Rahul Dravid\\IdeaProjects\\Library Management System\\src\\LibraryManagementSystem\\Report.txt");
//
//            FileWriter writer = null;
//            try {
//                writer = new FileWriter(file);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            BufferedWriter buffer = new BufferedWriter(writer);
//            for (int i = 0; i < temp.size(); i++) {
//                try {
//                    buffer.write(temp.get(i).toString() + "\n");
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//
//            }
//            try {
//                buffer.write("\n");
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            try {
//                buffer.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//
//        }
//
//    }

