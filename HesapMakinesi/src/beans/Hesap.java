package beans;

import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Hesap {
	private static final int MAX_BASAMAK = 10;
	private BigDecimal sonuc = new BigDecimal(0);
	private BigDecimal eskiGirilenSayi = new BigDecimal(0);
	private BigDecimal girilenSayi = new BigDecimal(0);
	private char islem;

	public String getSonuc() {
		sonuc.setScale(10, BigDecimal.ROUND_HALF_UP);
		sonuc = sonuc.stripTrailingZeros();
		return sonuc.toString();
	}

	public void silCE() {
		sonuc = new BigDecimal(0);
		girilenSayi = new BigDecimal(0);
		eskiGirilenSayi = new BigDecimal(0);
		islem = ' ';
	}

	public void isaretDegistir() {
		girilenSayi = girilenSayi.multiply(new BigDecimal(-1));
		sonuc = girilenSayi;
	}

	public void silC() {
		sonuc = new BigDecimal(0);
		girilenSayi = new BigDecimal(0);
	}

	public void toplama() {
		islem = '+';
		eskiGirilenSayi = girilenSayi;
		girilenSayi = new BigDecimal(0);
	}

	public void cikarma() {
		islem = '-';
		eskiGirilenSayi = girilenSayi;
		girilenSayi = new BigDecimal(0);
	}

	public void carpma() {
		islem = '*';
		eskiGirilenSayi = girilenSayi;
		girilenSayi = new BigDecimal(0);
	}

	public void bolme() {
		islem = '/';
		eskiGirilenSayi = girilenSayi;
		girilenSayi = new BigDecimal(0);
	}

	public void tus(String basamak) {
		if (girilenSayi.toString().length() < MAX_BASAMAK) {
			girilenSayi = girilenSayi.multiply(new BigDecimal(10)).add(new BigDecimal(basamak));
			sonuc = girilenSayi;
		}
	}

	public void birBolu() {
		girilenSayi = new BigDecimal(1).divide(girilenSayi, MAX_BASAMAK, BigDecimal.ROUND_HALF_UP);
		sonuc = girilenSayi;
	}

	public void kare() {
		girilenSayi = girilenSayi.multiply(girilenSayi);
		sonuc = girilenSayi;
	}

	private static BigDecimal sqrt(BigDecimal A, final int SCALE) {
		BigDecimal x0 = new BigDecimal("0");
		BigDecimal x1 = new BigDecimal(Math.sqrt(A.doubleValue()));
		while (!x0.equals(x1)) {
			x0 = x1;
			x1 = A.divide(x0, SCALE, BigDecimal.ROUND_HALF_UP);
			x1 = x1.add(x0);
			x1 = x1.divide(new BigDecimal("2"), SCALE, BigDecimal.ROUND_HALF_UP);

		}
		return x1;
	}

	public void kok() {
		girilenSayi = sqrt(girilenSayi, MAX_BASAMAK);
		sonuc = girilenSayi;
	}

	public void esittir() {
		switch (islem) {
		case '+':
			sonuc = eskiGirilenSayi.add(girilenSayi);
			break;
		case '-':
			sonuc = eskiGirilenSayi.subtract(girilenSayi);
			break;
		case '*':
			sonuc = eskiGirilenSayi.multiply(girilenSayi);
			break;
		case '/':
			sonuc = eskiGirilenSayi.divide(girilenSayi, MAX_BASAMAK, BigDecimal.ROUND_HALF_UP);
			break;

		}
		girilenSayi = new BigDecimal(0);
	}

	public static void main(String[] args) {
		BigDecimal sayi = new BigDecimal("12123213");
		System.out.println(sayi.scale());
	}
}
