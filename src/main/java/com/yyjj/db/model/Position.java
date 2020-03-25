package com.yyjj.db.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yml
 * @since 2020-03-18
 */
public class Position implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
   
    /**
     * 职位标题
     */
    private String title;

    /**
     * 职位要求
     */
    private String requirement;

    /**
     * 招聘数量
     */
    private Integer quantity;

    /**
     * 工作地点
     */
    private String workCity;

    /**
     * 最高薪资
     */
    private Integer salaryUp;

    /**
     * 最低薪资
     */
    private Integer salaryDown;

    /**
     * 发布时间
     */
    private LocalDate releaseDate;

    /**
     * 有效时间
     */
    private LocalDate validDate;

    /**
     * 状态
     */
    private Integer state;

    /**
     * 阅读量
     */
    private Integer hits;

    /**
     * hrid
     */
    private Integer hrId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public String getWorkCity() {
        return workCity;
    }

    public void setWorkCity(String workCity) {
        this.workCity = workCity;
    }
    public Integer getSalaryUp() {
        return salaryUp;
    }

    public void setSalaryUp(Integer salaryUp) {
        this.salaryUp = salaryUp;
    }
    public Integer getSalaryDown() {
        return salaryDown;
    }

    public void setSalaryDown(Integer salaryDown) {
        this.salaryDown = salaryDown;
    }
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
    public LocalDate getValidDate() {
        return validDate;
    }

    public void setValidDate(LocalDate validDate) {
        this.validDate = validDate;
    }
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }
    public Integer getHrId() {
        return hrId;
    }

    public void setHrId(Integer hrId) {
        this.hrId = hrId;
    }

    @Override
    public String toString() {
        return "Position{" +
            "id=" + id +
            ", title=" + title +
            ", requirement=" + requirement +
            ", quantity=" + quantity +
            ", workCity=" + workCity +
            ", salaryUp=" + salaryUp +
            ", salaryDown=" + salaryDown +
            ", releaseDate=" + releaseDate +
            ", validDate=" + validDate +
            ", state=" + state +
            ", hits=" + hits +
            ", hrId=" + hrId +
        "}";
    }
}
