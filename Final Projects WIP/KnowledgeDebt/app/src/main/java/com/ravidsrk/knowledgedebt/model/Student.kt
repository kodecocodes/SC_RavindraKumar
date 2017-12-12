package com.ravidsrk.knowledgedebt.model

import android.os.Parcelable
import com.ravidsrk.knowledgedebt.model.Address
import kotlinx.android.parcel.Parcelize

/**
 * Created by ravindra on 08/12/17.
 */

@Parcelize
data class Student(val name: String, val age: Int, val address: Address): Parcelable