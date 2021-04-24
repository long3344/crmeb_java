package com.zbkj.crmeb.outcoupon.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author long
 * @date 2021/02/25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("eb_out_coupon")
@ApiModel(value = "OutCoupon对象", description = "外部优惠券表")
public class OutCoupon implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "优惠券表ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "横幅图片")
    private String bannerPic;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "小程序")
    private String minApp;

    @ApiModelProperty(value = "优惠券名称")
    private String name;

    @ApiModelProperty(value = "优惠券数量")
    private Integer sort;

    @ApiModelProperty(value = "菜单id")
    private Integer tabId;

    @ApiModelProperty(value = "优惠券类型")
    private Integer type;

    @ApiModelProperty(value = "优惠券领取地址")
    private String url;

    @ApiModelProperty(value = "状态（0：关闭，1：开启）")
    private Boolean status;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}
