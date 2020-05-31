package com.megacom.httptest.http;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.megacom.httptest.models.Lot;
import com.squareup.okhttp.*;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

public class OkHttpHelper {

    public static OkHttpHelper getInstance() {
        return new OkHttpHelper();
    }

    private ObjectMapper om = new ObjectMapper();

    private OkHttpClient httpClient = new OkHttpClient();

    public void get() throws Exception {

        Request request = new Request.Builder()
                .url("http://localhost:8080/lot/get/8")
                .build();

        Response response = httpClient.newCall(request).execute();

        int code = response.code();
        System.out.println(code);

        if(response.isSuccessful()){
             Lot lot = om.readValue(response.body().string(), Lot.class);
            System.out.println(lot);
        }
    }

    public void post() throws Exception {

        Lot lot = new Lot();
        lot.setDescription("TestOkHttp");
        lot.setStart_date(new Date());
        lot.setEnd_date(new Date());
        lot.setMin_price(100);
        lot.setMax_price(1000);
        lot.setStep(50);

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), om.writeValueAsString(lot));

        Request request = new Request.Builder()
                .addHeader("Content-Type", "application/json")
                .url("http://localhost:8080/lot/save")
                .post(requestBody)
                .build();

        Response response = httpClient.newCall(request).execute();

        int code = response.code();
        System.out.println(code);

        if(response.isSuccessful()){
            lot = om.readValue(response.body().string(), Lot.class);
            System.out.println(lot);
        }
    }

    public void getList() throws Exception {
        Request request = new Request.Builder()
                .url("http://localhost:8080/lot/getList")
                .build();

        Response response = httpClient.newCall(request).execute();

        if(response.isSuccessful()){
            List<Lot> list = om.readValue(response.body().string(), new TypeReference<List<Lot>>() {});
            System.out.println(list);
        }
    }

    
}
