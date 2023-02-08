import java.util.Scanner;
import java.lang.*;
import java.util.ArrayList;

public class Entradas
{

    public static int pedirOpcion(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Que tipo de usuario es?");
        System.out.println("1. Pasajero");
        System.out.println("2. Propietario");
        System.out.println("3. Taxista");
        System.out.println("");
        System.out.println("4. Salir");
        int user=sc.nextInt();
        
        return user;
    }
    public static String capturaMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el mensaje que quiere enviarle al taxista:");
        String m=sc.nextLine();
        return m;
    }
    public static void deseoPasajero(ArrayList<Propietario>flotasPlataforma){
        Scanner scan=new Scanner(System.in);
        System.out.println("Que desea hacer?");
        System.out.println("1. Registrar otra denuncia");
        System.out.println("2. Regresar a menú de usuarios");
        int s=scan.nextInt();
        if(s==1){
                Denuncia.crearDenuncia(flotasPlataforma);
                deseoPasajero(flotasPlataforma);
        }
        else if(s==2){
            Principal.main();
        }
    }
    public static String opcionMotivo(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Motivo de denuncia: "); 
        System.out.println("1. Mal trato");  
        System.out.println("2. Exceso de tarifa"); 
        System.out.println("3. Mala conducta");  
        System.out.println("4. Mala conduccion");  
        System.out.println("5. Otro");  
        int mot=scan.nextInt();
        String motivo="";
        if(mot==1){
            motivo="Mal trato";
        }
        else if(mot==2){
            motivo="Exceso de tarifa";
        }
        else if(mot==3){
            motivo="Mala conducta";
        }
        else if(mot==4){
            motivo="Mala conduccion";
        }
        else if(mot==5){
            motivo=otraOpcion();
        }
        else{
            System.out.println("Opcion no existe");
            motivo=Denuncia.capturaMotivo();
        }
        return motivo;

    }
    public static int opcionPropietario(){
            Scanner scan=new Scanner(System.in);
            System.out.println("Que desea hacer?");
            System.out.println("1. Registrar nuevo vehiculo");
            System.out.println("2. Buscar denuncias de un taxi en especifico");
            System.out.println("3. Ver informe detallado de las denuncias hechas a la flota");
            System.out.println("4. Enviar mensaje a taxista");
            System.out.println("5. Regresar a menú de usuarios");
            int elige=scan.nextInt();
            return elige;
    }
    public static String otraOpcion(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Escriba cual otra opcion:");
        String motivo=scan.nextLine();
        return motivo;
    }
}