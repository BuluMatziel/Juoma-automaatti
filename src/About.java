import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;

public class About {

	private JFrame frmJuomaautomaattiGuiV;
	private JLabel lblJuomaautomaattiVersio;
	private JLabel lblTekij;
	private JLabel gitHub;

	/**
	 * Launch the application.
	 */
	public static void Tiedot() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About window = new About();
					window.frmJuomaautomaattiGuiV.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public About() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJuomaautomaattiGuiV = new JFrame();
		frmJuomaautomaattiGuiV.setTitle("Juoma-automaatti GUI v. 1.0.0");
		frmJuomaautomaattiGuiV.setBounds(100, 100, 450, 300);
		frmJuomaautomaattiGuiV.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		lblJuomaautomaattiVersio = new JLabel("Juoma-automaatti versio 1.0.0");
		lblJuomaautomaattiVersio.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblJuomaautomaattiVersio.setHorizontalAlignment(SwingConstants.CENTER);
		frmJuomaautomaattiGuiV.getContentPane().add(lblJuomaautomaattiVersio, BorderLayout.NORTH);
		
		lblTekij = new JLabel("Tekij\u00E4: Matias Kohanevic");
		lblTekij.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTekij.setHorizontalAlignment(SwingConstants.CENTER);
		frmJuomaautomaattiGuiV.getContentPane().add(lblTekij, BorderLayout.CENTER);
		
		gitHub = new JLabel("https://github.com/BuluMatziel/Juoma-automaatti-GUI");
		gitHub.setFont(new Font("Tahoma", Font.PLAIN, 16));
		gitHub.setHorizontalAlignment(SwingConstants.CENTER);
		frmJuomaautomaattiGuiV.getContentPane().add(gitHub, BorderLayout.SOUTH);
	}

}
