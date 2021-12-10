package com.example.memeorshower.database.imagetmp

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "image_tmp_table")
data class ImageTmp(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    var data: ByteArray? = null,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "desc") val desc: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ImageTmp

        if (id != other.id) return false
        if (data != null) {
            if (other.data == null) return false
            if (!data.contentEquals(other.data)) return false
        } else if (other.data != null) return false
        if (title != other.title) return false
        if (desc != other.desc) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + (data?.contentHashCode() ?: 0)
        result = 31 * result + title.hashCode()
        result = 31 * result + desc.hashCode()
        return result
    }
}