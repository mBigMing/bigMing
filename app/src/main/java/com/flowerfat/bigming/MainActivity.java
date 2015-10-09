package com.flowerfat.bigming;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.flowerfat.utiltool.Utils.ContactsUtil;


public class MainActivity extends AppCompatActivity {


    GestureDetector mGestureDetector ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }





    public void buttonClick(View v){
        if(v.getId() == R.id.notification){
            notification();
        } else if(v.getId() == R.id.contacts){
            contacts();
        }
    }
    private void notification(){

    }
    private void contacts(){
        // 查询
//        ContactsUtil.getPhoneContacts(this);
        // 插入
        ContactsUtil.insertAContact(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
