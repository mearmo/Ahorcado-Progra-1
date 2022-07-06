import java.util.Iterator;

public class Ahorcado {
    public static void main(String[] args) {
        //inicializar variables

        int intentos = 5;
        boolean continuar = true;
        int secuencia = 0;

        //Crear lista y escoger palabra aleatoria
        String[] arreglo1 = {"-","-","-","-"}; //ejemplo temporal
        String[] arreglo2 = {"h","o","l","a"}; //ejemplo temporal


        while(continuar){
            //imprimir arreglo
            for (int i = 0; i< arreglo1.length; i++){ //ejemplo temporal
                System.out.println(arreglo1[i]);      //ejemplo temporal
            }
            //imprimir secuencia

            if(arreglo1 == arreglo2){
                //ganar
                System.out.println("Ganar");        //ejemplo temporal
                continuar = false;
            }
            else if(intentos == 0){
                //morir
                System.out.println("Morir");        //ejemplo temporal
                continuar = false;
            }
            else{
                //solicitar al usuario letra
                String letra = "p";                 //ejemplo temporal
                boolean isInArray = false;
                //buscar si la letra está en el arreglo
                for (int i = 0; i< arreglo2.length; i++){
                    if(letra == arreglo2[i]){
                        arreglo1[i] = letra;
                        isInArray = true;
                    }
                }

                if(!isInArray){
                    intentos -= 1;
                    secuencia += 1;
                }

            }
        }


    }
}
