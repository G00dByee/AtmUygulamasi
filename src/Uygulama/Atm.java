package Uygulama;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Atm {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int bakiye = 5000;
		int faturaValue ;
		boolean open = false;
		boolean key = false;
		String[][] users = { { "Barış", "245423" }, { "Eda", "345527" }, { "Mahmut", "195621" }, { "Mehmet", "223522" },
				{ "Melisa", "218593" } };
		String[][] faturalar = { { "Elektrik", "225" }, { "Su", "175" }, { "İnternet", "149" }, { "DoğalGaz", "500" },
				{ "GSM", "110" } };

		System.out.println("Merhaba DuranBank Bankasına HoşGeldiniz\nAşağıda ki Boşluğa Müşteri No Giriniz.");
		String müsteriNumber = scan.nextLine();

		for (int i = 0; i < users.length; i++) {
			for (int j = 0; j < users[i].length; j++) {
				if (users[i][1].equals(müsteriNumber)) {
					key = true;
					System.out.print("Merhaba , " + users[i][0]);
					break;
				}
			}
		}

		if (key) {
			System.out.println(" Başarıyla Giriş Yapıldı! ");

		} else {
			System.out.println("Geçersiz Kullanıcı. Doğru Müşteri Numarası Girdiğinizden Emin Olun!");
		}
		while (key) {
			System.out.println("Yapmak İstediğiniz İşlemi Seçiniz :=)");
			System.out.println("Bakiyeniz : " + bakiye);
			System.out.println("1-Para Çekmek");
			System.out.println("2-Para Yatırmak");
			System.out.println("3-Bakiye Öğrenme");
			System.out.println("4-Fatura Yatırmak");
			System.out.println("5-Çıkış Yap");
			int selectProcess = scan.nextInt();

			if (selectProcess == 1) {
				System.out.println("Bakiyeniz : " + bakiye);
				System.out.println("Çekmek İstediğiniz Tutarı Giriniz ");
				int negativeBakiye = scan.nextInt();
				if (negativeBakiye > bakiye) {
					System.out.println(
							"Bakiyenizin üzerinde değer girdiniz. Lütfen Bakiyenizin altında bir değer giriniz.");
				} else {
					int lastBakiye = 0;
					lastBakiye = bakiye - negativeBakiye;
					System.out.println("İşlem Başarılı. Kalan Bakiyeniz : " + lastBakiye);
					bakiye = lastBakiye;
				}
			} else if (selectProcess == 2) {
				System.out.println("Yatırmak İstediğiniz Tutarı Giriniz");
				int addBakiye = scan.nextInt();
				if (addBakiye > 0) {
					int finalBakiye = addBakiye + bakiye;
					bakiye = finalBakiye;
					System.out.println("Mevcut Bakiye : " + finalBakiye);
				} else {
					System.out.println("Doğru Değer Girdiğinize Emin Olunuz");
				}
			} else if (selectProcess == 3) {
				System.out.println("Bakiyeniz : " + bakiye);
			}

			else if (selectProcess == 4) {
				System.out.println("Ödemek İstediğiniz Faturayı Yazınız.. (Örn,Elektrik,İnternet,su,Telefon,Doğalgaz");
				String fatura = scan.next();
				for (int i = 0; i < faturalar.length; i++) {
					for (int j = 0; j < faturalar[i].length; j++) {
						if (faturalar[i][0].toLowerCase().equals(fatura.toLowerCase())) {
							System.out.println(faturalar[i][0] + " Faturanız: " + faturalar[i][1] + " TL'dir.");
							 faturaValue = Integer.parseInt(faturalar[i][1]);
							open = true;
							if (open) {
								System.out.println("Ödemek İstiyor musunuz? (Evet,Hayır)");
								String yesNo = scan.next();
								if (yesNo.toLowerCase().equals("evet")) {
									int newBakiye = bakiye-faturaValue;
									System.out.println("Faturanız Ödenmiştir! ");
									bakiye = newBakiye;
									break;
								}  else if(yesNo.toLowerCase().equals("hayır")) {
									System.out.println("Geri Dönüş Yapılıyor...");
								}
							}else {
									System.out.println(
											"Sadece Elektrik,Su,Gsm,Doğalgaz,İnternet faturlarını ödeyebilirsiniz bu faturalardan birini ödemek için lütfen bu isimlerden birini yazınız!");
								}
						}
					}
				}
				} else if (selectProcess == 5) {
					System.out.println("Çıkış Yapıldı... Tekrar Bekleriz!");
					break;
				} else {
					System.out.println("Doğru Seçim Girdiğinizden Emin Olun!");
				}
			}
		}

	}

