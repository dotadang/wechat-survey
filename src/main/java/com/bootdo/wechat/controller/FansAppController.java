package com.bootdo.wechat.controller;

import java.util.List;
import java.util.Map;

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

import com.bootdo.wechat.domain.FansAppDO;
import com.bootdo.wechat.service.FansAppService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 粉丝公众号-粉丝关联表
 * 
 * @author song
 * @email 1992lcg@163.com
 * @date 2017-11-09 15:33:54
 */
 
@Controller
@RequestMapping("/wechat/fansApp")
public class FansAppController {
	@Autowired
	private FansAppService fansAppService;
	
	@GetMapping()
	@RequiresPermissions("wechat:fansApp:fansApp")
	String FansApp(){
	    return "wechat/fansApp/fansApp";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("wechat:fansApp:fansApp")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<FansAppDO> fansAppList = fansAppService.list(query);
		int total = fansAppService.count(query);
		PageUtils pageUtils = new PageUtils(fansAppList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("wechat:fansApp:add")
	String add(){
	    return "wechat/fansApp/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("wechat:fansApp:edit")
	String edit(@PathVariable("id") Long id,Model model){
		FansAppDO fansApp = fansAppService.get(id);
		model.addAttribute("fansApp", fansApp);
	    return "wechat/fansApp/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("wechat:fansApp:add")
	public R save( FansAppDO fansApp){
		if(fansAppService.save(fansApp)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("wechat:fansApp:edit")
	public R update( FansAppDO fansApp){
		fansAppService.update(fansApp);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("wechat:fansApp:remove")
	public R remove( Long id){
		if(fansAppService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("wechat:fansApp:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		fansAppService.batchRemove(ids);
		return R.ok();
	}
	
}
