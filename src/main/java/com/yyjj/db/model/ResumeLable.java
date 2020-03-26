package com.yyjj.db.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yml
 * @since 2020-03-26
 */
@TableName("resume_lable")
public class ResumeLable implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 简历类型关联id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 1级分类id
     */
    private Integer classifyId;

    /**
     * 二级分类id
     */
    private Integer sortId;

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
    public Integer getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Integer classifyId) {
        this.classifyId = classifyId;
    }
    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }
    public Integer getResumeId() {
        return resumeId;
    }

    public void setResumeId(Integer resumeId) {
        this.resumeId = resumeId;
    }

    @Override
    public String toString() {
        return "ResumeLable{" +
            "id=" + id +
            ", classifyId=" + classifyId +
            ", sortId=" + sortId +
            ", resumeId=" + resumeId +
        "}";
    }
}
