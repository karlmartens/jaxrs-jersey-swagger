package net.karlmartens.data;

public interface AttributeValueVisitor<R, T extends Throwable> {

    R accept(boolean value) throws T;

    R accept(String value) throws T;

    R accept(int value) throws T;

    R accept(double value) throws T;

    R acceptNull() throws T;
}
