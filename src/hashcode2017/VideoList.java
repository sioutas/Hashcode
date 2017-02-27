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
public class VideoList extends ArrayList<Endpoint>{
    private List<Endpoint> EndpointVideoList = new ArrayList<Endpoint>();
    
    public VideoList(List<Endpoint> list) {
        EndpointVideoList = list;
    }
}