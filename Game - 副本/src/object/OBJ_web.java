package object;

import main.GamePanel;
import javax.imageio.ImageIO;

public class OBJ_web extends SuperObject{
    GamePanel gp;
    public OBJ_web(GamePanel gp) {
        this.gp = gp;
        name = "web";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/web.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
        collision = true;
    }

}
