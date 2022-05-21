package com.example.nutracker.extensions

import com.example.nutracker.model.Fruit
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class FruitSerialize: JsonDeserializer<Fruit>{
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Fruit {
        val fruitObject = json?.getAsJsonObject()
        val id: Long? = fruitObject?.get("id")?.asLong;
        val nutritions = fruitObject?.getAsJsonObject("nutritions")
        val name: String? = fruitObject?.get("name")?.asString
        val family: String? = fruitObject?.get("family")?.asString
        val genus: String? = fruitObject?.get("genus")?.asString
        val order: String? = fruitObject?.get("order")?.asString
        val calories: Float?  = nutritions?.get("calories")?.asFloat
        val carbohydrates: Float?  = nutritions?.get("carbohydrates")?.asFloat
        val protein: Float?  = nutritions?.get("protein")?.asFloat
        val fat: Float?  = nutritions?.get("fat")?.asFloat

        println(fruitObject);
        println(nutritions);
        return Fruit(id,name,family,genus,order,calories,carbohydrates,protein,fat)
    }
}