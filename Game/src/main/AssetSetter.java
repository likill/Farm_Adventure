package main;

import entity.NPC_Nan;
import entity.NPC_OldMan;
import entity.NPC_hurt_man;
import entity.NPC_oldwoman;
import entity.NPC_rich_man;
import object.*;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setObject(){
        
        gp.obj[0] = new OBJ_iron_hoe(gp);
        gp.obj[0].worldX = 26 * gp.tileSize+ 50 * gp.tileSize;
        gp.obj[0].worldY = 33 * gp.tileSize;
        
        gp.obj[1] = new OBJ_Key(gp);
        gp.obj[1].worldX = 8 * gp.tileSize+ 50 * gp.tileSize;
        gp.obj[1].worldY = 6 * gp.tileSize;

        
        gp.obj[2] = new OBJ_iron_pickaxe(gp);
        gp.obj[2].worldX = 41 * gp.tileSize;
        gp.obj[2].worldY = 23 * gp.tileSize;

        gp.obj[3] = new OBJ_box(gp);
        gp.obj[3].worldX = 14 * gp.tileSize;
        gp.obj[3].worldY = 42 * gp.tileSize;

        gp.obj[4] = new OBJ_table(gp);
        gp.obj[4].worldX = 14 * gp.tileSize+ 50 * gp.tileSize;
        gp.obj[4].worldY = 13 * gp.tileSize;

        gp.obj[5] = new OBJ_Rubble(gp);
        gp.obj[5].worldX = 38 * gp.tileSize;
        gp.obj[5].worldY = 38 * gp.tileSize;

        gp.obj[6] = new OBJ_cactus(gp);
        gp.obj[6].worldX = 33 * gp.tileSize;
        gp.obj[6].worldY = 42 * gp.tileSize;

        gp.obj[7] = new OBJ_TreeWall(gp);//1
        gp.obj[7].worldX = 10 * gp.tileSize;
        gp.obj[7].worldY = 36 * gp.tileSize;

        gp.obj[8] = new OBJ_TreeWall(gp);//2
        gp.obj[8].worldX = 9 * gp.tileSize;
        gp.obj[8].worldY = 36 * gp.tileSize;

        gp.obj[9] = new OBJ_TreeWall(gp);//3
        gp.obj[9].worldX = 9 * gp.tileSize;
        gp.obj[9].worldY = 37 * gp.tileSize;

        gp.obj[10] = new OBJ_TreeWall(gp);//4
        gp.obj[10].worldX = 9 * gp.tileSize;
        gp.obj[10].worldY = 38 * gp.tileSize;

        gp.obj[11] = new OBJ_TreeWall(gp);//5
        gp.obj[11].worldX = 9 * gp.tileSize;
        gp.obj[11].worldY = 39 * gp.tileSize;

        gp.obj[12] = new OBJ_TreeWall(gp);//6
        gp.obj[12].worldX = 9 * gp.tileSize;
        gp.obj[12].worldY = 40 * gp.tileSize;

        gp.obj[13] = new OBJ_TreeWall(gp);//7
        gp.obj[13].worldX = 10 * gp.tileSize;
        gp.obj[13].worldY = 40 * gp.tileSize;

        gp.obj[14] = new OBJ_TreeWall(gp);//8
        gp.obj[14].worldX = 10 * gp.tileSize;
        gp.obj[14].worldY = 41 * gp.tileSize;

        gp.obj[15] = new OBJ_TreeWall(gp);//9
        gp.obj[15].worldX = 12 * gp.tileSize;
        gp.obj[15].worldY = 41 * gp.tileSize;

        gp.obj[16] = new OBJ_TreeWall(gp);//10
        gp.obj[16].worldX = 12 * gp.tileSize;
        gp.obj[16].worldY = 40 * gp.tileSize;

        gp.obj[17] = new OBJ_TreeWall(gp);//11
        gp.obj[17].worldX = 13 * gp.tileSize;
        gp.obj[17].worldY = 40 * gp.tileSize;

        gp.obj[18] = new OBJ_TreeWall(gp);//12
        gp.obj[18].worldX = 14 * gp.tileSize;
        gp.obj[18].worldY = 40 * gp.tileSize;

        gp.obj[19] = new OBJ_TreeWall(gp);//13
        gp.obj[19].worldX = 14 * gp.tileSize;
        gp.obj[19].worldY = 41 * gp.tileSize;

        gp.obj[20] = new OBJ_TreeWall(gp);//4
        gp.obj[20].worldX = 11 * gp.tileSize;
        gp.obj[20].worldY = 41 * gp.tileSize;

        gp.obj[21] = new OBJ_coin(gp);
        gp.obj[21].worldX = 41 * gp.tileSize;
        gp.obj[21].worldY = 41 * gp.tileSize;

        gp.obj[22] = new OBJ_coin(gp);
        gp.obj[22].worldX = 9 * gp.tileSize;
        gp.obj[22].worldY = 7 * gp.tileSize;
        

        

//////////////////////////////////////////////////////////////////////////////////////////////
            // gp.obj[23] = new OBJ_mouse(gp);//////////////////////////////////////////////////////////////////////////
            // gp.obj[23].worldX = 33 * gp.tileSize;
            // gp.obj[23].worldY = 27 * gp.tileSize;

            gp.obj[23] = new OBJ_mouse(gp);//////////////////////////////////////////////////////////////////////////
            gp.obj[23].worldX = 38 * gp.tileSize+ 50 * gp.tileSize;
            gp.obj[23].worldY = 7 * gp.tileSize;
            

            // if(gp.obj[24].isexist==true){}
            gp.obj[24] = new OBJ_TreeWall(gp);//1
            gp.obj[24].worldX = 26 * gp.tileSize+ 50 * gp.tileSize;
            gp.obj[24].worldY = 34 * gp.tileSize;
            // if(gp.obj[25].isexist==true){}
            gp.obj[25] = new OBJ_TreeWall(gp);//2
            gp.obj[25].worldX = 26 * gp.tileSize+ 50 * gp.tileSize;
            gp.obj[25].worldY = 35 * gp.tileSize;

            // if(gp.obj[26].isexist==true){}
            gp.obj[26] = new OBJ_TreeWall(gp);//3
            gp.obj[26].worldX = 26 * gp.tileSize+ 50 * gp.tileSize;
            gp.obj[26].worldY = 36 * gp.tileSize;

            // if(gp.obj[27].isexist==true){}
            gp.obj[27] = new OBJ_TreeWall(gp);//4
            gp.obj[27].worldX = 27 * gp.tileSize+ 50 * gp.tileSize;
            gp.obj[27].worldY = 37 * gp.tileSize;

            // if(gp.obj[28].isexist==true){}
            gp.obj[28] = new OBJ_TreeWall(gp);//5
            gp.obj[28].worldX = 28 * gp.tileSize+ 50 * gp.tileSize;
            gp.obj[28].worldY = 37 * gp.tileSize;

            // if(gp.obj[29].isexist==true){}
            gp.obj[29] = new OBJ_TreeWall(gp);//6
            gp.obj[29].worldX = 29 * gp.tileSize+ 50 * gp.tileSize;
            gp.obj[29].worldY = 37 * gp.tileSize;

            // if(gp.obj[30].isexist==true){}
            gp.obj[30] = new OBJ_TreeWall(gp);//7
            gp.obj[30].worldX = 30 * gp.tileSize+ 50 * gp.tileSize;
            gp.obj[30].worldY = 37 * gp.tileSize;

            // if(gp.obj[31].isexist==true){}
            gp.obj[31] = new OBJ_TreeWall(gp);//8
            gp.obj[31].worldX = 31 * gp.tileSize+ 50 * gp.tileSize;
            gp.obj[31].worldY = 37 * gp.tileSize;

            // if(gp.obj[32].isexist==true){}
            gp.obj[32] = new OBJ_TreeWall(gp);//9
            gp.obj[32].worldX = 32 * gp.tileSize+ 50 * gp.tileSize;
            gp.obj[32].worldY = 37 * gp.tileSize;

            // if(gp.obj[33].isexist==true){}
            gp.obj[33] = new OBJ_TreeWall(gp);//10
            gp.obj[33].worldX = 33 * gp.tileSize+ 50 * gp.tileSize;
            gp.obj[33].worldY = 37 * gp.tileSize;

            // if(gp.obj[34].isexist==true){}
            gp.obj[34] = new OBJ_TreeWall(gp);//10
            gp.obj[34].worldX = 34 * gp.tileSize+ 50 * gp.tileSize;
            gp.obj[34].worldY = 37 * gp.tileSize;

            //if(gp.obj[35].isexist==true){}
            gp.obj[35] = new OBJ_TreeWall(gp);//10
            gp.obj[35].worldX = 35 * gp.tileSize+ 50 * gp.tileSize;
            gp.obj[35].worldY = 37 * gp.tileSize;

            //if(gp.obj[36].isexist==true){}
            gp.obj[36] = new OBJ_TreeWall(gp);//10
            gp.obj[36].worldX = 36 * gp.tileSize+ 50 * gp.tileSize;
            gp.obj[36].worldY = 37 * gp.tileSize;

           // if(gp.obj[37].isexist==true){}
            gp.obj[37] = new OBJ_TreeWall(gp);//10
            gp.obj[37].worldX = 37 * gp.tileSize+ 50 * gp.tileSize;
            gp.obj[37].worldY = 37 * gp.tileSize;

           // if(gp.obj[38].isexist==true){}
            gp.obj[38] = new OBJ_TreeWall(gp);//10
            gp.obj[38].worldX = 37 * gp.tileSize+ 50 * gp.tileSize;
            gp.obj[38].worldY = 36 * gp.tileSize;

            //if(gp.obj[39].isexist==true){}
            gp.obj[39] = new OBJ_TreeWall(gp);//10
            gp.obj[39].worldX = 37 * gp.tileSize+ 50 * gp.tileSize;
            gp.obj[39].worldY = 35 * gp.tileSize;

            // if(gp.obj[40].isexist==true){}
            gp.obj[40] = new OBJ_TreeWall(gp);//10
            gp.obj[40].worldX = 26 * gp.tileSize+ 50 * gp.tileSize;
            gp.obj[40].worldY = 37 * gp.tileSize;

            // if(gp.obj[41].isexist==true){}/////////////////////////////////////////////////////////////////////////////////////
            gp.obj[41] = new OBJ_web_table(gp);//10
            gp.obj[41].worldX = 19 * gp.tileSize+ 50 * gp.tileSize;
            gp.obj[41].worldY = 13 * gp.tileSize;

            // if(gp.obj[42].isexist==true){}
            gp.obj[42] = new OBJ_potato_sprouts(gp);
            gp.obj[42].worldX = 26 * gp.tileSize+ 50 * gp.tileSize;
            gp.obj[42].worldY = 17 * gp.tileSize;

            
            gp.obj[43] = new OBJ_potato_sprouts(gp);
            gp.obj[43].worldX = 28 * gp.tileSize+ 50 * gp.tileSize;
            gp.obj[43].worldY = 16 * gp.tileSize;

            
            gp.obj[44] = new OBJ_potato_sprouts(gp);
            gp.obj[44].worldX = 23 * gp.tileSize+ 50 * gp.tileSize;
            gp.obj[44].worldY = 9 * gp.tileSize;

            gp.obj[45] = new OBJ_potato_sprouts(gp);
            gp.obj[45].worldX = 26 * gp.tileSize+ 50 * gp.tileSize;
            gp.obj[45].worldY = 10 * gp.tileSize;

            gp.obj[46] = new OBJ_bag(gp);
            gp.obj[46].worldX = 17 * gp.tileSize+ 50 * gp.tileSize;//+ 50 * gp.tileSize;
            gp.obj[46].worldY = 27 * gp.tileSize;

            gp.obj[47] = new OBJ_send(gp);
            gp.obj[47].worldX = 8 * gp.tileSize+ 50 * gp.tileSize;
            gp.obj[47].worldY = 41 * gp.tileSize;

            gp.obj[48] = new OBJ_mouse(gp);
            gp.obj[48].worldX = 33 * gp.tileSize+ 50 * gp.tileSize;
            gp.obj[48].worldY = 6 * gp.tileSize;

            gp.obj[49] = new OBJ_mouse(gp);
            gp.obj[49].worldX = 40 * gp.tileSize+ 50 * gp.tileSize;
            gp.obj[49].worldY = 22 * gp.tileSize;

            gp.obj[50] = new OBJ_mouse(gp);
            gp.obj[50].worldX = 15 * gp.tileSize+ 50 * gp.tileSize;
            gp.obj[50].worldY = 7 * gp.tileSize;

            gp.obj[51] = new OBJ_mouse(gp);
            gp.obj[51].worldX = 28 * gp.tileSize+ 50 * gp.tileSize;
            gp.obj[51].worldY = 28 * gp.tileSize;

 
    }
    
    public void setNPC(){
        
            gp.npc[0] = new NPC_OldMan(gp);
            //设置初始位置
            gp.npc[0].worldX = 30 * gp.tileSize;
            gp.npc[0].worldY = 29 * gp.tileSize;

            gp.npc[1] = new NPC_Nan(gp);
            gp.npc[1].worldX = 16 * gp.tileSize+50*gp.tileSize;
            gp.npc[1].worldY = 12 * gp.tileSize;

            gp.npc[2] = new NPC_oldwoman(gp);
            gp.npc[2].worldX = 17 * gp.tileSize+ 50 * gp.tileSize;
            gp.npc[2].worldY = 29 * gp.tileSize;

            gp.npc[3] = new NPC_hurt_man(gp);
            gp.npc[3].worldX = 38 * gp.tileSize+ 50 * gp.tileSize;
            gp.npc[3].worldY = 18 * gp.tileSize;

            gp.npc[4] = new NPC_rich_man(gp);
            gp.npc[4].worldX = 34 * gp.tileSize+ 50 * gp.tileSize;
            gp.npc[4].worldY = 12* gp.tileSize;



        
        
    }

    public void clearObjects() {
        
        for(int i= 0;i<gp.obj.length;i++)
        {
            gp.obj[i] = null;
        }
        for(int i=0;i<gp.npc.length;i++)
        {
            gp.npc[i] = null;
        }
    }
}
