package sam.com.example.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import androidx.room.Embedded;

public class Variable implements Parcelable {
    
    @Embedded
    @SerializedName(value = "$1")
    @Expose
    public Dollar dollar1;
    
    @Embedded
    @SerializedName(value = "$2")
    @Expose
    public Dollar dollar2;
    
    @Embedded
    @SerializedName(value = "$3")
    @Expose
    public Dollar dollar3;
    
    @Embedded
    @SerializedName(value = "$4")
    @Expose
    public Dollar dollar4;
    
    @Embedded
    @SerializedName(value = "$17")
    @Expose
    public Dollar dollar17;
    
    
    protected Variable(Parcel in) {
        dollar1 = in.readParcelable(Dollar.class.getClassLoader());
        dollar2 = in.readParcelable(Dollar.class.getClassLoader());
        dollar3 = in.readParcelable(Dollar.class.getClassLoader());
        dollar4 = in.readParcelable(Dollar.class.getClassLoader());
        dollar17 = in.readParcelable(Dollar.class.getClassLoader());
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
        
        dest.writeParcelable(dollar1, flags);
        dest.writeParcelable(dollar2, flags);
        dest.writeParcelable(dollar3, flags);
        dest.writeParcelable(dollar4, flags);
        dest.writeParcelable(dollar17, flags);
    }
    
    public Dollar getDollar1() {
        return dollar1;
    }
    
    public void setDollar1(Dollar dollar1) {
        this.dollar1 = dollar1;
    }
    
    public Dollar getDollar2() {
        return dollar2;
    }
    
    public void setDollar2(Dollar dollar2) {
        this.dollar2 = dollar2;
    }
    
    public Dollar getDollar3() {
        return dollar3;
    }
    
    public void setDollar3(Dollar dollar3) {
        this.dollar3 = dollar3;
    }
    
    public Dollar getDollar4() {
        return dollar4;
    }
    
    public void setDollar4(Dollar dollar4) {
        this.dollar4 = dollar4;
    }
    
    public Dollar getDollar17() {
        return dollar4;
    }
    
    public void setDollar17(Dollar dollar17) {
        this.dollar17 = dollar17;
    }
    
    public static Creator<Variable> getCREATOR() {
        return CREATOR;
    }
}
