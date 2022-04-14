package com.example.tpdynamicfragment;

import android.view.View;

public interface Communication {
    void onSend(View source, int selectedIndex);
    void onReceived(View source, int selectedIndex, String nom, String prenom, String date);
}
