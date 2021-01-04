package com.rikihikmianto.rikicovid.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.rikihikmianto.rikicovid.R
import com.rikihikmianto.rikicovid.adapter.ProvinsiAdapter
import com.rikihikmianto.rikicovid.api.RetrofitClient
import com.rikihikmianto.rikicovid.model.ProvinsiResponse
import kotlinx.android.synthetic.main.activity_provinsi.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProvinsiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_provinsi)
        showProvinsi()
    }

    private fun showProvinsi() {
        rv_provinsi.setHasFixedSize(true)
        rv_provinsi.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.getProvinsi().enqueue(object :
            Callback<ArrayList<ProvinsiResponse>> {
            override fun onResponse(
                call: Call<ArrayList<ProvinsiResponse>>,
                response: Response<ArrayList<ProvinsiResponse>>
            ) {
                val list = response.body()
                val adapter = list?.let { ProvinsiAdapter(it) }
                rv_provinsi.adapter = adapter
            }

            override fun onFailure(call: Call<ArrayList<ProvinsiResponse>>, t: Throwable) {
                Toast.makeText(this@ProvinsiActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }
}