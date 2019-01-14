package cn.tedu.shoot;

/**
 * 测试类
 * 
 * @author liyub 整个世界
 */
public class World {
	Sky sky;
	Hero hero;
	Airplane a1;
	Airplane a2;
	BigAirplane ba1;
	BigAirplane ba2;
	Bee b1;
	Bee b2;
	Bullet bt1;
	Bullet bt2;

	void action() {// 启动执行测试代码
		sky=new Sky();
		hero=new Hero();
		a1=new Airplane();
		a2=new Airplane();
		ba1=new BigAirplane();
		ba2=new BigAirplane();
		b1= new Bee();
		b2= new Bee();
		bt1=new Bullet(100,150);
		bt2=new Bullet(20,65);
		
		sky.step();
		hero.step();
		hero.moveTo(20, 10);
		a1.step();
		a2.step();
		ba1.step();
		ba2.step();
		b1.step();
		b2.step();
		bt1.step();
		bt2.step();
		
		System.out.println("英雄机的宽："+hero.width+"英雄机的高："+hero.height
				+"英雄机的x:"+hero.x+"英雄机的y:"+hero.y+"英雄机的生命："+hero.life
				+"英雄机的火力值："+hero.doublefire);
		System.out.println("小蜜蜂的宽:"+b1.width+"小蜜蜂的高："+b1.height
				+"小蜜蜂的x："+b1.x+"小蜜蜂的y："+b1.y+"小蜜蜂的x移动速度:"+b1.xspeed
				+"小蜜蜂的y移动速度："+b1.yspeed+"小蜜蜂的奖励："+b1.awardType);
		
	}

	public static void main(String[] args) {
		World world = new World();// 创建世界
		world.action();// 启动执行

	}

}
