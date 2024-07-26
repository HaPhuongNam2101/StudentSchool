package manager;

import model.User;

import java.util.ArrayList;

public class UserManager implements IManager<User>{
    private ArrayList<User> users;
    public UserManager() {
        this.users = new ArrayList<>();
    }
    @Override
    public void add(User user) {
        users.add(user);
    }

    @Override
    public void remove(int id) {
    }

    @Override
    public int findIndexById(int id) {
        return -1;
    }

    @Override
    public void update(int id, User user) {
    }

    @Override
    public ArrayList<User> findAll() {
        return users;
    }

    public User findByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}

