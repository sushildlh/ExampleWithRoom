package sam.com.example.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import androidx.room.ColumnInfo;
import androidx.room.TypeConverters;

public class Dollar implements Parcelable {
    
    @ColumnInfo(name = "type")
    @SerializedName("type")
    @Expose
    private String type;
    
    @ColumnInfo(name = "study_type")
    @SerializedName("study_type")
    @Expose
    private String studyType;
    
    @ColumnInfo(name = "parameter_name")
    @SerializedName("parameter_name")
    @Expose
    private String parameterName;
    
    @ColumnInfo(name = "min_value")
    @SerializedName("min_value")
    @Expose
    private Integer minValue;
    
    @ColumnInfo(name = "max_value")
    @SerializedName("max_value")
    @Expose
    private Integer maxValue;
    
    @ColumnInfo(name = "default_value")
    @SerializedName("default_value")
    @Expose
    private Integer defaultValue;
    
    @ColumnInfo(name = "values")
    @TypeConverters(DoubleTypeConverter.class)
    @SerializedName("values")
    @Expose
    private List<Double> values = new ArrayList<>();
    
    protected Dollar(Parcel in) {
        type = in.readString();
        studyType = in.readString();
        parameterName = in.readString();
        if (in.readByte() == 0) {
            minValue = null;
        } else {
            minValue = in.readInt();
        }
        if (in.readByte() == 0) {
            maxValue = null;
        } else {
            maxValue = in.readInt();
        }
        if (in.readByte() == 0) {
            defaultValue = null;
        } else {
            defaultValue = in.readInt();
        }
        
        in.readList(values, List.class.getClassLoader());
    }
    
    public static final Creator<Dollar> CREATOR = new Creator<Dollar>() {
        @Override
        public Dollar createFromParcel(Parcel in) {
            return new Dollar(in);
        }
        
        @Override
        public Dollar[] newArray(int size) {
            return new Dollar[size];
        }
    };
    
    public List<Double> getValues() {
        return values;
    }
    
    public void setValues(List<Double> values) {
        this.values = values;
    }
    
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getStudyType() {
        return studyType;
    }
    
    public void setStudyType(String studyType) {
        this.studyType = studyType;
    }
    
    public String getParameterName() {
        return parameterName;
    }
    
    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }
    
    public Integer getMinValue() {
        return minValue;
    }
    
    public void setMinValue(Integer minValue) {
        this.minValue = minValue;
    }
    
    public Integer getMaxValue() {
        return maxValue;
    }
    
    public void setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
    }
    
    public Integer getDefaultValue() {
        return defaultValue;
    }
    
    public void setDefaultValue(Integer defaultValue) {
        this.defaultValue = defaultValue;
    }
    
    
    @Override
    public int describeContents() {
        return 0;
    }
    
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        
        dest.writeString(type);
        dest.writeString(studyType);
        dest.writeString(parameterName);
        if (minValue == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(minValue);
        }
        if (maxValue == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(maxValue);
        }
        if (defaultValue == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(defaultValue);
        }
        
        dest.writeList(values);
    }
    
    public static Creator<Dollar> getCREATOR() {
        return CREATOR;
    }
}
