package com.yyjj.db.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * <p>
 * 
 * </p>
 *
 * @author yml
 * @since 2020-03-18
 */
public class Lable implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer lableClassId;

    private Integer lableSortId;

    private Integer positionId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getLableClassId() {
        return lableClassId;
    }

    public void setLableClassId(Integer lableClassId) {
        this.lableClassId = lableClassId;
    }
    public Integer getLableSortId() {
        return lableSortId;
    }

    public void setLableSortId(Integer lableSortId) {
        this.lableSortId = lableSortId;
    }
    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    @Override
    public String toString() {
        return "Lable{" +
            "id=" + id +
            ", lableClassId=" + lableClassId +
            ", lableSortId=" + lableSortId +
            ", positionId=" + positionId +
        "}";
    }
}
