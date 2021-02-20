package com.org.hu.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2021-02-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_employee_ec")
@ApiModel(value="EmployeeEc对象", description="")
public class EmployeeEc implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "员工编号")
    private Integer eid;

    @ApiModelProperty(value = "奖罚日期")
    @TableField("ecDate")
    private LocalDate ecDate;

    @ApiModelProperty(value = "奖罚原因")
    @TableField("ecReason")
    private String ecReason;

    @ApiModelProperty(value = "奖罚分")
    @TableField("ecPoint")
    private Integer ecPoint;

    @ApiModelProperty(value = "奖罚类别，0：奖，1：罚")
    @TableField("ecType")
    private Integer ecType;

    @ApiModelProperty(value = "备注")
    private String remark;


}