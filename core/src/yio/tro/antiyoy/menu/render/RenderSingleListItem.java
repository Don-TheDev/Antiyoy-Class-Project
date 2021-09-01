package yio.tro.antiyoy.menu.render;

import yio.tro.antiyoy.menu.customizable_list.AbstractCustomListItem;
import yio.tro.antiyoy.menu.customizable_list.AbstractSingleLineItem;

public class RenderSingleListItem extends AbstractRenderCustomListItem {

    private AbstractSingleLineItem slItem;
    private float alpha;


    @Override
    public void loadTextures() {

    }


    @Override
    public void renderItem(AbstractCustomListItem item) {
        slItem = (AbstractSingleLineItem) item;
        alpha = slItem.customizableListYio.getFactor().get();

        renderTextOptimized(slItem.title, alpha);
        renderDefaultSelection(slItem);
    }
}
