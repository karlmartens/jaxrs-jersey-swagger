package net.karlmartens.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public class BeginBatchResponse {

    public String batchId;

    @JsonValue
    public String toString() {
        return batchId;
    }

    @JsonCreator
    public static BeginBatchResponse newInstance(String batchId) {
        BeginBatchResponse r = new BeginBatchResponse();
        r.batchId = batchId;
        return r;
    }
}
