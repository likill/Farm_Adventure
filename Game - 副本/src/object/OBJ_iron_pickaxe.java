package object;

import main.GamePanel;

import javax.imageio.ImageIO;

public class OBJ_iron_pickaxe extends SuperObject{
    GamePanel gp;

    public OBJ_iron_pickaxe(GamePanel gp){
        this.gp = gp;
        name = "pickaxe";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/iron_pickaxe.png"));
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
