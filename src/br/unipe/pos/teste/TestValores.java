package br.unipe.pos.teste;

import br.unipe.pos.model.Valores;
import junit.framework.TestCase;

public class TestValores extends TestCase {
	
	private Valores valores;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		valores = new Valores();
		valores.ins(5);
		valores.ins(12);
		valores.ins(1);
		valores.ins(30);
		valores.ins(152);
		valores.ins(6);
	}
	
	public void testIns() {
		assertEquals(false, valores.ins(-10));
		assertEquals(false, valores.ins(0));
		valores.ins(2);
		assertEquals(7, valores.size());
		valores.ins(3);
		assertEquals(8, valores.size());
		valores.ins(4);
		assertEquals(9, valores.size());
		assertEquals(true, valores.ins(5));
		assertEquals(10, valores.size());
		assertEquals(false, valores.ins(11));
	}
	
	public void testDel() {
		assertEquals(5, valores.del(0));
		assertEquals(12, valores.del(1));
		assertEquals(1, valores.del(2));
		assertEquals(30, valores.del(3));
		assertEquals(152, valores.del(4));
		assertEquals(6, valores.del(5));
		
		assertEquals(-1, valores.del(0));
		
	}
	
	public void testMean() {
		testIns();
		
		assertEquals(22d, valores.mean());

		valores.del(0);
		valores.del(1);
		valores.del(2);
		valores.del(3);
		valores.del(4);
		valores.del(5);
		valores.del(6);
		valores.del(7);
		valores.del(8);
		valores.del(9);

		assertEquals(-1d, valores.mean());
	}
	
	public void testGreater() {
		assertEquals(152, valores.greater());

		testDel();
		
		assertEquals(-1, valores.greater());
		
	}
	
	public void testLower() {
		assertEquals(1, valores.lower());

		testDel();
		
		assertEquals(-1, valores.lower());
	}
	
	

}
