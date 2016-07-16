package com.example.zheng.maptreasure.account;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by zhengshujuan on 2016/7/16.
 */
public class UserPrefs {
    private static final String PREFS_NAME = "user_info";
    private static UserPrefs userPrefs;
    private static final String KEY_TOKENID = "key_tokenid";
    private static final String KEY_PHOTO = "key_photo";
    private final SharedPreferences preferences;

    private UserPrefs(Context context) {
        preferences = context.getApplicationContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public static UserPrefs getInstance() {
        return userPrefs;
    }

    public static void init(Context context) {
        userPrefs = new UserPrefs(context);
    }

    public void setTokenId(int tokenId) {
        preferences.edit().putInt(KEY_TOKENID, tokenId).apply();
    }

    public int getTokenId() {
        return preferences.getInt(KEY_TOKENID, -1);
    }

    public void setPhoto(String photoUrl) {
        preferences.edit().putString(KEY_PHOTO, photoUrl).apply();
    }

    public String getPhoto() {
        return preferences.getString(KEY_PHOTO, null);
    }
}
