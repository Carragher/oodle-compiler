package com.bju.cps450;

/**
 * Created by carragher on 3/12/16.
 */
public class Type {
public static final Type error = new Type("<error>"),
    integer = new Type("int"),
    bool = new Type("boolean"),
    string = new Type("string"),
    array = new Type("array");

    protected String name;

    protected Type(String name){
        this.name = name;
    }
}
