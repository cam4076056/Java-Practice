/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 * Clase NCuadratica
 * 
 * Representa la lógica para trabajar con funciones cuadráticas
 * de la forma:
 * 
 *      f(x) = ax² + bx + c
 * 
 * Permite:
 * - Hallar los cortes con el eje X
 * - Hallar el vértice de la función
 * - Determinar la concavidad de la parábola
 * - Evaluar la función en un punto dado
 * 
 * El resultado de cada operación se almacena como String.
 * 
 * @author Christian Mendez
 */
public class NCuadratica {

    /**
     * Coeficiente cuadrático (a).
     */
    private double terminoA;

    /**
     * Coeficiente lineal (b).
     */
    private double terminoB;

    /**
     * Término independiente (c).
     */
    private double terminoC;

    /**
     * Valor de x para evaluar la función.
     */
    private double terminoX;

    /**
     * Resultado de las operaciones, almacenado como String.
     */
    private String resultado;

    /**
     * Constructor vacío.
     * Inicializa la clase sin valores asignados.
     */
    public NCuadratica(){
        
    }

    /**
     * Constructor con parámetros.
     * Permite inicializar todos los términos de la función cuadrática.
     * 
     * @param a coeficiente cuadrático
     * @param b coeficiente lineal
     * @param c término independiente
     * @param x valor de x a evaluar
     * @param r resultado inicial
     */
    public NCuadratica(double a, double b, double c, double x, String r){
        this.terminoA = a;
        this.terminoB = b;
        this.terminoC = c;
        this.terminoX = x;
        this.resultado = r;
    }

    /**
     * Obtiene el coeficiente cuadrático.
     * 
     * @return terminoA
     */
    public double getTerminoA(){
        return this.terminoA;
    }

    /**
     * Asigna el coeficiente cuadrático.
     * 
     * @param a valor del coeficiente cuadrático
     */
    public void setTerminoA(double a){
        this.terminoA = a;
    }

    /**
     * Obtiene el coeficiente lineal.
     * 
     * @return terminoB
     */
    public double getTerminoB(){
        return this.terminoB;
    }

    /**
     * Asigna el coeficiente lineal.
     * 
     * @param b valor del coeficiente lineal
     */
    public void setTerminoB(double b){
        this.terminoB = b;
    }

    /**
     * Obtiene el término independiente.
     * 
     * @return terminoC
     */
    public double getTerminoC(){
        return this.terminoC;
    }

    /**
     * Asigna el término independiente.
     * 
     * @param c valor del término independiente
     */
    public void setTerminoC(double c){
        this.terminoC = c;
    }

    /**
     * Obtiene el valor de x.
     * 
     * @return terminoX
     */
    public double getTerminoX(){
        return this.terminoX;
    }

    /**
     * Asigna el valor de x.
     * 
     * @param x valor a evaluar en la función
     */
    public void setTerminoX(double x){
        this.terminoX = x;
    }

    /**
     * Obtiene el resultado actual.
     * 
     * @return resultado
     */
    public String getResultado(){
        return this.resultado;
    }

    /**
     * Asigna el resultado manualmente.
     * 
     * @param r resultado en formato String
     */
    public void setResultado(String r){
        this.resultado = r;
    }

    /**
     * Halla los cortes de la función cuadrática con el eje X.
     * Utiliza el discriminante de la ecuación cuadrática.
     * 
     * @return resultado con las soluciones encontradas
     */
    public String hallarCortes(){
        double discriminante;
        discriminante = ((Math.pow(this.terminoB, 2)) - 4 * (this.terminoA * this.terminoC));

        if (discriminante > 0) {
            double solA;
            double solB;
            solA = (((-this.terminoB) + discriminante) / (2 * this.terminoA));
            solB = (((-this.terminoB) - discriminante) / (2 * this.terminoA));
            this.resultado = solA + " , " + solB;
        } else {
            if (discriminante < 0) {
                this.resultado = "Sin solución en los reales";
            } else {
                double sol;
                sol = ((-this.terminoB) / (2 * this.terminoA));
                this.resultado = sol + "";
            }
        }
        return this.resultado;
    }

    /**
     * Calcula el vértice de la función cuadrática.
     * Devuelve las coordenadas (x, f(x)).
     * 
     * @return resultado con las coordenadas del vértice
     */
    public String hallarVertice(){
        double vertice;
        vertice = ((-this.terminoB) / (2 * this.terminoA));

        double fvertice;
        fvertice = ((this.terminoA * Math.pow(vertice, 2)) + (this.terminoB * vertice) + this.terminoC);

        this.resultado = vertice + " , " + fvertice;
        return this.resultado;
    }

    /**
     * Determina la forma o concavidad de la parábola.
     * 
     * @return mensaje indicando si la función abre hacia arriba o hacia abajo
     */
    public String hallarForma(){
        double forma;
        forma = (2 * this.terminoA);

        if (forma > 0) {
            return "La funcion va hacia arriba";
        } else {
            return "La funcion va hacia abajo";
        }
    }

    /**
     * Evalúa la función cuadrática en el punto x.
     * 
     * @return resultado de f(x)
     */
    public String evaluarPunto(){
        double fx;
        fx = ((this.terminoA * Math.pow(this.terminoX, 2)) + (this.terminoB * this.terminoX) + this.terminoC);
        this.resultado = fx + "";
        return this.resultado;
    }

    /**
     * Devuelve el resultado como representación en texto del objeto.
     * 
     * @return resultado
     */
    @Override
    public String toString(){
        return this.resultado;
    }
}
