package LibraryManagementSystem;

import java.util.ArrayList;

interface UserManagement extends BookManagement {

    public ArrayList<User> AddUser(ArrayList u1);

    public ArrayList<User> DeleteUser(ArrayList u1);

    public void Exit();
}
