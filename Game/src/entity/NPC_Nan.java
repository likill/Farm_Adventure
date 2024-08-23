package entity;

import main.GamePanel;

public class NPC_Nan extends Entity{
    public NPC_Nan(GamePanel gp) {
        super(gp);
        direction = "down";

        getNanImage();
        setDialogue();
    }
    public void getNanImage(){
        up1 = setup("/npc/NPC_talk");
        up2 = setup("/npc/NPC_talk");
        down1 = setup("/npc/NPC_idle");
        down2 = setup("/npc/NPC_talk");
        left1 = setup("/npc/NPC_talk");
        left2 = setup("/npc/NPC_talk");
        right1 = setup("/npc/NPC_talk");
        right2 = setup("/npc/NPC_talk");
    }
    public void setDialogue(){
        dialogues[0] = "你需要工具吗？亲！";
        dialogues[1] = "金币够了，就自己去拿吧！\n记得把钱放在桌上，亲！";
        dialogues[2] = "斧头3枚金币，在左边。亲！";
        dialogues[3] = "捕鼠网5枚金币，在右边。亲！";
        dialogues[4] = "付款后概不退款！！！！亲！";
        dialogues[5] = "村外森林里长着奇怪的植物\n我都不能顺利的去我的瓜蒌地看看了！";
        
    }
    public void speak(){
        super.speak();
    }
}
