package com.mphantom.forrest.model

import com.google.gson.annotations.SerializedName

/**
 * Created by wushaorong on 3/12/16.
 */
object Model {
    data class DataHistory(val error: Boolean, val results: List<String>)

    data class GankDay(val errror: Boolean, val category: List<String>, val results: DayResult)
    data class DayResult(@SerializedName("Android") val android: List<GankItem>,
                         @SerializedName("iOS") val ios: List<GankItem>,
                         @SerializedName("休息视频") val restVideo: List<GankItem>,
                         @SerializedName("拓展资源") val expandRes: List<GankItem>,
                         @SerializedName("福利") val welfare: List<GankItem>,
                         @SerializedName("App") val app: List<GankItem>,
                         @SerializedName("前端") val fondEnd: List<GankItem>,
                         @SerializedName("瞎推荐") val recommend: List<GankItem>)

    data class TypeList(val error: Boolean, val results: List<GankItem>)

    data class GankItem(val _id: String, val _ns: String, val createdAt: String,
                        val desc: String, val publishedAt: String,
                        val source: String, val type: String,
                        val url: String, val used: Boolean, val who: String)
}
