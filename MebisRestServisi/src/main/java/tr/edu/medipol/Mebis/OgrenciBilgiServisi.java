package tr.edu.medipol.Mebis;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Giris")
public class OgrenciBilgiServisi {
	private static List<String> ogrenciler = new ArrayList<>();
	static {
		ogrenciler.add("Oğuzhan");
		ogrenciler.add("Aleyna");
		ogrenciler.add("Büşra");
		ogrenciler.add("Mert");

	}
	
	@GetMapping("/tumBilgiler")
	public synchronized List<String> tumBilgilerbu(){
		return ogrenciler;
		
	}
	@GetMapping("/ogrenciEkle/{ogrenciAdi}")
		public synchronized List<String> ogrenciEkle(@PathVariable String ogrenciAdi 
		) {
			ogrenciler.add(ogrenciAdi);
			
			return ogrenciler;
			
	}

	
	@GetMapping("/ogrenciSil/{ogrenciAdi}")
	public synchronized List<String> ogrenciSil(@PathVariable String ogrenciAdi) {
		ogrenciler.remove(ogrenciAdi);
		return ogrenciler;
		
}
	@GetMapping("/ogrenciGuncelle")
	public synchronized List<String> ogrenciGuncelle(@RequestParam String eskiAd, @RequestParam String
			yeniAd) {
		ogrenciler.remove(eskiAd);
		ogrenciler.add(yeniAd);
		return ogrenciler;
		
}
	@GetMapping("/ogrenciNotEkleVeGuncelle")
	public synchronized List<String> ogrenciNotEkle(@RequestParam String ogrencininAdi, @RequestParam String ogrenciyeEklenenNot,@RequestParam String guncelenenNot) {
		ogrenciler.remove(ogrencininAdi);

		ogrenciler.remove(ogrencininAdi+" "+ogrenciyeEklenenNot);
		ogrenciler.add(ogrencininAdi+" "+ogrenciyeEklenenNot.replace(ogrenciyeEklenenNot, guncelenenNot));
		ogrenciler.remove(ogrencininAdi+" "+ogrenciyeEklenenNot);
		
		
		return ogrenciler;
		
}
}
