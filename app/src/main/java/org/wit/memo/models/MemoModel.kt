package org.wit.memo.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MemoModel(var id: Long = 0,
                     var title: String = "",
                     var description: String = "",
                     var address: String = "",
                     var image: String = "",
                     var personDate: String = "",
                     var type: String = "",
                     var descriptionP: String = "",
                     var prescription: String = "",
                     var prescriptionDate: String = "",

) : Parcelable

//@Parcelize
//data class DetailedLog(
//    var id: Long = 0,
//    var type: String = "",
//    var descriptionP: String = "",
//    var prescription: String = "",
//    var prescriptionDate: String = "",
//
//
//):Parcelable