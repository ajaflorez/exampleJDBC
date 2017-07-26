package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import model.ConexionMysql;
import model.Medico;
import model.MedicoDAO;

public class PanelNewCenter extends JPanel implements ActionListener,ItemListener{
    // Action Listener se utiliza para Botones y menus
    
    Border border;
    JButton botonOne, botonTwo, botonThree, botonFour;
    JCheckBox estado;
    JRadioButton radioOne, radioTwo, radioThree;
    ButtonGroup grupoRadio;
    JTextField textOne;
    
    // Mysql
    ConexionMysql conMysql;
    JTextField textSearch;
    JButton botonSearch;
    JTextField TextResult;
    // DAO
    Medico medico = null;
    MedicoDAO medicoDao;
    //----------------------
    
    
    public PanelNewCenter() throws Exception {        
        //--------------------------
        // DAO
        // Instanciando el objeto MedicoDAO
        medicoDao = new MedicoDAO();    // Agregar el throws Exception
        //---------------------
                
        
        setLayout(new FlowLayout());        
        
        // COlocando Border al Panel
        border = BorderFactory.createEtchedBorder();
        this.setBorder(border);
        
        // Instanciar objetos
        botonOne = new JButton("Click One");
        botonTwo = new JButton("Click Two");
        botonThree = new JButton("Click Three");
        botonFour = new JButton("Click Four");
        
        estado = new JCheckBox("Desactivado");
        
        radioOne = new JRadioButton("One");
        radioTwo = new JRadioButton("Two");
        radioThree = new JRadioButton("Three");
        
        grupoRadio = new ButtonGroup();
        grupoRadio.add(radioOne);
        grupoRadio.add(radioTwo);
        grupoRadio.add(radioThree);
        
        textOne = new JTextField("Zero", 15);
        
        //-------- Mysql
        textSearch = new JTextField(5);
        botonSearch = new JButton("Buscar");
        TextResult = new JTextField(30);
        //------------------------------        
                
        // Agregando el Action LIstener
        botonOne.addActionListener(this);
        botonTwo.addActionListener(this);
        botonThree.addActionListener(this);
        botonFour.addActionListener(this);
        
        estado.addItemListener(this);
        
        radioOne.addItemListener(this);
        radioTwo.addItemListener(this);
        radioThree.addItemListener(this);
        
        //---- Mysql
        botonSearch.addActionListener(this);
        //--------------------
        
        /*estado.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (estado.isSelected())
                    estado.setText("Activado");
                else
                    estado.setText("Desactivado");
            }
        });*/
        
        // Agregando Botones al panel actual
        this.add(botonOne);
        this.add(botonTwo);
        this.add(botonThree);
        this.add(botonFour);
        
        this.add(estado);
        
        this.add(radioOne);
        this.add(radioTwo);
        this.add(radioThree);
        
        this.add(textOne);
        
        //---------Mysql --
        this.add(textSearch);
        this.add(botonSearch);
        this.add(TextResult);
        //--------------------------
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botonThree) {
            JOptionPane.showMessageDialog(null, "Hizo Click en el boton Three");
        }
        if(e.getSource() == botonTwo) {
            onClickBotonTwo(e);
        }
        //--------------Mysql
        if(e.getSource() == botonSearch) {
            // Colocar el onClickBotonSearch(e); dentro de un try
            try {
                onClickBotonSearch(e);  // Metodo que realiza la busqueda y muestra el resultado
            } catch (Exception ex) {
                Logger.getLogger(PanelNewCenter.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == estado) {
            onCheckEstado(e);
        }
        if(e.getSource() == radioOne || e.getSource() == radioTwo || e.getSource() == radioThree) {
            onClickRadio(e);
        }
            
            
    }
    // Metodos que se ejecutan cuando el listener tiene un llamado
    private void onClickBotonTwo(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Hizo CLick en boton Two");
    }
    private void onCheckEstado(ItemEvent e) {
        if(estado.isSelected())
            estado.setText("Activo");
        else
            estado.setText("Desactivo");
    }

    private void onClickRadio(ItemEvent e) {
        JRadioButton radioTmp = (JRadioButton)e.getSource();
        textOne.setText(radioTmp.getText());
    }

    private void onClickBotonSearch(ActionEvent e) throws Exception {
        String idS = textSearch.getText();                
        medico = medicoDao.getMedicoPaterno(idS);    // Obtiene el medico buscado        
        if(medico != null)
            TextResult.setText(medico.toString());
        else
            JOptionPane.showMessageDialog(null, "No hay nadie");
                
    }
    
    
}


