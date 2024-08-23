package object;

import main.GamePanel;

import javax.imageio.ImageIO;

public class OBJ_potato_sprouts extends SuperObject{
    GamePanel gp;
    public OBJ_potato_sprouts(GamePanel gp){
        this.gp = gp;
        name = "potato";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/potato_sprouts.png"));
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
