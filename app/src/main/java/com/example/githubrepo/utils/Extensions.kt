package com.example.githubrepo.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun dateFromString(date: String?): Date {
    var dateToReturn: Date? = null
    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    try {
        dateToReturn = dateFormat.parse(date ?: "") as Date
    } catch (e: ParseException) {
        e.printStackTrace()
    }
    return dateToReturn!!
}

fun formattedDate(date: String): String {
    val dateObject = dateFromString(date)
    val format = SimpleDateFormat("MMM dd, yyyy")
    return format.format(dateObject)
}