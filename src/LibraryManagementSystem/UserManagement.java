package LibraryManagementSystem;

import java.util.ArrayList;

interface UserManagement extends BookManagement {

    public ArrayList<User> AddUser();

    public void Exit();
}
