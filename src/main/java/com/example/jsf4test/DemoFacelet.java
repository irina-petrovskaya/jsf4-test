package com.example.jsf4test;
import static jakarta.faces.application.StateManager.IS_BUILDING_INITIAL_STATE;

import jakarta.el.ELContext;
import jakarta.el.ExpressionFactory;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.annotation.View;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.UIOutput;
import jakarta.faces.component.html.*;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.facelets.Facelet;

import java.io.IOException;
import java.util.List;

@View("/java_pages/demo.xhtml")// would be ice to make this route resolved
@ApplicationScoped
public class DemoFacelet extends Facelet {
    @Override
    public void apply(FacesContext facesContext, UIComponent root) throws IOException {
        if (!facesContext.getAttributes().containsKey(IS_BUILDING_INITIAL_STATE)) {
            return;
        }
        ELContext elContext = facesContext.getELContext();
        ExpressionFactory expressionFactory = facesContext.getApplication().getExpressionFactory();
        ComponentBuilder components = new ComponentBuilder(facesContext);
        List<UIComponent> rootChildren = root.getChildren();
        UIOutput output = new UIOutput();
        output.setValue("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
        rootChildren.add(output);
        HtmlBody body = components.create(HtmlBody.COMPONENT_TYPE);
        rootChildren.add(body);
        HtmlOutputText fromEL = new HtmlOutputText();
        fromEL.setValueExpression("value", expressionFactory.createValueExpression(elContext, "#{foo.message}", String.class));
        body.getChildren().add(fromEL);
        HtmlForm form = components.create(HtmlForm.COMPONENT_TYPE);
        form.setId("form");
        body.getChildren().add(form);
        HtmlOutputLabel label = components.create(HtmlOutputLabel.COMPONENT_TYPE);
        label.setValue("Enter your name");
        form.getChildren().add(label);
        HtmlInputText message = components.create(HtmlInputText.COMPONENT_TYPE);
        message.setId("message");
        form.getChildren().add(message);
        HtmlOutputText text = components.create(HtmlOutputText.COMPONENT_TYPE);
        form.getChildren().add(text);
        HtmlCommandButton actionButton = components.create(HtmlCommandButton.COMPONENT_TYPE);
        actionButton.setId("button");
        actionButton.addActionListener(e -> text.setValue("Hi " + message.getValue()));
        actionButton.setValue("Do action");
        form.getChildren().add(actionButton);
        output = new UIOutput();
        output.setValue("</html>");
        rootChildren.add(output);
    }
    private static class ComponentBuilder {
        FacesContext facesContext;
        ComponentBuilder(FacesContext facesContext) {
            this.facesContext = facesContext;
        }
        @SuppressWarnings("unchecked")
        <T> T create(String componentType) {
            return (T) facesContext.getApplication().createComponent(facesContext, componentType, null);
        }
    }
}
