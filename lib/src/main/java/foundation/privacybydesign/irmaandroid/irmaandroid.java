package foundation.privacybydesign.irmaandroid;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import org.json.JSONObject;
import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class irmaandroid {
    public static void StartIRMA(String sessionPointer, String returnURL, Activity requestingActivity) throws InvalidRequest {
        try {
            JSONObject sessionJSON = new JSONObject(sessionPointer);
            sessionJSON.put("returnURL", returnURL);
            String sessionData = sessionJSON.toString();

            String Target = "https://irma.app/-/session#" + URLEncoder.encode(sessionData, "UTF-8");
            Uri targetUri = Uri.parse(Target);
            Intent openIntent = new Intent(Intent.ACTION_VIEW, targetUri);
            requestingActivity.startActivity(openIntent);
        } catch (JSONException e) {
            throw new InvalidRequest();
        } catch (UnsupportedEncodingException e) {
            throw new InvalidRequest();
        }
    }
}
