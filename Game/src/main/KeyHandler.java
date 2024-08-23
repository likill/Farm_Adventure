package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed,nextPressed;

    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        // TITLE STATE
        if(gp.gameState == gp.titleState){

            if(code == KeyEvent.VK_W){
                //System.out.println("W");
                gp.ui.commandNum--;
                if(gp.ui.commandNum < 0){
                    gp.ui.commandNum = 1;
                }
            }
            if(code == KeyEvent.VK_S){
                //System.out.println("S");
                gp.ui.commandNum++;
                if(gp.ui.commandNum > 1){
                    gp.ui.commandNum = 0;
                }
                //System.out.println(gp.ui.commandNum);
            }
            if(code == KeyEvent.VK_ENTER){
                
                if(gp.ui.commandNum == 0){
                    gp.gameState = gp.playState;
                    //System.out.println("playbegin");
                    //System.out.println(gp.gameState);
                    //gp.playMusic(0);
                    //gp.tileM.loadMap("/maps/out_valliger.txt", 0);
                }
                if(gp.ui.commandNum == 1){
                    System.exit(0);
                }
                
            }
            
        }



        //PLAY STATE
        if (gp.gameState == gp.playState) {
            if(code == KeyEvent.VK_W){
    //            System.out.println("W");
                upPressed = true;
            }
            if(code == KeyEvent.VK_S){
    //            System.out.println("S");
                downPressed = true;
            }
            if(code == KeyEvent.VK_A){
    //            System.out.println("A");
                leftPressed = true;
            }
            if(code == KeyEvent.VK_D){
    //            System.out.println("D");
                rightPressed = true;
            }
            if(code == KeyEvent.VK_P){
                //System.out.println("p");
                gp.gameState = gp.pauseState;
                 
            }
            if(code == KeyEvent.VK_ENTER){
                enterPressed = true;
            }
            // if(code == KeyEvent.VK_R){
            //     switch (gp.currentMap) {
            //         case 0:
            //             gp.tileM.loadMap("/maps/villige.txt", 1);/////////////////////////////////////////////////////////////////////////////////
            //             gp.aSetter.setObject();
            //             gp.currentMap = 1;
            //             gp.player.setDefaultValues();
                        
            //             break;
                
            //         case 1:
            //             gp.tileM.loadMap("/maps/out_valliger.txt", 0);//////////////////////////////////////////////////////////////////////////////
            //             gp.aSetter.setObject();
            //             gp.currentMap = 0;
            //             gp.player.setDefaultValues();
            //             break;
            //     }



            // }

        }
        //PAUSE STATE
        else if(gp.gameState == gp.pauseState){
            if(code == KeyEvent.VK_P){
                gp.gameState = gp.playState;
            }
        }
        //DIALOGUE STATE
        else if(gp.gameState == gp.dialogueState) {
            if(code == KeyEvent.VK_ENTER){
                gp.gameState = gp.playState;
            }
           
        }
        

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_W){

            upPressed = false;
        }
        if(code == KeyEvent.VK_S){

            downPressed = false;
        }
        if(code == KeyEvent.VK_A){

            leftPressed = false;
        }
        if(code == KeyEvent.VK_D){

            rightPressed = false;
        }

    }
}
