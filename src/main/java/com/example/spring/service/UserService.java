package com.example.spring.service;

import com.example.spring.dao.LoginLogDao;
import com.example.spring.dao.UserDao;
import com.example.spring.domain.LoginLog;
import com.example.spring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
  @Autowired
  private UserDao userDao;

  @Autowired
  private LoginLogDao loginLogDao;

  public boolean hasMatchUser(String userName, String password) {
    int matchCount = userDao.getMatchCount(userName, password);
    return matchCount > 0;
  }

  public User findUserByUserName(String userName) {
    return userDao.findUserByUserName(userName);
  }

  @Transactional
  public void loginSuccess(User user) {
    user.setCredits(5 + user.getCredits());
    LoginLog loginLog = new LoginLog();
    loginLog.setUserId(user.getUserId());
    loginLog.setIp(user.getLastIp());
    loginLog.setLoginDate(user.getLastVisit());
    userDao.updateLoginInfo(user);
    loginLogDao.insertLoginLog(loginLog);
  }
}
