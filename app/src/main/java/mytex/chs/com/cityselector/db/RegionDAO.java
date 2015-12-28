package mytex.chs.com.cityselector.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import mytex.chs.com.cityselector.bean.RegionInfo;

public class RegionDAO {
	
	public static List<RegionInfo> getProvencesOrCityOnId(int id){
		SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(DBManager.DB_PATH + "/" + DBManager.DB_NAME, null);
		List<RegionInfo> regionInfos = new ArrayList<RegionInfo>();//String.valueOf(type)
		Cursor cursor = db.rawQuery("select * from REGIONS where _id="+id,null);
		while (cursor.moveToNext()) {
			RegionInfo regionInfo = new RegionInfo();
			int _id = cursor.getInt(cursor
					.getColumnIndex("_id"));
			int parent = cursor.getInt(cursor
					.getColumnIndex("parent"));
			String name = cursor.getString(cursor
					.getColumnIndex("name"));
			int type1 = cursor.getInt(cursor
					.getColumnIndex("type"));
			regionInfo.setId(_id);
			regionInfo.setParent(parent);
			regionInfo.setName(name);
			regionInfo.setType(type1);
			regionInfos.add(regionInfo);
		}
		cursor.close();
		db.close();
		return regionInfos;
	}
	public static List<RegionInfo> getProvencesOrCity(int type){
		SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(DBManager.DB_PATH + "/" + DBManager.DB_NAME, null);
		List<RegionInfo> regionInfos = new ArrayList<RegionInfo>();//String.valueOf(type)
		Cursor cursor = db.rawQuery("select * from REGIONS where type="+type,null);
		while (cursor.moveToNext()) {
			RegionInfo regionInfo = new RegionInfo();
			int _id = cursor.getInt(cursor
					.getColumnIndex("_id"));
			int parent = cursor.getInt(cursor
					.getColumnIndex("parent"));
			String name = cursor.getString(cursor
					.getColumnIndex("name"));
			int type1 = cursor.getInt(cursor
					.getColumnIndex("type"));
			regionInfo.setId(_id);
			regionInfo.setParent(parent);
			regionInfo.setName(name);
			regionInfo.setType(type1);
			regionInfos.add(regionInfo);
		}
		cursor.close();
		db.close();
		return regionInfos;
	}
	
	public static List<RegionInfo> getProvencesOrCityOnParent(int parent){
		SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(DBManager.DB_PATH + "/" + DBManager.DB_NAME, null);
		List<RegionInfo> regionInfos = new ArrayList<RegionInfo>();//String.valueOf(type)
		Cursor cursor = db.rawQuery("select * from REGIONS where parent="+parent,null);
		while (cursor.moveToNext()) {
			RegionInfo regionInfo = new RegionInfo();
			int _id = cursor.getInt(cursor
					.getColumnIndex("_id"));
			int parent1 = cursor.getInt(cursor
					.getColumnIndex("parent"));
			String name = cursor.getString(cursor
					.getColumnIndex("name"));
			int type = cursor.getInt(cursor
					.getColumnIndex("type"));
			regionInfo.setId(_id);
			regionInfo.setParent(parent1);
			regionInfo.setName(name);
			regionInfo.setType(type);
			regionInfos.add(regionInfo);
		}
		cursor.close();
		db.close();
		return regionInfos;
	}
	
	
	//插入  ，不用
	public static void insertRegion(SQLiteDatabase db, RegionInfo ri) {
		ContentValues values = new ContentValues();
		values.put("parent", ri.getParent());
		values.put("name", ri.getName());
		values.put("type", ri.getType());
		db.insert("REGIONS", null, values);
	}

	//返回所有的省市信息
	public static List<RegionInfo> queryAllInfo() {
		SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(DBManager.DB_PATH + "/" + DBManager.DB_NAME, null);
		List<RegionInfo> regionInfos = new ArrayList<RegionInfo>();
		Cursor cursor = db.rawQuery("select * from REGIONS", null);
		while (cursor.moveToNext()) {
			RegionInfo regionInfo = new RegionInfo();
			int _id = cursor.getInt(cursor
					.getColumnIndex("_id"));
			int parent = cursor.getInt(cursor
					.getColumnIndex("parent"));
			String name = cursor.getString(cursor
					.getColumnIndex("name"));
			int type = cursor.getInt(cursor
					.getColumnIndex("type"));
			regionInfo.setId(_id);
			regionInfo.setParent(parent);
			regionInfo.setName(name);
			regionInfo.setType(type);
			
			
			/*kcontent = cursor.getString(cursor
					.getColumnIndex("remarkcontent"));
			String issettingremind = cursor.getString(cursor
					.getColumnIndex("issettingremind"));
			String isdaoqi = cursor.getString(cursor.getColumnIndex("isdaoqi"));
			int _id = cursor.getInt(cursor.getColumnIndex("_id"));
			remind.set_id(_id);

			Integer netid = cursor.getInt(cursor.getColumnIndex("netid"));
			remind.setNetid(netid);

			Integer starcount = cursor.getInt(cursor
					.getColumnIndex("starcount"));
			remind.setStarcount(starcount);

			long createtime = cursor*//*.getLong(cursor
					.getColumnIndex("createtime"));
			remind.setCreatetime(createtime);

			String remind_time_format = cursor.getString(cursor
					.getColumnIndex("remind_time_format"));
			remind.setRemind_time_format(remind_time_format);*/

			/*remind.setCustomerName(customerName);
			remind.setIszhuanshu(iszhuanshu);
			remind.setProductName(productName);
			remind.setProductStyle(productStyle);
			remind.setLastfournumber(lastfournumber);
			remind.setBuymoney(buymoney);
			remind.setBuydate(buydate);
			remind.setDaoqidate(daoqidate);
			remind.setDaoqi_remind_time(daoqi_remind_time);
			remind.setRepeat_remind_style(repeat_remind_style);
			remind.setRemarkcontent(remarkcontent);
			remind.setIssettingremind(issettingremind);
			remind.setIsdaoqi(isdaoqi);*/
			
			
			regionInfos.add(regionInfo);
		}
		cursor.close();
		db.close();
		return regionInfos;
	}

	public static RegionInfo querySingleRemind(SQLiteDatabase db, int _id) {
		String sql = "select * from remindtable where _id =" + _id;
		Cursor cursor = db.rawQuery(sql, null);
		RegionInfo remind = null;
		if (cursor.moveToNext()) {
			
			
			/*
			remind = new TimeRemind();
			String customerName = cursor.getString(cursor
					.getColumnIndex("customerName"));
			String iszhuanshu = cursor.getString(cursor
					.getColumnIndex("iszhuanshu"));
			String productName = cursor.getString(cursor
					.getColumnIndex("productName"));
			String productStyle = cursor.getString(cursor
					.getColumnIndex("productStyle"));
			String lastfournumber = cursor.getString(cursor
					.getColumnIndex("lastfournumber"));
			String buymoney = cursor.getString(cursor
					.getColumnIndex("buymoney"));
			String buydate = cursor.getString(cursor.getColumnIndex("buydate"));
			String daoqidate = cursor.getString(cursor
					.getColumnIndex("daoqidate"));
			String daoqi_remind_time = cursor.getString(cursor
					.getColumnIndex("daoqi_remind_time"));
			String repeat_remind_style = cursor.getString(cursor
					.getColumnIndex("repeat_remind_style"));
			String remarkcontent = cursor.getString(cursor
					.getColumnIndex("remarkcontent"));
			String issettingremind = cursor.getString(cursor
					.getColumnIndex("issettingremind"));
			String isdaoqi = cursor.getString(cursor.getColumnIndex("isdaoqi"));
			int id = cursor.getInt(cursor.getColumnIndex("_id"));
			remind.set_id(id);

			Integer netid = cursor.getInt(cursor.getColumnIndex("netid"));
			remind.setNetid(netid);

			Integer starcount = cursor.getInt(cursor
					.getColumnIndex("starcount"));
			remind.setStarcount(starcount);

			long createtime = cursor.getLong(cursor
					.getColumnIndex("createtime"));
			remind.setCreatetime(createtime);

			String remind_time_format = cursor.getString(cursor
					.getColumnIndex("remind_time_format"));
			remind.setRemind_time_format(remind_time_format);

			remind.setCustomerName(customerName);
			remind.setIszhuanshu(iszhuanshu);
			remind.setProductName(productName);
			remind.setProductStyle(productStyle);
			remind.setLastfournumber(lastfournumber);
			remind.setBuymoney(buymoney);
			remind.setBuydate(buydate);
			remind.setDaoqidate(daoqidate);
			remind.setDaoqi_remind_time(daoqi_remind_time);
			remind.setRepeat_remind_style(repeat_remind_style);
			remind.setRemarkcontent(remarkcontent);
			remind.setIssettingremind(issettingremind);
			remind.setIsdaoqi(isdaoqi);

		*/}
		cursor.close();
		return remind;
	}

	public static void deleteRegion(int _id, SQLiteDatabase db) {
		db.execSQL("delete from remindtable where _id = ?",
				new Object[] { _id });
	}

}
