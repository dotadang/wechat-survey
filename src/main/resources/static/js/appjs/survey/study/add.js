$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});

$("#edu-other").change(function() { 
	if($("#edu-other").is(':checked')){
		$("#eduinput").show();
	}
	else {
		$("#eduinput").hide();
	}
	});

$("#fin-other").change(function() { 
	if($("#fin-other").is(':checked')){
		$("#fininput").show();
	}
	else {
		$("#fininput").hide();
	}
	});

$("#asset-other").change(function() { 
	if($("#asset-other").is(':checked')){
		$("#assetinput").show();
	}
	else {
		$("#assetinput").hide();
	}
	});
function save() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/survey/study/save",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
//				parent.layer.msg("操作成功");
//				parent.reLoad();
//				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
//				parent.layer.close(index);
				window.location.href = "/survey/survey/notify";

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			name : {
				required : true
			}
		},
		messages : {
			name : {
				required : icon + "请输入姓名"
			}
		}
	})
}