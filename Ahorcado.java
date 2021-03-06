import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) {

        //Bienvenida
        System.out.println("\t *******************************************************  \n \t ********    Bienvenido al Juego de Ahorcado    ******** \n \t ******************************************************* \n");
        System.out.println("\t Autores: \n \t \t Melissa Arce \n \t \t Fernanda Lizano \n \t \t Paulina Vargas \n");
        System.out.println("\t Tienes 6 intentos para adivinar la palabra \n");


        /*INICIALIZAR VARIABLES
        * intentos > cantidad de intentos/oprtunidades de fallar
        * continuar > mientras continuar sea true, el loop se repetirá para continuar jugando hasta perder o ganar
        * secuecnia > indice para saber qué secuencia imprimir en el dibujo del ahorcado
        * sec* > son los dibujos con las secuencias
        * */
        int intentos = 6;
        boolean continuar = true;
        char[] fallos = {'-','-','-','-','-','-'};

        int secuencia = 0;

        String sec0 = "Juego del Ahorcado \n " +
                "_ _ _ _ _ \n" +
                "|/       \n" +
                "|        \n" +
                "|        \n" +
                "|        \n" +
                "|        \n" +
                "|        \n" +
                "|        \n" +
                "|_____   \n";

        String sec1 = "Juego del Ahorcado \n " +
                "_ _ _ _ _ \n" +
                "|/      |    \n" +
                "|     ( _ )   \n" +
                "|        \n" +
                "|        \n" +
                "|        \n" +
                "|        \n" +
                "|        \n" +
                "|_____   \n";

        String sec2 = "Juego del Ahorcado \n " +
                "_ _ _ _ _ \n" +
                "|/      |        \n" +
                "|     (x_ )     \n" +
                "|        \n" +
                "|        \n" +
                "|        \n" +
                "|_____   \n";

        String sec3 = "Juego del Ahorcado \n " +
                "_ _ _ _ _ \n" +
                "|/      | \n" +
                "|     (x_x) \n" +
                "|        \n" +
                "|        \n" +
                "|        \n" +
                "|_____   \n";

        String sec4 = "Juego del Ahorcado \n " +
                "_ _ _ _ _ \n" +
                "|/      | \n" +
                "|     (x_x)       \n" +
                "|     ==|==        \n" +
                "|       |        \n" +
                "|        \n" +
                "|_____   \n";

        String sec5 = "Juego del Ahorcado \n " +
                "_ _ _ _ _ \n" +
                "|/      | \n" +
                "|     (x_x)       \n" +
                "|     ==|==      \n" +
                "|       |        \n" +
                "|         )     \n" +
                "|_____   \n";

        String end = "Juego del Ahorcado \n " +
                "_ _ _ _ _ \n" +
                "|/      | \n" +
                "|     (x_x)       \n" +
                "|     ==|==     \n" +
                "|       |        \n" +
                "|     (   )     \n" +
                "|                \n" +
                "|_____   \n";

        String win = "  .                 .                .   . .     .  \n" +
                "                   .                    .       .     * .      .    .     . .   \n" +
                "  .       *                        . . . .  o.   .  + . .      .    .     . .   \n" +
                "       Felicidades!           .   .  +  . . .\n" +
                ".            |Has Ganado             .  .   .    .    . . .  o    .    .     . .   \n" +
                "                  |el juego!           .     .     . +.    +  . .      .    .     . .   \n" +
                "         *                     .       . . .  +    .  .  . .  +    .  .    . .\n" +
                "    . .  +    .           .      . .                 .    * . . .  .  +   .\n" +
                "           +      .           .   .      +\n" +
                "                            .       . +  .+. .. + .  .      .    .     . .    \n" +
                "  .                      .     . + .  . .     .      . .      .    .     . .   \n" +
                "          o .      .    .     . .   o. . .        | /.  *   .  *  . +..  .     \n" +
                "      *             .    . .  +    .  .       - o -.    . .  +  \n" +
                "          .     .    .  +   . .  *  .       . / |  .    .  +   . .  *\n" +
                "               . + .  .  .  .. +  .\n" +
                ".      .  .  .  *   .  *  . +..  .            *\n" +
                " .      .   . .   .   .   . .  +   .    .            ";

        /*SELECCIONAR PALABRA
         * crear array de posible palabras
         * escoger aleatoriamente una palabra con la funcion escogerPalabra
         * convertir la palabra a un array de caracteres char[] con la funcion palabraArray
         * crear un array secundario con la misma cantidad de char donde se irá almacenando la palabra
         * */
        String[] basePalabras = {"lapiz", "manzana", "reloj", "agua", "automovil", "azul", "flores"};
        int min = 0;

        int max = basePalabras.length-1;

        char[] arregloSolucion = palabraArray(escogerPalabra(basePalabras, numeroRandom(min,max)));

        char[] arregloRespuesta = new char[arregloSolucion.length];
        for(int i = 0; i < arregloSolucion.length; i++){
            arregloRespuesta[i] = '-';
        }

        /*LOOP DEL JUEGO
         * dentro de un while para que se repita hasta que el usuario gane o pierda
         * */
        while(continuar){

            //imprimir intro y avance de respuesta
            System.out.println("\n \t ******************************** \n \t ********    Ahorcado    ******** \n \t ******************************** \n");
            System.out.printf("\t Adivinado: ");
            System.out.println(arregloRespuesta);
            System.out.printf("\t Letras perdidas: ");
            System.out.println(fallos);
            System.out.println("\t Intentos restantes: " + intentos + "\n");

            //imprimir secuencia
            switch(secuencia) {
                case 0:
                    // Secuencia donde inicia el juego
                    // el arte ha sido almacenado en variables para evitar que se muevan o desordenen.
                    System.out.println(sec0);
                    break;
                case 1:
                    // ha perdido una vida, resta un intento
                    System.out.println(sec1);
                    break;
                case 2:
                    // ha perdido una vida, resta un intento
                    System.out.println(sec2);
                    break;
                case 3:
                    // ha perdido una vida, resta un intento
                    System.out.println(sec3);
                    break;
                case 4:
                    // ha perdido una vida, resta un intento
                    System.out.println(sec4);
                    break;
                case 5:
                    // ha perdido una vida, resta un intento
                    System.out.println(sec5);
                    break;
                case 777: //ganar + se imprimen estrellitas en celebracion wooo!
                    System.out.println(win);
                    continuar = false;
                    break;
                case 707: //perder + se imprime el asesinado :(
                    System.out.println(end);
                    continuar = false;
                    break;
                default:
                    //POR EJEMPLO
                    System.out.println(sec0);
                    break;
            }


            //se compara elemento por elemento de cada array
            boolean arrayIgual = true;
            for(int i = 0; i < arregloSolucion.length; i++){
                if(arregloRespuesta[i] != arregloSolucion[i]){
                    arrayIgual = false;
                }
            }

            //si son iguales, el usuario gana
            if(arrayIgual){
                secuencia = 777;
            }

            //de lo contrario, se verifica que el usuario aun tenga intentos
            //si intentos = 0, el usuario pierde
            else if(intentos == 0){
                secuencia = 707;
            }

            //si ninguna de las anteriores condiciones se cumplió, continua el juego
            else{

                //solicitar al usuario una letra con la funcion letraEscogida
                char letra = letraEscogida();

                //buscar si la letra está en el arreglo
                boolean isInArray = false;
                for (int i = 0; i< arregloSolucion.length; i++){
                    if(letra == arregloSolucion[i]){
                        arregloRespuesta[i] = letra;
                        isInArray = true;
                    }
                }

                //si la letra no esta, se disminuyen los intentos y se pasa a la siguinete secuencia de dibujo
                if(!isInArray){
                    fallos[secuencia] = letra;
                    intentos -= 1;
                    secuencia += 1;
                }

            }
        }


    }

    /* ESCOGER UN NUMERO ALEATORIO
     * escoger numerp que este dentro del rango [min, max]
     * */
    private static int numeroRandom(int min, int max) {

        min = (int) Math.ceil(min);
        max = (int) Math.floor(max);
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    /* ESCOGER PALABRA
     * utilizar un numero aleatorio para escoger el inidice del array
     * con el numero random escogido selecciona la palabra en esa posición
     * */
    private static String escogerPalabra (String[] basePalabras, int numeroRandom){

        String palabraEscogida = basePalabras[numeroRandom];
        return palabraEscogida;
    }

    /* CONVERTIR PALABRA ESCOGIDA A ARRAY DE CARACTERES
     * convertir string a array de caracteres char[]
     * */
    private static char[] palabraArray(String palabraEscogida) {
        char[] arreglo1 = palabraEscogida.toCharArray();
        return arreglo1;
    }

    /* SOLICITAR LETRA AL USUARIO
     * Scanner para solicitar input de usuario
     * convertir ese input a un caracter
     * NOTA: si el usuairo ingresa mas de un caracter, solo se toma como opcion el primer caracter (posicion 0) con charAt(0)
     * Los demas caracteres se ignoran
     * */
    private static char letraEscogida(){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Digite una letra: ");
        char letra1 = scanner.next().charAt(0);
        return letra1;
    }
}
