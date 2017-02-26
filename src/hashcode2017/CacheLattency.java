/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode2017;

/**
 *
 * @author antonis
 */
public class CacheLattency implements Comparable<CacheLattency> {
    private final int id_cache;
    private int time;
    public CacheLattency(int id, int time){
        this.time = time;
        this.id_cache = id;    
    }
    @Override
    public int compareTo(CacheLattency t) {
        if (this.time > t.getTime())
            return 1;
        else if (this.time < t.getTime())
            return -1;
        return 0;
    }
    
    public int getTime(){
        return time;
    }
    
    public int getCacheID(){
        return id_cache;
    }
}