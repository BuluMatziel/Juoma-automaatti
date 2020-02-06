import javax.swing.Timer;

public class JuomaAutomaatti {

	private int tee;
	private int kahvi;
	private int kaakao;

	public JuomaAutomaatti() {
		this.tee = 50;
		this.kahvi = 50;
		this.kaakao = 50;
	}

	public int getTee() {
		return tee;
	}

	public void setTee(int tee) {
		this.tee = tee;
	}

	public int getKahvi() {
		return kahvi;
	}

	public void setKahvi(int kahvi) {
		this.kahvi = kahvi;
	}

	public int getKaakao() {
		return kaakao;
	}

	public void setKaakao(int kaakao) {
		this.kaakao = kaakao;
	}

	public void valmistaKahvi() {
		
		int value = GUI.kahviSlider.getValue();
		if (this.kahvi - value < 0) {
			
			String kahviStatus = ("Kahvia j�ljell�: " + this.kahvi);
			GUI.kahviVaroitus.setText("Kahvia ei ole tarpeeksi, t�yt� s�ili�.");
			Timer timer = new Timer(2000, event -> {
				GUI.lblKahviaJljell.setText(kahviStatus);
			
	        });
	        timer.setRepeats(false);
	        timer.start();
		} else  {
			
			this.kahvi -= value;
			String kahviStatus = ("Kahvia j�ljell�: " + this.kahvi);
			GUI.lblKahviaJljell.setText("Odota hetki, kahvisi valmistuu...");
			Timer timer = new Timer(2000, event -> {
				GUI.lblKahviaJljell.setText(kahviStatus);
			
	        });
	        timer.setRepeats(false);
	        timer.start();
		
	        } 
		
		
		if (this.kahvi < 20) {
			GUI.kahviVaroitus.setVisible(true);
		}

		this.toString();
	}
	
	public void valmistaTee() {
		
		int value = GUI.teeSlider.getValue();
		if (this.tee - value < 0) {
			
			String teeStatus = ("Teet� j�ljell�: " + this.tee);
			GUI.teeVaroitus.setText("Teet� ei ole tarpeeksi, t�yt� s�ili�.");
			Timer timer = new Timer(2000, event -> {
				GUI.lblTeetJljell.setText(teeStatus);
			
	        });
	        timer.setRepeats(false);
	        timer.start();
		} else  {
			
			this.tee -= value;
			String teeStatus = ("Teet� j�ljell�: " + this.tee);
			GUI.lblTeetJljell.setText("Odota hetki, teesi valmistuu...");
			Timer timer = new Timer(2000, event -> {
				GUI.lblTeetJljell.setText(teeStatus);
			
	        });
	        timer.setRepeats(false);
	        timer.start();
		
	        } 
		
		
		if (this.tee < 20) {
			GUI.teeVaroitus.setVisible(true);
		}

		this.toString();
	}

 
	public void valmistaKaakao() {
		
		int value = GUI.kaakaoSlider.getValue();
		if (this.kaakao - value < 0) {
			
			String kaakaoStatus = ("Kaakaota j�ljell�: " + this.kaakao);
			GUI.kaakaoVaroitus.setText("Kaakaota ei ole tarpeeksi, t�yt� s�ili�.");
			Timer timer = new Timer(2000, event -> {
				GUI.lblKaakaotaJljell.setText(kaakaoStatus);
			
	        });
	        timer.setRepeats(false);
	        timer.start();
		} else  {
			
			this.kaakao -= value;
			String kaakaoStatus = ("Kaakaota j�ljell�: " + this.kaakao);
			GUI.lblKaakaotaJljell.setText("Odota hetki, kaakaosi valmistuu...");
			Timer timer = new Timer(2000, event -> {
				GUI.lblKaakaotaJljell.setText(kaakaoStatus);
			
	        });
	        timer.setRepeats(false);
	        timer.start();
		
	        } 
		
		
		if (this.kaakao < 20) {
			GUI.kaakaoVaroitus.setVisible(true);
		}

		this.toString();
	}

	@Override
	public String toString() {
		String tuloste1 = "" + this.getKahvi() + this.getKaakao() + this.getTee();
		return tuloste1;
	}
	
	
}