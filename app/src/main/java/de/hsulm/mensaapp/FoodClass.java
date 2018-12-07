package de.hsulm.mensaapp;

import android.os.Parcel;
import android.os.Parcelable;

public class FoodClass implements Parcelable {

    private int id;
    private String name;
    private String category;
    private String date;
    private int vegan;
    private int vegetarian;
    private String price;
    private String uuid;
    private float rating;
    private int mimgId;

    public FoodClass(int id, String name, String category, int vegan, int vegetarian, String price, String uuid, float rating, int mimgId){
        this.id = id;
        this.name = name;
        this.category = category;
        this.date = date;
        this.vegan = vegan;
        this.vegetarian = vegetarian;
        this.price = price;
        this.uuid = uuid;
        this.rating = rating;
        this.mimgId = mimgId;
    }

    protected FoodClass(Parcel in) {
        id = in.readInt();
        name = in.readString();
        category = in.readString();
        date = in.readString();
        vegan = in.readInt();
        vegetarian = in.readInt();
        price = in.readString();
        uuid = in.readString();
        rating = in.readFloat();
        mimgId = in.readInt();
    }

    public static final Creator<FoodClass> CREATOR = new Creator<FoodClass>() {
        @Override
        public FoodClass createFromParcel(Parcel in) {
            return new FoodClass(in);
        }

        @Override
        public FoodClass[] newArray(int size) {
            return new FoodClass[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getName() {
        if(name != null) {
            name = name.replaceAll(System.getProperty("line.separator"), (""));
        }
        return name;
    }

    public String getDate() {
        return date;
    }

    public int isVegan() {
        return vegan;
    }

    public int isVegetarian() {
        return vegetarian;
    }

    public String getPrice() {
        return price;
    }

    public String getUuid() {
        return uuid;
    }

    public float getRating(){return rating;}

    public int getmimgId() {
        return mimgId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(price);
        dest.writeString(name);
        dest.writeString(((Float)rating).toString());
        dest.writeInt(mimgId);

    }
}
