package cn.tedu.shoot;

import java.util.Random;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Graphics;

/**
 * 飞行物类
 * 
 * @author liyub
 *
 */
public abstract class FlyingObject {
	public static final int LIFE = 0;
	public static final int DEAD = 1;
	public static final int REMOVE = 2;
	protected int state = LIFE;

	protected int width;// 宽
	protected int height;// 高
	protected int x;// x坐标
	protected int y;// y坐标

	/** 默认构造 */
	public FlyingObject() {

	}

	public FlyingObject(int width, int height, int x, int y) {
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
	}

	public FlyingObject(int width, int height) {// 供给大敌机，小敌机，小蜜蜂调用的有参构造方法
		this.width = width;
		this.height = height;
		Random rand = new Random();// 随机数对象
		x = rand.nextInt(World.WIDTH - width);// 产生0到400-width的随机数
		y = -this.height;
	}

	/** 飞行物移动 */
	public abstract void step();

	/** 获取图片 */
	public abstract BufferedImage getImage();

	/** 画对象 g:画笔 */
	public void paintObject(Graphics g) {
		g.drawImage(getImage(), x, y, null);
	}

	/** 判断是否活着 */
	public boolean isLife() {
		return state == LIFE;

	}

	/** 判断是否死亡 */
	public boolean isDead() {
		return state == DEAD;
	}

	/** 判断是否移动 */
	public boolean isRemove() {
		return state == REMOVE;
	}

	/** 判断飞行物是否越界 */
	public abstract boolean outOfBounds();

	/** 检测敌人与子弹和英雄机是否碰撞 */
	public boolean hit(FlyingObject other) {
		int x1 = this.x - other.width;
		int x2 = this.x + this.width;
		int y1 = this.y - other.height;
		int y2 = this.y + other.height;
		int x = other.x;
		int y = other.y;
		return x >= x1 && x <= x2 && y >= y1 && y <= y2;
	}

	/** 飞行物死亡 */
	public void goDead() {
		state = DEAD;
	}
	/**读取图片*/
	public static BufferedImage loadImage(String fileName) {
		try {
			BufferedImage img = ImageIO.read(FlyingObject.class.getResource(fileName));
			return img;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

}
