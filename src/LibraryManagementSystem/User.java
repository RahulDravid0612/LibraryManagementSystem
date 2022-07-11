package LibraryManagementSystem;

import java.time.LocalDateTime;

public class User {
    String name;
    String user_Id;
    Double fine_Amount;
    String books_Issued;
    LocalDateTime date_Issued;
    LocalDateTime return_Date;

    public User(String name, String user_Id, Double fine_Amount, String books_Issued, LocalDateTime date_Issued, LocalDateTime return_Date) {
        this.name = name;
        this.user_Id = user_Id;
        this.fine_Amount = fine_Amount;
        this.books_Issued = books_Issued;
        this.date_Issued = date_Issued;
        this.return_Date = return_Date;
    }

    @Override
    public String toString() {
        return "" + name +
                "," + user_Id +
                "," + fine_Amount +
                "," + books_Issued +
                "," + date_Issued +
                "," + return_Date +","
                ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(String user_Id) {
        this.user_Id = user_Id;
    }

    public Double getFine_Amount() {
        return fine_Amount;
    }

    public void setFine_Amount(Double fine_Amount) {
        this.fine_Amount = fine_Amount;
    }

    public String getBooks_Issued() {
        return books_Issued;
    }

    public void setBooks_Issued(String books_Issued) {
        this.books_Issued = books_Issued;
    }

    public LocalDateTime getDate_Issued() {
        return date_Issued;
    }

    public void setDate_Issued(LocalDateTime date_Issued) {
        this.date_Issued = date_Issued;
    }

    public LocalDateTime getReturn_Date() {
        return return_Date;
    }

    public void setReturn_Date(LocalDateTime return_Date) {
        this.return_Date = return_Date;
    }
}
