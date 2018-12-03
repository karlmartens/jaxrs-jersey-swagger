package net.karlmartens.data;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

@JsonTypeName("put")
public class Put extends Mutation {

    @JsonUnwrapped
    public Entity entity;

    @Override
    public void visit(MutationVisitor visitor) {
        visitor.onPut(this);
    }
}
