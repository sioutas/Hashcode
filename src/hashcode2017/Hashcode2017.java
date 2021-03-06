/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode2017;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
    
    private static int TotalEndponts,TotalVideo, TotalRequest, TotalCaches, MaxCacheSize;
    private static Video[] Videos;
    private static Endpoint[] endpoints;
    private static Cache[] caches;
    
    public static void main(String[] args) {
        int counter_line = 0;
        int i,j=0;
        File file = new File("input/kittens.in");
        
        Scanner scanner;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            return;
        }
        while (scanner.hasNext()){
            String[] entries = scanner.nextLine().split(" ");
            
            if (counter_line == 0){
                //apothikeusi                                
                counter_line++;
                TotalVideo = Integer.parseInt(entries[0]);
                TotalEndponts = Integer.parseInt(entries[1]);
                TotalRequest = Integer.parseInt(entries[2]);
                TotalCaches = Integer.parseInt(entries[3]);
                MaxCacheSize = Integer.parseInt(entries[4]);
                Videos =  new Video[TotalVideo];
                endpoints = new Endpoint[TotalEndponts];
                caches = new Cache[TotalCaches];
            }else if (counter_line == 1) {
                //apothikeusi
                for(i=0; i<entries.length;i++){
                    Videos[i]= new Video(i,Integer.parseInt(entries[i])); 
                }
                //System.out.println("line1: " + Arrays.toString(entries));
                counter_line++;
            }else {
                
                int endp_count=0;
                
                if (entries.length == 2){
                    endp_count = Integer.parseInt(entries[1]);
                    //apothikeusi latency data center
                    endpoints[j] = new Endpoint(j,Integer.parseInt(entries[0]));
                    
                    j++;
                    //System.out.println("---- " + j + " " + (entries[0]));
                    for (i=0; i<endp_count; i++){
                        String[] end_cache = scanner.nextLine().split(" ");
                        caches[Integer.parseInt(end_cache[0])].AddEndpoint(j-1);
                        //apothikeusi
                        //System.out.println("End cache:" + i + " " + Arrays.toString(end_cache) + " " + (end_cache[1]));
                        endpoints[j-1].addLattency(Integer.parseInt(end_cache[0]), Integer.parseInt(end_cache[1]));
                    }
                    
                }else{
                    //System.out.println("+++ " + Arrays.toString(entries));
                    Videos[Integer.parseInt(entries[0])].addRequest(Integer.parseInt(entries[2]), Integer.parseInt(entries[1]));
                    while (scanner.hasNext()){
                        String[] vid_req = scanner.nextLine().split(" ");
                        //apothikeusi
                        Videos[Integer.parseInt(vid_req[0])].addRequest(Integer.parseInt(vid_req[2]), Integer.parseInt(vid_req[1]));
                        //System.out.println("Vid Req:" +Arrays.toString(vid_req));
                    }
                }
            }
        }
        scanner.close();
        System.out.println("Reading completed");
        
        double value;
        List<request> video;
        request r;
        for(i=0;i<TotalVideo;i++){
            j=0;
            Videos[i].sort();
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
        
        writeFile();
    }
    
    private static void writeFile(){
        BufferedWriter bw = null;
        FileWriter fw = null;
        int NumCashes =3; //test variable... later cashe number
        try {
            fw = new FileWriter("out1.txt");
            bw = new BufferedWriter(fw);     
            bw.write(Integer.toString(NumCashes));
            int i;
            for (i=0;i<NumCashes;i++){
                String out = "\n" + Integer.toString(i);
                //while(true)
                    out = out + " "+ "aa" ;
                    //out = out + " "+ "bb" ;
                
                
                bw.write(out);
            }
            
            
            fw.flush();
            bw.flush();
            fw.close();
            bw.close();
        } catch (IOException ex) {
            System.out.println("Writing Error");
            System.exit(-1);
        }
    }
    
    public List<Endpoint> sendBuffer(int i) {
        return endpoints[i].getBuffer();
    }
}
