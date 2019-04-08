package com.app.temp.features.home.repolist.model.repository;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by nguyen_van_cuong on 23/11/2017.
 */

public class TopicResponseDeserializerJson implements JsonDeserializer<TopicResponse> {

    @Override
    public TopicResponse deserialize(JsonElement je, Type type, JsonDeserializationContext jdc)
            throws JsonParseException {
        TopicResponse topicResponse = new TopicResponse();
        JsonArray jsonArray = je.getAsJsonArray();
        Gson gson = new Gson();
        for (JsonElement element : jsonArray) {
            Topic topic = gson.fromJson(element.getAsJsonObject(), Topic.class);
            topicResponse.add(topic);
        }
        return topicResponse;
    }
}
