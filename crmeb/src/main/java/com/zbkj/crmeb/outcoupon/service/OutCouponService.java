package com.zbkj.crmeb.outcoupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.PageParamRequest;
import com.zbkj.crmeb.outcoupon.model.OutCoupon;

import java.util.List;

/**
 * @author wb-twl390144
 * @date 2021/02/25
 */
public interface OutCouponService extends IService<OutCoupon> {

    List<OutCoupon> getList(PageParamRequest pageParamRequest);
}
