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
		// ȷ��һ��Ư������۷��
//        JFrame.setDefaultLookAndFeelDecorated(true);

        /// ���� JFrame ʵ��
        frame = new JFrame("Login Example");
        // Setting the width and height of frame
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* ������壬��������� HTML �� div ��ǩ
         * ���ǿ��Դ��������岢�� JFrame ��ָ��λ��
         * ��������ǿ�������ı��ֶΣ���ť�����������
         */
        JPanel panel = new JPanel(new FlowLayout());    
        // ������
        frame.add(panel);
        /* 
         * �����û�����ķ����������������
         */
        placeLogin(panel);

        // ���ý���ɼ�
        frame.setVisible(true);

	}
	
	private static void placeLogin(JPanel panel) {

        /* ���ֲ���������߲���������
         * ������ò���Ϊ null
         */
        panel.setLayout(null);

        // ���� JLabel
        JLabel userLabel = new JLabel("User:");
        /* ������������������λ�á�
         * setBounds(x, y, width, height)
         * x �� y ָ�����Ͻǵ���λ�ã��� width �� height ָ���µĴ�С��
         */
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);

        /* 
         * �����ı��������û�����
         */
        JTextField userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        // ����������ı���
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);
        /* 
         *�����������������ı���
         * �����������Ϣ���Ե�Ŵ��棬���ڰ�������İ�ȫ��
         */
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);

        // ������¼��ť
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
        /* ���ֲ���������߲���������
         * ������ò���Ϊ null
         */
        panel2.setLayout(null);

        /* 
         * �����ı��������û�����
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


        // ������¼��ť
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
