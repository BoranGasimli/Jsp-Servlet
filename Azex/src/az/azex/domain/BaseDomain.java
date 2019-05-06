package az.azex.domain;

import java.io.Serializable;
import java.util.Objects;

public class   BaseDomain implements Serializable {

    protected long id;
    protected Status status;

    public BaseDomain() {
        this.id = 0l;
        this.status = Status.ACTIVE;
    }

    public BaseDomain(long id, Status status) {
        this.id = id;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseDomain that = (BaseDomain) o;
        return id == that.id &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BaseDomain{" +
                "id=" + id +
                ", status=" + status +
                '}';
    }
}
