/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DANIEL
 */
import javax.swing.JOptionPane;
public class Presentacion {
    public Presentacion() {
		
	}
    public Empresa capturarEmpresa() {
		Empresa rEmpresa;
        rEmpresa = new Empresa();
        try {
            rEmpresa.setNumeroSolicitud(Integer.parseInt(JOptionPane.showInputDialog("Numero de solicitud: ")));
            rEmpresa.setNombreEmpresa(JOptionPane.showInputDialog("Nombre de la empresa: "));
            rEmpresa.setNit(Integer.parseInt(JOptionPane.showInputDialog("Nit: ")));
            rEmpresa.setDepartamento(JOptionPane.showInputDialog("Departamento: "));
            rEmpresa.setCiudad(JOptionPane.showInputDialog("Ciudad: "));
            rEmpresa.setNumeroContacto(JOptionPane.showInputDialog("Numero contacto:"));
            rEmpresa.setTipoResiduo(JOptionPane.showInputDialog("Tipo de residuo(Organico,inorganico,Peligroso,): "));
            rEmpresa.setCantidadResiduoMes(Integer.parseInt(JOptionPane.showInputDialog("Cantidad de residuos mensuales kg: ")));
        } catch (Exception e) {
        	
        }
        return rEmpresa;
    }
    public String capturarSolicitudEmpresa(){
        String rNumeroSolicitud;
        rNumeroSolicitud=JOptionPane.showInputDialog("Numero de solicitud: ");
        return rNumeroSolicitud;
    }
     public void presentarEmpresa(Empresa pEmpresa) {
    	String rMensaje;
    	if (pEmpresa.validarEmpresa()) {
        	rMensaje = "Numero Solicitud: "+pEmpresa.getNumeroSolicitud();
        	rMensaje = rMensaje + "\nNombre Empresa: "+pEmpresa.getNombreEmpresa();
        	rMensaje = rMensaje + "\nNit: "+pEmpresa.getNit();
        	rMensaje = rMensaje + "\n Departamento: "+pEmpresa.getDepartamento();
            rMensaje = rMensaje + "\n Ciudad: "+pEmpresa.getCiudad();
            rMensaje = rMensaje + "\nNumero de Contacto: "+pEmpresa.getNumeroContacto();
            rMensaje = rMensaje + "\n Tipo de Residuo: "+pEmpresa.getTipoResiduo();
            rMensaje = rMensaje + "\n Cantidad Residuo por mes kg: "+pEmpresa.getCantidadResiduoMes();
        	
    	} else {
    		rMensaje = "Datos inconsistentes. No se puede presentar";
    	}
    	JOptionPane.showMessageDialog(null, rMensaje);
    }
     public void presentarCantidadRegistros(int pCantidadRegistros) {
     	String rMensaje;
     	rMensaje = "El archivo contiene "+pCantidadRegistros+" registros.";
     	JOptionPane.showMessageDialog(null, rMensaje);
     }
     
     public void presentarEmpresas(Empresas pEmpresas){
         int i;
         for (i=0;i<pEmpresas.calcularCapacidad();i=i+1){
             this.presentarEmpresa(pEmpresas.recuperar(i));
         }
     }
     public void presentarIndicadores(Empresas pEmpresas) {
     	String rMensaje;
     	rMensaje = "Empresas: "+pEmpresas.calcularCapacidad();
     	rMensaje = rMensaje + "\nTotal kg por empresas : "+pEmpresas.acumularTotalResiduos();
     	rMensaje = rMensaje + "\nTotal porcentaje: "+pEmpresas.calcularPorcentaje();
     
     	JOptionPane.showMessageDialog(null, rMensaje);
     }
    
}
