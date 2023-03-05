package com.qacart.todo.utils;

import com.github.javafaker.Faker;
import com.qacart.todo.objects.User;

public class UserUtils {
    public static User generateRandomUser(){
        String fisrstName = new Faker().name().firstName();
        String lasttName = new Faker().name().lastName();
        String emailtName = new Faker().internet().emailAddress();
        String passwordtName = new Faker().internet().password();
        User user = new User(fisrstName,lasttName,emailtName,passwordtName);
        return user;
    }
}
