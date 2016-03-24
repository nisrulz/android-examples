package github.nisrulz.intents;

import android.os.Parcel;
import android.os.Parcelable;

public class POJOClass implements Parcelable {

    private String name;
    private String text;

    public POJOClass(String name, String text) {
        this.name = name;
        this.text = text;
    }

    protected POJOClass(Parcel in) {
        name = in.readString();
        text = in.readString();
    }

    public static final Creator<POJOClass> CREATOR = new Creator<POJOClass>() {
        @Override
        public POJOClass createFromParcel(Parcel in) {
            return new POJOClass(in);
        }

        @Override
        public POJOClass[] newArray(int size) {
            return new POJOClass[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(text);
    }
}
