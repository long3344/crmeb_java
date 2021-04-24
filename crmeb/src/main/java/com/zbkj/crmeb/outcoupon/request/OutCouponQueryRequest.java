package com.zbkj.crmeb.outcoupon.request;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("eb_store_coupon")
@ApiModel(value="StoreCouponRequest对象", description="优惠券表")
public class OutCouponQueryRequest implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "优惠券名称", required = true)
    private String name;

    @ApiModelProperty(value = "状态（0：关闭，1：开启）")
    private Boolean status;
}
