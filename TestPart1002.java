package com.neuedu.part10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 泛型
 * 在使用集合定义时放任意类型的场景，可以用泛型定义
 * 使用集合时，由于如果不加限制什么类型都可以放，取出来使用不方便所以要使用泛型
 * 限制存放的类型，不需要强制转换
 * 注意：定义集合时，构造器的泛型，在1.7版本 可以省略（<>钻石操作符），不然需要和前面声明的泛型保持一致
 * 
 * 自定义泛型类
 * 可以实现多个泛型的定义
 * 注意：当一个类 继承带有泛型的类时，如果在类上表明了泛型标识，那么子类必须实现泛型功能，如果不标，子类可以实现可以不实现
 * 
 * Map接口
 * map是以键/值对存放成对数据的数据组，K代表key键，V代表value值
 * put(key,value)方法 存值
 * size()取大小
 * get（key）根据key获取value
 * HashMap集合
 * 遍历的方式：keySet()   entrySet()
 * 
 * 所有集合都有的foreach方法
 * list.foreach(item -> {});
 * set.foreach(item -> {});
 * map.foreach((k,v) -> {});
 */
public class TestPart1002 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(3);
		a.add(10);
		Generic<Integer> g = new Generic<>();
		g.setT(10);
		System.out.println(g.getT());
		Result<Integer,Integer,Integer> result = new Result<Integer, Integer, Integer>(10, 20, 30);
		result.showAll();
		
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		hashMap.put(1, 11);
		hashMap.put(2, 22);
		hashMap.put(3, 33);
		hashMap.put(4, 44);
		hashMap.put(4, 45);
		System.out.println(hashMap.size());
		Integer integer = hashMap.get(4);
		System.out.println(integer);
		//遍历
		//1.根据key拿value
		Set<Integer> keySet = hashMap.keySet();//拿所有的key的集合
		
		Iterator<Integer> iterator = keySet.iterator();
		
		while(iterator.hasNext()){
			Integer key = iterator.next();//拿到每一个key
			
			Integer value = hashMap.get(key);//拿到每一个value
			
			System.out.println("key:"+key+",value:"+value);
		}
		
		//2.通过entry集合遍历
		
		Set<Entry<Integer, Integer>> entrySet = hashMap.entrySet();
		
		Iterator<Entry<Integer, Integer>> iterator2 = entrySet.iterator();
		
		while(iterator2.hasNext()){
			Entry<Integer, Integer> entry = iterator2.next();//每一对key-value
			System.out.println("key:"+entry.getKey()+",value:"+entry.getValue());
		}
		//扩展：如何不根据key去查value？
		
		for (Entry<Integer, Integer> entry : entrySet) {
			System.out.println("key:"+entry.getKey()+",value:"+entry.getValue());
		}
		
		//lamdba表达式
		a.forEach(item ->{//list
			System.out.println(item);
		});
		hashMap.keySet().forEach(item ->{//set
			System.out.println(item+","+hashMap.get(item));
		});
		hashMap.forEach((k,v)->{//map
			System.out.println(k+","+v);
		});
		
		//编写一个程序，创建一个　HashMap对象，用于存储银行储户的信息(其中储户的主要信息有储户的ID，姓名和余额)直接定义3个
		//输出所有储户的当前余额。
		//testBank();
		//保证线程安全（同步）
		Hashtable<Object, Object> hashtable = new Hashtable<>();
		//保证线程安全（同步）
		new ConcurrentHashMap<>();//1.7采用分段锁进行线程安全管理，1.8开始使用CAS锁
	}

	private static void testBank() {
		HashMap<Integer, BankerInfo> map = new HashMap<>();
		map.put(1, new BankerInfo(1, "Tom", 100.00));
		map.put(2, new BankerInfo(2, "Mark", 200.00));
		map.put(3, new BankerInfo(3, "Smith", 300.00));
		
		Scanner sc = new Scanner(System.in);
		System.out.println("欢迎使用该系统查询信息，1 查询所有人信息   2 查询个人   3 退出");
		
		while(true){
			String type = sc.next();
			if("1".equals(type)){
				Iterator<Entry<Integer, BankerInfo>> iterator3 = map.entrySet().iterator();
				while (iterator3.hasNext()) {
					Entry<Integer, BankerInfo> next = iterator3.next();
					System.out.println("用户编号："+next.getKey()+" 姓名："+next.getValue().getName()+" 余额是："+next.getValue().getBalance());
				}
			}else if("2".equals(type)){
				System.out.println("请输入要查询人的编号");
				String no = sc.next();
				BankerInfo bankerInfo = map.get(Integer.parseInt(no));
				if(bankerInfo != null){
					System.out.println("用户编号："+bankerInfo.getNo()+" 姓名："+bankerInfo.getName()+" 余额是："+bankerInfo.getBalance());
				}else{
					System.out.println("对不起，查无此人");
				}
			}else if("3".equals(type)){
				System.out.println("您已退出查询系统");
				break;
			}else{
				System.out.println("没有此选项，请重新输入");
			}
		}
		
		
	}

}

class BankerInfo{
	
	private int no;
	
	private String name;
	
	private double balance;
	
	public BankerInfo(int no,String name,double balance){
		this.balance = balance;
		this.name = name;
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}






class Generic<T> {
	
	private T t;

	
	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
	
}

class Result<E,T,U> extends Generic<T>{

	private E e;
	
	private U u;
	
	
	
	public E getE() {
		return e;
	}



	public void setE(E e) {
		this.e = e;
	}



	public U getU() {
		return u;
	}



	public void setU(U u) {
		this.u = u;
	}



	public Result(T t,U u,E e) {
		setT(t);
		this.e = e;
		this.u = u;
	}

	public void showAll(){
		System.out.println(u+" "+e+" "+getT());
	}
	
}
