package net.karlmartens.data;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

@JsonTypeName("delete")
public class Delete extends Mutation {

    @JsonUnwrapped
    public Key _key;

    @Override
    public void visit(MutationVisitor visitor) {
        visitor.onDelete(this);
    }
}
