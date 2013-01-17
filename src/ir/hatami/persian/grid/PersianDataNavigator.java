package ir.hatami.persian.grid;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UIPanel;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import java.io.IOException;
import java.util.Map;

/**
 * @Author : Hamed Hatami
 */

@FacesComponent("ir.hatami.persian.grid.PersianDataNavigator")
public class PersianDataNavigator extends UIPanel {

    private static final String DEFAULT_RENDERER = "ir.hatami.persian.grid.PersianDataNavigator";
    public static final String COMPONENT_FAMILY = "ir.hatami.persian.grid.PersianDataNavigatorComponent";

    protected enum PropertyKeys {
        styleClass, innerStyleClass, model;
        String toString;

        PropertyKeys(String toString) {
            this.toString = toString;
        }

        PropertyKeys() {
        }

        public String toString() {
            return ((this.toString != null) ? this.toString : super.toString());
        }
    }

    public PersianDataNavigator() {
        setRendererType(DEFAULT_RENDERER);
    }

    @Override
    public String getFamily() {
        return COMPONENT_FAMILY;
    }


    public String getStyleClass() {
        return (String) getStateHelper().eval(PropertyKeys.styleClass, null);
    }

    public void setStyleClass(String styleClass) {
        getStateHelper().put(PropertyKeys.styleClass, styleClass);
    }

    public String getInnerStyleClass() {
        return (String) getStateHelper().eval(PropertyKeys.innerStyleClass, null);
    }

    public void setInnerStyleClass(String innerStyleClass) {
        getStateHelper().put(PropertyKeys.innerStyleClass, innerStyleClass);
    }

    public PersianLazyDataModel getModel() {
        return (PersianLazyDataModel) getStateHelper().eval(PropertyKeys.model, null);
    }

    public void setModel(PersianLazyDataModel model) {
        getStateHelper().put(PropertyKeys.model, model);
    }

}



