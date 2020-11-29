package com.rsc.assignment247.model

import com.google.gson.annotations.SerializedName

data class UserResponse(

	@field:SerializedName("code")
    val code: Int? = null,

	@field:SerializedName("data")
    val data: List<DataItem?>? = null,

	@field:SerializedName("meta")
    val meta: Meta? = null
)

data class Pagination(

    @field:SerializedName("total")
    val total: Int? = null,

    @field:SerializedName("pages")
    val pages: Int? = null,

    @field:SerializedName("limit")
    val limit: Int? = null,

    @field:SerializedName("page")
    val page: Int? = null
)

data class Meta(

    @field:SerializedName("pagination")
    val pagination: Pagination? = null
)

data class DataItem(

    @field:SerializedName("gender")
    val gender: String? = null,

    @field:SerializedName("updated_at")
    val updatedAt: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("email")
    val email: String? = null,

    @field:SerializedName("status")
    val status: String? = null
)
