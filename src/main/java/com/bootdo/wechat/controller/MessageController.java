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

import com.bootdo.wechat.domain.MessageDO;
import com.bootdo.wechat.service.MessageService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 消息记录库
 * 
 * @author song
 * @email 1992lcg@163.com
 * @date 2017-11-09 15:23:03
 */
 
@Controller
@RequestMapping("/wechat/message")
public class MessageController {
	@Autowired
	private MessageService messageService;
	
	@GetMapping()
	@RequiresPermissions("wechat:message:message")
	String Message(){
	    return "wechat/message/message";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("wechat:message:message")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<MessageDO> messageList = messageService.list(query);
		int total = messageService.count(query);
		PageUtils pageUtils = new PageUtils(messageList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("wechat:message:add")
	String add(){
	    return "wechat/message/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("wechat:message:edit")
	String edit(@PathVariable("id") Long id,Model model){
		MessageDO message = messageService.get(id);
		model.addAttribute("message", message);
	    return "wechat/message/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("wechat:message:add")
	public R save( MessageDO message){
		if(messageService.save(message)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("wechat:message:edit")
	public R update( MessageDO message){
		messageService.update(message);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("wechat:message:remove")
	public R remove( Long id){
		if(messageService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("wechat:message:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		messageService.batchRemove(ids);
		return R.ok();
	}
	
}
