import java.util.ArrayList;
import java.util.Scanner;

public class Taxi
{
    Scanner scan=new Scanner(System.in);
    private String placa;
    private String nameDriver;
    private String mensajeConductor=" ";
    ArrayList<Denuncia>denunciasTaxi=new ArrayList<>();
    public Taxi(String p, String n){
        this.placa=p;
        this.nameDriver=n;
    }
    public String getPlaca(){
        return this.placa;
    }
    public String getDriver(){
        return this.nameDriver;
    }
    public void enviarMensaje(String m){
        this.mensajeConductor=m;
    }
    public String getMensaje(){
        return this.mensajeConductor;
    }
    public void addDenun(Denuncia d){
        denunciasTaxi.add(d);
    }
    public int numDenun(){
        return denunciasTaxi.size();
    }
    public ArrayList<Denuncia> getDenunciasTaxi(){
        return denunciasTaxi;
    }
    /*public void printDenunTaxi(){
        if(denunciasTaxi.size()>0){
            for(int i=0;i<denunciasTaxi.size();i++){
               denunciasTaxi.get(i).printDenuncia();
            }
        }
        else{
            System.out.println("El taxi no cuenta con denuncias registradas");
        }
    }*/
    public static Taxi crearTaxi(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Escriba la placa del taxi");
        String pla=scan.next();
        String tax=capturaNameDriver();
        Taxi nuevo=new Taxi(pla, tax);
        return nuevo;
    }
    public static String capturaNameDriver(){
        Scanner sn=new Scanner(System.in);
        System.out.println("Escriba nombre de taxista");
        String taxista=sn.nextLine();
        return taxista;
    }
    public static void loginTaxista(ArrayList<Propietario>flotasPlataforma){
        Scanner scan=new Scanner(System.in);
        System.out.println("Escriba la placa del taxi");
        String pla=scan.next();
        //Declaramos un array de [n, m] dos casillas, aquí se almacenara lo que nos dé el metodo buscarEnPlataforma
        int[] hallar=new int[2];
        //El metodo del que ya hable antes retorna un array de dos posiciones, lo asignamos al array hallar que ya creamos
        hallar=Procesamiento.buscarEnPlataforma(pla, flotasPlataforma);
        int prop=hallar[0];//la posicion [0] de ese array se supone que es la posicion del propietario dentro de flotasPlataforma
        int tax=hallar[1];//Y la posicion [1], la posicion del taxi dentro del arreglo de taxis que tiene el propietario
        
        //Si el metodo buscarEnPlataforma() no encuentra el taxi les atribuira posicion "-1" a ambos individuos del array [-1,-1]
        //Por tanto basta con saber que uno (prop o tax) es menor a 0 para saber que no existe el taxi al que se quiere acceder
        if(prop<0){
                System.out.println("Intente de nuevo");
                loginTaxista(flotasPlataforma);
        }
        //Si el caso if no fue el caso se procede a entrar en el sign in del taxista
        else{
            inTaxista(flotasPlataforma, prop, tax);
        }
    }
    public static void inTaxista(ArrayList<Propietario>flotasPlataforma,int prop,int tax){
        Scanner scan=new Scanner(System.in);
        //Las siguientes dos líneas son por comodidad
        Propietario esteProp=flotasPlataforma.get(prop);
        Taxi esteTax=flotasPlataforma.get(prop).getTaxi(tax);
 
        //Creo que lo que sigue se puede mas o menos entender por si mismo
        System.out.println("Bienvenid@ señor(a) "+esteTax.getDriver()+" a Denuncia Tax");
        System.out.println("Que desea hacer?");
        System.out.println("1. Ver denuncias recibidas");
        System.out.println("2. Ver mensaje de "+esteProp.getPropietario());
        //System.out.println("3. Enviar mensaje a "+esteProp.getPropietario());
        System.out.println("3. Regresar a menu de Usuarios");
        int a=scan.nextInt();
        switch(a){
            case 1:{
                Salidas.printDenunForTax(flotasPlataforma, prop, tax);
                inTaxista(flotasPlataforma, prop, tax);
                break;
            }
            case 2:{
                Salidas.printMensaje(flotasPlataforma, prop, tax);
                inTaxista(flotasPlataforma, prop, tax);
                break;
            }
            default:{
                Principal.main();
                break;
            }
        }
    }
}
