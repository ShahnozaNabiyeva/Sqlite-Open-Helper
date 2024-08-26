package com.shahnoza.sqliteopenhelpermalumotqoshishvaolish.database

import com.shahnoza.sqliteopenhelpermalumotqoshishvaolish.models.MyUser
import java.util.ArrayList

interface MyPlan {
    // Database da bo'lishi kerak bo'lagan qo'shimcha imkoniyatlar

    //userni qo'shish uchun
    fun addUser(muUser: MyUser)

    //userlarni olish uchun
    fun getAllUsers():ArrayList<MyUser>


}