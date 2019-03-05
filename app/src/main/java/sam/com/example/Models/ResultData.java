package sam.com.example.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import io.reactivex.annotations.NonNull;

@Entity(tableName = "my_table")
public class ResultData implements Parcelable {
    
    public ResultData(Integer id, String name, String tag, String color, List<Criterium> criteria) {
        this.id = id;
        this.name = name;
        this.tag = tag;
        this.color = color;
        this.criteria = criteria;
    }
    
    @NonNull
    @PrimaryKey()
    @SerializedName(value = "id")
    @Expose
    private Integer id;
    
    @ColumnInfo(name = "name")
    @SerializedName("name")
    @Expose
    private String name;
    
    @ColumnInfo(name = "tag")
    @SerializedName("tag")
    @Expose
    private String tag;
    
    @ColumnInfo(name = "color")
    @SerializedName("color")
    @Expose
    private String color;
    
    @ColumnInfo(name = "ListData")
    @TypeConverters(DataTypeConverter.class)
    @SerializedName("criteria")
    @Expose
    private List<Criterium> criteria = new ArrayList<>();
    
    protected ResultData(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        name = in.readString();
        tag = in.readString();
        color = in.readString();
        in.readTypedList(criteria, Criterium.CREATOR);
    }
    
    public static final Creator<ResultData> CREATOR = new Creator<ResultData>() {
        @Override
        public ResultData createFromParcel(Parcel in) {
            return new ResultData(in);
        }
        
        @Override
        public ResultData[] newArray(int size) {
            return new ResultData[size];
        }
    };
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getTag() {
        return tag;
    }
    
    public void setTag(String tag) {
        this.tag = tag;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public List<Criterium> getCriteria() {
        return criteria;
    }
    
    public void setCriteria(List<Criterium> criteria) {
        this.criteria = criteria;
    }
    
    @Override
    public int describeContents() {
        return 0;
    }
    
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(name);
        dest.writeString(tag);
        dest.writeString(color);
        dest.writeTypedList(criteria);
    }
    
    public static Creator<ResultData> getCREATOR() {
        return CREATOR;
    }
}
