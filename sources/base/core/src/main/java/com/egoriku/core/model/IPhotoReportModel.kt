package com.egoriku.core.model

interface IComplexPhotoReportModel {

    val photoReports: List<IPhotoReportModel>
}

interface IPhotoReportModel {

    val date: String

    val description: String

    val images: List<String>
}