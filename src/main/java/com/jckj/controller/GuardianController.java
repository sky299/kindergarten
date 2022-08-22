package com.jckj.controller;

import com.jckj.model.TGuardianInfo;
import com.jckj.service.GuardianService;
import com.jckj.util.ExcelUtil;
import com.jckj.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("page/guardian")
public class GuardianController {

    @Autowired
    private GuardianService guardianService;

    @RequestMapping("list")
    public JsonResult list(TGuardianInfo tGuardianInfo) {
        return JsonResult.success(guardianService.list(tGuardianInfo).getList(),guardianService.count(tGuardianInfo));
    }

    @PostMapping("add")
    public JsonResult add(@RequestBody TGuardianInfo tGuardianInfo){
        guardianService.add(tGuardianInfo);
        return JsonResult.success();
    }

    @PostMapping("update")
    public JsonResult update(@RequestBody TGuardianInfo tGuardianInfo){
        guardianService.update(tGuardianInfo);
        return JsonResult.success();
    }

    @PostMapping("info")
    public ModelAndView info(Integer id){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("page/guardian/edit");
        mv.addObject("guardian",guardianService.info(id));
        return mv;
    }

    @PostMapping("delete")
    public JsonResult delete(Integer id){
        guardianService.remove(id);
        return JsonResult.success();
    }

    @PostMapping("export")
    public JsonResult export(TGuardianInfo tGuardianInfo) throws Exception {
        ExcelUtil.writeExcel(new String[]{"编号","姓名","电话","是否显示","是否删除","创建时间","更新时间"},
                guardianService.list(tGuardianInfo).getList());
        //System.out.println(ExcelUtil.loadExcel("D:/TGuardianInfo.xls",TGuardianInfo.class));
        return JsonResult.success();
    }
}
