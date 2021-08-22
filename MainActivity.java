package com.e.myzipcoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.e.myzipcoe.adapterclass.AdapterClass;

import com.e.myzipcoe.modelclass.ModelClassZIp;
import com.valdesekamdem.library.mdtoast.MDToast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
//    private List<Movie> movieList = new ArrayList<>();
//    private RecyclerView recyclerView;
//    private MoviesAdapter mAdapter;


    private ModelClassZIp movieList;
    private RecyclerView recyclerView;
    private AdapterClass mAdapter;
    private List<ModelClassZIp.List> volleyList;
    private DividerItemDecoration dividerItemDecoration;


    EditText source;
    Button submit;
    private TextView msg, count;
    public static String token = "100f8bcd4626d373cade4e832633b5f7";
    public static String BASEURL = "http://edflow.cladev.com/api/users/zipcodes/";
    private static final String sour = "ANDROID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        volleyList = new ArrayList<>();

        movieList = new ModelClassZIp();


        msg = findViewById(R.id.msg);
        count = findViewById(R.id.count);
//        recyclerView = (RecyclerView) findViewById(R.id.recycler);
//       mAdapter = new AdapterClass(movieList,getApplicationContext());
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(mLayoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setAdapter(mAdapter);


//        recyclerView = (RecyclerView) findViewById(R.id.recycler);
//        mAdapter = new MoviesAdapter(movieList);
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(mLayoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setAdapter(mAdapter);

        // prepareMovieData();


        source = findViewById(R.id.source);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                   updatePassword();
//                recycleMethod();

                    RegisterMember();
                recycleMethodForVolley();


            }
        });
    }

    public void recycleMethod() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(llm);


//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setAdapter(mAdapter);
    }

    public void recycleMethodForVolley() {
//        volleyList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(llm);

       dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), llm.getOrientation());

        recyclerView.setHasFixedSize(true);
       recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        mAdapter = new AdapterClass(volleyList);
//        recyclerView.setAdapter(mAdapter);

    }


    public void updatePassword() {
        String sources = source.getText().toString();
        token = RetrofitClient.token;

        Log.d("hello", "before apply method");
        Call<ModelClassZIp> call = RetrofitClient
                .getInstance()
                .getApi()
                .update_password(token);
        Log.d("hell", "hiiii");
        call.enqueue(new Callback<ModelClassZIp>() {
            @Override
            public void onResponse(Call<ModelClassZIp> call, Response<ModelClassZIp> response) {
                ModelClassZIp list = response.body();

                if (response.isSuccessful()) {

                    AdapterClass ac = new AdapterClass(response.body().getData().getList());
                    recyclerView.setAdapter(ac);


                    String pincode = list.getData().getList().get(1).getZipcode().toString();
                    // if (response.body().getErrorCode().equals(200)) {
                    //                  UpdatePasswordModel updatePasswordModel=new UpdatePasswordModel();
//                    updatePasswordModel = response.body();
                    Log.d("res", "response - " + response.body());
                    //Toast.makeText(MainActivity.this, pincode, Toast.LENGTH_SHORT).show();
                    msg.setText(list.getMsg());
                    count.setText(list.getData().getCount().toString());
                    //mAdapter.setMovieList(list);


                    //         Log.d("jhff",mAdapter.toString() );

                }
            }

            @Override
            public void onFailure(Call<ModelClassZIp> call, Throwable t) {
                Log.d("hell", "exception :- " + t.getMessage());
                t.printStackTrace();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        //      call.enqueue(new Callback<ModelClassZIp>() {
//            @Override
//            public void onResponse(Call<ModelClassZIp> call, Response<ModelClassZIp> response) {
//                ModelClassZIp list = response.body();
//
//                if (response.isSuccessful()) {
//
//                    //  String pincode = list.getData().getList().get(1).getZipcode().toString();
//                    // if (response.body().getErrorCode().equals(200)) {
//                    //                  UpdatePasswordModel updatePasswordModel=new UpdatePasswordModel();
////                    updatePasswordModel = response.body();
//                    Log.d("res", "response - " + response.body());
//                    //Toast.makeText(MainActivity.this, pincode, Toast.LENGTH_SHORT).show();
//                    //    msg.setText(list.getMsg());
//                    // count.setText(list.getData().getCount().toString());
//
//                    mAdapter.setMovieList(list);
//
//
//                    //         Log.d("jhff",mAdapter.toString() );
//
//                }
//            }
//            @Override
//            public void onFailure(Call<ModelClassZIp> call, Throwable t) {
//                Log.d("hell", "exception :- " + t.getMessage());
//                t.printStackTrace();
//                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
//            }
        //   });

    }

    private void RegisterMember() {
        Log.d("ddd", "wee4");
//        pd=new ProgressDialog(this);
//        pd.setMessage("Adding Please wait.....");
//        pd.show();
        Log.d("ddd", "wee5");
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        StringRequest postRequest = new StringRequest(Request.Method.POST, BASEURL,
                response -> {
                    NextActivity(response);
                    Log.d("sffk","respo");
                },
                error -> {
                    // pd.dismiss();
                    Log.d("ddd", "wee6");
                    Log.d("ddd", error.getMessage());
                }

        ) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                //      params.put("Content-Type", "application/json; charset=UTF-8");
                params.put("source", sour);
                params.put("token", token);
                return params;
            }

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("source", source.getText().toString());
                params.put("token", token);
                Log.d("ddd", "wee1");
                return params;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(postRequest);
    }

    private void NextActivity(String response) {
        try {
                        Log.d("ddd", "wee");
                        JSONObject jsonObject = new JSONObject(response);
                        String error_code = jsonObject.getString("error");
                        JSONObject data_message = jsonObject.getJSONObject("data");
                        JSONArray jsonArray = data_message.getJSONArray("list");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
                            String id = object.getString("id");
                            String zipcode = object.getString("zipcode");

                            ModelClassZIp.List info = new ModelClassZIp.List();
Log.d("sffk",zipcode);
                            info.setId(Integer.valueOf(id));
                            info.setZipcode(Integer.valueOf(zipcode));
                            volleyList.add(info);
                            mAdapter = new AdapterClass(volleyList);
                            recyclerView.setAdapter(mAdapter);

                        }
                        String counts = data_message.getString("count");
                        String msgs = jsonObject.getString("msg");
                          count.setText(counts);
                          msg.setText(msgs);
                      //  Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
                        Log.d("sss", msgs);
                        Log.d("ddd", error_code);
                        MDToast mdToast = MDToast.makeText(MainActivity.this, msgs, 2, MDToast.TYPE_SUCCESS);
                        mdToast.setGravity(Gravity.CENTER | Gravity.CENTER, 0, 0);
                        mdToast.show();

//                        AdapterClass ac = new AdapterClass((List<ModelClassZIp.List>) jsonObject.getJSONObject(String.valueOf(data_message)).getJSONArray(String.valueOf(jsonArray)));
//                        recyclerView.setAdapter(ac);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
    }

    private void prepareMovieData() {
//        Movie movie = new Movie("Mad Max: Fury Road","hgvhjjh","2015");
//        movieList.add(movie);
//
//        movie = new Movie("Inside Out", "Animation, Kids & Family", "2015");
//        movieList.add(movie);
//
//        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
//        movieList.add(movie);
//
//        movie = new Movie("Shaun the Sheep", "Animation", "2015");
//        movieList.add(movie);
//
//        movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015");
//        movieList.add(movie);
//
//        movie = new Movie("Mission: Impossible Rogue Nation", "Action", "2015");
//        movieList.add(movie);
//
//        movie = new Movie("Up", "Animation", "2009");
//        movieList.add(movie);
//
//        movie = new Movie("Star Trek", "Science Fiction", "2009");
//        movieList.add(movie);
//
//        movie = new Movie("The LEGO Movie", "Animation", "2014");
//        movieList.add(movie);
//
//        movie = new Movie("Iron Man", "Action & Adventure", "2008");
//        movieList.add(movie);
//
//        movie = new Movie("Aliens", "Science Fiction", "1986");
//        movieList.add(movie);
//
//        movie = new Movie("Chicken Run", "Animation", "2000");
//        movieList.add(movie);
//
//        movie = new Movie("Back to the Future", "Science Fiction", "1985");
//        movieList.add(movie);
//
//        movie = new Movie("Raiders of the Lost Ark", "Action & Adventure", "1981");
//        movieList.add(movie);
//
//        movie = new Movie("Goldfinger", "Action & Adventure", "1965");
//        movieList.add(movie);
//
//        movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
//        movieList.add(movie);
//
//        mAdapter.notifyDataSetChanged();
//    }
    }
}