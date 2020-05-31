package com.megacom.httptest;


import com.megacom.httptest.http.ApacheClient;
import com.megacom.httptest.http.OkHttpHelper;
import com.squareup.okhttp.OkHttpClient;

public class Main {

	public static void main(String[] args) {

	//	ApacheClient.getInstance().testPost();

        try {
           // OkHttpHelper.getInstance().get();
            //OkHttpHelper.getInstance().post();
            OkHttpHelper.getInstance().getList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
