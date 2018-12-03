package net.karlmartens.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Key {

    @JsonProperty
    public PartitionId partitionId;

    @JsonProperty
    public List<PathElement> path;

}
