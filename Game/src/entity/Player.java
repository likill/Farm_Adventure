package entity;

import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{

    KeyHandler keyH;

    public final int screenX;
    public final int screenY;
    public int hasKey = 0;
    public int hascoin = 0;///////////////////////////////////////////////////////////////
    public int hasover = 0;
    public int hascatch =5;
    int standCount = 0;
    boolean moving = false;
    int pixelCounter = 0;

    //技能
    public boolean able_distroy = false;
    public boolean able_farm = false;
    public boolean able_logging = false;
    public boolean able_catch =false;//////////////////////////////////////////////////////////////////////=================================
    public boolean able_bag = false;////////////////////////////////////////////////////




    public Player(GamePanel gp, KeyHandler keyH)
    {
        super(gp);
        this.keyH = keyH;

        screenX = gp.screenWidth / 2-(gp.tileSize/2);
        screenY = gp.screenHeight / 2-(gp.tileSize/2);

        solidArea = new Rectangle();//人物图片是48x48
        solidArea.x = 1;
        solidArea.y = 1;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 46;
        solidArea.height= 46;

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        // worldX = gp.tileSize*37;
        // worldY = gp.tileSize*27;
        
            worldX = gp.tileSize*37;
            worldY = gp.tileSize*27;
        
        
        speed = 4;
        direction = "down";

        // PLAYER STATUS
        maxLife = 6;
        life = 0;
    }
    public void getPlayerImage(){

        up1 = setup("/player/A_up1_4");
        up2 = setup("/player/A_up2_3");
        down1 = setup("/player/A_down1_1");
        down2 = setup("/player/A_down2_1");
        left1 = setup("/player/A_left1_2");
        left2 = setup("/player/A_left2_14");
        right1 = setup("/player/A_right1_1");
        right2 = setup("/player/A_right2_1");

    }

    public void update(){
        if(moving == false) {
            if (keyH.upPressed == true || keyH.downPressed == true
                    || keyH.leftPressed == true || keyH.rightPressed == true) {
                if (keyH.upPressed == true) {
                    direction = "up";

                } else if (keyH.downPressed == true) {
                    direction = "down";

                } else if (keyH.leftPressed == true) {
                    direction = "left";

                } else if (keyH.rightPressed == true) {
                    direction = "right";

                }
                moving = true;
                //check collision
                collisionOn = false;
                gp.cChecker.checkTile(this);

                //check object collision
                int objIndex = gp.cChecker.checkObject(this, true);
                pickUpObject(objIndex);

                //check npc collision
                int npcIndex = gp.cChecker.checkEntity(this, gp.npc);//==========================================================
                interactNPC(npcIndex);
            }
            else {
                standCount++;

                if (standCount == 20) {
                    spriteNum = 1;
                    standCount = 0;
                }
            }
        }
        if (moving == true){
            //if collision is false, player can move
            if(collisionOn == false){
                switch (direction){
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }
                
            }

            spriteCounter++;
            if(spriteCounter > 12){
                if(spriteNum == 1){
                    spriteNum = 2;
                }
                else if(spriteNum == 2){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
            pixelCounter += speed;
                if(pixelCounter == 48){
                    moving = false;
                    pixelCounter = 0;
                }
           
        }
    }
    public void pickUpObject(int i){
        if(i != 999){
        //gp.player.life是村民满意度，满心为六就结束游戏
           String objectName = gp.obj[i].name;
           switch (objectName){
               case "Key":
                   hasKey++;
                   gp.obj[i] = null;
                   //gp.obj[i].isexist = false;
                   gp.ui.showMessage("钥匙!");
                   break;
                case "coin":
                   hascoin++;
                   gp.obj[i] = null;
                   //gp.obj[i].isexist = false;
                   gp.ui.showMessage("获得金币!");
                   break;
               case "box":
                   if(hasKey > 0){
                       gp.obj[i] = null;
                       //gp.obj[i].isexist = false;
                       gp.ui.showMessage("获得四枚金币");
                       //箱子功能待定
                       hascoin+=4;

                       hasKey--;
                   }
                   else{
                       gp.ui.showMessage("需要钥匙!");
                   }
                   break;
                case "axe_table"://===============================================================
                   if(hascoin >= 3){
                    able_logging = true;
                    gp.ui.showMessage("购得斧头!");
                    //gp.player.life ++;
                    hascoin-=3;
                   }
                   else{
                    gp.ui.showMessage("斧头：3枚金币!");
                   }
                   break;
                case "web_table":
                if(hascoin >= 5){
                    able_catch = true;
                    gp.ui.showMessage("购得捕鼠网!");
                    gp.player.life ++;
                    hascoin-=5;
                   }
                   else{
                    gp.ui.showMessage("捕鼠网：5枚金币!");
                   }
                   break;
                case "mouse":
                if(able_catch){
                    gp.obj[i] = null;
                    gp.ui.showMessage("鼠被抓住!");////////////////////////////////////////////////////////////////////////
                    hascatch--;
                    if(hascatch==0){
                        able_catch = false;
                        gp.player.life ++;
                    }
                    
                }
                else{
                    gp.ui.showMessage("你需要专业工具来捕鼠!");
                }
                break;
                case "bag":
                    gp.obj[i] = null;
                    gp.ui.showMessage("获得包裹!");
                    able_bag = true;
                    break;
                case "send":
                    if(able_bag){
                        gp.ui.showMessage("包裹已寄送成功!报酬已获得！");
                        able_bag = false;
                        gp.player.life ++;
                        hascoin++;
                    }
                    break;
               //稿子 碎石
               case "pickaxe":
                   gp.obj[i] = null;
                   //gp.obj[i].isexist = false;
                   able_distroy = true;
                   gp.ui.showMessage("铁镐!");
                   
                   break;
               case "Rubble":
                   if(able_distroy) {
                       gp.obj[i] = null;
                       //gp.obj[i].isexist = false;
                       gp.player.life ++; 
                       gp.ui.showMessage("获得碎石!");
                   }
                   break;

               //农作物//锄头
               case "hoe":
                   gp.obj[i] = null;
                   //gp.obj[i].isexist = false;
                   able_farm = true;
                   gp.ui.showMessage("锄头!");
                   break;
               case "potato":
                   if(able_farm) {
                       gp.obj[i] = null;
                       //gp.obj[i].isexist = false;
                       hasover++;
                       if(hasover == 4){
                           gp.ui.showMessage("杂草清理完了");
                           gp.player.life ++; 
                           hascoin++;
                       }
                   }
                   break;

               //砍伐//斧子
               case "axe":
                   gp.obj[i] = null;
                   //gp.obj[i].isexist = false;
                   able_logging = true;
                   gp.ui.showMessage("斧头!");
                   break;
               case "cactus":
                   if(able_logging) {
                       gp.obj[i] = null;
                       //gp.obj[i].isexist = false;
                       gp.player.life ++; //砍树增加村民满意度
                       gp.ui.showMessage("路通了!");
                   }
                   break;

                case "treewall":
                    if(able_logging) {
                        gp.obj[i] = null;
                        //gp.obj[i].isexist = false;
                        gp.ui.showMessage("发现新大陆!");
                    }
                    break;


           }
         }
    }
    public void interactNPC(int i){//===================================================================================
        if(i != 999){
            
            if(gp.keyH.enterPressed == true){
                gp.gameState = gp.dialogueState;
                gp.npc[i].speak();
                
            }
            
        }
        gp.keyH.enterPressed = false; 
    }
    public void draw(Graphics2D g2){
//        g2.setColor(Color.white);
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize);
        BufferedImage image = null;

        switch (direction){
            case "up":
                if(spriteNum == 1){
                    image = up1;
                }
                if(spriteNum == 2){
                    image = up2;
                }

                break;
            case "down":
                if(spriteNum == 1){
                    image = down1;
                }
                if(spriteNum == 2){
                    image = down2;
                }
                break;
            case "left":
                if(spriteNum == 1){
                    image = left1;
                }
                if(spriteNum == 2){
                    image = left2;
                }

                break;
            case "right":
                if(spriteNum == 1){
                    image = right1;
                }
                if(spriteNum == 2){
                    image = right2;
                }

                break;
        }
        g2.drawImage(image, screenX, screenY,  null);

        //显示碰撞框
//        g2.setColor(Color.red);
//        g2.drawRect(screenX+solidArea.x, screenY+solidArea.y, solidArea.width, solidArea.height);
    }
}
