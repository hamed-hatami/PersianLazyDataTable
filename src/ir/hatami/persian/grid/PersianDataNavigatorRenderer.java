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


@FacesRenderer(rendererType = "ir.hatami.persian.grid.PersianDataNavigator",
        componentFamily = "ir.hatami.persian.grid.PersianDataNavigatorComponent")
public class PersianDataNavigatorRenderer extends Renderer {

    private static final String DEFAULT_CURRENT_PAGE_CLASS = "current-page";

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {

        PersianDataNavigator dataNavigator = (PersianDataNavigator) component;
        ResponseWriter writer = context.getResponseWriter();
        PersianLazyDataModel model = dataNavigator.getModel();


        writer.startElement("div", dataNavigator);
        writer.writeAttribute("id", dataNavigator.getClientId(context), "id");
        if (dataNavigator.getStyleClass() != null) {
            writer.writeAttribute("class", dataNavigator.getStyleClass(), "styleClass");
        }


        String innerStyleClass = "";
        if (!dataNavigator.getInnerStyleClass().isEmpty()) {
            innerStyleClass = dataNavigator.getInnerStyleClass();
        }
        for (int i = 1; i <= model.getNumberOfPages(); i++) {

            writer.startElement("span", dataNavigator);

            if (model.getCurrentPage() == i) {
                writer.writeAttribute("class", String.format("%s %s", innerStyleClass, PersianDataNavigatorRenderer.DEFAULT_CURRENT_PAGE_CLASS), null);
            } else if (!innerStyleClass.isEmpty()) {
                writer.writeAttribute("class", innerStyleClass, null);
            }

            if (model.getCurrentPage() == i) {
                writer.writeText(i, null);
            } else {
                HtmlOutcomeTargetLink link = new HtmlOutcomeTargetLink();
                UIParameter par = new UIParameter();
                par.setName("page");
                par.setValue(i);
                link.setOutcome(context.getViewRoot().getViewId());
                link.getChildren().add(par);
                link.setIncludeViewParams(true);
                link.setValue(i);

                link.encodeBegin(context);
                link.encodeEnd(context);
            }
            writer.endElement("span");
        }
        writer.endElement("div");

    }
}
