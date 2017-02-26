/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode2017;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author kourt
 */
public class Hashcode2017 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int counter_line = 0;
        
        
        File file = new File("/home/antonis/Downloads/kittens.in");
        
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()){
            
            String[] entries = scanner.nextLine().split(" ");
            
            if (counter_line == 0){
                //apothikeusi
                System.out.println("line0: " + Arrays.toString(entries));
                counter_line++;
                Video[] video =  new Video[Integer.parseInt(entries[0])];
                Endpoint[] endpoint = new Endpoint[Integer.parseInt(entries[1])];
                
            }else if (counter_line == 1) {
                //apothikeusi
                for(int i=0; i<entries.length;i++){
                    video[i]= new Video(i,Integer.parseInt(entries[i])); 
                }
                System.out.println("line1: " + Arrays.toString(entries));
                counter_line++;
            }else {
                
                int endp_count=0;
                
                if (entries.length == 2){
                    endp_count = Integer.parseInt(entries[1]);
                    //apothikeusi latency data center
                    
                    for (int i=0; i< endp_count; i++){
                       
                        String[] end_cache = scanner.nextLine().split(" ");
                        //apothikeusi
                        System.out.println("End cache:" + i + " " + Arrays.toString(end_cache));
                    }
                    
                }else{
                    while (scanner.hasNext()){
                        String[] vid_req = scanner.nextLine().split(" ");
                        //apothikeusi
                        System.out.println("Vid Req:" +Arrays.toString(vid_req));
                    }
                     
                }
                
               
            }
        }
    int TotalEndponts,TotalVideo;
    Endpoint[] endpoints = new Endpoint[TotalEndponts];
    Video[] Videos = new Video[TotalVideo];
    
    int i;
    int j;
    double value;
    List<request> video;
    request r;
    for(i=0;i<TotalVideo;i++){
        j=0;
        video = Videos[i].getVideoList();
        while(true){            
            try{
                r = video.get(j);
                value = r.getRequest()/Videos[i].getSize();
                j++;
                endpoints[r.getEndpoint()].addBuffer(r,i,value); 
            }catch (IndexOutOfBoundsException ex){
                break;
            }
         }
    }
    for (i=0;i<TotalEndponts;i++)
        endpoints[i].sort();    
    }
    
}
