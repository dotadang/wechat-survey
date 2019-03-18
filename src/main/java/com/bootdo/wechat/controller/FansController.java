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

import com.bootdo.wechat.domain.FansDO;
import com.bootdo.wechat.service.FansService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 粉丝信息表
 * 
 * @author song
 * @email 1992lcg@163.com
 * @date 2017-11-09 15:33:54
 */
 
@Controller
@RequestMapping("/wechat/fans")
public class FansController {
	@Autowired
	private FansService fansService;
	
	@GetMapping()
	@RequiresPermissions("wechat:fans:fans")
	String Fans(){
	    return "wechat/fans/fans";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("wechat:fans:fans")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<FansDO> fansList = fansService.list(query);
		int total = fansService.count(query);
		PageUtils pageUtils = new PageUtils(fansList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("wechat:fans:add")
	String add(){
	    return "wechat/fans/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("wechat:fans:edit")
	String edit(@PathVariable("id") Long id,Model model){
		FansDO fans = fansService.get(id);
		model.addAttribute("fans", fans);
	    return "wechat/fans/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("wechat:fans:add")
	public R save( FansDO fans){
		if(fansService.save(fans)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("wechat:fans:edit")
	public R update( FansDO fans){
		fansService.update(fans);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("wechat:fans:remove")
	public R remove( Long id){
		if(fansService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("wechat:fans:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		fansService.batchRemove(ids);
		return R.ok();
	}
	
}
