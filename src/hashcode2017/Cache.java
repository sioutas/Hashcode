/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode2017;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gmants
 */
public class Cache {
    private int MaxCacheSize;
    private int RemainingCacheSize;
    private List<Video> cache_vid = new ArrayList<Video>();
    
    public Cache(int MaxCacheSize){
        this.MaxCacheSize = MaxCacheSize;
        this.RemainingCacheSize = MaxCacheSize;
    }
    
    
}
