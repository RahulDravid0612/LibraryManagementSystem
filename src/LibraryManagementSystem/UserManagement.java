package LibraryManagementSystem;

import java.io.IOException;
import java.util.ArrayList;

interface UserManagement extends BookManagement {

    public ArrayList AddUser(ArrayList u1) throws IOException;

    public ArrayList<User> DeleteUser(ArrayList u1);

    public void Exit();
}
