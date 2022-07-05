package LibraryManagementSystem;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

interface BookManagement {
   public ArrayList<Book> AddBook() throws IOException;
   public void ViewBooksList(ArrayList l1) throws IOException;
    public void ViewByBookCode();
    public void SortBook();
    public void MarkAsIssued();
    public void MarkAsReturned();
    public void DeleteBookByBookCode();
    public void GenerateReport();

}
