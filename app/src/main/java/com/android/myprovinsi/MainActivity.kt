package com.android.myprovinsi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.myprovinsi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), DetailInterface {
    private lateinit var rvProvinsi: RecyclerView
    private val list = ArrayList<Provinsi>()

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvProvinsi = findViewById(R.id.rv_provinsi)
        rvProvinsi.setHasFixedSize(true)

        list.addAll(getListProvinsi())
        showRecyclerList()
    }
    private fun getListProvinsi(): ArrayList<Provinsi> {
        val dataName = resources.getStringArray(R.array.data_provinsi_names)
        val dataDescription = resources.getStringArray(R.array.data_provinsi_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_provinsi_logos)
        val listProvinsi = ArrayList<Provinsi>()
        for (i in dataName.indices) {
            val provinsi = Provinsi(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listProvinsi.add(provinsi)
        }
        return listProvinsi
    }

    private fun showRecyclerList() {
        rvProvinsi.layoutManager = LinearLayoutManager(this)
        val listProvinsiAdapter = ListProvinsiAdapter(list, this@MainActivity)
        rvProvinsi.adapter = listProvinsiAdapter
    }

    override fun getDetail(nameProvinsi: String, descProvinsi: String, logoProvinsi: Int) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("name", nameProvinsi)
        intent.putExtra("desc", descProvinsi)
        intent.putExtra("poto", logoProvinsi)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this,AboutMeActivity::class.java)
        startActivity(intent)
        return super.onOptionsItemSelected(item)
    }
}