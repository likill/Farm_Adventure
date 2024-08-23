package tile;

import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];
    ArrayList<String> fileNames = new ArrayList<>();
    ArrayList<String> colliosionStatus = new ArrayList<>();

    public TileManager(GamePanel gp) {
        this.gp = gp;

        InputStream is = getClass().getResourceAsStream("/maps/out_valliger_data.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String line;

        try{
            while((line = br.readLine()) != null){
                fileNames.add(line);
                colliosionStatus.add(br.readLine());
            }   
            br.close(); 
        }catch(IOException e){
            e.printStackTrace();
        }
       
        tile = new Tile[fileNames.size()];//创建多少种砖片

        getTileImage();

        //get map witdthandhight
        is = getClass().getResourceAsStream("/maps/out_valliger.txt");
        br = new BufferedReader(new InputStreamReader(is));

        // try {
        //     String line2 = br.readLine();
        //     String maxTile[]=line2.split(" ");

        //     gp.maxWorldCol = maxTile.length;
        //     gp.maxWorldRow = maxTile.length;
        //     mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        // }catch(Exception e){
        //     e.printStackTrace();
        // }

            gp.maxWorldCol = 100;
            gp.maxWorldRow = 50;
            mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        loadMap("/maps/out_valliger1.txt");
        //loadMap("/maps/villige.txt",1);
        

        

        
        //loadMap( "/maps/world1.txt");
    }

    private void getTileImage() {
        for(int i =0;i<fileNames.size();i++){
            String filename;
            boolean collision;

            //get filename
            filename = fileNames.get(i);

            //get collision status
            if(colliosionStatus.get(i).equals("true")){collision = true;}
            else{collision = false;}
            setup(i,fileNames.get(i),Boolean.parseBoolean(colliosionStatus.get(i)));
        
        }
            // setup(0,"dirt",false);
            // setup(1,"stone",true);
            // setup(2,"water",true);
            // setup(3,"flower_grass",false);
            // setup(4,"tree1",true);
            // setup(5,"grass_low",false);
            // setup(6,"tree2",true);
    }
    public void setup(int index,String imageName,boolean collision){
        UtilityTool uTool = new UtilityTool();

        try {
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/" + imageName ));
            tile[index].image = uTool.scaleImage(tile[index].image,gp.tileSize,gp.tileSize);
            tile[index].collision = collision;
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void loadMap(String filePath) {
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col = 0;
            int row = 0;
            while (col < gp.maxWorldCol && row < gp.maxWorldRow) {//gp.maxWorldCol
                String line = br.readLine();
                while (col < gp.maxWorldCol) {
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.maxWorldCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

//    public void loadMap() {
//        try {
//            //读取地图
//            InputStream is = getClass().getResourceAsStream("/maps/map1.txt");
//            BufferedReader br = new BufferedReader(new InputStreamReader(is));
//
//            int col = 0;
//            int row = 0;
//            while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
//                String line = br.readLine();
//                while (col < gp.maxScreenCol) {
//                    String numbers[] = line.split(" ");
//
//                   int num = Integer.parseInt(numbers[col]);
//
//                   mapTileNum[col][row] = num;
//                   col++;
//                }
//                if(col == gp.maxScreenCol){
//                    col = 0;
//                    row++;
//                }
//            }
//            br.close();
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    public void draw(Graphics2D g2) {
//        int col = 0;
//        int row = 0;
//        int x = 0;
//        int y = 0;
//
//        while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
//            int tileNum = mapTileNum[col][row];
//
//            g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
//            col++;
//            x += gp.tileSize;
//            if (col == gp.maxScreenCol) {
//                col = 0;
//                x = 0;
//                row++;
//               y += gp.tileSize;
//            }
//        }
//
//
//    }


    public void draw(Graphics2D g2) {
        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if(worldX+ gp.tileSize>=gp.player.worldX-gp.player.screenX
                    &&worldX-gp.tileSize<=gp.player.worldX+gp.player.screenX
                    && worldY+gp.tileSize>=gp.player.worldY-gp.player.screenY
                    && worldY-gp.tileSize<=gp.player.worldY+gp.player.screenY){

                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            }

            worldCol++;

            if(worldCol == gp.maxWorldCol){
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
