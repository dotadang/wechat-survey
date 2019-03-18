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

import com.bootdo.wechat.domain.FansMessageDO;
import com.bootdo.wechat.service.FansMessageService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 粉丝消息表
 * 
 * @author song
 * @email 1992lcg@163.com
 * @date 2017-11-09 15:23:03
 */
 
@Controller
@RequestMapping("/wechat/fansMessage")
public class FansMessageController {
	@Autowired
	private FansMessageService fansMessageService;
	
	@GetMapping()
	@RequiresPermissions("wechat:fansMessage:fansMessage")
	String FansMessage(){
	    return "wechat/fansMessage/fansMessage";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("wechat:fansMessage:fansMessage")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<FansMessageDO> fansMessageList = fansMessageService.list(query);
		int total = fansMessageService.count(query);
		PageUtils pageUtils = new PageUtils(fansMessageList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("wechat:fansMessage:add")
	String add(){
	    return "wechat/fansMessage/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("wechat:fansMessage:edit")
	String edit(@PathVariable("id") Long id,Model model){
		FansMessageDO fansMessage = fansMessageService.get(id);
		model.addAttribute("fansMessage", fansMessage);
	    return "wechat/fansMessage/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("wechat:fansMessage:add")
	public R save( FansMessageDO fansMessage){
		if(fansMessageService.save(fansMessage)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("wechat:fansMessage:edit")
	public R update( FansMessageDO fansMessage){
		fansMessageService.update(fansMessage);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("wechat:fansMessage:remove")
	public R remove( Long id){
		if(fansMessageService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("wechat:fansMessage:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		fansMessageService.batchRemove(ids);
		return R.ok();
	}
	
}
