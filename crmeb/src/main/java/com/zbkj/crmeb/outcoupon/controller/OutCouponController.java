package com.zbkj.crmeb.outcoupon.controller;

import com.common.CommonPage;
import com.common.CommonResult;
import com.common.PageParamRequest;
import com.zbkj.crmeb.outcoupon.model.OutCoupon;
import com.zbkj.crmeb.outcoupon.request.OutCouponQueryRequest;
import com.zbkj.crmeb.outcoupon.service.OutCouponService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wb-twl390144
 * @date 2021/02/25
 */
@Slf4j
@RestController
@RequestMapping("api/admin/marketing/outCoupon")
@Api(tags = "外部-优惠券")
public class OutCouponController {

    @Autowired
    private OutCouponService outCouponService;

    @ApiOperation("外部优惠券分页列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult<CommonPage<OutCoupon>> getList(@Validated OutCouponQueryRequest request, @Validated PageParamRequest pageParamRequest) {
        CommonPage<OutCoupon> outCouponCommonPage = CommonPage.restPage(outCouponService.getList(request, pageParamRequest));
        return CommonResult.success(outCouponCommonPage);
    }

    @ApiOperation(value = "新增")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public CommonResult<String> save(@RequestBody @Validated OutCouponQueryRequest request) {
        if (outCouponService.create(request)) {
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }

}
