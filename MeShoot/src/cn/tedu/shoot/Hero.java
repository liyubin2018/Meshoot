package cn.tedu.shoot;

/**
 * 
 * @author liyub 英雄机
 */
public class Hero extends FlyingObject {
	int life;// 生命
	int doublefire;

	Hero() {
		super(97, 124, 140, 400);
		this.life = 3;
		this.doublefire = 0;
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
		System.out.println("英雄机切换图片啦");
	}

}