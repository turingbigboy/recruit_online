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
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 公司id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 公司名称
     */
  
    private String companyName;

    private Integer companyLogo;

    /**
     * 公司描述
     */
    private String description;

    /**
     * 公司状态
     */
    private Integer state;

    /**
     * 公司代码
     */

    private String companyCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public Integer getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(Integer companyLogo) {
        this.companyLogo = companyLogo;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    @Override
    public String toString() {
        return "Company{" +
            "id=" + id +
            ", companyName=" + companyName +
            ", companyLogo=" + companyLogo +
            ", description=" + description +
            ", state=" + state +
            ", companyCode=" + companyCode +
        "}";
    }
}
