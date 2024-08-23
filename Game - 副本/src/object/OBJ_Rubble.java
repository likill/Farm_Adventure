package object;

import main.GamePanel;

import javax.imageio.ImageIO;
//碎石
public class OBJ_Rubble extends SuperObject{
    GamePanel gp;
    public OBJ_Rubble(GamePanel gp){
        this.gp = gp;
        name = "Rubble";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/brewing_stand_base.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
        collision = true;

    }
}
