package cn.tedu.shoot;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

/**
 * 测试类
 * 
 * @author liyub 整个世界
 */
@SuppressWarnings("serial")
public class World extends JPanel {
	public static final int WIDTH = 400;
	public static final int HEIGTH = 700;
	private Sky sky=new Sky();
	private Hero hero=new Hero();
	private FlyingObject[] enemies = {};
	private Bullet[] bts = {};

	public void action() {// 启动执行测试代码
//		enemies=new FlyingObject[3];
//		enemies[0]=new Airplane();
//		enemies[1]=new BigAirplane();
//		enemies[2]=new Bee();
//		bts=new Bullet[2];
//		bts[0]=new Bullet(50,100);
//		bts[1]=new Bullet(100,200);
	}
	/**重写paint()方法*/
public void paint(Graphics g) {
	sky.paintObject(g);//画天空
	hero.paintObject(g);//画英雄机
	for (int i = 0; i < enemies.length; i++) {
		enemies[i].paintObject(g);//画敌人
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
