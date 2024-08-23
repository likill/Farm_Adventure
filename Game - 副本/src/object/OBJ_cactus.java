package object;

import main.GamePanel;

import javax.imageio.ImageIO;

public class OBJ_cactus extends SuperObject{
    GamePanel gp;
    public OBJ_cactus(GamePanel gp){
        this.gp = gp;
        name = "cactus";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/cactus.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
        collision = true;
    }

}
