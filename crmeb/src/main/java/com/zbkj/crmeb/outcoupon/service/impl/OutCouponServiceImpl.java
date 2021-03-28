package com.zbkj.crmeb.outcoupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.PageParamRequest;
import com.github.pagehelper.PageHelper;
import com.zbkj.crmeb.outcoupon.dao.OutCouponDao;
import com.zbkj.crmeb.outcoupon.model.OutCoupon;
import com.zbkj.crmeb.outcoupon.service.OutCouponService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * StoreCouponServiceImpl 接口实现
 * +----------------------------------------------------------------------
 * | CRMEB [ CRMEB赋能开发者，助力企业发展 ]
 * +----------------------------------------------------------------------
 * | Copyright (c) 2016~2020 https://www.crmeb.com All rights reserved.
 * +----------------------------------------------------------------------
 * | Licensed CRMEB并不是自由软件，未经许可不能去掉CRMEB相关版权
 * +----------------------------------------------------------------------
 * | Author: CRMEB Team <admin@crmeb.com>
 * +----------------------------------------------------------------------
 */
@Service
public class OutCouponServiceImpl extends ServiceImpl<OutCouponDao, OutCoupon> implements OutCouponService {

    @Resource
    private OutCouponDao dao;

    @Override
    public List<OutCoupon> getList(PageParamRequest pageParamRequest) {
        PageHelper.startPage(pageParamRequest.getPage(), pageParamRequest.getLimit());
        LambdaQueryWrapper<OutCoupon> outCouponLambdaQueryWrapper = new LambdaQueryWrapper<>();
        outCouponLambdaQueryWrapper.orderByDesc(OutCoupon::getSort).orderByDesc(OutCoupon::getId);
        return dao.selectList(outCouponLambdaQueryWrapper);
    }
}
