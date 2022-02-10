package lists;

public class Simple_Windows {

	Nodo_Simple_Windows primero;

	public Simple_Windows() {
		this.primero = null;
	}

	public void insert(Object info) {
		Nodo_Simple_Windows new_node = new Nodo_Simple_Windows(info);
		if (isNone()) {
			this.primero = new_node;
		} else {
			new_node.next = this.primero;
			this.primero = new_node;
		}
	}

	public void showList() {
		if (isNone() == false) {
			Nodo_Simple_Windows actual = this.primero;
			while (actual != null) {
				System.out.println(actual.info);
				actual = actual.next;
			}
		}
	}

	public void Search(Object data) {
		if (isNone() == false) {
			Nodo_Simple_Windows actual = this.primero;
			while (actual != null && actual.info != data) {
				actual = actual.next;
				if (actual == null) {
					System.out.println("No se encontro el dato: " + data);
					break;
				}
			}
			if (actual != null && actual.info == data) {
				System.out.println("Dato encontrado: " + data);
			}
		}
	}
	
	/*
	public void Delete(Object data) {
		if (isNone() == false) {
			Nodo_Simple_Windows actual = this.primero;
			Nodo_Simple_Windows anterior = null;

			while (actual != null && actual.info != data) {
				anterior = actual;
				actual = actual.next;
			}

			if (anterior == null) {
				this.primero = actual.next;
				System.out.println("Se elimino el dato: " + data);
			} else if (actual != null) {
				anterior.next = actual.next;
				actual.next = null;
				System.out.println("Se elimino el dato: " + data);
			} else {
				System.out.println("No se encontro el dato a eliminar: " + data);
			}
		}
	}*/

	public Boolean isNone() {
		return this.primero == null;
	}
}

class Nodo_Simple_Windows {

	Nodo_Simple_Windows next;
	Object info;
	Object cliente_actual;
	//Pila

	public Nodo_Simple_Windows(Object info) {
		this.next = null;
		this.info = info;
	}
}
