package cn.tedu.shoot;

import java.util.Random;

/**
 * 飞行物类
 * 
 * @author liyub
 *
 */
public class FlyingObject {
	int width;// 宽
	int height;// 高
	int x;// x坐标
	int y;// y坐标

	FlyingObject() {

	}

	FlyingObject(int width, int height, int x, int y) {
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
	}

	FlyingObject(int width, int height) {// 供给大敌机，小敌机，小蜜蜂调用的有参构造方法
		this.width = width;
		this.height = height;
		Random rand = new Random();// 随机数对象
		x = rand.nextInt(400 - width);// 产生0到400-width的随机数
		y = -this.height;
	}

	/* 飞行物移动 */
	void step() {
		System.out.println("飞行物移动了！");
	}
}
