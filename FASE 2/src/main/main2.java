package main;

import java.awt.EventQueue;

import storage.ArbolB;




public class main2 {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				/*
				B arbolB = new B(5);
				//int[] edad = { 6, 11, 5, 4, 8, 9, 12, 21, 14, 10, 19, 28, 3, 17, 32, 15, 16, 26, 27 };
				//int[] edad = { 6, 11, 5, 4, 8, 9, 12, 21, 14, 10, 19, 28, 3, 17, 32, 15, 16};
				int[] edad = { 6,4,4,4 };
				for (int i : edad) {
					//arbolB.insertar(i,null);
				}
				arbolB.draw_start(arbolB.raiz.primero,"_ArbolB");
				
				//arbolB.raiz.print_start(arbolB.raiz.primero);
				System.out.println("algo");*/
				
				//int[] edad = { 6, 11, 5, 4, 8, 9,12, 21, 14, 10, 19, 28, 3, 17, 32, 15, 16, 26, 27 };
				//int[] edad = { 6,4,4,4 };
				//Long myStr1 = Long.valueOf("2999062130131"); Long myStr2 =Long.valueOf("2999062130102");
			    
			   // System.out.println(myStr1.compareTo(myStr2));
				
				/*ArbolB arbol = new ArbolB();
				String[] edad = { "6", "11", "5" };
				
				for (String string : edad) {
					Long id= Long.valueOf(string);
					arbol.insertar(id, null);
					
				}
				
				Long id = Long.valueOf("6");
				arbol.raiz.asdadasdd(arbol.raiz.primero,id);
				*/
				Long id = Long.valueOf("100");
				Long id2 = Long.valueOf("9000");
			   
			    System.out.println(id.compareTo(id2));

			}
		});

	}

}
