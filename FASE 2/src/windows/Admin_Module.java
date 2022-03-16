package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.transform.Source;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Admin_Module extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Nuevo_Password;
	private JTextField textField_Nuevo_DPI;
	private JTextField textField_Nuevo_Name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Module frame = new Admin_Module();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Admin_Module() {
		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.JSON", "JSON");
		fc.setFileFilter(filter);
		fc.setCurrentDirectory(new File("./Test"));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 932, 613);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 896, 552);
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
		label_ruta.setBounds(48, 11, 569, 14);
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
		textField_Nuevo_Password.setBounds(139, 106, 163, 20);
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
		textField_Nuevo_DPI.setBounds(139, 35, 163, 20);
		panel_4.add(textField_Nuevo_DPI);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_2_2_1.setBounds(33, 109, 117, 14);
		panel_4.add(lblNewLabel_2_2_1);
		
		textField_Nuevo_Name = new JTextField();
		textField_Nuevo_Name.setColumns(10);
		textField_Nuevo_Name.setBounds(139, 66, 163, 20);
		panel_4.add(textField_Nuevo_Name);
		
		JPanel panel_5 = new JPanel();
		tabbedPane_1.addTab("Modificar cliente", null, panel_5, null);
		panel_5.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		tabbedPane_1.addTab("Eliminar cliente", null, panel_6, null);
		panel_6.setLayout(null);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Arbol de clientes", null, panel_2, null);
		panel_2.setLayout(null);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Reportes", null, panel_3, null);
		panel_3.setLayout(null);

		// Buttons
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

			}
		});

		Button_LoadClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!label_ruta.getText().equals("Null")) {

					 textOut.setText( ReadJson(label_ruta.getText()));
					
					
					
				} else {
					JOptionPane.showMessageDialog(null, "Seleccionar un archivo");
				}

			}
		});
	}

	public String ReadJson(String ruta) {

		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader(ruta)) {
			String temp = "" ;
			Object obj = jsonParser.parse(reader);

			JSONArray jsonList = (JSONArray) obj;
			System.out.println(jsonList + "\n");
			
			for (Object object : jsonList) {
				temp+= object + "\n\n";
				JSONObject data = (JSONObject) object;
				System.out.println(data);
				
				String name = (String) data.get("nombre_cliente");
				//System.out.println(name);
				
				String dpi = (String) data.get("dpi");
				//System.out.println(dpi);
				
				String password = (String) data.get("password");
				//System.out.println(password);
			}
	
			System.out.println("El archivo se ingreso correctamente");
			return temp;
			
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "Ocurrio un error en la lectura del JSON");
			return null;
		}
	}
}