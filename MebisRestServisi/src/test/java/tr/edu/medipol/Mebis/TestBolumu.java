package tr.edu.medipol.Mebis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Anasayfa")
public class TestBolumu {
	@Test
	
	public void tumOgrencilerTest() {
	
	List<String> ogrenciler = new ArrayList<>();
		 {
			 String ogrencİsim1 ="Oğuzhan";
			 String ogrencİsim2 ="Aleyna";
			 String ogrencİsim3 ="Büşra";
			 String ogrencİsim4 ="Mert";
		ogrenciler.add(ogrencİsim1);
		ogrenciler.add(ogrencİsim2);
		ogrenciler.add(ogrencİsim3);
		ogrenciler.add(ogrencİsim4);	
			assertEquals("Oğuzhan",ogrencİsim1);
			assertEquals("Aleyna",ogrencİsim2);
			assertEquals("Büşra",ogrencİsim3);
			assertEquals("Mert",ogrencİsim4);
		}
	}
@GetMapping("/ogrenciEkle/{ogrenciAdi}")
@Test
public void   OgrenciEklemeTest() {
	List<String> ogrenciler = new ArrayList<>();
	 {
		 String ogrencİsim1 ="Oğuzhan";
		 String ogrencİsim2 ="Aleyna";
		 String ogrencİsim3 ="Büşra";
		 String ogrencİsim4 ="Mert";
	 }
	 String yeniogrenci="Murat";
	 ogrenciler.add(yeniogrenci);
	 //Then
	 assertEquals(yeniogrenci,"Murat");
}
@GetMapping("/ogrenciSil/{ogrenciAdi}")
@Test	
public void OgrenciSilmeTesti() {
		List<String> ogrenciler = new ArrayList<>();
		 {
			 String ogrencİsim1 ="Oğuzhan";
			 String ogrencİsim2 ="Aleyna";
			 String ogrencİsim3 ="Büşra";
			 String ogrencİsim4 ="Mert";
			 ogrenciler.remove(ogrencİsim3);
			 assertEquals(ogrencİsim1,"Oğuzhan");
		 }			
}
@GetMapping("/ogrenciGuncelle")
@Test
public void OgrenciGuncellemeTesti() {
	List<String> ogrenciler = new ArrayList<>();
	 {
		 String ogrencİsim1 ="Oğuzhan";
		 String ogrencİsim2 ="Aleyna";
		 String ogrencİsim3 ="Büşra";
		 String ogrencİsim4 ="Mert";
		 ogrencİsim1 = "Oğuzhan";
		 ogrenciler.remove(ogrencİsim1);
			ogrenciler.add(ogrencİsim1);
			assertEquals(ogrencİsim4,"Mert");	
	 } 
}
@GetMapping("/ogrenciNotEkleVeGuncelle")
@Test
public void ogrenciNotEklemeGuncellemeTesti() {
	List<String> ogrenciler = new ArrayList<>();
	 {
		 String ogrencİsim1 ="Oğuzhan";
		 String ogrencİsim2 ="Aleyna";
		 String ogrencİsim3 ="Büşra";
		 String ogrencİsim4 ="Mert";
		 String eklenenNot="50";
		 String guncelNot ="80";		
		 ogrenciler.remove(ogrencİsim1+" "+eklenenNot);
			ogrenciler.add(ogrencİsim1+" "+eklenenNot.replace(eklenenNot, guncelNot));
			ogrenciler.remove(ogrencİsim1+" "+eklenenNot);
			assertEquals(ogrencİsim2,"Aleyna");
			assertEquals(eklenenNot,"50");
			assertEquals(guncelNot,"80");
			
	 }
	
}

}
