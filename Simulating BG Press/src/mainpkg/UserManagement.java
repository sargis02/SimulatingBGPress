package mainpkg;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserManagement {

    private final List<User> userList;

    public UserManagement() {
        this.userList = new ArrayList<>();
    }

    public void registerUser(String id, String name, String gender, String email, String phone, String role) {
        User newUser = new User(id, name, gender, email, phone, role);
        userList.add(newUser);
    }


    public void deleteUser(String userId) {
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId().equals(userId)) {
                iterator.remove();
                break;
            }
        }
    }

    public List<User> getAllUsers() {
        return userList;
    }

    public void saveUserListToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (User user : userList) {
                writer.write(user.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving user data to file: " + e.getMessage());
        }
    }
}
