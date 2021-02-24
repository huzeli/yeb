package com.org.hu.controller;


import com.org.hu.pojo.Position;
import com.org.hu.pojo.RespBean;
import com.org.hu.service.IPositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2021-02-20
 */
@RestController
@RequestMapping("/system/config/pos")
public class PositionController {

    @Autowired
    private IPositionService positionService;
    /**
     * 获取所有职位信息
     */

    @ApiOperation(value = "获取所有职位信息")
    @GetMapping("/")
    public List<Position> getAllPositions(){
        return positionService.list();
    }

    /**
     * 添加职位信息
     */
    @ApiOperation(value = "添加职位信息")
    @PostMapping("/")
    public RespBean addPosition(@RequestBody Position position){
        position.setCreateDate(LocalDateTime.now());
        if(positionService.save(position)){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败！");
    }

    @ApiOperation(value = "更新职位信息")
    @PutMapping("/")
    public RespBean updatePosition(@RequestBody Position position){
        if(positionService.updateById(position)){
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败!");
    }

    @ApiOperation(value = "删除职位信息")
    @DeleteMapping("/")
    public RespBean deletePosition(@PathVariable Integer id){
        if(positionService.removeById(id)){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败!");
    }

    @ApiOperation(value = "批量删除职位信息")
    @DeleteMapping("/{id}")
    public RespBean deletePositions(@PathVariable Integer[] ids){
        if(positionService.removeByIds(Arrays.asList(ids))){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败!");
    }
}
