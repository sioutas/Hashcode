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
 * @author kourt
 */
public class Video {
    private final int id, size;
    private List<request> requestList = new ArrayList<request>();
    private request rqst;
    public Video(int id, int size) {
        this.id=id;
        this.size=size;
    }
    
    public int getId() {    //returns the id of the video
        return id;
    }
    
    public int getSize() {  //contains size of video in Mb
        return size;
    }
    
    public List getVideoList() {    //returns the list of requests from each endpoint for this video
        return requestList;
    }
    
    public void addRequest(int requestn, int nendpoint) {
        rqst = new request(requestn, nendpoint);
        requestList.add(rqst);
    }
    
    public void sort() {
        Collections.sort(requestList);
        Collections.reverse(requestList);
        //System.out.println(requestList.get(0).getRequest() +" " + requestList.get(1).getRequest());
    }
}
