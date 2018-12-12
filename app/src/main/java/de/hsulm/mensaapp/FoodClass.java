package de.hsulm.mensaapp;

import android.os.Parcel;
import android.os.Parcelable;

public class FoodClass implements Parcelable {

    public int id;
    public String name;
    public String category;
    public String date;
    public int vegan;
    public int vegetarian;
    public String price;
    public String uuid;
    public int rating;
    public String mimgId;

    public FoodClass(int id, String name, String category, int vegan, int vegetarian, String price, String uuid, int rating, String mimgId){
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
        rating = in.readInt();
        mimgId = in.readString();
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
        if(price != null) {
            price = price.replaceAll(System.getProperty("line.separator"), (""));
            price = price.replaceAll("\\?","");
        }
        return price;
    }

    public String getUuid() {
        return uuid;
    }

    public int getRating(){return rating;}

    public String getmimgId() {
        return mimgId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(category);
        dest.writeString(date);
        dest.writeInt(vegan);
        dest.writeInt(vegetarian);
        dest.writeString(price);
        dest.writeString(uuid);
        dest.writeInt(rating);
        dest.writeString(mimgId);
    }
}
