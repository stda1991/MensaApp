package de.hsulm.mensaapp.SQL_SEARCH_BY_DATEID;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import de.hsulm.mensaapp.CONSTANTS.URLS;
import de.hsulm.mensaapp.SHARED_PREF_MANAGER_AND_REQUEST_HANDLER.RequestHandler;
import de.hsulm.mensaapp.CLASS_OBJ_AND_ADPT.FoodClass;

/**
 * Created by Stephan Danz 05/12/2018
 * Class necessary for handling all DB operations such as getting food
 */
public class DatabaseOperationsDateID {

    private Context mContext;

    public DatabaseOperationsDateID(Context context) {
        mContext = context;
    }


    public void getFoodFromDB(final String searchQuery, final IDatabaseOperationsDateID callback) {

        final String food_object = null;

        StringRequest arrayRequest = new StringRequest(
                Request.Method.POST,
                URLS.URL_SEARCH_BY_DATEID,

                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {

                        final ArrayList<FoodClass> food_list = new ArrayList<>();
                        FoodClass food = null;

                        try {
                            JSONArray food_arr = new JSONArray(response);

                            for (int i = 0; i < food_arr.length(); i++) {

                                try {
                                    JSONObject food_obj = food_arr.getJSONObject(i);
                                    food = new FoodClass(food_obj.getInt("id"),
                                              food_obj.getString("name"),
                                              food_obj.getString("category"),
                                              food_obj.getInt("vegan"),
                                              food_obj.getInt("vegetarian"),
                                              food_obj.getString("price"),
                                              food_obj.getString("uuid"),
                                              food_obj.getInt("rating"),
                                              food_obj.getString("img_id_cover"),
                                              food_obj.getInt("number_rating"),
                                              food_obj.getString("daydiff") );
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                food_list.add(food);

                            }

                            callback.onSuccess(food_list);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }

                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<>();
                params.put("searchQuery", searchQuery);
                return params;
            }
        };

        RequestHandler.getInstance(mContext).addToRequestQueue(arrayRequest);

    }

}


