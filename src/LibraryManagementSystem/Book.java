package LibraryManagementSystem;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class Book {
    String Book_Code;
    String Book_Name;
    String Author;

    String Subject;

    String Issue_Status;
    String Issued_To;
    LocalDateTime Issued_Date;

    LocalDateTime Returned_date;

    public String getIssued_To() {
        return Issued_To;
    }

    public void setIssued_To(String issued_To) {
        Issued_To = issued_To;
    }

    public LocalDateTime getIssued_Date() {
        return Issued_Date;
    }

    public void setIssued_Date(LocalDateTime issued_Date) {
        Issued_Date = issued_Date;
    }

    public LocalDateTime getReturned_date() {
        return Returned_date;
    }

    public void setReturned_date(LocalDateTime returned_date) {
        Returned_date = returned_date;
    }


    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getIssue_Status() {
        return Issue_Status;
    }

    public void setIssue_Status(String issue_Status) {
        Issue_Status = issue_Status;
    }

    public Book(String book_Code, String book_Name, String author, String subject,String issue_Status, String issued_To, LocalDateTime issued_Date, LocalDateTime returned_date) {
        Book_Code = book_Code;
        Book_Name = book_Name;
        Author = author;
        Subject = subject;
        Issue_Status = issue_Status;
        Issued_To = issued_To;
        Issued_Date = issued_Date;
        Returned_date = returned_date;

    }

    public String getBook_Code() {
        return Book_Code;
    }

    public void setBook_Code(String book_Code) {
        Book_Code = book_Code;
    }

    public String getBook_Name() {
        return Book_Name;
    }

    public void setBook_Name(String book_Name) {
        Book_Name = book_Name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }


    @Override
    public String toString() {
        return "" + Book_Code +
                "," + Book_Name +
                "," + Author +
                "," + Subject +
                "," + Issue_Status +
                "," + Issued_To +
                "," + Issued_Date +
                "," + Returned_date+","
                ;
    }

}
//  while ((str=br.readLine())!=null){
//    String str=br.lines().collect(Collectors.joining());//file to string conversion
//    String[] split=str.split(" ");//split string
//
//        for (int i = 0; i < split.length; i++) {
//        System.out.println(split[i]);
//        }
//        LocalDateTime dateTime=LocalDateTime.parse(split[5]);
//        LocalDateTime dateTime1=LocalDateTime.parse(split[6]);
//        Book b2=new Book(split[0],split[1],split[2],split[3],split[4],dateTime,dateTime1);
//        l1.add(b2);
//  }
//while ((str = br.readLine()) != null) {
//                String[] split = str.split(",");//split string
//                LocalDateTime localDateTime;
//                if (split[7].equals("null")){
//                    localDateTime=null;
//                }else {
//                    localDateTime = (LocalDateTime.parse(split[7]));
//                }
//                LocalDateTime localDateTime1;
//                if (split[8].equals("null")){
//                    localDateTime1=null;
//                }else {
//                    localDateTime1 = LocalDateTime.parse(split[8]);
//                }
//                Book b2 = new Book(split[1], split[2], split[3], split[4], split[5],split[6],localDateTime,localDateTime1);
//                l1.add(b2);