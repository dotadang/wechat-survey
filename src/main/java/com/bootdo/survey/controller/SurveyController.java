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

import com.bootdo.survey.domain.SurveyDO;
import com.bootdo.survey.service.SurveyService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 问卷结果
 * 
 * @author dotadang
 * @email 1992lcg@163.com
 * @date 2019-02-12 14:44:38
 */
 
@Controller
@RequestMapping("/survey/survey")
public class SurveyController extends BasewxController{
	@Autowired
	private SurveyService surveyService;
	
	@GetMapping()
	@RequiresPermissions("survey:survey:survey")
	String Survey(){
	    return "survey/survey/survey";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("survey:survey:survey")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SurveyDO> surveyList = surveyService.list(query);
		int total = surveyService.count(query);
		PageUtils pageUtils = new PageUtils(surveyList, total);
		return pageUtils;
	}
	
	@GetMapping("/redirect")
	public String redirect(HttpServletRequest request) {
		String sb = "survey/survey/add";
	    if(isMicromessengerBrowser(request)) {
	    	String redirectUrl = getRequestUrl(request) + "/add";
			String oauthUrl = getOauth2buildAuthorizationUrl(redirectUrl);
			sb = new StringBuilder(500).append("redirect:").append(oauthUrl).toString();
	    }
		return sb;
	}
	
	@GetMapping("/add")
	//@RequiresPermissions("survey:survey:add")
	public String add(@RequestParam(value = "code", required = false) String code, Model model, HttpServletRequest request){
		String openId = null;
	    if(isMicromessengerBrowser(request)) {	    	
			try {
				openId = getOpenIdByOAuth2Code(code);
			} catch (Exception e) {
				return "redirect:/error";
			}			
	    }
	    model.addAttribute("openId", openId);
	    return "survey/survey/add";
	}
	
	@GetMapping("/add1")
	//@RequiresPermissions("survey:survey:add")
	public String add1(){
	    return "survey/survey/add";
	}
	
	@GetMapping("/notify")
	String notify(HttpServletRequest request){
	    return "survey/survey/notify";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("survey:survey:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		SurveyDO survey = surveyService.get(id);
		model.addAttribute("survey", survey);
	    return "survey/survey/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	//@RequiresPermissions("survey:survey:add")
	public R save( SurveyDO survey){
		if(surveyService.save(survey)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("survey:survey:edit")
	public R update( SurveyDO survey){
		surveyService.update(survey);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("survey:survey:remove")
	public R remove( Integer id){
		if(surveyService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("survey:survey:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		surveyService.batchRemove(ids);
		return R.ok();
	}
	
}
