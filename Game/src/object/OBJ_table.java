package object;

import main.GamePanel;

import javax.imageio.ImageIO;

public class OBJ_table extends SuperObject{
    GamePanel gp;
    public OBJ_table(GamePanel gp){
        this.gp = gp;
        name = "axe_table";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/axe_table.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
        collision = true;
    }

}
