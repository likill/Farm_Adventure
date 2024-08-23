package object;

import main.GamePanel;

import javax.imageio.ImageIO;

public class OBJ_iron_axe extends SuperObject{
    GamePanel gp;
    public OBJ_iron_axe(GamePanel gp){
        this.gp = gp;
        name = "axe";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/iron_axe.png"));
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
