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
@TableName("t_employee_train")
@ApiModel(value="EmployeeTrain对象", description="")
public class EmployeeTrain implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "员工编号")
    private Integer eid;

    @ApiModelProperty(value = "培训日期")
    @TableField("trainDate")
    private LocalDate trainDate;

    @ApiModelProperty(value = "培训内容")
    @TableField("trainContent")
    private String trainContent;

    @ApiModelProperty(value = "备注")
    private String remark;


}
