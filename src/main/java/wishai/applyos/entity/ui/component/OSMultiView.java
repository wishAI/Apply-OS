package wishai.applyos.entity.ui.component;

import wishai.applyos.entity.ui.OSGui;

import java.util.Collection;

public abstract class OSMultiView extends OSView {

    private Collection<SubView> subViews;


    public void add(OSView view, int x, int y) {
        this.subViews.add(new SubView(view, x, y));
    }

    private class SubView {
        OSView view;
        int x;
        int y;

        public SubView(OSView view, int x, int y) {
            this.view = view;
            this.x = x;
            this.y = y;
        }
    }

    @Override
    public void render(OSGui gui, int x, int y) {
        super.render(gui, x, y);

        for (SubView subView : subViews)
            subView.view.render(gui, x + subView.x, y + subView.y);
    }

    @Override
    protected void render(OSGui gui) {
    }

}
