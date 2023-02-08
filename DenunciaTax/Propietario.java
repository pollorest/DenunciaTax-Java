import java.util.ArrayList;
import java.util.Scanner;

public class Propietario
{
    String nameProp;
    ArrayList<Taxi>taxisFlota=new ArrayList<>();
    /*Al crear un nuevo propietario obviamente tendra los atributos y metodos de la clase,     
    uno de ellos es el ArrayList "taxisFlota" el cual sera modificable por el propietario
    y aumentara su tamaño cuando este cree nuevos objetos taxi para su flota*/ 
    public Propietario(String n){
        this.nameProp=n;
    }
    public String getPropietario(){
        return this.nameProp;
    }
    public int buscarTaxi(String s){
        for(int i=0;i<taxisFlota.size();i++){
            if(taxisFlota.get(i).getPlaca().equalsIgnoreCase(s)){
                System.out.println("coincide");
                return i;
            }
        }
        return -1;
    }
    public int sizeFlota(){
        return taxisFlota.size();
    }
    public Taxi getTaxi(int i){
        return taxisFlota.get(i);
    }
    public void addTaxi(Taxi t){
        taxisFlota.add(t);
    }
    public int numDenunFlota(){
        int cont=0;
        for(int i=0;i<taxisFlota.size();i++){
            cont=cont+taxisFlota.get(i).numDenun();
        }
        return cont;
    }
    
    
    public static ArrayList<Propietario> loginPropietario(ArrayList<Propietario>flotasPlataforma){
        //Pedimos el nombre de la flota para comprobar si se encuentra dentro del arreglo flotasPlataforma
        System.out.println("Escriba el nombre de su flota");
        Scanner scan=new Scanner(System.in);
        String nom=scan.nextLine();
        //El metodo posEnFlota que está en Procesamiento retornara -1 si no se encuentra, de lo contrario
        //la posición n>=0 del objeto Propietario dónde se encuentra el nombre del propietario, en 
        //caso de que esa posicion sea mayor es porque el Propietario ya se encuentra y le daremos la bienvenida(Ver lo que pasa en else)
        if(Procesamiento.posEnFlota(nom, flotasPlataforma)>=0){
            //Este es el mismo metodo que utilizamos en el if de arriba sólo que ahora lo necesitamos para hacer 
            //las operaciones del objeto Propietario quien ya nos señalo quién era
            int posc=Procesamiento.posEnFlota(nom, flotasPlataforma);
            //Aqui se atribuye el objeto Propietario de flotasPlataforma ubicado en la posicion posc a "estePropietario"
            //Eso es por un poco de comodidad para no tener que escribir tanto lo que esta a la derecha de la asignacion
            Propietario estePropietario=flotasPlataforma.get(posc);
            
            System.out.println("Bienvenido "+estePropietario.getPropietario()+" a DenunciaTax");
            //Llamamos a este metodo de Entradas el cual le pedirá al propietario que indique que quiere hacer
            //Cabe recalcar que asi como tuvimos que empezar creando por lo menos un propietario, también en este caso
            //tendrán que haber taxis creados, por lo tanto de no haber taxis, se registraran
            int elige=Entradas.opcionPropietario();
            

            //Quizo registrar un nuevo taxi
            if(elige==1){
                //Se llama al metodo crearTaxi el cual pide las entradas sobre la informacion de este nuevoTaxi, ver la clase Taxi si quiere profundizar
                Taxi nuevo=Taxi.crearTaxi();
                //Como ya tenemos nuestro objeto Taxi creado lo agregamos a la flota(taxisFlota) de estePropietario
                estePropietario.addTaxi(nuevo); 
                System.out.println("Taxi añadido");
                //Se imprime en el archivo txt el registro del taxi
                Persistencia.registroVehiculo(estePropietario.getPropietario(), nuevo.getPlaca(), nuevo.getDriver());
                //Se regresa al menu de usuarios
                loginPropietario(flotasPlataforma);
                return flotasPlataforma;
                
            }
            //Quizo ver las denuncias de un taxi en especifico
            else if(elige==2){
                System.out.println("Digite la placa del taxi:");
                String p=scan.next();
                //Se pidio la placa para comprobar su existencia, el metodo buscarTaxi funciona muy similar al metodo con el buscamos el propietario
                int posPlaca=flotasPlataforma.get(posc).buscarTaxi(p);
                if(posPlaca>=0){
                    Salidas.printDenunTaxi(flotasPlataforma,posc, posPlaca);
                }
                else{
                    System.out.println("Vehiculo no registrado");
                }
                loginPropietario(flotasPlataforma);
            }
            //Quizo ver las denuncias de su flota en general(todas de los taxis que tiene bajo mando)
            else if(elige==3){
                Salidas.printDenunFlota(flotasPlataforma, posc);
                loginPropietario(flotasPlataforma);
            }
            //Quizo enviar un mensaje al taxista
            else if(elige==4){
                System.out.println("Escriba la placa del taxi:");
                String pla=scan.next();
                int halla=flotasPlataforma.get(posc).buscarTaxi(pla);
                if(halla<0){
                    System.out.println("Taxi no esta registrado en su flota");
                }
                //Si el taxi ya fue registrado por el propietario podrá enviarle un mensaje
                else{
                    String men=Entradas.capturaMensaje();
                    //con el metodo enviarMensaje en realidad estamos asignado men a un String que tiene taxi llamado mensaje
                    flotasPlataforma.get(posc).getTaxi(halla).enviarMensaje(men);
                    //Imprimimos en el archivo txt que se envió el mensaje
                    Persistencia.mensaje(men, pla, estePropietario.getPropietario());
                    System.out.println("Mensaje enviado con éxito");
                }
                loginPropietario(flotasPlataforma);
            }
            //Quizo volver al menu de usuarios, el principal
            else if(elige==5){
               Principal.main();
            }
   
            else{
                System.out.println("Opcion no existe, vuelve a intentarlo");
                loginPropietario(flotasPlataforma);
            }    
        }
        //De no haber retorno de un numero >=0 es porque no se encontró y se procedera a pedir el nombre para crear
        else{
            System.out.println("No se encuentra, registraremos su flota");
            System.out.println("Digite nombre de flota:");    
            String flot=scan.nextLine();
            //Aqui creamos ese nuevo propietario
            Propietario nuevo=new Propietario(flot);
            //Aqui estamos añadiendo ese objeto Propietario llamado "nuevo" al ArrayList principal flotasPlataforma
            flotasPlataforma.add(nuevo);
            //Mediante este metodo de Persistencia, estamos imprimiendo que se registro esa flota 
            Persistencia.registroFlota(flot);
            System.out.println("De nuevo:");
            //Regresamos al main donde se le volvera a pedir el tipo de usuario, pero ahora ya está registrado
            Principal.main();
        }
        
        return flotasPlataforma;
        
    }
    
    
    
 
    
}
