package com.example.dynamicapplication

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ConfigurationModel(
    @SerializedName("menu")
    val menu: List<MenuModel>,
    @SerializedName("pages")
    val pages: List<PageModel>
): Serializable {

    data class MenuModel(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String
    ): Serializable

    data class PageModel(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("elements")
        val elements: List<ElementsModel>
    ): Serializable {

        data class ElementsModel(
            @SerializedName("type")
            val type: String,
            @SerializedName("label")
            val label: String,
            @SerializedName("content")
            val content: String?,
            @SerializedName("url")
            val url: String?,
            @SerializedName("alt")
            val alt: String?,
            @SerializedName("action")
            val action: String?
        ): Serializable

    }

}

