package net.karlmartens.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MutationResult {

    @JsonProperty
    public Key key;

    @JsonProperty
    public Integer version;

    @JsonProperty
    public List<String> errors;

}
