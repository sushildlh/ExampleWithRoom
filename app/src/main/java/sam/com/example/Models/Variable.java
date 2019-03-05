package sam.com.example.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import androidx.room.Embedded;

public class Variable implements Parcelable {
    
    @Embedded
    @SerializedName(value = "$1" ,alternate={"$2", "$3","$4"})
    @Expose
    public Dollar dollar;
    
    
    protected Variable(Parcel in) {
        dollar = in.readParcelable(Dollar.class.getClassLoader());
    }
    
    public static final Creator<Variable> CREATOR = new Creator<Variable>() {
        @Override
        public Variable createFromParcel(Parcel in) {
            return new Variable(in);
        }
        
        @Override
        public Variable[] newArray(int size) {
            return new Variable[size];
        }
    };
    
    @Override
    public int describeContents() {
        return 0;
    }
    
    @Override
    public void writeToParcel(Parcel dest, int flags) {
    
        dest.writeParcelable(dollar, flags);
    }
    
    public Dollar getD1() {
        return dollar;
    }
    
    public void setD1(Dollar d1) {
        this.dollar = d1;
    }
    
    public static Creator<Variable> getCREATOR() {
        return CREATOR;
    }
}
