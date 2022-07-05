package LibraryManagementSystem;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class MainClass implements BookManagement,UserManagement {
    static Scanner sc = new Scanner(System.in);
    BufferedReader input = null;
    ArrayList<Book> book = new ArrayList();

    @Override
    public ArrayList<Book> AddBook() throws IOException {
        String book_Code;
        we:
        while (true){
            System.out.println("Enter the Book_Code");
            book_Code = sc.nextLine();
            Iterator iterator = book.iterator();
            while (iterator.hasNext()) {
                Book o = (Book) iterator.next();
                if (book_Code.equals(o.getBook_Code())) {
                    System.out.println("Duplicate Code. Please enter unique Book-Code");
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
            String Issued_To="user1";
            DateTimeFormatter dft=DateTimeFormatter.ofPattern("dd/MM/yyyy    HH:mm:ss");
            LocalDateTime Issued_Date=LocalDateTime.now();

            LocalDateTime Returned_date=LocalDateTime.now();

            Book b1 = new Book(book_Code, book_Name, author, subject, Issued_To, Issued_Date,Returned_date);
            book.add(b1);
            System.out.println(" Book Added Successfully");

        for (Book x:book) {
            System.out.println(x);
        }
            File file = new File("Book.txt");
            PrintWriter pw = null;

            return book;
//        try {
//            pw = new PrintWriter(file);
//            pw.println();
//        }

//        System.out.println(" Book Added Successfully");
//        File f1 = new File("C:\\Users\\Rahul Dravid\\IdeaProjects\\Library Management System\\src\\LibraryManagementSystem\\Book.txt");
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

//          Book o=(Book) iterator.next();
//          book.add(o);
//
//


    }



    @Override
    public void ViewBooksList(ArrayList l1) throws IOException {

        for (Object x:l1) {
            System.out.println(x);
        }
//       File file=new File("Book.txt");
//       Scanner readFile=new Scanner(file);
//        StringTokenizer token=null;
//
//        while ((readFile.hasNext())) {
//            token=new StringTokenizer(readFile.nextLine(),",");
//
//        }

    }

    @Override
    public void AddUser() {

    }

    @Override
    public void ViewByBookCode() {

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

        ArrayList<Book> l1=new ArrayList();

        boolean condition=true;
        while (condition) {
                System.out.println("Menu: \n" +
                        "************Library Management System************* \n" +
                        "1.Add Book \n" +
                        "2.Add User \n" +
                        "3.Delete User \n" +
                        "4.Delete Book by Book-Code \n" +
                        "5.Update Details \n" +
                        "6.Search Book by Book-Code \n" +
                        "7.Sort Book  \n" +
                        "8.Mark as Issued \n" +
                        "9.Generate Report \n "
                        + "10.Exit \n" + " Enter Your Choice ");

                Scanner sc = new Scanner(System.in);
                int ch = sc.nextInt();
                MainClass m = new MainClass();
                switch (ch) {
                    case 1:l1=m.AddBook();
                    sc.nextLine();
                    we:
                    while (true){
                        String a;
                        System.out.println("Do you want to add another book (Y/N)");
                        a=sc.nextLine();
                        while (a.equals("Y")) {
                            m.AddBook();
                            continue we;
                        }
                        break;
                        }
                    case 2:
                        break;
                    case 3:
                        System.out.println("Delete User Method");
                        break;
                    case 4:
                        System.out.println("Delete Book By Book-Code");
                        break;
                    case 5:
                        System.out.println("Update Details Method");
                        break;
                    case 6:
                        System.out.println("Search Book By Book-Code");
                        break;
                    case 7:
                        System.out.println("Sort Book Method");
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