import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSlider;

@SuppressWarnings("serial")
public class GUI extends JFrame {

	static JuomaAutomaatti valmistus = new JuomaAutomaatti();
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnYllpito;
	private JMenu mnTietojaOhjelmasta;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JLabel lblKahvi;
	private JLabel lblTee;
	private JLabel lblKaakao;
	static JLabel lblKahviaJljell;
	static JLabel lblTeetJljell;
	static JLabel lblKaakaotaJljell;
	private JMenuItem mntmAsetaKahvinMr;
	private JMenuItem mntmAsetaTeenMr;
	private JMenuItem mntmAsetaKaakaonMr;
	private JMenuItem mntmTallennaAutomaatinTilaa;
	private JMenuItem mntmLataaAutomaatti;
	private JMenuItem mntmLopeta;
	private JMenuItem mntmVersiotiedot;
	private JMenuItem mntmOhje;
	static JSlider kahviSlider;
	static JLabel kahviVaroitus;
	static JSlider teeSlider;
	static JLabel teeVaroitus;
	static JSlider kaakaoSlider;
	static JLabel kaakaoVaroitus;
	
	public static void asetaKahvi() {
		String uusiArvo = JOptionPane.showInputDialog(null, "Anna uusi arvo", "Aseta kahvi", JOptionPane.INFORMATION_MESSAGE);
		int uusiKahvi = Integer.parseInt(uusiArvo);
		valmistus.setKahvi(uusiKahvi);
		lblKahviaJljell.setText("Kahvia jäljellä: " + valmistus.getKahvi());
		if (valmistus.getKahvi() < 20) {  
			lblKahviaJljell.setForeground(Color.RED);
			kahviVaroitus.setText("Varoitus: Kahvi vähissä, täytä säiliö.");
			kahviVaroitus.setVisible(true);
		} else { 
				lblKahviaJljell.setForeground(Color.BLACK);
				kahviVaroitus.setText("Varoitus: Kahvi vähissä, täytä säiliö.");
				kahviVaroitus.setVisible(false);
			}		
	}
	public static void asetaTee() {
		String uusiArvo = JOptionPane.showInputDialog(null, "Anna uusi arvo", "Aseta tee", JOptionPane.INFORMATION_MESSAGE);
		int uusiTee = Integer.parseInt(uusiArvo);
		valmistus.setTee(uusiTee);
		lblTeetJljell.setText("Teetä jäljellä: " + valmistus.getTee());
		if (valmistus.getTee() < 20) {
			lblTeetJljell.setForeground(Color.RED);
			teeVaroitus.setText("Varoitus: Tee vähissä, täytä säiliö.");
			teeVaroitus.setVisible(true);
		} else {
			lblTeetJljell.setForeground(Color.BLACK);
			teeVaroitus.setText("Varoitus: Tee vähissä, täytä säiliö.");
			teeVaroitus.setVisible(false);
		}
	}
	public static void asetaKaakao() {
		String uusiArvo = JOptionPane.showInputDialog(null, "Anna uusi arvo", "Aseta kaakao", JOptionPane.INFORMATION_MESSAGE);
		int uusiKaakao = Integer.parseInt(uusiArvo);
		valmistus.setKaakao(uusiKaakao);
		lblKaakaotaJljell.setText("Kaakaota jäljellä: " + valmistus.getKaakao());
		if (valmistus.getKaakao() < 20) {
			lblKaakaotaJljell.setForeground(Color.RED);
			kaakaoVaroitus.setText("Varoitus: Kaakao vähissä, täytä säiliö.");
			kaakaoVaroitus.setVisible(true);
		} else {
			lblKaakaotaJljell.setForeground(Color.BLACK);
			kaakaoVaroitus.setText("Varoitus: Kaakao vähissä, täytä säiliö.");
			kaakaoVaroitus.setVisible(false);
		}
	}
	public static void tallennaAutomaatti() {
		try {
			Sarjallistamista.kirjoitaTiedostoon(valmistus);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public static void lataaAutomaatti() {
		try {
			JuomaAutomaatti uusi = Sarjallistamista.lueTiedostosta();
			
			valmistus.setKahvi(uusi.getKahvi());
			lblKahviaJljell.setText("Kahvia jäljellä: " + uusi.getKahvi());
			if (uusi.getKahvi() < 20) {
				lblKahviaJljell.setForeground(Color.RED);
			} else {
				lblKahviaJljell.setForeground(Color.BLACK);
			}
			
			valmistus.setTee(uusi.getTee());
			lblTeetJljell.setText("Teetä jäljellä: " + uusi.getTee());
			if (uusi.getTee() < 20) {
				lblTeetJljell.setForeground(Color.RED);
			} else {
				lblTeetJljell.setForeground(Color.BLACK);
			}
			
			valmistus.setKaakao(uusi.getKaakao());
			lblKaakaotaJljell.setText("Kaakaota jäljellä: " + uusi.getKaakao());
			if (uusi.getKaakao() < 20) {
				lblKaakaotaJljell.setForeground(Color.RED);
			} else {
				lblKaakaotaJljell.setForeground(Color.BLACK);
			}
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setTitle("Juoma-automaatti GUI v. 1.0.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 618);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnYllpito = new JMenu("Yll\u00E4pito");
		menuBar.add(mnYllpito);
		
		mntmAsetaKahvinMr = new JMenuItem("Aseta kahvin m\u00E4\u00E4r\u00E4\u00E4");
		mntmAsetaKahvinMr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				asetaKahvi();		
			}
		});
		mnYllpito.add(mntmAsetaKahvinMr);
		
		mntmAsetaTeenMr = new JMenuItem("Aseta teen m\u00E4\u00E4r\u00E4\u00E4");
		mntmAsetaTeenMr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				asetaTee();
			}
		});
		mnYllpito.add(mntmAsetaTeenMr);
		
		mntmAsetaKaakaonMr = new JMenuItem("Aseta kaakaon m\u00E4\u00E4r\u00E4\u00E4");
		mntmAsetaKaakaonMr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asetaKaakao();
			}
		});
		mnYllpito.add(mntmAsetaKaakaonMr);
		
		mntmTallennaAutomaatinTilaa = new JMenuItem("Tallenna automaatin tila");
		mntmTallennaAutomaatinTilaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tallennaAutomaatti();
			}
		});
		mnYllpito.add(mntmTallennaAutomaatinTilaa);
		
		mntmLataaAutomaatti = new JMenuItem("Lataa automaatti");
		mntmLataaAutomaatti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lataaAutomaatti();
			}
		});
		mnYllpito.add(mntmLataaAutomaatti);
		
		mntmLopeta = new JMenuItem("Lopeta");
		mntmLopeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnYllpito.add(mntmLopeta);
		
		mnTietojaOhjelmasta = new JMenu("Tietoja ohjelmasta");
		menuBar.add(mnTietojaOhjelmasta);
		
		mntmVersiotiedot = new JMenuItem("Versiotiedot");
		mntmVersiotiedot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About.Tiedot();
			}
		});
		mnTietojaOhjelmasta.add(mntmVersiotiedot);
		
		mntmOhje = new JMenuItem("Ohje");
		mntmOhje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ohjeet.Ohje();
			}
		});
		mnTietojaOhjelmasta.add(mntmOhje);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        valmistus.valmistaKahvi();
			}
		});
		button.setIcon(new ImageIcon(GUI.class.getResource("/Resources/coffee.jpg")));
		button.setBounds(25, 25, 135, 135);
		contentPane.add(button);
		
		button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				valmistus.valmistaTee();
			}
		});
		button_1.setIcon(new ImageIcon(GUI.class.getResource("/Resources/tea.jpg")));
		button_1.setBounds(25, 195, 135, 135);
		contentPane.add(button_1);
		
		button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valmistus.valmistaKaakao();
			}
		});
		button_2.setIcon(new ImageIcon(GUI.class.getResource("/Resources/cocoa.jpg")));
		button_2.setBounds(25, 365, 135, 135);
		contentPane.add(button_2);
		
		lblKahvi = new JLabel("Kahvi");
		lblKahvi.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblKahvi.setHorizontalAlignment(SwingConstants.CENTER);
		lblKahvi.setBounds(25, 172, 140, 13);
		contentPane.add(lblKahvi);
		
		lblTee = new JLabel("Tee");
		lblTee.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTee.setHorizontalAlignment(SwingConstants.CENTER);
		lblTee.setBounds(25, 340, 135, 13);
		contentPane.add(lblTee);
		
		lblKaakao = new JLabel("Kaakao");
		lblKaakao.setHorizontalAlignment(SwingConstants.CENTER);
		lblKaakao.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblKaakao.setBounds(25, 510, 135, 13);
		contentPane.add(lblKaakao);
		
		lblKahviaJljell = new JLabel("Kahvia jäljellä: " + valmistus.getKahvi());
		lblKahviaJljell.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblKahviaJljell.setBounds(170, 25, 270, 27);
		contentPane.add(lblKahviaJljell);
		
		lblTeetJljell = new JLabel("Teetä jäljellä: " + valmistus.getTee());
		lblTeetJljell.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTeetJljell.setBounds(170, 195, 226, 27);
		contentPane.add(lblTeetJljell);
		
		lblKaakaotaJljell = new JLabel("Kaakaota jäljellä: " + valmistus.getKaakao());
		lblKaakaotaJljell.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblKaakaotaJljell.setBounds(170, 365, 270, 27);
		contentPane.add(lblKaakaotaJljell);
		
		kahviSlider = new JSlider();
		kahviSlider.setSnapToTicks(true);
		kahviSlider.setValue(10);
		kahviSlider.setPaintTicks(true);
		kahviSlider.setMinorTickSpacing(5);
		kahviSlider.setMinimum(5);
		kahviSlider.setMaximum(15);
		kahviSlider.setBounds(170, 62, 200, 44);
		contentPane.add(kahviSlider);
		
		//Create the label table
		Hashtable<Integer, JLabel> labelTable = new Hashtable<>();
		labelTable.put(5, new JLabel("Mieto") );
		labelTable.put(10, new JLabel("Normaali") );
		labelTable.put(15, new JLabel("Vahva") );
		kahviSlider.setLabelTable( labelTable );
		kahviSlider.setPaintLabels(true);
		
		kahviVaroitus = new JLabel("Varoitus: Kahvi vähissä, täytä säiliö.");
		kahviVaroitus.setIcon(new ImageIcon(GUI.class.getResource("/Resources/warning.png")));
		kahviVaroitus.setForeground(Color.RED);
		kahviVaroitus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		kahviVaroitus.setBounds(170, 116, 270, 27);
		kahviVaroitus.setVisible(false);
		contentPane.add(kahviVaroitus);
		
		teeSlider = new JSlider();
		teeSlider.setSnapToTicks(true);
		teeSlider.setValue(10);
		teeSlider.setPaintTicks(true);
		teeSlider.setPaintLabels(true);
		teeSlider.setMinorTickSpacing(5);
		teeSlider.setMinimum(5);
		teeSlider.setMaximum(15);
		teeSlider.setBounds(170, 232, 200, 44);
		teeSlider.setLabelTable(labelTable);
		teeSlider.setPaintLabels(true);
		contentPane.add(teeSlider);
		
		teeVaroitus = new JLabel("Varoitus: Tee v\u00E4hiss\u00E4, t\u00E4yt\u00E4 s\u00E4ili\u00F6.");
		teeVaroitus.setIcon(new ImageIcon(GUI.class.getResource("/Resources/warning.png")));
		teeVaroitus.setForeground(Color.RED);
		teeVaroitus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		teeVaroitus.setBounds(170, 286, 270, 27);
		teeVaroitus.setVisible(false);
		contentPane.add(teeVaroitus);
		
		kaakaoSlider = new JSlider();
		kaakaoSlider.setSnapToTicks(true);
		kaakaoSlider.setValue(10);
		kaakaoSlider.setPaintTicks(true);
		kaakaoSlider.setPaintLabels(true);
		kaakaoSlider.setMinorTickSpacing(5);
		kaakaoSlider.setMinimum(5);
		kaakaoSlider.setMaximum(15);
		kaakaoSlider.setBounds(170, 402, 200, 44);
		kaakaoSlider.setLabelTable(labelTable);
		kaakaoSlider.setPaintLabels(true);
		contentPane.add(kaakaoSlider);
		
		kaakaoVaroitus = new JLabel("Varoitus: Kaakao v\u00E4hiss\u00E4, t\u00E4yt\u00E4 s\u00E4ili\u00F6.");
		kaakaoVaroitus.setIcon(new ImageIcon(GUI.class.getResource("/Resources/warning.png")));
		kaakaoVaroitus.setForeground(Color.RED);
		kaakaoVaroitus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		kaakaoVaroitus.setBounds(170, 456, 270, 27);
		kaakaoVaroitus.setVisible(false);
		contentPane.add(kaakaoVaroitus);		
	}
	public JLabel getLblKahviaJljell() {
		return lblKahviaJljell;
	}
	public JLabel getLblTeetJljell() {
		return lblTeetJljell;
	}
	public JLabel getLblKaakaotaJljell() {
		return lblKaakaotaJljell;
	}

}
