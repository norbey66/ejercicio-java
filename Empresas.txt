
public class Empresas {
private Empresa[] arreglo;
    
    public Empresas(int pCapacidad){
        if (pCapacidad>0){
            arreglo=new Empresa[pCapacidad];
        }
    }
    
    public int calcularCapacidad(){
        int rCapacidad;
        rCapacidad=this.arreglo.length;
        return rCapacidad;
    }
    
    public void incluir(Empresa pEmpresa){
        int i;
        if (pEmpresa.validarEmpresa()){
            i=0;
            while ((i<this.arreglo.length) && (this.arreglo[i]!=null)){
                i=i+1;
            }
            if (i<this.arreglo.length){
                arreglo[i]=pEmpresa;
            }
        }
    }
    
    public Empresa recuperar(int pIndice){
        Empresa rEmpresa;
        if ((pIndice>=0) && (pIndice<=this.arreglo.length) && (this.arreglo[pIndice]!=null)){
            rEmpresa=this.arreglo[pIndice];
        }
        else{
            rEmpresa=new Empresa();
        }
        return rEmpresa;
    }
    public int acumularTotalResiduos() {
    	int rTotalResiduos;
    	int i;
    	rTotalResiduos=0;
    	for (i=0; i<this.calcularCapacidad(); i++) {
    		rTotalResiduos=rTotalResiduos+this.recuperar(i).getCantidadResiduoMes();
    	}
    	return rTotalResiduos;
    }
    public double calcularPorcentaje() {
    	double rPorcentaje;
    	rPorcentaje = (double) Math.round((float)(this.acumularTotalResiduos()) * 10000 / this.calcularCapacidad()) / 100;
    	return rPorcentaje;
    }
}
