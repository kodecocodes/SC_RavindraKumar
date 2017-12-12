package com.ravidsrk.knowledgedebt.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by ravindra on 08/12/17.
 */

@Parcelize
data class Address(val city: String, val state: String, val zipcode: String) : Parcelable