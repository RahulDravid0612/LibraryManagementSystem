package LibraryManagementSystem;

public class User {
    String Name;
    int User_Id;
    Double Fine_Amount;
    String Books_Issued;
    String Date_Issued;
    String Return_Date;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getUser_Id() {
        return User_Id;
    }

    public void setUser_Id(int user_Id) {
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

    public String getDate_Issued() {
        return Date_Issued;
    }

    public void setDate_Issued(String date_Issued) {
        Date_Issued = date_Issued;
    }

    public String getReturn_Date() {
        return Return_Date;
    }

    public void setReturn_Date(String return_Date) {
        Return_Date = return_Date;
    }
}
