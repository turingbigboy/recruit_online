package com.yyjj.db.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yml
 * @since 2020-03-18
 */
@TableName("user_make")
public class UserMake implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户收藏id
     */
    private Integer id;

    /**
     * 用户收藏id
     */
    private Integer userId;

    /**
     * 职位id
     */
    private Integer positionId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return "UserMake{" +
            "id=" + id +
            ", userId=" + userId +
            ", positionId=" + positionId +
        "}";
    }
}
