package test;

import static org.junit.Assert.*;

import org.junit.Test;

import ctr.Datei;
import ctr.Info;
import ctr.Ordner;

public class TestSE14 {

	@Test
	public void test() {
		
		Ordner testOrdner = new Ordner("Test Ordner");
		Datei testDatei = new Datei("Test", ".test");
		
		testOrdner.add(testDatei);
		
		
		
		Ordner testUnterOrdner = new Ordner("TestUnterOrdner");
		Datei testUnterDatei = new Datei("TestUnterDatei", ".test");
		
		Ordner testLeererOrdner = new Ordner("LeererOrdner");
		
		testOrdner.add(testLeererOrdner);
		
		testUnterOrdner.add(testUnterDatei);
		testOrdner.add(testUnterOrdner);
		
		Info infoTest = new Info();
		
		infoTest.visit(testOrdner);

		infoTest.ergebnis();
		
		assertEquals(2, infoTest.getTiefe());
		assertEquals(3,infoTest.getBlatt());
		assertEquals((double)1.5, infoTest.getDurchschnittlicherVerzweigungsGrad(),0);

		
	}
}