import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ScrollPaneConstants;

public class Ohjeet {

	private JFrame frmOhjeet;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void Ohje() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ohjeet window = new Ohjeet();
					window.frmOhjeet.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ohjeet() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOhjeet = new JFrame();
		frmOhjeet.setTitle("Ohjeet");
		frmOhjeet.setBounds(100, 100, 450, 300);
		frmOhjeet.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmOhjeet.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("<html>\r\n<h1>Ohjeet:</h1> <br>\r\nValitse juoman vahvuus ja paina nappia.<br>\r\n<br>\r\nMieto vahvuus kuluttaa 5 yksikk\u00F6\u00E4 juomaa.<br>\r\nNormaali vahvuus kuluttaa 10 yksikk\u00F6\u00E4 juomaa.<br>\r\nVahva vahvuus kuluttaa 15 yksikk\u00F6\u00E4 juomaa.<br>\r\n<br>\r\nOngelmatilanteissa ota yhteytt\u00E4 kehitt\u00E4j\u00E4\u00E4n:<br>\r\nmatiaskohanevic@gmail.com<br>\r\n+35800123123\r\n</html>");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 10, 416, 243);
		frmOhjeet.getContentPane().add(lblNewLabel);
	}
}
