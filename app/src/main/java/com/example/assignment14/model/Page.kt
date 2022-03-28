package com.example.assignment14.model

import com.google.gson.annotations.SerializedName

data class Page(

	@field:SerializedName("hits")
	val hits: List<HitsItem?>? = null,

	@field:SerializedName("exhaustiveTypo")
	val exhaustiveTypo: Boolean? = null,

	@field:SerializedName("hitsPerPage")
	val hitsPerPage: Int? = null,

	@field:SerializedName("processingTimeMS")
	val processingTimeMS: Int? = null,

	@field:SerializedName("query")
	val query: String? = null,

	@field:SerializedName("nbHits")
	val nbHits: Int? = null,

	@field:SerializedName("page")
	val page: Int? = null,

	@field:SerializedName("params")
	val params: String? = null,

	@field:SerializedName("nbPages")
	val nbPages: Int? = null,

	@field:SerializedName("exhaustiveNbHits")
	val exhaustiveNbHits: Boolean? = null
)

data class StoryUrl(

	@field:SerializedName("matchLevel")
	val matchLevel: String? = null,

	@field:SerializedName("value")
	val value: String? = null,

	@field:SerializedName("matchedWords")
	val matchedWords: List<Any?>? = null
)

data class CommentText(

	@field:SerializedName("matchLevel")
	val matchLevel: String? = null,

	@field:SerializedName("value")
	val value: String? = null,

	@field:SerializedName("matchedWords")
	val matchedWords: List<Any?>? = null
)

data class HighlightResult(

	@field:SerializedName("comment_text")
	val commentText: CommentText? = null,

	@field:SerializedName("author")
	val author: Author? = null,

	@field:SerializedName("story_title")
	val storyTitle: StoryTitle? = null,

	@field:SerializedName("story_url")
	val storyUrl: StoryUrl? = null
)

data class Author(

	@field:SerializedName("matchLevel")
	val matchLevel: String? = null,

	@field:SerializedName("value")
	val value: String? = null,

	@field:SerializedName("matchedWords")
	val matchedWords: List<Any?>? = null
)

data class StoryTitle(

	@field:SerializedName("matchLevel")
	val matchLevel: String? = null,

	@field:SerializedName("value")
	val value: String? = null,

	@field:SerializedName("matchedWords")
	val matchedWords: List<Any?>? = null
)

data class HitsItem(

	@field:SerializedName("comment_text")
	val commentText: String? = null,

	@field:SerializedName("story_text")
	val storyText: Any? = null,

	@field:SerializedName("author")
	val author: String? = null,

	@field:SerializedName("story_id")
	val storyId: Int? = null,

	@field:SerializedName("_tags")
	val tags: List<String?>? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("created_at_i")
	val createdAtI: Int? = null,

	@field:SerializedName("title")
	val title: Any? = null,

	@field:SerializedName("url")
	val url: Any? = null,

	@field:SerializedName("points")
	val points: Any? = null,

	@field:SerializedName("_highlightResult")
	val highlightResult: HighlightResult? = null,

	@field:SerializedName("num_comments")
	val numComments: Any? = null,

	@field:SerializedName("story_title")
	val storyTitle: String? = null,

	@field:SerializedName("parent_id")
	val parentId: Int? = null,

	@field:SerializedName("story_url")
	val storyUrl: String? = null,

	@field:SerializedName("objectID")
	val objectID: String? = null
)
