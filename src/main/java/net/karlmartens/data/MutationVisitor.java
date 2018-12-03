package net.karlmartens.data;

public interface MutationVisitor {

    void onPut(Put put);

    void onDelete(Delete delete);

}
