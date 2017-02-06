package Ventanas;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaPrincipal extends JFrame implements ActionListener {
	 
private Container contenedor;
JButton cmed,pm,pmv,cm,cmx;
JLabel labelTitulo;
private VentanaPrincipal miVentanaPrincipal;

public VentanaPrincipal(){
  iniciarComponentes();
  setTitle("Simulacion y modelo");
  setSize(1070,400);
  setLocationRelativeTo(null);
  setVisible(true);
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
}
 
public void setVentanaPrincipal(VentanaPrincipal miVentana) {
   miVentanaPrincipal=miVentana;
}
private void iniciarComponentes() {
  contenedor=getContentPane();
  contenedor.setLayout(null);

  contenedor.setBackground(Color.white);
  cmed= new JButton();
  cmed.setText("Medio Cuadrado");
  cmed.setBounds(10, 80, 150, 50);
  cmed.addActionListener(this);
  
  pm= new JButton();
  pm.setText("Producto Medio");
  pm.setBounds(170, 80, 200, 50);
  pm.addActionListener(this);
 
  pmv= new JButton();
  pmv.setText("Producto Medio con Variacion");
  pmv.setBounds(380, 80, 210, 50);
  pmv.addActionListener(this);
  
  cm= new JButton();
  cm.setText("Concruencial multiplicativo");
  cm.setBounds(600, 80, 200, 50);
  cm.addActionListener(this);
  
  cmx= new JButton();
  cmx.setText("Concruencial mixto");
  cmx.setBounds(810, 80, 200, 50);
  cmx.addActionListener(this);
  
  
  labelTitulo= new JLabel();
  labelTitulo.setText("Elige un metodo para realizar los calculos.");
  labelTitulo.setBounds(80, 20, 600, 23);
  contenedor.add(labelTitulo);
  contenedor.add(cmed);
  contenedor.add(pm);
  contenedor.add(pmv);
  contenedor.add(cm);
  contenedor.add(cmx);
 }
  public void actionPerformed(ActionEvent evento) {
      if (evento.getSource()==cm){
    	  new NuevaVentana(4);
    	  this.dispose();
      }else if(evento.getSource()==cmx){
    	  new NuevaVentana(5);
    	  this.dispose();
      }else if(evento.getSource()==cmed){
    	  new NuevaVentana(1);
    	  this.dispose();
      }else if(evento.getSource()==pm){
    	  new NuevaVentana(2);
    	  this.dispose();
      }else if(evento.getSource()==pmv){
    	  new NuevaVentana(3);
    	  this.dispose();
      }
      
    }
}