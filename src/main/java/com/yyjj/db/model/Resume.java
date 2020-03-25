package com.yyjj.db.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yml
 * @since 2020-03-25
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
     * 最低薪资
     */
    private Integer salaryDown;
    private String title;
    /**
     * 最高薪资
     */
    private Integer salaryUp;

    /**
     * 就职期望
     */
    private String jobDesire;

    /**
     * 阅读量
     */
    private Integer hits;

    private Integer state;

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

    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
    public Integer getSalaryDown() {
        return salaryDown;
    }

    public void setSalaryDown(Integer salaryDown) {
        this.salaryDown = salaryDown;
    }
    public Integer getSalaryUp() {
        return salaryUp;
    }

    public void setSalaryUp(Integer salaryUp) {
        this.salaryUp = salaryUp;
    }
    public String getJobDesire() {
        return jobDesire;
    }

    public void setJobDesire(String jobDesire) {
        this.jobDesire = jobDesire;
    }
    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
            ", salaryDown=" + salaryDown +
            ", salaryUp=" + salaryUp +
            ", jobDesire=" + jobDesire +
            ", hits=" + hits +
            ", state=" + state +
            ", publish=" + publish +
            ", userId=" + userId +
            ", publishTime=" + publishTime +
        "}";
    }
}
