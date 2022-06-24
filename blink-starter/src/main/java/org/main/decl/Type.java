package org.main.decl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.With;

@Data
@AllArgsConstructor
public class Type {
    public static final Type INT = new Type("integer", true);
    public static final Type STRING = new Type("string", true);
    public static final Type BOOL = new Type("bool", true);
    public static final Type NIL = new Type("nil");
    public static final Type VOID = new Type("void");
    public static final Type ERROR = new Type("error");

    private String name;
    private Boolean isPrimitive;
    @With private Integer dimensions = 0;

    public Type(String name) {
        this.name = name;
        this.isPrimitive = false;
    }

    public Type(String name, Boolean isPrimitive) {
        this.name = name;
        this.isPrimitive = isPrimitive;
    }

    public Type lessDimensions(Integer dimensions) {
        return this.withDimensions(this.dimensions - dimensions);
    }

    @Override
    public String toString() {
        String value = this.name;
        if(this.dimensions > 0) {
            value += "[" + this.dimensions + "]";
        }
        return value;
    }

    public static boolean isPredeclaredType(String name) {
        return name.equals(INT.getName()) || name.equals(STRING.getName()) || name.equals(BOOL.getName());
    }
}
