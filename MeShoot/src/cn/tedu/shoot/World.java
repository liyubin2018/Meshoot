package cn.tedu.shoot;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;
import java.util.Arrays;

/**
 * 测试类
 * 
 * @author liyub 整个世界
 */
@SuppressWarnings("serial")
public class World extends JPanel {
	public static final int WIDTH = 400;
	public static final int HEIGTH = 700;
	private Sky sky = new Sky();
	private Hero hero = new Hero();
	private FlyingObject[] enemies = {};
	private Bullet[] bts = {};
	
	/**创建敌人对象*/
	public FlyingObject nextOne() {
		Random rand=new Random();
		int type=rand.nextInt(20);
		if(type<10) {
			return new Airplane();
		}else if(type<14) {
			return new BigAirplane();
		}else {
			return new Bee();
		}
	}	
	
	int enterIndex=0;
	/**敌人入场*/
	public void enterdAction() {
		enterIndex++;
		if (enterIndex%30==0) {
			FlyingObject obj=nextOne();
			enemies=Arrays.copyOf(enemies,enemies.length+1);
			enemies[enemies.length-1]=obj;
		}
		
	}
	
	public void stupAction() {//10毫秒走一次
		sky.step();
		
		for (int i = 0; i < bts.length; i++) {
			bts[i].step();
		}
		for (int i = 0; i < enemies.length; i++) {
			enemies[i].step();
		}
		
	}
	/**程序启动执行*/
	public void action() {// 启动执行测试代码
		/*1，敌人入场
		 *2，飞行物移动
		 *3，子弹入场
		 *4英雄机随鼠标移动
		 *5子弹与敌人碰撞
		 *7，敌人与英雄机相撞
		 */
		Timer timer=new Timer();//创建定时对象
		timer.schedule(new TimerTask() {
			@Override//重写计时方法
			public void run() {
			enterdAction();
			System.out.println(enemies.length);
			stupAction();//飞行物移动
			
			
			repaint();
			
			}
		},10,10);//定时任务
	}

	/** 重写paint()方法 */
	public void paint(Graphics g) {
		sky.paintObject(g);// 画天空
		hero.paintObject(g);// 画英雄机
		for (int i = 0; i < enemies.length; i++) {
			enemies[i].paintObject(g);// 画敌人
		}
		for (int i = 0; i < bts.length; i++) {
			bts[i].paintObject(g);
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame(); // 创建一个窗口对象
		World world = new World(); // 创建一个面板对象
		frame.add(world); // 将面板添加到窗口中
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置关闭窗口时退出程序
		frame.setSize(WIDTH, HEIGTH); // 设置窗口的大小
		frame.setLocationRelativeTo(null); // 设置窗口居中显示
		frame.setVisible(true); // 1)设置窗口可见 2)尽快调用paint()

		world.action();// 启动执行

	}

}
