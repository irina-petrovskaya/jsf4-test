package com.example.jsf4test.customComponents;

import jakarta.faces.component.FacesComponent;
import jakarta.faces.component.UIComponentBase;
import jakarta.faces.context.FacesContext;
import jakarta.faces.context.ResponseWriter;

import java.io.IOException;

@FacesComponent(tagName = "myCompoTag", createTag = true)
public class MyCustomComponentWithTag extends UIComponentBase
{
    String prop1;


    public String getProp1() {
        return prop1;
    }

    public void setProp1(String prop1) {
        this.prop1 = prop1;
    }

    @Override
    public String getFamily() {
        return "my.custom.components";
    }

    @Override
    public void encodeBegin(FacesContext context) throws IOException {
                   ResponseWriter writer = context.getResponseWriter();

        writer.write(this.getProp1());
    }
}
