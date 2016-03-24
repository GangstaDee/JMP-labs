package com.jmp.rest.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on 3/21/2016.
 */
public class UserStorage {

    private static int size = 0;
    private static List<User> users = Collections.synchronizedList(new ArrayList<User>());

    public static void addUser(User user) {
        size++;
        user.setId(size);
        users.add(user);
    }

    public static User readUser(int id) {
        List<User> resultUserList = users.stream().filter(user -> id == user.getId()).collect(Collectors.toList());
        if (resultUserList.size() != 1) {
            return null;
        }
        return resultUserList.get(0);
    }

    public static boolean deleteUser(int id) {
        return users.removeIf(user -> id == user.getId());
    }

    public static boolean updateUser(int id, User updated) {
        User old = readUser(id);
        if(old == null)
            return false;
        old.setFirstName(updated.getFirstName());
        old.setLastName(updated.getLastName());
        old.setLogin(updated.getLogin());
        old.setEmail(updated.getEmail());
        return true;
    }
}
