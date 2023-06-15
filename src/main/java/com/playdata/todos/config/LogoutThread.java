package com.playdata.todos.config;

import com.playdata.todos.dao.UserDao;
import com.playdata.todos.dto.User;

public class LogoutThread extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            UserDao.me = null;
        }
    }
}
