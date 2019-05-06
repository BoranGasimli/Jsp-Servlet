package az.azex.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public class FlexibleListItem extends BaseDomain implements Serializable {

    private static final long serialVersionUID = -2535113646669417806L;

    private long listId;
    private long valueId;
    private String valueName;
    private LocalDateTime insertDate;

    public FlexibleListItem() {
        super(0, Status.ACTIVE);
        this.listId = listId;
        this.valueId = valueId;
        this.valueName = valueName;
    }

    public long getListId() {
        return listId;
    }

    public void setListId(long listId) {
        this.listId = listId;
    }

    public long getValueId() {
        return valueId;
    }

    public void setValueId(long valueId) {
        this.valueId = valueId;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public LocalDateTime getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(LocalDateTime insertDate) {
        this.insertDate = insertDate;
    }
}
