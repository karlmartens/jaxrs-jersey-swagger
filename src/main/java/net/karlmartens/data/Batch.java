package net.karlmartens.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Batch {

    @JsonProperty
    public List<Mutation> mutations = new ArrayList<>();

}
