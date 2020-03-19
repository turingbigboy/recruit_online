package com.yyjj.db.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yml
 * @since 2020-03-18
 */
public class Favor implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "favorId", type = IdType.AUTO)
    private Integer favorId;

    @TableField("userId")
    private Integer userId;

    @TableField("positionId")
    private Integer positionId;

    public Integer getFavorId() {
        return favorId;
    }

    public void setFavorId(Integer favorId) {
        this.favorId = favorId;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    @Override
    public String toString() {
        return "Favor{" +
            "favorId=" + favorId +
            ", userId=" + userId +
            ", positionId=" + positionId +
        "}";
    }
}
