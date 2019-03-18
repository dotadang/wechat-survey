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

import com.bootdo.wechat.domain.TeamDO;
import com.bootdo.wechat.service.TeamService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 团队/组织
 * 
 * @author song
 * @email 1992lcg@163.com
 * @date 2017-11-08 18:55:24
 */
 
@Controller
@RequestMapping("/wechat/team")
public class TeamController {
	@Autowired
	private TeamService teamService;
	
	@GetMapping()
	@RequiresPermissions("wechat:team:team")
	String Team(){
	    return "wechat/team/team";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("wechat:team:team")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TeamDO> teamList = teamService.list(query);
		int total = teamService.count(query);
		PageUtils pageUtils = new PageUtils(teamList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("wechat:team:add")
	String add(){
	    return "wechat/team/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("wechat:team:edit")
	String edit(@PathVariable("id") Long id,Model model){
		TeamDO team = teamService.get(id);
		model.addAttribute("team", team);
	    return "wechat/team/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("wechat:team:add")
	public R save( TeamDO team){
		if(teamService.save(team)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("wechat:team:edit")
	public R update( TeamDO team){
		teamService.update(team);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("wechat:team:remove")
	public R remove( Long id){
		if(teamService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("wechat:team:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		teamService.batchRemove(ids);
		return R.ok();
	}
	
}
