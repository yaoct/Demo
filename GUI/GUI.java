import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

public class GUI {
	static JFrame frame;
	public static void main(String[] args) {
		// 确保一个漂亮的外观风格
//        JFrame.setDefaultLookAndFeelDecorated(true);

        /// 创建 JFrame 实例
        frame = new JFrame("Login Example");
        // Setting the width and height of frame
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* 创建面板，这个类似于 HTML 的 div 标签
         * 我们可以创建多个面板并在 JFrame 中指定位置
         * 面板中我们可以添加文本字段，按钮及其他组件。
         */
        JPanel panel = new JPanel(new FlowLayout());    
        // 添加面板
        frame.add(panel);
        /* 
         * 调用用户定义的方法并添加组件到面板
         */
        placeLogin(panel);

        // 设置界面可见
        frame.setVisible(true);

	}
	
	private static void placeLogin(JPanel panel) {

        /* 布局部分我们这边不多做介绍
         * 这边设置布局为 null
         */
        panel.setLayout(null);

        // 创建 JLabel
        JLabel userLabel = new JLabel("User:");
        /* 这个方法定义了组件的位置。
         * setBounds(x, y, width, height)
         * x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
         */
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);

        /* 
         * 创建文本域用于用户输入
         */
        JTextField userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        // 输入密码的文本域
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);
        /* 
         *这个类似用于输入的文本域
         * 但是输入的信息会以点号代替，用于包含密码的安全性
         */
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);

        // 创建登录按钮
        JButton loginButton = new JButton("login");
        loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String text=userText.getText();
				String password=new String(passwordText.getPassword());
				if(text.equals("yaoct")&&password.equals("h19910116")) {
					panel.setVisible(false);
					JScrollPane panel2 = new JScrollPane();
					frame.add(panel2);
					GUI.placepanel2(panel2);
				}
			}

		});
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);
    }
	
	private static void placepanel2(JScrollPane panel2) {
        /* 布局部分我们这边不多做介绍
         * 这边设置布局为 null
         */
        panel2.setLayout(null);

        /* 
         * 创建文本域用于用户输入
         */
        JTextField userText1 = new JTextField(20);
        userText1.setBounds(10,20,165,25);
        panel2.add(userText1);
        JTextField userText2 = new JTextField(20);
        userText2.setBounds(10,50,165,25);
        panel2.add(userText2);
        JTextField userText3 = new JTextField(20);
        userText3.setBounds(10,80,165,25);
        panel2.add(userText3);


        // 创建登录按钮
        JButton button = new JButton("+");
        button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String num1=userText1.getText();
				String num2=userText2.getText();
				userText3.setText(add(num1,num2));
			}

			private String add(String num1, String num2) {
				long n1=Long.valueOf(num1);
				long n2=Long.valueOf(num2);
				return (n1+n2)+" ";
			}

		});
        button.setBounds(200, 20, 80, 25);
        panel2.add(button);
	}
}
