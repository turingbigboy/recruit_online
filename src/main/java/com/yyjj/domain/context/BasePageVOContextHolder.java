package com.yyjj.domain.context;


import com.yyjj.domain.service.BasePageVO;

public class BasePageVOContextHolder {
    
    private static final ThreadLocal<BasePageVO> basePageVOHolder = new ThreadLocal<>();
    
    public static BasePageVO getBasePageVO() {
        BasePageVO basePageVO = basePageVOHolder.get();
        basePageVOHolder.remove();
        return basePageVO;
    }
    
    public static void setBasePageVO(BasePageVO basePageVO) {
        basePageVOHolder.set(basePageVO);
    }

}
