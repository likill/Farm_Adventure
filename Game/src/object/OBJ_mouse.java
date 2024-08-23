package object;

import main.GamePanel;

import javax.imageio.ImageIO;

public class OBJ_mouse extends SuperObject{
    GamePanel gp;
    public OBJ_mouse(GamePanel gp){
        this.gp = gp;
        name = "mouse";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/mouse.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
        collision = true;

    }

}
