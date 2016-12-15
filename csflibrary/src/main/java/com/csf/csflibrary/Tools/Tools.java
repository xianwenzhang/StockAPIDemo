package com.csf.csflibrary.Tools;

import android.util.Base64;

import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 */
public class Tools {

    public static String getToken(String accessKey, Long t, String secretKey) {
        try {
            //生成token参数
            String data = accessKey + "," + t + "," + secretKey;
            SecretKeySpec keySpec = new SecretKeySpec(data.getBytes(), "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(keySpec);
            byte[] res = mac.doFinal();
            String token = Base64.encodeToString(res, Base64.NO_WRAP);
            return token;
        } catch (Exception e) {
            return null;
        }


    }
}
