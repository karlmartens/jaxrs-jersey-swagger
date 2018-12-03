package net.karlmartens.data;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Put.class, name = "put"),
        @JsonSubTypes.Type(value = Delete.class, name = "delete")
})
public abstract class Mutation {

    public abstract void visit(MutationVisitor visitor);

}
