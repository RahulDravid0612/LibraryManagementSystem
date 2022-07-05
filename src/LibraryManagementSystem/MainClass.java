package LibraryManagementSystem;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class MainClass implements BookManagement,UserManagement {
    static Scanner sc = new Scanner(System.in);
    ArrayList<Book> book = new ArrayList<Book>();
    ArrayList<User> user=new ArrayList<User>();
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
        String Issued_To = "user1";
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime Issued_Date = LocalDateTime.now();
        LocalDateTime Returned_date = LocalDateTime.now();

        Book b1 = new Book(book_Code, book_Name, author, subject, Issued_To, Issued_Date, Returned_date);
        l1.add(b1);


        System.out.println(" Book.txt Added Successfully");

        return l1;
    }
//        try {
//            pw = new PrintWriter(file);
//            pw.println();
//        }

//        System.out.println(" Book.txt Added Successfully");
//        File f1 = new File("C:\\Users\\Rahul Dravid\\IdeaProjects\\Library Management System\\src\\LibraryManagementSystem\\Book.txt.txt");
//        if (!f1.exists()) {
//            f1.createNewFile();
//
//            FileWriter writer = new FileWriter(f1, true);
//            BufferedWriter buffer = new BufferedWriter(writer);
//
//            buffer.write(String.valueOf(b1));
//            buffer.close();

//      Iterator iterator = book.iterator();
//        while (iterator.hasNext()){

//          Book.txt o=(Book.txt) iterator.next();
//          book.add(o);
    @Override
    public ArrayList<User> AddUser()  {
            String User_Id;
            System.out.println("Enter the User Name");
            String Name=sc.nextLine();
            we:
        while (true){
            System.out.println("Enter the user_Id");
            User_Id = sc.nextLine();
            Iterator iterator = user.iterator();
            while (iterator.hasNext()) {
                Book o = (Book) iterator.next();
                if (User_Id.equals(o.getBook_Code())) {
                    System.out.println("Duplicate Code. Please enter unique User_Id");
                    continue we;
                } else {
                    break;
                }
            }
            break;
        }
        double Fine_Amount=20;
        DateTimeFormatter dft=DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDateTime Books_Issued=LocalDateTime.now();
        LocalDateTime date_Issued=LocalDateTime.now();
        LocalDateTime return_Date=LocalDateTime.now();

        User u1=new User(Name,User_Id,Fine_Amount,Books_Issued,date_Issued,return_Date);
        user.add(u1);
        System.out.println(" Book.txt Added Successfully");

        for (Book x:book) {
            System.out.println(x);
        }
        return user;
    }
    @Override
    public void ViewBooksList(ArrayList l1) {
        ViewBooksList();
        Iterator iterator = l1.iterator();
        while (iterator.hasNext()) {
            Book o = (Book) iterator.next();
                System.out.printf("%7s %14s %17s %25s %13s %16s\n",o.getBook_Code(),o.getBook_Name(),o.getAuthor(),o.getSubject(),o.getIssued_To(),o.getIssued_Date(),o.getReturned_date() );
        }
        System.out.println("\n-------------------------------------------------------------" +
                "----------------------------------------" +
                "---------------------");
    }
    public void ViewBooksList(){

        System.out.println("-------------------------------------------------------------" +
                "----------------------------------------" +
                "---------------------");
        System.out.printf("%7s %14s %17s %25s %13s %16s","Book_Code","Book_Name","Author","Subject","Issued_To","Issued_Date","Returned_date");
        System.out.println("\n-------------------------------------------------------------" +
                "----------------------------------------" +
                "---------------------");
    }


    @Override
    public void ViewByBookCode(ArrayList l1) {
        ViewByBookCode();

    }
    public void ViewByBookCode(){
        System.out.println("-------------------------------------------------------------");
        System.out.printf("Library Details:");
        System.out.println("\n-------------------------------------------------------------");
    }


    @Override
    public void SortBook() {

    }

    @Override
    public void MarkAsIssued() {

    }

    @Override
    public void MarkAsReturned() {

    }

    @Override
    public void DeleteBookByBookCode() {

    }

    @Override
    public void GenerateReport() {

    }

    @Override
    public void Exit() {

    }


    public static void main(String[] args) throws IOException {

        ArrayList<Book> l1=new ArrayList<>();
        ArrayList<User> u1=new ArrayList<>();
        ArrayList<String> string1=new ArrayList<>();
        String[] str1=new String[100];

        File file1=new File("C:\\Users\\Rahul Dravid\\IdeaProjects\\Library Management System\\src\\LibraryManagementSystem\\Book.txt");
        BufferedReader br=new BufferedReader(new FileReader(file1));
        String str;
        while ((str=br.readLine())!=null){
            for (int i = 0; i < str1.length; i++) {
                str1[i]=str;
            }

            Book b2=new Book(str1[0],str1[1],str1[2],str1[3],str1[4],str1[5],str1[6]);

            //Collections.addAll(string1,str1);
           //  Arrays.asList(str1);
           // l1.add(b1);
           // System.out.println(str);
        }



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
                MainClass m = new MainClass();
                switch (ch) {
                    case 1:l1=m.AddBook(l1);
                    sc.nextLine();
                    we:
                    while (true){
                        String a;
                        System.out.println("Do you want to add another book (Y/N)");
                        a=sc.nextLine();
                        while (a.equals("Y")) {
                            m.AddBook(l1);
                            continue we;
                        }
                        File file=new File("C:\\Users\\Rahul Dravid\\IdeaProjects\\Library Management System\\src\\LibraryManagementSystem\\Book.txt");

                        FileWriter writer = new FileWriter(file, true);
                        BufferedWriter buffer = new BufferedWriter(writer);
                        buffer.write(String.valueOf(l1));
                        buffer.write("\n");
                        buffer.close();
                        break;
                        }
                    break;
                    case 2:u1=m.AddUser();
                        sc.nextLine();
                        we1:
                        while (true){
                            String a;
                            System.out.println("Do you want to add another book (Y/N)");
                            a=sc.nextLine();
                            while (a.equals("Y")) {
                                m.AddUser();
                                continue we1;
                            }
                            break;
                        }
                    break;
                    case 3:
                        System.out.println("Delete User Method");
                        break;
                    case 4:
                        System.out.println("Delete Book.txt By Book.txt-Code");
                        break;
                    case 5:
                        System.out.println("Update Details Method");
                        break;
                    case 6:
                        System.out.println("Search Book.txt By Book.txt-Code");
                        break;
                    case 7:
                        System.out.println("Sort Book.txt Method");
                        break;
                    case 8:
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