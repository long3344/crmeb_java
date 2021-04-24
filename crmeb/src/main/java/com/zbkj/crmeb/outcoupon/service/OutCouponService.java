package com.zbkj.crmeb.outcoupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.PageParamRequest;
import com.zbkj.crmeb.outcoupon.model.OutCoupon;
import com.zbkj.crmeb.outcoupon.request.OutCouponQueryRequest;

import java.util.List;

/**
 * @author long
 * @date 2021/02/25
 */
public interface OutCouponService extends IService<OutCoupon> {

    List<OutCoupon> getList(OutCouponQueryRequest request, PageParamRequest paramRequest);

    boolean create(OutCouponQueryRequest request);
}
