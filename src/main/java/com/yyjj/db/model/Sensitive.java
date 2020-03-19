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
public class Sensitive implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 敏感词id
     */
    private Integer id;

    /**
     * 敏感词
     */
    private String sensitive;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getSensitive() {
        return sensitive;
    }

    public void setSensitive(String sensitive) {
        this.sensitive = sensitive;
    }

    @Override
    public String toString() {
        return "Sensitive{" +
            "id=" + id +
            ", sensitive=" + sensitive +
        "}";
    }
}
