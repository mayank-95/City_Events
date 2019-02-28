package com.mayank.ok.events;

import android.content.Context;
import android.content.SharedPreferences;

public class Appdata{
    public static String pref="session";
    public static String login="false";
    public static String userkey="user";

    public Appdata()
    {
        super();
    }

    public static void save(Context context,String text,String key)
    {
        SharedPreferences settings;
        SharedPreferences.Editor editor;
        settings=context.getSharedPreferences(pref,Context.MODE_PRIVATE);
        editor=settings.edit();
        editor.putString(key,text);
        editor.commit();
    }

    public static String get(Context context,String key)
    {
        SharedPreferences settings;
        settings=context.getSharedPreferences(pref,Context.MODE_PRIVATE);
        String text=settings.getString(key,key);
        return text;
    }

    public static void remove(Context context,String key)
    {

        SharedPreferences settings;
        SharedPreferences.Editor editor;
        settings=context.getSharedPreferences(pref,Context.MODE_PRIVATE);
        editor=settings.edit();
        editor.remove(key);
        editor.commit();
    }
    public static void clear(Context context,String key)
    {

        SharedPreferences settings;
        SharedPreferences.Editor editor;
        settings=context.getSharedPreferences(pref,Context.MODE_PRIVATE);
        editor=settings.edit();
        editor.clear();
        editor.commit();
    }
}
