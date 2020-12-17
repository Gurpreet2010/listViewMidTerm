package com.example.midtermcustomlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

   private ListView lv;
   String name;

   private static String JSON_URL="https://run.mocky.io/v3/83e5c3ee-3abf-4561-a5b7-3dd27cf9f188";

   ArrayList<HashMap<String,String>> companyList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        companyList = new ArrayList<>();
        lv = findViewById(R.id.Listview);

         GetData getData = new GetData();
         getData.execute();

    }

public class GetData extends AsyncTask<String, String, String> {


    private Object CompanyList;

    @Override
    protected String doInBackground(String... strings) {
        return null;
        String current;
        try {
            URL url;
            HttpURLConnection urlConnection = null;

            try {
                url = new URL(JSON_URL);
                urlConnection = (HttpURLConnection) url.openConnection();

                InputStream in = urlConnection.getInputStream();
                InputStreamReader isr = new InputStreamReader(in);

                int data = isr.read();
                while (data != -1){

                }

                    char current = (char) data;
                     data = isr.read();
                }
                return current;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
           finally {
                if(urlConnection !=null){
                    urlConnection.disconnect();
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return current;
    }

    @Override
    protected void onPostExecute(String s) {
        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray jsonArray = jsonObject.getJSONArray(name:"Company");

            for(int i = 0; i< jsonArray.length() ; i++){

                JSONObject jsonObject1 = jsonArray.getJSONObject(i);


                name = jsonObject1.getString(name:"name");

                HashMap<String, String> Company = new HashMap<>();

                Company.put("name", name);
                CompanyList.add(Company);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Context context;
        ListAdapter adapter = new SimpleAdapter(
                context: MainActivity.this,
                CompanyList,
                R.layout.row_layout,
        new String[]  {"name",
        new int []{R.id.textView, R.id.textView2});

        lv.setAdapter(adapter);
        )
    }
}

}
