package com.org.hu.controller;


import com.org.hu.pojo.Joblevel;
import com.org.hu.pojo.RespBean;
import com.org.hu.service.IJoblevelService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/system/basic/joblevel")
public class JoblevelController {

    @Autowired
    private IJoblevelService joblevelService;

    /**
     * 查询所有职称等级
     * @return
     */
    @ApiOperation("查询所有职称等级")
    @GetMapping("/")
    public List<Joblevel> getAllJobLevels(){
        return joblevelService.list();
    }

    /**
     * 添加职称
     */
    @ApiOperation("添加职称")
    @PostMapping("/")
    public RespBean addJobLevel(@RequestBody Joblevel joblevel){
      if(joblevelService.save(joblevel)){
          return RespBean.success("添加成功！！！");
      }else{
          return RespBean.error("添加失败");
      }
    }

    /**
     * 修改职称
     */
    @ApiOperation("修改职称")
    @PutMapping("/")
    public RespBean updateJobLevel(@RequestBody Joblevel joblevel){
        if(joblevelService.updateById(joblevel)){
            return RespBean.success("修改成功");
        }else{
            return RespBean.error("修改失败");
        }
    }

    /**
     * 删除职称
     */
    @ApiOperation("删除职称")
    @DeleteMapping("/{id}")
    public RespBean deleteJobLevel(@PathVariable Integer id){
        if(joblevelService.removeById(id)){
            return RespBean.success("删除成功");
        }else {
            return RespBean.error("删除失败");
        }
    }

    @ApiOperation("批量删除职称")
    @DeleteMapping("/")
    public RespBean deleteManyJobLevel(Integer[] ids){
        if(joblevelService.removeByIds(Arrays.asList(ids))){
            return RespBean.success("批量删除成功");
        }else{
            return RespBean.error("批量删除失败");
        }
    }

}
