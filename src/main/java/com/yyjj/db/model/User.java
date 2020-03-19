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
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "userId", type = IdType.AUTO)
    private Integer userId;

    private String account;

    private String password;

    private String name;

    private Integer gender;

    private Integer birthYear;

    private String nickname;

    private String email;

    private String province;

    private String city;

    private String eduDegree;

    private String graduation;

    private Integer graYear;

    private String major;

    private Integer dirDesire;
    
    private Integer state;
    public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getEduDegree() {
        return eduDegree;
    }

    public void setEduDegree(String eduDegree) {
        this.eduDegree = eduDegree;
    }
    public String getGraduation() {
        return graduation;
    }

    public void setGraduation(String graduation) {
        this.graduation = graduation;
    }
    public Integer getGraYear() {
        return graYear;
    }

    public void setGraYear(Integer graYear) {
        this.graYear = graYear;
    }
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    public Integer getDirDesire() {
        return dirDesire;
    }

    public void setDirDesire(Integer dirDesire) {
        this.dirDesire = dirDesire;
    }

	@Override
	public String toString() {
		return "User [userId=" + userId + ", account=" + account + ", password=" + password + ", name=" + name
				+ ", gender=" + gender + ", birthYear=" + birthYear + ", nickname=" + nickname + ", email=" + email
				+ ", province=" + province + ", city=" + city + ", eduDegree=" + eduDegree + ", graduation="
				+ graduation + ", graYear=" + graYear + ", major=" + major + ", dirDesire=" + dirDesire + ", state="
				+ state + "]";
	}

	

    
}
