package Interfaz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz extends JFrame {

    private JPanel PanelPrincipal;
    private JTextField textNumIden;
    private JTextField textPeso;
    private JTextArea textAreaDescCont;
    private JTextField EmpRem;
    private JTextField EmpRecep;
    private JTabbedPane tabbedPane1;
    private JButton apilarButton;
    private JButton desabilitarButton;
    private JTextField textDesapilar;
    private JButton mostrarDatosContenedorButton;
    private JTextField textMostDatCont;
    private JButton cuántosButton;
    private JComboBox comboPais1;
    private JTextField textCuantos;
    private JComboBox comboPais;
    private JRadioButton Boton1;
    private JRadioButton Boton2;
    private JRadioButton Boton3;
    private JCheckBox insAdCheckBox;
    private JTextArea textAreaEstado;

    private Hub hub;
    private Contenedor contenedor;

    public Interfaz() {

        // Las 4 sentencias de siempre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//cierra la aplicacion y sale de memoria
        this.setTitle("Formulario Contenedor Hub");
        this.setSize(800, 400);
        this.setVisible(true);
        // Añadimos nuestro panel principal
        this.add(PanelPrincipal);

        // Añadimos opciones al combo País Procedencia
        this.comboPais.addItem("España");
        this.comboPais.addItem("Portugal");
        this.comboPais.addItem("Francia");
        this.comboPais.addItem("Italia");
        // Añadimos opciones al combo Destino
        this.comboPais1.addItem("España");
        this.comboPais1.addItem("Portugal");
        this.comboPais1.addItem("Francia");
        this.comboPais1.addItem("Italia");

        this.hub = new Hub();
        this.textAreaEstado.setText(this.hub.toString());

        Boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Boton1.isSelected()){
                    Boton2.setSelected(false);
                    Boton3.setSelected(false);
                }
            }
        });
        Boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Boton2.isSelected()){
                    Boton1.setSelected(false);
                    Boton3.setSelected(false);
                }
            }
        });
        Boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Boton3.isSelected()){
                    Boton1.setSelected(false);
                    Boton2.setSelected(false);
                }
            }
        });
        apilarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null, "Apilado");

                int textNumIden = Integer.parseInt(Interfaz.this.textNumIden.getText());
                int textPeso = Integer.parseInt(Interfaz.this.textPeso.getText());
                String textAreaDescCont = Interfaz.this.textAreaDescCont.getText();
                String EmpRem = Interfaz.this.EmpRem.getText();
                String EmpRecep = Interfaz.this.EmpRecep.getText();

                if(textNumIden != 0){
                    contenedor = new Contenedor(textNumIden);
                    contenedor.apilar(contenedor);
                    Interfaz.this.textAreaEstado.setText(Interfaz.this.contenedor.toString());
                }
            }
        });
        desabilitarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Desapilado");
                if(desabilitarButton.getText() != null){
                    contenedor.desapilar(Integer.parseInt(Interfaz.this.textNumIden.getText()));
                }
            }
        });
        insAdCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (insAdCheckBox.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Contenedor inspeccionado en aduanas", "", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        Interfaz intzf = new Interfaz();
    }

}
