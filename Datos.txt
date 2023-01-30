/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DANIEL
 */


import java.io.*;

public class Datos {
    public Datos() {
		
	}
    public String construirRegistroEmpresa(Empresa pEmpresa) {
		String rRegistro;
		rRegistro = pEmpresa.getNumeroSolicitud() + ",";
		rRegistro = rRegistro + pEmpresa.getNombreEmpresa() + ",";
		rRegistro = rRegistro + pEmpresa.getNit() + ",";
		rRegistro = rRegistro + pEmpresa.getDepartamento()+",";
        rRegistro = rRegistro + pEmpresa.getCiudad()+",";
        rRegistro = rRegistro + pEmpresa.getNumeroContacto()+",";
        rRegistro = rRegistro + pEmpresa.getTipoResiduo()+",";
        rRegistro = rRegistro + pEmpresa.getCantidadResiduoMes();
		return rRegistro;
	}
    public void grabarEmpresa(Empresa pEmpresa) {
                FileWriter fileWriter;
		PrintWriter printWriter;
		if (pEmpresa.validarEmpresa()) {
			try {
				fileWriter = new FileWriter("empresas.txt", true);
				printWriter = new PrintWriter(fileWriter);
				printWriter.println(this.construirRegistroEmpresa(pEmpresa));
				fileWriter.close();
			} catch(Exception e) {
				
			}
		}
    }
	
        public String descomponerEmpresa(String pRegistro, int pOrden){
        int i,j;
        String rDato;
        i=0;
        j=1;
        rDato="";
        while ((i<pRegistro.length()) && (j<=pOrden)) {
            if (pRegistro.substring(i,i+1).compareTo(",")!=0){
                if (j==pOrden){
                    rDato=rDato+pRegistro.substring(i,i+1);
                }
            }
            else{
                j=j+1;
            }
            i=i+1;
        }
        return rDato;
    }
        
       public String recuperarRegistroEmpresa(int pNumeroSolicitud){
        FileReader fileReader;
        BufferedReader bufferedReader;
        String rRegistro = "";
        String line = "";
        try{
            fileReader=new FileReader("empresas.txt");
            bufferedReader=new BufferedReader(fileReader);
            
            while((line = bufferedReader.readLine())!= null) {
               String[] split = line.split(",");
               if(split[0].equals(String.valueOf(pNumeroSolicitud))){
                  rRegistro = line;
               }
            }
            fileReader.close();
        }
        catch (Exception e){
            rRegistro="";
        }
        return rRegistro;
    }
       public String recuperarRegistroEmpresas(int pPosicion){
           FileReader fileReader;
           BufferedReader bufferedReader;
           String rRegistro = "";
           int i;
           i=-1;
           String line = "";
           
           try{
               fileReader=new FileReader("empresas.txt");
               bufferedReader=new BufferedReader(fileReader);
               do{
                   rRegistro=bufferedReader.readLine();
                   i=i+1;
               } while (i<pPosicion);
              
               
                  
               fileReader.close();
           }
           catch (Exception e){
        	   rRegistro = line;
               rRegistro="";
           }
           return rRegistro;
       }
       
    
        public Empresa recuperarEmpresa(int pNumeroSolicitud){
        String tRegistro;
        
        Empresa rEmpresa;
        rEmpresa=new Empresa();
        try {
            tRegistro=this.recuperarRegistroEmpresa(pNumeroSolicitud);
            rEmpresa.setNumeroSolicitud(Integer.parseInt(this.descomponerEmpresa(tRegistro,1)));
            rEmpresa.setNombreEmpresa(this.descomponerEmpresa(tRegistro,2)); 
            rEmpresa.setNit(Integer.parseInt(this.descomponerEmpresa(tRegistro,3)));
            rEmpresa.setDepartamento(this.descomponerEmpresa(tRegistro, 4));
            rEmpresa.setCiudad(this.descomponerEmpresa(tRegistro, 5));
            rEmpresa.setNumeroContacto(this.descomponerEmpresa(tRegistro, 6));
            rEmpresa.setTipoResiduo(this.descomponerEmpresa(tRegistro, 7));
            rEmpresa.setCantidadResiduoMes(Integer.parseInt(this.descomponerEmpresa(tRegistro, 8)));
        } catch (Exception e) {
        	
        }
        return rEmpresa;
    }
        public Empresa recuperarEmpresas(int pPosicion){
            String tRegistro;
            Empresa rEmpresa;
            rEmpresa=new Empresa();
            tRegistro=this.recuperarRegistroEmpresas(pPosicion);
            try{
            	rEmpresa.setNumeroSolicitud(Integer.parseInt(this.descomponerEmpresa(tRegistro,1)));
                rEmpresa.setNombreEmpresa(this.descomponerEmpresa(tRegistro,2)); 
                rEmpresa.setNit(Integer.parseInt(this.descomponerEmpresa(tRegistro,3)));
                rEmpresa.setDepartamento(this.descomponerEmpresa(tRegistro, 4));
                rEmpresa.setCiudad(this.descomponerEmpresa(tRegistro, 5));
                rEmpresa.setNumeroContacto(this.descomponerEmpresa(tRegistro, 6));
                rEmpresa.setTipoResiduo(this.descomponerEmpresa(tRegistro, 7));
                rEmpresa.setCantidadResiduoMes(Integer.parseInt(this.descomponerEmpresa(tRegistro, 8)));
            }
            catch (Exception e){
                
            }
            return rEmpresa;
        }
        public Empresas recuperarEmpresas(){
            Empresas rEmpresas;
            rEmpresas=new Empresas(this.contarRegistrosEmpresas());
            int i;
            for (i=0;i<this.contarRegistrosEmpresas();i=i+1){
                rEmpresas.incluir(this.recuperarEmpresas(i));
            }
            return rEmpresas;
        }
        public int contarRegistrosEmpresas() {
        	FileReader fileReader;
        	BufferedReader bufferedReader;
        	int rRegistros;
        	String tRegistro;
        	rRegistros = 0;
        	try {
        		fileReader=new FileReader("empresas.txt");
        		bufferedReader=new BufferedReader(fileReader);
        		do {
        			tRegistro=bufferedReader.readLine();
        			if (tRegistro!=null) {
        				rRegistros = rRegistros + 1;
        			}
        		} while (tRegistro!=null);
        		fileReader.close();
        	} catch (Exception e) {
        		
        	}
        	return rRegistros;
        }
    
}
