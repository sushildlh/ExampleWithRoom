package sam.com.example.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;

public class Criterium implements Parcelable {
    
    @ColumnInfo(name = "type")
    @SerializedName("type")
    @Expose
    private String type;
    
    @ColumnInfo(name = "text")
    @SerializedName("text")
    @Expose
    private String text;
    
    @Embedded
    @SerializedName("variable")
    @Expose
    private Variable variable;
    
    protected Criterium(Parcel in) {
        type = in.readString();
        text = in.readString();
        variable = in.readParcelable(Variable.class.getClassLoader());
    }
    
    public static final Creator<Criterium> CREATOR = new Creator<Criterium>() {
        @Override
        public Criterium createFromParcel(Parcel in) {
            return new Criterium(in);
        }
        
        @Override
        public Criterium[] newArray(int size) {
            return new Criterium[size];
        }
    };
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public Variable getVariable() {
        return variable;
    }
    
    public void setVariable(Variable variable) {
        this.variable = variable;
    }
    
    @Override
    public int describeContents() {
        return 0;
    }
    
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(type);
        dest.writeString(text);
        dest.writeParcelable(variable,flags);
    }
    
    public static Creator<Criterium> getCREATOR() {
        return CREATOR;
    }
}
