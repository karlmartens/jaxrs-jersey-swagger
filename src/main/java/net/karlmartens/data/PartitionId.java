package net.karlmartens.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PartitionId {

    @JsonProperty
    public String realm;

    @JsonProperty
    public String namespace;

}
