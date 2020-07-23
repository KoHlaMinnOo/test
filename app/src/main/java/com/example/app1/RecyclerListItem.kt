package com.example.app1


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RecyclerListItem (var blood_type:String,var name:String,
                             var gender:String,var date:String,var phone:String) : Parcelable

@Parcelize
class RecyclerListItems:ArrayList<RecyclerListItem>(), Parcelable