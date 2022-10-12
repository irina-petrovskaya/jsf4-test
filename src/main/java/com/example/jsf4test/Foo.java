package com.example.jsf4test;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.Arrays;
import java.util.List;

/**
 * *
 * <p>Created by irina on 10/3/2022.</p>
 * <p>Project: jsf4-test</p>
 * *
 */
@Named
@RequestScoped
public class Foo {
    private String id = "foo";
    private String message = "Java Pages Test";
    private boolean flag = true;
    private final List<String> mylist = Arrays.asList("aaa","bbb","ccc");

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public List<String> getMylist() {
        return mylist;
    }

    public boolean isFlag() {
        return flag;
    }

    public String getSome_str() {
        return "_value";
    }
}
