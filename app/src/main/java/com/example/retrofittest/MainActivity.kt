package com.example.retrofittest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofittest.retrofit.apiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val  TAG : String = "MainActivity"
    lateinit var  mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        setupRecyclerView()
        getDataFromApi()
    }

    private fun setupRecyclerView() {
        mainAdapter = MainAdapter(arrayListOf(), object : MainAdapter.OnAdapterListener {
            override fun onClick(result: MainModel.Result) {
                startActivity(Intent(this@MainActivity,DetailAcitivity::class.java).putExtra("detail_title",result.title).putExtra("detail_image",result.image))
            }


        })
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerVieww)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = mainAdapter
        }
    }

    private fun getDataFromApi() {
        apiService.endPoint.getData().enqueue(object : Callback<MainModel> {
            override fun onResponse(
                call: Call<MainModel>,
                response: Response<MainModel>
            ) {
                if (response.isSuccessful){
                    showDatas(response.body()!!)
                }
            }

            override fun onFailure(call: Call<MainModel>, t: Throwable) {
                printLog(t.toString())
            }

        })
    }

    private fun printLog(message: String) {
        Log.d(TAG,message)
    }

    private fun showDatas(data :MainModel){
        val results = data.result
        mainAdapter.setData(results)
//        for (d in results){
//            printLog("title ${d.title}")
//            printLog("title ${d.id}")
//            printLog("title ${d.image}")
//        }
    }

}