/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DANIEL
 */
public class Empresa {
     private int numeroSolicitud;
     private String nombreEmpresa;
     private int nit;
     private String departamento;
     private String ciudad;
     private String numeroContacto;
     private String tipoResiduo;
     private int cantidadResiduoMes;
    

     public Empresa(){
      numeroSolicitud =0;
      nombreEmpresa ="";
      nit =0;
      departamento="";
      ciudad="";
      numeroContacto="";
      tipoResiduo="";
      cantidadResiduoMes=0;
      

    }
     
     public void setNumeroSolicitud(int pNumeroSolicitud) {
    	if (pNumeroSolicitud>=0) {
    		this.numeroSolicitud = pNumeroSolicitud;
    	}
    }
     public void setNombreEmpresa(String pNombreEmpresa) {
    	if (pNombreEmpresa.length()>=0) {
    		this.nombreEmpresa = pNombreEmpresa;
    	}
    }
     public void setNit(int pNit) {
    	if (pNit>=0) {
    		this.nit = pNit;
    	}
    }
     public void setDepartamento(String pDepartamento) {
    	if (pDepartamento.length()>=0) {
    		this.departamento = pDepartamento;
    	}
    }
     public void setCiudad(String pCiudad) {
    	if (pCiudad.length()>=0) {
    		this.ciudad = pCiudad;
    	}
    }
     public void setNumeroContacto(String pNumeroContacto) {
    	if (pNumeroContacto.length()>=0) {
    		this.numeroContacto = pNumeroContacto;
    	}
    }
     public void setTipoResiduo(String pTipoResiduo) {
    	if (pTipoResiduo.length()>=0) {
    		this.tipoResiduo = pTipoResiduo;
    	}
    }
     public void setCantidadResiduoMes(int pCantidadResiduoMes) {
    	if (pCantidadResiduoMes>=0) {
    		this.cantidadResiduoMes = pCantidadResiduoMes;
    	}
    }
     //metodos get 
     public int getNumeroSolicitud() {
    	return this.numeroSolicitud;
    }
    
    public String getNombreEmpresa() {
    	return this.nombreEmpresa;
    }
	
    public int getNit() {
    	return this.nit;
    }
	
    public String getDepartamento() {
    	return this.departamento;
    }
    public String getCiudad(){
        return this.ciudad;
    }
    public String getNumeroContacto(){
        return this.numeroContacto;
    }
    public String getTipoResiduo(){
    return this.tipoResiduo;
    }
    public int getCantidadResiduoMes(){
        return this.cantidadResiduoMes;
    }
    public boolean validarEmpresa(){
        boolean rValidar;
        rValidar=((this.numeroSolicitud>0)&&
                (this.nombreEmpresa.length()>0) &&
                (this.nit>0) &&
                (this.departamento.length()>0) &&
                (this.ciudad.length()>0) &&
                (this.numeroContacto.length()>0)&&
                (this.tipoResiduo.length()>0)&&
                (this.cantidadResiduoMes>0));
        return rValidar;
    }
}
