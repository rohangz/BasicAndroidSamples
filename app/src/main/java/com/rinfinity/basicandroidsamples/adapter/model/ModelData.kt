package com.rinfinity.basicandroidsamples.adapter.model

abstract class BaseModel

data class NoteData(var noteTitle: String = "", var noteDescription: String = "")

data class GridItemData(var data: String="")