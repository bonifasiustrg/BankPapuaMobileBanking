package com.takasima.bankpapuamb.data.model

data class Invoice(
    val noReferensi: String,
    val nama: String? = null,
    val tanggal: String,
    val rekAsal: String? = null,
    val noTujuan: String? = null,
    val jenisTransaksi: String,
    val nominal: Int,
    val adminFee: Int = 0,
    val noKendaraan: String? = null,
)