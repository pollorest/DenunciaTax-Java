import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Persistencia
{
    public static void fin(){
        File f = new File("persistencia.txt");
        FileWriter writer = null;
        PrintWriter pw = null;
        //ACA CREO EL ARCHIVO SINO EXISTE
        if (!f.exists()) {
            try{
                f.createNewFile();
            }catch(IOException exception){
                System.err.println("Error creating the file");
            }
        }
        try{
            writer = new FileWriter("persistencia.txt",true);
            pw = new PrintWriter(writer);
            pw.println("       Fin Proceso");
            pw.println("-------------------------");
            pw.println("");
            pw.println("");
        }catch(IOException exception){
                System.err.println("Error opening the file");
        }finally {
           try {
               //ACA CIERRO EL ARCHIVO
           if (null != writer)
              writer.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
    public static void registroDenuncia(String placa, String motivo, String descripcion, String momento, String flota, String taxista){
        File f = new File("persistencia.txt");
        FileWriter writer = null;
        PrintWriter pw = null;
        //ACA CREO EL ARCHIVO SINO EXISTE
        if (!f.exists()) {
            try{
                f.createNewFile();
            }catch(IOException exception){
                System.err.println("Error creating the file");
            }
        }
        try{
            writer = new FileWriter("persistencia.txt",true);
            pw = new PrintWriter(writer);
            pw.println("Se registra denuncia con los siguientes detalles: ");
            pw.println("");
            pw.println("Placa: "+placa);
            pw.println("Motivo: "+motivo);
            pw.println("Descripcion: "+descripcion);
            pw.println("Momento: "+momento);
            pw.println("El taxi con esta placa lo conduce "+taxista+" y pertenece a la flota "+flota);
            pw.println("");
            pw.println("");
        }catch(IOException exception){
                System.err.println("Error opening the file");
        }finally {
           try {
               //ACA CIERRO EL ARCHIVO
           if (null != writer)
              writer.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
    public static void registroFlota(String flota){
        File f = new File("persistencia.txt");
        FileWriter writer = null;
        PrintWriter pw = null;
        //ACA CREO EL ARCHIVO SINO EXISTE
        if (!f.exists()) {
            try{
                f.createNewFile();
            }catch(IOException exception){
                System.err.println("Error creating the file");
            }
        }
        try{
            writer = new FileWriter("persistencia.txt",true);
            pw = new PrintWriter(writer);
            pw.println("Se registra la flota "+flota);
            pw.println("");
            pw.println("");
        }catch(IOException exception){
                System.err.println("Error opening the file");
        }finally {
           try {
               //ACA CIERRO EL ARCHIVO
           if (null != writer)
              writer.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
    public static void registroVehiculo(String flota, String placa, String conductor){
        File f = new File("persistencia.txt");
        FileWriter writer = null;
        PrintWriter pw = null;
        //ACA CREO EL ARCHIVO SINO EXISTE
        if (!f.exists()) {
            try{
                f.createNewFile();
            }catch(IOException exception){
                System.err.println("Error creating the file");
            }
        }
        try{
            writer = new FileWriter("persistencia.txt",true);
            pw = new PrintWriter(writer);
            pw.println("La flota "+flota+" registra un nuevo taxi:");
            pw.println("Taxi de placa "+placa+", conducido por "+conductor);
            pw.println("");
            pw.println("");
        }catch(IOException exception){
                System.err.println("Error opening the file");
        }finally {
           try {
               //ACA CIERRO EL ARCHIVO
           if (null != writer)
              writer.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
    public static void mensaje(String mensaje, String placa, String flota){
        File f = new File("persistencia.txt");
        FileWriter writer = null;
        PrintWriter pw = null;
        //ACA CREO EL ARCHIVO SINO EXISTE
        if (!f.exists()) {
            try{
                f.createNewFile();
            }catch(IOException exception){
                System.err.println("Error creating the file");
            }
        }
        try{
            writer = new FileWriter("persistencia.txt",true);
            pw = new PrintWriter(writer);
            pw.println("La flota "+flota+" le envia el siguiente mensaje a la placa "+placa+":");
            pw.println(mensaje);
            pw.println("");
            pw.println("");
        }catch(IOException exception){
                System.err.println("Error opening the file");
        }finally {
           try {
               //ACA CIERRO EL ARCHIVO
           if (null != writer)
              writer.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
    

}
