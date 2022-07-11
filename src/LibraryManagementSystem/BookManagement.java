package LibraryManagementSystem;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

interface BookManagement {
   public ArrayList<Book> AddBook(ArrayList l1) throws IOException;
   public void ViewBooksList(ArrayList l1) throws IOException;
    public void ViewByBookCode(ArrayList l1);
    public ArrayList<Book> SortBook(ArrayList l1);
    public void CheckBookAvailability() throws IOException;
    public void MarkAsIssued() throws IOException;
    public void MarkAsReturned() throws IOException;
    public ArrayList<Book> DeleteBookByBookCode(ArrayList l1);
    public void GenerateReport() throws IOException;

}
