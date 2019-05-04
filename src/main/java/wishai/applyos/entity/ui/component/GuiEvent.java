package wishai.applyos.entity.ui.component;

import wishai.applyos.entity.ui.component.basic.OSView;

public class GuiEvent {

    private OSView source;


    public GuiEvent(OSView source) {
        this.source = source;
    }

    public OSView getSource() {
        return source;
    }

}
