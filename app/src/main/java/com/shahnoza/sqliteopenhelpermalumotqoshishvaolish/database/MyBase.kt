package com.shahnoza.sqliteopenhelpermalumotqoshishvaolish.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.shahnoza.sqliteopenhelpermalumotqoshishvaolish.models.MyUser
import kotlin.collections.ArrayList


const val TABLE_NAME="users"
const val ID="id"
const val NAME="name"
const val SURNAME="surname"

class MyBase(context: Context):SQLiteOpenHelper(context,"Sqlite.db",null,1) ,MyPlan{
    override fun onCreate(db: SQLiteDatabase?) {
      // databaselarni tablisalarini yaratish uchun kodlar yoziladi
        val query="create table $TABLE_NAME($ID integer primary key autoincrement not null,$NAME text not null,$SURNAME text not null)"
        db?.execSQL(query)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {


    }

    override fun addUser(muUser: MyUser) {
        val write=this.writableDatabase
        val contentValue=ContentValues()
        // id avtomatik ravishda oshib borish hisobiga uni qo'shish shart emas
        contentValue.put("$NAME",muUser.name)
        contentValue.put("$SURNAME",muUser.surname)
        write.insert("$TABLE_NAME",null,contentValue)
        write.close()


    }

    override fun getAllUsers(): ArrayList<MyUser> {
        val reader=this.readableDatabase //basedan malumotni o'qib olish
        val list=ArrayList<MyUser>() // basedan olingan ma'lumotni listga joylash uchun
        val query="select * from $TABLE_NAME" // SQLite helperga so'rov yuborish
        val cursor=reader.rawQuery(query,null)
        if (cursor.moveToFirst()){
            do {

                val myUser=MyUser(cursor.getInt(0),cursor.getString(1),cursor.getString(2))
                list.add(myUser)
            }while (cursor.moveToNext())

        }
        return list
    }


}