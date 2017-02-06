package Ventanas;

import java.awt.Color;
import java.awt.Container;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class NuevaVentana extends JFrame implements ActionListener {
	String metodo;
	TextField txo,ta,tb,tk,tm;
	JLabel jxo,ja,jb,jk,jm;
	JButton menu,otro, generar,act;
	int i;
	private NuevaVentana metodos;
	private Container ct;
	NuevaVentana(int i){
		  this.i=i;
		  iniciarComponentes(i);
		  setTitle("Simulacion y modelo- Metodo : "+metodo);
		  setSize(1070,400);
		  setLocationRelativeTo(null);
		  setVisible(true);
		  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	private void limpiar(){
		this.txo.setText("");
		this.tk.setText("");
		this.tm.setText("");
		if(i==4){
			this.ta.setText("");
		}else if(i==5){
			this.ta.setText("");
			this.tb.setText("");
		}
	}
	private void iniciarComponentes(int i) {
		ct=getContentPane();
		ct.setLayout(null); 
		ct.setBackground(Color.white);
			
		menu= new JButton();
		menu.setText("Menu");
		menu.setBounds(0, 300, 270, 60);
		menu.addActionListener(this);
		ct.add(menu);
		
		
		otro= new JButton();
		otro.setText("Siguiente metodo");
		otro.setBounds(790, 300, 270, 60);
		otro.addActionListener(this);
		ct.add(otro);


		if(i==1){
			metodo="Medio Cuadrado";
			
			jxo= new JLabel();
			jxo.setText("xn = ");
			jxo.setBounds(20, 40, 40, 23);
			
			txo = new TextField();
			txo.setText(" ");
			txo.setBounds(90, 40, 100, 23);
			
			jm= new JLabel();
			jm.setText("n = ");
			jm.setBounds(200, 40, 40, 23);
			
			tm = new TextField();
			tm.setText(" ");
			tm.setBounds(240, 40, 100, 23);
			

			ct.add(jm);
			ct.add(tm);
			ct.add(jxo);
			ct.add(txo);
			
			
		}else if(i==2){
			metodo="Producto medio";
			jxo= new JLabel();
			jxo.setText("xo = ");
			jxo.setBounds(20, 40, 40, 23);
			
			txo = new TextField();
			txo.setText(" ");
			txo.setBounds(90, 40, 100, 23);
			
			jm= new JLabel();
			jm.setText("Xn = ");
			jm.setBounds(200, 40, 40, 23);
			
			tm = new TextField();
			tm.setText(" ");
			tm.setBounds(240, 40, 100, 23);
			
			jk= new JLabel();
			jk.setText("n = ");
			jk.setBounds(350, 40, 40, 23);
			
			tk = new TextField();
			tk.setText(" ");
			tk.setBounds(400, 40, 100, 23);

			ct.add(jk);
			ct.add(tk);
			ct.add(jxo);
			ct.add(txo);
			ct.add(jm);
			ct.add(tm);
			
		}else if(i==3){
			metodo= "Producto medio con Variacion";
			
			jxo= new JLabel();
			jxo.setText("xo = ");
			jxo.setBounds(20, 40, 40, 23);
			
			txo = new TextField();
			txo.setText(" ");
			txo.setBounds(90, 40, 100, 23);
			
			jm= new JLabel();
			jm.setText("x1 = ");
			jm.setBounds(200, 40, 40, 23);
			
			tm = new TextField();
			tm.setText(" ");
			tm.setBounds(240, 40, 100, 23);
			
			jk= new JLabel();
			jk.setText("n = ");
			jk.setBounds(350, 40, 40, 23);
			
			tk = new TextField();
			tk.setText(" ");
			tk.setBounds(400, 40, 100, 23);

			ct.add(jk);
			ct.add(tk);
			
			ja= new JLabel();
			ja.setText("a = ");
			ja.setBounds(20, 80, 40, 23);
			ta= new TextField();
			ta.setText(" ");
			ta.setBounds(90, 80, 100, 23);
			ct.add(ja);
			ct.add(ta);
			ct.add(txo);
			ct.add(jxo);
			ct.add(jm);
			ct.add(tm);
			
		}else if(i==4){
			metodo= "Congruencial Multiplicativo";
			
			jxo= new JLabel();
			jxo.setText("xo = ");
			jxo.setBounds(20, 40, 40, 23);
			
			txo = new TextField();
			txo.setText(" ");
			txo.setBounds(90, 40, 100, 23);
			
			jm= new JLabel();
			jm.setText("m = ");
			jm.setBounds(200, 40, 40, 23);
			
			tm = new TextField();
			tm.setText(" ");
			tm.setBounds(240, 40, 100, 23);
			
			ct.add(jm);
			ct.add(tm);

			jk= new JLabel();
			jk.setText("n = ");
			jk.setBounds(350, 40, 40, 23);
			
			tk = new TextField();
			tk.setText(" ");
			tk.setBounds(400, 40, 100, 23);

			ct.add(jk);
			ct.add(tk);
			
			ct.add(txo);
			ct.add(jxo);
			
			ja= new JLabel();
			ja.setText("a = ");
			ja.setBounds(20, 80, 40, 23);
			ta= new TextField();
			ta.setText(" ");
			ta.setBounds(90, 80, 100, 23);
			ct.add(ja);
			ct.add(ta);
		}else if(i==5){
			metodo= "Congruencial Mixto";
			
			jxo= new JLabel();
			jxo.setText("xo = ");
			jxo.setBounds(20, 40, 40, 23);
			
			txo = new TextField();
			txo.setText(" ");
			txo.setBounds(90, 40, 100, 23);
			
			jm= new JLabel();
			jm.setText("m = ");
			jm.setBounds(200, 40, 40, 23);
			
			tm = new TextField();
			tm.setText(" ");
			tm.setBounds(240, 40, 100, 23);
			
			ct.add(jm);
			ct.add(tm);
			
			jk= new JLabel();
			jk.setText("n = ");
			jk.setBounds(350, 40, 40, 23);
			
			tk = new TextField();
			tk.setText(" ");
			tk.setBounds(400, 40, 100, 23);

			ct.add(jk);
			ct.add(tk);
			
			ja= new JLabel();
			ja.setText("a = ");
			ja.setBounds(20, 80, 40, 23);
			
			ta= new TextField();
			ta.setText(" ");
			ta.setBounds(90, 80, 100, 23);
			
			jb= new JLabel();
			jb.setText("b = ");
			jb.setBounds(200, 80, 40, 23);
			
			tb= new TextField();
			tb.setText(" ");
			tb.setBounds(240, 80, 100, 23);
			
			ct.add(ja);
			ct.add(ta);
			ct.add(jb);
			ct.add(tb);
			ct.add(txo);
			ct.add(jxo);
		}
		
		act= new JButton();
		act.setText("Actualizar");
		act.setBounds(200, 120, 170, 30);
		act.addActionListener(this);
		ct.add(act);
		generar= new JButton();
		generar.setText("Generar");
		generar.setBounds(20, 120, 170, 30);
		generar.addActionListener(this);
		ct.add(generar);
		
	}
	int xo,a,b,m,k;
	private boolean validar(){
		try{
			xo = Integer.parseInt(txo.getText());
		}catch(Exception e){
			return false;
		}
		
		if(i==1){
			try{
				m = Integer.parseInt(tm.getText());
			}catch(Exception e){
				return false;
			}
		}
		if(i==2){
			try{
				k = Integer.parseInt(tk.getText());
			}catch(Exception e){
				return false;
			}
			try{
				m = Integer.parseInt(tm.getText());
			}catch(Exception e){
				return false;
			}
		}
		if(i==3){
			
			try{
				k = Integer.parseInt(tk.getText());
			}catch(Exception e){
				return false;
			}
			try{
				m = Integer.parseInt(tm.getText());
			}catch(Exception e){
				return false;
			}
		}
		if(i==4){
			try{
				a =Integer.parseInt(ta.getText());
			}catch(Exception e){
				return false;
			}
			try{
				m = Integer.parseInt(tm.getText());
			}catch(Exception e){
				return false;
			}
			try{
				k = Integer.parseInt(tk.getText());
			}catch(Exception e){
				return false;
			}
		}else if(i==5){
			try{
				a = Integer.parseInt(ta.getText());
			}catch(Exception e){
				return false;
			}
			try{
				b = Integer.parseInt(tb.getText());
			}catch(Exception e){
				return false;
			}
			try{
				k = Integer.parseInt(tk.getText());
			}catch(Exception e){
				return false;
			}
			try{
				m = Integer.parseInt(tm.getText());
			}catch(Exception e){
				return false;
			}
		}
		
		return true;
		
	}  
	public void actionPerformed(ActionEvent evento) {
	      if (evento.getSource()==menu){
	    	  new VentanaPrincipal();
	    	  this.dispose();
	      }else if(evento.getSource()==otro){
	    	  if(i+1==6){
	    		  new NuevaVentana(1);
	    	  }else
	    		  new NuevaVentana(i+1);
	    	  this.dispose();
	      }else if(evento.getSource()==generar){
	    	  	if(validar()){
	    	  		if(i==1 ){
	    	  			//new seudos(txo.getText(),0,(int)m,0,0,i);
	    	  		}else if(i==2){
	    	  			//new seudos(txo.getText(),m,(int)k,0,0,i);
	    	  		}else if(i==3){	
	    	  			//new seudos(txo.getText(),a,(int)k,0,0,i);
	    	  		}else if(i==4){
	    	  			new seudos(txo.getText(),m,k,a,0,i);
	    	  		}else if(i==5){
	    	  			new seudos(txo.getText(),m,k,a,b,i);
	    	  		}
	    	  		this.dispose();
	    	  	}else{
	    	  		//mensasjito
	    	  	}
	      }else if(evento.getSource()==act){
	    	  limpiar();
	      }
	    }
}
