package com.wircodeteam.ecommercedemo.base;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;


@MappedSuperclass
@Data
public abstract class BaseEntity<T extends Serializable> implements Serializable {
    @Id
    private T id;

    private String name;

    private boolean isDeleted;

    @Column(updatable = false)
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime updatedDate;

    @Column
    private LocalDateTime deletedDate;

    public BaseEntity() {
        createdDate = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity<?> that = (BaseEntity<?>) o;
        return that.id == this.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
