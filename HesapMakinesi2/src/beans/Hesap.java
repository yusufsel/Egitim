package beans;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
	private boolean virgul;

	public String getSonuc() {
		sonuc.setScale(10, BigDecimal.ROUND_HALF_UP);
		sonuc = sonuc.stripTrailingZeros();
		return sonuc.toString();
	}

	public void basamakSil() {
		girilenSayi = girilenSayi.divide(BigDecimal.TEN, RoundingMode.DOWN);
		sonuc = girilenSayi;
	}

	public void silCE() {
		sonuc = new BigDecimal(0);
		girilenSayi = new BigDecimal(0);
		eskiGirilenSayi = new BigDecimal(0);
		islem = ' ';
		virgul = false;
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
		virgul = false;
	}

	public void cikarma() {
		islem = '-';
		eskiGirilenSayi = girilenSayi;
		girilenSayi = new BigDecimal(0);
		virgul = false;
	}

	public void carpma() {
		islem = '*';
		eskiGirilenSayi = girilenSayi;
		girilenSayi = new BigDecimal(0);
		virgul = false;
	}

	public void bolme() {
		islem = '/';
		eskiGirilenSayi = girilenSayi;
		girilenSayi = new BigDecimal(0);
		virgul = false;
	}

	public void tus(String basamak) {
		if (girilenSayi.toString().length() < MAX_BASAMAK) {
			if (!virgul) {
				girilenSayi = girilenSayi.multiply(new BigDecimal(10)).add(new BigDecimal(basamak));
				sonuc = girilenSayi;
			} else {
				int virguldenSonrakiBasamak = girilenSayi.scale();
				BigDecimal kesir = BigDecimal.ONE.divide(BigDecimal.TEN.pow(virguldenSonrakiBasamak + 1));
				girilenSayi = girilenSayi.add(new BigDecimal(basamak).multiply(kesir));
				sonuc = girilenSayi;
			}
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

	public void yuzde() {
		esittir();
		sonuc = sonuc.divide(new BigDecimal(100), MAX_BASAMAK, RoundingMode.HALF_UP);
		girilenSayi = sonuc;
	}

	public void virgul() {
		virgul = true;
	}

	public static void main(String[] args) {
		BigDecimal sayi = new BigDecimal("12123213");
		System.out.println(sayi.scale());
	}
}
