package object;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_coin extends SuperObject{
    GamePanel gp;

    public OBJ_coin(GamePanel gp){
        this.gp = gp;
        name = "coin";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/coin.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        }catch (Exception e){
            e.printStackTrace();
        }


    }

}
