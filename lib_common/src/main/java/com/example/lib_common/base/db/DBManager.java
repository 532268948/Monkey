package com.example.lib_common.base.db;

import android.content.Context;

import com.example.lib_common.base.db.dao.MusicBeforeDao;
import com.example.lib_common.base.db.dao.UserDaoUtil;
import com.example.lib_common.base.db.entity.DaoMaster;
import com.example.lib_common.base.db.entity.DaoSession;

/**
 * @author: tianhuaye
 * date:   2018/11/15 15:20
 * description:
 */
public class DBManager {
    private static DBManager instance;
    private DaoMaster daoMaster;
    private DaoSession daoSession = null;
    private DaoMaster.DevOpenHelper devOpenHelper;
    private UserDaoUtil userDao;
    private MusicBeforeDao musicBeforeDao;

    private DBManager(Context context) {
        if (daoMaster == null) {
            devOpenHelper = new DaoMaster.DevOpenHelper(context, "monkey", null);
            daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        }
    }

    public static DBManager getInstance(Context context) {
        if (instance == null) {
            synchronized (DBManager.class) {
                if (instance == null) {
                    instance = new DBManager(context.getApplicationContext());
                }
            }
        }
        return instance;
    }


    /**
     * 得到用户信息数据表
     *
     * @return
     */
    public UserDaoUtil getUserDB() {
        if (userDao == null) {
            userDao = new UserDaoUtil(instance, getDaoSession());
        }
        return userDao;
    }

    /**
     * 得到睡前小曲数据表
     *
     * @return
     */
    public MusicBeforeDao getMusicBeforeDB() {
        if (musicBeforeDao == null) {
            musicBeforeDao = new MusicBeforeDao(instance, getDaoSession());
        }
        return musicBeforeDao;
    }

    public DaoSession getDaoSession() {
        if (daoSession == null) {
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }

    /**
     * 关闭DaoSession
     */
    private void closeDaoSession() {
        if (daoSession != null) {
            daoSession.clear();
            daoSession = null;
        }
    }


    /**
     * 关闭Helper
     */
    private void closeHelper() {
        if (devOpenHelper != null) {
            devOpenHelper.close();
            devOpenHelper = null;
        }
    }

    /**
     * 关闭所有的操作
     */
    public void closeConnection() {
        closeDaoSession();
        closeHelper();
    }

}
