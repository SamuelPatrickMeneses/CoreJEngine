
package Core;

/**
 *
 * @author Sameul P M
 */
public final class FrameCounter {
    private long fps;//fps em calculo
    private long lfps;//fps em exibição
    private long ti;//tempo inicial do frame
    private long nt;//tempo final do frame
    private long tf;//durçao do frames
    private long limitFrame;//limite de fremes
    private long realTime;//inicio do segundo
    
    public FrameCounter(int nfps){
        this.setFps(nfps);   
    }
    
    public void startCount(){
        this.ti = System.nanoTime();
        this.realTime = ti;
        this.nt = this.ti + this.tf;
    }
    
    public void update(){
        this.ti = System.nanoTime();
        this.nt = this.ti + this.tf;         
        this.fps++;
        if((System.nanoTime() - this.realTime)>= 1000000000){
            this.lfps = this.fps;
            this.fps = 0;
            this.realTime = System.nanoTime();
        }
        try{
            if((nt - System.nanoTime())>=0){
                long t =(long)(this.nt - System.nanoTime())/1000000;
                Thread.sleep(t);
            }
        }catch(IllegalArgumentException | InterruptedException e){
        }
    }
    public long getFps(){
         return this.lfps;
        
    }
    public void setFps(long fps){
        this.limitFrame = fps;
        this.tf =(long) (1000000000/fps);
    }
    public  long getlimitFrame(){
        return this.limitFrame;
    }
}
