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
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "departmentId", type = IdType.AUTO)
    private Integer departmentId;

    @TableField("departmentName")
    private String departmentName;

    private String description;

    @TableField("companyId")
    private Integer companyId;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "Department{" +
            "departmentId=" + departmentId +
            ", departmentName=" + departmentName +
            ", description=" + description +
            ", companyId=" + companyId +
        "}";
    }
}
