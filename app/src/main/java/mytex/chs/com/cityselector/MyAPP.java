package mytex.chs.com.cityselector;

import android.app.Application;

import mytex.chs.com.cityselector.db.DBManager;

/**
 * 作者：chs on 2015/12/26 17:35
 * 邮箱：657083984@qq.com
 */
public class MyAPP extends Application {
    private DBManager dbHelper;
    @Override
    public void onCreate() {
        super.onCreate();
        //导入数据库
        dbHelper = new DBManager(this);
        dbHelper.openDatabase();
//        dbHelper.closeDatabase();
    }
}
