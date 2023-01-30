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
public class Menu {
    public Menu() {
		
	}
    public int capturarOpcion() {
		String tMensaje;
		int rOpcion;
		tMensaje = "1. Registrar Empresa\n";
		tMensaje = tMensaje + "2. Consultar Empresa\n";
		tMensaje = tMensaje + "3. Consultar archivo\n";
		tMensaje = tMensaje + "4. Consultar Indicadores\n";
		tMensaje = tMensaje + "5. Salir";
		rOpcion=Integer.parseInt(JOptionPane.showInputDialog(tMensaje));
		return rOpcion;
	}
    
}
