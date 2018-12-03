package net.karlmartens.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PathElement {

    @JsonProperty
    public String kind;

    @JsonProperty
    public String name;

    @JsonProperty
    public Integer id;

}
