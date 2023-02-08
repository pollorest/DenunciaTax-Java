import java.util.ArrayList;

public class Procesamiento
{
  
    public static int[] buscarEnPlataforma(String p, ArrayList<Propietario>flotasPlataforma){
        int []m=new int[2];
        for(int k=0;k<flotasPlataforma.size();k++){
            for(int j=0;j<flotasPlataforma.get(k).sizeFlota();j++){
                if(flotasPlataforma.get(k).getTaxi(j).getPlaca().equalsIgnoreCase(p)){
                    int []n=new int[2];
                    n[0]=k;
                    n[1]=j;
                    return n;
                }
            }
        }
        
        m[0]=-1;
        m[1]=-1;
        return m;
    }
    
    
    public static int posEnFlota(String n, ArrayList<Propietario>flotasPlataforma){
        int i=-1;
        for(int j=0;j<flotasPlataforma.size();j++){
            if(flotasPlataforma.get(j).getPropietario().equalsIgnoreCase(n)){
                i=j;
            }
        }
        return i;
    }
}

