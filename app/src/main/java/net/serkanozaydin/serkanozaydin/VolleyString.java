package net.serkanozaydin.serkanozaydin;

/**
 * Created by hsmnzaydn on 4/5/17.
 */

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

//Hüseyin Serkan Özaydin:UTF-8 karakter hatası veren Volley kütüphanesi için editlediğim class
public class VolleyString extends JsonRequest<String> {

    public VolleyString(int method, String url, String requestBody,
                        Listener<String> listener, ErrorListener errorListener) {
        super(method, url, requestBody, listener,
                errorListener);
    }

    public VolleyString(String url, Listener<String> listener, ErrorListener errorListener) {
        super(Method.GET, url, null, listener, errorListener);
    }

    public VolleyString(int method, String url, Listener<String> listener, ErrorListener errorListener) {
        super(method, url, null, listener, errorListener);
    }

    public VolleyString(int method, String url, JSONObject jsonRequest,
                        Listener<String> listener, ErrorListener errorListener) {
        super(method, url, (jsonRequest == null) ? null : jsonRequest.toString(), listener,
                errorListener);
    }

    public VolleyString(String url, JSONObject jsonRequest, Listener<String> listener,
                        ErrorListener errorListener) {
        this(jsonRequest == null ? Method.GET : Method.POST, url, jsonRequest,
                listener, errorListener);
    }

    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        try {
            String jsonString = new String(response.data, "UTF-8");
            return Response.success(new String(jsonString),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (Exception je) {
            return Response.error(new ParseError(je));
        }
    }
}