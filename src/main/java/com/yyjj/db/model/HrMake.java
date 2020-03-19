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
@TableName("hr_make")
public class HrMake implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * hr收藏id
     */
    private Integer id;

    /**
     * hrid
     */
    private Integer hrId;

    /**
     * 简历id
     */
    private Integer resumeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getHrId() {
        return hrId;
    }

    public void setHrId(Integer hrId) {
        this.hrId = hrId;
    }
    public Integer getResumeId() {
        return resumeId;
    }

    public void setResumeId(Integer resumeId) {
        this.resumeId = resumeId;
    }

    @Override
    public String toString() {
        return "HrMake{" +
            "id=" + id +
            ", hrId=" + hrId +
            ", resumeId=" + resumeId +
        "}";
    }
}
