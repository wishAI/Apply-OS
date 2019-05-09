package wishai.applyos.ui.component;

import wishai.applyos.ui.component.basic.OSView;

public class GuiEvent {

    private OSView source;


    public GuiEvent(OSView source) {
        this.source = source;
    }

    public OSView getSource() {
        return source;
    }

}
