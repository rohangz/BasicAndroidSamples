package com.rinfinity.basicandroidsamples.adapter.model

import android.net.Uri

abstract class BaseModel

data class NoteData(var noteTitle: String = "", var noteDescription: String = "")

data class GridItemData(var data: String="")

data class ImageItemData(var imageUri: Uri?)