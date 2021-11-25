package com.a7medelnoor.androiddevtest.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.a7medelnoor.androiddevtest.R
import com.a7medelnoor.androiddevtest.ui.adapter.AndroidDevAdapter
import com.a7medelnoor.androiddevtest.ui.data.api.ApiClient
import com.a7medelnoor.androiddevtest.ui.data.model.response.BaseResponse
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import retrofit2.Response

class HomeFragment : Fragment() {
    private lateinit var androidDevRecyclerView: RecyclerView
    private lateinit var androidDevAdapter: AndroidDevAdapter
    private  var androidBaseResponse= ArrayList<BaseResponse>()
    private lateinit var apiClient: ApiClient
    private  val TAG = "HomeFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_home, container, false)
        androidDevRecyclerView = view.findViewById(R.id.recyclerView)
        androidDevRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = AndroidDevAdapter(androidBaseResponse, context)
        }

        getBaseResponseData()
        return  view
    }

    private fun getBaseResponseData() {
        apiClient = ApiClient()
        apiClient.getAndroidDevServices().getApiResponse().enqueue(object : retrofit2.Callback<List<BaseResponse>>{
            override fun onResponse(
                call: retrofit2.Call<List<BaseResponse>>,
                response: Response<List<BaseResponse>>
            ) {
                Log.d(TAG,"LLLLLLLLLLLLLLL"+response.body())

            }

            override fun onFailure(call: retrofit2.Call<List<BaseResponse>>, t: Throwable) {
                Log.d(TAG,"LLLLLLLLLLLLLLL"+t.message)
            }


        })}

}