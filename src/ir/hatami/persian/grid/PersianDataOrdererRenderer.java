package ir.hatami.persian.grid;

import javax.faces.component.UIComponent;
import javax.faces.component.UIParameter;
import javax.faces.component.html.HtmlOutcomeTargetLink;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;
import java.io.IOException;

/**
 * @Author : Hamed Hatami
 */

@FacesRenderer(rendererType = "ir.hatami.persian.grid.PersianDataOrderer",
        componentFamily = "ir.hatami.persian.grid.PersianDataOrdererComponent")
public class PersianDataOrdererRenderer extends Renderer {

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {

        PersianDataOrderer dataOrderer = (PersianDataOrderer) component;
        ResponseWriter writer = context.getResponseWriter();
        PersianLazyDataModel model = dataOrderer.getModel();


        writer.startElement("span", dataOrderer);
        writer.writeAttribute("id", dataOrderer.getClientId(context), "id");


        String spanClass = "";
        if (dataOrderer.getField().equals(model.getSortField())) {
            if (model.getSortOrder()) {
                spanClass = dataOrderer.getAscStyleClass();
            } else {
                spanClass = dataOrderer.getDescStyleClass();
            }
        }
        if (dataOrderer.getStyleClass() != null) {
            spanClass = String.format("%s %s", spanClass, dataOrderer.getStyleClass());
        }
        writer.writeAttribute("class", spanClass, "styleClass");


        HtmlOutcomeTargetLink link = new HtmlOutcomeTargetLink();
        link.setIncludeViewParams(true);
        link.setValue(dataOrderer.getValue());
        link.setOutcome(context.getViewRoot().getViewId());

        UIParameter parSort = new UIParameter();
        parSort.setName("sort");
        parSort.setValue(dataOrderer.getField().toString());

        UIParameter parOrder = new UIParameter();
        parOrder.setName("order");
        if (dataOrderer.getField().equals(model.getSortField())) {
            parOrder.setValue(model.getSortOrder() ? "desc" : "asc");
        } else {
            parOrder.setValue("asc");
        }

        link.getChildren().add(parSort);
        link.getChildren().add(parOrder);
        link.encodeBegin(context);
        link.encodeChildren(context);
        link.encodeEnd(context);


        writer.endElement("span");
    }
}
