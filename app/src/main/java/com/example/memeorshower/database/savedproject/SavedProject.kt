package com.example.memeorshower.database.savedproject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "saved_project_table")
data class SavedProject(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    var data: ByteArray? = null,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "date") val date: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SavedProject

        if (id != other.id) return false
        if (data != null) {
            if (other.data == null) return false
            if (!data.contentEquals(other.data)) return false
        } else if (other.data != null) return false
        if (title != other.title) return false
        if (date != other.date) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + (data?.contentHashCode() ?: 0)
        result = 31 * result + title.hashCode()
        result = 31 * result + date.hashCode()
        return result
    }
}