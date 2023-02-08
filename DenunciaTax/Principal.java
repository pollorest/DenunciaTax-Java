import java.util.ArrayList;
import java.util.Scanner;

public class Principal
{   
    static Scanner scan=new Scanner(System.in);
    static ArrayList<Propietario>flotasPlataforma=new ArrayList<>();
    //El arrayList "flotasPlataforma" es un arreglo de objetos Propietario, por cada creacion aumentará su tamaño
    public static void main(){
        
        int user = Entradas.pedirOpcion();
        
        // Primero se deben crear los propietarios
   
        if(user==1){
            Denuncia.crearDenuncia(flotasPlataforma);
            Entradas.deseoPasajero(flotasPlataforma);
            
        }
        else if(user==2){
            flotasPlataforma = Propietario.loginPropietario(flotasPlataforma);
            
        }
        else if(user==3){
            Taxi.loginTaxista(flotasPlataforma);
        }
        else{
            Persistencia.fin();
        }
        

    }
    

    //public static void loginUsuario(){
        //crearDenuncia();
    //}
    
    
    

}
