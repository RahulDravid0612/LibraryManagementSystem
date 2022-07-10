package LibraryManagementSystem;

import java.time.LocalDateTime;

public class User {
    String Name;
    String User_Id;
    Double Fine_Amount;
    String Books_Issued;
    LocalDateTime Date_Issued;
    LocalDateTime Return_Date;

    public User(String name, String user_Id, Double fine_Amount, String books_Issued, LocalDateTime date_Issued, LocalDateTime return_Date) {
        Name = name;
        User_Id = user_Id;
        Fine_Amount = fine_Amount;
        Books_Issued = books_Issued;
        Date_Issued = date_Issued;
        Return_Date = return_Date;
    }

    @Override
    public String toString() {
        return "" + Name +
                "," + User_Id +
                "," + Fine_Amount +
                "," + Books_Issued +
                "," + Date_Issued +
                "," + Return_Date+","
                ;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUser_Id() {
        return User_Id;
    }

    public void setUser_Id(String user_Id) {
        User_Id = user_Id;
    }

    public Double getFine_Amount() {
        return Fine_Amount;
    }

    public void setFine_Amount(Double fine_Amount) {
        Fine_Amount = fine_Amount;
    }

    public String getBooks_Issued() {
        return Books_Issued;
    }

    public void setBooks_Issued(String books_Issued) {
        Books_Issued = books_Issued;
    }

    public LocalDateTime getDate_Issued() {
        return Date_Issued;
    }

    public void setDate_Issued(LocalDateTime date_Issued) {
        Date_Issued = date_Issued;
    }

    public LocalDateTime getReturn_Date() {
        return Return_Date;
    }

    public void setReturn_Date(LocalDateTime return_Date) {
        Return_Date = return_Date;
    }
}
