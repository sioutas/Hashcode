/*public
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode2017;

/**
 *
 * @author kourt
 */
public class request  implements Comparable<request>{
    private int requestn, nendpoint;
    
    public request(int requestn, int nendpoint){
        this.requestn = requestn;
        this.nendpoint = nendpoint;
    }
    
    public int getRequest(){
        return requestn;
    }
    
    public int getEndpoint(){
        return nendpoint;
    }
    
    @Override
    public int compareTo(request d) {
        if (d.getRequest() > getRequest())
            return 1;
        else if (d.getRequest() < getRequest())
            return -1;
        return 0;
    }
}
