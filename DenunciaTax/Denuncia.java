import java.util.Scanner;
import java.util.ArrayList;

public class Denuncia
{
    Scanner scan=new Scanner(System.in);
    private String placa;
    private String motivo;
    private String descripcion="Sin descripcion";
    private String momento;
    public void Denuncia(){
    }
    public void denunciar(String p,String mot,String d,String moment){
        this.placa=p;
        this.motivo=mot;
        this.descripcion=d;
        this.momento=moment;
    }
    public void printDenuncia(){
        System.out.println("La placa denunciada es: "+placa);
        System.out.println("El motivo es: "+motivo);
        System.out.println("La descripcion es: "+descripcion);
        System.out.println("El momento fue: "+momento);
    }
    
    public String getPlaca(){
        return this.placa;
    }
    
    public String getMotivo(){
        return this.motivo;
    }
    
    public String getMomento(){
        return this.momento;
    }
    
    public String getDescripcion(){
        return this.descripcion;
    }
    
    public String capturaPlaca(){
        System.out.println("Placa que quiere denunciar:");
        String placa=scan.nextLine();
        return placa;
    }
    
    public static String capturaMotivo(){
        String motivo=Entradas.opcionMotivo();
        return motivo;
    }
    
    public String capturaDescripcion(){
        System.out.println("Mas detalles si lo desea: ");
        String descrip=scan.nextLine();
        if(descrip.length()>3){
            this.descripcion=descrip;
        }
        return descripcion;
    }
    
    public String capturaMomento(){
        System.out.println("Fecha en que ocurrio: ");
        String momento=scan.nextLine();
        return momento;
    }
    
    public static ArrayList<Propietario> crearDenuncia(ArrayList<Propietario>flotasPlataforma){
        Scanner scan=new Scanner(System.in);
        System.out.println("Bienvenido a DenunciaTax, ingrese los datos de su denuncia");  
        Denuncia nuevaDenun=new Denuncia();
        String placa=nuevaDenun.capturaPlaca();
        String motivo=nuevaDenun.capturaMotivo();
        String descrip=nuevaDenun.capturaDescripcion();
        String momento=nuevaDenun.capturaMomento();
        nuevaDenun.denunciar(placa, motivo, descrip, momento);
        nuevaDenun.printDenuncia();
        System.out.println("Desea registrar la denuncia?");
        System.out.println("1. Si");
        System.out.println("2. Volver a crear una Denuncia");
        System.out.println("3. No quiero crear Denuncia");
        int des=scan.nextInt();
        if(des==1){
            int[] hallar=new int[2];
            hallar=Procesamiento.buscarEnPlataforma(placa, flotasPlataforma);
            int prop=hallar[0];
            int tax=hallar[1];
            if(prop<0){
                System.out.println("Placa no registrada, vuelva a intentarlo");
                crearDenuncia(flotasPlataforma);
            }
            else{flotasPlataforma.get(prop).getTaxi(tax).addDenun(nuevaDenun);
                String nameFlota=flotasPlataforma.get(prop).getPropietario();
                String nameTax=flotasPlataforma.get(prop).getTaxi(tax).getDriver();
                Persistencia.registroDenuncia(placa, motivo, descrip, momento, nameFlota, nameTax);
                System.out.println("Denuncia registrada con éxito");}
        }
        else if(des==2){
            crearDenuncia(flotasPlataforma);
        }
        else if(des==3){
        }
        return flotasPlataforma;
    }
    
    
}
