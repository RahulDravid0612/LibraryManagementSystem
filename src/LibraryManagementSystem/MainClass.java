package LibraryManagementSystem;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class MainClass implements BookManagement,UserManagement {
    static Scanner sc = new Scanner(System.in);
    @Override
    public ArrayList<Book> AddBook(ArrayList l1) {
        String book_Code;
        we:
        while (true) {
            System.out.println("Enter the Book_Code");
            book_Code = sc.nextLine();
            Iterator iterator = l1.iterator();
            while (iterator.hasNext()) {
                Book o = (Book) iterator.next();
                if (book_Code.equals(o.getBook_Code())) {
                    System.out.println("Duplicate Code. Please enter unique Book.txt-Code");
                    continue we;
                } else {
                    break;
                }
            }
            break;
        }
        System.out.println("Enter the book_Name");
        String book_Name = sc.nextLine();
        System.out.println("Enter the author");
        String author = sc.nextLine();
        System.out.println("Enter the Subject");
        String subject = sc.nextLine();
        String Issue_Status="Available";
        String Issued_To = null;
        LocalDateTime Issued_Date =null;
        LocalDateTime Returned_date = null;

        Book b1 = new Book(book_Code, book_Name, author, subject,Issue_Status, Issued_To, Issued_Date, Returned_date);
        l1.add(b1);
        System.out.println(" Book.txt Added Successfully");
        return l1;
    }

    @Override
    public ArrayList<User> AddUser(ArrayList l2)  {
            String User_Id;
            System.out.println("Enter the User Name");
            String Name=sc.nextLine();
            we:
        while (true){
            System.out.println("Enter the user_Id");
            User_Id = sc.nextLine();
            Iterator iterator = l2.iterator();
            while (iterator.hasNext()) {
                User o = (User) iterator.next();
                if (User_Id.equals(o.getUser_Id())) {
                    System.out.println("Duplicate Code. Please enter unique User_Id");
                    continue we;
                } else {
                    break;
                }
            }
            break;
        }
        double Fine_Amount=20;
        String Books_Issued=null;
        LocalDateTime date_Issued=null;
        LocalDateTime return_Date = null;


        User u1=new User(Name,User_Id,Fine_Amount,Books_Issued,date_Issued,return_Date);
        l2.add(u1);
        System.out.println(l2);
        System.out.println(" Book.txt Added Successfully");
        return l2;
    }
    @Override
    public void ViewBooksList(ArrayList l1) {
        ViewBooksList();
        Iterator iterator = l1.iterator();
        while (iterator.hasNext()) {
            Book o = (Book) iterator.next();
                System.out.printf("%7s %14s %17s %25s 15%s %13s %16s \n",o.getBook_Code(),o.getBook_Name(),o.getAuthor(),o.getSubject(),o.getIssue_Status(), o.getIssued_To(),o.getIssued_Date(),o.getReturned_date() );
        }
        System.out.println("\n-------------------------------------------------------------" +
                "----------------------------------------" +
                "---------------------");
    }
    public void ViewBooksList(){

        System.out.println("-------------------------------------------------------------" +
                "----------------------------------------" +
                "---------------------");
        System.out.printf("%7s %14s %17s %25s %15s %13s %16s","Book_Code","Book_Name","Author","Subject","Issue_Status","Issued_To","Issued_Date","Returned_date");
        System.out.println("\n-------------------------------------------------------------" +
                "----------------------------------------" +
                "---------------------");
    }

    @Override
    public void ViewByBookCode(ArrayList l1) {
        we3:
        while (true) {
            System.out.println("Enter Book_Code");
            String Book_Code = sc.nextLine();
            Iterator iterator = l1.iterator();
            int count=0;
            while (iterator.hasNext()) {
                Book o = (Book) iterator.next();
                 boolean search=o.getBook_Code().equals(Book_Code);
                if (search==true) {
                    ViewByBookCode();
                    System.out.printf(" Book_Code = " + o.getBook_Code() + "\n" +
                            " Book_Name = " + o.getBook_Name() + "\n" +
                            " author_Name = " + o.getAuthor() + "\n" +
                            " Subject = " + o.getSubject() + "\n" +
                            " Issue_Status = " + o.getIssue_Status() + "\n" +
                            " Issued_To = " + o.getIssued_To() + "\n" +
                            " Issued_Date = " + o.getIssued_Date() + "\n" +
                            " Returned_Date = " + o.getReturned_date());
                    System.out.println("\n-------------------------------------------------------------");
                    count++;
                    break we3;
                }
                }
            if(count==0){
                System.out.println(" Book Not Found ");
                System.out.println("-----------------------------------------------");
            }
        }
    }
    public void ViewByBookCode(){
        System.out.println("-------------------------------------------------------------");
        System.out.printf("Library Details:");
        System.out.println("\n-------------------------------------------------------------");
    }

    @Override
    public ArrayList<Book> SortBook(ArrayList l1) {
        Collections.sort(l1);
        System.out.println("----------------------------------------");
        System.out.printf("%7s %14s %13s","Book_Code","Book_Name","Status");
        System.out.println("\n----------------------------------------");
        Iterator iterator=l1.iterator();
            while(iterator.hasNext()){
                Book o = (Book) iterator.next();
                System.out.printf("%7s %14s %13s \n",o.getBook_Code(),o.getBook_Name(),o.getIssue_Status());
                System.out.println("\n--------------------------------------");
            }
        return null;
    }

    @Override
    public ArrayList MarkAsIssued(ArrayList l1,ArrayList l2) {
        String a;
        we:
        while (true) {
            SortBook(l1);
            System.out.println(" Enter the Book_Code");
            String Book_Code = sc.nextLine();
            System.out.println(" Enter the User_Id");
            String User_Id = sc.nextLine();
            Iterator iterator = l1.iterator();
            Iterator iterator1 = l2.iterator();
            int count = 0;
            we1:
            while (iterator.hasNext()) {
                Book o = (Book) iterator.next();
                if (o.getBook_Code().equals(Book_Code)) {
                    if(o.getIssue_Status().equals("Available")) {
                        String Status = "Issued";
                        o.setIssue_Status(Status);
                        o.setIssued_To(User_Id);
                        o.setIssued_Date(LocalDateTime.now());
                        o.setReturned_date(LocalDateTime.now());
                        break we1;
                    }else {
                        System.out.println("Book is already issued on "+o.getIssued_Date()+" to "+o.getIssued_To());
                    }
                } else {
                    count++;
                }
            }
            if (count == 0) {
                System.out.println(" Please enter a valid Book_Id ");
            } else {
                break we;
            }
            we3:
            while (iterator1.hasNext()) {
                User u = (User) iterator.next();
                if (u.getUser_Id().equals(User_Id)) {
                    u.setBooks_Issued(User_Id);
                    u.setDate_Issued(LocalDateTime.now());
                    u.setReturn_Date(LocalDateTime.now());
                    break we3;
                } else {
                    count++;
                }
            }
            if (count == 0) {
                System.out.println(" Please enter a valid User_Id ");
            } else {
                break we;
            }

            System.out.println("Book " + Book_Code + " issued to user " + User_Id + " successfully");
            System.out.println("-----------------------------------------\n");
            System.out.println("Do you want to issue another book(Y/N)  ");
            a = sc.nextLine();
            if (a == "Y") {
                continue we;
            } else {
                break we;
            }
        }
        return null;
    }




    @Override
    public void MarkAsReturned() {

    }

    @Override
    public ArrayList<Book> DeleteBookByBookCode(ArrayList l1) {
        we4:
        while (true) {
            System.out.println("Enter Book_Code");
            String Book_Code = sc.nextLine();
            Iterator iterator = l1.iterator();
            int count=0;
            while (iterator.hasNext()) {
                Book o = (Book) iterator.next();
                boolean search=o.getBook_Code().equals(Book_Code);
                if (search==true) {
                    iterator.remove();
                    System.out.println(" Book deleted Successfully");
                    count++;
                    break we4;
                }
            }
            if(count==0){
                System.out.println(" Book code is not available ");
                System.out.println("-----------------------------------------------");
                continue we4;
            }
            }
            //System.out.println(l1);

        return l1;
    }


    @Override
    public void GenerateReport() {

    }

    @Override
    public ArrayList<User> DeleteUser(ArrayList l2) {
        we4:
        while (true) {
            System.out.println("Enter User_Code");
            String Book_Code = sc.nextLine();
            Iterator iterator = l2.iterator();
            int count=0;
            while (iterator.hasNext()) {
                User o = (User) iterator.next();
                boolean search=o.getUser_Id().equals(Book_Code);
                if (search==true) {
                    iterator.remove();
                    System.out.println(" User deleted Successfully");
                    count++;
                    break we4;
                }
            }
            if(count==0){
                System.out.println(" User code is not available ");
                System.out.println("-----------------------------------------------");
                continue we4;
            }
        }
        return l2;
    }

    @Override
    public void Exit() {

    }

    public ArrayList<Book> read() throws FileNotFoundException {
        ArrayList<Book> l1=new ArrayList<>();

        File file1=new File("C:\\Users\\Rahul Dravid\\IdeaProjects\\Library Management System\\src\\LibraryManagementSystem\\Book.txt");
        BufferedReader br=new BufferedReader(new FileReader(file1));
        try {
            String str = null; //file to string conversion
            while ((str = br.readLine()) != null) {
                String[] split = str.split(" ");//split string
                LocalDateTime dateTime = LocalDateTime.parse(split[7]);
                LocalDateTime dateTime1 = LocalDateTime.parse(split[8]);
                Book b2 = new Book(split[1], split[2], split[3], split[4], split[5],split[6],dateTime, dateTime1);
                l1.add(b2);
            }
        }catch (ArrayIndexOutOfBoundsException | IOException e){

        }
        return l1;
    }

    public ArrayList<User> read2() throws FileNotFoundException {
        ArrayList<User> l2=new ArrayList<>();

        File file1=new File("C:\\Users\\Rahul Dravid\\IdeaProjects\\Library Management System\\src\\LibraryManagementSystem\\User.txt");
        BufferedReader br=new BufferedReader(new FileReader(file1));
        try {
            String str = null; //file to string conversion
            while ((str = br.readLine()) != null) {
                String[] split = str.split(" ");//split string

                LocalDateTime dateTime = LocalDateTime.parse(split[5]);
                LocalDateTime dateTime1 = LocalDateTime.parse(split[6]);
                User u2 = new User(split[1], split[2], Double.parseDouble(split[3]),split[4],dateTime, dateTime1);
                l2.add(u2);
            }
        }catch (ArrayIndexOutOfBoundsException | IOException e){

        }
        return l2;
    }

    public static void main(String[] args) throws IOException {


        MainClass m = new MainClass();
        ArrayList l1=m.read();
        ArrayList l2=m.read2();

        boolean condition=true;
        while (condition) {
                System.out.println("Menu: \n" +
                        "************Library Management System************* \n" +
                        "1.Add Book.txt \n" +
                        "2.Add User \n" +
                        "3.Delete User \n" +
                        "4.Delete Book.txt by Book.txt-Code \n" +
                        "5.Update Details \n" +
                        "6.Search Book.txt by Book.txt-Code \n" +
                        "7.Sort Book.txt  \n" +
                        "8.Mark as Issued \n" +
                        "9.Generate Report \n "
                        + "10.Exit \n" + " Enter Your Choice ");

                Scanner sc = new Scanner(System.in);
                int ch = sc.nextInt();

                switch (ch) {
                    case 1:
                            m.AddBook(l1);
                             sc.nextLine();
                        File file=new File("C:\\Users\\Rahul Dravid\\IdeaProjects\\Library Management System\\src\\LibraryManagementSystem\\Book.txt");

                        FileWriter writer = new FileWriter(file);
                        BufferedWriter buffer = new BufferedWriter(writer);
                        for (int i = 0; i <l1.size() ; i++) {
                            buffer.write(l1.get(i).toString()+"\n");

                        }
                        buffer.write("\n");

                    we:
                    while (true){
                        String a;
                        System.out.println("Do you want to add another book (Y/N)");
                        a=sc.nextLine();
                        while (a.equals("Y")) {
                            m.AddBook(l1);
                            for (int i = 0; i <l1.size() ; i++) {
                                buffer.write(l1.get(i).toString()+"\n");

                            }
                            buffer.write("\n");
                            continue we;
                        }
                        buffer.close();
                        break;
                        }
                    break;
                    case 2:
                            m.AddUser(l2);
                        System.out.println(l2);
                        sc.nextLine();
                        File file2=new File("C:\\Users\\Rahul Dravid\\IdeaProjects\\Library Management System\\src\\LibraryManagementSystem\\User.txt");

                        FileWriter writer2 = new FileWriter(file2);
                        BufferedWriter buffer2 = new BufferedWriter(writer2);
                        for (int i = 0; i <l2.size() ; i++) {
                            buffer2.write(l2.get(i).toString()+"\n");

                        }
                        buffer2.write("\n");
                        we1:
                        while (true){
                            String a;
                            System.out.println("Do you want to add another User (Y/N)");
                            a=sc.nextLine();
                            while (a.equals("Y")) {
                                m.AddUser(l2);
                                for (int i = 0; i <l2.size() ; i++) {
                                    buffer2.write(l2.get(i).toString()+"\n");

                                }
                                buffer2.write("\n");
                                continue we1;
                            }
                            System.out.println(l2);
                            buffer2.close();
                            break;
                        }
                    break;
                    case 3: m.DeleteUser(l2);
                        File file3=new File("C:\\Users\\Rahul Dravid\\IdeaProjects\\Library Management System\\src\\LibraryManagementSystem\\User.txt");

                        FileWriter writer3 = new FileWriter(file3);
                        BufferedWriter buffer3 = new BufferedWriter(writer3);
                        for (int i = 0; i <l2.size() ; i++) {
                            buffer3.write(l2.get(i).toString()+"\n");

                        }
                        buffer3.write("\n");

                        we3:
                        while (true){
                            String a;
                            sc.nextLine();
                            System.out.println("Do you want to delete another book (Y/N)");
                            a=sc.nextLine();
                            while (a.equals("Y")) {
                                m.DeleteBookByBookCode(l1);
                                for (int i = 0; i <l2.size() ; i++) {
                                    buffer3.write(l2.get(i).toString()+"\n");

                                }
                                buffer3.write("\n");
                                continue we3;
                            }
                            buffer3.close();
                            break;
                        }
                        break;
                    case 4:m.DeleteBookByBookCode(l1);
                        File file4=new File("C:\\Users\\Rahul Dravid\\IdeaProjects\\Library Management System\\src\\LibraryManagementSystem\\Book.txt");

                        FileWriter writer4 = new FileWriter(file4);
                        BufferedWriter buffer4 = new BufferedWriter(writer4);
                        for (int i = 0; i <l1.size() ; i++) {
                            buffer4.write(l1.get(i).toString()+"\n");

                        }
                        buffer4.write("\n");

                        we3:
                        while (true){
                            String a;
                            sc.nextLine();
                            System.out.println("Do you want to delete another book (Y/N)");
                            a=sc.nextLine();
                            while (a.equals("Y")) {
                                m.DeleteBookByBookCode(l1);
                                for (int i = 0; i <l1.size() ; i++) {
                                    buffer4.write(l1.get(i).toString()+"\n");

                                }
                                buffer4.write("\n");
                                continue we3;
                            }
                            buffer4.close();
                            break;
                        }
                        break;
                    case 5:
                        System.out.println("Update Details Method");
                        break;
                    case 6:m.ViewByBookCode(l1);
                        break;
                    case 7:m.SortBook(l1);
                        break;
                    case 8:m.MarkAsIssued(l1,l2);
                        System.out.println("Mark As Issued Method");
                        break;
                    case 9:m.ViewBooksList(l1);
                        break;
                    case 10:
                        condition = false;
                        break;
                    default:
                        System.out.println("Please enter a valid choice..");
                }
            }
        }
    }