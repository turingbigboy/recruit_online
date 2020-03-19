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
@TableName("drop_box")
public class DropBox implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 投递箱
     */
    private Integer id;

    /**
     * 职位id
     */
    private Integer positionId;

    /**
     * 简历id
     */
    private Integer resumeId;

    /**
     * 投递状态 0:未审阅 1：已阅读 
     */
    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }
    public Integer getResumeId() {
        return resumeId;
    }

    public void setResumeId(Integer resumeId) {
        this.resumeId = resumeId;
    }
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "DropBox{" +
            "id=" + id +
            ", positionId=" + positionId +
            ", resumeId=" + resumeId +
            ", state=" + state +
        "}";
    }
}
