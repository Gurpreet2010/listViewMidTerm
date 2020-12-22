package com.example.midtermfinalproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class OwnerObject {
    @SerializedName("login")
    @Expose
    private String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

}
