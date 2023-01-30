/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DANIEL
 */
public class Main {
    public static void main(String[] args) {
        Empresa empresa;
        Empresas empresas;
        Presentacion presentacion;
        Menu menu;
        Datos datos;
        int opcion;
        String parametro;
        
        presentacion=new Presentacion();
        menu=new Menu();
        datos=new Datos();
        do {
        	opcion=menu.capturarOpcion();
        	switch (opcion) {
        		case 1: {
        	        empresa=presentacion.capturarEmpresa();
        	        datos.grabarEmpresa(empresa);
        	        presentacion.presentarEmpresa(empresa);
        	        break;
        		}
        		case 2: {
        			parametro=presentacion.capturarSolicitudEmpresa();
                                
        			empresa=datos.recuperarEmpresa(Integer.parseInt(parametro));
        			presentacion.presentarEmpresa(empresa);
        			break;
        		}
        		case 3: {
                    empresas=datos.recuperarEmpresas();
                    presentacion.presentarCantidadRegistros(empresas.calcularCapacidad());
                    presentacion.presentarEmpresas(empresas);
        		}
        		case 4: {
        			empresas=datos.recuperarEmpresas();
        			presentacion.presentarIndicadores(empresas);
        		}
        	}
        } while (opcion<=4);
	}
}
