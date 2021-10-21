package com.example.retrofitpostdataresponse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    APIInterface apiInterface;
    //TextView responseText;
    RecyclerView recyclerView;
    List<Datum> datumList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //responseText = (TextView) findViewById(R.id.responseText);

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        datumList = new ArrayList<>();
        apiInterface=APIClient.getClient().create(APIInterface.class);

        /*User user = new User("morpheus", "leader");
        Call<User> call1 = apiInterface.createUser(user);
        call1.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user1 = response.body();

                Toast.makeText(getApplicationContext(), " name:" + user1.name + "\njob:" + user1.job + "\nid:" + user1.id + "\ncreatedAt:" + user1.createdAt, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                call.cancel();
            }
        });*/


       /* *//**
         POST name and job Url encoded.
         **/
//        Call<UserList> call3 = apiInterface.doCreateUserWithField(1,5,10);
//        call3.enqueue(new Callback<UserList>() {
//            @Override
//            public void onResponse(Call<UserList> call, Response<UserList> response) {
//                UserList userList = response.body();
//                Integer text = userList.page;
//                Integer total = userList.total;
//                Integer totalPages = userList.totalPages;
//                List<UserList.Data> datumList = userList.data;
//                Toast.makeText(getApplicationContext(), text + " page\n" + total + " total\n" + totalPages + " totalPages\n", Toast.LENGTH_SHORT).show();
//
//                for (UserList.Data datum : datumList) {
//                    Toast.makeText(getApplicationContext(), "id : " + datum.id + " name: " + datum.first_name + " " + datum.last_name + " avatar: " + datum.avatar, Toast.LENGTH_SHORT).show();
//
//                    String strCall3Response = "id : " + datum.id + " name: " + datum.first_name + " " + datum.last_name + " avatar: " + datum.avatar;
//                    responseText.append(strCall3Response);
//
//                }

        Call<GetCategoryData> call3 = apiInterface.doCreateUserWithField();
        call3.enqueue(new Callback<GetCategoryData>() {
            @Override
            public void onResponse(Call<GetCategoryData> call, Response<GetCategoryData> response) {
                GetCategoryData userList = response.body();
                Toast.makeText(getApplicationContext(), "df", Toast.LENGTH_SHORT).show();


                try {
                    List<Datum> data = userList.getData();

                    for (int i=0;i<data.size();i++){
                        String CId=data.get(i).getcId();
                        String CatName=data.get(i).getCatName();
                        String Status=data.get(i).getStatus();
                        String CreateDate=data.get(i).getCreateDate();
                        Log.d("CId :",CId);
                        Log.d("CatName : ",CatName);
                        Log.d("Status : ",Status);
                        Log.d("CreateDate :",CreateDate);
                        datumList.add(new Datum(CatName,Status,CreateDate));
                    }

                    recyclerView.setAdapter(new DemoAdapter(datumList));

                } catch (Exception e) {
                    e.printStackTrace();
                }

                // done

//                String status = userList.status;
//                String result = userList.result;
//                String message = userList.message;
//                List<UserList.Data> datumList = userList.data;
//                Toast.makeText(getApplicationContext(), status + " status\n" + result + " result\n" + message +" message\n", Toast.LENGTH_SHORT).show();
//
//                for (UserList.Data datum : datumList) {
//                    Toast.makeText(getApplicationContext(), "id : " + datum.CId + " name: " + datum.CatName + " " + datum.Status + " Status: " + datum.CreateDate, Toast.LENGTH_SHORT).show();
//
//                    *//*String strCall3Response = "id : " + datum.id + " name: " + datum.first_name + " " + datum.last_name + " avatar: " + datum.avatar;
//                    responseText.append(strCall3Response);*//*
//
//                }
            }

            @Override
            public void onFailure(Call<GetCategoryData> call, Throwable t) {
                call.cancel();
                Log.d("Retrofit Activity","Connect Failed");
            }
        });


    }

}