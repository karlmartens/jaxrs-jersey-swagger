package net.karlmartens.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.List;


public class BatchCommitResponse {

    private List<MutationResult> _results;

    @JsonValue
    private List<MutationResult> results() {
        return _results;
    }

    @JsonCreator
    public static BatchCommitResponse newInstance(List<MutationResult> results) {
        BatchCommitResponse r = new BatchCommitResponse();
        r._results = results;
        return r;
    }
}
