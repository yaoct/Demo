import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.WindowConstants;

public class Demo2 {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(
				new Runnable() {
					@Override
					public void run() {
						// 此处处于 事件调度线程
						createGUI();
					}

				}
				);
		SwingUtilities.invokeLater(
				new Runnable() {
					@Override
					public void run() {
						// 此处处于 事件调度线程
						createGUI();
					}

				}
				);
	}

	protected static void createGUI() {
		JFrame jf=new JFrame("线程测试");
		jf.setSize(600,600);
		jf.setLocationRelativeTo(null);//相对其他窗口位置
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JPanel jp=new JPanel(new FlowLayout());
		JButton btn1=new JButton("按钮1");
		JButton btn2=new JButton("按钮2");
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				 // 创建后台任务
		        SwingWorker<String, Object> task = new SwingWorker<String, Object>() {
		            @Override
		            protected String doInBackground() throws Exception {
		            	while(true) {
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							System.out.println("button11111111");
						}
		            }
		            @Override
		            protected void done() {
		            }
		        };
		        task.execute();
			}
		});
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				 // 创建后台任务
		        SwingWorker<String, Object> task = new SwingWorker<String, Object>() {
		            @Override
		            protected String doInBackground() throws Exception {
		            	while(true) {
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							System.out.println("button2click...");
						}
		            }
		            @Override
		            protected void done() {
		            }
		        };
		        task.execute();
			}
		});
		jp.add(btn1);
		jp.add(btn2);
		jf.add(jp);
		jf.setVisible(true);
	}

}
