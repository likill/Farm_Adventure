package object;

import main.GamePanel;

import javax.imageio.ImageIO;

public class OBJ_TreeWall extends SuperObject{
    GamePanel gp;
    public OBJ_TreeWall(GamePanel gp){
        this.gp = gp;
        name = "treewall";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/tree_wall.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
        collision = true;
    }

}
