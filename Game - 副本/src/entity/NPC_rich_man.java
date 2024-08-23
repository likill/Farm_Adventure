package entity;

import main.GamePanel;

public class NPC_rich_man extends Entity{
    public NPC_rich_man(GamePanel gp) {
        super(gp);
        direction = "down";

        getImage();
        setDialogue();
    }
    public void getImage(){
        up1 = setup("/npc/rich_man2");
        up2 = setup("/npc/rich_man2");
        down1 = setup("/npc/rich_man1");
        down2 = setup("/npc/rich_man2");
        left1 = setup("/npc/rich_man2");
        left2 = setup("/npc/rich_man2");
        right1 = setup("/npc/rich_man2");
        right2 = setup("/npc/rich_man2");
    }
    public void setDialogue(){
        dialogues[0] = "可恶，村里的粮食全被老鼠糟蹋了！";
        dialogues[1] = "需要花费大力气去整治呀！";
    }
    public void speak(){
        super.speak();
    }
}