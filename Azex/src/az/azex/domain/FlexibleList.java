package az.azex.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FlexibleList extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 1601384639726303157L;

    private String name;
    private List<FlexibleListItem> itemList;

    public FlexibleList() {
        this.name = "";
        this.itemList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FlexibleListItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<FlexibleListItem> itemList) {
        this.itemList = itemList;
    }

    public void add(FlexibleListItem item) {
        getItemList().add(item);
    }
}
