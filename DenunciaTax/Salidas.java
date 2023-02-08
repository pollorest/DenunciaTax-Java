import java.util.ArrayList;

public class Salidas
{
    public static void notificarTaxista(String placa){
        System.out.println("Alerta para taxista de carro con placa número "+ placa);
    }
    
    public static void printDenunTaxi(ArrayList<Propietario>flotasPlataforma , int posFlota , int posTaxi){
        Taxi esteTaxi=flotasPlataforma.get(posFlota).getTaxi(posTaxi);
        ArrayList<Denuncia>d=flotasPlataforma.get(posFlota).getTaxi(posTaxi).denunciasTaxi;
        if(d.size()>0){
            System.out.println("El taxi con placa "+esteTaxi.getPlaca()+" es conducido por "+esteTaxi.getDriver()+
             " cuenta con "+esteTaxi.numDenun()+" denuncia(s):");
            System.out.println(" ");
            for(int i=0;i<d.size();i++){
               System.out.println("Denuncia numero "+(i+1)+":");
               d.get(i).printDenuncia();
               System.out.println(" ");
            }
        }
        else{
            System.out.println("El taxi con placa: "+esteTaxi.getPlaca()+" es conducido por "+esteTaxi.getDriver()+
             ", no cuenta con denuncias registradas");
            System.out.println(" ");

        }
        
    }
    public static void printDenunFlota(ArrayList<Propietario>flotasPlataforma , int posFlota){
        Propietario esteProp=flotasPlataforma.get(posFlota);
        ArrayList<Taxi>c=flotasPlataforma.get(posFlota).taxisFlota;
        if(c.size()>0){
            System.out.println("La flota "+esteProp.getPropietario()+" cuenta con "+esteProp.numDenunFlota()+" denuncia(s) registrada(s):");
            System.out.println(" ");
            for(int j=0;j<c.size();j++){
                printDenunTaxi(flotasPlataforma, posFlota, j);
            }
        }
        else{
            System.out.println("La flota "+esteProp.getPropietario()+" no cuenta con denuncias registradas");
            System.out.println(" ");
        }
    }
    public static void printDenunForTax(ArrayList<Propietario>flotasPlataforma , int posFlota, int posTaxi){
        Taxi esteTaxi=flotasPlataforma.get(posFlota).getTaxi(posTaxi);
        ArrayList<Denuncia>d=esteTaxi.denunciasTaxi;
        if(d.size()>0){
            System.out.println("Usted cuenta con "+esteTaxi.numDenun()+" denuncia(s):");
            System.out.println(" ");
            for(int i=0;i<d.size();i++){
               System.out.println("Denuncia numero "+(i+1)+":");
               d.get(i).printDenuncia();
               System.out.println(" ");
            }
        }
        else{
            System.out.println(" Usted no cuenta con denuncias registradas");
            System.out.println(" ");

        }
    }
    public static void printMensaje(ArrayList<Propietario>flotasPlataforma , int posFlota, int posTaxi){
        Propietario flota=flotasPlataforma.get(posFlota);
        Taxi esteTax=flota.getTaxi(posTaxi);
        String mensaje=esteTax.getMensaje();
        if(mensaje.length()>4){
            System.out.println(flota.getPropietario()+" le ha enviado el siguiente mensaje:");
            System.out.println(mensaje);
            System.out.println(" ");
        }
        else{
            System.out.println(flota.getPropietario()+" no le ha enviado ningún mensaje:");
            System.out.println(" ");
        }
    }
    /*public static void verTaxisFlota(ArrayList<Propietario>flotasPlataforma , int posFlota){
        Propietario esteProp=flotasPlataforma.get(posFlota);
        ArrayList<Taxi>c=flotasPlataforma.get(posFlota).taxisFlota;
        if(c.size()>0){
            
        }
    }*/

}
