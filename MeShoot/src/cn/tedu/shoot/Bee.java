package cn.tedu.shoot;

import java.util.Random;

/**
 * 小蜜蜂
 * 
 * @author liyub
 *
 */
public class Bee {
	int width;// 宽
	int height;// 高
	int x;// x坐标
	int y;// y坐标
	int xspeed;// x方向的移动速度
	int yspeed;// y方向的移动速度
	int awardType;// 打下小蜜蜂的奖励（0或1）
	
	Bee(){
		width=60;
		height=50;
		Random rand=new Random();
		x=rand.nextInt(400-this.width);
		y=-this.height;
		xspeed=1;
		yspeed=1;
		awardType=rand.nextInt(2);
	}

	/* 小蜜蜂移动 */
	void step() {
		System.out.println("小蜜蜂的X坐标移动了：" + xspeed);
		System.out.println("小蜜蜂的y坐标移动了：" + yspeed);
	}
}
