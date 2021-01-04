package com.rikihikmianto.rikicovid.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.rikihikmianto.rikicovid.R
import com.rikihikmianto.rikicovid.api.RetrofitClient
import com.rikihikmianto.rikicovid.model.IndonesiaResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showIndonesia()

        btn_provinsi.setOnClickListener {
            startActivity(Intent(this, ProvinsiActivity::class.java))
        }
    }
    private fun showIndonesia(){
        RetrofitClient.instance.getIndonesia().enqueue(object :
            Callback<ArrayList<IndonesiaResponse>> {
            override fun onResponse(
                call: Call<ArrayList<IndonesiaResponse>>,
                response: Response<ArrayList<IndonesiaResponse>>
            ) {
                val indonesia = response.body()?.get(0)
                val positif = indonesia?.positif
                val dirawat = indonesia?.dirawat
                val meninggal = indonesia?.meninggal
                val sembuh = indonesia?.sembuh

                tv_positif.text = positif
                tv_dirawat.text = dirawat
                tv_sembuh.text = sembuh
                tv_meninggal.text = meninggal
            }

            override fun onFailure(call: Call<ArrayList<IndonesiaResponse>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        }
        )
    }
}