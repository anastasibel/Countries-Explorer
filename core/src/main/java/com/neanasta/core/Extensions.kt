package com.neanasta.core

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.widget.ImageView
import androidx.core.graphics.drawable.toBitmap
import coil.ImageLoader
import coil.request.ImageRequest
import java.io.ByteArrayOutputStream
import java.net.HttpURLConnection
import java.net.URL

fun Bitmap.bitmapToByteArray(
    format: Bitmap.CompressFormat = Bitmap.CompressFormat.PNG,
    quality: Int = 100
): ByteArray {
    return ByteArrayOutputStream().use { stream ->
        this.compress(format, quality, stream)
        stream.toByteArray()
    }
}

suspend fun String.loadBitmapFromUrl(context: Context): Bitmap? {
    return try {
        val loader = ImageLoader(context)
        val request = ImageRequest.Builder(context)
            .data(this)
            .allowHardware(false)
            .build()
        val result = loader.execute(request).drawable
        (result as? BitmapDrawable)?.bitmap
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}

suspend fun String.urlToByteArray(context: Context): ByteArray? {
    return this.loadBitmapFromUrl(context)?.bitmapToByteArray()
}

fun String.urlToByteArray(): ByteArray? {
    return try {
        val connection = URL(this).openConnection() as HttpURLConnection
        connection.inputStream.use { input ->
            ByteArrayOutputStream().use { output ->
                val buffer = ByteArray(4096)
                var bytesRead: Int
                while (input.read(buffer).also { bytesRead = it } != -1) {
                    output.write(buffer, 0, bytesRead)
                }
                output.toByteArray()
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}