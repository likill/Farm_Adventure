package object;

import main.GamePanel;

import javax.imageio.ImageIO;

public class OBJ_box extends SuperObject{
    GamePanel gp;

    public OBJ_box(GamePanel gp){
        this.gp = gp;
        name = "box";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/box.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
        collision = true;

    }
}