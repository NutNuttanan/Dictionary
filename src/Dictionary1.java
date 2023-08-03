import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Dictionary1 extends JFrame
{

	private JPanel contentPane;
	private JTextField txt;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Dictionary1 frame = new Dictionary1();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Dictionary1()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("word");
		lblNewLabel.setBounds(10, 50, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("meaning");
		lblNewLabel_1.setBounds(10, 100, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txt = new JTextField();
		txt.setBounds(105, 47, 200, 20);
		contentPane.add(txt);
		txt.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String mytext_tosearch = txt.getText().trim().toUpperCase();
				File f = new File("dictionary2.txt");
				Scanner sc = null;
				try
				{
					boolean isFound = false;
					System.out.println("start read File");
					sc = new Scanner(f);
					while(sc.hasNext())
					{
						String word = sc.nextLine();
						String meaning = sc.nextLine();
						if(word.equals(mytext_tosearch))
						{
							textArea.setText(meaning);
							isFound=true;
							break;
						}
					}
					if(!isFound)
					{
						JOptionPane.showMessageDialog(Dictionary1.this,"Word NOT FOUND");
					}
					System.out.println("end read File");
				} catch (FileNotFoundException e)
				{
					System.out.println("this is error");
					e.printStackTrace();
				}
				finally
				{
					System.out.println("this is finally");
					if(sc!=null)
					{
						sc.close();
					}
				}
				
			}
		});
		btnNewButton.setBounds(340, 46, 89, 23);
		contentPane.add(btnNewButton);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setBackground(Color.YELLOW);
		textArea.setBounds(105, 95, 324, 205);
		contentPane.add(textArea);
		
		JLabel lblNewLabel_2 = new JLabel("This is my dictionary");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(10, 11, 182, 28);
		contentPane.add(lblNewLabel_2);
	}
}
