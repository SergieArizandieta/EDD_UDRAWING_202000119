package windows;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import objects.Clients;
import storage.NodoB;
import storage.Storage;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class Admin_Module extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Nuevo_Password;
	private JTextField textField_Nuevo_DPI;
	private JTextField textField_Nuevo_Name;
	private JTextField textField_DPI_search;
	private JTextField textField_Name_Modify;
	private JTextField textField_Password_Modify;
	private JTextField textField_deleteclient;
	private JTextField textField_id_searching;
	private JTable table;
	private JTable table_2;
	private JTable table_3;

	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { Admin_Module frame = new
	 * Admin_Module(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	public Admin_Module(Storage storage) {
		String[] Colums_table1 = { "DPI", "Nombre", "Password", "Cantidad de imagenes", "Cantidad de capas","Cantidad de Albumes" };
		String[] Colums_table2 = { "Album", "Imagenes" };
		String[] Colums_table3 = {"Cliente", "DPI", "Total de imagenes"};

		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.JSON", "JSON");
		fc.setFileFilter(filter);
		fc.setCurrentDirectory(new File("./Test"));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1526, 913);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 41, 1490, 822);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Carga Masiva", null, panel, null);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Ruta:");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 46, 14);
		panel.add(lblNewLabel);

		JLabel label_ruta = new JLabel("Null");
		label_ruta.setForeground(Color.BLACK);
		label_ruta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_ruta.setBounds(48, 11, 1127, 14);
		panel.add(label_ruta);

		JButton Button_Search = new JButton("Buscar Archivo");

		Button_Search.setBounds(10, 36, 123, 23);
		panel.add(Button_Search);

		TextArea textOut = new TextArea();
		textOut.setEditable(false);
		textOut.setBounds(312, 72, 569, 442);
		panel.add(textOut);

		JButton Button_LoadClients = new JButton("Cargar clientes");

		Button_LoadClients.setBounds(10, 69, 123, 23);
		panel.add(Button_LoadClients);

		JLabel lblNewLabel_4 = new JLabel("Clientes JSON ingresados");
		lblNewLabel_4.setBounds(312, 50, 171, 14);
		panel.add(lblNewLabel_4);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Operaciones de clientes", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Operaciones disponibles");
		lblNewLabel_1.setBounds(27, 11, 190, 14);
		panel_1.add(lblNewLabel_1);

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(27, 36, 836, 461);
		panel_1.add(tabbedPane_1);

		JPanel panel_4 = new JPanel();
		tabbedPane_1.addTab("Insertar nuevo cliente", null, panel_4, null);
		panel_4.setLayout(null);

		textField_Nuevo_Password = new JTextField();
		textField_Nuevo_Password.setBounds(139, 106, 237, 20);
		panel_4.add(textField_Nuevo_Password);
		textField_Nuevo_Password.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("DPI:");
		lblNewLabel_2_1.setBounds(69, 35, 46, 14);
		panel_4.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("Nombre cliente:");
		lblNewLabel_2_2.setBounds(33, 69, 117, 14);
		panel_4.add(lblNewLabel_2_2);

		textField_Nuevo_DPI = new JTextField();
		textField_Nuevo_DPI.setColumns(10);
		textField_Nuevo_DPI.setBounds(139, 35, 237, 20);
		panel_4.add(textField_Nuevo_DPI);

		JLabel lblNewLabel_2_2_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_2_2_1.setBounds(33, 109, 117, 14);
		panel_4.add(lblNewLabel_2_2_1);

		textField_Nuevo_Name = new JTextField();
		textField_Nuevo_Name.setColumns(10);
		textField_Nuevo_Name.setBounds(139, 66, 237, 20);
		panel_4.add(textField_Nuevo_Name);

		JButton btnNewButton = new JButton("Insertar");

		btnNewButton.setBounds(190, 171, 89, 23);
		panel_4.add(btnNewButton);

		JPanel panel_5 = new JPanel();
		tabbedPane_1.addTab("Modificar cliente", null, panel_5, null);
		panel_5.setLayout(null);

		JLabel lblNewLabel_2_1_1 = new JLabel("DPI:");
		lblNewLabel_2_1_1.setBounds(51, 34, 46, 14);
		panel_5.add(lblNewLabel_2_1_1);

		textField_DPI_search = new JTextField();
		textField_DPI_search.setColumns(10);
		textField_DPI_search.setBounds(121, 34, 237, 20);
		panel_5.add(textField_DPI_search);

		JButton btnBuscarYModificar = new JButton("Buscar y modificar");

		btnBuscarYModificar.setBounds(170, 173, 155, 23);
		panel_5.add(btnBuscarYModificar);

		JLabel lblNewLabel_2_2_2 = new JLabel("Nombre cliente:");
		lblNewLabel_2_2_2.setBounds(15, 117, 117, 14);
		panel_5.add(lblNewLabel_2_2_2);

		textField_Name_Modify = new JTextField();
		textField_Name_Modify.setColumns(10);
		textField_Name_Modify.setBounds(121, 114, 237, 20);
		panel_5.add(textField_Name_Modify);

		JLabel lblNewLabel_2_2_1_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_2_2_1_1.setBounds(15, 142, 117, 14);
		panel_5.add(lblNewLabel_2_2_1_1);

		textField_Password_Modify = new JTextField();
		textField_Password_Modify.setColumns(10);
		textField_Password_Modify.setBounds(121, 142, 237, 20);
		panel_5.add(textField_Password_Modify);

		JLabel lblNewLabel_2_1_1_2 = new JLabel("Datos del cliente a modificar:  ");
		lblNewLabel_2_1_1_2.setBounds(15, 92, 202, 14);
		panel_5.add(lblNewLabel_2_1_1_2);

		JPanel panel_6 = new JPanel();
		tabbedPane_1.addTab("Eliminar cliente", null, panel_6, null);
		panel_6.setLayout(null);

		textField_deleteclient = new JTextField();
		textField_deleteclient.setColumns(10);
		textField_deleteclient.setBounds(136, 39, 237, 20);
		panel_6.add(textField_deleteclient);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("DPI:");
		lblNewLabel_2_1_1_1.setBounds(66, 39, 46, 14);
		panel_6.add(lblNewLabel_2_1_1_1);

		JButton Button_Delete_Client = new JButton("Eliminar");
		
		Button_Delete_Client.setBounds(211, 83, 89, 23);
		panel_6.add(Button_Delete_Client);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Arbol de clientes", null, panel_2, null);
		panel_2.setLayout(null);

		JPanel panel_7 = new JPanel();
		panel_7.setBounds(10, 45, 1465, 738);
		panel_2.add(panel_7);
		panel_7.setLayout(null);

		JLabel lblNewLabel_img = new JLabel("");
		lblNewLabel_img.setBounds(10, 11, 1445, 716);
		panel_7.add(lblNewLabel_img);

		JLabel lblNewLabel_3 = new JLabel("Arbol de Clientes");
		lblNewLabel_3.setBounds(10, 20, 116, 14);
		panel_2.add(lblNewLabel_3);

		JButton Button_btree = new JButton("Generar");

		Button_btree.setBounds(136, 16, 131, 23);
		panel_2.add(Button_btree);

		JButton Button_btree_1 = new JButton("Visualizar");

		Button_btree_1.setBounds(594, 16, 131, 23);
		panel_2.add(Button_btree_1);

		JLabel lblNewLabel_3_1 = new JLabel("Nombre del archivo:");
		lblNewLabel_3_1.setBounds(277, 20, 144, 14);
		panel_2.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_1_1 = new JLabel("Admin_Btree_Clients");
		lblNewLabel_3_1_1.setBounds(431, 20, 153, 14);
		panel_2.add(lblNewLabel_3_1_1);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Reportes", null, panel_3, null);
		panel_3.setLayout(null);

		JComboBox<String> comboBox_estrucgenerates = new JComboBox<String>();
		comboBox_estrucgenerates.setModel(
				new DefaultComboBoxModel<String>(new String[] { "Listar clientes", "Buscar cliente por id" }));
		comboBox_estrucgenerates.setBounds(10, 51, 206, 22);
		panel_3.add(comboBox_estrucgenerates);

		textField_id_searching = new JTextField();
		textField_id_searching.setBounds(226, 52, 143, 20);
		panel_3.add(textField_id_searching);
		textField_id_searching.setColumns(10);

		String[] rows__table1 = new String[0];

		JButton btnNewButton_1 = new JButton("Generar reporte");

		btnNewButton_1.setBounds(379, 51, 138, 23);
		panel_3.add(btnNewButton_1);

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.LIGHT_GRAY);
		panel_8.setBounds(527, 26, 948, 757);
		panel_3.add(panel_8);
		panel_8.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Informacion del cliente  buscado");
		lblNewLabel_2.setBounds(10, 11, 200, 14);
		panel_8.add(lblNewLabel_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 934, 72);
		panel_8.add(scrollPane);

		table = new JTable();
		table.setModel(
				new DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, }, Colums_table1));

		table.getColumnModel().getColumn(1).setResizable(false);
		scrollPane.setViewportView(table);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(125, 133, 689, 613);
		panel_8.add(scrollPane_1);

		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(new Object[][] { { null, null }, }, Colums_table2));

		scrollPane_1.setViewportView(table_2);

		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.LIGHT_GRAY);
		panel_9.setBounds(10, 105, 507, 678);
		panel_3.add(panel_9);
		panel_9.setLayout(null);

		JLabel lblNewLabel_2_3 = new JLabel("Clientes del arbol B por niveles");
		lblNewLabel_2_3.setBounds(10, 11, 200, 14);
		panel_9.add(lblNewLabel_2_3);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 36, 487, 631);
		panel_9.add(scrollPane_2);

		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(new Object[][] {{null, null, null},},Colums_table3));
		scrollPane_2.setViewportView(table_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("DPI buscado");
		lblNewLabel_2_4.setBounds(225, 37, 200, 14);
		panel_3.add(lblNewLabel_2_4);

		JButton Button_closesesion = new JButton("Cerrar sesion");

		Button_closesesion.setBounds(775, 23, 131, 23);
		contentPane.add(Button_closesesion);

		// Buttons-----------------------------------------------------------------------------------------------------------
		Button_Delete_Client.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String DPI = textField_deleteclient.getText();
					Long DPI_int = Long.valueOf(DPI);
					
					//System.out.println(DPI_int);
					storage.RemovingClient(DPI_int);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Debe ingresar un digito en el DPI");
					System.out.println(e2);
				}
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (comboBox_estrucgenerates.getSelectedItem() == "Listar clientes") {
						Queue<Clients> info ;
						info =storage.ClientesB.print_start(storage.ClientesB.raiz.primero);
						Object[][] list = new Object[info.size()][3];
						int contador = 0;
						
						while (info.peek() != null) {
							Clients temp = info.poll();
							
							list[contador][0] = temp.Name;
							list[contador][1] = temp.DPI;
							
							Object  no_images = temp.AVLImages.cantidad_images();
							list[contador][2] = no_images;
							
							contador++;
						}
						table_3.setModel(new DefaultTableModel(list,Colums_table3));
						
					} else if (comboBox_estrucgenerates.getSelectedItem() == "Buscar cliente por id") {
						Long id = Long.valueOf(textField_id_searching.getText());
						
						NodoB nodotemp = storage.ClientesB.buscar_start(storage.ClientesB.raiz.primero,id);
						System.out.println("\n\n------Registro--------");
						
						Object DPI = nodotemp.cliente.DPI;
						Object name = nodotemp.cliente.Name;
						Object password = nodotemp.cliente.Password;
						
						Object  no_capas = nodotemp.cliente.ABBCapas.cantidad_images();
						System.out.println("No capas: " + no_capas);
						
						Object  no_images = nodotemp.cliente.AVLImages.cantidad_images();
						System.out.println("No iamges: " + no_images);
						
						nodotemp.cliente.Album_list.cantidad_albums();
						Object  no_albums = nodotemp.cliente.Album_list.albums.size();
						
						System.out.println("Canrida de albums: " + no_albums);
						
						Object[][] data_albums = nodotemp.cliente.Album_list.data_toshow();
						
						table.setModel(new DefaultTableModel(new Object[][] { {  DPI, name, password, no_images, no_capas, no_albums }, }, Colums_table1));
						table_2.setModel(new DefaultTableModel(data_albums, Colums_table2));
					}
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Debe ingresar un digito en el DPI");
					table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, }, Colums_table1));
					table_2.setModel(new DefaultTableModel(new Object[][] { { null, null }, }, Colums_table2));
					table_3.setModel(new DefaultTableModel(new Object[][] {{null, null, null},},Colums_table3));
					System.out.println(e2);
				}

			}
		});

		btnBuscarYModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String DPI = textField_DPI_search.getText();
					String name = textField_Name_Modify.getText();
					String password = textField_Password_Modify.getText();
					Long DPI_long = Long.valueOf(DPI);
					storage.modifyClient(DPI_long, name, password);

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Debe ingresar un digito en el DPI");
					System.out.println(e2);
				}
			}
		});

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String DPI = textField_Nuevo_DPI.getText();
					String Name = textField_Nuevo_Name.getText();
					String Password = textField_Nuevo_Password.getText();

					if (!(DPI.equals("") | Name.equals("") | Password.equals(""))) {
						Long DPI_number = Long.valueOf(DPI);

						Clients cliente_temp = new Clients(Name, Password, DPI);
						JOptionPane.showMessageDialog(null, "Se Ingreso DPI");
						storage.InsertClients(cliente_temp, DPI_number);

					} else {
						JOptionPane.showMessageDialog(null, "Debe ingresar todos los datos correspondinets");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Debe ingresar un digito en el DPI");
				}

			}
		});

		Button_btree_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = "Admin_Btree_Clients";
				String ruta = "Grafico\\" + name + ".png";
				System.out.println(name);
				ImageIcon imagen = new ImageIcon(ruta);
				lblNewLabel_img.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(lblNewLabel_img.getWidth(),
						lblNewLabel_img.getHeight(), Image.SCALE_SMOOTH)));
			}
		});

		Button_btree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				storage.ClientesB.draw_start(storage.ClientesB.raiz.primero, "Admin_Btree_Clients");
				JOptionPane.showMessageDialog(null, "Se creo grafo: arbol B de clientes");
			}
		});

		Button_Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fc.showOpenDialog(Button_Search) == JFileChooser.APPROVE_OPTION) {
					try {
						textOut.setText(" ");

						label_ruta.setText(fc.getSelectedFile().toString());

					} catch (Exception e2) {

					}
				} else {
					label_ruta.setText("Null");
				}
//DPI:2299062130101\nName: Sergie Daniel\nPassword: 1234
			}
		});

		Button_LoadClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!label_ruta.getText().equals("Null")) {

					textOut.setText(ReadJson(label_ruta.getText(), storage));

				} else {
					JOptionPane.showMessageDialog(null, "Seleccionar un archivo");
				}

			}
		});

		Button_closesesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login(storage);
				login.setVisible(true);
				dispose();
			}
		});
	}

	public String ReadJson(String ruta, Storage storage) {

		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader(ruta)) {
			String temp = "";
			Object obj = jsonParser.parse(reader);

			JSONArray jsonList = (JSONArray) obj;
			// System.out.println(jsonList + "\n");

			for (Object object : jsonList) {

				JSONObject data = (JSONObject) object;
				// System.out.println(data);

				String name = (String) data.get("nombre_cliente");
				// System.out.println(name);

				String dpi = ((String) data.get("dpi"));
				Long DPI_Long = Long.valueOf(dpi);
				// System.out.println(DPI_Long);

				String password = (String) data.get("password");
				// System.out.println(password);

				Clients client_new = new Clients(name, password, dpi);

				if (dpi != null && name != null && password != null) {
					temp += object + "\n\n";
					storage.InsertClients(client_new, DPI_Long);
				}
			}
			// storage.showClients();

			System.out.println("El archivo se ingreso correctamente");
			return temp;

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Ocurrio un error en la lectura del JSON");
			System.out.println(e);
			return null;
		}
	}
}
