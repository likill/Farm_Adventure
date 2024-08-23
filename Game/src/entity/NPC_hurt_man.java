package entity;

import main.GamePanel;

public class NPC_hurt_man extends Entity{
    public NPC_hurt_man(GamePanel gp) {
        super(gp);
        direction = "down";

        getImage();
        setDialogue();
    }
    public void getImage(){
        up1 = setup("/npc/hurt_man2");
        up2 = setup("/npc/hurt_man2");
        down1 = setup("/npc/hurt_man1");
        down2 = setup("/npc/hurt_man2");
        left1 = setup("/npc/hurt_man2");
        left2 = setup("/npc/hurt_man2");
        right1 = setup("/npc/hurt_man2");
        right2 = setup("/npc/hurt_man2");
    }
    public void setDialogue(){
        dialogues[0] = "小伙子，我腿今天下地的时候摔伤了，\n能帮我把地里的草除一下吗？";
        dialogues[1] = "我会付报酬的。谢谢啦！";
    }
    public void speak(){
        super.speak();
    }
}