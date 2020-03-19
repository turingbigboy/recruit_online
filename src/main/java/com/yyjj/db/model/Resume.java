package com.yyjj.db.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
public class Resume implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 专业能力
     */
    private String ability;

    /**
     * 实习经历
     */
    private String internship;

    /**
     * 工作经历
     */
    private String workExperience;

    /**
     * 荣获奖项
     */
    private String certificate;

    /**
     * 就职期望
     */
    @TableField("jobDesire")
    private String jobDesire;

    /**
     * 是否发布
     */
    private Integer publish;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 发布时间
     */
    private LocalDateTime publishTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }
    public String getInternship() {
        return internship;
    }

    public void setInternship(String internship) {
        this.internship = internship;
    }
    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }
    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }
    public String getJobDesire() {
        return jobDesire;
    }

    public void setJobDesire(String jobDesire) {
        this.jobDesire = jobDesire;
    }
    public Integer getPublish() {
        return publish;
    }

    public void setPublish(Integer publish) {
        this.publish = publish;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public LocalDateTime getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(LocalDateTime publishTime) {
        this.publishTime = publishTime;
    }

    @Override
    public String toString() {
        return "Resume{" +
            "id=" + id +
            ", ability=" + ability +
            ", internship=" + internship +
            ", workExperience=" + workExperience +
            ", certificate=" + certificate +
            ", jobDesire=" + jobDesire +
            ", publish=" + publish +
            ", userId=" + userId +
            ", publishTime=" + publishTime +
        "}";
    }
}
