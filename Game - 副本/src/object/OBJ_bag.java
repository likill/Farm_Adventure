package object;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_bag extends SuperObject{
     GamePanel gp;
    public OBJ_bag(GamePanel gp) {
        this.gp = gp;
        name = "bag";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/bag.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
        //collision = true;
    }

}
