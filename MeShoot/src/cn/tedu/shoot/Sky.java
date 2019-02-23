package cn.tedu.shoot;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * 天空
 * 
 * @author liyub
 *
 */
public class Sky extends FlyingObject {
	@SuppressWarnings("unused")
	private static BufferedImage image;// 图片
	static {
		image = loadImage("background.png");
	}
	private int y1;// y1坐标(图片轮换)
	private int speed;

	public Sky() {
		super(World.WIDTH, World.HEIGTH, 0, 0);
		speed = 1;
		y1 = -height;
	}

	public void step() {
		System.out.println("天空移动了：" + speed);
	}

	/** 重写getImage()方法，获取图片 */
	public BufferedImage getImage() {
		return image;
	}

	/** 画对象 g:画笔 */
	public void paintObject(Graphics g) {
		g.drawImage(getImage(), x, y, null);
		g.drawImage(getImage(), x, y1, null);
	}

}
