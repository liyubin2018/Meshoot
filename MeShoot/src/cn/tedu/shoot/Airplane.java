package cn.tedu.shoot;
import java.util.Random;
/**
 * 小敌机
 * 
 * @author liyub
 *
 */
public class Airplane {
	int width;// 宽
	int height;// 高
	int x;// x坐标
	int y;// y坐标
	int speed;// 移动速度
	Airplane(){
		width=49;
		height=36;
		Random rand=new Random();//随机数对象
		x=rand.nextInt(400-width);//产生0到400-width的随机数
		y=-this.height;
		//x=(int)(Math.random()*(400-width));	
		speed=1;
	}

	/** 小敌机移动 */
	void step() {
		System.out.println("小敌机的y坐标移动了:" + speed);
	}

}
