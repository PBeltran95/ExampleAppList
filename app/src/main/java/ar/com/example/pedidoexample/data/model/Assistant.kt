package ar.com.example.pedidoexample.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Assistant(
    @PrimaryKey(autoGenerate = true)
    val id: Int  = 0,
    val name: String = "",
    val surName:String = "",
    val age:Int = 0
) : Parcelable

@Parcelize
data class ListOfAssistants(
    val result: MutableList<Assistant> = mutableListOf()
) : Parcelable
