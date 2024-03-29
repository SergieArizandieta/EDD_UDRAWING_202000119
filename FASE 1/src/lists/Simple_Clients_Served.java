package lists;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import object.client;
//list of client served
public class Simple_Clients_Served {

	Nodo_Simple_Client_Served primero;

	public Simple_Clients_Served() {
		this.primero = null;
	}
	//insert new data
	public void insert(client info) {//log_2(n)
		Nodo_Simple_Client_Served new_node = new Nodo_Simple_Client_Served(info);
		if (isNone()) {
			this.primero = new_node;
		} else {
			Nodo_Simple_Client_Served actual = this.primero;
			while (actual.next != null) {
				actual = actual.next;
			}
			actual.next = new_node;
		}
	}
	
	//clonate the list
	public void clonacion(Simple_Clients_Served Lista) { 
		Nodo_Simple_Client_Served actual_aclonar = Lista.primero;
		
		while (actual_aclonar != null) {	
			insert(actual_aclonar.cliente);
			actual_aclonar = actual_aclonar.next;
		}
}
	//show the list
	public void showList() {
		if (isNone() == false) {
			Nodo_Simple_Client_Served actual = this.primero;
			while (actual != null) {
				System.out.println("\nNombre: " + actual.cliente.name +"\nVentanilla: " + actual.cliente.VentanillaIngresada + ""
						+ "\nNumero de imagenes: " + (actual.cliente.img_bwTotal + actual.cliente.img_colorTotal) + ""
								+ "\nPasos totales: " + (actual.cliente.PasoSalida - actual.cliente.PasoIngresado) + "\n\n"  );
				actual = actual.next;
			}
		}
	}
	
	//search a specific data in the list
	public void Search(int ClientId) {
		if (isNone() == false) {
			Nodo_Simple_Client_Served actual = this.primero;
			while (actual != null && actual.cliente.id != ClientId) {
				actual = actual.next;
				if (actual == null) {
					System.out.println("No se encontro el dato: " + ClientId);
					Draw_GraphizReport_serching(null,ClientId);
					break;
				}
			}
			if (actual != null && actual.cliente.id == ClientId) {
				System.out.println("Dato encontrado: " + ClientId);
				Draw_GraphizReport_serching( actual.cliente,ClientId);
			}
		}else {
			System.out.println("La lista esta vacia");
			openimg();
		}
	}
	
	//verify if the list is null
	public Boolean isNone() {
		return this.primero == null;
	}
	
	//create the graphivz texet
	public String Text_Graphivz() {
		StringBuilder dot = new StringBuilder();
		dot.append("digraph L {\n");
		dot.append("node[shape=note fillcolor=\"#A181FF\" style =filled]\n");
		dot.append("subgraph cluster_p{\n");
		dot.append("    label= \" Clientes atendidos \"\n");
		dot.append("    bgcolor = \"#FF7878\"\n");

		String nombresNodos = "";
		String conexiones = "";
		Nodo_Simple_Client_Served aux = this.primero;
		while (aux != null) {
			String info ="\nNombre: " + aux.cliente.name +"\nAtendido por ventanilla: " + aux.cliente.VentanillaIngresada + ""
					+ "\nNumero de imagenes impresas: " + (aux.cliente.img_bwTotal + aux.cliente.img_colorTotal) + ""
					+ "\nPasos totales en sistema: " + (aux.cliente.PasoSalida - aux.cliente.PasoIngresado); 
			nombresNodos += "Nodo" + aux.hashCode() + "[label=\"" + info + "\",fillcolor=\"#81FFDA\"]\n";
			if (aux.next != null)
				conexiones += String.format("Nodo%d -> Nodo%d\n", aux.hashCode(), aux.next.hashCode());
			aux = aux.next;
		}
		dot.append(nombresNodos);
		dot.append(conexiones);

		dot.append("}}");

		return dot.toString();
	}

	//create the dot file
	private void Create_File(String route, String contents) {

		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter(route);
			pw = new PrintWriter(fw);
			pw.write(contents);
			pw.close();
			fw.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			if (pw != null)
				pw.close();
		}

	}
	
	//draw the graph
	public void Draw_Graphiz() {

		try {
			if(isNone()) {
				String graph = "digraph L {\r\n"
						+ "node[shape=note fillcolor=\"#A181FF\" style =filled]\r\n"
						+ "subgraph cluster_p{\r\n"
						+ "    label= \" Clientes atendidos \"\r\n"
						+ "    bgcolor = \"#FF7878\"\r\n"
						+ "Nodo1008925772[label=\"Vacio\",fillcolor=\"#81FFDA\"]\r\n"
						+ "\r\n"
						+ "}}";
				Create_File("Simple_Clients_Served.dot", graph);
			}else {
				Create_File("Simple_Clients_Served.dot", Text_Graphivz());
			}

			//System.out.println(Text_Graphivz());
			ProcessBuilder pb;
			pb = new ProcessBuilder("dot", "-Tpng", "-o", "Simple_Clients_Served.png", "Simple_Clients_Served.dot");
			pb.redirectErrorStream(true);
			pb.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//open the graph
	public void openimg() {
		try {
			String url = "Simple_Clients_Served.png";
			ProcessBuilder p = new ProcessBuilder();
			p.command("cmd.exe", "/c", url);
			p.start();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	//sort ascedent by the majot num of steps
	public void SortASC_Steps() {
		if (isNone() == false) {

			Nodo_Simple_Client_Served actual = this.primero;
			Nodo_Simple_Client_Served pivot;
			client temp;
			while (actual != null) {
				pivot = actual.next;

				while (pivot != null) {

					if ((actual.cliente.PasoSalida - actual.cliente.PasoIngresado) < (pivot.cliente.PasoSalida
							- pivot.cliente.PasoIngresado)) {
						temp = actual.cliente;
						actual.cliente = pivot.cliente;
						pivot.cliente = temp;
					}

					pivot = pivot.next;
				}
				actual = actual.next;
			}
			//showList();
		}else {
			System.out.println("La lista esta vacia");
			
		}
	}

	//sort the list in decedent by the no of imges blank and white
	public void SortDesc_BW() {

		if (isNone() == false) {

			Nodo_Simple_Client_Served actual = this.primero;
			Nodo_Simple_Client_Served pivot;
			client temp;
			while (actual != null) {
				pivot = actual.next;

				while (pivot != null) {

					if (actual.cliente.img_bwTotal > pivot.cliente.img_bwTotal) {
						temp = actual.cliente;
						actual.cliente = pivot.cliente;
						pivot.cliente = temp;
					}

					pivot = pivot.next;
				}
				actual = actual.next;
			}
			//showList();
		}else {
			System.out.println("La lista esta vacia");
			
		}
	}

	//sort the list ascedent by the num of images color printed
	public void  SortASC_Color() {
		if (isNone() == false) {
			Nodo_Simple_Client_Served actual = this.primero;
			Nodo_Simple_Client_Served pivot;
			client temp;
			while (actual != null) {
				pivot = actual.next;

				while (pivot != null) {

					if (actual.cliente.img_colorTotal < pivot.cliente.img_colorTotal) {
						temp = actual.cliente;
						actual.cliente = pivot.cliente;
						pivot.cliente = temp;
					}

					pivot = pivot.next;
				}
				actual = actual.next;
			}
			//showList();
		}else {
			System.out.println("La lista esta vacia");
		
		}
	}
	
	//creaste the text of graphivz
	public String Text_Graphivz_Report(String tipo,int cantidad,int option) {
		int counter=0;
		StringBuilder dot = new StringBuilder();
		dot.append("digraph L {\n");
		dot.append("node[shape=note fillcolor=\"#A181FF\" style =filled]\n");
		dot.append("subgraph cluster_p{\n");
		dot.append("    label= \"" +  tipo + "\"\r\n");
		dot.append("    bgcolor = \"#FF7878\"\n");

		String nombresNodos = "";
		String conexiones = "";
		Nodo_Simple_Client_Served aux = this.primero;
		while (aux != null) {
			if (counter < cantidad) {
				String info = "";
				
				if(option==2) {
					info = "\nID: " + aux.cliente.id;
					info += "\nNombre: " + aux.cliente.name;
					info += "\nImgenes a color: " + aux.cliente.img_colorTotal;

				}else if (option==3) {
					info = "\nID: " + aux.cliente.id;
					info += "\nNombre: " + aux.cliente.name;
					info += "\nImgenes Blanco y Negro: " + aux.cliente.img_bwTotal;
				}else if (option==4) {
					info = "\nID: " + aux.cliente.id;
					info += "\nNombre: " + aux.cliente.name;
					info += "\nPasos en sistema: " + (aux.cliente.PasoSalida - aux.cliente.PasoIngresado);
				}
				
				nombresNodos += "Nodo" + aux.hashCode() + "[label=\"" + info + "\",fillcolor=\"#81FFDA\"]\n";
				if (aux.next != null && (counter +1)<cantidad)
					conexiones += String.format("Nodo%d -> Nodo%d\n", aux.hashCode(), aux.next.hashCode());
				aux = aux.next;
				counter ++;
			}else {
				break;
			}
		}
		dot.append(nombresNodos);
		dot.append(conexiones);

		dot.append("}}");

		return dot.toString();
	}
	
	//draw the graph searching a specific data
	public void Draw_GraphizReport_serching(client cliente,int id) {
		try {
		String graph = "digraph L {\r\n"
				+ "node[shape=note fillcolor=\"#A181FF\" style =filled]\r\n"
				+ "subgraph cluster_p{\r\n";
		
		graph += "    label= \"" + "Busqueda del Cliente ID: " + id + "\"\r\n";
		if (cliente != null) {
			String info = "";
			info += "ID: " + cliente.id;
			info += "\nNombre: " + cliente.name;
			info += "\nPasos en sitema: " + (cliente.PasoSalida - cliente.PasoIngresado);
			info += "\nVentanilla que atendio: " + cliente.VentanillaIngresada;
			info += "\nImagenes a color impresas: " + cliente.img_colorTotal;
			info += "\nImagenes blanco y negro impresas: " + cliente.img_bwTotal;
			info += "\nImagenes totales impresas: " + (cliente.img_bwTotal + cliente.img_colorTotal);

			graph += "    bgcolor = \"#FF7878\"\r\n" + "Nodo1008925772[label=\"" + info
					+ "\",fillcolor=\"#81FFDA\"]\r\n" + "\r\n" + "}}";
		} else {
			graph += "    bgcolor = \"#FF7878\"\r\n"
					+ "Nodo1008925772[label=\"No se encontro cliente\",fillcolor=\"#81FFDA\"]\r\n" + "\r\n" + "}}";
		}

		Create_File("Simple_Clients_Served_Report_Searc.dot", graph);
		ProcessBuilder pb;
		pb = new ProcessBuilder("dot", "-Tpng", "-o", "Simple_Clients_Served_Report_Searc.png",
				"Simple_Clients_Served_Report_Searc.dot");
		pb.redirectErrorStream(true);

		pb.start();
		openimgReportSerching();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
	//open the graph with the data serched
	public void openimgReportSerching() {
		try {
			String url = "Simple_Clients_Served_Report_Searc.png";
			ProcessBuilder pp = new ProcessBuilder();
			pp.command("cmd.exe", "/c", url);
			pp.start();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	//draw the graph of report
	public void Draw_GraphizReport(String tipo,int repetir,int option) {

		try {
			if(isNone()) {
				String graph = "digraph L {\r\n"
						+ "node[shape=note fillcolor=\"#A181FF\" style =filled]\r\n"
						+ "subgraph cluster_p{\r\n";
				
				
				graph+= "    label= \"" +  tipo + "\"\r\n";
				
				graph+=	"    bgcolor = \"#FF7878\"\r\n"
						+ "Nodo1008925772[label=\"Vacio\",fillcolor=\"#81FFDA\"]\r\n"
						+ "\r\n"
						+ "}}";
				Create_File("Simple_Clients_Served_Report.dot", graph);
			}else {
				Create_File("Simple_Clients_Served_Report.dot", Text_Graphivz_Report(tipo,repetir,option));
			}

			//System.out.println(Text_Graphivz());
			ProcessBuilder pb;
			pb = new ProcessBuilder("dot", "-Tpng", "-o", "Simple_Clients_Served_Report.png", "Simple_Clients_Served_Report.dot");
			pb.redirectErrorStream(true);
			pb.start();
			
			openimgReport();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	//open graph of report
	public void openimgReport() {
		try {
			String url = "Simple_Clients_Served_Report.png";
			ProcessBuilder pp = new ProcessBuilder();
			pp.command("cmd.exe", "/c", url);
			pp.start();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
	//node of list
	class Nodo_Simple_Client_Served {

		Nodo_Simple_Client_Served next;
		client cliente;
		//contrductor
		public Nodo_Simple_Client_Served(client cliente) {
			this.next = null;
			this.cliente = cliente;
		}
}

