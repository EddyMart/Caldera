/**
 * Clase que gestiona los gastos de campanya de
 * una caldera de comunitaria sin contadores.
 * Permite analizar gastos y hacer una regularizacion
 * informando cuanto se tiene que devolver o
 * cuanto mas tiene que pagar cada vecino.
 * 
 * @author Eddy Martinez
 * @version 1.0
 */
public class Caldera {
    
    // TODO: CONSTANTES

    /** El IVA se aplica a todos los gasto. */
    final double IMP_IVA = 0.22;
    
    /** El impuesto de hidrocarburos solo se aplica al gas, ademas del iva. */
    final double IMP_HIDROCARBUROS = 0.22;

    // Conceptos gastos
    final char AGUA = 'A';
    final char LUZ = 'L';
    final char NADA = 'N';

    // Ningun mes
    final int NINGUNO = 0;

    // Periodos
    final int PERIODO_OCTUBRE_DICIEMBRE = 1;
    final int PERIODO_ENERO_MARZO = 2;
    final int PERIODO_ABRIL_JUNIO = 3;
    final int JULIO_SEPTIEMBRE = 4;

    // TODO: VARIABLES DE CLASE (PROPIEDADES/ATRIBUTOS)

    // vecinos y presupuesto
    private int vecinos;
    private double presupuesto;

    // acumulados
    private double acumuladoConsumo;
    private double acumuladoMantenimiento;
    private int gastoAgua;
    private int gastoLuz;
    // estadisticas
    private int mesMasConsumo;
    private double maxConsumo;
    
    private int mesMasCaro;
    private double maxPrecio;
    
    private int mesMasBarato;
    private double minPrecio;
    
    private int periodoMasMantenimiento;
    private double maxMantenimiento;
    
    private int mesMasGasto;
    private double maxGasto;
    private char conceptoMasGasto;
    
    // TODO: constructores
    
    /**
     * Constructor de la clase Caldera. Inicializa los atributos.
     */
    public Caldera(){
        vecinos = 0;
        presupuesto = 0;
        acumuladoConsumo = 0;
        acumuladoMantenimiento = 0;
        gastoAgua = 0;
        gastoLuz = 0;
        mesMasConsumo = NINGUNO;
        maxConsumo = 0;
        mesMasCaro = NINGUNO;
        maxPrecio = 0;
        mesMasBarato = NINGUNO;
        minPrecio = 0;
        periodoMasMantenimiento = NINGUNO;
        maxMantenimiento = 0;
        mesMasGasto = NINGUNO;
        maxGasto = 0;
        conceptoMasGasto = NADA;
    }

    /**
     * Constructor de la clase Caldera. Inicializa los atributos.
     * 
     * @param queVecinos     Numero de vecinos que conforman la comunidad
     * @param quePresupuesto Presupuesto inicial con el que se pretende afrontar los
     *                       gastos
     */
    public Caldera(int queVecinos, int quePresupuesto){
        vecinos = queVecinos;
        presupuesto = quePresupuesto;
        acumuladoConsumo = 0;
        acumuladoMantenimiento = 0;
        gastoAgua = 0;
        gastoLuz = 0;
        mesMasConsumo = NINGUNO;
        maxConsumo = 0;
        mesMasCaro = NINGUNO;
        maxPrecio = 0;
        mesMasBarato = NINGUNO;
        minPrecio = 0;
        periodoMasMantenimiento = NINGUNO;
        maxMantenimiento = 0;
        mesMasGasto = NINGUNO;
        maxGasto = 0;
        conceptoMasGasto = NADA;
    }

    
    // TODO: getters y setters
    
    /**
     * Fija el valor del presupuesto
     * 
     * @param quePresupuesto Valor del presupuesto, ej. 38638
     */
    public void setPresupuesto(int quePresupuesto){
        presupuesto = quePresupuesto;
    }   
    /**
     * Obtiene el valor del presupuesto
     * 
     * @return valor del presupuesto, ej. 38638
     */
    public double getPresupuesto(){
        return presupuesto;
    }

    /**
     * Fija el numero de vecinos de la comunidad
     * 
     * @param queVecinos numero de vecinos, ej. 48
     */
    public void setVecinos( int queVecinos){
        vecinos = queVecinos;
    }
        /**
     * Obtiene el numero de vecinos

     * @return numero de vecinos, ej. 48
     */
    public int getVecinos(){
        return vecinos;
    }

    /**
     * Cantidad de gas consumido cada mes al precio de mercado
     * 
     * @param mes    Numero de mes, 1 es enero, 2 febrero, ..., 12 diciembre, ej. 9
     * @param gas    Cantidad de gas consumido en KWh, ej. 15496
     * @param precio Precio en Euros al que se ha conseguido el gas, ej. 0.067668
     */
    public void consumo(int mes, int gas, double precio) {
        // TODO: consumo
        double consumo = gas * precio;
        acumuladoConsumo += consumo;
        minPrecio = precio;
        if(consumo > maxConsumo){
            maxConsumo = consumo;
            mesMasConsumo = mes;
        }
        if (precio>maxPrecio){
            maxPrecio = precio;
            mesMasCaro = mes;
        }else{
            if(precio < maxPrecio){
                minPrecio = precio;
                mesMasBarato = mes;
            }
        }
        if(mes < 1 || mes > 12){
            System.out.println("Debe introducir un mes entre 1 y 12");
        }
    }

    /**
     * Gasto de mantenimiento en cada periodo
     * 
     * @param periodo Numero que representa el periodo, ej. OCTUBRE-DICIEMBRE es 1
     * @param importe Valor del gasto de mantenimiento
     */
    public void mantenimiento(int periodo, double importe) {
        // TODO: mantenimiento
        double mantenimiento = importe;
        acumuladoMantenimiento += mantenimiento;
        if(mantenimiento > maxMantenimiento){
            maxMantenimiento = mantenimiento; 
            periodo = periodoMasMantenimiento;
        }
    }

    /**
     * Gasto mensual en concepto de agua o luz.
     * 
     * @param mes      Numero del mes, ej. ENERO es 1
     * @param concepto Agua 'A' o luz 'L'
     * @param importe  Valor del gasto, ej. 189.03
     */
    public void gasto(int mes, char concepto, double importe) {
        // TODO: gasto
        double gasto = importe;
        importe = maxGasto;
        if(concepto ==  AGUA || concepto == LUZ){
            if (concepto == AGUA){
                
            }
        }else{
            if(gasto > maxGasto){
                maxGasto = gasto;
                mesMasGasto = mes;
            }  
        }
    }

    /**
     * Imprime el resultado del periodo, ej.
     * 
     * ==================
     * RESULTADO GLOBAL
     * ==================
     * Presupuesto: 38638.0
     * Consumo gas: 61688.26
     * Impuestos g.: 25909.07
     * Mantenimiento: 4157.58
     * Iva manto.: 914.67
     * Gasto agua: 2647.83
     * Iva agua: 582.52
     * Gasto luz: 4663.01
     * Iva luz: 1025.86
     * ------------------
     * TOTAL : -62950.8 Euros.
     * ------------------
     * ==================
     * RESULTADO X VECINO
     * ==================
     * Vecinos: 48
     * Aporte v.: 804.96
     * Gasto v.: 2116.43
     * Resultado: -1311.47
     * ------------------
     * El resultado ha sido NEGATIVO,
     * se tiene que pagar 1311.47 Euros.
     * El pago se pasara en
     * 5 cuotas de 262.29 Euros.
     * ------------------
     */
    public void printResultados() {
        // TODO: printResultados
        System.out.println("Presupuesto:"+ presupuesto);
        System.out.println("Consumo gas:"+ acumuladoConsumo);
        System.out.println("Impuestos g.:"+acumuladoConsumo*(1+IMP_HIDROCARBUROS)*(1+IMP_IVA));
        System.out.println("Mantenimiento:"+acumuladoMantenimiento);
        System.out.println("IVA manto.:"+acumuladoMantenimiento*(1+IMP_IVA));
        System.out.println("Gasto agua:"+maxGasto);
        System.out.println("Iva agua:"+maxGasto*(1+IMP_IVA));
        System.out.println("Gasto Luz:"+maxGasto);
        System.out.println("Iva luz:"+maxGasto*(1+IMP_IVA));
        System.out.println("TOTAL:"+(presupuesto - (acumuladoConsumo*(1+IMP_HIDROCARBUROS)*(1+IMP_IVA)-
        acumuladoMantenimiento*(1+IMP_IVA))-maxGasto*(1+IMP_IVA)-maxGasto*(1+IMP_IVA)));
        System.out.println("Vecinos:"+ vecinos);
        System.out.println("Aporte v.:"+presupuesto/vecinos);
        System.out.println("Gasto v.:"+(acumuladoMantenimiento+acumuladoConsumo)/vecinos);
        
    }

    /**
     * Imprime las estadisticas del periodo, ej.
     * 
     * ==================
     * ESTADISTICAS
     * ==================
     * Max. consumo: ENERO 12527.66
     * Mes mas caro: AGOSTO 0.202504
     * Mes mas barato: SEPTIEMBRE 0.067668
     * Mayor gasto en: ABRIL 679.94 LUZ
     * P. mas manto.: OCTUBRE-DICIEMBRE 1552.1
     * ------------------
     */
    public void printEstadisticas() {
        // TODO: printEstadisticas
    }

    /**
     * Devuelve el nombre del mes asociado a su valor numerico
     * 
     * @param numMes Numero del mes del 1 al 12, ej. 1
     * @return Nombre del mes, ej. ENERO
     */
    public String getNombreMes(int numMes) {
        // TODO: getNombreMes
        String strNumMes = "";
        switch ( numMes ) {
            case 1: strNumMes = "ENERO"; break;
            case 2: strNumMes = "FEBRERO" ; break;
            case 3: strNumMes = "MARZO"; break;
            case 4: strNumMes = "ABRIL"; break;
            case 5: strNumMes = "MAYO"; break;
            case 6: strNumMes = "JUNIO"; break;
            case 7: strNumMes = "JULIO"; break;
            case 8: strNumMes = "AGOSTO"; break;
            case 9: strNumMes = "SEPTIEMPRE"; break;
            case 10: strNumMes = "OCTUBRE"; break;
            case 11: strNumMes = "NOVIEMBRE"; break;
            case 12: strNumMes = "DICIEMBRE"; break;
            default: strNumMes = "NINGUNO"; break;
            
        }
        return strNumMes;        
    }

    /**
     * Devuelve el nombre del concepto asociado al caracter
     * 
     * @param concepto Valor caracter, ej. 'L'
     * @return Nombre del concepto, ej. 'LUZ'. Si no es agua o luz devuelve "NADA"
     */
    public String getNombreConcepto(char concepto) {
        // TODO: getNombreConcepto
        String strConcepto = "";
        if(concepto == 'L'){
            strConcepto = "LUZ";
        }
        else if(concepto == 'A'){
            strConcepto = "AGUA";
        }
        else if(concepto == 'N'){
            strConcepto = "NADA";
        }
        return strConcepto;        
    }

    /**
     * Devuelve el nombre del periodo asociado a su numero
     * 
     * @param numPeriodo Numero de periodo, del 1 al 4, ej. 4
     * @return Nombre del periodo con nombres de los meses separados por guion, ej.
     *         "OCTUBRE-DICIEMBRE". Sino devuelve "NINGUN PERIODO"
     */
    public String getNombrePeriodo(int numPeriodo) {
        // TODO: getNombrePeriodo
        String strNumPeriodo = "";
        switch(numPeriodo){
            case 1 : strNumPeriodo = "OCTUBRE-DICIEMBRE"; break;
            case 2 : strNumPeriodo = "ENERO-MARZO"; break;
            case 3 : strNumPeriodo = "ABRIL-JUNIO"; break;
            case 4 : strNumPeriodo = "JULIO-SEPTIEMBRE"; break;
            default: strNumPeriodo = "NINGUN PERIODO"; break;
        }
        return strNumPeriodo;        
    }

    /**
     * Analiza el resultado, si el valor es negativo se tendra que pagar si es
     * positivo se devolvera.
     * En el caso negativo se debera pagar de una vez si el importe en menor o igual
     * que 200,
     * en multiplos de 200 y el resto si el resultado es menor o igual que 600 o
     * en 5 partes alicuotas sino.
     * 
     * @param resultado cantidad positiva o negativa, ej. -1311.47
     * @return Mensaje con la informacion sobre el pago. Ej.
     *         </br>
     *         El resultado ha sido NEGATIVO,
     *         se tiene que pagar 114.56 Euros.
     *         El pago se pasara en un solo cobro.
     *         </br>
     *         El resultado ha sido NEGATIVO,
     *         se tiene que pagar 513.33 Euros.
     *         El pago se pasara en
     *         2 cuotas de 200 Euros y
     *         otro cobro de 113.33 Euros.
     *         </br>
     *         El resultado ha sido NEGATIVO,
     *         se tiene que pagar 1311.47 Euros.
     *         El pago se pasara en
     *         5 cuotas de 262.29 Euros.
     *         </br>
     *         El resultado ha sido POSITIVO,
     *         se devolvera 45.52 Euros.
     *         El pago se realizara en breve en
     *         una transferencia.
     */
    public String analisisResultado(double resultado) {
        // TODO: analisisResultado
        return "";
    }

    /**
     * Redondea un valor de tipo double a dos decimales.
     * Al imprimirlo se vera al menos un decimal y como mucho dos.
     *
     * @param valor Numero con decimales de tipo double
     * @return Redondeo con 1 o 2 decimales, ej.
     *         38638 -> 38638.0
     *         61688.255730000004 -> 61688.26
     *         25909.067406600003 -> 25909.07
     *         -62950.79553660001 -> -62950.8
     *         -1311.4749070125 -> -1311.47
     */
    public double redondeo2decimales(double valor) {
        // TODO: redondeo2decimales
        return  Math.round(valor * 100.0)/100.0;
    }

    /**
     * Divide un numero decimal entre un numero entero y devuelve el resultado
     * entero.
     * 
     * @param dividendo Numero con decimales que se divide, ej. 647.55
     * @param divisor   Numero entero que divide, ej. 200
     * @return Cociente, numero entero, cuantos divisores caben en el dividendo, ej.
     *         3
     */
    public int divisionEntera(double dividendo, int divisor) {
        // TODO: divisionEntera
        return 0;
    }

    /**
     * Divide un numero decimal entre un numero entero y devuelve el resto con
     * decimales.
     * 
     * @param dividendo Numero con decimales que se divide, ej. 647.55
     * @param divisor   Numero entero que divide, ej. 200
     * @return Resto con decimales, ej. 47.55
     */
    public double restoDivisionEntera(double dividendo, int divisor) {
        // TODO: restoDivisionEntera
        return 0;
    }

}
