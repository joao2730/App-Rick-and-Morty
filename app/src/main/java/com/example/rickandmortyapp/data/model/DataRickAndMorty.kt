package com.example.rickandmortyapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue


@Parcelize
data class DataRickAndMorty(
    val info: @RawValue Info,
    val results: ArrayList<RickAndMorty>
) : Parcelable