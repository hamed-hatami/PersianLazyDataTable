package ir.hatami.persian.grid;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIPanel;

/**
 * @Author : Hamed Hatami
 */

@FacesComponent("ir.hatami.persian.grid.PersianDataOrderer")
public class PersianDataOrderer extends UIPanel {

    private static final String DEFAULT_RENDERER = "ir.hatami.persian.grid.PersianDataOrderer";
    public static final String COMPONENT_FAMILY = "ir.hatami.persian.grid.PersianDataOrdererComponent";

    protected enum PropertyKeys {
        styleClass, model, field, value, ascStyleClass, descStyleClass;
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

    public PersianDataOrderer() {
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

    public PersianLazyDataModel getModel() {
        return (PersianLazyDataModel) getStateHelper().eval(PropertyKeys.model, null);
    }

    public void setModel(PersianLazyDataModel model) {
        getStateHelper().put(PropertyKeys.model, model);
    }

    public Object getField() {
        return (Object) getStateHelper().eval(PropertyKeys.field, null);
    }

    public void setField(Object field) {
        getStateHelper().put(PropertyKeys.field, field);
    }

    public String getValue() {
        return (String) getStateHelper().eval(PropertyKeys.value, null);
    }

    public void setValue(String value) {
        getStateHelper().put(PropertyKeys.value, value);
    }

    public String getAscStyleClass() {
        return (String) getStateHelper().eval(PropertyKeys.ascStyleClass, null);
    }

    public void setAscStyleClass(String ascStyleClass) {
        getStateHelper().put(PropertyKeys.ascStyleClass, ascStyleClass);
    }

    public String getDescStyleClass() {
        return (String) getStateHelper().eval(PropertyKeys.descStyleClass, null);
    }

    public void setDescStyleClass(String descStyleClass) {
        getStateHelper().put(PropertyKeys.descStyleClass, descStyleClass);
    }
}
