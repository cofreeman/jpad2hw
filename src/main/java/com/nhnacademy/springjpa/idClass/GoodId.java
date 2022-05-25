package com.nhnacademy.springjpa.idClass;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
public class GoodId implements Serializable {
    private int postNo;
    private int userNo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodId goodId = (GoodId) o;
        return postNo == goodId.postNo && userNo == goodId.userNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(postNo, userNo);
    }
}
