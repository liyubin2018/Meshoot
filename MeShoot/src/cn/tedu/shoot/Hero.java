package cn.tedu.shoot;

/**
 * 
 * @author liyub 英雄机
 */
public class Hero {
	int width;// 宽
	int height;// 高
	int x;// x坐标
	int y;// y坐标
	int life;// 生命
	int doublefire;
	
	Hero(){
		width=97;
		height=124;
		x=140;
		y=400;
		life=3;
		doublefire=0;
	}

	/**
	 * 英雄机随着鼠标的移动，鼠标的坐标x，y；
	 * 
	 * @param x
	 * @param y
	 */
	void moveTo(int x, int y) {
		System.out.println("英雄机移动了!");
	}

	void step() {
		System.out.println("英雄机切换图片啦！");
	}
}