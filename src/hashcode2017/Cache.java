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
    private List<Integer> endpoints = new ArrayList<Integer>();
    Hashcode2017 hc;
    
    public Cache(int MaxCacheSize){
        this.MaxCacheSize = MaxCacheSize;
        this.RemainingCacheSize = MaxCacheSize;
    }
    
    public void AddEndpoint(int i){
        endpoints.add(i);
    }
    
    public void algorithm() {
        VideoList[] EndpointVideoList = new VideoList[endpoints.size()];
        for (int i = 0; i < endpoints.size(); i++) {
            EndpointVideoList[i] = hc.sendBuffer(endpoints.get(i));
        }
        
    }
}
