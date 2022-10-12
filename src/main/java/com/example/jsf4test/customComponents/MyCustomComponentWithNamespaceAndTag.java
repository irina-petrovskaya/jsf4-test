package com.example.jsf4test.customComponents;

import jakarta.faces.component.FacesComponent;
import jakarta.faces.component.UIComponentBase;
import jakarta.faces.context.FacesContext;
import jakarta.faces.context.ResponseWriter;

import java.io.IOException;

@FacesComponent(createTag=true, namespace = "jakarta.faces.irina_components",
        tagName = "myCompo")
public class MyCustomComponentWithNamespaceAndTag extends UIComponentBase {

    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getFamily() {
        return "my.custom.components";
    }

    @Override
    public void encodeBegin(FacesContext context) throws IOException {

        String value = (String) getAttributes().get("author");

        if (value != null) {
            ResponseWriter writer = context.getResponseWriter();
            writer.write(this.getMessage()+"; by "+value.toUpperCase());
        }
    }
}