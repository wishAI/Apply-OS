package wishai.applyos.ui.component;

import wishai.applyos.ui.OSGui;
import wishai.applyos.ui.component.basic.OSView;

import java.util.ArrayList;
import java.util.List;

public class OSMultiView extends OSView {

    private List<SubView> subViews;


    public OSMultiView() {
        this.subViews = new ArrayList<>();
    }

    public void add(OSView view, int x, int y) {
        this.subViews.add(new SubView(view, x, y));
    }

    public void remove(OSView view) {
        for (SubView subView : subViews) {
            if (subView.view == view) {
                this.subViews.remove(subView);
                return;
            }
        }
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
