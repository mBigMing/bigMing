package com.flowerfat.utiltool.Utils;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.util.Log;

/**
 * 1. permission
 *
 * 2. lesson：http://www.imooc.com/video/4041
 */
public class ContactsUtil {

    private ContactsUtil mContactsUtil ;

    public ContactsUtil() {

    }


    public static void getPhoneContacts(Context context) {
        ContentResolver cr = context.getContentResolver();
        try {
            Cursor c = cr.query(Contacts.CONTENT_URI, new String[]{Contacts._ID, Contacts.DISPLAY_NAME}, null, null, null) ;
            if(c != null){
                while (c.moveToNext()){
                    int id = c.getInt(c.getColumnIndex("_id"));
                    Log.i("info", "_id:"+id );
                    Log.i("info", "name:"+ c.getString(c.getColumnIndex("display_name")));
                    // 根据联系人id 查询电话号码
                    Cursor c1 = cr.query(Phone.CONTENT_URI, new String[]{Phone.NUMBER, Phone.TYPE}, Phone.CONTACT_ID+"="+id, null, null);
                    if(c1 != null){
                        while (c1.moveToNext()){
                            int type = c1.getInt(c1.getColumnIndex(Phone.TYPE));
                            if(type == Phone.TYPE_HOME){
                                Log.i("info", "家庭电话:"+c1.getString(c1.getColumnIndex(Phone.NUMBER)));
                            } else if(type == Phone.TYPE_MOBILE){
                                Log.i("info", "手机:"+c1.getString(c1.getColumnIndex(Phone.NUMBER) ));
                            }
                        }
                        c1.close();
                    }
                    // 根据联系人ID 查询邮箱地址
                    Cursor c2 = cr.query(Email.CONTENT_URI, new String[]{Email.DATA, Email.TYPE}, Email.CONTACT_ID+"="+id, null, null);
                    if(c2 != null){
                        while (c2.moveToNext()){
                            int type = c2.getInt(c2.getColumnIndex(Email.TYPE));
                            if(type == Email.TYPE_WORK){
                                Log.i("info", "工作邮箱:"+c2.getString(c2.getColumnIndex(Email.DATA) ));
                            }
                        }
                        c2.close();
                    }
                }
                c.close();
            }
        } catch (Exception e){
            return ;
        }
    }

    /**
     * insert
     * @param context nothing
     */
    public static void insertAContact(Context context){
        ContentResolver cr = context.getContentResolver();
        // insert one data into the contact
        ContentValues values = new ContentValues();
        Uri uri = cr.insert(RawContacts.CONTENT_URI, values);
        Long raw_contact_id = ContentUris.parseId(uri);
        values.clear();
        // insert the name
        values.put(StructuredName.RAW_CONTACT_ID, raw_contact_id);
        values.put(StructuredName.DISPLAY_NAME, "Name");
        values.put(StructuredName.MIMETYPE, StructuredName.CONTENT_ITEM_TYPE);
        cr.insert(Data.CONTENT_URI, values);
        // insert the phone
        values.clear();
        values.put(Phone.RAW_CONTACT_ID, raw_contact_id);
        values.put(Phone.NUMBER, "13888888888");
        values.put(Phone.MIMETYPE, Phone.CONTENT_ITEM_TYPE);
        cr.insert(Data.CONTENT_URI, values);
    }


}
