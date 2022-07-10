package LibraryManagementSystem;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;



public class MainClass implements BookManagement,UserManagement {
    static Scanner sc = new Scanner(System.in);
    @Override
    public ArrayList<Book> AddBook(ArrayList l1) {
        String book_Code;
        //System.out.println(l1);
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
                }
            }
            break ;
        }
        System.out.println("Enter the book_Name");
        String book_Name = sc.nextLine();
        System.out.println("Enter the author");
        String author = sc.nextLine();
        System.out.println("Enter the Subject");
        String subject = sc.nextLine();
        String Issue_Status="Available";
        String Issued_To = "NotIssued";


        Book b1 = new Book(book_Code, book_Name, author, subject,Issue_Status, Issued_To,null,null);
        l1.add(b1);
        System.out.println(" Book Added Successfully");

        return l1;
    }

    @Override
    public ArrayList<User> AddUser(ArrayList l2) throws IOException {
            String User_Id,a;
            System.out.println("Enter the User Name");
            String Name = sc.nextLine();
            we1:
            while (true) {
                System.out.println("Enter the user_Id");
                User_Id = sc.nextLine();
                Iterator iterator = l2.iterator();
                while (iterator.hasNext()) {
                    User o = (User) iterator.next();
                    if (User_Id.equals(o.getUser_Id())) {
                        System.out.println("Duplicate Code. Please enter unique User_Id");
                        continue we1;
                    }
                }
                break;
            }
            double Fine_Amount = 0;
            String Books_Issued = "null";

            User u1 = new User(Name, User_Id, Fine_Amount, Books_Issued, null, null);
            l2.add(u1);
            System.out.println(" User Added Successfully");


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
        return null;
    }

    @Override
    public ArrayList<Book> CheckBookAvailability(ArrayList l1) {

        System.out.println(" Enter the Book_Code to Check Availability");
        String Book_Code=sc.nextLine();
        String IssuedTo="";
        Iterator iterator=l1.iterator();
        boolean flag=false;
        while (iterator.hasNext()) {
            Book o = (Book) iterator.next();
            if (o.getBook_Code().equals(Book_Code)) {
                if (o.getIssue_Status().equals("Issued")) {
                    Book_Code=o.getBook_Code();
                    IssuedTo=o.getIssued_To();
                    flag = true;
                    break;
                }
            }
        }
        if (flag == true) {
            System.out.println(Book_Code + " assigned to " +IssuedTo );
        }else{
            System.out.println(Book_Code + " available in library");
        }
        return l1;
    }

    @Override
    public void MarkAsIssued() throws IOException {
        ArrayList l1=read();
        ArrayList l2=read2();
//        System.out.println(l1);
//        System.out.println(l2);

        System.out.println("----------------------------------------");
        System.out.printf("%7s %14s %13s","Book_Code","Book_Name","Status");
        System.out.println("\n----------------------------------------");
        Iterator iterator = l1.iterator();
        while (iterator.hasNext()) {
            Book o = (Book) iterator.next();
            System.out.printf("%7s %14s %17s \n",o.getBook_Code(),o.getBook_Name(),o.getIssue_Status() );
        }
        System.out.println("\n----------------------------------------");
        String a;
        we:
        while (true) {
            System.out.println(" Enter the Book_Code");
            String Book_Code = sc.nextLine();
            System.out.println(" Enter the User_Id");
            String User_Id = sc.nextLine();
            int count = 0;
            Iterator iterator3 = l1.iterator();
            we1:
            while (iterator3.hasNext()) {
                Book o = (Book) iterator3.next();
                if (o.getBook_Code().equals(Book_Code)) {
                    if(o.getIssue_Status().equals("Available")) {
                        o.setIssue_Status("Issued");
                        o.setIssued_To(User_Id);
                        o.setIssued_Date(LocalDateTime.now());
                        o.setReturned_date(LocalDateTime.now().plusDays(7));
                        break we1;
                    } else if (o.getIssue_Status().equals("Issued")) {
                        System.out.println("Book is already issued on " + o.getIssued_Date() + " to " + o.getIssued_To());
                        System.out.println(" try other Book ");
                        continue we;
                    }
                }
            }
//            if (count > 0) {
//                System.out.println(" Please enter a valid Book_Id ");
//                MarkAsReturned();
//            }
            int count1=0;
            Iterator iterator1 = l2.iterator();
            we3:
            while (iterator1.hasNext()) {
                User u = (User) iterator1.next();
                if (u.getUser_Id().equals(User_Id)) {
                    u.setBooks_Issued(Book_Code);
                    u.setDate_Issued(LocalDateTime.now());
                    u.setReturn_Date(LocalDateTime.now().plusDays(7));
                    break we3;
                } else {
                    count1++;
                }
            }
//            if (count1 > 0) {
//                System.out.println(" valid User_Id ");
//                MarkAsReturned();
//            }
            System.out.println("Book " + Book_Code + " issued to user " + User_Id + " successfully");
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
        File file=new File("C:\\Users\\Rahul Dravid\\IdeaProjects\\Library Management System\\src\\LibraryManagementSystem\\User.txt");

        FileWriter writer = new FileWriter(file);
        BufferedWriter buffer = new BufferedWriter(writer);
        for (int i = 0; i <l2.size() ; i++) {
            buffer.write(l2.get(i).toString()+"\n");

        }
        buffer.write("\n");
       // System.out.println(l1);
        buffer.close();
        //write to the User.txt
        File file2=new File("C:\\Users\\Rahul Dravid\\IdeaProjects\\Library Management System\\src\\LibraryManagementSystem\\Book.txt");

        FileWriter writer2 = new FileWriter(file2);
        BufferedWriter buffer2 = new BufferedWriter(writer2);
        for (int i = 0; i <l1.size() ; i++) {
            buffer2.write(l1.get(i).toString()+"\n");

        }
        buffer2.write("\n");
        buffer2.close();
    }
    @Override
    public void MarkAsReturned() throws IOException {
        ArrayList l1 = read();
        ArrayList l2 = read2();
        String a;
        we:
        while (true) {
            System.out.println(" Enter the Book_Code");
            String Book_Code = sc.nextLine();
            System.out.println(Book_Code);
            Iterator iterator3 = l1.iterator();
            we1:
            while (iterator3.hasNext()) {
                Book o = (Book) iterator3.next();
                if (o.getBook_Code().equals(Book_Code)) {
                        o.setIssue_Status("Available");
                        o.setIssued_Date(null);
                        o.setReturned_date(null);
                        break we1;
                }
            }
            Iterator iterator1 = l2.iterator();
            we3:
            while (iterator1.hasNext()) {
                User u = (User) iterator1.next();
                if (u.getBooks_Issued().equals(Book_Code)) {
                    u.setDate_Issued(null);
                    u.setDate_Issued(null);
                    u.setReturn_Date(null);
                    break we3;
                }
            }
//            if (count1 == 0) {
//                System.out.println(" valid User_Id ");
//            } else {
//                break we;
//            }
            System.out.println(" Book Returned Successfully ");
            System.out.println("-----------------------------------------\n");
            System.out.println("Do you want to return another book(Y/N)  ");
            a = sc.nextLine();
            if (a.equals("Y")) {
                continue we;
            } else {
                break we;
            }
        }
        //write to the Book.txt
        File file=new File("C:\\Users\\Rahul Dravid\\IdeaProjects\\Library Management System\\src\\LibraryManagementSystem\\User.txt");

        FileWriter writer = new FileWriter(file);
        BufferedWriter buffer = new BufferedWriter(writer);
        for (int i = 0; i <l2.size() ; i++) {
            buffer.write(l2.get(i).toString()+"\n");

        }
        buffer.write("\n");
        System.out.println(l2);
        buffer.close();
        //write to the User.txt
        File file2=new File("C:\\Users\\Rahul Dravid\\IdeaProjects\\Library Management System\\src\\LibraryManagementSystem\\Book.txt");

        FileWriter writer2 = new FileWriter(file2);
        BufferedWriter buffer2 = new BufferedWriter(writer2);
        for (int i = 0; i <l1.size() ; i++) {
            buffer2.write(l1.get(i).toString()+"\n");
        }
        buffer2.write("\n");
        System.out.println(l1);
        buffer2.close();
    }


    @Override
    public ArrayList<Book> DeleteBookByBookCode(ArrayList l1) {
        if (l1.isEmpty()){
            System.out.println(" List is Empty ");
            System.out.println("-----------------------------------");
        }else {
            we4:
            while (true) {
                System.out.println("Enter Book_Code");
                String Book_Code = sc.nextLine();
                Iterator iterator = l1.iterator();
                int count = 0;
                while (iterator.hasNext()) {
                    Book o = (Book) iterator.next();
                    boolean search = o.getBook_Code().equals(Book_Code);
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
            //System.out.println(l1);

        return l1;
    }


    @Override
    public void GenerateReport() throws IOException {
        ArrayList l1=read();
        System.out.println("******** Choose Report Type*********  ");
        System.out.println("1.Export All \n" +
                "2.Export By Availability \n" +
                "3.Export By Issued ");
        int ch=sc.nextInt();
        switch (ch){
            case 1:ExportAll(l1);
                ArrayList<Book> array1=new ArrayList<>();

                File file1=new File("C:\\Users\\Rahul Dravid\\IdeaProjects\\Library Management System\\src\\LibraryManagementSystem\\Book.txt");
                BufferedReader br=new BufferedReader(new FileReader(file1));
                try {
                    String str = null; //file to string conversion
                    while ((str = br.readLine()) != null) {
                        String[] split = str.split(",");//split string
                        LocalDateTime localDateTime;
                        if (split[7].equals("null")){
                            localDateTime=null;
                        }else {
                            localDateTime = (LocalDateTime.parse(split[7]));
                        }
                        LocalDateTime localDateTime1;
                        if (split[8].equals("null")){
                            localDateTime1=null;
                        }else {
                            localDateTime1 = LocalDateTime.parse(split[8]);
                        }
                        Book b2 = new Book(split[1], split[2], split[3], split[4], split[5],split[6],localDateTime,localDateTime);
                            array1.add(b2);

                    }
                }catch (ArrayIndexOutOfBoundsException | IOException e){

                }
                File file=new File("C:\\Users\\Rahul Dravid\\IdeaProjects\\Library Management System\\src\\LibraryManagementSystem\\ExportAllReport.txt");
                file.createNewFile();
                FileWriter writer = new FileWriter(file);
                BufferedWriter buffer = new BufferedWriter(writer);
                for (int i = 0; i < array1.size(); i++) {
                    buffer.write(array1.get(i).toString() + "\n");

                }
                buffer.write("\n");
                buffer.close();
                break;
            case 2:
                ViewAvailability va=new ViewAvailability();
                va.start();
                break;
            case 3:
                ViewIssue vi=new ViewIssue();
                vi.start();
                break;
            default:
                System.out.println("Please enter a valid choice..");
        }
    }


    public ArrayList ExportAll(ArrayList l1){
        ViewBooksList();
        Iterator iterator = l1.iterator();
        while (iterator.hasNext()) {
            Book o = (Book) iterator.next();
            System.out.printf("%7s %14s %17s %25s 15%s %13s %16s \n",o.getBook_Code(),o.getBook_Name(),o.getAuthor(),o.getSubject(),o.getIssue_Status(), o.getIssued_To(),o.getIssued_Date(),o.getReturned_date() );
        }
        System.out.println("\n-------------------------------------------------------------" +
                "----------------------------------------" +
                "---------------------");
        return l1;
    }


    @Override
    public ArrayList<User> DeleteUser(ArrayList l2) {
        if (l2.isEmpty()){
            System.out.println(" List is Empty ");
            System.out.println("-----------------------------------");
        }else {
            we4:
            while (true) {
                System.out.println("Enter User_Code");
                String Book_Code = sc.nextLine();
                Iterator iterator = l2.iterator();
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
                String[] split = str.split(",");//split string
                LocalDateTime localDateTime;
                LocalDateTime localDateTime1;
                    if (split[6].equals("null")) {
                        localDateTime=null;
                    } else {
                        localDateTime = LocalDateTime.parse(split[6]);
                    }
                    if (split[7].equals("null")) {
                        localDateTime1=null;
                    } else {
                        localDateTime1 = LocalDateTime.parse(split[7]);
                    }
                Book b2 = new Book(split[0], split[1], split[2], split[3], split[4], split[5], localDateTime, localDateTime1);
                l1.add(b2);
            }
               // System.out.println(l1);
            }catch(ArrayIndexOutOfBoundsException | IOException e){

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
                String[] split = str.split(",");//split string
                LocalDateTime localDateTime;
                LocalDateTime localDateTime1;
                if(split[4].equals("null")){
                    localDateTime=null;
                }else{
                    localDateTime= LocalDateTime.parse(split[4]);
                }
                if (split[5].equals("null")){
                    localDateTime1=null;
                }else{
                    localDateTime1= LocalDateTime.parse(split[5]);
                }
                User u2 = new User(split[0],split[1],Double.parseDouble(split[2]),split[3],localDateTime,localDateTime1);
                l2.add(u2);
                //System.out.println(l2);
            }
        }catch (ArrayIndexOutOfBoundsException | IOException e){
        }
        return l2;
    }

    public static void main(String[] args) throws IOException {


        MainClass m = new MainClass();
        ArrayList l1=m.read();
        ArrayList l2=m.read2();
//       System.out.println(l1);
//       System.out.println(l2);

        boolean condition=true;
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

                    case 1:sc.nextLine();
                        we:
                        while(true) {
                            String a;
                            l1 = m.AddBook(l1);

                            File file = new File("C:\\Users\\Rahul Dravid\\IdeaProjects\\Library Management System\\src\\LibraryManagementSystem\\Book.txt");

                            FileWriter writer = new FileWriter(file);
                            BufferedWriter buffer = new BufferedWriter(writer);
                            for (int i = 0; i < l1.size(); i++) {
                                buffer.write(l1.get(i).toString() + "\n");

                            }
                            buffer.write("\n");
                            buffer.close();
                            System.out.println(" Do you want to add another book (Y/N)");
                            a=sc.nextLine();
                            if(a.equals("Y")){
                                continue we;
                            }else {
                                break we;
                            }
                        }
                        break;

                    case 2:sc.nextLine();
                        we:
                        while(true) {
                            String a;
                            l2 = m.AddUser(l2);

                            File file = new File("C:\\Users\\Rahul Dravid\\IdeaProjects\\Library Management System\\src\\LibraryManagementSystem\\User.txt");

                            FileWriter writer = new FileWriter(file);
                            BufferedWriter buffer = new BufferedWriter(writer);
                            for (int i = 0; i < l2.size(); i++) {
                                buffer.write(l2.get(i).toString() + "\n");

                            }
                            buffer.write("\n");
                            buffer.close();
                            System.out.println(" Do you want to add another User (Y/N)");
                            a=sc.nextLine();
                            if(a.equals("Y")){
                                continue we;
                            }else {
                                break we;
                            }
                        }
                        break;
                        case 3: m.ViewBooksList(l1);
                        break;

                    case 4:m.ViewByBookCode(l1);
                        break;
                                                               
                    case 5:sc.nextLine();
                        we:
                        while(true) {
                            String a;
                            l1 = m.DeleteBookByBookCode(l1);
                            //sc.nextLine();
                            File file = new File("C:\\Users\\Rahul Dravid\\IdeaProjects\\Library Management System\\src\\LibraryManagementSystem\\Book.txt");

                            FileWriter writer = new FileWriter(file);
                            BufferedWriter buffer = new BufferedWriter(writer);
                            for (int i = 0; i < l1.size(); i++) {
                                buffer.write(l1.get(i).toString() + "\n");

                            }
                            buffer.write("\n");
                            buffer.close();
                            System.out.println(" Do you want to delete another User (Y/N)");
                            a=sc.nextLine();
                            if(a.equals("Y")){
                                continue we;
                            }else {
                                break we;
                            }
                        }
                        break;

                    case 6:
                        we:
                        while(true) {
                            String a;
                            l1 = m.CheckBookAvailability(l1);

                            File file = new File("C:\\Users\\Rahul Dravid\\IdeaProjects\\Library Management System\\src\\LibraryManagementSystem\\Book.txt");

                            FileWriter writer = new FileWriter(file);
                            BufferedWriter buffer = new BufferedWriter(writer);
                            for (int i = 0; i < l1.size(); i++) {
                                buffer.write(l1.get(i).toString() + "\n");

                            }
                            buffer.write("\n");
                            buffer.close();
                            System.out.println(" Do you want to Check another Book Availability(Y/N)");
                            a=sc.nextLine();
                            if(a.equals("Y")){
                                continue we;
                            }else {
                                break we;
                            }
                        }
                        break;

                    case 7:m.MarkAsIssued();
                        break;

                    case 8:m.MarkAsReturned();
                        break;

                    case 9:m.GenerateReport();
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
class ViewAvailability extends Thread {

    @Override
    public void run() {
        MainClass m1 = new MainClass();
        ArrayList temp=new ArrayList();
        ArrayList l1;
        try {
            l1 = m1.read();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        int count = 0;
        Iterator iterator3 = l1.iterator();
        while (iterator3.hasNext()) {
            Book o = (Book) iterator3.next();
                if (o.getIssue_Status().equals("Available")) {
                        temp.add(o);
                }
        }
        File file=new File("C:\\Users\\Rahul Dravid\\IdeaProjects\\Library Management System\\src\\LibraryManagementSystem\\AvailabilityReport.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedWriter buffer = new BufferedWriter(writer);
        for (int i = 0; i < temp.size(); i++) {
            try {
                buffer.write(temp.get(i).toString() + "\n");
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
    }
}

class ViewIssue extends  Thread{


    @Override
    public void run() {
        ArrayList temp=new ArrayList();
        MainClass m1 = new MainClass();
        ArrayList l1;
        try {
            l1 = m1.read();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        int count = 0;
        Iterator iterator3 = l1.iterator();
        while (iterator3.hasNext()) {
            Book o = (Book) iterator3.next();
            if (o.getIssue_Status().equals("Issued")) {
                temp.add(o);
            }
        }
        File file=new File("C:\\Users\\Rahul Dravid\\IdeaProjects\\Library Management System\\src\\LibraryManagementSystem\\IssuedReport.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedWriter buffer = new BufferedWriter(writer);
        for (int i = 0; i < temp.size(); i++) {
            try {
                buffer.write(temp.get(i).toString() + "\n");
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
    }
}


