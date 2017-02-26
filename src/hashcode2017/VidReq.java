/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode2017;

/**
 *
 * @author Antonis
 */
public class VidReq implements Comparable<VidReq> {
    private request r;
    private int id;
    private double rate;
    private boolean cached = false;
    public VidReq(request r, int id, double rate){
        this.r = r;
        this.id =id;
        this.rate = rate;
    }
    public int getId(){
        return id;
    }
    public request getR(){
        return r;
    }
    public double getRate(){
        return rate;
    }
    @Override
    public int compareTo(VidReq t) {
        if (this.rate > t.getRate())
            return 1;
        else if (this.rate < t.getRate())
            return -1;
        return 0;
    }
    public void Cached(){
        cached = true;
    }
    
}
