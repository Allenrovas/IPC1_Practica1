package proyecto1;
import java.util.Random;
import java.util.Scanner;
import java.io.*;



/**
 *Proyecto 1 Escaleras y Serpientes matemáticas
 * @author Allen Román
 */
public class Proyecto1 {
    

    static int [][] tablero = new int [8][8];   //Control de las posiciones
    static int [][] tablero2 = new int [8][8];  // Penalizacion
    static boolean verificarpenal1 = false; //facil
    static boolean verificarpenal2 = false; //inter
    static boolean verificarpenal3 = false; //dificil
    static boolean nopenal1= true;
    static boolean nopenal2= true;
    static boolean nopenal3= true;
    static boolean nopenal4= true;
    static boolean nopenal5= true;
    static boolean nopenal6= true;
    static boolean nopenal7= true;
    static boolean nopenal8= true;
    static boolean nopenal9= true;
    static int sumadado=0;
    static int contfacil=0;
    static int continter=0;
    static int contdif=0; 
    static double alphar2; static double ar2; static double gammar2;
    static double alphar3; static double cr3; static double bethar3;
    static double bethar1; static double br1; static double gammar1;
    static int [][] suma1 = new int [5][5]; static int [][] suma2 = new int [5][5]; static int [][] respuesta1 = new int [5][5];
    static int [][] suma3 = new int [5][5]; static int [][] suma4 = new int [5][5]; static int [][] respuesta2 = new int [5][5];
    static int [][] suma5 = new int [5][5]; static int [][] suma6 = new int [5][5]; static int [][] respuesta3 = new int [5][5];
    static int[][] dividendo2 = new int [4][4]; static int[][] divisora2 = new int [4][4]; static double[][] resultado2= new double[4][4];
    static int[][] dividendo0 = new int [4][4]; static int[][] divisora0 = new int [4][4]; static double[][] respuesta0= new double[4][4];
    static int[][] dividendo1 = new int [4][4]; static int[][] divisora1 = new int [4][4]; static double[][] resultado1= new double[4][4];
     
    
    public static void main(String[] args) {
        int menu=0;
        Scanner lector = new Scanner(System.in);
        
        do{
            System.out.println("===== MENU PRINCIPAL =====");
            System.out.println("1. Iniciar Juego");
            System.out.println("2. Retomar Juego");
            System.out.println("3. Generar Reportes");
            System.out.println("4. Salir");
            System.out.println("");
            try{
            menu = lector.nextInt();
            }catch(Exception error){
                lector.nextLine();
                System.out.println("Ingrese un valor numerico");
                System.out.println("");
            }
            switch(menu){
                case 1:
                    iniciarJuego();
                    break;
                case 2: 
                    retomarJuego();
                case 3:
                    generarReportes();
                case 4:
                    break;
                default:
                    System.out.println("Seleccione un numero entre 1 y 4");
                    System.out.println("");
                    break;     
            }
        }while(menu != 4);
        
    }
    
    public static void  iniciarJuego(){
        sumadado=0;
        boolean verificarpenal1 = false; //facil
        boolean verificarpenal2 = false; //inter
        boolean verificarpenal3 = false;
        boolean nopenal1= true;
        boolean nopenal2= true;
        boolean nopenal3= true;
        boolean nopenal4= true;
        boolean nopenal5= true;
        boolean nopenal6= true;
        boolean nopenal7= true;
        boolean nopenal8= true;
        boolean nopenal9= true;
        int contfacil=0;
        int continter=0;
        int contdif=0;
        int contador =1;
        Random penalizacion = new Random();
        for(int i=0; i<tablero.length; i++){
                for (int j = 0; j < tablero[i].length; j++){
                    tablero[i][j] = contador;
                    contador++;
            }
        }
        int bodega=0;
        for(int i=0; i<tablero2.length; i++){
                    int restriccion =0;
            for (int j = 0; j < tablero2[i].length; j++){
            tablero2[0][0]=0;
            if (restriccion<=3){
                    tablero2[i][j] = penalizacion.nextInt(2);
                }
                if(tablero2[i][j]==1){
                    restriccion = restriccion;
                    restriccion++;
                }
            else{
                 tablero2[i][j]=0;   
                    }
        }
        } 
        
        
        boolean derecha = false; 
        for (int i = tablero.length-1; i >=0; i--){
            System.out.println("-------------------------------------------------------------------");
            if(derecha){
                for (int j=0; j<tablero[i].length;j++){
                    if(i==0&&j==0){
                        System.out.print("@"+"\t"+tablero[i][j]+" |");
                    }
                    else{
                        System.out.print("\t"+tablero[i][j]+"|");
                    } 
                }
                System.out.println("");
                for (int j=0; j<tablero2[i].length;j++){
                        bodega= tablero2[i][j];
                        if(bodega==0){
                            String reemplazo = " ";
                            System.out.print("\t "+reemplazo+"|");
                        }
                        else{
                            String reemplazo = "#";
                            System.out.print("\t "+reemplazo+"|");
                        }
                }
            }else{
                for (int j = tablero[i].length-1; j >= 0; j--){
                    System.out.print("\t"+tablero[i][j]+"|");
                }
                System.out.println("");
                for (int j = tablero2[i].length-1; j >= 0; j--){
                    bodega= tablero2[i][j];
                        if(bodega==0){
                            String reemplazo = " ";
                            System.out.print("\t "+reemplazo+"|");
                        }
                        else{
                            String reemplazo = "#";
                            System.out.print("\t "+reemplazo+"|");
                        }
                }
            }
            System.out.println("");
            System.out.println("-------------------------------------------------------------------");
            derecha =! derecha;
        }
    System.out.println("");
    System.out.println("");
    movimiento();
        System.out.println("Usted ha ganado el juego, Felicidades");
    }
    
    public static void movimiento(){
    
    boolean derecha = false; 
    int bodega=0;
        
        while(sumadado<64){
    verificarpenal1=false;
    verificarpenal3=false;
    verificarpenal2=false;
    
    String nombre=null;
    Scanner teclado = new Scanner(System.in);
            System.out.println("");
            System.out.println("Seleccione para la siguiente tirada");
            System.out.println("p. MENU PRINCIPAL");
            System.out.println("Presione enter para tirar el dado");
            try{
            nombre = teclado.nextLine();
            }catch(Exception error){
                teclado.nextLine();
                System.out.println("Ingrese un caracter valido");
                System.out.println("");
            }
            if(!nombre.equals("p")){
               int dado = 0;
    Random dado1= new Random();
    dado = (int) (dado1.nextInt(5)+2); 
    sumadado+= dado;
        System.out.println("El valor que devuelve el dado  es: "+dado);
        System.out.println("");
        System.out.println("-------------------------------------------------------------------");
        for (int i = tablero.length-1; i >=0; i--){
            if(derecha){
                for (int j=0; j<tablero[i].length;j++){
                    if(j==sumadado && i==0){
                        System.out.print("@"+"\t"+tablero[i][j]+" |");
                        if(tablero2[i][j]==1){
                            verificarpenal1=true;
                        }
                    }
                    else if(j==sumadado-16 && i==2){
                        System.out.print("@"+"\t"+tablero[i][j]+"|");
                        if(tablero2[i][j]==1){
                            verificarpenal2=true;                        }
                    }
                    else if(j==sumadado-32 && i==4){
                        System.out.print("@"+"\t"+tablero[i][j]+"|");
                        if(tablero2[i][j]==1){
                            verificarpenal2=true;
                        }
                    }
                    else if(j==sumadado-48 && i==6){
                        System.out.print("@"+"\t"+tablero[i][j]+"|");
                        if(tablero2[i][j]==1){
                            verificarpenal3=true;
                        }
                    }
                    else{
                        System.out.print("\t"+tablero[i][j]+"|");
                    } 
                }
                System.out.println("");
                for (int j=0; j<tablero2[i].length;j++){
                        bodega= tablero2[i][j];
                        if(bodega==0){
                            String reemplazo = " ";
                            System.out.print("\t "+reemplazo+"|");
                        }
                        else{
                            String reemplazo = "#";
                            System.out.print("\t "+reemplazo+"|");
                        }
                }
            }else{
                int sumacasteada = 0;
                for (int j = tablero[i].length-1; j >= 0; j--){
                    sumacasteada = casteardado(sumadado); 
                    if(j==sumacasteada-8 && i==1){
                        System.out.print("@"+"\t"+tablero[i][j]+"|");
                        if(tablero2[i][j]==1){
                            verificarpenal1=true;
                        }
                    }
                    else if(j==sumacasteada-24 && i==3){
                        System.out.print("@"+"\t"+tablero[i][j]+"|");
                        if(tablero2[i][j]==1){
                            verificarpenal2=true;
                        }
                    }
                    else if(j==sumacasteada-40 && i==5){
                        System.out.print("@"+"\t"+tablero[i][j]+"|");
                        if(tablero2[i][j]==1){
                            verificarpenal3=true;
                        }
                    }
                    else if(j==sumacasteada-56 && i==7){
                        System.out.print("@"+"\t"+tablero[i][j]+"|");
                        if(tablero2[i][j]==1){
                            verificarpenal3=true;
                        }
                    }
                    else{
                        System.out.print("\t"+tablero[i][j]+"|");
                    }   
                }
                System.out.println("");
                for (int j = tablero2[i].length-1; j >= 0; j--){
                    bodega= tablero2[i][j];
                        if(bodega==0){
                            String reemplazo = " ";
                            System.out.print("\t "+reemplazo+"|");
                        }
                        else{
                            String reemplazo = "#";
                            System.out.print("\t "+reemplazo+"|");
                        }
                }
            }
            System.out.println("");
            System.out.println("-------------------------------------------------------------------");
            derecha =! derecha;
        }
        //System.out.println("Suma del dado: "+sumadado);
        if (verificarpenal1==true){
            if(contfacil<2){
            System.out.println("“¡Has caido en una penalizacion facil!");
            leycos();
            contfacil= contfacil;
                    contfacil++;
            }
        }
        if (verificarpenal2==true){
            if(continter<2){
            System.out.println("“¡Has caido en una penalizacion intermedia!");
            suma();
            continter= continter;
                continter++;
            }
        
        }
        if (verificarpenal3==true){
            if(contdif<2){
            System.out.println("“¡Has caido en una penalizacion dificil!");
            division();
            contdif= contdif;
                contdif++;
            }
        }
            }
        if(nombre.equals("p")) {
                int menu=0;
        Scanner lector = new Scanner(System.in);
        
        do{
            System.out.println("===== MENU PRINCIPAL =====");
            System.out.println("1. Iniciar Juego");
            System.out.println("2. Retomar Juego");
            System.out.println("3. Generar Reportes");
            System.out.println("4. Salir");
            System.out.println("");
            try{
            menu = lector.nextInt();
            }catch(Exception error){
                lector.nextLine();
                System.out.println("Ingrese un valor numerico");
                System.out.println("");
            }
            switch(menu){
                case 1:
                    iniciarJuego();
                    break;
                case 2: 
                    retomarJuego();
                case 3:
                    generarReportes();
                case 4:
                    salida();
                default:
                    System.out.println("Seleccione un numero entre 1 y 4");
                    System.out.println("");
                    break;     
            }
        }while(menu != 4);
            }
            
            
    
    
    }
    }
    
    public static void retomarJuego(){
            movimiento();
    }
    
    public static void salida(){
       System.exit(0);
    }
    
    public static void generarReportes(){
        FileWriter fichero=null;
        PrintWriter pw=null;
        
        String texto = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "	<meta charset=\"utf-8\">\n"
                + "	<title>Reporte 1</title>\n"
                + "<style type=\"text/css\">\n"
                + "body{\n"
                + "	margin: 0;\n"
                + "	font-family: times, serif;\n"
                + "	background-color: #E1DBB4; \n"
                + "}\n"
                + "\n"
                + "</style>\n"
                + "\n"
                + "</head>\n"
                + "<body>\n"
                + " \n"
                + "<h1 align=\"center\">Reporte 1</h1>\n"
                + "\n"
                + "<h2>1. Operación</h2>\n"
                +"<h3>1.1. Operaciones faciles</h1>\n "
                +"<h4>1.1.1. Operacion facil no.1</h1>\n "
                +"<h5>Se tiene un triangulo escaleno con lado A=15, lado C=20 y angulo alpha=25</h1>\n "
                +"<h4>1.1.2. Operacion facil no.2</h1>\n "
                +"<h5>Se tiene un triangulo escaleno con lado B=10, lado C=20 y angulo betha=30</h1>\n "
                +"<h4>1.1.3. Operacion facil no.3</h1>\n "
                +"<h5>Se tiene un triangulo escaleno con lado B=10, lado C=20 y angulo betha=30</h1>\n "
                +"<h3>1.2. Operaciones intermedias</h1>\n "
                +"<h4>1.2.1. Operacion intermedia no.1</h1>\n ";
        
                for (int i = 0; i < suma1.length; i++) {
                           texto+= "<br></br>";
                        
                    for (int j = 0; j < suma1.length; j++) {
                        texto+= "("+suma1[j][i]+")";
                    }
                    }
                
                texto+="<h5>Sumada </h1>\n" ; 
                
                for (int i = 0; i < suma2.length; i++) {
                texto+= "<br></br>";
                    for (int j = 0; j < suma2.length; j++) {
                        texto+= "("+suma2[j][i]+")";
                    }
                    }
                
                texto+="<h5></h1>\n "
                +"<h4>1.2.2. Operacion intermedia no.2</h1>\n ";
                
                 for (int i = 0; i < suma3.length; i++) {
            texto += "<br></br>";
            for (int j = 0; j < suma3.length; j++) {
                texto += "(" + suma3[j][i] + ")";
            }
        }

           texto+="<h5>Sumada </h1>\n" ;        
                 
        for (int i = 0; i < suma4.length; i++) {
            texto += "<br></br>";
            for (int j = 0; j < suma4.length; j++) {
                texto += "(" + suma4[j][i] + ")";
            }
        }
                        
                texto+="<h4>1.2.3. Operacion intermedia no.3</h1>\n ";
                
            for (int i = 0; i < suma5.length; i++) {
            texto += "<br></br>";

            for (int j = 0; j < suma5.length; j++) {
                texto += "(" + suma5[j][i] + ")";
            }
        }

           texto+="<h5>Sumada </h1>\n" ;        
                 
        for (int i = 0; i < suma6.length; i++) {
            texto += "<br></br>";
            for (int j = 0; j < suma6.length; j++) {
                texto += "(" + suma6[j][i] + ")";
            }
        }
                
                texto+="<h3>1.3. Operaciones dificiles</h1>\n "
                +"<h4>1.3.1. Operacion dificil no.1</h1>\n ";
                        
             for (int i = 0; i < divisora0.length; i++) {
            texto += "<br></br>";

            for (int j = 0; j < dividendo0.length; j++) {
                texto += "(" + dividendo0[j][i] + ")";
            }
        }
           texto+="<h5>División </h1>\n" ;        
        for (int i = 0; i < divisora0.length; i++) {
            texto += "<br></br>";
            for (int j = 0; j < divisora0.length; j++) {
                texto += "(" + divisora0[j][i] + ")";
            }
        }
             texto+="<h4>1.3.2. Operacion dificil no.2</h1>\n ";
                             for (int i = 0; i < divisora1.length; i++) {
            texto += "<br></br>";

            for (int j = 0; j < dividendo1.length; j++) {
                texto += "(" + dividendo1[j][i] + ")";
            }
        }
           texto+="<h5>División </h1>\n" ;        
        for (int i = 0; i < divisora1.length; i++) {
            texto += "<br></br>";
            for (int j = 0; j < divisora1.length; j++) {
                texto += "(" + divisora1[j][i] + ")";
            }
        }
                
                 
                        
                texto+="<h4>1.3.3. Operacion dificil no.3</h1>\n ";
                        
                        
                        
                             for (int i = 0; i < divisora2.length; i++) {
            texto += "<br></br>";

            for (int j = 0; j < dividendo2.length; j++) {
                texto += "(" + dividendo2[j][i] + ")";
            }
        }

           texto+="<h5>División </h1>\n" ;        
                 
        for (int i = 0; i < divisora2.length; i++) {
            texto += "<br></br>";
            for (int j = 0; j < divisora2.length; j++) {
                texto += "(" + divisora2[j][i] + ")";
            }
        }
                
                 
                        
                texto+= "\n"
                + "\n"
                + "<h2>2. Descripción</h2>\n"
                +"<h3>2.1. Operaciones faciles</h1>\n "
                +"<h4>El teorema del coseno, denominado también como ley de cosenos, es una generalización del teorema de Pitágoras en los triángulos rectángulos en trigonometría.</h1>\n "
                +"<h3>2.2. Operaciones intermedias</h1>\n "
                +"<h4>La suma de matrices es una operación lineal que consiste en unificar los elementos de dos o más matrices que coincidan en posición dentro de sus respectivas matrices y que estas tengan el mismo orden.</h1>\n "
                +"<h3>2.3. Operaciones dificiles</h1>\n "
                +"<h4>La división de dos matrices es la multiplicación de una matriz por la matriz inversa de la matriz divisora, y al mismo tiempo, exige que la matriz divisora sea una matriz cuadrada y que su determinante sea distinto de cero</h1>\n "
                + "\n"
                + "\n"
                + "<h2>3. Resultado</h2>\n"
                +"<h3>3.1. Operaciones faciles</h1>\n "
                        
                +"<h4>3.1.1. Operacion facil no.1</h1>\n ";
                       
                 texto+="Lado B: "+br1;
                 texto+= "<br></br>";
                 texto+="Angulo betha: "+bethar1;
                 texto+= "<br></br>";
                 texto+="Angulo gamma: "+gammar1;
                
                texto+="<h4>3.1.2. Operacion facil no.2</h1>\n ";
                
                texto+="Lado A: "+ar2;
                texto+="Angulo alpha: "+alphar2;
                texto+="Angulo gamma: "+gammar2;
                texto+="<h4>3.1.3. Operacion facil no.3</h1>\n ";
                        
                texto+="Lado C: "+cr3;
                texto+="Angulo alpha: "+alphar3;
                texto+="Angulo betha: "+bethar3;
                        
                texto+="<h3>3.2. Operaciones intermedias</h1>\n "
                +"<h4>3.2.1. Operacion intermedia no.1</h1>\n ";
                        
                                     for (int i = 0; i < respuesta1.length; i++) {
                texto+= "<br></br>";
                    for (int j = 0; j < respuesta1.length; j++) {
                        texto+= "("+respuesta1[j][i]+")";
                    }
                    }   
                        
                texto+="<h4>3.2.2. Operacion intermedia no.2</h1>\n ";
                        
                for (int i = 0; i < respuesta2.length; i++) {
                texto+= "<br></br>";
                    for (int j = 0; j < respuesta2.length; j++) {
                        texto+= "("+respuesta2[j][i]+")";
                    }
                    }          
                        
                texto+="<h4>3.2.3. Operacion intermedia no.3</h1>\n ";
                        
                for (int i = 0; i < respuesta3.length; i++) {
                texto+= "<br></br>";
                    for (int j = 0; j < respuesta3.length; j++) {
                        texto+= "("+respuesta3[j][i]+")";
                    }
                    } 
                texto+="<h3>3.3. Operaciones dificiles</h1>\n "
                +"<h4>3.3.1. Operacion dificil no.1</h1>\n ";
                
                for (int i = 0; i < respuesta0.length; i++) {
                texto+= "<br></br>";
                    for (int j = 0; j < respuesta0.length; j++) {
                        texto+= "("+respuesta0[j][i]+")";
                    }
                    }
                
                texto+="<h4>3.3.2. Operacion dificil no.2</h1>\n ";
                        
                for (int i = 0; i < resultado1.length; i++) {
                texto+= "<br></br>";
                    for (int j = 0; j < resultado1.length; j++) {
                        texto+= "("+resultado1[j][i]+")";
                    }
                    }    
                        
                texto+="<h4>3.3.3. Operacion dificil no.3</h1>\n ";
                
                for (int i = 0; i < resultado2.length; i++) {
                texto+= "<br></br>";
                    for (int j = 0; j < resultado2.length; j++) {
                        texto+= "("+resultado2[j][i]+")";
                    }
                    }
                
                texto+= "\n"
                + "</body>\n"
                + "</html>";
                
        try
        {
            fichero= new FileWriter("D:\\UNIVERSIDAD\\2021 Segundo Semestre\\Introducción a la Programación y Computación 1\\Proyecto 1\\Proyecto1/Reporte 1.html");
            pw  = new PrintWriter(fichero);
            
            for (int i=0; i<=0; i++)
            pw.println(texto);
        
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                if (null!=fichero)
                    fichero.close();
            } catch (Exception e2){
                e2.printStackTrace();
            }
        }
        
    }
    
    public static int casteardado(int sumadado){
                    if(sumadado==0){
                        sumadado=7;
                        return sumadado;
                    }
                    if(sumadado==1){
                        sumadado=6;
                        return sumadado;
                    }
                    if(sumadado==2){
                        sumadado=5;
                        return sumadado;
                    }
                    if(sumadado==3){
                        sumadado=4;
                        return sumadado;
                    }
                    if(sumadado==4){
                        sumadado=3;
                        return sumadado;
                    }
                    if(sumadado==5){
                        sumadado=2;
                        return sumadado;
                    }
                    if(sumadado==6){
                        sumadado=1;
                        return sumadado;
                    }
                    if(sumadado==7){
                        sumadado=0;
                        return sumadado;
                    }
        return sumadado;
    }
    
   public static void leycos(){
   int opcion;
   int aleatorio;
   
   Random opfacil = new Random();
   opcion = opfacil.nextInt(3);
   
   if(opcion==0 && nopenal1==false){
   opcion = opfacil.nextInt(2)+1;   
   }
      else if (opcion==1 && nopenal2==false){   
            aleatorio = opfacil.nextInt(2);
            if(aleatorio==0){
                opcion=0;
            }
            else{
                opcion=2;
            }
      }
      if(opcion==2 && nopenal3==false){
          opcion = opfacil.nextInt(2);
      }
   
   if (opcion==0 && nopenal1==true){
   double a= 15;
   double c= 20;
   double alpha= 25;
   double b; double betha; double gamma;  
       System.out.println("Se tiene un triangulo escaleno con lado A=15, lado C=20 y angulo alpha=25");
       System.out.println("Calcule: el Lado B, angulo betha y angulo gamma");
   b= Math.sqrt((a*a)+(c*c)-2*a*c*Math.cos(alpha*Math.PI/180));
   betha= Math.acos(((a*a)-(c*c)-(b*b))/(-2*b*c))*180/Math.PI;
   gamma = 180 - alpha -betha; 
   
   br1= Math.round(b*1000.0)/1000.0;
   bethar1= Math.round(betha*1000.0)/1000.0;
   gammar1= Math.round(gamma*1000.0)/1000.0;
   
       System.out.println("");
       System.out.println("Lado B: "+br1);
       System.out.println("Angulo betha: "+bethar1);
       System.out.println("Angulo gamma: "+gammar1);
       nopenal1=false;
   }
   
   
   if (opcion==1 && nopenal2==true){
   double b= 10;
   double c= 25;
   double betha= 30;
   double a; double alpha; double gamma;
       System.out.println("Se tiene un triangulo escaleno con lado B=10, lado C=20 y angulo betha=30");
       System.out.println("Calcule: el Lado A, angulo alpha y angulo gamma");
   a= Math.sqrt((b*b)+(c*c)-2*b*c*Math.cos(betha*Math.PI/180));
   alpha= Math.acos(((b*b)-(c*c)-(a*a))/(-2*a*c))*180/Math.PI;
   gamma = 180 - alpha -betha; 
   
   ar2= Math.round(a*1000.0)/1000.0;
   alphar2= Math.round(alpha*1000.0)/1000.0;
   gammar2= Math.round(gamma*1000.0)/1000.0;
   
       System.out.println("");
       System.out.println("Lado A: "+ar2);
       System.out.println("Angulo alpha: "+alphar2);
       System.out.println("Angulo gamma: "+gammar2);
       nopenal2=false;
   }
   if (opcion==2 && nopenal3==true){
   double b= 25;
   double a= 18;
   double gamma= 30;
   double c; double alpha; double betha; 
       System.out.println("Se tiene un triangulo escaleno con lado B=10, lado C=20 y angulo betha=30");
       System.out.println("Calcule: el Lado A, angulo alpha y angulo gamma");
   c= Math.sqrt((b*b)+(a*a)-2*a*b*Math.cos(gamma*Math.PI/180));
   alpha= Math.acos(((a*a)-(c*c)-(b*b))/(-2*b*c))*180/Math.PI;
   betha = 180 - alpha -gamma; 
   
   cr3= Math.round(c*1000.0)/1000.0;
   alphar3= Math.round(alpha*1000.0)/1000.0;
   bethar3= Math.round(betha*1000.0)/1000.0;
   
       System.out.println("");
       System.out.println("Lado C: "+cr3);
       System.out.println("Angulo alpha: "+alphar3);
       System.out.println("Angulo betha: "+bethar3);
       nopenal3=false;
   }
   
   }
   
   public static void suma(){
   int opcion;
   int aleatorio;
   
   Random opfacil = new Random();
   opcion = opfacil.nextInt(3);
   
   if(opcion==0 && nopenal4==false){
   opcion = opfacil.nextInt(2)+1;   
   }
      else if (opcion==1 && nopenal5==false){   
            aleatorio = opfacil.nextInt(2);
            if(aleatorio==0){
                opcion=0;
            }
            else{
                opcion=2;
            }
      }
      if(opcion==2 && nopenal6==false){
          opcion = opfacil.nextInt(2);
      }
   
   if (opcion==0 && nopenal4==true){
   suma1 [0][0]=7; suma1 [1][0]=48; suma1 [2][0]=5; suma1 [3][0]=0; suma1 [4][0]=1;
   suma1 [0][1]=57; suma1 [1][1]=8; suma1 [2][1]=4; suma1 [3][1]=6; suma1 [4][1]=14;
   suma1 [0][2]=0; suma1 [1][2]=5; suma1 [2][2]=6; suma1 [3][2]=78; suma1 [4][2]=15;
   suma1 [0][3]=21; suma1 [1][3]=14; suma1 [2][3]=8; suma1 [3][3]=19; suma1 [4][3]=54;
   suma1 [0][4]=32; suma1 [1][4]=20; suma1 [2][4]=26; suma1 [3][4]=47; suma1 [4][4]=12;
   
   suma2 [0][0]=9; suma2 [1][0]=5; suma2 [2][0]=2; suma2 [3][0]=1; suma2 [4][0]=8;
   suma2 [0][1]=4; suma2 [1][1]=2; suma2 [2][1]=3; suma2 [3][1]=47; suma2 [4][1]=8;
   suma2 [0][2]=48; suma2 [1][2]=55; suma2 [2][2]=32; suma2 [3][2]=19; suma2 [4][2]=6;
   suma2 [0][3]=7; suma2 [1][3]=56; suma2 [2][3]=32; suma2 [3][3]=14; suma2 [4][3]=8;
   suma2 [0][4]=32; suma2 [1][4]=87; suma2 [2][4]=0; suma2 [3][4]=1; suma2 [4][4]=7;
   
       for (int i = 0; i<5; i++) {
           for (int j = 0; j < 5; j++){
               respuesta1[i][j]=suma1[i][j]+suma2[i][j];
           }
       }
       System.out.println("");
       System.out.println("La respuesta correcta es: ");
       System.out.println("");
       for (int i = 0; i<5; i++) {
           for (int j = 0; j < 5; j++){
               System.out.print("("+respuesta1[j][i]+")");
               if (j==4){
                   System.out.println("");
               }
           }
       }
     nopenal4=false;  
   }
   
   if (opcion==1 && nopenal5==true){
   suma3 [0][0]=4; suma3 [1][0]=9; suma3 [2][0]=7; suma3 [3][0]=45; suma3 [4][0]=18;
   suma3 [0][1]=7; suma3 [1][1]=51; suma3 [2][1]=26; suma3 [3][1]=8; suma3 [4][1]=38;
   suma3 [0][2]=48; suma3 [1][2]=26; suma3 [2][2]=37; suma3 [3][2]=21; suma3 [4][2]=19;
   suma3 [0][3]=1; suma3 [1][3]=0; suma3 [2][3]=6; suma3 [3][3]=8; suma3 [4][3]=1;
   suma3 [0][4]=2; suma3 [1][4]=19; suma3 [2][4]=55; suma3 [3][4]=25; suma3 [4][4]=15;
   
   suma4 [0][0]=0; suma4 [1][0]=2; suma4 [2][0]=15; suma4 [3][0]=1; suma4 [4][0]=66;
   suma4 [0][1]=21; suma4 [1][1]=48; suma4 [2][1]=62; suma4 [3][1]=7; suma4 [4][1]=33;
   suma4 [0][2]=4; suma4 [1][2]=88; suma4 [2][2]=0; suma4 [3][2]=68; suma4 [4][2]=4;
   suma4 [0][3]=25; suma4 [1][3]=18; suma4 [2][3]=24; suma4 [3][3]=7; suma4 [4][3]=55;
   suma4 [0][4]=24; suma4 [1][4]=15; suma4 [2][4]=36; suma4 [3][4]=5; suma4 [4][4]=98;
   
       for (int i = 0; i<5; i++) {
           for (int j = 0; j < 5; j++){
               respuesta2[i][j]=suma3[i][j]+suma4[i][j];
           }
       }
       System.out.println("");
       System.out.println("La respuesta correcta es: ");
       System.out.println("");
       for (int i = 0; i<5; i++) {
           for (int j = 0; j < 5; j++){
               System.out.print("("+respuesta2[j][i]+")");
               if (j==4){
                   System.out.println("");
               }
           }
       }
      nopenal5=false; 
   }
   if (opcion==2&& nopenal6==true){
   suma5 [0][0]=0; suma5 [1][0]=1; suma5 [2][0]=15; suma5 [3][0]=5; suma5 [4][0]=36;
   suma5 [0][1]=1; suma5 [1][1]=78; suma5 [2][1]=65; suma5 [3][1]=32; suma5 [4][1]=4;
   suma5 [0][2]=48; suma5 [1][2]=66; suma5 [2][2]=39; suma5 [3][2]=0; suma5 [4][2]=55;
   suma5 [0][3]=14; suma5 [1][3]=98; suma5 [2][3]=63; suma5 [3][3]=20; suma5 [4][3]=15;
   suma5 [0][4]=11; suma5 [1][4]=39; suma5 [2][4]=84; suma5 [3][4]=7; suma5 [4][4]=1;
   
   suma6 [0][0]=78; suma6 [1][0]=25; suma6 [2][0]=66; suma6 [3][0]=48; suma6 [4][0]=98;
   suma6 [0][1]=0; suma6 [1][1]=45; suma6 [2][1]=2; suma6 [3][1]=3; suma6 [4][1]=1;
   suma6 [0][2]=2; suma6 [1][2]=9; suma6 [2][2]=14; suma6 [3][2]=10; suma6 [4][2]=20;
   suma6 [0][3]=35; suma6 [1][3]=87; suma6 [2][3]=65; suma6 [3][3]=2; suma6 [4][3]=32;
   suma6 [0][4]=25; suma6 [1][4]=8; suma6 [2][4]=4; suma6 [3][4]=9; suma6 [4][4]=39;
   
       for (int i = 0; i<5; i++) {
           for (int j = 0; j < 5; j++){
               respuesta3[i][j]=suma5[i][j]+suma6[i][j];
           }
       }
       System.out.println("");
       System.out.println("La respuesta correcta es: ");
       System.out.println("");
       for (int i = 0; i<5; i++) {
           for (int j = 0; j < 5; j++){
               System.out.print("("+respuesta3[j][i]+")");
               if (j==4){
                   System.out.println("");
               }
           }
       }
       nopenal6=false;
   }
    }
    
   public static void division(){
   int opcion;
   int aleatorio;
   
   Random opfacil = new Random();
   opcion = opfacil.nextInt(3);
   
   if(opcion==0 && nopenal7==false){
   opcion = opfacil.nextInt(2)+1;   
   }
      else if (opcion==1 && nopenal8==false){   
            aleatorio = opfacil.nextInt(2);
            if(aleatorio==0){
                opcion=0;
            }
            else{
                opcion=2;
            }
      }
      if(opcion==2 && nopenal9==false){
          opcion = opfacil.nextInt(2);
      }
   
   if(opcion==0 && nopenal7==true){
   int btraspuesta [][] = new int [4][4];
   int adjunta[][]=new int[4][4];
   double inversa[][]=new double[4][4];
   double d;
   
   
   dividendo0 [0][0]=5; dividendo0 [1][0]=10; dividendo0 [2][0]=1; dividendo0 [3][0]=3; 
   dividendo0 [0][1]=9; dividendo0 [1][1]=14; dividendo0 [2][1]=2; dividendo0 [3][1]=6; 
   dividendo0 [0][2]=7; dividendo0 [1][2]=8; dividendo0 [2][2]=15; dividendo0 [3][2]=3; 
   dividendo0 [0][3]=6; dividendo0 [1][3]=8; dividendo0 [2][3]=9; dividendo0 [3][3]=2;
   
   divisora0 [0][0]=5; divisora0 [1][0]=13; divisora0 [2][0]=9; divisora0 [3][0]=4; 
   divisora0 [0][1]=1; divisora0 [1][1]=9; divisora0 [2][1]=6; divisora0 [3][1]=3; 
   divisora0 [0][2]=8; divisora0 [1][2]=11; divisora0 [2][2]=69; divisora0 [3][2]=33; 
   divisora0 [0][3]=25; divisora0 [1][3]=6; divisora0 [2][3]=7; divisora0 [3][3]=4;
   
   btraspuesta [0][0]=divisora0 [0][0]; btraspuesta [1][0]=divisora0 [0][1]; btraspuesta [2][0]=divisora0 [0][2]; btraspuesta [3][0]=divisora0 [0][3]; 
   btraspuesta [0][1]=divisora0 [1][0]; btraspuesta [1][1]=divisora0 [1][1]; btraspuesta [2][1]=divisora0 [1][2]; btraspuesta [3][1]=divisora0 [1][3]; 
   btraspuesta [0][2]=divisora0 [2][0]; btraspuesta [1][2]=divisora0 [2][1]; btraspuesta [2][2]=divisora0 [2][2]; btraspuesta [3][2]=divisora0 [2][3]; 
   btraspuesta [0][3]=divisora0 [3][0]; btraspuesta [1][3]=divisora0 [3][1]; btraspuesta [2][3]=divisora0 [3][2]; btraspuesta [3][3]=divisora0 [3][3];
   
   adjunta[0][0] =btraspuesta [1][1]*((btraspuesta [2][2]*btraspuesta [3][3])-(btraspuesta [2][3]* btraspuesta [3][2]))-btraspuesta [2][1]*((btraspuesta [1][2]*btraspuesta [3][3])-(btraspuesta [1][3]* btraspuesta [3][2]))+btraspuesta [3][1]*(( btraspuesta [1][2]*btraspuesta [2][3])-(btraspuesta [1][3]*btraspuesta [2][2]));
   adjunta[0][1] =-1*(btraspuesta [1][0]*((btraspuesta [2][2]*btraspuesta [3][3])-(btraspuesta [2][3]* btraspuesta [3][2]))-btraspuesta [2][0]*((btraspuesta [1][2]*btraspuesta [3][3])-(btraspuesta [1][3]* btraspuesta [3][2]))+btraspuesta [3][0]*(( btraspuesta [1][2]*btraspuesta [2][3])-(btraspuesta [1][3]*btraspuesta [2][2])));
   adjunta[0][2] =1*btraspuesta [1][0]*((btraspuesta [2][1]*btraspuesta [3][3])-(btraspuesta [2][3]* btraspuesta [3][1]))-btraspuesta [2][0]*((btraspuesta [1][1]*btraspuesta [3][3])-(btraspuesta [1][3]* btraspuesta [3][1]))+btraspuesta [3][0]*(( btraspuesta [1][1]*btraspuesta [2][3])-(btraspuesta [1][3]*btraspuesta [2][1]));
   adjunta[0][3]=-1*(btraspuesta[1][0]*((btraspuesta[2][1]*btraspuesta[3][2])-(btraspuesta[2][2]*btraspuesta[3][1]))-btraspuesta[2][0]*((btraspuesta[1][1]*btraspuesta[3][2])-(btraspuesta[1][2]*btraspuesta[3][1]))+btraspuesta[3][0]*((btraspuesta[1][1]*btraspuesta[2][2])-(btraspuesta[1][2]*btraspuesta[2][1])));
   adjunta[1][0] =-1*(btraspuesta[0][1]*((btraspuesta[2][2]*btraspuesta[3][3])-(btraspuesta[2][3]*btraspuesta[3][2]))-btraspuesta[2][1]*((btraspuesta[0][2]*btraspuesta[3][3])-(btraspuesta[0][3]*btraspuesta[3][2]))+btraspuesta[3][1]*((btraspuesta[0][2]*btraspuesta[2][3])-(btraspuesta[0][3]*btraspuesta[2][2])));
   adjunta[1][1] =1*(btraspuesta[0][0]*((btraspuesta[2][2]*btraspuesta[3][3])-(btraspuesta[2][3]*btraspuesta[3][2]))-btraspuesta[2][0]*((btraspuesta[0][2]*btraspuesta[3][3])-(btraspuesta[0][3]*btraspuesta[3][2]))+btraspuesta[3][0]*((btraspuesta[0][2]*btraspuesta[2][3])-(btraspuesta[0][3]*btraspuesta[2][2])));
   adjunta[1][2] =-1*(btraspuesta[0][0]*((btraspuesta[2][1]*btraspuesta[3][3])-(btraspuesta[2][3]*btraspuesta[3][1]))-btraspuesta[2][0]*((btraspuesta[0][1]*btraspuesta[3][3])-(btraspuesta[0][3]*btraspuesta[3][1]))+btraspuesta[3][0]*((btraspuesta[0][1]*btraspuesta[2][3])-(btraspuesta[0][3]*btraspuesta[2][1])));
   adjunta[1][3] =1*btraspuesta [0][0]*((btraspuesta [2][1]*btraspuesta [3][2])-(btraspuesta [2][2]* btraspuesta [3][1]))-btraspuesta [2][0]*((btraspuesta [0][1]*btraspuesta [3][2])-(btraspuesta [0][2]* btraspuesta [3][1]))+btraspuesta [3][0]*(( btraspuesta [0][1]*btraspuesta [2][2])-(btraspuesta [0][2]*btraspuesta [2][1]));
   adjunta[2][0] =1*btraspuesta [0][1]*((btraspuesta [1][2]*btraspuesta [3][3])-(btraspuesta [1][3]* btraspuesta [3][2]))-btraspuesta [1][1]*((btraspuesta [0][2]*btraspuesta [3][3])-(btraspuesta [0][3]* btraspuesta [3][2]))+btraspuesta [3][1]*(( btraspuesta [0][2]*btraspuesta [1][3])-(btraspuesta [0][3]*btraspuesta [1][2]));
   adjunta[2][1] =-1*(btraspuesta[0][0]*((btraspuesta[1][2]*btraspuesta[3][3])-(btraspuesta[1][3]*btraspuesta[3][2]))-btraspuesta[1][0]*((btraspuesta[0][2]*btraspuesta[3][3])-(btraspuesta[0][3]*btraspuesta[3][2]))+btraspuesta[3][0]*((btraspuesta[0][2]*btraspuesta[1][3])-(btraspuesta[0][3]*btraspuesta[1][2])));
   adjunta[2][2] =1*btraspuesta [0][0]*((btraspuesta [1][1]*btraspuesta [3][3])-(btraspuesta [1][3]* btraspuesta [3][1]))-btraspuesta [1][0]*((btraspuesta [0][1]*btraspuesta [3][3])-(btraspuesta [0][3]* btraspuesta [3][1]))+btraspuesta [3][0]*(( btraspuesta [0][1]*btraspuesta [1][3])-(btraspuesta [0][3]*btraspuesta [1][1]));
   adjunta[2][3] =-1*(btraspuesta[0][0]*((btraspuesta[1][1]*btraspuesta[3][2])-(btraspuesta[1][2]*btraspuesta[3][1]))-btraspuesta[1][0]*((btraspuesta[0][1]*btraspuesta[3][2])-(btraspuesta[0][2]*btraspuesta[3][1]))+btraspuesta[3][0]*((btraspuesta[0][1]*btraspuesta[1][2])-(btraspuesta[0][2]*btraspuesta[1][1])));
   adjunta[3][0] =-1*(btraspuesta[0][1]*((btraspuesta[1][2]*btraspuesta[2][3])-(btraspuesta[1][3]*btraspuesta[2][2]))-btraspuesta[1][1]*((btraspuesta[0][2]*btraspuesta[2][3])-(btraspuesta[0][3]*btraspuesta[2][2]))+btraspuesta[2][1]*((btraspuesta[0][2]*btraspuesta[1][3])-(btraspuesta[0][3]*btraspuesta[1][2])));
   adjunta[3][1] =1*btraspuesta [0][0]*((btraspuesta [1][2]*btraspuesta [2][3])-(btraspuesta [1][3]* btraspuesta [2][2]))-btraspuesta [1][0]*((btraspuesta [0][2]*btraspuesta [2][3])-(btraspuesta [0][3]* btraspuesta [2][2]))+btraspuesta [2][0]*(( btraspuesta [0][2]*btraspuesta [1][3])-(btraspuesta [0][3]*btraspuesta [1][2]));
   adjunta[3][2] =-1*(btraspuesta[0][0]*((btraspuesta[1][1]*btraspuesta[2][3])-(btraspuesta[1][3]*btraspuesta[2][1]))-btraspuesta[1][0]*((btraspuesta[0][1]*btraspuesta[2][3])-(btraspuesta[0][3]*btraspuesta[2][1]))+btraspuesta[2][0]*((btraspuesta[0][1]*btraspuesta[1][3])-(btraspuesta[0][3]*btraspuesta[1][1])));
   adjunta[3][3] =1*btraspuesta [0][0]*((btraspuesta [2][2]*btraspuesta [1][1])-(btraspuesta [1][2]* btraspuesta [2][1]))-btraspuesta [1][0]*((btraspuesta [2][2]*btraspuesta [0][1])-(btraspuesta [0][2]* btraspuesta [2][1]))+btraspuesta [2][0]*(( btraspuesta [0][1]*btraspuesta [1][2])-(btraspuesta [0][2]*btraspuesta [1][1]));
   
   d= ( btraspuesta [0][0]*adjunta[0][0])+( btraspuesta [1][0]*adjunta[1][0])+(btraspuesta [2][0]*adjunta[2][0])+( btraspuesta[3][0]*adjunta[3][0]);
   
       
   if(d!=0){
           for (int i = 0; i<4; i++) {
           for (int j = 0; j < 4; j++) {
                   inversa[i][j] = adjunta[i][j] / d;
               }
           }
           respuesta0[0][0]=(inversa[0][0]*dividendo0[0][0])+(dividendo0[1][0]*inversa[0][1])+(dividendo0[2][0]*inversa[0][2])+(dividendo0[3][0]*inversa[0][3]);
           respuesta0[1][0]=(dividendo0[0][0]*inversa[1][0])+(dividendo0[1][0]*inversa[1][1])+(dividendo0[2][0]*inversa[1][2])+(dividendo0[3][0]*inversa[1][3]);
           respuesta0[2][0] = (dividendo0[0][0] * inversa[2][0]) + (dividendo0[1][0] * inversa[2][1]) + (dividendo0[2][0] * inversa[2][2]) + (dividendo0[3][0] * inversa[2][3]);
           respuesta0[3][0] = (dividendo0[0][0] * inversa[3][0]) + (dividendo0[1][0] * inversa[3][1]) + (dividendo0[2][0] * inversa[3][2]) + (dividendo0[3][0] * inversa[3][3]);
           respuesta0[0][1]=(dividendo0[0][1]*inversa[0][0])+(dividendo0[1][1]*inversa[0][1])+(dividendo0[2][1]*inversa[0][2])+(dividendo0[3][1]*inversa[0][3]);
           respuesta0[1][1]=(dividendo0[0][1]*inversa[1][0])+(dividendo0[1][1]*inversa[1][1])+(dividendo0[2][1]*inversa[1][2])+(dividendo0[3][1]*inversa[1][3]);
           respuesta0[2][1] = (dividendo0[0][1] * inversa[2][0]) + (dividendo0[1][1] * inversa[2][1]) + (dividendo0[2][1] * inversa[2][2]) + (dividendo0[3][1] * inversa[2][3]);
           respuesta0[3][1] = (dividendo0[0][1] * inversa[3][0]) + (dividendo0[1][1] * inversa[3][1]) + (dividendo0[2][1] * inversa[3][2]) + (dividendo0[3][1] * inversa[3][3]);
           respuesta0[0][2]=(dividendo0[0][2]*inversa[0][0])+(dividendo0[1][2]*inversa[0][1])+(dividendo0[2][2]*inversa[0][2])+(dividendo0[3][2]*inversa[0][3]);
           respuesta0[1][2]=(dividendo0[0][2]*inversa[1][0])+(dividendo0[1][2]*inversa[1][1])+(dividendo0[2][2]*inversa[1][2])+(dividendo0[3][2]*inversa[1][3]);
           respuesta0[2][2] = (dividendo0[0][2] * inversa[2][0]) + (dividendo0[1][2] * inversa[2][1]) + (dividendo0[2][2] * inversa[2][2]) + (dividendo0[3][2] * inversa[2][3]);
           respuesta0[3][2] = (dividendo0[0][2] * inversa[3][0]) + (dividendo0[1][2] * inversa[3][1]) + (dividendo0[2][2] * inversa[3][2]) + (dividendo0[3][2] * inversa[3][3]);
           respuesta0[0][3]=(dividendo0[0][3]*inversa[0][0])+(dividendo0[1][3]*inversa[0][1])+(dividendo0[2][3]*inversa[0][2])+(dividendo0[3][3]*inversa[0][3]);
           respuesta0[1][3]=(dividendo0[0][3]*inversa[1][0])+(dividendo0[1][3]*inversa[1][1])+(dividendo0[2][3]*inversa[1][2])+(dividendo0[3][3]*inversa[1][3]);
           respuesta0[2][3] = (dividendo0[0][3] * inversa[2][0]) + (dividendo0[1][3] * inversa[2][1]) + (dividendo0[2][3] * inversa[2][2]) + (dividendo0[3][3] * inversa[2][3]);
           respuesta0[3][3] = (dividendo0[0][3] * inversa[3][0]) + (dividendo0[1][3] * inversa[3][1]) + (dividendo0[2][3] * inversa[3][2]) + (dividendo0[3][3] * inversa[3][3]);
         
       System.out.println("");
       System.out.println("La respuesta correcta es: ");
       System.out.println("");
           for (int i = 0; i < 4; i++) {
               for (int j = 0; j < 4; j++) {
                   System.out.print("(" + Math.round(respuesta0[j][i]*1000.0)/1000.0 + ")");
                   if (j == 3) {
                       System.out.println("");
                   }
               }
           }
       }
   else{
       System.out.println("El determinante de la matriz no puede ser cero");
   }
    nopenal7=false;
   }
   
   if (opcion==1&&nopenal8==true){
   int btraspuesta [][] = new int [4][4];
   int adjunta[][]=new int[4][4];
   double inversa[][]=new double[4][4];
   double d;
   
   dividendo1 [0][0]=1; dividendo1 [1][0]=12; dividendo1 [2][0]=9; dividendo1 [3][0]=8; 
   dividendo1 [0][1]=7; dividendo1 [1][1]=6; dividendo1 [2][1]=3; dividendo1 [3][1]=2; 
   dividendo1 [0][2]=0; dividendo1 [1][2]=5; dividendo1 [2][2]=6; dividendo1 [3][2]=14; 
   dividendo1 [0][3]=6; dividendo1 [1][3]=9; dividendo1 [2][3]=6; dividendo1 [3][3]=10;
   
   divisora1 [0][0]=8; divisora1 [1][0]=19; divisora1 [2][0]=20; divisora1 [3][0]=4; 
   divisora1 [0][1]=12; divisora1 [1][1]=33; divisora1 [2][1]=6; divisora1 [3][1]=8; 
   divisora1 [0][2]=4; divisora1 [1][2]=5; divisora1 [2][2]=9; divisora1 [3][2]=7; 
   divisora1 [0][3]=8; divisora1 [1][3]=22; divisora1 [2][3]=14; divisora1 [3][3]=6; 
   
    btraspuesta [0][0]=divisora1 [0][0]; btraspuesta [1][0]=divisora1 [0][1]; btraspuesta [2][0]=divisora1 [0][2]; btraspuesta [3][0]=divisora1 [0][3]; 
   btraspuesta [0][1]=divisora1 [1][0]; btraspuesta [1][1]=divisora1 [1][1]; btraspuesta [2][1]=divisora1 [1][2]; btraspuesta [3][1]=divisora1 [1][3]; 
   btraspuesta [0][2]=divisora1 [2][0]; btraspuesta [1][2]=divisora1 [2][1]; btraspuesta [2][2]=divisora1 [2][2]; btraspuesta [3][2]=divisora1 [2][3]; 
   btraspuesta [0][3]=divisora1 [3][0]; btraspuesta [1][3]=divisora1 [3][1]; btraspuesta [2][3]=divisora1 [3][2]; btraspuesta [3][3]=divisora1 [3][3];
   
   adjunta[0][0] =btraspuesta [1][1]*((btraspuesta [2][2]*btraspuesta [3][3])-(btraspuesta [2][3]* btraspuesta [3][2]))-btraspuesta [2][1]*((btraspuesta [1][2]*btraspuesta [3][3])-(btraspuesta [1][3]* btraspuesta [3][2]))+btraspuesta [3][1]*(( btraspuesta [1][2]*btraspuesta [2][3])-(btraspuesta [1][3]*btraspuesta [2][2]));
   adjunta[0][1] =-1*(btraspuesta [1][0]*((btraspuesta [2][2]*btraspuesta [3][3])-(btraspuesta [2][3]* btraspuesta [3][2]))-btraspuesta [2][0]*((btraspuesta [1][2]*btraspuesta [3][3])-(btraspuesta [1][3]* btraspuesta [3][2]))+btraspuesta [3][0]*(( btraspuesta [1][2]*btraspuesta [2][3])-(btraspuesta [1][3]*btraspuesta [2][2])));
   adjunta[0][2] =1*btraspuesta [1][0]*((btraspuesta [2][1]*btraspuesta [3][3])-(btraspuesta [2][3]* btraspuesta [3][1]))-btraspuesta [2][0]*((btraspuesta [1][1]*btraspuesta [3][3])-(btraspuesta [1][3]* btraspuesta [3][1]))+btraspuesta [3][0]*(( btraspuesta [1][1]*btraspuesta [2][3])-(btraspuesta [1][3]*btraspuesta [2][1]));
   adjunta[0][3]=-1*(btraspuesta[1][0]*((btraspuesta[2][1]*btraspuesta[3][2])-(btraspuesta[2][2]*btraspuesta[3][1]))-btraspuesta[2][0]*((btraspuesta[1][1]*btraspuesta[3][2])-(btraspuesta[1][2]*btraspuesta[3][1]))+btraspuesta[3][0]*((btraspuesta[1][1]*btraspuesta[2][2])-(btraspuesta[1][2]*btraspuesta[2][1])));
   adjunta[1][0] =-1*(btraspuesta[0][1]*((btraspuesta[2][2]*btraspuesta[3][3])-(btraspuesta[2][3]*btraspuesta[3][2]))-btraspuesta[2][1]*((btraspuesta[0][2]*btraspuesta[3][3])-(btraspuesta[0][3]*btraspuesta[3][2]))+btraspuesta[3][1]*((btraspuesta[0][2]*btraspuesta[2][3])-(btraspuesta[0][3]*btraspuesta[2][2])));
   adjunta[1][1] =1*(btraspuesta[0][0]*((btraspuesta[2][2]*btraspuesta[3][3])-(btraspuesta[2][3]*btraspuesta[3][2]))-btraspuesta[2][0]*((btraspuesta[0][2]*btraspuesta[3][3])-(btraspuesta[0][3]*btraspuesta[3][2]))+btraspuesta[3][0]*((btraspuesta[0][2]*btraspuesta[2][3])-(btraspuesta[0][3]*btraspuesta[2][2])));
   adjunta[1][2] =-1*(btraspuesta[0][0]*((btraspuesta[2][1]*btraspuesta[3][3])-(btraspuesta[2][3]*btraspuesta[3][1]))-btraspuesta[2][0]*((btraspuesta[0][1]*btraspuesta[3][3])-(btraspuesta[0][3]*btraspuesta[3][1]))+btraspuesta[3][0]*((btraspuesta[0][1]*btraspuesta[2][3])-(btraspuesta[0][3]*btraspuesta[2][1])));
   adjunta[1][3] =1*btraspuesta [0][0]*((btraspuesta [2][1]*btraspuesta [3][2])-(btraspuesta [2][2]* btraspuesta [3][1]))-btraspuesta [2][0]*((btraspuesta [0][1]*btraspuesta [3][2])-(btraspuesta [0][2]* btraspuesta [3][1]))+btraspuesta [3][0]*(( btraspuesta [0][1]*btraspuesta [2][2])-(btraspuesta [0][2]*btraspuesta [2][1]));
   adjunta[2][0] =1*btraspuesta [0][1]*((btraspuesta [1][2]*btraspuesta [3][3])-(btraspuesta [1][3]* btraspuesta [3][2]))-btraspuesta [1][1]*((btraspuesta [0][2]*btraspuesta [3][3])-(btraspuesta [0][3]* btraspuesta [3][2]))+btraspuesta [3][1]*(( btraspuesta [0][2]*btraspuesta [1][3])-(btraspuesta [0][3]*btraspuesta [1][2]));
   adjunta[2][1] =-1*(btraspuesta[0][0]*((btraspuesta[1][2]*btraspuesta[3][3])-(btraspuesta[1][3]*btraspuesta[3][2]))-btraspuesta[1][0]*((btraspuesta[0][2]*btraspuesta[3][3])-(btraspuesta[0][3]*btraspuesta[3][2]))+btraspuesta[3][0]*((btraspuesta[0][2]*btraspuesta[1][3])-(btraspuesta[0][3]*btraspuesta[1][2])));
   adjunta[2][2] =1*btraspuesta [0][0]*((btraspuesta [1][1]*btraspuesta [3][3])-(btraspuesta [1][3]* btraspuesta [3][1]))-btraspuesta [1][0]*((btraspuesta [0][1]*btraspuesta [3][3])-(btraspuesta [0][3]* btraspuesta [3][1]))+btraspuesta [3][0]*(( btraspuesta [0][1]*btraspuesta [1][3])-(btraspuesta [0][3]*btraspuesta [1][1]));
   adjunta[2][3] =-1*(btraspuesta[0][0]*((btraspuesta[1][1]*btraspuesta[3][2])-(btraspuesta[1][2]*btraspuesta[3][1]))-btraspuesta[1][0]*((btraspuesta[0][1]*btraspuesta[3][2])-(btraspuesta[0][2]*btraspuesta[3][1]))+btraspuesta[3][0]*((btraspuesta[0][1]*btraspuesta[1][2])-(btraspuesta[0][2]*btraspuesta[1][1])));
   adjunta[3][0] =-1*(btraspuesta[0][1]*((btraspuesta[1][2]*btraspuesta[2][3])-(btraspuesta[1][3]*btraspuesta[2][2]))-btraspuesta[1][1]*((btraspuesta[0][2]*btraspuesta[2][3])-(btraspuesta[0][3]*btraspuesta[2][2]))+btraspuesta[2][1]*((btraspuesta[0][2]*btraspuesta[1][3])-(btraspuesta[0][3]*btraspuesta[1][2])));
   adjunta[3][1] =1*btraspuesta [0][0]*((btraspuesta [1][2]*btraspuesta [2][3])-(btraspuesta [1][3]* btraspuesta [2][2]))-btraspuesta [1][0]*((btraspuesta [0][2]*btraspuesta [2][3])-(btraspuesta [0][3]* btraspuesta [2][2]))+btraspuesta [2][0]*(( btraspuesta [0][2]*btraspuesta [1][3])-(btraspuesta [0][3]*btraspuesta [1][2]));
   adjunta[3][2] =-1*(btraspuesta[0][0]*((btraspuesta[1][1]*btraspuesta[2][3])-(btraspuesta[1][3]*btraspuesta[2][1]))-btraspuesta[1][0]*((btraspuesta[0][1]*btraspuesta[2][3])-(btraspuesta[0][3]*btraspuesta[2][1]))+btraspuesta[2][0]*((btraspuesta[0][1]*btraspuesta[1][3])-(btraspuesta[0][3]*btraspuesta[1][1])));
   adjunta[3][3] =1*btraspuesta [0][0]*((btraspuesta [2][2]*btraspuesta [1][1])-(btraspuesta [1][2]* btraspuesta [2][1]))-btraspuesta [1][0]*((btraspuesta [2][2]*btraspuesta [0][1])-(btraspuesta [0][2]* btraspuesta [2][1]))+btraspuesta [2][0]*(( btraspuesta [0][1]*btraspuesta [1][2])-(btraspuesta [0][2]*btraspuesta [1][1]));
   
   d= ( btraspuesta [0][0]*adjunta[0][0])+( btraspuesta [1][0]*adjunta[1][0])+(btraspuesta [2][0]*adjunta[2][0])+( btraspuesta[3][0]*adjunta[3][0]);
   
       
   
       
   if(d!=0){
           for (int i = 0; i<4; i++) {
           for (int j = 0; j < 4; j++) {
                   inversa[i][j] = adjunta[i][j] / d;
               }
           }
           resultado1[0][0]=(inversa[0][0]*dividendo1[0][0])+(dividendo1[1][0]*inversa[0][1])+(dividendo1[2][0]*inversa[0][2])+(dividendo1[3][0]*inversa[0][3]);
           resultado1[1][0]=(dividendo1[0][0]*inversa[1][0])+(dividendo1[1][0]*inversa[1][1])+(dividendo1[2][0]*inversa[1][2])+(dividendo1[3][0]*inversa[1][3]);
           resultado1[2][0] = (dividendo1[0][0] * inversa[2][0]) + (dividendo1[1][0] * inversa[2][1]) + (dividendo1[2][0] * inversa[2][2]) + (dividendo1[3][0] * inversa[2][3]);
           resultado1[3][0] = (dividendo1[0][0] * inversa[3][0]) + (dividendo1[1][0] * inversa[3][1]) + (dividendo1[2][0] * inversa[3][2]) + (dividendo1[3][0] * inversa[3][3]);
           resultado1[0][1]=(dividendo1[0][1]*inversa[0][0])+(dividendo1[1][1]*inversa[0][1])+(dividendo1[2][1]*inversa[0][2])+(dividendo1[3][1]*inversa[0][3]);
           resultado1[1][1]=(dividendo1[0][1]*inversa[1][0])+(dividendo1[1][1]*inversa[1][1])+(dividendo1[2][1]*inversa[1][2])+(dividendo1[3][1]*inversa[1][3]);
           resultado1[2][1] = (dividendo1[0][1] * inversa[2][0]) + (dividendo1[1][1] * inversa[2][1]) + (dividendo1[2][1] * inversa[2][2]) + (dividendo1[3][1] * inversa[2][3]);
           resultado1[3][1] = (dividendo1[0][1] * inversa[3][0]) + (dividendo1[1][1] * inversa[3][1]) + (dividendo1[2][1] * inversa[3][2]) + (dividendo1[3][1] * inversa[3][3]);
           resultado1[0][2]=(dividendo1[0][2]*inversa[0][0])+(dividendo1[1][2]*inversa[0][1])+(dividendo1[2][2]*inversa[0][2])+(dividendo1[3][2]*inversa[0][3]);
           resultado1[1][2]=(dividendo1[0][2]*inversa[1][0])+(dividendo1[1][2]*inversa[1][1])+(dividendo1[2][2]*inversa[1][2])+(dividendo1[3][2]*inversa[1][3]);
           resultado1[2][2] = (dividendo1[0][2] * inversa[2][0]) + (dividendo1[1][2] * inversa[2][1]) + (dividendo1[2][2] * inversa[2][2]) + (dividendo1[3][2] * inversa[2][3]);
           resultado1[3][2] = (dividendo1[0][2] * inversa[3][0]) + (dividendo1[1][2] * inversa[3][1]) + (dividendo1[2][2] * inversa[3][2]) + (dividendo1[3][2] * inversa[3][3]);
           resultado1[0][3]=(dividendo1[0][3]*inversa[0][0])+(dividendo1[1][3]*inversa[0][1])+(dividendo1[2][3]*inversa[0][2])+(dividendo1[3][3]*inversa[0][3]);
           resultado1[1][3]=(dividendo1[0][3]*inversa[1][0])+(dividendo1[1][3]*inversa[1][1])+(dividendo1[2][3]*inversa[1][2])+(dividendo1[3][3]*inversa[1][3]);
           resultado1[2][3] = (dividendo1[0][3] * inversa[2][0]) + (dividendo1[1][3] * inversa[2][1]) + (dividendo1[2][3] * inversa[2][2]) + (dividendo1[3][3] * inversa[2][3]);
           resultado1[3][3] = (dividendo1[0][3] * inversa[3][0]) + (dividendo1[1][3] * inversa[3][1]) + (dividendo1[2][3] * inversa[3][2]) + (dividendo1[3][3] * inversa[3][3]);
         
       System.out.println("");
       System.out.println("La respuesta correcta es: ");
       System.out.println("");
           for (int i = 0; i < 4; i++) {
               for (int j = 0; j < 4; j++) {
                   System.out.print("(" + Math.round(resultado1[j][i]*1000.0)/1000.0 + ")");
                   if (j == 3) {
                       System.out.println("");
                   }
               }
           }
       }
   else{
       System.out.println("El determinante de la matriz no puede ser cero");
   }
   nopenal8=false;
   
   }
   
   if (opcion==2&&nopenal9==true){
   int btraspuesta [][] = new int [4][4];
   int adjunta[][]=new int[4][4];
   double inversa[][]=new double[4][4];
   double d;
   
   dividendo2 [0][0]=5; dividendo2 [1][0]=9; dividendo2 [2][0]=14; dividendo2 [3][0]=5; 
   dividendo2 [0][1]=6; dividendo2 [1][1]=0; dividendo2 [2][1]=5; dividendo2 [3][1]=3; 
   dividendo2 [0][2]=1; dividendo2 [1][2]=14; dividendo2 [2][2]=68; dividendo2 [3][2]=8; 
   dividendo2 [0][3]=7; dividendo2 [1][3]=5; dividendo2 [2][3]=3; dividendo2 [3][3]=9;
   
   divisora2 [0][0]=0; divisora2 [1][0]=9; divisora2 [2][0]=7; divisora2 [3][0]=19; 
   divisora2 [0][1]=2; divisora2 [1][1]=30; divisora2 [2][1]=5; divisora2 [3][1]=48; 
   divisora2 [0][2]=1; divisora2 [1][2]=31; divisora2 [2][2]=2; divisora2 [3][2]=5; 
   divisora2 [0][3]=15; divisora2 [1][3]=8; divisora2 [2][3]=4; divisora2 [3][3]=3;  
    btraspuesta [0][0]=divisora2 [0][0]; btraspuesta [1][0]=divisora2 [0][1]; btraspuesta [2][0]=divisora2 [0][2]; btraspuesta [3][0]=divisora2 [0][3]; 
   btraspuesta [0][1]=divisora2 [1][0]; btraspuesta [1][1]=divisora2 [1][1]; btraspuesta [2][1]=divisora2 [1][2]; btraspuesta [3][1]=divisora2 [1][3]; 
   btraspuesta [0][2]=divisora2 [2][0]; btraspuesta [1][2]=divisora2 [2][1]; btraspuesta [2][2]=divisora2 [2][2]; btraspuesta [3][2]=divisora2 [2][3]; 
   btraspuesta [0][3]=divisora2 [3][0]; btraspuesta [1][3]=divisora2 [3][1]; btraspuesta [2][3]=divisora2 [3][2]; btraspuesta [3][3]=divisora2 [3][3];
   
   adjunta[0][0] =btraspuesta [1][1]*((btraspuesta [2][2]*btraspuesta [3][3])-(btraspuesta [2][3]* btraspuesta [3][2]))-btraspuesta [2][1]*((btraspuesta [1][2]*btraspuesta [3][3])-(btraspuesta [1][3]* btraspuesta [3][2]))+btraspuesta [3][1]*(( btraspuesta [1][2]*btraspuesta [2][3])-(btraspuesta [1][3]*btraspuesta [2][2]));
   adjunta[0][1] =-1*(btraspuesta [1][0]*((btraspuesta [2][2]*btraspuesta [3][3])-(btraspuesta [2][3]* btraspuesta [3][2]))-btraspuesta [2][0]*((btraspuesta [1][2]*btraspuesta [3][3])-(btraspuesta [1][3]* btraspuesta [3][2]))+btraspuesta [3][0]*(( btraspuesta [1][2]*btraspuesta [2][3])-(btraspuesta [1][3]*btraspuesta [2][2])));
   adjunta[0][2] =1*btraspuesta [1][0]*((btraspuesta [2][1]*btraspuesta [3][3])-(btraspuesta [2][3]* btraspuesta [3][1]))-btraspuesta [2][0]*((btraspuesta [1][1]*btraspuesta [3][3])-(btraspuesta [1][3]* btraspuesta [3][1]))+btraspuesta [3][0]*(( btraspuesta [1][1]*btraspuesta [2][3])-(btraspuesta [1][3]*btraspuesta [2][1]));
   adjunta[0][3]=-1*(btraspuesta[1][0]*((btraspuesta[2][1]*btraspuesta[3][2])-(btraspuesta[2][2]*btraspuesta[3][1]))-btraspuesta[2][0]*((btraspuesta[1][1]*btraspuesta[3][2])-(btraspuesta[1][2]*btraspuesta[3][1]))+btraspuesta[3][0]*((btraspuesta[1][1]*btraspuesta[2][2])-(btraspuesta[1][2]*btraspuesta[2][1])));
   adjunta[1][0] =-1*(btraspuesta[0][1]*((btraspuesta[2][2]*btraspuesta[3][3])-(btraspuesta[2][3]*btraspuesta[3][2]))-btraspuesta[2][1]*((btraspuesta[0][2]*btraspuesta[3][3])-(btraspuesta[0][3]*btraspuesta[3][2]))+btraspuesta[3][1]*((btraspuesta[0][2]*btraspuesta[2][3])-(btraspuesta[0][3]*btraspuesta[2][2])));
   adjunta[1][1] =1*(btraspuesta[0][0]*((btraspuesta[2][2]*btraspuesta[3][3])-(btraspuesta[2][3]*btraspuesta[3][2]))-btraspuesta[2][0]*((btraspuesta[0][2]*btraspuesta[3][3])-(btraspuesta[0][3]*btraspuesta[3][2]))+btraspuesta[3][0]*((btraspuesta[0][2]*btraspuesta[2][3])-(btraspuesta[0][3]*btraspuesta[2][2])));
   adjunta[1][2] =-1*(btraspuesta[0][0]*((btraspuesta[2][1]*btraspuesta[3][3])-(btraspuesta[2][3]*btraspuesta[3][1]))-btraspuesta[2][0]*((btraspuesta[0][1]*btraspuesta[3][3])-(btraspuesta[0][3]*btraspuesta[3][1]))+btraspuesta[3][0]*((btraspuesta[0][1]*btraspuesta[2][3])-(btraspuesta[0][3]*btraspuesta[2][1])));
   adjunta[1][3] =1*btraspuesta [0][0]*((btraspuesta [2][1]*btraspuesta [3][2])-(btraspuesta [2][2]* btraspuesta [3][1]))-btraspuesta [2][0]*((btraspuesta [0][1]*btraspuesta [3][2])-(btraspuesta [0][2]* btraspuesta [3][1]))+btraspuesta [3][0]*(( btraspuesta [0][1]*btraspuesta [2][2])-(btraspuesta [0][2]*btraspuesta [2][1]));
   adjunta[2][0] =1*btraspuesta [0][1]*((btraspuesta [1][2]*btraspuesta [3][3])-(btraspuesta [1][3]* btraspuesta [3][2]))-btraspuesta [1][1]*((btraspuesta [0][2]*btraspuesta [3][3])-(btraspuesta [0][3]* btraspuesta [3][2]))+btraspuesta [3][1]*(( btraspuesta [0][2]*btraspuesta [1][3])-(btraspuesta [0][3]*btraspuesta [1][2]));
   adjunta[2][1] =-1*(btraspuesta[0][0]*((btraspuesta[1][2]*btraspuesta[3][3])-(btraspuesta[1][3]*btraspuesta[3][2]))-btraspuesta[1][0]*((btraspuesta[0][2]*btraspuesta[3][3])-(btraspuesta[0][3]*btraspuesta[3][2]))+btraspuesta[3][0]*((btraspuesta[0][2]*btraspuesta[1][3])-(btraspuesta[0][3]*btraspuesta[1][2])));
   adjunta[2][2] =1*btraspuesta [0][0]*((btraspuesta [1][1]*btraspuesta [3][3])-(btraspuesta [1][3]* btraspuesta [3][1]))-btraspuesta [1][0]*((btraspuesta [0][1]*btraspuesta [3][3])-(btraspuesta [0][3]* btraspuesta [3][1]))+btraspuesta [3][0]*(( btraspuesta [0][1]*btraspuesta [1][3])-(btraspuesta [0][3]*btraspuesta [1][1]));
   adjunta[2][3] =-1*(btraspuesta[0][0]*((btraspuesta[1][1]*btraspuesta[3][2])-(btraspuesta[1][2]*btraspuesta[3][1]))-btraspuesta[1][0]*((btraspuesta[0][1]*btraspuesta[3][2])-(btraspuesta[0][2]*btraspuesta[3][1]))+btraspuesta[3][0]*((btraspuesta[0][1]*btraspuesta[1][2])-(btraspuesta[0][2]*btraspuesta[1][1])));
   adjunta[3][0] =-1*(btraspuesta[0][1]*((btraspuesta[1][2]*btraspuesta[2][3])-(btraspuesta[1][3]*btraspuesta[2][2]))-btraspuesta[1][1]*((btraspuesta[0][2]*btraspuesta[2][3])-(btraspuesta[0][3]*btraspuesta[2][2]))+btraspuesta[2][1]*((btraspuesta[0][2]*btraspuesta[1][3])-(btraspuesta[0][3]*btraspuesta[1][2])));
   adjunta[3][1] =1*btraspuesta [0][0]*((btraspuesta [1][2]*btraspuesta [2][3])-(btraspuesta [1][3]* btraspuesta [2][2]))-btraspuesta [1][0]*((btraspuesta [0][2]*btraspuesta [2][3])-(btraspuesta [0][3]* btraspuesta [2][2]))+btraspuesta [2][0]*(( btraspuesta [0][2]*btraspuesta [1][3])-(btraspuesta [0][3]*btraspuesta [1][2]));
   adjunta[3][2] =-1*(btraspuesta[0][0]*((btraspuesta[1][1]*btraspuesta[2][3])-(btraspuesta[1][3]*btraspuesta[2][1]))-btraspuesta[1][0]*((btraspuesta[0][1]*btraspuesta[2][3])-(btraspuesta[0][3]*btraspuesta[2][1]))+btraspuesta[2][0]*((btraspuesta[0][1]*btraspuesta[1][3])-(btraspuesta[0][3]*btraspuesta[1][1])));
   adjunta[3][3] =1*btraspuesta [0][0]*((btraspuesta [2][2]*btraspuesta [1][1])-(btraspuesta [1][2]* btraspuesta [2][1]))-btraspuesta [1][0]*((btraspuesta [2][2]*btraspuesta [0][1])-(btraspuesta [0][2]* btraspuesta [2][1]))+btraspuesta [2][0]*(( btraspuesta [0][1]*btraspuesta [1][2])-(btraspuesta [0][2]*btraspuesta [1][1]));
   
   d= ( btraspuesta [0][0]*adjunta[0][0])+( btraspuesta [1][0]*adjunta[1][0])+(btraspuesta [2][0]*adjunta[2][0])+( btraspuesta[3][0]*adjunta[3][0]);
   
       
   
       
   if(d!=0){
           for (int i = 0; i<4; i++) {
           for (int j = 0; j < 4; j++) {
                   inversa[i][j] = adjunta[i][j] / d;
               }
           }
           resultado2[0][0]=(inversa[0][0]*dividendo2[0][0])+(dividendo2[1][0]*inversa[0][1])+(dividendo2[2][0]*inversa[0][2])+(dividendo2[3][0]*inversa[0][3]);
           resultado2[1][0]=(dividendo2[0][0]*inversa[1][0])+(dividendo2[1][0]*inversa[1][1])+(dividendo2[2][0]*inversa[1][2])+(dividendo2[3][0]*inversa[1][3]);
           resultado2[2][0] = (dividendo2[0][0] * inversa[2][0]) + (dividendo2[1][0] * inversa[2][1]) + (dividendo2[2][0] * inversa[2][2]) + (dividendo2[3][0] * inversa[2][3]);
           resultado2[3][0] = (dividendo2[0][0] * inversa[3][0]) + (dividendo2[1][0] * inversa[3][1]) + (dividendo2[2][0] * inversa[3][2]) + (dividendo2[3][0] * inversa[3][3]);
           resultado2[0][1]=(dividendo2[0][1]*inversa[0][0])+(dividendo2[1][1]*inversa[0][1])+(dividendo2[2][1]*inversa[0][2])+(dividendo2[3][1]*inversa[0][3]);
           resultado2[1][1]=(dividendo2[0][1]*inversa[1][0])+(dividendo2[1][1]*inversa[1][1])+(dividendo2[2][1]*inversa[1][2])+(dividendo2[3][1]*inversa[1][3]);
           resultado2[2][1] = (dividendo2[0][1] * inversa[2][0]) + (dividendo2[1][1] * inversa[2][1]) + (dividendo2[2][1] * inversa[2][2]) + (dividendo2[3][1] * inversa[2][3]);
           resultado2[3][1] = (dividendo2[0][1] * inversa[3][0]) + (dividendo2[1][1] * inversa[3][1]) + (dividendo2[2][1] * inversa[3][2]) + (dividendo2[3][1] * inversa[3][3]);
           resultado2[0][2]=(dividendo2[0][2]*inversa[0][0])+(dividendo2[1][2]*inversa[0][1])+(dividendo2[2][2]*inversa[0][2])+(dividendo2[3][2]*inversa[0][3]);
           resultado2[1][2]=(dividendo2[0][2]*inversa[1][0])+(dividendo2[1][2]*inversa[1][1])+(dividendo2[2][2]*inversa[1][2])+(dividendo2[3][2]*inversa[1][3]);
           resultado2[2][2] = (dividendo2[0][2] * inversa[2][0]) + (dividendo2[1][2] * inversa[2][1]) + (dividendo2[2][2] * inversa[2][2]) + (dividendo2[3][2] * inversa[2][3]);
           resultado2[3][2] = (dividendo2[0][2] * inversa[3][0]) + (dividendo2[1][2] * inversa[3][1]) + (dividendo2[2][2] * inversa[3][2]) + (dividendo2[3][2] * inversa[3][3]);
           resultado2[0][3]=(dividendo2[0][3]*inversa[0][0])+(dividendo2[1][3]*inversa[0][1])+(dividendo2[2][3]*inversa[0][2])+(dividendo2[3][3]*inversa[0][3]);
           resultado2[1][3]=(dividendo2[0][3]*inversa[1][0])+(dividendo2[1][3]*inversa[1][1])+(dividendo2[2][3]*inversa[1][2])+(dividendo2[3][3]*inversa[1][3]);
           resultado2[2][3] = (dividendo2[0][3] * inversa[2][0]) + (dividendo2[1][3] * inversa[2][1]) + (dividendo2[2][3] * inversa[2][2]) + (dividendo2[3][3] * inversa[2][3]);
           resultado2[3][3] = (dividendo2[0][3] * inversa[3][0]) + (dividendo2[1][3] * inversa[3][1]) + (dividendo2[2][3] * inversa[3][2]) + (dividendo2[3][3] * inversa[3][3]);
         
       System.out.println("");
       System.out.println("La respuesta correcta es: ");
       System.out.println("");
           for (int i = 0; i < 4; i++) {
               for (int j = 0; j < 4; j++) {
                   System.out.print("(" + Math.round(resultado2[j][i]*1000.0)/1000.0 + ")");
                   if (j == 3) {
                       System.out.println("");
                   }
               }
           }
       }
   else{
       System.out.println("El determinante de la matriz no puede ser cero");
   }
   nopenal9=false;
   }
   }
       
    class string {
}
   
}
