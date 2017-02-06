package Ventanas;

import java.awt.Color;
import java.awt.Container;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
public class seudos extends JFrame implements ActionListener {
	String[] titulos = {"n","Xn","Xn+1","Rn"}; // los titulos
	String[][] seudosle; // Aqui metemos los datos de los pseudo a
	private JTable mitabla;
	private Container ct,pdf;
	int n;
	int xo;
	int a;
	int b;
	int m;
	int tipo; // tipo de metodo
	int k;
        int p;
        double media,desviacion;
	double[][] seudos;
        double tabla1[][];
        double tabla3[][];
        double tabla2[][];
        double tabla4[][]; 
        double tabla5[][];
        double beneficios[][];
        double exceso[][];
        double compras[]={190,200,210,220,230,240,250,260};
        double decision[][];
	
	private DefaultTableModel dtm=new DefaultTableModel();
	private JTable personTable = new JTable(dtm);
	private JScrollPane scroll;
	JLabel tablas, cut;
	JButton menu,home,otro, bS,bR,bB,bE,bC;
	
	DefaultTableModel mym = new DefaultTableModel(seudosle,titulos);         
	
	seudos(String xo, int m, int n, int a, int b, int tipo){
		  this.xo=Integer.parseInt(xo); 
                  this.m=m;
                  this.n=n; 
                  this.a=a;
                  this.b=b;
                  this.tipo=tipo; 
                  this.k=String.valueOf(xo).length();
		  switch (tipo) {
                        
                         case 4:
				seudos=new double[n*3][4];
				generarSeudos(0,this.xo);
				//this.obtenerMatriz(seudos);
				//concruencial mixto
				break;
			
			case 5:
				seudos=new double[n*3][4];
				generarSeudos(0,this.xo);
                                //this.obtenerMatriz(seudos);
                                //mostrar();
				//this.obtenerMatriz();
				//concruencial mixto
				break;
			}
                  
		  leerArchivo();
                  leerArchivo2();
                  leerArchivo3();
                  tablaResultado();
                  beneficios_excesp();
		  iniciarComponentes();
                  this.obtenerMatriz(seudos);
		  setTitle("Simulacion y modelo - Tablas y resultados");
		  setSize(1070,400);
		  setLocationRelativeTo(null);
		  setVisible(true);
		  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	}
        
        void mostrar(){
		for(int i=0;i<n*3;++i){
			for(int j=0;j<4;++j){
				System.out.print(seudos[i][j]+"    ");
			}
			System.out.println();
		}
	}
	
	private void obtenerMatriz(double[][] a){
		int cantr = dtm.getRowCount();
		while(cantr>0){
			dtm.removeRow(cantr-1);
			cantr--;
		}
		for(int i=0;i<n*3;++i){
			Object[] seudosle= new Object[4];
				for(int j=0;j<4;++j){
                                      System.out.println("hola");
					seudosle[j]=a[i][j];
				}
				dtm.addRow(seudosle);
		}	
	}
	private void iniciarComponentes() {
		ct=getContentPane();
		ct.setLayout(null); 
		ct.setBackground(Color.white);
		
		int l1=50,lg=270,l3=100,anc=2,ang=35;
		
		dtm.setColumnIdentifiers(titulos);
		
		tablas = new JLabel();
		tablas.setText("TABLAS");
		tablas.setBounds(70, 0, 270, 50);
		ct.add(tablas);
		
		cut = new JLabel();
		cut.setText("Cuentas");
		cut.setBounds(650, 0, 270, 50);
		ct.add(cut);
		
		bS= new JButton();
		bS.setText("Seudo Aletorios");
		bS.setBounds(anc, l1, lg, ang);
		bS.addActionListener(this);
		ct.add(bS);
		
		bR= new JButton();
		bR.setText("Resultados");
		bR.setBounds(anc, l1*2, lg, ang);
		bR.addActionListener(this);
		ct.add(bR);
		
		bB= new JButton();
		bB.setText("Beneficios");
		bB.setBounds(anc, l1*3, lg, ang);
		bB.addActionListener(this);
		ct.add(bB);
		
		bE= new JButton();
		bE.setText("Exceso");
		bE.setBounds(anc,l1*4, lg, ang);
		bE.addActionListener(this);
		ct.add(bE);
		
		bC= new JButton();
		bC.setText("Conclusion");
		bC.setBounds(anc,l1*5, lg, ang);
		bC.addActionListener(this);
		ct.add(bC);
		
		menu= new JButton();
		menu.setText("Menu");
		menu.setBounds(2, 300, lg, 60);
		menu.addActionListener(this);
		ct.add(menu);
		dtm.setColumnIdentifiers(titulos);
		scroll = new JScrollPane(personTable);
		scroll.setBounds(290,50,760,310);
		ct.add(scroll);
	}
	public void actionPerformed(ActionEvent evento) {
	     if(evento.getSource()==menu){
	    	 new VentanaPrincipal();
	    	  this.dispose();
	     }
	     if(evento.getSource()==bS){
	    	 //pseudos
	    	obtenerMatriz(seudos);
	     }
	     if(evento.getSource()==bR){
	    	 obtenerMatriz(tabla4);
	     }
	     if(evento.getSource()==bB){
	    	 obtenerMatriz(beneficios);
	     }
	     if(evento.getSource()==bE){
	    	 obtenerMatriz(exceso);
	     }
	     if(evento.getSource()==bC){
	    	 obtenerMatriz(decision);
	     }
	}

	void generarSeudos(int i,double xo){
		if(i<n*3){
				seudos[i][0]=i;
				seudos[i][1]=a*xo;
				double mod=mod(xo);
				seudos[i][2]=mod;
				double valor=ks(xo);
				seudos[i][3]=valor;
				generarSeudos(++i,mod);
		}
	}
	void cuadradoMedio(int i, double xo){
		if(i < n){
			seudos[i][0]=i;
			seudos[i][1]=xo;
			double medio=mediana((int)Math.pow(xo,2));
			seudos[i][2]=medio;
			String rn= "0."+String.valueOf((int)medio);
			seudos[i][3]=Double.valueOf(rn); 
			cuadradoMedio(++i,medio);
		}
	}
	//variacion
	void productoMedioC(int i,double a, double xo){
		if(i < n){
			seudos[i][0]=i;
			seudos[i][1]=xo;
			double medio=mediana((int)(xo*a));
			seudos[i][2]=medio;
			String rn= "0."+String.valueOf((int)medio);
			seudos[i][3] = 2; //Double.valueOf(rn); 
			productoMedioC(++i,a,medio);
		}
	}
	
	//este toma dos valores como semilla, y comienza con n=1
	void productoMedio(int i, double xo,double x1){
		if(i <= n){
			seudos[i][0]=i;
			seudos[i][1]=xo;
			seudos[i][2]=x1;
			double medio=mediana((int)(xo*x1));
			seudos[i][3]=medio;
			String rn= "0."+String.valueOf((int)medio);
			seudos[i][4]=Double.valueOf(rn); 
			productoMedio(++i,x1,medio);
		}
	}
	
	double mediana(int m){
		LinkedList<String> cola = new LinkedList<String>();
		String lista=String.valueOf(m);
		if((lista.length()-k)%2!=0){
			cola.add("0");
		}
		for(int i=0;i<lista.length();++i){
			cola.add(lista.substring(i, i+1));
		}
		k=3;
		while(cola.size()>k){
			cola.remove(0);
			cola.remove(cola.size()-1);
		}
		String aux="";
		while(!cola.isEmpty()){
			aux += (cola.get(0));
			cola.remove(0);
		}
		return Double.valueOf(aux);
	}
	
	double ks(double xo){
		double valor=(double)(xo/m);
                String h="%."+k+"f";
                String a = String.format(h, valor);
                String arr[]=a.split(",");
                
                double b = Double.valueOf(arr[0]+"."+arr[1]);
                return b;
	}
	double mod(double xo){
		return (double)((a*xo+b)%(m));
	}
	
	 void leerArchivo(){
	        
	        File f = new File("Tabla1.txt");
	        try{
	        FileInputStream f1 = new FileInputStream(f);
	        BufferedReader leer = new BufferedReader(new InputStreamReader(f1));
	        String cadena= leer.readLine();
	        tabla1 = new double[5][6];
	           for(int i=0;i<5;i++){
	            String arr[]=cadena.split(" ");
	            for(int j=0;j<6;j++){
	                tabla1[i][j]=Double.parseDouble(arr[j]);
	            }
	            cadena=leer.readLine();
	          }                                      
	        }catch(IOException ex){
	            System.out.println("Error en la lectura del archivo");
	        }
	        
	    }
	     void leerArchivo2(){
	        
	        File f = new File("Tabla2.txt");
	        try{
	        FileInputStream f1 = new FileInputStream(f);
	        BufferedReader leer = new BufferedReader(new InputStreamReader(f1));
	        String cadena= leer.readLine();
	        tabla3= new double[6][6];
	           for(int i=0;i<6;i++){
	            String arr[]=cadena.split(" ");
	            for(int j=0;j<6;j++){
	                tabla3[i][j]=Double.parseDouble(arr[j]);
	            }
	            cadena=leer.readLine();
	          }                                      
	        }catch(IOException ex){
	            System.out.println("Error en la lectura del archivo");
	        }
	        
	    }
	      void leerArchivo3(){
	        
	        File f = new File("Tabla3.txt");
	        try{
	        FileInputStream f1 = new FileInputStream(f);
	        BufferedReader leer = new BufferedReader(new InputStreamReader(f1));
	        String cadena= leer.readLine();
	        tabla2 = new double[5][6];
	           for(int i=0;i<5;i++){
	            String arr[]=cadena.split(" ");
	            for(int j=0;j<6;j++){
	                tabla2[i][j]=Double.parseDouble(arr[j]);
	            }
	            cadena=leer.readLine();
	          }                                      
	        }catch(IOException ex){
	            System.out.println("Error en la lectura del archivo");
	        }
	        
	    }
	      
	  void tablaResultado(){
	          tabla4 = new double[n][6];
	          int cont=0;
	          for(int i=0;i<n;i++){
	              double x1=seudos[i][3];
	              for(int j=0;j<5;j++){
	                  double x2=tabla1[j][4];
	                  double x3=tabla1[j][5];
	                  if(x1>=x2 && x1 <= x3){
	                      tabla4[i][0]=tabla1[j][0];
	                      tabla4[i][1]=x1;
	                      break;
	                  }
	             }
	           }
	          for(int i=n;i<n*2;i++){           
	                     double x1=seudos[i][3];
	                     for(int j=0;j<5;j++){
	                        double x2=tabla2[j][4];
	                        double x3=tabla2[j][5];
	                        if(x1>=x2 && x1 <= x3){
	                            tabla4[cont][2]=tabla2[j][0];
	                            tabla4[cont][3]=x1;
	                      break;
	                        }
	                    }
	               cont=cont+1;
	          }
	                 
	          cont=0;
	          for(int i=n*2;i<n*3;i++){   
	                    double x1=seudos[i][3];
	                     for(int j=0;j<6;j++){
	                        double x2=tabla3[j][4];
	                        double x3=tabla3[j][5];
	                        if(x1>=x2 && x1 <= x3){
	                            tabla4[cont][4]=tabla3[j][0];
	                            tabla4[cont][5]=x1;
	                           
	                      break;
	                        }
	                    }
	                     cont=cont+1;
	          }
	          
	      }
	      
	      void beneficios_excesp(){
	          beneficios = new double[n][8];
	          exceso = new double[n][8];
	          decision= new double[5][8];
	        for(int i=0;i<compras.length;i++){  
	         for(int j=0;j<n;j++){
	             double precioC = tabla4[j][0];
	             double precioV = tabla4[j][2];
	             double demanda = tabla4[j][4];
	             if(demanda>=compras[i]){
	                 beneficios[j][i]= (compras[i]*precioV) - (compras[i]*precioC)-(compras[i]*10);
	                 media=media+beneficios[j][i];
	                 desviacion=desviacion+Math.pow(beneficios[j][i],2);
	             }else{
	                 beneficios[j][i]=(demanda*precioV)-(compras[i]*precioC)-(compras[i]*10);
	                 media=media+beneficios[j][i];
	                 desviacion=desviacion+Math.pow(beneficios[j][i],2);
	                 double res = compras[i]-demanda;
	                 exceso[j][i]= res*precioC + res*10;
	             }
	         }
	         media =media /n;    
	          String h="%."+k+"f";
	          String a = String.format(h,media);
	          String arr[]=a.split(",");            
	          double b = Double.valueOf(arr[0]+"."+arr[1]);
	          desviacion=Math.pow((desviacion/n)-Math.pow(b,2),0.5);
	          String c = String.format(h,desviacion);
	          String arr1[]=c.split(",");
	          double d = Double.valueOf(arr1[0]+"."+arr1[1]); 
	          double minimo=b-1.96*(d/Math.pow(n,0.5));
	          double maximo=b+1.96*(d/Math.pow(n,0.5));
	          double confianza=maximo-b;
	          String min=String.format(h,minimo);
	          String max=String.format(h,maximo);
	          String conf=String.format(h,confianza);
	          String arr2[]=min.split(",");
	          String arr3[]=max.split(",");
	          String arr4[]=conf.split(",");
	          double min2 = Double.valueOf(arr2[0]+"."+arr2[1]);
	          double max2 = Double.valueOf(arr3[0]+"."+arr3[1]); 
	          double conf2 = Double.valueOf(arr4[0]+"."+arr4[1]); 
	          decision[0][i]=b;
	          decision[1][i]=d;
	          decision[2][i]=conf2;
	          decision[3][i]=max2;
	          decision[4][i]=min2;
	         desviacion=0; 
	         media=0;
	        }
	        
	        
	      }
	      

}