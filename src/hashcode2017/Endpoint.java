/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode2017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author antonis
 */
public class Endpoint {
    private final int id;
    private final int lattency;
    private List<CacheLattency> LattencyList= new ArrayList<CacheLattency>();
    private CacheLattency lat;
    private List<VidReq> buffer =new ArrayList<VidReq>();
    private int i=0;
    
    public Endpoint(int id, int lattency){
        this.id = id;
        this.lattency = lattency;
    }
    public int getL(){
        return lattency;
    }
    public void addLattency(int cacheid , int time){
        lat = new CacheLattency(cacheid, time);
        LattencyList.add(lat);
    }
    
    public void sort(){
        Collections.sort(LattencyList);     //Sorting to ascending order
        Collections.reverse(LattencyList);  // and then reverse order
        Collections.sort(buffer);     //Sorting to ascending order
        Collections.reverse(buffer);  // and then reverse order
            
    }
    public void addBuffer(request r, int VId, double rate){
        VidReq v = new VidReq(r,VId,rate);
        buffer.add(v);        
    }
    

}
