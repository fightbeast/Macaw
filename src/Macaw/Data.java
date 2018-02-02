package Macaw;
public class Data {
  public int time;
  public int BO;

  public Data(int time){
    this.time = time;
  }
  public Data(int time,int BO){
    this.time = time;
    this.BO = BO;
  }
  public void set(int time){
    this.time = time;
  }
  public void setBO(int BO){
    this.BO = BO;
  }
}
