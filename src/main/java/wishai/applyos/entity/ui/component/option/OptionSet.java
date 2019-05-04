package wishai.applyos.entity.ui.component.option;

import java.util.ArrayList;
import java.util.List;


public class OptionSet {

    private List<OptionView> options;


    public OptionSet() {
        this.options = new ArrayList<>();
    }

    public void add(OptionView option) {
        this.options.add(option);
        option.setOptionSet(this);
    }

    public OptionView getSelected() {
        for (OptionView option : options)
            if (option.isSelected())
                return option;

        return null;
    }

    public void setSelected(OptionView target) {
        for (OptionView option : options)
            option.setSelected(false);

        target.setSelected(true);
    }

//    public OptionView getOption(int idx) {
//        return options.get(idx);
//    }

    public List<OptionView> getOptions() {
        return options;
    }

    public void clear() {
        this.options.clear();
    }

}
