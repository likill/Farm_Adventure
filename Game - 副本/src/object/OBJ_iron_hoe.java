package object;

import main.GamePanel;

import javax.imageio.ImageIO;

public class OBJ_iron_hoe extends SuperObject{

    GamePanel gp;
    public OBJ_iron_hoe(GamePanel gp){
        this.gp = gp;
        name = "hoe";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/iron_hoe.png"));
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}