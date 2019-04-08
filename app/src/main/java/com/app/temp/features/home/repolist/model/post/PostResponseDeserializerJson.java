package com.app.temp.features.home.repolist.model.post;

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

public class PostResponseDeserializerJson implements JsonDeserializer<PostResponse> {

    @Override
    public PostResponse deserialize(JsonElement je, Type type, JsonDeserializationContext jdc)
            throws JsonParseException {
        PostResponse postResponse = new PostResponse();
        JsonArray jsonArray = je.getAsJsonArray();
        Gson gson = new Gson();
        for (JsonElement element : jsonArray) {
            Post post = gson.fromJson(element.getAsJsonObject(), Post.class);
            postResponse.add(post);
        }
        return postResponse;
    }
}
