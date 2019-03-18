# BootDo
1.BootDo项目集成weixin-java-tool的SDK 管理微信公众号
  功能不全  只是作为学习 有兴趣的可以一起开发。
2.BootDo项目 地址：布嘟开源[www.bootdo.com](http://www.bootdo.com./blog)
3.weixin-java-tool SDK开源地址：
    码云：http://git.oschina.net/binary/weixin-java-tools
    GitHub: https://github.com/wechat-group/weixin-java-tools
    Bitbucket：https://bitbucket.org/binarywang/weixin-java-tools
    Coding: https://git.coding.net/binarywang/weixin-java-tools.git
    
#启动项目
1.修改配置文件application-dev 和pro中的数据库信息
2.添加application.yml中的公众号信息
#关于公众号的接入
在微信公众平台申请订阅号 或者测试号
将appid和appsecret token 等写到 application.yml配置文件中   
将项目接入地址填写在公众平台接入url里 先启动项目  然后做内网穿透（魔法隧道、花生壳之类的） 然后点击公众平台的保存配置