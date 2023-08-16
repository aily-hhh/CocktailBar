package ru.mirea.cocktailbar.data.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cocktail")
data class Cocktail(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "name")
    var name: String?,
    @ColumnInfo(name = "description")
    var description: String?,
    @ColumnInfo(name = "recept")
    var recept: String?,
    @ColumnInfo(name = "image")
    var image: String?
): Parcelable {
    constructor(parcel: Parcel) : this(
        id = parcel.readLong(),
        name = parcel.readString(),
        description = parcel.readString(),
        recept = parcel.readString(),
        image = parcel.readString()
    )

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeLong(id)
        dest.writeString(name)
        dest.writeString(description)
        dest.writeString(recept)
        dest.writeString(image)
    }

    companion object CREATOR : Parcelable.Creator<Cocktail> {
        override fun createFromParcel(parcel: Parcel): Cocktail {
            return Cocktail(parcel)
        }

        override fun newArray(size: Int): Array<Cocktail?> {
            return arrayOfNulls(size)
        }
    }

}
