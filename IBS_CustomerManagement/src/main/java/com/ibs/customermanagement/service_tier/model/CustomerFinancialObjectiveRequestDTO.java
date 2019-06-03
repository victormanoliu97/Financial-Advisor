package com.ibs.customermanagement.service_tier.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONException;
import org.json.JSONObject;

@Getter
@Setter
public class CustomerFinancialObjectiveRequestDTO {

    private int id;
    private Integer customerId;
    private double income;
    private double objectiveValue;
    private int years;

    @Override
    public String toString() {
        JSONObject responseJson = new JSONObject();
        try {
            responseJson.put("customerId", customerId)
                    .put("income", income)
                    .put("objectiveValue", objectiveValue)
                    .put("years", years);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(String.valueOf(responseJson)).getAsJsonObject();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        return gson.toJson(jsonObject);
    }
}
