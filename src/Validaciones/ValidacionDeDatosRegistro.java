/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validaciones;

import Validaciones.*;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author cashd
 */
public class ValidacionDeDatosRegistro {
    private boolean[] abecedario = new boolean[256];
    public ValidacionDeDatosRegistro() {
    }

    private void numerosValidos(){
        for (int i= 48; i < 58; i++){
            abecedario[i] = true;
        }
    }

    private void numerosInvalidos(){
        for (int i= 48; i < 58; i++){
            abecedario[i] = false;
        }
    }
    /**
     * Asigna un valor de verdadero a las posiciones donde se encuentren 
     * las vocales con acentos,tanto mayúsculas como minúsculas, incluye ü y Ü
     */
    private void acentosValidos(){
        abecedario[225] = true;
        abecedario[233] = true;
        abecedario[237] = true;
        abecedario[243] = true;
        abecedario[250] = true;
        abecedario[193] = true;
        abecedario[201] = true;
        abecedario[205] = true;
        abecedario[211] = true;
        abecedario[218] = true;
        abecedario[250] = true;
        abecedario[252] = true;
    }
    /**
     * Asigna un valor de falso a las posiciones donde se encuentren 
     * las vocales con acentos,tanto mayúsculas como minúsculas, incluye ü y Ü
     */
    private void acentosInvalidos(){
        abecedario[225] = false;
        abecedario[233] = false;
        abecedario[237] = false;
        abecedario[243] = false;
        abecedario[250] = false;
        abecedario[193] = false;
        abecedario[201] = false;
        abecedario[205] = false;
        abecedario[211] = false;
        abecedario[218] = false;
        abecedario[250] = false;
        abecedario[252] = false;
    }
    /**
     * Asigna un valor de verdadero solo a los números, los demás caracteres 
     * quedan inválidos (con valor falso)
     */
    private void soloNumeros(){
        numerosValidos();
        acentosInvalidos();
        for (int i = 65; i<=90; i++){
            abecedario[i] = false;
        }
        for (int i = 97; i <= 122; i++){
            abecedario[i] = false;
        }
        abecedario[241] = false;
        abecedario[209] = false;
    }
    /**
     * Asigna un valor de verdadero solo a las letras, tanto mayúsculas como 
     * minúsculas, incluye 'ñ' y 'Ñ'
     */
    public void letras(){
        for (int i = 65; i<=90; i++){
            abecedario[i] = true;
        }
        for (int i = 97; i <= 122; i++){
            abecedario[i] = true;
        }
        abecedario[241]=true;
        abecedario[209]=true;
    }

    public boolean validarLongitudDeCadena (String cadenaAEvaluar){
        boolean longitudAceptable = true;
        if (cadenaAEvaluar.length() < 1 || cadenaAEvaluar.length() > 50){
            longitudAceptable = false;
        }
        return longitudAceptable;
    }
    public boolean validarLongitudMatricula (String cadenaAEvaluar){
        boolean longitudAceptable = true;
        if (cadenaAEvaluar.length() < 1 || cadenaAEvaluar.length() > 9){
            longitudAceptable = false;
        }
        return longitudAceptable;
    }
    public boolean validarLongitudDescripcion (String cadenaAEvaluar){
        boolean longitudAceptable = true;
        if (cadenaAEvaluar.length() < 1 || cadenaAEvaluar.length() > 250){
            longitudAceptable = false;
        }
        return longitudAceptable;
    }
    public boolean validarMayusculasMinusculasAcentos (String cadenaAEvaluar){
        acentosValidos();
        numerosInvalidos();
        letras();
        /**
         * ASCII 32 = espacio
         */
        abecedario[32] = true;
        boolean cadenaValida = true;
        for (int i = 0; i < cadenaAEvaluar.length() && cadenaValida == true; i++){
            if(abecedario[cadenaAEvaluar.charAt(i)] == false){
                cadenaValida=false;
            }
        }
        return cadenaValida;
    }

    /**
     * Verifica que una cadena incluya los caracteres permitidos en una dirección 
     * de correo electrónico ({'.', '_', '-', '@'}, números y letras), que no 
     * incluya acentos ni espacios.
     * @param correoAEvaluar
     * @return true si la cadena pasa los criterios, 
     *              false en caso contrario.
     */
    public boolean validarCorreoElectronico (String correoAEvaluar){
        /**
         * ASCII 46 = '.'
         * ASCII 45 = '_'
         * ASCII 95 = '-'
         * ASCII 64 = '@'
         * ASCII 32 = espacio
         */
        abecedario[46] = true;
        abecedario[45] = true;
        abecedario[95] = true;
        abecedario[64] = true;
        abecedario[32] = false;
        numerosValidos();
        acentosInvalidos();
        letras();
        boolean cadenaValida = true;
        for (int i = 0; i < correoAEvaluar.length() && cadenaValida == true; i++){
            if(abecedario[correoAEvaluar.charAt(i)] == false){
                cadenaValida=false;
            }
        }
        abecedario[46] = false;
        abecedario[45] = false;
        abecedario[95] = false;
        abecedario[64] = false;
        return cadenaValida;
    }
    /**
     * Verifica que todos los elementos de una cadena sean números para formar 
     * un entero
     * @param cadenaAEvaluar
     * @return Un entero con los números que tenía la cadena si esta solo tenía números, 
     *                  -1 si había un caractér diferente a {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
     */
    public int validarNumeros(String cadenaAEvaluar){
        soloNumeros();
        boolean cadenaValida = true;
        for (int i = 0; i < cadenaAEvaluar.length() && cadenaValida == true; i++){
            if(abecedario[cadenaAEvaluar.charAt(i)] == false){
                cadenaValida=false;
            }
        }
        int entero = -1;
        
        if (cadenaValida){
            entero = Integer.valueOf(cadenaAEvaluar);
        }
        return entero;
    }
    
}
