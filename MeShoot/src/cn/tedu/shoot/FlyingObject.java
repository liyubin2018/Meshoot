package cn.tedu.shoot;

import java.util.Random;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 * 飞行物类
 * 
 * @author liyub
 *
 */
public class FlyingObject {
	protected int width;// 宽
	protected int height;// 高
	protected int x;// x坐标
	protected int y;// y坐标

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

	/* 飞行物移动 */
	public void step() {
		System.out.println("飞行物移动了！");
	}

	// 加载/读取对象图片，fileName图片的文件名
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
