package com.example.myapp.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.R
import com.example.myapp.adapter.RecyclerAdapter
import com.example.myapp.interfaceapi.ApiInterface
import com.example.myapp.model.DataModel
import com.example.myapp.model.DataModelItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductFragment : Fragment() {
    // Recycler View
    lateinit var recyclerView: RecyclerView
    // List
    lateinit var list: ArrayList<DataModelItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

         recyclerView = findViewById(R.id.recyclerView)

        list = ArrayList()


        val layoutManager = LinearLayoutManager(this)

        val adapter = RecyclerAdapter(list, this)

        val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()


        val api:ApiInterface=retrofit.create(ApiInterface::class.java)

        val call:Call<DataModel> = api.getData()

        call.enqueue(object : Callback<DataModel?>{
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<DataModel?>, response: Response<DataModel?>) {
                if (response.isSuccessful){
                    list.clear()

                    for (myData in response.body()!!){
                        list.add(myData)
                    }

                    adapter.notifyDataSetChanged()
                    recyclerView.adapter = adapter

                }
            }
            override fun onFailure(call: Call<DataModel?>, t: Throwable) {
                Toast.makeText(requireActivity(), "Some Error", Toast.LENGTH_SHORT).show()

            }
        })
    }

}