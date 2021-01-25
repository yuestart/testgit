package com.neuedu.part10;

import java.util.ArrayList;
import java.util.Date;

public class TestPart1004 {

	public static void main(String[] args) {
		/*
		 * 打卡系统：给公司员工提供的一个打卡系统
		 * 员工的信息是系统的基础数据，员工的信息包括：ID 姓名 
		 * 提供的功能点：
		 * 1-------------签到
		 * 2-------------签退
		 * 3-------------查询打卡信息  （记录打卡时间 可以查询近7天 ，1次签到签退为一天）
		 * 4-------------退出
		 * 签到：打卡的员工必须是公司已有员工
		 * 签退：打卡的员工必须是公司已有员工，只有当天签到的员工才可以签退
		 * 同一天不能重复签到，签退
		 * 
		 */
		 //0.需要初始化一个存放公司现有员工的集合
		 //1.应该有个确认员工信息登录环节
		 //2.打卡记录存在另一个集合中
		 //3.打卡之后退出登录界面

	}

}


class Employee {
	
	private int ID;
	
	private String name;
	
    //存放员工打卡记录的属性 
	//最多存 7条，超过7条，时间依次顶掉
	private ArrayList<CheckInRecord> arrayList = new ArrayList<>();
	
	
	public Employee(int ID, String name){
		this.ID = ID;
		this.name = name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<CheckInRecord> getArrayList() {
		return arrayList;
	}

	public void setArrayList(ArrayList<CheckInRecord> arrayList) {
		this.arrayList = arrayList;
	}
	
	
	
	
}

class CheckInRecord {
	
	private String checkFlag;//默认是签退状态，员工签到时，判断状态为签退，即可签到，签到之后只能签退
	
	private Date checkInTime;
	
	private Date checkOutTime;
	
	
	public String getCheckFlag() {
		return checkFlag;
	}

	public void setCheckFlag(String checkFlag) {
		this.checkFlag = checkFlag;
	}

	public Date getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(Date checkInTime) {
		this.checkInTime = checkInTime;
	}

	public Date getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(Date checkOutTime) {
		this.checkOutTime = checkOutTime;
	}
	
	
	
}

