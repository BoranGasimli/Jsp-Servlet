package az.azex.domain;

public enum Status {
    ACTIVE, DELETED;

    public static Status fromValue(int value) {
        if(value == 1) {
            return Status.ACTIVE;
        } else {
            return Status.DELETED;
        }
    }
}
