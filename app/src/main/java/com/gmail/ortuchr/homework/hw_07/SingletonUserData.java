package com.gmail.ortuchr.homework.hw_07;

import android.os.SystemClock;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

class SingletonUserData{
    private static final List<User> userData = new ArrayList<>();

    private SingletonUserData() {
    }

    public static List<User> getUserData() {
        if (userData.isEmpty()) {
            userData.add(new User(1,"Иван", "Иванов", "https://hornews.com/upload/images/akter.jpeg.pagespeed.ce.cjK81FuZxR.jpg"));
            userData.add(new User(2,"Петр", "Петров", "https://avatarko.ru/img/kartinka/8/muzhchina_glaza_7472.jpg"));
            userData.add(new User(3,"Василий", "Теркин", "http://batona.net/uploads/posts/2015-06/1434426753_1.jpg"));
            userData.add(new User(4,"Анатолий", "Круглый", "https://www.theplace.ru/archive/Sergey_bezrukov/img/4-84.jpg"));
            userData.add(new User(5,"Антон", "Климов", "https://f3.mylove.ru/FLDheGrmMH.jpg"));
            userData.add(new User(6,"Филипп", "Наумов", "https://images.wallpaperscraft.ru/image/tom_khardi_muzhchina_akter_znamenitost_101537_300x168.jpg"));
            userData.add(new User(7,"Григорий", "Топчун", "http://lemonade.style/wp-content/uploads/2018/10/1630-886x668.jpg"));
            userData.add(new User(8,"Максим", "Белый", "https://www.famousbirthdays.com/faces/durov-pavel-image.jpg"));
            userData.add(new User(9,"Владимир", "Пржевальский", "http://www.milenerd.com/wp-content/uploads/2017/08/clooney.jpg"));
        }
        return userData;
    }

    public static void deleteUser(Long idDeleteUser) {
        Iterator<User> iterator = userData.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == idDeleteUser) {
                iterator.remove();
            }
        }
    }

    public static void addUser(Long id, String name, String surname, String url) {
        userData.add(new User(id, name, surname, url));
    }

    public static void updateUser(Long id, String name, String surname, String url) {
        for (User user : userData) {
            if (user.getId() == id) {
                int index = userData.indexOf(user);
                userData.set(index, new User(id, name, surname, url));
            }
        }
    }
}
