package com.example.inspiron.homework6;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by INSPIRON on 22-Dec-16.
 */

public class Response {

    @JsonProperty("definitions")
    private List<User> user = new ArrayList<User>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The user
     */
    @JsonProperty("definitions")
    public List<User> getUser() {
        return user;
    }

    /**
     *
     * @param user
     * The user
     */
    @JsonProperty("user")
    public void setUser(List<User> user) {
        this.user = user;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
