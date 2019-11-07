<?xml version="1.0"?>
<globals>
	<#assign Collection=extractLetters(ActivityClass)>//从输入的title中获取输入字符
    <#assign collection_name=Collection?lower_case>//获取到的字符转成小写

	<!-- 这里声明全局变量-->
	<global id="activity_layout" value="${Collection?lower_case}" />//作为activity的layout的命名
    <global id="ActivityName" value="${Collection}Activity" />//作为activity类名
    <global id="PresenterName" value="${Collection}PresenterImpl" />//作为presenter类名
    <global id="EntryName" value="${Collection}" />//实体类

	<global id="packageName" value="com.config.pad.content.libding" />//文件项目包名  packageName指的是 右键点击的包路径
	<global id="package" value="com.config.pad.content" />//项目包名  R文件 包名

</globals>
