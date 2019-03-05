package sam.com.example.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import androidx.room.Embedded;

public class Variable implements Parcelable {
    
    @Embedded
    @SerializedName("$1")
    @Expose
    public Dollar d1;
    
    @Embedded
    @SerializedName("$2")
    @Expose
    private Dollar d2;
    
    @Embedded
    @SerializedName("$3")
    @Expose
    private Dollar d3;
    
    @Embedded
    @SerializedName("$4")
    @Expose
    private Dollar d4;
    
    
    protected Variable(Parcel in) {
        d1 = in.readParcelable(Dollar.class.getClassLoader());
        d2 = in.readParcelable(Dollar.class.getClassLoader());
        d3 = in.readParcelable(Dollar.class.getClassLoader());
        d4 = in.readParcelable(Dollar.class.getClassLoader());
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
    
        dest.writeParcelable(d1, flags);
        dest.writeParcelable(d2, flags);
        dest.writeParcelable(d3, flags);
        dest.writeParcelable(d4, flags);
    }
    
    public Dollar getD1() {
        return d1;
    }
    
    public void setD1(Dollar d1) {
        this.d1 = d1;
    }
    
    public Dollar getD2() {
        return d2;
    }
    
    public void setD2(Dollar d2) {
        this.d2 = d2;
    }
    
    public Dollar getD3() {
        return d3;
    }
    
    public void setD3(Dollar d3) {
        this.d3 = d3;
    }
    
    public Dollar getD4() {
        return d4;
    }
    
    public void setD4(Dollar d4) {
        this.d4 = d4;
    }
    
    public static Creator<Variable> getCREATOR() {
        return CREATOR;
    }
}
