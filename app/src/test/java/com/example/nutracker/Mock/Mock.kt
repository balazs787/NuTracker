package com.example.nutracker.Mock

import android.net.Uri
import com.example.nutracker.di.NetworkConfig
import com.example.nutracker.model.Fruit
import com.google.gson.Gson
import okhttp3.*
import okio.BufferedSource
import okio.Okio
import java.io.ByteArrayInputStream

object Mock {
    fun process(request: Request): Response {
        val uri = Uri.parse(request.url().toString())

        val responseString: String
        val responseCode: Int
        val headers = request.headers()

        if (uri.path == NetworkConfig.SERVICE_ENDPOINT && request.method() == "GET") {
            val fruits = listOf(
                Fruit(1, "genus1", "fruit1", "family1", "order1", 1f, 1f, 1f, 1f, 1f),
                Fruit(2, "genus2", "fruit2", "family2", "order2", 1f, 1f, 1f, 1f, 1f),
                Fruit(3, "genus1", "fruit3", "family3", "order3", 1f, 1f, 1f, 1f, 1f),
                Fruit(4, "genus2", "fruit4", "family1", "order4", 1f, 1f, 1f, 1f, 1f),
                Fruit(5, "genus1", "fruit5", "family2", "order5", 1f, 1f, 1f, 1f, 1f),
                Fruit(6, "genus2", "fruit6", "family3", "order6", 1f, 1f, 1f, 1f, 1f),
                Fruit(7, "genus1", "fruit7", "family1", "order7", 1f, 1f, 1f, 1f, 1f)
            );
            responseString = Gson().toJson(fruits)
            responseCode = 200
        } else {
            responseString = "error"
            responseCode = 500
        }

        return createRsponseForMock(request, headers, responseCode, responseString)
    }

    public fun createRsponseForMock(request: Request, headers: Headers, code: Int, content: String): Response {
        val responseBody = object : ResponseBody() {
            override fun contentType(): MediaType? = MediaType.parse("application/json")

            override fun contentLength(): Long = content.toByteArray().size.toLong()

            override fun source(): BufferedSource = Okio.buffer(Okio.source(ByteArrayInputStream(content.toByteArray())))
        }

        return Response.Builder()
            .protocol(Protocol.HTTP_2)
            .code(code)
            .request(request)
            .headers(headers)
            .message("")
            .body(responseBody)
            .build()
    }
}