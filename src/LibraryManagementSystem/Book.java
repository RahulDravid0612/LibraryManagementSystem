package LibraryManagementSystem;

import java.time.LocalDateTime;

public class Book {
    String Book_Code;
    String Book_Name;
    String Author;

    String Subject;
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

    public Book(String book_Code, String book_Name, String author, String subject,String issued_To, LocalDateTime issued_Date, LocalDateTime returned_date) {
        Book_Code = book_Code;
        Book_Name = book_Name;
        Author = author;
        Subject = subject;
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
        return "Book{" +
                "Book_Code='" + Book_Code + '\'' +
                ", Book_Name='" + Book_Name + '\'' +
                ", Author='" + Author + '\'' +
                ", Subject='" + Subject + '\'' +
                ", Issued_To='" + Issued_To + '\'' +
                ", Issued_Date=" + Issued_Date +
                ", Returned_date=" + Returned_date +
                '}';
    }

}
