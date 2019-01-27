package com.example.csdc.greendaotest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.greenrobot.greendao.AbstractDaoMaster;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(getApplicationContext(),"lqw.db",null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        DaoSession daoSession = daoMaster.newSession();

        UserDao userDao = daoSession.getUserDao();

        //插入数据
        User user1 = new User(null,"刘奇伟1","奇伟1");
        userDao.insert(user1);
        User user2 = new User(null,"刘奇伟2","奇伟2");
        userDao.insert(user2);
        User user3 = new User(null,"刘奇伟3","奇伟3");
        userDao.insert(user3);
        User user4 = new User(null,"刘奇伟4","奇伟4");
        userDao.insert(user4);
        User user5 = new User(null,"刘奇伟5","奇伟5");
        userDao.insert(user5);

        //查询
        List<User> userList = userDao.queryBuilder().where(UserDao.Properties.Id.le(5)).build().list();
        for(User u : userList){
            //删除数据
            //userDao.delete(user1);
            Log.d("lqw","name: "+ u.getUserName() + "\n"+ "nickName: "+ u.getNickName());
        }

        //更新数据
        User user = userDao.queryBuilder().where(UserDao.Properties.Id.eq(3)).unique();
        if(user == null){
            Toast.makeText(this, "该条数据不存在", Toast.LENGTH_SHORT).show();
        }else {
            user.setUserName("到哈市");
            userDao.update(user);
        }
        //查询
        List<User> userList1 = userDao.queryBuilder().where(UserDao.Properties.Id.le(5)).build().list();
        for(User u : userList1){
            //删除数据
            //userDao.delete(user1);
            Log.d("lqw","name: "+ u.getUserName() + "\n"+ "nickName: "+ u.getNickName());
        }
    }

}
