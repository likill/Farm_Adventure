package entity;

import main.GamePanel;

public class NPC_oldwoman extends Entity{
    public NPC_oldwoman(GamePanel gp) {
        super(gp);
        direction = "down";

        getImage();
        setDialogue();
    }
    public void getImage(){
        up1 = setup("/npc/old_woman2");
        up2 = setup("/npc/old_woman2");
        down1 = setup("/npc/old_woman1");
        down2 = setup("/npc/old_woman2");
        left1 = setup("/npc/old_woman2");
        left2 = setup("/npc/old_woman2");
        right1 = setup("/npc/old_woman2");
        right2 = setup("/npc/old_woman2");
    }
    public void setDialogue(){
        dialogues[0] = "小伙子，能帮奶奶送一下包裹吗？";
        dialogues[1] = "快递站就在门口的丛林里。\n我会给奖励的。谢谢了！";
    }
    public void speak(){
        super.speak();
    }
}