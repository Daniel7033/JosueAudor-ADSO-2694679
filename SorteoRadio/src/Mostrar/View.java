package Mostrar;

import Entity.Artista;
import Entity.Canciones;
import Entity.Colores;
import Entity.Encuesta;
import Utils.FunctionNumeric;
import Utils.FunctionString;

public class View {

    public static void main(String[] args) {
        FunctionString fs = new FunctionString();
        FunctionNumeric fn = new FunctionNumeric();
        int a = 0, b = 0, cantidad = 10, rango = 10;
        int arreglo[] = new int[cantidad];
//******************************************************
        Integer o;
        Encuesta encuesta[] = new Encuesta[o = fn.InputIntegerNumericPositiveScanner("Cantidad de los participantes: ")];
        /*  ****************************************************
ARRAY DE LOS COLORES DE LAS BOLETAS*********************/
        Colores color[] = new Colores[o];
        for (int i = 0; i < color.length; i++) {
            color[i] = new Colores(i, "#FF000");
        }
//*******************************************************
        for (int i = 0; i < encuesta.length; i++) {
//SE GENERA UN NUMERO DE BOLETA ALEATOREAMENTE***********
            for (a = 0; a < cantidad; a++) {
                arreglo[a] = (int) (Math.random() * rango);
                for (int j = 0; j < a; j++) {
                    if (arreglo[a] == arreglo[j]) {
                        a--;
                    }
                }
            }
            for (b = 0; a < cantidad; a++) {
                arreglo[b] = (int) (Math.random() * rango);
                for (int j = 0; j < b; j++) {
                    if (arreglo[b] == arreglo[j]) {
                        b--;
                    }
                }
            }
            /**
             * ********************************************************
             * ARRAY DEL REGISTRO DE LOS PARTICIPANTES
             */
            encuesta[i] = new Encuesta(fn.InputIntegerNumericPositiveScanner("ID: "), fs.InputScanner("Nombre: "), fs.InputScanner("Apellido: "), arreglo[b], fs.InputScanner("Dirección: "), color[i].getColor());
            /**
             * ********************************************************
             * ARRAY DE LA LISTA DE LOS ARITSTAS
             */
            fs.ShowScanner("Artistas");
            Artista artista[] = new Artista[5];
            artista[0] = new Artista(1, "Artista 1");
            artista[1] = new Artista(2, "Artista 2");
            artista[2] = new Artista(3, "Artista 3");
            artista[3] = new Artista(4, "Artista 4");
            artista[4] = new Artista(5, "Artista 5");
            fs.ShowScanner("\n");
            for (Artista artista1 : artista) { //for (int i = 0; i < artista.length; i++) {
                fs.ShowScanner(artista1.getIdArtista() + " - " + artista1.getNombreArtista() + ".\n");
            }
            /**
             * ****************************************************************************************************************
             * SELECCIONAR EL ARTISTA PARA ACCEDER A SUS CANCIONES
             */
            int art = fn.InputIntegerNumericRangeScanner("Escribe el número del artista ", 1.0, 5.0);
            /**
             * ****************************************************************************************************************
             * ARRAY DE CANCIONES DE CADA ARTISTA
             */
            switch (art) {
//CANCIONES ARTISTA 1
                case 1 -> {
                    Canciones cancionesArtista1[] = new Canciones[5];
                    cancionesArtista1[0] = new Canciones(31, artista[0].getIdArtista(), "Canción a");
                    cancionesArtista1[1] = new Canciones(32, artista[0].getIdArtista(), "Cancion b");
                    cancionesArtista1[2] = new Canciones(33, artista[0].getIdArtista(), "Cancion c");
                    cancionesArtista1[3] = new Canciones(34, artista[0].getIdArtista(), "Cancion d");
                    cancionesArtista1[4] = new Canciones(35, artista[0].getIdArtista(), "Cancion e");
                    for (Canciones cancion1 : cancionesArtista1) {
                        fs.ShowScanner("Canción " + cancion1.getIdCancion() + " - " + cancion1.getCancion() + " Artista: " + cancion1.getIdArtista() + ".\n");
                    }
                    for (int j = 1; j < 4; j++) {
                        int can = fn.InputIntegerNumericRangeScanner("Selecciones sus canciones favoritas \n", 31.0, 35.0);
                        switch (can) {
                            case 31 -> {
                                if (can == cancionesArtista1[0].getIdCancion()) {
                                    fs.ShowScanner("Fav " + j + " - " + cancionesArtista1[0].getIdCancion() + " " + cancionesArtista1[0].getCancion() + "\n");
                                }
                            }
                            case 32 -> {
                                if (can == cancionesArtista1[1].getIdCancion()) {
                                    fs.ShowScanner("Fav " + j + " - " + cancionesArtista1[1].getIdCancion() + " " + cancionesArtista1[1].getCancion() + "\n");
                                }
                            }
                            case 33 -> {
                                if (can == cancionesArtista1[2].getIdCancion()) {
                                    fs.ShowScanner("Fav " + j + " - " + cancionesArtista1[2].getIdCancion() + " " + cancionesArtista1[2].getCancion() + "\n");
                                }
                            }
                            case 34 -> {
                                if (can == cancionesArtista1[3].getIdCancion()) {
                                    fs.ShowScanner("Fav " + j + " - " + cancionesArtista1[3].getIdCancion() + " " + cancionesArtista1[3].getCancion() + "\n");
                                }
                            }
                            case 35 -> {
                                if (can == cancionesArtista1[4].getIdCancion()) {
                                    fs.ShowScanner("Fav " + j + " - " + cancionesArtista1[4].getIdCancion() + " " + cancionesArtista1[4].getCancion() + "\n");
                                }
                            }
                            default -> {
                            }
                        }
                    }
                }
//CANCIONES ARTISTA 2                
                case 2 -> {
                    Canciones[] cancionesArtista2 = new Canciones[5];
                    cancionesArtista2[0] = new Canciones(36, artista[1].getIdArtista(), "Canción f");
                    cancionesArtista2[1] = new Canciones(37, artista[1].getIdArtista(), "Canción g");
                    cancionesArtista2[2] = new Canciones(38, artista[1].getIdArtista(), "Canción h");
                    cancionesArtista2[3] = new Canciones(39, artista[1].getIdArtista(), "Canción i");
                    cancionesArtista2[4] = new Canciones(40, artista[1].getIdArtista(), "Canción j");
                    for (Canciones cancion1 : cancionesArtista2) {
                        fs.ShowScanner("Cancion " + cancion1.getIdCancion() + " - " + cancion1.getCancion() + " Artista: " + cancion1.getIdArtista() + ".\n");
                    }
                    for (int j = 1; j < 4; j++) {
                        int can = fn.InputIntegerNumericRangeScanner("Selecciones sus canciones favoritas \n", 36.0, 40.0);
                        switch (can) {
                            case 36 -> {
                                if (can == cancionesArtista2[0].getIdCancion()) {
                                    fs.ShowScanner("Fav " + j + " - " + cancionesArtista2[0].getIdCancion() + " " + cancionesArtista2[0].getCancion() + "\n");
                                }
                            }
                            case 37 -> {
                                if (can == cancionesArtista2[1].getIdCancion()) {
                                    fs.ShowScanner("Fav " + j + " - " + cancionesArtista2[1].getIdCancion() + " " + cancionesArtista2[1].getCancion() + "\n");
                                }
                            }
                            case 38 -> {
                                if (can == cancionesArtista2[2].getIdCancion()) {
                                    fs.ShowScanner("Fav " + j + " - " + cancionesArtista2[2].getIdCancion() + " " + cancionesArtista2[2].getCancion() + "\n");
                                }
                            }
                            case 39 -> {
                                if (can == cancionesArtista2[3].getIdCancion()) {
                                    fs.ShowScanner("Fav " + j + " - " + cancionesArtista2[3].getIdCancion() + " " + cancionesArtista2[3].getCancion() + "\n");
                                }
                            }
                            case 40 -> {
                                if (can == cancionesArtista2[4].getIdCancion()) {
                                    fs.ShowScanner("Fav " + j + " - " + cancionesArtista2[4].getIdCancion() + " " + cancionesArtista2[4].getCancion() + "\n");
                                }
                            }
                            default -> {
                            }
                        }
                    }
                }
//CANCIONES ARTISTA 3                
                case 3 -> {
                    Canciones[] cancionesArtista3 = new Canciones[5];
                    cancionesArtista3[0] = new Canciones(41, artista[2].getIdArtista(), "Canción k");
                    cancionesArtista3[1] = new Canciones(42, artista[2].getIdArtista(), "Canción l");
                    cancionesArtista3[2] = new Canciones(43, artista[2].getIdArtista(), "Canción m");
                    cancionesArtista3[3] = new Canciones(44, artista[2].getIdArtista(), "Canción n");
                    cancionesArtista3[4] = new Canciones(45, artista[2].getIdArtista(), "Canción enhe");
                    for (Canciones cancion1 : cancionesArtista3) {
                        fs.ShowScanner("Cancion " + cancion1.getIdCancion() + " - " + cancion1.getCancion() + " Artista: " + cancion1.getIdArtista() + ".\n");
                    }
                    for (int j = 1; j < 4; j++) {
                        int can = fn.InputIntegerNumericRangeScanner("Selecciones sus canciones favoritas \n", 41.0, 45.0);
                        switch (can) {
                            case 41 -> {
                                if (can == cancionesArtista3[0].getIdCancion()) {
                                    fs.ShowScanner("Fav " + j + " - " + cancionesArtista3[0].getIdCancion() + " " + cancionesArtista3[0].getCancion() + "\n");
                                }
                            }
                            case 42 -> {
                                if (can == cancionesArtista3[1].getIdCancion()) {
                                    fs.ShowScanner("Fav " + j + " - " + cancionesArtista3[1].getIdCancion() + " " + cancionesArtista3[1].getCancion() + "\n");
                                }
                            }
                            case 43 -> {
                                if (can == cancionesArtista3[2].getIdCancion()) {
                                    fs.ShowScanner("Fav " + j + " - " + cancionesArtista3[2].getIdCancion() + " " + cancionesArtista3[2].getCancion() + "\n");
                                }
                            }
                            case 44 -> {
                                if (can == cancionesArtista3[3].getIdCancion()) {
                                    fs.ShowScanner("Fav " + j + " - " + cancionesArtista3[3].getIdCancion() + " " + cancionesArtista3[3].getCancion() + "\n");
                                }
                            }
                            case 45 -> {
                                if (can == cancionesArtista3[4].getIdCancion()) {
                                    fs.ShowScanner("Fav " + j + " - " + cancionesArtista3[4].getIdCancion() + " " + cancionesArtista3[4].getCancion() + "\n");
                                }
                            }
                            default -> {
                            }
                        }
                    }
                }
//CANCIONES ARTISTA 4                
                case 4 -> {
                    Canciones[] cancionesArtista4 = new Canciones[5];
                    cancionesArtista4[0] = new Canciones(46, artista[3].getIdArtista(), "Canción o");
                    cancionesArtista4[1] = new Canciones(47, artista[3].getIdArtista(), "Canción p");
                    cancionesArtista4[2] = new Canciones(48, artista[3].getIdArtista(), "Canción q");
                    cancionesArtista4[3] = new Canciones(49, artista[3].getIdArtista(), "Canción r");
                    cancionesArtista4[4] = new Canciones(50, artista[3].getIdArtista(), "Canción s");
                    for (Canciones cancion1 : cancionesArtista4) {
                        fs.ShowScanner("Cancion " + cancion1.getIdCancion() + " - " + cancion1.getCancion() + " Artista: " + cancion1.getIdArtista() + ".\n");
                    }
                    for (int j = 1; j < 4; j++) {
                        int can = fn.InputIntegerNumericRangeScanner("Selecciones sus canciones favoritas \n", 46.0, 50.0);

                        switch (can) {
                            case 46 -> {
                                if (can == cancionesArtista4[0].getIdCancion()) {
                                    fs.ShowScanner("Fav " + j + " - " + cancionesArtista4[0].getIdCancion() + " " + cancionesArtista4[0].getCancion() + "\n");
                                }
                            }
                            case 47 -> {
                                if (can == cancionesArtista4[1].getIdCancion()) {
                                    fs.ShowScanner("Fav " + j + " - " + cancionesArtista4[1].getIdCancion() + " " + cancionesArtista4[1].getCancion() + "\n");
                                }
                            }
                            case 48 -> {
                                if (can == cancionesArtista4[2].getIdCancion()) {
                                    fs.ShowScanner("Fav " + j + " - " + cancionesArtista4[2].getIdCancion() + " " + cancionesArtista4[2].getCancion() + "\n");
                                }
                            }
                            case 49 -> {
                                if (can == cancionesArtista4[3].getIdCancion()) {
                                    fs.ShowScanner("Fav " + j + " - " + cancionesArtista4[3].getIdCancion() + " " + cancionesArtista4[3].getCancion() + "\n");
                                }
                            }
                            case 50 -> {
                                if (can == cancionesArtista4[4].getIdCancion()) {
                                    fs.ShowScanner("Fav " + j + " - " + cancionesArtista4[4].getIdCancion() + " " + cancionesArtista4[4].getCancion() + "\n");
                                }
                            }
                            default -> {
                            }
                        }
                    }
                }
//CANCIONES ARTISTA 5                
                case 5 -> {
                    Canciones[] cancionesArtista5 = new Canciones[5];
                    cancionesArtista5[0] = new Canciones(51, artista[4].getIdArtista(), "Canción t");
                    cancionesArtista5[1] = new Canciones(52, artista[4].getIdArtista(), "Canción u");
                    cancionesArtista5[2] = new Canciones(53, artista[4].getIdArtista(), "Canción v");
                    cancionesArtista5[3] = new Canciones(54, artista[4].getIdArtista(), "Canción w");
                    cancionesArtista5[4] = new Canciones(55, artista[4].getIdArtista(), "Canción x");
                    for (Canciones cancion1 : cancionesArtista5) {
                        fs.ShowScanner("Cancion " + cancion1.getIdCancion() + " - " + cancion1.getCancion() + " Artista: " + cancion1.getIdArtista() + ".\n");
                    }
                    for (int j = 1; j < 4; j++) {
                        int can = fn.InputIntegerNumericRangeScanner("Selecciones sus canciones favoritas \n", 51.0, 55.0);
                        switch (can) {
                            case 51 -> {
                                if (can == cancionesArtista5[0].getIdCancion()) {
                                    fs.ShowScanner("Fav " + j + " - " + cancionesArtista5[0].getIdCancion() + " " + cancionesArtista5[0].getCancion() + "\n");
                                }
                            }
                            case 52 -> {
                                if (can == cancionesArtista5[1].getIdCancion()) {
                                    fs.ShowScanner("Fav " + j + " - " + cancionesArtista5[1].getIdCancion() + " " + cancionesArtista5[1].getCancion() + "\n");
                                }
                            }
                            case 53 -> {
                                if (can == cancionesArtista5[2].getIdCancion()) {
                                    fs.ShowScanner("Fav " + j + " - " + cancionesArtista5[2].getIdCancion() + " " + cancionesArtista5[2].getCancion() + "\n");
                                }
                            }
                            case 54 -> {
                                if (can == cancionesArtista5[3].getIdCancion()) {
                                    fs.ShowScanner("Fav " + j + " - " + cancionesArtista5[3].getIdCancion() + " " + cancionesArtista5[3].getCancion() + "\n");
                                }
                            }
                            case 55 -> {
                                if (can == cancionesArtista5[4].getIdCancion()) {
                                    fs.ShowScanner("Fav " + j + " - " + cancionesArtista5[4].getIdCancion() + " " + cancionesArtista5[4].getCancion() + "\n");
                                }
                            }
                            default -> {
                            }
                        }
                    }
                }
                default -> {
                }
//***************************************************************************************************************************************************************                
            }
            /**
             * ****************************************************************************************
             * SE "COMPLETA" EL REGISTRO DE LOS PARTICIPANTES Y SE DA SU BOLETA
             * DE PARTICIPACIÓN
             */
            fs.ShowScanner("----------------------------- \n");
            fs.ShowScanner("Participante: " + encuesta[i].getNombre() + " " + encuesta[i].getApellido() + "\n");
            fs.ShowScanner("N° Boleta: " + (encuesta[i].getNumboleta()) + "\n");
            fs.ShowScanner("Color Boleta: " + color[i].getColor() + arreglo[b] + "\n");
            fs.ShowScanner("----------------------------- \n");
        }
//*****************************************************************************************
        for (int k = 0; k < cantidad; k++) {
            if (arreglo[k] == arreglo[b]) {
                fs.ShowScanner("Boleta ganadora " + arreglo[b] + ".\n");
                fs.ShowScanner("Color boleta: #FF000" + arreglo[b]);
                break;
            }
        }
    }
}
