package net.karlmartens.data;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class Entity {

    @JsonProperty
    public Key key;

    private Map<String, AttributeValue> _attributes = new HashMap<>();

    @JsonAnyGetter
    public Map<String, AttributeValue> attributes() {
        return _attributes;
    }

    @JsonAnySetter
    public void put(String attribute, AttributeValue value) {
        _attributes.put(attribute, value);
    }

}
