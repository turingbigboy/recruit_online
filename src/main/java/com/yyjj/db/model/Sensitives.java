package com.yyjj.db.model;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yml
 * @since 2020-03-18
 */
public class Sensitives implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 敏感词id
     */
    private Integer id;

    /**
     * 敏感词
     */
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Sensitives [id=" + id + ", name=" + name + "]";
	}
  
}
