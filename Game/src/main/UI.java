package main;

import object.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font maruMonica,purisaB,arial_40,lanaPixel,zpix;

    
    
    //定义图片变量
    BufferedImage heart_full, heart_half, heart_blank, coinImage,mouseImage;
    BufferedImage keyImage, pickaxeImage, axeImage,hoeImage,webImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public String currentDialogue = "";
    public int commandNum = 0;

    public UI(GamePanel gp){
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 20);
        try{
            //添加字体类型
            InputStream is = getClass().getResourceAsStream("/font/x12y16pxMaruMonica.ttf");
            maruMonica = Font.createFont(Font.TRUETYPE_FONT, is);
            is = getClass().getResourceAsStream("/font/PurisaBold.ttf");
            purisaB = Font.createFont(Font.TRUETYPE_FONT, is);
            is = getClass().getResourceAsStream("/font/LanaPixel.ttf");
            lanaPixel = Font.createFont(Font.TRUETYPE_FONT, is);
            is = getClass().getResourceAsStream("/font/zpix.ttf");
            zpix = Font.createFont(Font.TRUETYPE_FONT, is);

        }catch(FontFormatException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        } 
        //create hub object
        SuperObject obj = new OBJ_Heart(gp);
        heart_full = obj.image;
        heart_half = obj.image2;
        heart_blank = obj.image3;
        
        //在界面上放置物品，需要先定义物品keyImage
        OBJ_Key key = new OBJ_Key(gp);
        keyImage = key.image;
        OBJ_iron_pickaxe pickaxe = new OBJ_iron_pickaxe(gp);
        pickaxeImage = pickaxe.image;
        OBJ_iron_axe axe = new OBJ_iron_axe(gp);
        axeImage = axe.image;
        OBJ_iron_hoe hoe = new OBJ_iron_hoe(gp);
        hoeImage = hoe.image;
        OBJ_coin coin = new OBJ_coin(gp);
        coinImage = coin.image;
        OBJ_web web = new OBJ_web(gp);
        webImage = web.image;
        OBJ_mouse mouse = new OBJ_mouse(gp);
        mouseImage = mouse.image;

    }
    public void showMessage(String text){
        message = text;
        messageOn = true;
    }
    public void draw(Graphics2D g2){
        this.g2 = g2;

        //设置字体类型
        g2.setFont(zpix);
        // g2.setFont(purisaB);
        // g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setColor(Color.white);

        //title state
       if(gp.gameState == gp.titleState){
            drawTitleScreen();
       }
        //play state
        if(gp.gameState == gp.playState){
            //gp.player.draw(g2);
            drawPlayScreen();
        }
        //pause state
        if(gp.gameState == gp.pauseState){
            drawPlayScreen();
            drawPauseScreen();
        }
        //dialogue state
        if(gp.gameState == gp.dialogueState){
            
            drawPlayScreen();
            drawDialogueScreen();
        }

        //画出钥匙X数量
//        g2.setFont(arial_40);
//        g2.setColor(Color.white);
//        g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
//        g2.drawString("X"+ gp.player.hasKey, 74, 60);
//        //如果有破土工具就会显示稿子
//        if(gp.player.able_distroy == true) {
//            g2.drawImage(pickaxeImage, 0, gp.screenHeight - gp.tileSize, gp.tileSize, gp.tileSize, null);
//        }
//        if(gp.player.able_farm == true) {
//            g2.drawImage(hoeImage, gp.tileSize*2, gp.screenHeight - gp.tileSize , gp.tileSize, gp.tileSize, null);
//        }
//        if(gp.player.able_logging == true) {
//            g2.drawImage(axeImage, gp.tileSize, gp.screenHeight - gp.tileSize, gp.tileSize, gp.tileSize, null);
//        }
//
//
//
//        if(messageOn == true){
//
//            g2.setFont(g2.getFont().deriveFont(30F));
//            g2.drawString(message, gp.tileSize/2, gp.tileSize*5);
//
//            messageCounter++;
//
//            if(messageCounter > 120){
//                messageCounter = 0;
//                messageOn = false;
//            }
//        }
    }
    public void drawTitleScreen(){
        //背景颜色
        g2.setColor(new Color(255 ,255 ,224)); 
        g2.fillRect(0,0,gp.screenWidth,gp.screenHeight);
        
       
        //Title name
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 80F));
        String text = "Farm Adventure";
        int x = getXForCenteredText(text);
        int y = gp.tileSize*3;
        //shadow
        g2.setColor(Color.gray);
        g2.drawString(text, x+5, y+5);
        
        Color c1 = new Color(205, 155 ,29);
        g2.setColor(c1);
        g2.drawString(text, x, y);//title

        //图片
        x = gp.screenWidth/2 - (gp.tileSize*2)/2;
        y += gp.tileSize*2;
        g2.drawImage(gp.ui.hoeImage, x, y, gp.tileSize*2, gp.tileSize*2, null);

        //菜单
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 48F));
        text = "开始游戏";
        x = getXForCenteredText(text);
        y += gp.tileSize*3.5;
        g2.drawString(text, x, y);
        if(commandNum == 0){
            g2.drawString(">>", x - gp.tileSize, y);
        }

        //g2.setFont(g2.getFont().deriveFont(Font.BOLD, 48F));
        text = "退出";
        x = getXForCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if(commandNum == 1){
            g2.drawString(">>", x - gp.tileSize, y);
        }

        // g2.setFont(g2.getFont().deriveFont(Font.BOLD, 48F));
        // text = "QUIT";
        // x = getXForCenteredText(text);
        // y += gp.tileSize;
        // g2.drawString(text, x, y);
        // if(commandNum == 2){
        //     g2.drawString(">>", x - gp.tileSize, y);
        // }


    }
    public void drawPlayScreen(){


        //gp.player.life = 3;
        int x = gp.tileSize/2;
        int y = gp.tileSize/2;
        int i = 0;
        //画三颗空心
        while(i<gp.player.maxLife/2){
            g2.drawImage(heart_blank, x, y, null);
            i++;
            x += gp.tileSize;
        }

        x = gp.tileSize/2;
        y = gp.tileSize/2;
        i = 0;

        while(i<gp.player.life){
            g2.drawImage(heart_half, x, y, null);
            i++;
            if(i<gp.player.life){
                g2.drawImage(heart_full, x, y, null);
            }
            i++;
            x += gp.tileSize;
        }
        
        g2.setFont(arial_40);
        g2.setColor(Color.white);
       //画出钥匙X数量
       g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2+gp.tileSize, gp.tileSize, gp.tileSize, null);
       g2.drawString("" +gp.player.hasKey, 60, gp.tileSize/2+gp.tileSize+40);
       g2.drawImage(coinImage, gp.tileSize/2, gp.tileSize/2+gp.tileSize*2, gp.tileSize, gp.tileSize, null);
       g2.drawString("" +gp.player.hascoin, 60, gp.tileSize/2+gp.tileSize*2+40);
       if(gp.player.able_catch == true){
        g2.drawImage(mouseImage, gp.tileSize/2, gp.tileSize/2+gp.tileSize*3, gp.tileSize, gp.tileSize, null);
        g2.drawString("" +gp.player.hascatch, 60, gp.tileSize/2+gp.tileSize*3+40);
        }

       g2.setFont(lanaPixel);
       g2.setColor(Color.white);
       //如果有破土工具就会显示稿子
       if(gp.player.able_distroy == true) {
           g2.drawImage(pickaxeImage, 0, gp.screenHeight - gp.tileSize, gp.tileSize, gp.tileSize, null);
       }
       if(gp.player.able_farm == true) {
           g2.drawImage(hoeImage, gp.tileSize*2, gp.screenHeight - gp.tileSize , gp.tileSize, gp.tileSize, null);
       }
       if(gp.player.able_logging == true) {
           g2.drawImage(axeImage, gp.tileSize, gp.screenHeight - gp.tileSize, gp.tileSize, gp.tileSize, null);
       }
       if(gp.player.able_catch == true){
           g2.drawImage(webImage, gp.tileSize*3, gp.screenHeight - gp.tileSize, gp.tileSize, gp.tileSize, null);
       }
       
       if(messageOn == true){
    
           g2.setFont(g2.getFont().deriveFont(30F));
           g2.drawString(message, gp.tileSize/2, gp.tileSize*5);
    
           messageCounter++;
    
           if(messageCounter > 120){
               messageCounter = 0;
               messageOn = false;
           }
       }
    }
    public void drawPauseScreen(){
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80F));

        String text = "PAUSE";
        //System.out.println("p");

        int x = getXForCenteredText(text);
        int y = gp.screenHeight/2;

        g2.drawString(text, x, y);
    }
    public void drawDialogueScreen(){
        //window
        int x = gp.tileSize*2;
        int y = gp.tileSize/2;
        int width = gp.screenWidth - (gp.tileSize*4);
        int height = gp.tileSize*4;
        drawSubWindow(x, y, width, height);


        x += gp.tileSize;
        y += gp.tileSize;
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 32F));

        for(String line: currentDialogue.split("\n")){
            g2.drawString(line, x, y);
            y += 28;
        }
        
    }

    public void drawSubWindow(int x, int y, int width, int height){

        Color c = new Color(0,0,0,210);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        c = new Color(255,255,255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
    }
    public int getXForCenteredText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }
}

