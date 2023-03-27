package com.rnwidgets_2;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

public class SharedStorage extends ReactContextBaseJavaModule {
    ReactApplicationContext context;

    public SharedStorage(ReactApplicationContext reactContext) {
        super(reactContext);
        context = reactContext;
    }

    @Override
    public String getName() {
        return "SharedStorage";
    }

    @ReactMethod
    public void set(String message) {
        SharedPreferences.Editor editor = context.getSharedPreferences("DATA", Context.MODE_PRIVATE).edit();
        editor.putString("appData", message);
        editor.commit();

        Intent intent = new Intent(getCurrentActivity().getApplicationContext(), RoutingWidget.class);
        intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        int[] ids = AppWidgetManager.getInstance(getCurrentActivity().getApplicationContext()).getAppWidgetIds(new ComponentName(getCurrentActivity().getApplicationContext(), RoutingWidget.class));
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, ids);
        getCurrentActivity().getApplicationContext().sendBroadcast(intent);

        Intent pieChartIntent = new Intent(getCurrentActivity().getApplicationContext(), PieChart.class);
        pieChartIntent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        int[] pieChartIds = AppWidgetManager.getInstance(getCurrentActivity().getApplicationContext()).getAppWidgetIds(new ComponentName(getCurrentActivity().getApplicationContext(), PieChart.class));
        pieChartIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, pieChartIds);
        getCurrentActivity().getApplicationContext().sendBroadcast(pieChartIntent);

        Intent nextJobIntent = new Intent(getCurrentActivity().getApplicationContext(), NextJobWidget.class);
        nextJobIntent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        int[] nextJobIds = AppWidgetManager.getInstance(getCurrentActivity().getApplicationContext()).getAppWidgetIds(new ComponentName(getCurrentActivity().getApplicationContext(), NextJobWidget.class));
        nextJobIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, nextJobIds);
        getCurrentActivity().getApplicationContext().sendBroadcast(nextJobIntent);

    }
}

/*
This code is an implementation of a React Native module for an Android app that provides a way to
store and access data using the Android shared preferences storage.

The code defines a class called SharedStorage which extends ReactContextBaseJavaModule. The class has a
constructor that takes a ReactApplicationContext object as an argument and saves it as a class member. The
getName() method returns a string "SharedStorage", which is used to identify the module when it is registered
with the React Native framework.

The code contains a single method set which is annotated with @ReactMethod. This method is used to save data
in the shared preferences storage. It takes a string argument "message" which is the data that needs to be stored.
The method uses the context.getSharedPreferences("DATA", Context.MODE_PRIVATE).edit() method to get an editor for
the shared preferences and saves the "message" string under the key "appData". After the data is saved, the method
calls the commit() method to save the changes.

The set method then sends a broadcast with an action AppWidgetManager.ACTION_APPWIDGET_UPDATE to update any
widgets associated with the app. It retrieves an array of app widget IDs using
AppWidgetManager.getInstance(getCurrentActivity().getApplicationContext()).getAppWidgetIds(new ComponentName(getCurrentActivity().getApplicationContext(), RoutingWidget.class)),
adds the IDs to an intent using intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, ids), and finally sends the
broadcast using getCurrentActivity().getApplicationContext().sendBroadcast(intent).
 */