package entity;

import main.GamePanel;

import java.util.Random;

public class NPC_OldMan extends Entity{
    public NPC_OldMan(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 1;

        getImage();
        setDialogue();
        
    }
    public void getImage(){
        up1 = setup("/npc/oldman_up_1");
        up2 = setup("/npc/oldman_up_2");
        down1 = setup("/npc/oldman_down_1");
        down2 = setup("/npc/oldman_down_2");
        left1 = setup("/npc/oldman_left_1");
        left2 = setup("/npc/oldman_left_2");
        right1 = setup("/npc/oldman_right_1");
        right2 = setup("/npc/oldman_right_2");
    }
    public void setDialogue(){
        dialogues[0] = "你好，我是这个村的村长！\n村子在右边，\n这里是村子外边的林子。\n村外处处有惊喜！\n要好好探索一下";
        dialogues[1] = "帮助村民，会增加满意度，就是心心！";
        dialogues[2] = "利用好每一枚金币！";
        dialogues[3] = "有了工具才能事半功倍！";
        dialogues[4] = "我们村正在防洪，碎石不够了，\n能帮我们在森林里开采一些吗？";
    }
    public void setAction(){
        //simple AI
        actionLockCounter++;
        if(actionLockCounter == 120){
            Random random = new Random();
            int i = random.nextInt(100)+1;//1--100
            if(i <= 25){
                direction = "up";
            }
            if(i > 25 && i <= 50){
                direction = "down";
            }
            if(i > 50 && i <= 75){
                direction = "left";
            }
            if(i > 75 && i <= 100){
                direction = "right";
            }

            actionLockCounter = 0;
        }
    }
    public void speak(){
        super.speak();
    }
}
