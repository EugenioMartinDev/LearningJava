package vista;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.*;

import modelo.negocio.GestorPeliculas;
import modelo.negocio.Pelicula;
import modelo.persistencia.DaoPelicula;
import utils.Constantes;

import java.awt.*;              //for layout managers and more
import java.awt.event.*;        //for action events
 
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.io.IOException;
 
public class vistaSwingPeliculas extends JPanel
                             implements ActionListener {
    private String newline = "\n";
 
    protected JLabel actionLabel;
    
    static GestorPeliculas gp = null;
    
    boolean anioSelected = false;
    boolean tituloSelected = false;
    boolean directorSelected = false;
    boolean generoSelected = false;
    boolean useCombo = false;
    
    JTable peliculas = null;

    
    public vistaSwingPeliculas() {
    	
        //this.setPreferredSize(new Dimension(600,600));
        this.setVisible(true);
        
        JTabbedPane tabbedPane = new JTabbedPane();
        //tabbedPane.setPreferredSize(new Dimension(500,500));
        tabbedPane.setVisible(true);
        ImageIcon icon = createImageIcon("images/middle.gif");
        
        JComponent panel1 = makeTextPanel("Panel #1");
        //panel1.setPreferredSize(new Dimension(500, 500));
        //panel1.setLayout(new BorderLayout());
        tabbedPane.addTab("ALTA", icon, panel1,
                "Does nothing");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
        
        JComponent panel2 = makeTextPanel2("Panel #2");
        //panel3.setPreferredSize(new Dimension(300, 300));
        tabbedPane.addTab("BUSQUEDA", icon, panel2,
                "Still does nothing");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_3);
        
        JComponent panel3 = makeTextPanel3("Panel #3");
        //panel2.setPreferredSize(new Dimension(300, 300));
        tabbedPane.addTab("MODIFICACION", icon, panel3,
                "Does twice as much nothing");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_2);
               
        JComponent panel4 = makeTextPanel(
                "Panel #4 (has a preferred size of 410 x 50).");
        //panel4.setPreferredSize(new Dimension(410, 50));
        tabbedPane.addTab("LISTADO", icon, panel4,
                "Does nothing at all");
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
        
        //Add the tabbed pane to this panel.
        add(tabbedPane, BorderLayout.CENTER);
        
      
        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }
 
    public JComponent makeTextPanel(String texto) {
    	JPanel tabPane =  new JPanel();
    	tabPane.setLayout(new BorderLayout());
    	
        // Global gridbag layout
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
 
        // Creating input data fields
        JTextField tituloText = new JTextField(10);
        JTextField directorText = new JTextField(10);
        JTextField anioProduccionText = new JTextField(4);
  		JComboBox<String> generoCombo = new JComboBox<String>();
  		generoCombo.addItem("Select");
  		generoCombo.addItem("Action");
  		generoCombo.addItem("Adventure");
  		generoCombo.addItem("Animation");
  		generoCombo.addItem("Anime");
  		generoCombo.addItem("Classic");
  		generoCombo.addItem("Comedy");
       
  		// Creating input labels
  		JLabel titulo = new JLabel("Título : ");
 
  		
  		JLabel director = new JLabel("Director : ");
  		JLabel anioProduccion = new JLabel("Año De Produccion : ");
  		JLabel genero = new JLabel("Género : ");
  		
        //Create a label to put messages during an action event.
        actionLabel = new JLabel("Type text in all fields and press SUBMIT.");
        actionLabel.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
       
        //Lay out the text controls and the labels.
        JPanel textControlsPane = new JPanel();
        textControlsPane.setLayout(gridbag);
 
        JLabel[] labels = {titulo, director, anioProduccion, genero};
        Component[] componentFields = {tituloText, directorText, anioProduccionText, generoCombo};
        addLabelTextRows(labels, componentFields, textControlsPane);
 
        c.gridwidth = GridBagConstraints.REMAINDER; //last
        c.anchor = GridBagConstraints.WEST;
        c.weightx = 1.0;
        textControlsPane.add(actionLabel, c);
        textControlsPane.setBorder(
                BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Input Fields"),
                                BorderFactory.createEmptyBorder(5,5,5,5)));
 
        //Lay out the button controls and the labels.
        JPanel buttonControlsPane = new JPanel();
        buttonControlsPane.setLayout(gridbag);
        
        // Button controls
        JButton submit = new JButton ("SUBMIT");
        c.gridwidth = GridBagConstraints.RELATIVE; //next-to-last
        c.fill = GridBagConstraints.NONE;     //reset to default
        c.weightx = 1.0;                       //reset to default
        c.anchor = GridBagConstraints.CENTER;
        buttonControlsPane.add(submit, c);

        JButton clear = new JButton ("CLEAR");
        c.gridwidth = GridBagConstraints.REMAINDER;     //end row
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 1.0;
        buttonControlsPane.add(clear, c);
        
        //Create a text reporting errors area.
        JTextArea textArea = new JTextArea(
                "Área de mensajes de control "
        );
        textArea.setFont(new Font("Serif", Font.ITALIC, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        JScrollPane areaScrollPane = new JScrollPane(textArea);
        areaScrollPane.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        areaScrollPane.setPreferredSize(new Dimension(250, 100));
        areaScrollPane.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Plain Text"),
                                BorderFactory.createEmptyBorder(5,5,5,5)),
                areaScrollPane.getBorder()));
        
        c.gridwidth = GridBagConstraints.REMAINDER; //last
        c.anchor = GridBagConstraints.WEST;
        c.weightx = 1.0;
        buttonControlsPane.add(areaScrollPane, c);
        buttonControlsPane.setBorder(
                BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Control Fields"),
                                BorderFactory.createEmptyBorder(5,5,5,5)));  
  	
        // Create a table
      	String[] columnNames = {"INDICE", "TITULO", "DIRECTOR", "AÑO DE PRODUCCION"};
      	Object[][] data = { {"", "", "", ""}};     	
      	//JTable peliculas = new JTable(data,columnNames);
      	DefaultTableModel dtm=new DefaultTableModel(columnNames,0);
      	JTable peliculas = new JTable(dtm);
      	setJTableColumnsWidth(peliculas, 250, 10, 50, 30, 10);
      	peliculas.setFillsViewportHeight(true);
      	peliculas.setEnabled(false);
      	JScrollPane editorPeliculas = new JScrollPane(peliculas);

      	JPanel surPane = new JPanel();
      	surPane.setLayout(new BorderLayout());
      	surPane.add(editorPeliculas);  
      	surPane.setPreferredSize(new Dimension(250, 145));
      	surPane.setMinimumSize(new Dimension(10, 10));
      	surPane.setBorder(                
      			BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Films Table"),
                                BorderFactory.createEmptyBorder(5,5,5,5)));
                 	
        //Put everything together.
        JPanel leftPane = new JPanel(new BorderLayout());
        leftPane.add(textControlsPane, 
                     BorderLayout.LINE_START);
        leftPane.add(buttonControlsPane,
                     BorderLayout.LINE_END);
 
        tabPane.add(leftPane, BorderLayout.PAGE_START);
        tabPane.add(surPane, BorderLayout.CENTER);
        
        DocumentListener documentListener = new DocumentListener() {
            private void printIt(DocumentEvent documentEvent) {
              DocumentEvent.EventType type = documentEvent.getType();
              String typeString = null;
              if (type.equals(DocumentEvent.EventType.CHANGE)) {
                typeString = "Change";
              }  else if (type.equals(DocumentEvent.EventType.INSERT)) {
                typeString = "Insert";
              }  else if (type.equals(DocumentEvent.EventType.REMOVE)) {
                typeString = "Remove";
              }
              System.out.print("Type : " + typeString);
              Document source = documentEvent.getDocument();
              int length = source.getLength();
              System.out.println("Length: " + length);
              try {
            	  System.out.println("documentEvent " + documentEvent.getDocument().getText(0, documentEvent.getDocument().getLength()));
              } catch (BadLocationException e) {
					// TODO Auto-generated catch block
            	  e.printStackTrace();
              }
              
              if (documentEvent.getDocument().getLength()> 0) {
  				ArrayList<Pelicula> listaPeliculas = null;
  				try {
  					listaPeliculas = (ArrayList) gp.buscarPeliculaPorTitulo(documentEvent.getDocument().getText(0, documentEvent.getDocument().getLength()));
  				} catch (BadLocationException e) {
  					// TODO Auto-generated catch block
  					e.printStackTrace();
  				}
  				
  				limpiarTabla(peliculas);
  				for (Pelicula elementoPelicula : listaPeliculas) {
  					Object[] row = {elementoPelicula.getId(), elementoPelicula.getTitulo(), elementoPelicula.getDirector(), elementoPelicula.getAnioPublicacion()};
  					DefaultTableModel modelo = (DefaultTableModel) peliculas.getModel();
  					modelo.addRow(row);
  				} 
              }
            
            }
			@Override
			public void changedUpdate(DocumentEvent e) {
				printIt(e);
				
			}
			@Override
			public void insertUpdate(DocumentEvent e) {
				printIt(e);
				
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				printIt(e);
				
			}
			
        	private void limpiarTabla(JTable tabla) {
                try {
                    DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
                    int filas=tabla.getRowCount();
                    for (int i = 0;filas>i; i++) {
                        	modelo.removeRow(0);
                    	}
        	        } catch (Exception e) {
        	            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        	        }
            	}
        };          
        tituloText.getDocument().addDocumentListener(documentListener);
                       
    	submit.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			if(tituloText.getText().isEmpty()||(directorText.getText().isEmpty())
    					||(anioProduccionText.getText().isEmpty()))
    				JOptionPane.showMessageDialog(null, "Data Missing");
    			else
    			{
    				if (generoCombo.getSelectedItem().equals("Select")) 
    						JOptionPane.showMessageDialog(null, "Selecciona el género de la película");
	    			else
	    			{
		    			//JOptionPane.showMessageDialog(null, "Data Submitted");
		    			Pelicula pelicula = new Pelicula();
		    			pelicula.setTitulo(tituloText.getText());
		    			pelicula.setDirector(directorText.getText());
	
	    				if (checkErrorAnioProduccionText(anioProduccionText.getText())) {
	    					JOptionPane.showMessageDialog(null,"Please enter the year with 4 numbers");
	    					anioProduccionText.requestFocusInWindow();
	    					return;
	    				}
	    				pelicula.setAnioPublicacion(Integer.parseInt(anioProduccionText.getText()));
				
		    			pelicula.setGenero(generoCombo.getSelectedItem().toString());
		    			try {
							int resultado = gp.altaPelicula(pelicula);
							if (resultado != Constantes.EXECUTED_WITHOUT_ERRORS) {
								textArea.setText(Constantes.getNameFromValue(resultado));
								textArea.setForeground(Color.RED);
							} else {
								ArrayList<Pelicula> listaPeliculas = (ArrayList) gp.buscarPeliculaPorTitulo(pelicula.getTitulo());
								for (Pelicula elementoPelicula : listaPeliculas) {
									Object[] row = {elementoPelicula.getId(), elementoPelicula.getTitulo(), elementoPelicula.getDirector(), elementoPelicula.getAnioPublicacion()};
									dtm.addRow(row);
								}
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							JOptionPane.showMessageDialog(null, e.getMessage());
							//textArea.setText( e.getMessage());
							//textArea.setForeground(Color.RED);
						}
	    			}
    			}
    		}

			private boolean checkErrorAnioProduccionText(String text) {
				
    			try {
    				Integer.parseInt(text);
    			} catch ( NumberFormatException ex) {
    				return true;
    			} catch ( Exception ex2) {
    				return true;
    			}
    			
    			int value = Integer.parseInt(text);
    			
    			if ((value < 1895) || (text.length() != 4)) {
    				return true;
    			}
				
				return false;
			}
    	});
    	
    	clear.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			tituloText.setText(null);
    			directorText.setText(null);
    			anioProduccionText.setText(null);
    			generoCombo.setSelectedItem("Select");
    	        textArea.setText("Área de mensajes de control ");
    			textArea.setForeground(Color.BLACK); 
    			limpiarTabla(peliculas);
    		}
    		
        	private void limpiarTabla(JTable tabla) {
                try {
                    DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
                    int filas=tabla.getRowCount();
                    for (int i = 0;filas>i; i++) {
                        	modelo.removeRow(0);
                    	}
        	        } catch (Exception e) {
        	            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        	        }
            	}
    		
    	});

    	return tabPane;
        
    }
 
    private void addLabelTextRows(JLabel[] labels,
                                  Component[] componentFields,
                                  Container container) {
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.EAST;
        int numLabels = labels.length;
 
        for (int i = 0; i < numLabels; i++) {
            c.gridwidth = GridBagConstraints.RELATIVE; //next-to-last
            c.fill = GridBagConstraints.NONE;      //reset to default
            c.weightx = 0.0;                       //reset to default
            c.anchor = GridBagConstraints.EAST;
            container.add(labels[i], c);
 
            c.gridwidth = GridBagConstraints.REMAINDER;     //end row
            c.fill = GridBagConstraints.NONE;
            c.anchor = GridBagConstraints.WEST;
            c.weightx = 1.0;
            container.add(componentFields[i], c);
        }
    }
 
    public JComponent makeTextPanel2(String texto) {
    	JPanel tabPane =  new JPanel();
    	tabPane.setLayout(new BorderLayout());
    	    	 
        // Global gridbag layout
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
    	
    	String buscarTitulo = "Por Título";
    	String buscarDirector = "Por Director";
    	String buscarAnio = "Por Año";
    	String buscarGenero = "Por Género";
    	  	
    	//Create the radio buttons.
        JRadioButton tituloButton = new JRadioButton(buscarTitulo);
        tituloButton.setMnemonic(KeyEvent.VK_T);
        tituloButton.setActionCommand(buscarTitulo);
        tituloButton.setSelected(true);
        tituloSelected = true;

        JRadioButton directorButton = new JRadioButton(buscarDirector);
        directorButton.setMnemonic(KeyEvent.VK_D);
        directorButton.setActionCommand(buscarDirector);

        JRadioButton anioButton = new JRadioButton(buscarAnio);
        anioButton.setMnemonic(KeyEvent.VK_A);
        anioButton.setActionCommand(buscarAnio);

        JRadioButton generoButton = new JRadioButton(buscarGenero);
        generoButton.setMnemonic(KeyEvent.VK_G);
        generoButton.setActionCommand(buscarGenero);


        //Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(tituloButton);
        group.add(directorButton);
        group.add(anioButton);
        group.add(generoButton);

        //Register a listener for the radio buttons.
        tituloButton.addActionListener(this);
        directorButton.addActionListener(this);
        anioButton.addActionListener(this);
        generoButton.addActionListener(this);
        
        JTextField claveBusquedaText = new JTextField(10);
        JLabel claveBusqueda = new JLabel("Clave de Búsqueda : ");
               
        //Put the radio buttons in a column in a panel.
        JPanel radioPanel = new JPanel(new GridLayout(2, 2));
        radioPanel.add(tituloButton);
        radioPanel.add(directorButton);
        radioPanel.add(anioButton);
        radioPanel.add(generoButton);
 
        //add(radioPanel, BorderLayout.LINE_START);
        //setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        
        JPanel northControlsPane = new JPanel(new GridLayout(2, 1));

        //Lay out the text controls and the labels.
        JPanel searchControlsPane = new JPanel();
        searchControlsPane.setLayout(gridbag);
        
        c.gridwidth = GridBagConstraints.RELATIVE; //next-to-last
        c.fill = GridBagConstraints.NONE;      //reset to default
        c.weightx = 0.0;                       //reset to default
        c.anchor = GridBagConstraints.EAST;
        searchControlsPane.add(claveBusqueda, c);

        c.gridwidth = GridBagConstraints.REMAINDER;     //end row
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.WEST;
        c.weightx = 1.0;
        searchControlsPane.add(claveBusquedaText, c);
        
        northControlsPane.add(radioPanel);
        northControlsPane.add(searchControlsPane);      
        northControlsPane.setBorder(
                BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Search Fields"),
                                BorderFactory.createEmptyBorder(5,5,5,5)));
        
        //Lay out the text controls and the labels.
        JPanel buttonControlsPane = new JPanel();
        buttonControlsPane.setLayout(gridbag);
        
        // Create Button
        JButton submit = new JButton ("SUBMIT");
        c.gridwidth = GridBagConstraints.RELATIVE; //next-to-last
        c.fill = GridBagConstraints.NONE;     //reset to default
        c.weightx = 1.0;                       //reset to default
        c.anchor = GridBagConstraints.CENTER;
        buttonControlsPane.add(submit, c);

        JButton clear = new JButton ("CLEAR");
        c.gridwidth = GridBagConstraints.REMAINDER;     //end row
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 1.0;
        buttonControlsPane.add(clear, c);
        
        //Create a text area.
        JTextArea textArea = new JTextArea(
                "Área de mensajes de control "
        );
        textArea.setFont(new Font("Serif", Font.ITALIC, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        JScrollPane areaScrollPane = new JScrollPane(textArea);
        areaScrollPane.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        areaScrollPane.setPreferredSize(new Dimension(250, 100));
        areaScrollPane.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Plain Text"),
                                BorderFactory.createEmptyBorder(5,5,5,5)),
                areaScrollPane.getBorder()));
        
        c.gridwidth = GridBagConstraints.REMAINDER; //last
        c.anchor = GridBagConstraints.WEST;
        c.weightx = 1.0;
        buttonControlsPane.add(areaScrollPane, c);
        buttonControlsPane.setBorder(
                BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Control Fields"),
                                BorderFactory.createEmptyBorder(5,5,5,5)));
        
        // Create a table

      	String[] columnNames = {"INDICE", "TITULO", "DIRECTOR", "AÑO DE PRODUCCION"};
      	Object[][] data = { {"", "", "", ""}};     	
      	//JTable peliculas = new JTable(data,columnNames);
      	DefaultTableModel dtm=new DefaultTableModel(columnNames,0);
      	JTable peliculas = new JTable(dtm);
      	setJTableColumnsWidth(peliculas, 250, 10, 50, 30, 10);
      	//JScrollPane scrollPane = new JScrollPane(leste);
      	peliculas.setFillsViewportHeight(true);
      	peliculas.setEnabled(false);
      	JScrollPane editorPeliculas = new JScrollPane(peliculas);

      	JPanel surPane = new JPanel();
      	surPane.setLayout(new BorderLayout());
      	surPane.add(editorPeliculas);  
      	surPane.setPreferredSize(new Dimension(250, 145));
      	surPane.setMinimumSize(new Dimension(10, 10));
      	surPane.setBorder(                
      			BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Films Table"),
                                BorderFactory.createEmptyBorder(5,5,5,5)));
              
 
        //Put everything together.
        JPanel leftPane = new JPanel(new BorderLayout());
        /*
        leftPane.add(textControlsPane, 
                     BorderLayout.LINE_START);
                     */
        leftPane.add(northControlsPane,
        			 BorderLayout.LINE_START);
        leftPane.add(buttonControlsPane,
                     BorderLayout.LINE_END);
 
        tabPane.add(leftPane, BorderLayout.PAGE_START);
        tabPane.add(surPane, BorderLayout.CENTER);
       

		JComboBox<String> generoCombo = new JComboBox<String>();
  		generoCombo.addItem("All");
  		generoCombo.addItem("Action");
  		generoCombo.addItem("Adventure");
  		generoCombo.addItem("Animation");
  		generoCombo.addItem("Anime");
  		generoCombo.addItem("Classic");
  		generoCombo.addItem("Comedy");
        ActionListener radioActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
              AbstractButton aButton = (AbstractButton) actionEvent.getSource();
              //System.out.println("Selected: " + aButton.getText());
              
            claveBusquedaText.setText("");
  	        textArea.setText("Área de mensajes de control ");
  			textArea.setForeground(Color.BLACK); 
  			limpiarTabla(peliculas);
              
              if (aButton.getText().contentEquals(buscarGenero)) {
            	    useCombo = true;
            	    searchControlsPane.removeAll();
                    c.gridwidth = GridBagConstraints.RELATIVE; //next-to-last
                    c.fill = GridBagConstraints.NONE;      //reset to default
                    c.weightx = 0.0;                       //reset to default
                    c.anchor = GridBagConstraints.EAST;
                    searchControlsPane.add(claveBusqueda, c);

                    c.gridwidth = GridBagConstraints.REMAINDER;     //end row
                    c.fill = GridBagConstraints.NONE;
                    c.anchor = GridBagConstraints.WEST;
                    c.weightx = 1.0;
                    searchControlsPane.add(generoCombo, c);
                    repaint();                    
              } else {
            	  useCombo = false;
            	  searchControlsPane.removeAll();
                  c.gridwidth = GridBagConstraints.RELATIVE; //next-to-last
                  c.fill = GridBagConstraints.NONE;      //reset to default
                  c.weightx = 0.0;                       //reset to default
                  c.anchor = GridBagConstraints.EAST;
                  searchControlsPane.add(claveBusqueda, c);

                  c.gridwidth = GridBagConstraints.REMAINDER;     //end row
                  c.fill = GridBagConstraints.NONE;
                  c.anchor = GridBagConstraints.WEST;
                  c.weightx = 1.0;
                  searchControlsPane.add(claveBusquedaText, c);                
                  repaint();
              }
              
              tituloSelected = false;
              directorSelected = false;
              anioSelected = false;
              generoSelected = false;
              
              if (aButton.getText().contentEquals(buscarTitulo))
              {
            	  tituloSelected = true;
              }
              else { 
            	  if (aButton.getText().contentEquals(buscarDirector)) 
	              {
	            	  directorSelected = true;
	              } else {
	            	  if (aButton.getText().contentEquals(buscarAnio)) 
		              {
		            	  anioSelected = true;
		              } else {
		            	  if (aButton.getText().contentEquals(buscarGenero)) 
		            	  {
		            		  generoSelected = true;
		            	  }
		              }
	              }
              }
              
            }
          };
		tituloButton.addActionListener(radioActionListener);
		directorButton.addActionListener(radioActionListener); 
		anioButton.addActionListener(radioActionListener);
		generoButton.addActionListener(radioActionListener);
                       
    	submit.addActionListener(new ActionListener() {    	
    		public void actionPerformed(ActionEvent arg0) {
    		
    	        textArea.setText("Área de mensajes de control ");
    			textArea.setForeground(Color.BLACK); 
    			limpiarTabla(peliculas);
    			
    			if (useCombo) claveBusquedaText.setText(generoCombo.getSelectedItem().toString());
    			if(claveBusquedaText.getText().isEmpty())
    			{
    				JOptionPane.showMessageDialog(null, "Data Missing");
    				return;
    			}
    			else
    			{
    				if (anioSelected) 
	    				if (checkErrorAnioProduccionText(claveBusquedaText.getText())) {
	    					JOptionPane.showMessageDialog(null,"Please enter the year with 4 numbers");
	    					claveBusquedaText.requestFocusInWindow();
	    					return;
	    				}
    			}
	    				
    			//JOptionPane.showMessageDialog(null, "Data Submitted");
    			Pelicula pelicula = new Pelicula();
    			
    			String campo = "";
    			if (generoSelected) {
    				campo = Constantes.GENERO;
    				if ("All".contentEquals(claveBusquedaText.getText())) {
    					claveBusquedaText.setText("");
    				}
    			}
    			if (directorSelected) campo = Constantes.DIRECTOR;
    			if (anioSelected) campo = Constantes.ANIOPROD;
    			if (tituloSelected) campo = Constantes.TITULO;
		
    			ArrayList<Pelicula> listaPeliculas = (ArrayList) gp.buscarPeliculaPorClave(claveBusquedaText.getText(), campo);
				
				if (listaPeliculas.size() == 0) {
					textArea.setText("No se ha encontrado ninguna película");
					textArea.setForeground(Color.RED);
				} else {					
					for (Pelicula elementoPelicula : listaPeliculas) {
						Object[] row = {elementoPelicula.getId(), elementoPelicula.getTitulo(), elementoPelicula.getDirector(), elementoPelicula.getAnioPublicacion()};
						dtm.addRow(row);
					}
				}  		
    		}
    		

			private boolean checkErrorAnioProduccionText(String text) {
				
    			try {
    				Integer.parseInt(text);
    			} catch ( NumberFormatException ex) {
    				return true;
    			} catch ( Exception ex2) {
    				return true;
    			}
    			
    			int value = Integer.parseInt(text);
    			
    			if ((value < 1895) || (text.length() != 4)) {
    				return true;
    			}
				
				return false;
			}
			
    	});
    	
    	clear.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			
          	    useCombo = false;
          	    searchControlsPane.removeAll();
                c.gridwidth = GridBagConstraints.RELATIVE; //next-to-last
                c.fill = GridBagConstraints.NONE;      //reset to default
                c.weightx = 0.0;                       //reset to default
                c.anchor = GridBagConstraints.EAST;
                searchControlsPane.add(claveBusqueda, c);

                c.gridwidth = GridBagConstraints.REMAINDER;     //end row
                c.fill = GridBagConstraints.NONE;
                c.anchor = GridBagConstraints.WEST;
                c.weightx = 1.0;
                searchControlsPane.add(claveBusquedaText, c);    
                tituloButton.setSelected(true);
                tituloSelected = true;
                repaint();
    			
    			claveBusquedaText.setText(null);

    	        textArea.setText("Área de mensajes de control ");
    			textArea.setForeground(Color.BLACK); 
    			limpiarTabla(peliculas);
    			
    		}
    		

    		
    	});
    	
    	return tabPane;
        
    }

    
    public JComponent makeTextPanel3(String texto) {
    	JPanel tabPane =  new JPanel();
    	tabPane.setLayout(new BorderLayout());
    	    	 
        // Global gridbag layout
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
    	
    	String buscarTitulo = "Por Título";
    	String buscarDirector = "Por Director";
    	String buscarAnio = "Por Año";
    	String buscarGenero = "Por Género";
    	String buscarIdentidad = "Por Identidad";
    	  	
    	//Create the radio buttons.
        JRadioButton tituloButton = new JRadioButton(buscarTitulo);
        tituloButton.setMnemonic(KeyEvent.VK_T);
        tituloButton.setActionCommand(buscarTitulo);
        tituloButton.setSelected(true);
        tituloSelected = true;

        JRadioButton directorButton = new JRadioButton(buscarDirector);
        directorButton.setMnemonic(KeyEvent.VK_D);
        directorButton.setActionCommand(buscarDirector);

        JRadioButton anioButton = new JRadioButton(buscarAnio);
        anioButton.setMnemonic(KeyEvent.VK_A);
        anioButton.setActionCommand(buscarAnio);

        JRadioButton generoButton = new JRadioButton(buscarGenero);
        generoButton.setMnemonic(KeyEvent.VK_G);
        generoButton.setActionCommand(buscarGenero);

        JRadioButton idButton = new JRadioButton(buscarIdentidad);
        generoButton.setMnemonic(KeyEvent.VK_I);
        generoButton.setActionCommand(buscarIdentidad);

        //Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(tituloButton);
        group.add(directorButton);
        group.add(anioButton);
        group.add(generoButton);
        group.add(idButton);

        //Register a listener for the radio buttons.
        tituloButton.addActionListener(this);
        directorButton.addActionListener(this);
        anioButton.addActionListener(this);
        generoButton.addActionListener(this);
        idButton.addActionListener(this);
        
        JTextField claveBusquedaText = new JTextField(10);
        JLabel claveBusqueda = new JLabel("Clave de Búsqueda : ");
               
        //Put the radio buttons in a column in a panel.
        JPanel radioPanel = new JPanel(new GridLayout(3, 2));
        radioPanel.add(tituloButton);
        radioPanel.add(directorButton);
        radioPanel.add(anioButton);
        radioPanel.add(generoButton);
        radioPanel.add(idButton);
 
        JPanel northControlsPane = new JPanel(new BorderLayout());

        //Lay out the text controls and the labels.
        JPanel searchControlsPane = new JPanel();
        searchControlsPane.setLayout(gridbag);
        
        c.gridwidth = GridBagConstraints.RELATIVE; //next-to-last
        c.fill = GridBagConstraints.NONE;      //reset to default
        c.weightx = 0.0;                       //reset to default
        c.anchor = GridBagConstraints.EAST;
        searchControlsPane.add(claveBusqueda, c);

        c.gridwidth = GridBagConstraints.REMAINDER;     //end row
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.WEST;
        c.weightx = 1.0;

        searchControlsPane.add(claveBusquedaText, c);
        
        JButton buscar = new JButton("BÚSQUEDA");

        northControlsPane.add(radioPanel, BorderLayout.PAGE_START);
        northControlsPane.add(searchControlsPane, BorderLayout.CENTER);
        northControlsPane.add(buscar, BorderLayout.PAGE_END);
        
        northControlsPane.setBorder(
                BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Search Fields"),
                                BorderFactory.createEmptyBorder(5,5,5,5)));
        
        //Lay out the text controls and the labels.
        JPanel buttonControlsPane = new JPanel();
        buttonControlsPane.setLayout(gridbag);
        
        // Create Button
        JButton submit = new JButton ("SUBMIT");
        c.gridwidth = GridBagConstraints.RELATIVE; //next-to-last
        c.fill = GridBagConstraints.NONE;     //reset to default
        c.weightx = 1.0;                       //reset to default
        c.anchor = GridBagConstraints.CENTER;
        buttonControlsPane.add(submit, c);

        JButton clear = new JButton ("CLEAR");
        c.gridwidth = GridBagConstraints.REMAINDER;     //end row
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 1.0;
        buttonControlsPane.add(clear, c);
        
        //Create a text area.
        JTextArea textArea = new JTextArea(
                "Área de mensajes de control "
        );
        textArea.setFont(new Font("Serif", Font.ITALIC, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        JScrollPane areaScrollPane = new JScrollPane(textArea);
        areaScrollPane.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        areaScrollPane.setPreferredSize(new Dimension(250, 100));
        areaScrollPane.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Plain Text"),
                                BorderFactory.createEmptyBorder(5,5,5,5)),
                areaScrollPane.getBorder()));
        
        c.gridwidth = GridBagConstraints.REMAINDER; //last
        c.anchor = GridBagConstraints.WEST;
        c.weightx = 1.0;
        buttonControlsPane.add(areaScrollPane, c);
        buttonControlsPane.setBorder(
                BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Control Fields"),
                                BorderFactory.createEmptyBorder(5,5,5,5)));
        
        // Create a table

      	String[] columnNames = {"INDICE", "TITULO", "DIRECTOR", "AÑO DE PRODUCCION"};
      	Object[][] data = { {"", "", "", ""}};     	
      	//JTable peliculas = new JTable(data,columnNames);
      	DefaultTableModel dtm=new DefaultTableModel(columnNames,0);
      	peliculas = new JTable(dtm);
      	setJTableColumnsWidth(peliculas, 250, 10, 50, 30, 10);
      	//JScrollPane scrollPane = new JScrollPane(leste);
      	peliculas.setFillsViewportHeight(true);
      	//peliculas.setEnabled(false);
      	peliculas.addMouseListener(new MouseAdapter () {
    	    @Override
    	    public void mousePressed(MouseEvent event) {
    	        // selects the row at which point the mouse is clicked
    	        Point point = event.getPoint();
    	        int currentRow = peliculas.rowAtPoint(point);
    	        peliculas.setRowSelectionInterval(currentRow, currentRow);
    	        //System.out.println("selected row " + peliculas.getSelectedRow());
    	    }
      	});
      	JScrollPane editorPeliculas = new JScrollPane(peliculas);

      	JPanel surPane = new JPanel();
      	surPane.setLayout(new BorderLayout());
      	surPane.add(editorPeliculas);  
      	surPane.setPreferredSize(new Dimension(250, 145));
      	surPane.setMinimumSize(new Dimension(10, 10));
      	surPane.setBorder(                
      			BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Films Table"),
                                BorderFactory.createEmptyBorder(5,5,5,5)));
              
 
        //Put everything together.
        JPanel leftPane = new JPanel(new BorderLayout());
        leftPane.add(northControlsPane,
        			 BorderLayout.LINE_START);
        leftPane.add(buttonControlsPane,
                     BorderLayout.LINE_END);
 
        tabPane.add(leftPane, BorderLayout.PAGE_START);
        tabPane.add(surPane, BorderLayout.CENTER);
       

		JComboBox<String> generoCombo = new JComboBox<String>();
  		generoCombo.addItem("All");
  		generoCombo.addItem("Action");
  		generoCombo.addItem("Adventure");
  		generoCombo.addItem("Animation");
  		generoCombo.addItem("Anime");
  		generoCombo.addItem("Classic");
  		generoCombo.addItem("Comedy");
        ActionListener radioActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
              AbstractButton aButton = (AbstractButton) actionEvent.getSource();
              
            claveBusquedaText.setText("");
  	        textArea.setText("Área de mensajes de control ");
  			textArea.setForeground(Color.BLACK); 
  			limpiarTabla(peliculas);
              
              if (aButton.getText().contentEquals(buscarGenero)) {
            	    useCombo = true;
            	    searchControlsPane.removeAll();
                    c.gridwidth = GridBagConstraints.RELATIVE; //next-to-last
                    c.fill = GridBagConstraints.NONE;      //reset to default
                    c.weightx = 0.0;                       //reset to default
                    c.anchor = GridBagConstraints.EAST;
                    searchControlsPane.add(claveBusqueda, c);

                    c.gridwidth = GridBagConstraints.REMAINDER;     //end row
                    c.fill = GridBagConstraints.NONE;
                    c.anchor = GridBagConstraints.WEST;
                    c.weightx = 1.0;
                    searchControlsPane.add(generoCombo, c);
                    repaint();                    
              } else {
            	  useCombo = false;
            	  searchControlsPane.removeAll();
                  c.gridwidth = GridBagConstraints.RELATIVE; //next-to-last
                  c.fill = GridBagConstraints.NONE;      //reset to default
                  c.weightx = 0.0;                       //reset to default
                  c.anchor = GridBagConstraints.EAST;
                  searchControlsPane.add(claveBusqueda, c);

                  c.gridwidth = GridBagConstraints.REMAINDER;     //end row
                  c.fill = GridBagConstraints.NONE;
                  c.anchor = GridBagConstraints.WEST;
                  c.weightx = 1.0;
                  searchControlsPane.add(claveBusquedaText, c);                
                  repaint();
              }
              
              tituloSelected = false;
              directorSelected = false;
              anioSelected = false;
              generoSelected = false;
              
              if (aButton.getText().contentEquals(buscarTitulo))
              {
            	  tituloSelected = true;
              }
              else { 
            	  if (aButton.getText().contentEquals(buscarDirector)) 
	              {
	            	  directorSelected = true;
	              } else {
	            	  if (aButton.getText().contentEquals(buscarAnio)) 
		              {
		            	  anioSelected = true;
		              } else {
		            	  if (aButton.getText().contentEquals(buscarGenero)) 
		            	  {
		            		  generoSelected = true;
		            	  }
		              }
	              }
              }
              
            }
          };
		tituloButton.addActionListener(radioActionListener);
		directorButton.addActionListener(radioActionListener); 
		anioButton.addActionListener(radioActionListener);
		generoButton.addActionListener(radioActionListener);
                       
    	buscar.addActionListener(new ActionListener() {    	
    		public void actionPerformed(ActionEvent arg0) {
    		
    	        textArea.setText("Área de mensajes de control ");
    			textArea.setForeground(Color.BLACK); 
    			limpiarTabla(peliculas);    			    			
    			
    			if (useCombo) claveBusquedaText.setText(generoCombo.getSelectedItem().toString());
    			if(claveBusquedaText.getText().isEmpty())
    			{
    				JOptionPane.showMessageDialog(null, "Data Missing");
    				return;
    			}
    			else
    			{
    				if (anioSelected) 
	    				if (checkErrorAnioProduccionText(claveBusquedaText.getText())) {
	    					JOptionPane.showMessageDialog(null,"Please enter the year with 4 numbers");
	    					claveBusquedaText.requestFocusInWindow();
	    					return;
	    				}
    			}
	    				
    			//JOptionPane.showMessageDialog(null, "Data Submitted");
    			Pelicula pelicula = new Pelicula();
    			
    			String campo = "";
    			if (generoSelected) {
    				campo = Constantes.GENERO;
    				if ("All".contentEquals(claveBusquedaText.getText())) {
    					claveBusquedaText.setText("");
    				}
    			}
    			if (directorSelected) campo = Constantes.DIRECTOR;
    			if (anioSelected) campo = Constantes.ANIOPROD;
    			if (tituloSelected) campo = Constantes.TITULO;
		
    			ArrayList<Pelicula> listaPeliculas = (ArrayList) gp.buscarPeliculaPorClave(claveBusquedaText.getText(), campo);
				
				if (listaPeliculas.size() == 0) {
					textArea.setText("No se ha encontrado ninguna película");
					textArea.setForeground(Color.RED);
				} else {	
					for (Pelicula elementoPelicula : listaPeliculas) {
						Object[] row = {elementoPelicula.getId(), elementoPelicula.getTitulo(), elementoPelicula.getDirector(), elementoPelicula.getAnioPublicacion()};
						dtm.addRow(row);
					}
				}  		
    		}
    		

			private boolean checkErrorAnioProduccionText(String text) {
				
    			try {
    				Integer.parseInt(text);
    			} catch ( NumberFormatException ex) {
    				return true;
    			} catch ( Exception ex2) {
    				return true;
    			}
    			
    			int value = Integer.parseInt(text);
    			
    			if ((value < 1895) || (text.length() != 4)) {
    				return true;
    			}
				
				return false;
			}
			
    	});
    	
    	clear.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			
          	    useCombo = false;
          	    searchControlsPane.removeAll();
                c.gridwidth = GridBagConstraints.RELATIVE; //next-to-last
                c.fill = GridBagConstraints.NONE;      //reset to default
                c.weightx = 0.0;                       //reset to default
                c.anchor = GridBagConstraints.EAST;
                searchControlsPane.add(claveBusqueda, c);

                c.gridwidth = GridBagConstraints.REMAINDER;     //end row
                c.fill = GridBagConstraints.NONE;
                c.anchor = GridBagConstraints.WEST;
                c.weightx = 1.0;
                searchControlsPane.add(claveBusquedaText, c);    
                tituloButton.setSelected(true);
                tituloSelected = true;
                repaint();
    			
    			claveBusquedaText.setText(null);

    	        textArea.setText("Área de mensajes de control ");
    			textArea.setForeground(Color.BLACK); 
    			limpiarTabla(peliculas);
    			
    		}
    		

    		
    	});
    	
    	return tabPane;
        
    }
    
	private void limpiarTabla(JTable tabla) {
        try {            
            tabla.clearSelection();
            DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
            int filas=tabla.getRowCount();
            for (int i = 0;filas>i; i++) {
                	modelo.removeRow(0);
            	}
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
	        }
    	}
   
    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = vistaSwingPeliculas.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    
    
    public static void setJTableColumnsWidth(JTable table, int tablePreferredWidth,
            double... percentages) {
        double total = 0;
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            total += percentages[i];
        }
     
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth((int)
                    (tablePreferredWidth * (percentages[i] / total)));
        }
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {

		DaoPelicula daoPelicula = new DaoPelicula();
		gp = new GestorPeliculas();
		gp.setDaoPelicula(daoPelicula);
    	
        //Create and set up the window.
        JFrame frame = new JFrame("GESTOR DE PELICULAS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add content to the window.
        frame.add(new vistaSwingPeliculas());
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                 //Turn off metal's use of bold fonts
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        createAndShowGUI();
            }
        });
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
