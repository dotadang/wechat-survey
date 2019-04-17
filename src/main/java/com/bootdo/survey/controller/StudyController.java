package com.bootdo.survey.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.survey.domain.StudyDO;
import com.bootdo.survey.service.StudyService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-04-16 11:06:17
 */
 
@Controller
@RequestMapping("/survey/study")
public class StudyController {
	@Autowired
	private StudyService studyService;
	
	@GetMapping()
	@RequiresPermissions("survey:study:study")
	String Study(){
	    return "survey/study/study";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("survey:study:study")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<StudyDO> studyList = studyService.list(query);
		int total = studyService.count(query);
		PageUtils pageUtils = new PageUtils(studyList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	//@RequiresPermissions("survey:study:add")
	String add(){
	    return "survey/study/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("survey:study:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		StudyDO study = studyService.get(id);
		model.addAttribute("study", study);
	    return "survey/study/edit";
	}
	
	@GetMapping("/notify")
	String notify(HttpServletRequest request){
	    return "survey/survey/notify";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	//@RequiresPermissions("survey:study:add")
	public R save( StudyDO study){
		if(studyService.save(study)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("survey:study:edit")
	public R update( StudyDO study){
		studyService.update(study);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("survey:study:remove")
	public R remove( Integer id){
		if(studyService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("survey:study:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		studyService.batchRemove(ids);
		return R.ok();
	}
	
}
