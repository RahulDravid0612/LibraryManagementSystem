package LibraryManagementSystem;

import java.time.LocalDateTime;

public class Book {
    String bookCode;
    String bookName;
    String author;
    String subject;
    String issue_Status;
    String issued_To;
    LocalDateTime issued_Date;
    LocalDateTime returned_date;

    public String getIssued_To() {
        return issued_To;
    }

    public void setIssued_To(String issued_To) {
        this.issued_To = issued_To;
    }

    public LocalDateTime getIssued_Date() {
        return issued_Date;
    }

    public void setIssued_Date(LocalDateTime issued_Date) {
        this.issued_Date = issued_Date;
    }

    public LocalDateTime getReturned_date() {
        return returned_date;
    }

    public void setReturned_date(LocalDateTime returned_date) {
        this.returned_date = returned_date;
    }


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getIssue_Status() {
        return issue_Status;
    }

    public void setIssue_Status(String issue_Status) {
        this.issue_Status = issue_Status;
    }

    public Book(String bookCode, String book_Name, String author, String subject, String issue_Status, String issued_To, LocalDateTime issued_Date, LocalDateTime returned_date) {
        this.bookCode = bookCode;
        bookName = book_Name;
        this.author = author;
        this.subject = subject;
        this.issue_Status = issue_Status;
        this.issued_To = issued_To;
        this.issued_Date = issued_Date;
        this.returned_date = returned_date;

    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    @Override
    public String toString() {
        return "" + bookCode +
                "," + bookName +
                "," + author +
                "," + subject +
                "," + issue_Status +
                "," + issued_To +
                "," + issued_Date +
                "," + returned_date +","
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