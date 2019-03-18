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

import com.bootdo.wechat.domain.MpMessageDO;
import com.bootdo.wechat.service.MpMessageService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 公众号消息
 * 
 * @author song
 * @email 1992lcg@163.com
 * @date 2017-11-09 15:23:03
 */
 
@Controller
@RequestMapping("/wechat/mpMessage")
public class MpMessageController {
	@Autowired
	private MpMessageService mpMessageService;
	
	@GetMapping()
	@RequiresPermissions("wechat:mpMessage:mpMessage")
	String MpMessage(){
	    return "wechat/mpMessage/mpMessage";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("wechat:mpMessage:mpMessage")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<MpMessageDO> mpMessageList = mpMessageService.list(query);
		int total = mpMessageService.count(query);
		PageUtils pageUtils = new PageUtils(mpMessageList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("wechat:mpMessage:add")
	String add(){
	    return "wechat/mpMessage/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("wechat:mpMessage:edit")
	String edit(@PathVariable("id") Long id,Model model){
		MpMessageDO mpMessage = mpMessageService.get(id);
		model.addAttribute("mpMessage", mpMessage);
	    return "wechat/mpMessage/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("wechat:mpMessage:add")
	public R save( MpMessageDO mpMessage){
		if(mpMessageService.save(mpMessage)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("wechat:mpMessage:edit")
	public R update( MpMessageDO mpMessage){
		mpMessageService.update(mpMessage);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("wechat:mpMessage:remove")
	public R remove( Long id){
		if(mpMessageService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("wechat:mpMessage:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		mpMessageService.batchRemove(ids);
		return R.ok();
	}
	
}
