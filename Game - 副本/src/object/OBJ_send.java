package object;

import main.GamePanel;

import javax.imageio.ImageIO;
//碎石
public class OBJ_send extends SuperObject{
    GamePanel gp;
    public OBJ_send(GamePanel gp){
        this.gp = gp;
        name = "send";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/send.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
        collision = true;

    }
}