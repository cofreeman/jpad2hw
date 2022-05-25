package com.nhnacademy.springjpa.idClass;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
public class ViewId implements Serializable{

    private int postNo;
    private int userNo;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ViewId viewId = (ViewId) object;
        return Objects.equals(postNo, viewId.postNo) && Objects.equals(userNo, viewId.userNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userNo, postNo);
    }
}