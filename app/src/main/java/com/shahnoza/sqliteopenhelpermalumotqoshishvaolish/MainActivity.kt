package com.shahnoza.sqliteopenhelpermalumotqoshishvaolish

import android.os.Bundle
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity

import com.shahnoza.sqliteopenhelpermalumotqoshishvaolish.database.MyBase
import com.shahnoza.sqliteopenhelpermalumotqoshishvaolish.databinding.ActivityMainBinding
import com.shahnoza.sqliteopenhelpermalumotqoshishvaolish.models.MyUser

import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var list: ArrayList<MyUser>
    lateinit var myBase: MyBase
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)



        list=ArrayList()
        myBase= MyBase(this)


        // databasega saqlash
        binding.btnSave.setOnClickListener {
            val name=binding.edtName.text.toString()
            val suname=binding.edtSurname.text.toString()
            myBase.addUser(MyUser(name,suname))
            Toast.makeText(this, "Saqlandi!", Toast.LENGTH_SHORT).show()
            binding.edtName.text.clear()
            binding.edtSurname.text.clear()
        }


        binding.btnGetData.setOnClickListener {

            list.addAll(myBase.getAllUsers())
            var data:String = ""
            list.forEach {
                data +="\nId: ${it.id}\nName:${it.name}\nSurname${it.surname}"
            }
            binding.txtView.text=data



        }


































    }
}