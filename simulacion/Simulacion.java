/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simulacion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.*;

public class Simulacion {

    public static void main(String[] args) {
        new simu(30,"050",1001,1021,0,1850);
    }
    
}
class simu {
	int n;
	int xo;
	int a;
	int b;
	int m;
	int tipo; // tipo de metodo
	int k;
        double media,desviacion;
	double[][] seudos;
        double tabla1[][];
        double tabla3[][];
        double tabla2[][];
        double tabla4[][]; 
        double beneficios[][];
        double exceso[][];
        double compras[]={190,200,210,220,230,240,250,260};
        double decision[][];
	simu(int n, String xo,int a,int b,int tipo,int m){
		this.n=n;
		this.m=m;
		this.xo=Integer.parseInt(xo);
		this.a=a;
		this.b=b;
		this.k=xo.length();
		this.tipo = tipo;
		seudos=new double[n*3][4];
		generarSeudos(0,this.xo);
                leerArchivo();
                leerArchivo2();
                leerArchivo3();
                tablaResultado();
                beneficios_excesp();
		mostrar2();
	}
	void mostrar(){
		for(int i=0;i<n*3;++i){
			for(int j=0;j<4;++j){
				System.out.print(seudos[i][j]+"    ");
			}
			System.out.println();
		}
	}
        
        void mostrar2(){
            for(int i=0;i<5;++i){
			for(int j=0;j<8;++j){
				System.out.print(decision[i][j]+"    ");
			}
			System.out.println();
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