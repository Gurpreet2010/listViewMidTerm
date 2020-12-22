package com.example.midtermfinalproject;

import android.os.Parcel;
import android.os.Parcelable;

public class Owner implements Parcelable {

    private String name;
    private String login;
    private String full_name;

    private OwnerObject owner;
    public Owner(String name, String login, String full_name, OwnerObject owner) {
        this.name = name;
        this.login = login;
        this.full_name = full_name;
        this.owner = owner;
    }


    protected Owner(Parcel in) {
        name = in.readString();
        login = in.readString();
        full_name = in.readString();
    }

    public static final Creator<Owner> CREATOR = new Creator<Owner>() {
        @Override
        public Owner createFromParcel(Parcel in) {
            return new Owner(in);
        }

        @Override
        public Owner[] newArray(int size) {
            return new Owner[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public OwnerObject getOwner() {
        return owner;
    }

    public void setOwner(OwnerObject owner) {
        this.owner = owner;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(login);
        dest.writeString(full_name);
    }
}

