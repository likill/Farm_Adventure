package object;

import main.GamePanel;

import javax.imageio.ImageIO;

public class OBJ_web_table extends SuperObject{
    GamePanel gp;
    public OBJ_web_table(GamePanel gp){
        this.gp = gp;
        name = "web_table";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/web_table.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
        collision = true;
    }

}
